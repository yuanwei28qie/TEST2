package com.microsilver.mrcard.scheduledtask.job;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.HttpClientUtils;
import com.microsilver.mrcard.mq.ExtraContent;
import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommend;
import com.microsilver.mrcard.scheduledtask.service.ImsCrowdsourcingOrderService;
import com.microsilver.mrcard.scheduledtask.service.ImsEweiShopMemberIdentityAdditionalService;
import com.microsilver.mrcard.scheduledtask.service.MQHandlerService;
import com.microsilver.mrcard.scheduledtask.service.PanterOrderService;
import com.microsilver.mrcard.scheduledtask.service.ShopOrderJobService;
import com.microsilver.mrcard.scheduledtask.utils.MQUtil;
import com.rabbitmq.client.Channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Name com.microsilver.mrcard.scheduledtask.job.OrderHandler
 * @Description 订单业务异步处理
 * @Author Jade
 * @Version 2017/9/19
 * @Copyright Micro Silver
 */
@Component
public class OrderHandler implements ChannelAwareMessageListener {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ImsEweiShopMemberIdentityAdditionalService imsEweiShopMemberIdentityAdditionalService;
	// 统一处理消息
	@Autowired
	private MQHandlerService handlerService;
	@Autowired
	private ImsCrowdsourcingOrderService imsCrowdsourcingOrderService;
	@Autowired
	private ShopOrderJobService shopOrderJobService;
	@Autowired
	private PanterOrderService panterOrderService;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		OrderMQ order = MQUtil.fromMessage(message, OrderMQ.class);

		logger.info("收到订单通知信息：" + JSON.toJSONString(order));

		if (order != null) {
			switch (order.getType()) {
			case 1:
				// 小飞侠订单通知
				sendNotificationToKnight(order);
				break;
			case 2:
				// 超级订订单立即结算，并提现到商户
				autoSettlementAndWithDrawByMerch(order);
				break;
			case 3:
				// 合伙人订单订单结算
				panterSettlement(order);
				break;
			default:
				logger.info("收到未定义的订单类型：{}", order.getType());
				break;
			}
		}

	}

	/**
	 * 合伙人订单结算
	 * 
	 * @param order
	 */
	private void panterSettlement(OrderMQ order) {
		try {
			ImsUserRecommend userRecommed = panterOrderService.selectUserRecommendByOrder(order.getOrderId());
			if (userRecommed == null) {
				return ;
			}
			panterOrderService.updateUserRecommend(userRecommed.getMemberId(), (byte) 2);
			if (userRecommed.getLevel1ParentId() > 0 || userRecommed.getLevel2ParentId() > 0) {
				// 存在推荐人的情况下对订单，进行结算
				try {
					if (userRecommed.getVipType() != 10) {
						if (panterOrderService.PreSettlementByRecommend(Long.valueOf(order.getOrderId()),
								userRecommed)) {
							logger.info("合伙人订单：{},预结算成功", order.getOrderId());
						} else {
							return;
						}
					}
					if (panterOrderService.SettlementByRecommend(order.getOrderId())) {
						// logger.info("订单：{},结算成功",order.getOrderId());
						logger.info("合伙人订单:{},发现1级推荐人{},2级推荐人{},结算成功", order.getOrderId(),
								userRecommed.getLevel1ParentId(), userRecommed.getLevel2ParentId());
					} else {
						panterOrderService.updateUserRecommend(userRecommed.getMemberId(), (byte) -1);
						logger.error("合伙人订单:{},结算失败", order);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					panterOrderService.updateUserRecommend(userRecommed.getMemberId(), (byte) -1);
					logger.error("合伙人订单:{},结算失败,{}", order.getOrderId(), ex.getMessage());
				}
			} else {
				logger.info("合伙人订单:{},没有推荐人,不分润,只修改状态", order.getOrderId());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 超级订订单立即结算，并提现到商户 1，ims_ewei_shop_cash 生成提现单(0 未审核 1 审核通过 2 审核不通过 3 支付完成 4
	 * 系统繁忙 定时器执行 5 用户帐号错误 后台改支付宝帐号状态4 6 余额不足 发短信提醒 7 其他错误 备注查看)
	 *
	 * 2,财务系统生成提现扣款单 3，自动审核提现单，调用PHP打款接口，异步处理打款
	 */
	private void autoSettlementAndWithDrawByMerch(OrderMQ order) {
		try {
			ImsEweiShopOrder dbOrder = shopOrderJobService.getImsEweiShopOrderById((long) order.getOrderId());
			if (dbOrder == null || dbOrder.getIssettlement() != 0) {
				logger.error("autoSettlement 订单数据不正常 : " + JSON.toJSONString(dbOrder));
				return;
			}
			// 1,结算
			boolean isCash = false;
			if (shopOrderJobService.preSettlementSync(dbOrder)) {
				isCash = shopOrderJobService.settlement(dbOrder.getId(), dbOrder.getOrdersn());
			}
			// 2生成提现单
			Long payId = null;
			if (isCash) {
				payId = shopOrderJobService.widthDrawByHotel(dbOrder);
			}
			if (payId > 0) {
				try {
					String url = SystemProperties.HTTP_PHP_ALIPAYURL + payId;
					String result = HttpClientUtils.doGet(url);
					logger.info("php pay result :" + result);
				} catch (Exception ex) {
					logger.error(ex.getMessage(), ex);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("结算出现错误：" + ex.getMessage());
		}
	}

	/**
	 * 通知小飞侠 根据订单所在地址，获取能为当前订单服务的骑士
	 * 
	 * @param order
	 */
	public void sendNotificationToKnight(OrderMQ order) {
		logger.info("订单通知骑士:" + JSON.toJSONString(order));
		// 验证订单状态
		ImsCrowdsourcingOrder dbOrder = imsCrowdsourcingOrderService.selectByPrimaryKey((long) order.getOrderId());
		if (dbOrder == null || dbOrder.getStatus() != 1) {
			logger.error("订单异常，不发抢单通知：" + JSON.toJSONString(order));
			return;
		}
		// 根据坐标及距离查询满足条件的骑士
		// 根据骑士，查询骑士的推送id
		List<OrderMQ> knight = imsEweiShopMemberIdentityAdditionalService.selectByConditionExample(order);
		if (null == knight || knight.isEmpty()) {
			logger.error("未找到符合条件的骑士 : " + JSON.toJSONString(order));
			return;
		}
		logger.info("查询到满足条件的骑士：" + JSON.toJSONString(knight));
		// 根据推送id发送抢单通知
		knight.forEach((kk) -> {
			PushMsg msg = new PushMsg();
			msg.setAppType(order.getAppName());
			msg.setPushType(0);
			msg.setRegistration(kk.getRegistration());
			msg.setDevice(kk.getDevice().byteValue());

			ExtraContent content = new ExtraContent();
			content.setMsgId(order.getOrderId() + "");
			content.setMsgType(201);// 去向，待抢订单页面
			content.setStatus(1);// 订单状态，标识订单动作
			msg.setContent(content);
			msg.setTitle("小飞侠，你有新的任务来了，去拯救世界吧！");
			logger.debug("通知小飞侠内容:" + JSON.toJSONString(msg));
			handlerService.pushMsg(msg);
		});
	}
}
