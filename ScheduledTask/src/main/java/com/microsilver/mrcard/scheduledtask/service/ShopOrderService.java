package com.microsilver.mrcard.scheduledtask.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.common.SystemConfig;
import com.microsilver.mrcard.scheduledtask.constant.OrderStatus;
import com.microsilver.mrcard.scheduledtask.constant.OrderType;
import com.microsilver.mrcard.scheduledtask.dao.IMemberDao;
import com.microsilver.mrcard.scheduledtask.dao.IShopOrderGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopActivityGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMemberIdentityMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMerchUserMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopOrderMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsUserPanterMapper;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoodsExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMember;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderExample.Criteria;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanter;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanterExample;
import com.microsilver.mrcard.scheduledtask.utils.DateUtil;

/**
 * 订单业务处理.
 */
//@Service
public class ShopOrderService extends BaseService {

/*
	@Autowired
	private ImsEweiShopOrderMapper imsEweiShopOrderMapper;

	@Autowired
	private IShopOrderGoodsMapper iShopOrderGoodsMapper;

	@Autowired
	private ImsEweiShopGoodsMapper imsEweiShopGoodsMapper;

	// 活动商品
	@Autowired
	private ImsEweiShopActivityGoodsMapper imsEweiShopActivityGoodsMapper;

	// 分成结算
	@Autowired
	private IFinanceRemoteService financeRemoteService;

	// 会员身份
	@Autowired
	private ImsEweiShopMemberIdentityMapper imsEweiShopMemberIdentityMapper;

	// 用户表
	@Autowired
	private IMemberDao memberDao;

	@Autowired
	private ImsUserPanterMapper imsUserPanterMapper;

	@Autowired
	private ImsEweiShopMerchUserMapper imsEweiShopMerchUserMapper;

	*/
/**
	 * 订单3分钟内未支付则失效
	 *//*

	@Transactional
	public void orderExpireDate() {
		try {
			// 1、查询未支付订单(创建时间大于等于3分钟的)
			Date now = new Date();
			int expireMinutes = 3;
			Date expireTime = DateUtil.addMinutes(now, -expireMinutes);

			ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo(OrderStatus.WAIT_PAY).andOrderTypeEqualTo(OrderType.SUPER_BOOK);
			criteria.andCreatetimeLessThan(DateUtil.dateToSecond(expireTime));
			List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectHotelByStatu(example);
			if (orderList.isEmpty()) {
				return;
			}

			this.logger.info(String.format("当前查询到已过期未支付订单%s条", orderList.size()));

			// 2、计算创单时间和当前时间差值，大于等于3分钟，则认为订单失效
			String createTime = "";
			StringBuilder logInfo = new StringBuilder();
			for (ImsEweiShopOrder order : orderList) {
				logInfo.append(String.format("当前时间%s，", DateUtil.dateToString(now)));
				createTime = DateUtil.dateToString(DateUtil.secondToDate(order.getCreatetime()));
				logInfo.append(String.format("订单%s创建时间%s，在%s分钟内未支付已失效，更新订单状态为交易关闭，", order.getId(), createTime, expireMinutes));

				// 3、更新订单状态为交易关闭
				ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
				updateParam.setStatus(OrderStatus.DEAL_CANCEL);
				updateParam.setId(order.getId());
				this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);

				// 4、还原商品库存
				List<ImsEweiShopOrderGoods> shopOrderList = this.iShopOrderGoodsMapper.selectOrderGoodsByOrderId(order.getId());
				if (shopOrderList.size() == 0) {
					logInfo.append("不存在商品库存映射信息，不处理。");
					this.logger.info(logInfo.toString());
					logInfo.delete(0, logInfo.length());
					continue;
				}

				for (ImsEweiShopOrderGoods shopOrder : shopOrderList) {
					// 判断活动是否还有效
					ImsEweiShopActivityGoodsExample activityGoodsExample = new ImsEweiShopActivityGoodsExample();
					activityGoodsExample.createCriteria().andGoodsIdEqualTo((long) shopOrder.getGoodsid().intValue());
					List<ImsEweiShopActivityGoods> shopActivityList = this.imsEweiShopActivityGoodsMapper.selectByExample(activityGoodsExample);
					if (shopActivityList.size() != 1) {
						logInfo.append(String.format("商品%s对应ims_ewei_shop_activity_goods表信息有问题，不处理库存", shopOrder.getGoodsid()));
						continue;
					}
					ImsEweiShopActivityGoods goodsInfo = shopActivityList.get(0);
					int nowSecond = DateUtil.dateToSecond(now).intValue();
					if (nowSecond > goodsInfo.getBeginTime() && nowSecond < goodsInfo.getEndTime()) {
						// 还原库存
						ImsEweiShopGoods shop = this.imsEweiShopGoodsMapper.selectByPrimaryKey(Long.parseLong(shopOrder.getGoodsid().toString()));
						ImsEweiShopGoods updateShop = new ImsEweiShopGoods();
						updateShop.setTotal(shop.getTotal().intValue() + shopOrder.getTotal().intValue());
						updateShop.setId(shop.getId());
						this.imsEweiShopGoodsMapper.updateByPrimaryKeySelective(updateShop);
						logInfo.append(String.format("商品%s库存数量增加%s，还原后库存%s，", shopOrder.getGoodsid(), shopOrder.getTotal(), updateShop.getTotal()));
					} else {
						logInfo.append(String.format("商品%s此时已过活动时间，不处理库存", shopOrder.getGoodsid()));
					}
				}

				logInfo.replace(logInfo.length() - 1, logInfo.length(), "。");
				this.logger.info(logInfo.toString());
				logInfo.delete(0, logInfo.length());
			}
		} catch (RuntimeException ex) {
			this.logger.error(ex.getMessage(), ex);
			throw ex;
		}
	}

	*/
/**
	 * 超级订“已完成”状态的订单需要结算
	 * 
	 * 3天————(酒店)的订单
	 *//*

	public void hotelOrderSettlement() {
		try {
			Date now = new Date();
			int settleDays = 3;
			Date settleTime = DateUtil.addDays(now, -settleDays);

			// 1、查询已完成（状态为3和6）超级订订单，带上完成时间查询
			ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
			example.createCriteria().andOrderTypeEqualTo(OrderType.SUPER_BOOK).andIssettlementEqualTo(0).andStatusOr(OrderStatus.ALREADY_RECEIVE_GOODS, OrderStatus.ALREADY_FINISH)
					.andFinishtimeLessThan(DateUtil.dateToSecond(settleTime));
			List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectByExample(example);
			if (orderList.isEmpty()) {
				return;
			}

			this.logger.info(String.format("当前查询到要结算已完成超级订订单%s条", orderList.size()));

			// 2、处理订单
			StringBuilder logInfo = new StringBuilder();
			for (ImsEweiShopOrder order : orderList) {
				String finishTime = DateUtil.dateToString(DateUtil.secondToDate(order.getFinishtime()));
				logInfo.append(String.format("当前时间%s，", DateUtil.dateToString(now)));
				logInfo.append(String.format("超级订订单%s完成时间%s，已完成%s天，", order.getId(), finishTime, settleDays));

				// 3、开始结算，调用结算服务
				// 查找会员身份
				ImsEweiShopMemberIdentityExample identityExample = new ImsEweiShopMemberIdentityExample();
				identityExample.createCriteria().andStatusEqualTo((byte) 1).andIdentityEqualTo((byte) 21).andMerchidEqualTo((long) order.getMerchid());
				List<ImsEweiShopMemberIdentity> identityList = this.imsEweiShopMemberIdentityMapper.selectByExample(identityExample);
				if (identityList.size() != 1) {
					logInfo.append(String.format("商户%s的Identity身份不正常，请手工结算，订单号%s", order.getMerchid(), order.getId()));
					this.logger.error(logInfo);
					logInfo.delete(0, logInfo.length());
					continue;
				}

				ImsEweiShopMemberIdentity memberIdentity = identityList.get(0);
				Map<String, Object> map = this.getHotelBenefitIdentityList(order, memberIdentity);
				map.put("order", order);
				map.put("memberIdentity", memberIdentity);
				boolean result = false;
				try {
					// 构造结算参数
					logInfo.append("开始结算，");
					CommissionDto commission = this.constructSettleParam(map);
					this.logger.info(String.format("超级订订单%s结算参数:%s", order.getId(), JSON.toJSONString(commission)));
					result = this.financeRemoteService.TaskCommisstion(commission);
				} catch (Exception ex) {
					String msg = String.format("订单%s结算失败", order.getId());
					logInfo.append(msg);
					this.logger.error(msg, ex);
				}

				if (result) {
					logInfo.append("结算成功，");
					// 4、结算成功，更新状态为已结算
					ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
					updateParam.setIssettlement((byte) 1);
					updateParam.setId(order.getId());
					this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);
					logInfo.append("更新订单状态为已结算成功");
				}else{
					logInfo.append("结算失败，");
					// 5、结算失败，更新状态为 -1
					ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
					updateParam.setIssettlement((byte) -1);
					updateParam.setId(order.getId());
					this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);
					logInfo.append("更新订单状态为结算失败");
				}
				this.logger.info(logInfo.toString());
				logInfo.delete(0, logInfo.length());
			}
		} catch (RuntimeException ex) {
			this.logger.error(ex.getMessage(), ex);
		}
	}

	*/
/**
	 * 卡先生和面对面支付“已完成”状态的订单需要结算
	 * 
	 * 7天————(会员)的订单
	 *//*

	public void cardOrderSettlement() {
		try {
			Date now = new Date();
			int settleDays = 7;
			Date settleTime = DateUtil.addDays(now, -settleDays);

			// 1、查询已完成（状态为3和6）卡先生订单，带上完成时间查询
			ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
			example.createCriteria().andOrderTypeOr(OrderType.CARD,OrderType.FACE_PAY).andIssettlementEqualTo(0).andStatusOr(OrderStatus.ALREADY_RECEIVE_GOODS, OrderStatus.ALREADY_FINISH)
					.andFinishtimeLessThan(DateUtil.dateToSecond(settleTime)).andFinishtimeNotEqualTo(0);
			List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectByExample(example);
			if (orderList.isEmpty()) {
				return;
			}

			this.logger.info(String.format("当前查询到要结算已完成卡先生订单%s条", orderList.size()));

			// 2、处理订单
			StringBuilder logInfo = new StringBuilder();
			for (ImsEweiShopOrder order : orderList) {
				String finishTime = DateUtil.dateToString(DateUtil.secondToDate(order.getFinishtime()));
				logInfo.append(String.format("当前时间%s，", DateUtil.dateToString(now)));
				logInfo.append(String.format("卡先生订单%s完成时间%s，已完成%s天，", order.getId(), finishTime, settleDays));

				// 3、开始结算，调用结算服务
				// 查找商户身份
				ImsEweiShopMemberIdentityExample identityExample = new ImsEweiShopMemberIdentityExample();
				identityExample.createCriteria().andStatusEqualTo((byte) 1).andIdentityEqualTo((byte) 1).andMerchidEqualTo((long) order.getMerchid());
				List<ImsEweiShopMemberIdentity> identityList = this.imsEweiShopMemberIdentityMapper.selectByExample(identityExample);
				if (identityList.size() != 1) {
					logInfo.append(String.format("商户%s的Identity身份不正常，请手工结算，订单号%s", order.getMerchid(), order.getId()));
					this.logger.error(logInfo);
					logInfo.delete(0, logInfo.length());
					continue;
				}

				ImsEweiShopMemberIdentity memberIdentity = identityList.get(0);
				Map<String, Object> map = this.getCardBenefitIdentityList(order, memberIdentity);
				// 卡先生如果没有被抽成比例，那么不结算
				if (!map.containsKey("payrate")) {
					logInfo.append(String.format("商户%s的被抽成比例payrate为空，请手工结算，订单号%s", order.getMerchid(), order.getId()));
					this.logger.error(logInfo);
					logInfo.delete(0, logInfo.length());
					continue;
				}

				map.put("order", order);
				map.put("memberIdentity", memberIdentity);
				boolean result = false;
				try {
					// 构造结算参数
					logInfo.append("开始结算，");
					CommissionDto commission = this.constructSettleParam(map);
					this.logger.info(String.format("卡先生订单%s结算参数:%s", order.getId(), JSON.toJSONString(commission)));
					result = this.financeRemoteService.TaskCommisstion(commission);
				} catch (Exception ex) {
					String msg = String.format("订单%s结算失败", order.getId());
					logInfo.append(msg);
					this.logger.error(msg, ex);
				}

				if (result) {
					logInfo.append("结算成功，");
					// 4、结算成功，更新状态为已结算
					ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
					updateParam.setIssettlement((byte) 1);
					updateParam.setId(order.getId());
					this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);
					logInfo.append("更新订单状态为已结算成功");
				}else{
					logInfo.append("结算失败，");
					// 5、结算失败，更新状态为 -1
					ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
					updateParam.setIssettlement((byte) -1);
					updateParam.setId(order.getId());
					this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);
					logInfo.append("更新订单状态为结算失败");
				}

				this.logger.info(logInfo.toString());
				logInfo.delete(0, logInfo.length());
			}
		} catch (RuntimeException ex) {
			this.logger.error(ex.getMessage(), ex);
		}
	}

	*/
/**
	 * 获取卡先生当前商户的分润成员
	 * 
	 * @param order
	 * @param memberIdentity
	 * @return
	 *//*

	private Map<String, Object> getCardBenefitIdentityList(ImsEweiShopOrder order, ImsEweiShopMemberIdentity memberIdentity) {
		// (卡先生) 1:商户,2:代理商(全国) ,3:代理商(省级),4:代理商(市级),5代理商(县级),6 勇士，7合伙人(VIP)，8骑士
		List<ImsEweiShopMemberIdentity> identityList = new LinkedList<>();

		// 全国 省级 市级 县级
		// 四种身份的，可以直接在ims_ewei_shop_member_identity表中查找到，通过parent_id查找上级
		int count = 0, maxCount = 20;
		long parentId = memberIdentity.getParentId();
		ImsEweiShopMemberIdentity identity = null;
		while (count++ < maxCount) {
			identity = this.imsEweiShopMemberIdentityMapper.selectByPrimaryKey(parentId);
			if (identity == null) {
				break;
			}

			identityList.add(identity);
			parentId = identity.getParentId();
			if (identity.getIdentity().intValue() == 2) {
				break;
			}
		}

		// 卡先生的勇士、骑士、vip要单独处理
		// vip
		ImsEweiShopMember user = this.memberDao.selectByOpenId(order.getOpenid());
		if (user.getReferee() != null) {
			// 查询推荐用户
			ImsUserPanterExample userPanterExample = new ImsUserPanterExample();
			userPanterExample.createCriteria().andUserIdEqualTo(user.getReferee());
			List<ImsUserPanter> userPanterList = this.imsUserPanterMapper.selectByExample(userPanterExample);
			if (!userPanterList.isEmpty()) {
				ImsUserPanter userPanter = userPanterList.get(0);
				if (userPanter.getIsVip() == 1) {
					// 如果是vip，则构造身份
					identity = new ImsEweiShopMemberIdentity();
					identity.setIdentity((byte) 7);
					identity.setMemberid(user.getReferee());
					identity.setMerchid((long) 0);
					identityList.add(identity);
				}
			}
		}

		// 骑士和勇士
		ImsEweiShopMerchUser merchUser = this.imsEweiShopMerchUserMapper.selectByPrimaryKey(order.getMerchid().longValue());
		if (merchUser.getReferee() != null) {
			ImsEweiShopMemberIdentityExample memberIdentityExample = new ImsEweiShopMemberIdentityExample();
			memberIdentityExample.createCriteria().andStatusEqualTo((byte) 1).andMemberidEqualTo(merchUser.getReferee().longValue()).andIdentityOr(6, 8);
			List<ImsEweiShopMemberIdentity> merhlist = this.imsEweiShopMemberIdentityMapper.selectByExample(memberIdentityExample);
			identityList.addAll(merhlist);
		}

		Map<String, Object> map = new HashMap<>();
		if (merchUser.getPayrate() != null) {
			map.put("payrate", new BigDecimal(100).subtract(merchUser.getPayrate()));
		}
		map.put("benefitIdentityList", identityList);
		return map;
	}

	*/
/**
	 * 获取超级订当前商户的分润成员
	 * 
	 * @param order
	 * @param memberIdentity
	 * @return
	 *//*

	private Map<String, Object> getHotelBenefitIdentityList(ImsEweiShopOrder order, ImsEweiShopMemberIdentity memberIdentity) {
		List<ImsEweiShopMemberIdentity> identityList = new LinkedList<>();

		// 全国 省级 市级 县级
		// 四种身份的，可以直接在ims_ewei_shop_member_identity表中查找到，通过parent_id查找上级
		// (去订) 21:商户,22:代理商(全国) ,23:代理商(省级),24:代理商(市级),25代理商(县级),26 勇士
		int count = 0, maxCount = 20;
		long parentId = memberIdentity.getParentId();
		ImsEweiShopMemberIdentity identity = null;
		while (count++ < maxCount) {
			identity = this.imsEweiShopMemberIdentityMapper.selectByPrimaryKey(parentId);
			if (identity == null) {
				break;
			}

			identityList.add(identity);
			parentId = identity.getParentId();
			if (identity.getIdentity().intValue() == 22) {
				break;
			}
		}

		// 查找勇士身份
		ImsEweiShopMerchUser merchUser = this.imsEweiShopMerchUserMapper.selectByPrimaryKey(order.getMerchid().longValue());
		if (merchUser.getReferee() != null) {
			ImsEweiShopMemberIdentityExample memberIdentityExample = new ImsEweiShopMemberIdentityExample();
			memberIdentityExample.createCriteria().andStatusEqualTo((byte) 1).andMerchidEqualTo(merchUser.getReferee().longValue()).andIdentityEqualTo((byte) 26);
			List<ImsEweiShopMemberIdentity> merhlist = this.imsEweiShopMemberIdentityMapper.selectByExample(memberIdentityExample);
			identityList.addAll(merhlist);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("payrate", 100 - SystemConfig.getIntValue("SUPER_BOOK_PAYRATE"));
		map.put("benefitIdentityList", identityList);
		return map;
	}

	*/
/**
	 * 构造结算参数
	 * 
	 * @param order
	 *            订单信息
	 * @param memberIdentity
	 *            会员身份
	 * @param parentIdentityList
	 *            上级信息
	 * @return 结算参数
	 *//*

	@SuppressWarnings("unchecked")
	private CommissionDto constructSettleParam(Map<String, Object> map) {
		ImsEweiShopOrder order = (ImsEweiShopOrder) map.get("order");
		ImsEweiShopMemberIdentity memberIdentity = (ImsEweiShopMemberIdentity) map.get("memberIdentity");
		List<ImsEweiShopMemberIdentity> benefitIdentityList = (List<ImsEweiShopMemberIdentity>) map.get("benefitIdentityList");

		CommissionDto commission = new CommissionDto();

		commission.setMerchInfo(this.convertIdentityToCustomer(memberIdentity));

		CustomerDto[] parents = new CustomerDto[benefitIdentityList.size()];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < benefitIdentityList.size(); i++) {
			parents[i] = this.convertIdentityToCustomer(benefitIdentityList.get(i));
			sb.append(benefitIdentityList.get(i).getIdentity().toString()).append("-");
		}
		commission.setParentCustomer(parents);

		commission.setMerchType(memberIdentity.getIdentity().intValue());
		commission.setOrderSn(order.getOrdersn());
		commission.setOrderType(order.getOrderType().intValue());
		commission.setTotalAmount(order.getPrice());
		if (map.containsKey("payrate")) {
			commission.getMerchInfo().setProportion(new BigDecimal(map.get("payrate").toString()).shortValue());
		}

		String key = sb.toString();
		sb.delete(0, sb.length());

		if (order.getOrderType() == OrderType.CARD||order.getOrderType() == OrderType.FACE_PAY) {
			for (int i = 2; i <= 8; i++) {
				sb.append(key.contains(String.valueOf(i)) ? i : 0).append("_");
			}
		} else {
			for (int i = 22; i <= 26; i++) {
				sb.append(key.contains(String.valueOf(i)) ? i : 0).append("_");
			}
		}
		commission.setKeyWord(sb.substring(0, sb.length() - 1));

		return commission;
	}

	// 没有用映射框架就先自己写转换了
	private CustomerDto convertIdentityToCustomer(ImsEweiShopMemberIdentity memberIdentity) {
		CustomerDto merchInfo = new CustomerDto();
		merchInfo.setIdentity(memberIdentity.getIdentity());
		merchInfo.setMerchId(memberIdentity.getMerchid());
		merchInfo.setMemberId(memberIdentity.getMemberid());
		merchInfo.setMemberName(memberIdentity.getName());
		return merchInfo;
	}

	*/
/**
	 * 超级订订单，当status=1时，paytime超过24小时（24小时可配置），设置status=3，finishtime=系统时间
	 *//*

	public void hotelOrderCheckInHotel(){

		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		example.createCriteria().andOrderTypeEqualTo(OrderType.SUPER_BOOK).andStatusEqualTo(OrderStatus.WAIT_SEND_GOODS);
		List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectByExample(example);
		if (orderList.isEmpty()) {
			return;
		}
		int checkInHours = SystemProperties.SYS_CHECK_IN_HOURS;
		Date d2 = new Date();
		for(ImsEweiShopOrder ims : orderList){
			Date d1 = new Date(ims.getPaytime()*1000);
			if(DateUtil.daysBetween(d1,d2) > checkInHours){
				// 订单完成支付超过24H要进行手动完成入住
				ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
				updateParam.setStatus(OrderStatus.ALREADY_RECEIVE_GOODS);
				updateParam.setFinishtime((int) DateUtil.getNowDate());
				updateParam.setId(ims.getId());
				this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);
				logger.info(String.format("系统进行用户已入住操作，订单号：%s", ims.getId()));
			}
		}
	}
*/


}
