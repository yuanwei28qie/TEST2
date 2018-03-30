package com.microsilver.mrcard.scheduledtask.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType;
import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.common.HttpClientUtils;
import com.microsilver.mrcard.common.SystemConfig;
import com.microsilver.mrcard.scheduledtask.constant.OrderStatus;
import com.microsilver.mrcard.scheduledtask.constant.OrderType;
import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import com.microsilver.mrcard.scheduledtask.dao.IMemberDao;
import com.microsilver.mrcard.scheduledtask.dao.IShopOrderGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsCrowdsourcingOrderMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiMemberCardMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopActivityGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopActivityMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopCashMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMemberIdentityMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMerchConfigMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMerchUserMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopOrderMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsUserPanterMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsUserRecommendMapper;
import com.microsilver.mrcard.scheduledtask.delay.DelayQueueService;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrderExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiMemberCard;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiMemberCardExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivity;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoodsExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopCash;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopCashExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMember;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchConfig;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchConfigExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderExample.Criteria;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanter;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanterExample;
import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommend;
import com.microsilver.mrcard.scheduledtask.utils.DateUtil;

/**
 * 订单业务处理.
 */
@Service
public class ShopOrderJobService extends BaseService {

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

	@Autowired
	private ImsEweiShopMerchConfigMapper shopMerchConfigMapper;

	@Autowired
	private ImsEweiShopActivityMapper shopActivityMapper;

	@Autowired
	private ImsCrowdsourcingOrderMapper imsCrowdsourcingOrderMapper;
	@Autowired
	private ImsCrowdsourcingOrderLogService imsCrowdsourcingOrderLogService;

	@Autowired
	private ImsEweiShopCashMapper imsEweiShopCashMapper;

	@Resource
	private DelayQueueService delayQueueService;

	@Autowired
	private ImsEweiMemberCardMapper imsEweiMemberCardMapper;
	
	@Autowired
	private ImsUserRecommendMapper recommendMapper;
	/**
	 * 订单根据参加的活动类型，在有效期内未完成支付则订单失败
	 */
	@Transactional
	public void orderExpireDate() {
		try {
			/**
			 *1、查询未支付订单(创建时间大于等于3分钟的)
			 * 	3分钟 为参加活动有效时间最小的时间
			 * 	1,超级特价 10min
			 *  2,零点半价 3min
			 *  3,小时定   ?min
 			 */
			Date now = new Date();
			int expireMinutes = SystemProperties.SYS_CHECK_HALF_OFF;
			Date expireTime = DateUtil.addMinutes(now, -expireMinutes);

			ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo(OrderStatus.WAIT_PAY).andOrderTypeEqualTo(OrderType.SUPER_BOOK);
			criteria.andCreatetimeLessThan(DateUtil.dateToSecond(expireTime));
			List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectHotelByStatu(example);
			if (orderList.isEmpty()) {
				return;
			}

			this.logger.info(String.format("当前查询到未支付订单%s条", orderList.size()));
			orderList.forEach((order)->{
				if(null == order.getActivityId()) {
					return;
				}
				DateTime dbTime = new DateTime(DateUtil.secondToDate(order.getCreatetime()));
				int diffTime = Minutes.minutesBetween(dbTime,new DateTime()).getMinutes();
				if(2 == order.getActivityId() && diffTime > SystemProperties.SYS_CHECK_SUPER_DISCOUNT){
					//than 10min
					closeOrder(now, SystemProperties.SYS_CHECK_SUPER_DISCOUNT, order);
				}else if(1 == order.getActivityId() && diffTime > SystemProperties.SYS_CHECK_HALF_OFF){
					//default more 3 min
					closeOrder(now, SystemProperties.SYS_CHECK_HALF_OFF, order);
				}else{
					//do nothing
				}

			});

		} catch (RuntimeException ex) {
			this.logger.error(ex.getMessage(), ex);
			throw ex;
		}
	}

	/**
	 * 关闭订单，还原库存
	 * 		活动已经关闭的，不再还原存
	 * @param now
	 * @param expireMinutes
	 * @param order
	 */
	private void closeOrder(Date now, int expireMinutes,ImsEweiShopOrder order) {
		// 2、计算创单时间和当前时间差值，大于等于3分钟，则认为订单失效
		String createTime = "";
		StringBuilder logInfo = new StringBuilder();
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
			return;
		}

		for (ImsEweiShopOrderGoods shopOrder : shopOrderList) {
			// 判断活动是否还有效
			ImsEweiShopActivityGoodsExample activityGoodsExample = new ImsEweiShopActivityGoodsExample();
			activityGoodsExample.createCriteria().andGoodsIdEqualTo((long) shopOrder.getGoodsid().intValue());
			List<ImsEweiShopActivityGoods> shopActivityList = this.imsEweiShopActivityGoodsMapper.selectByExample(activityGoodsExample);
			if (shopActivityList.size() != 1) {
				logInfo.append(String.format("商品%s对应ims_ewei_shop_activity_goods表信息有问题，不处理库存", shopOrder.getGoodsid()));
				return;
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


	/**
	 * 超级订“已完成/已入住”状态的订单需要预结算
	 *
	 * 3天————(酒店)的订单 进行结算
	 */
	public void hotelOrderPreSettlement() {
		try {
			//get order
			List<ImsEweiShopOrder> orderList = getFinishOrders(OrderType.SUPER_BOOK);
			if (orderList == null) return;
			else this.logger.info(String.format("当前查询到要结算已完成超级订订单%s条", orderList.size()));

			//check
			// 2、处理订单
			for (ImsEweiShopOrder order : orderList) {
				preSettlement(order);
			}
		} catch (RuntimeException ex) {
			this.logger.error(ex.getMessage(), ex);
		}
	}

	/**
	 * 卡先生和面对面支付“已完成”状态的订单需要结算
	 *
	 * 7天————(会员)的订单
	 */
	public void cardOrderPreSettlement() {
		try {
			//get order
			List<ImsEweiShopOrder> orderList = new ArrayList<>();
			List<ImsEweiShopOrder> cardList = getFinishOrders(OrderType.CARD);
			if(null != cardList && !cardList.isEmpty()) {
				orderList.addAll(cardList);
			}
			List<ImsEweiShopOrder> faceList = getFinishOrders(OrderType.FACE_PAY);
			if(null != faceList && !faceList.isEmpty())
				orderList.addAll(faceList);
			if (orderList.isEmpty()) {
				return;
			}	else this.logger.info(String.format("当前查询到要结算已完成卡先生订单%s条", orderList.size()));

			// 2、处理订单
			for (ImsEweiShopOrder order : orderList) {
				logger.info(String.format("预结算订单数据 %s", JSON.toJSONString(order)));
				CommissionDto commission = new CommissionDto();
				//order
				commission.setOrderSn(order.getOrdersn());
				commission.setOrderType(order.getOrderType().intValue());
				commission.setTotalAmount(order.getGoodsprice());

				//check merch and identity
				ImsEweiShopMemberIdentity merchIdentity = checkMerchIdentity((byte)1,(byte)1,(long)order.getMerchid());
				if(null == merchIdentity || null == merchIdentity.getParentId()){
					logger.info(String.format("商户%s的Identity身份不正常，请手工结算，订单号%s", order.getMerchid(), order.getId()));
					changeOrderStatus(order.getId(),(byte)-1);
					continue;
				}else {
					commission.setMerchType(merchIdentity.getIdentity().intValue());
					commission.setMerchInfo(this.convertIdentityToCustomer(merchIdentity));
				}

				// prate
				Short prate = getMrcardPrate(order.getMerchid()).shortValue();
				commission.setFlowType((byte)1);
				if(0 == prate) {
					logger.info(String.format("商户%s的被抽成比例payrate为空，请手工结算，订单号%s", order.getMerchid(), order.getId()));
					changeOrderStatus(order.getId(),(byte)-1);
					continue;
				}else
					commission.getMerchInfo().setProportion(prate);

				//get proxy identity
				CustomerDto [] parentCustomer = getMrcardProxyIdentity(order.getMerchid(),merchIdentity.getParentId(),order.getOpenid());
				commission.setParentCustomer(parentCustomer);

				//commission keyword
				commission.setKeyWord(keyWords(order.getOrderType(),parentCustomer));

				logger.info(String.format("超级订订单%s结算参数:%s", order.getId(), JSON.toJSONString(commission)));

				delayQueueService.putCommissionToQueue(order.getId(),commission);
			}
		} catch (RuntimeException ex) {
			this.logger.error(ex.getMessage(), ex);
		}
	}


	/**
	 * 超级定 帮我买订单预结算
	 *  -为骑士结算收入
	 * 	订单完成：已收货+用户评价 -用户方完成
	 * 			：已收货+骑士评价 -骑士方完成
	 * 		// 状态(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定）
	 */
	public void BuyForMePreSettlement(){
		//订单完成
		List<ImsCrowdsourcingOrder> orderList = getImsCrowdsourcingOrders();
		if (orderList.isEmpty()) {
			return;
		}else{ this.logger.info(String.format("当前查询到要结算已完成小飞侠订单%s条", orderList.size()));}

		List<CommissionDto> commissionDtoList = null;
		// 2、处理订单
		for(ImsCrowdsourcingOrder order : orderList){
			commissionDtoList = new ArrayList<>();
			logger.info(String.format("预结算订单数据 %s", JSON.toJSONString(order)));
			//骑士
			Long knightId = order.getCourier();
			ImsEweiShopMemberIdentity merchIdentity = getImsEweiShopMemberIdentity(knightId);
			if(null == merchIdentity || null == merchIdentity.getParentId()){
				logger.info(String.format("骑士%s的Identity身份不正常，请手工结算，订单号%s", knightId, order.getId()));
				changeOrderStatusByKnight(order.getId(),(byte)-1);
				continue;
			}
			//骑士默认分得全部金额
			CustomerDto knight = new CustomerDto();
			knight = this.convertIdentityToCustomer(merchIdentity);
			knight.setProportion((short)100);


			/**
			 * 1,折单
			 *   把订单折为三个
			 *   	代收货款、运费、小费
			 */
			//A 代收货款
			CommissionDto commission = new CommissionDto();
			commission.setOrderSn(order.getOrdersn());
			commission.setOrderType(OrderType.SUPER_KNIGHT.intValue());
			commission.setTotalAmount(order.getGoodsConsultPrice());
			commission.setMerchType((int) knight.getIdentity());
			commission.setMerchInfo(knight);
			commission.setFlowType((byte) CommissionFlowType.SALE_ADVANCE.getIndex());
			commission.setRemark(CommissionFlowType.SALE_ADVANCE.getName());
			commissionDtoList.add(commission);
			//B 小费
			CommissionDto commissionTip = new CommissionDto();
			commissionTip.setOrderSn(order.getOrdersn());
			commissionTip.setOrderType(OrderType.SUPER_KNIGHT.intValue());
			commissionTip.setTotalAmount(order.getTipPrice());
			commissionTip.setMerchType((int) knight.getIdentity());
			commissionTip.setMerchInfo(knight);
			commissionTip.setFlowType((byte)CommissionFlowType.SALE_TIP.getIndex());
			commissionTip.setRemark(CommissionFlowType.SALE_TIP.getName());
			commissionDtoList.add(commissionTip);
			//C 销售收入
			CommissionDto commissionAdv = new CommissionDto();
			commissionAdv.setOrderSn(order.getOrdersn());
			commissionAdv.setOrderType(OrderType.SUPER_KNIGHT.intValue());
			commissionAdv.setTotalAmount(order.getDispatchPrice());
			commissionAdv.setMerchType((int) knight.getIdentity());
			commissionAdv.setMerchInfo(knight);
			//分成
			int payrate = SystemConfig.getIntValue("SUPER_BOOK_PAYRATE");
			BigDecimal proportion = new BigDecimal(100).subtract(new BigDecimal(payrate));
			commissionAdv.getMerchInfo().setProportion(proportion.shortValue());
			//get proxy identity
			CustomerDto [] parentCustomer = getHotelProxyIdentity(merchIdentity.getParentId());
			commissionAdv.setParentCustomer(parentCustomer);

			//commission keyword
			commissionAdv.setKeyWord(keyWords(OrderType.SUPER_KNIGHT.byteValue(),parentCustomer));
			commissionAdv.setFlowType((byte)CommissionFlowType.SALE_NONE.getIndex());
			commissionAdv.setRemark(CommissionFlowType.SALE_NONE.getName());
			commissionDtoList.add(commissionAdv);
			logger.info("预结算数据："+JSON.toJSONString(commissionDtoList));
			try {
                delayQueueService.putCommissionToQueue(order.getId().intValue(), order.getOrdersn(), commissionDtoList);
            }catch (Exception ex){
			    logger.error("骑士预结算失败：",ex);
            }
		}

	}

	/**
	 * 查询骑士已完成订单，根据订单完成时间来
	 * 		订单完成->骑士已评价
	 * @return
	 */
	private List<ImsCrowdsourcingOrder> getImsCrowdsourcingOrders() {
		int orderType = 3;
		//查询已完成未结算的订单
		ImsCrowdsourcingOrderExample imsCrowdsourcingOrderExample = new ImsCrowdsourcingOrderExample();
		imsCrowdsourcingOrderExample.createCriteria()
				.andIsSettlementEqualTo((byte)0).andCourierAppraiseEqualTo(true).andStatusEqualTo((byte)6).andCourierIsNotNull();
		return imsCrowdsourcingOrderMapper.selectByExample(imsCrowdsourcingOrderExample);
	}

	/**
	 * 获取骑士信息
	 * @param knightId
	 * @return
	 */
	private ImsEweiShopMemberIdentity getImsEweiShopMemberIdentity(Long knightId) {
		ImsEweiShopMemberIdentity merchIdentity = null;
		List<ImsEweiShopMemberIdentity> merchIdentityList = null;
		ImsEweiShopMemberIdentityExample identityExample = new ImsEweiShopMemberIdentityExample();
		identityExample.createCriteria().andMemberidEqualTo(knightId).andMerchidEqualTo(0L);

		merchIdentityList = imsEweiShopMemberIdentityMapper.selectByExample(identityExample);
		if(null != merchIdentityList && !merchIdentityList.isEmpty()){
            merchIdentity = merchIdentityList.get(0);
        }
		return merchIdentity;
	}

	/**
	 * 结算订单
	 */
	public void OrderSettlement(){
		Date Seven = new Date();
		int cardDays = 7;
		Date settleTimeSeven = DateUtil.addDays(Seven, -cardDays);

		//@Jade 2017-10-16修改结算时间为预结算后立即结算
		Date Three = new Date();
		int hotelDays = 0;
		Date settleTimeThreee = DateUtil.addDays(Three, -hotelDays);

		List<ImsEweiShopOrder> list = new LinkedList<>();
		/*
		 //2017-09-20 @Jade 根据要求关闭卡先生所有定时任务
		//card
		List<ImsEweiShopOrder> cardList = getSettlementOrders(settleTimeSeven,OrderType.CARD);
		if(null != cardList && !cardList.isEmpty())
			list.addAll(cardList);
		List<ImsEweiShopOrder> faceList = getSettlementOrders(settleTimeSeven,OrderType.FACE_PAY);
		if(null != faceList && !faceList.isEmpty())
			list.addAll(faceList);*/
		//hotel
		List<ImsEweiShopOrder> hotelList = getSettlementOrders(settleTimeThreee,OrderType.SUPER_BOOK);
		if(null != hotelList && !hotelList.isEmpty())
			list.addAll(hotelList);
		if(null != list && !list.isEmpty())
			list.forEach((order) -> settlement(order.getId(),order.getOrdersn()));

	}

	/**
	 * 结算订单
	 * 1，根据周期内订单进行结算，
	 * 2，根据单个用户周期内订单核查是否全部结算完成
	 * 3，全部结算完成的用户进行结转
	 */
	/*public void KnightSettlement(){
		//查询已完成未结算的订单
		LocalDate d = LocalDate.now();
		LocalDate.Property property = d.minusWeeks(1).dayOfWeek();
		LocalDate beginTime = property.withMinimumValue();
        LocalDate endTime = property.withMaximumValue();
		Long b1 = (beginTime.toInterval().getStartMillis()/1000);
        Long e1 = (endTime.toInterval().getEndMillis()/1000);
		List<ImsCrowdsourcingOrder> orderList = imsCrowdsourcingOrderMapper.selectByLOGStatus(true,(byte)1,(byte)6,b1.intValue(),e1.intValue());
		if(null == orderList || orderList.isEmpty()){
			return;
		}else{
			logger.debug("settlement knight data ->" +JSON.toJSONString(orderList));
		}
		//结算订单列表 ，根据骑士分组
		Map<Long,CarryoverKnightDto> carryMap = new HashMap<>();
		final int[] flag = {0};
		orderList.forEach((corder)->{
			ImsEweiShopMemberIdentity merchIdentity = getImsEweiShopMemberIdentity(corder.getCourier());
			CommissionDto commissionDto = new CommissionDto();
			commissionDto.setMerchInfo(convertIdentityToCustomer(merchIdentity));
			commissionDto.setOrderSn(corder.getOrdersn());
			boolean isBound = financeRemoteService.TaskKnightBound(commissionDto);
			if(isBound){
				flag[0]++;
				if(carryMap.containsKey(corder.getCourier())){
					carryMap.get(corder.getCourier()).getSnList().add(corder.getOrdersn());
				}else{
					CarryoverKnightDto knightDto = new CarryoverKnightDto();
					knightDto.setIdentity(merchIdentity.getIdentity());
					knightDto.setMemberId(merchIdentity.getMemberid());
					knightDto.setMerchId(merchIdentity.getMerchid());
					knightDto.setBeginTime(b1);
					knightDto.setEndTime(e1);
					List<String> snList = new ArrayList<>();
					snList.add(corder.getOrdersn());
					knightDto.setSnList(snList);
					carryMap.put(corder.getCourier(),knightDto);
				}
			}
		});
		//全部结算成功 ，则执行结转
		if(orderList.size() == flag[0]){
			logger.debug("pre carryover knight data ->" +JSON.toJSONString(carryMap));
			List<String> settList = new ArrayList<>();
			carryMap.forEach((k,v)->{
				String settlementSN = financeRemoteService.TaskKnightCarryover(v);
				if(null != settlementSN) {
					settList.add(settlementSN);
				}
			});
			logger.debug("carryover knight result data ->" +JSON.toJSONString(settList));
			//全部结转成功，则执行订单结转成功变更
			if(settList != null && settList.size() == carryMap.size()){
				orderList.forEach((order)->changeOrderStatusByKnight(order.getId(),(byte)2));
			}else{
				logger.info("结转数据不一至，请检查->"+JSON.toJSONString(settList));
				return;
			}
		}else {
			logger.info("结算不数据不一至，不于结转请检查->" +JSON.toJSONString(carryMap));
			return;
		}
	}*/

	/**
	 * 只生成财务流水，不做结算
	 * @param ordersn
	 */
	public void KnightBound(String ordersn){
		ImsCrowdsourcingOrderExample example = new ImsCrowdsourcingOrderExample();
		example.createCriteria().andOrdersnEqualTo(ordersn);
		ImsCrowdsourcingOrder corder = imsCrowdsourcingOrderMapper.selectByExample(example).get(0);
		//有未结算的单据进行结算，已经结算过的单据不再进行结算
		ImsEweiShopMemberIdentity merchIdentity = getImsEweiShopMemberIdentity(corder.getCourier());
		if(corder.getIsSettlement() == 1) {
			CommissionDto commissionDto = new CommissionDto();
			commissionDto.setMerchInfo(convertIdentityToCustomer(merchIdentity));
			commissionDto.setOrderSn(corder.getOrdersn());
			boolean isBound = financeRemoteService.TaskKnightBound(commissionDto);
			if (isBound) {
				logger.info("生成财务流水成功:"+ JSON.toJSONString(commissionDto));
				corder.setStatus((byte)11);
				imsCrowdsourcingOrderLogService.addLog(corder);
			}
		}
	}
	/**
	 * 结算订单
	 * 1，根据周期内订单进行结算，
	 * 2，根据单个用户周期内订单核查是否全部结算完成
	 * 3，全部结算完成的用户进行结转
	 */
	public void KnightSettlement(){
		//查询已完成未结算的订单
		LocalDate d = LocalDate.now();
		LocalDate.Property property = d.minusWeeks(1).dayOfWeek();
		LocalDate beginTime = property.withMinimumValue();
		LocalDate endTime = property.withMaximumValue();
		Long b1 = (beginTime.toInterval().getStartMillis()/1000);
		Long e1 = (endTime.toInterval().getEndMillis()/1000);
		List<ImsCrowdsourcingOrder> orderList =  imsCrowdsourcingOrderMapper.selectByLOGStatus(true,(byte)1,(byte)11,b1.intValue(),e1.intValue());
		if(null == orderList || orderList.isEmpty()){
			return;
		}else{
			logger.debug("settlement knight data ->" +JSON.toJSONString(orderList));
		}
		//结算订单列表 ，根据骑士分组
		Map<Long,CarryoverKnightDto> carryMap = new HashMap<>();
		Map<Long,List<ImsCrowdsourcingOrder>> checkMap = new HashMap<>();
		orderList.forEach((corder)->{
			//有未结算的单据进行结算，已经结算过的单据不再进行结算
			ImsEweiShopMemberIdentity merchIdentity = getImsEweiShopMemberIdentity(corder.getCourier());
			//结算数据构造-根据骑士进行分组
			if(carryMap.containsKey(corder.getCourier())){
				carryMap.get(corder.getCourier()).getSnList().add(corder.getOrdersn());
			}else{
				CarryoverKnightDto knightDto = new CarryoverKnightDto();
				knightDto.setIdentity(merchIdentity.getIdentity());
				knightDto.setMemberId(merchIdentity.getMemberId());
				knightDto.setMerchId(merchIdentity.getMerchId());
				knightDto.setBeginTime(b1);
				knightDto.setEndTime(e1);
				List<String> snList = new ArrayList<>();
				snList.add(corder.getOrdersn());
				knightDto.setSnList(snList);
				carryMap.put(corder.getCourier(),knightDto);
			}
			if(checkMap.containsKey(corder.getCourier())){
				checkMap.get(corder.getCourier()).add(corder);
			}else{
				List<ImsCrowdsourcingOrder> cL = new ArrayList<>();
				cL.add(corder);
				checkMap.put(corder.getCourier(),cL);
			}
		});
		//单个用户全部结算成功 ，则执行结转
		checkMap.forEach((k,v)->{
			CarryoverKnightDto carryDto = carryMap.get(k);
			String settlementSN = financeRemoteService.TaskKnightCarryover(carryDto);
			if(settlementSN != null) {
				logger.info(k + "结转成功 ->" + settlementSN);
				//记录订单结转单号
				for (ImsCrowdsourcingOrder sv : v) {
					changeOrderStatusByKnight(sv.getId(), (byte) 2);
					imsCrowdsourcingOrderLogService.addLog(sv.getId(), settlementSN, (byte) 12);
				}
			}
		});
	}
	/*public void KnightSettlementOLD(){
		//查询已完成未结算的订单
		LocalDate d = LocalDate.now();
		LocalDate.Property property = d.minusWeeks(1).dayOfWeek();
		LocalDate beginTime = property.withMinimumValue();
        LocalDate endTime = property.withMaximumValue();
		Long b1 = (beginTime.toInterval().getStartMillis()/1000);
        Long e1 = (endTime.toInterval().getEndMillis()/1000);
		List<ImsCrowdsourcingOrder> orderList =  imsCrowdsourcingOrderMapper.selectByLOGStatus(true,(byte)2,(byte)11,b1.intValue(),e1.intValue());
		if(null == orderList || orderList.isEmpty()){
			return;
		}else{
			logger.debug("settlement knight data ->" +JSON.toJSONString(orderList));
		}
		//结算订单列表 ，根据骑士分组
		Map<Long,CarryoverKnightDto> carryMap = new HashMap<>();
		orderList.forEach((corder)->{
		    //有未结算的单据进行结算，已经结算过的单据不再进行结算
            ImsEweiShopMemberIdentity merchIdentity = getImsEweiShopMemberIdentity(corder.getCourier());
//          //@2017-09-22 结算功能提出为单独方法 KnightBound（），在预结算完成后立即结算，但不进行余额扣除，要在结转的时候进行扣除
//		    if(corder.getIsSettlement() == 1) {
//                CommissionDto commissionDto = new CommissionDto();
//                commissionDto.setMerchInfo(convertIdentityToCustomer(merchIdentity));
//                commissionDto.setOrderSn(corder.getOrdersn());
//                boolean isBound = financeRemoteService.TaskKnightBound(commissionDto);
//                if (isBound) {
//                    changeOrderStatusByKnight(corder.getId(), (byte) 2);
//                    corder.setStatus((byte)11);
//                    imsCrowdsourcingOrderLogService.addLog(corder);
//                }
//            }
            //结算数据构造-根据骑士进行分组
            if(carryMap.containsKey(corder.getCourier())){
                carryMap.get(corder.getCourier()).getSnList().add(corder.getOrdersn());
            }else{
                CarryoverKnightDto knightDto = new CarryoverKnightDto();
                knightDto.setIdentity(merchIdentity.getIdentity());
                knightDto.setMemberId(merchIdentity.getMemberid());
                knightDto.setMerchId(merchIdentity.getMerchid());
                knightDto.setBeginTime(b1);
                knightDto.setEndTime(e1);
                List<String> snList = new ArrayList<>();
                snList.add(corder.getOrdersn());
                knightDto.setSnList(snList);
                carryMap.put(corder.getCourier(),knightDto);
            }
		});
		//查询全部已经结算完成的订单--做校验使用
        List<ImsCrowdsourcingOrder> carryList = imsCrowdsourcingOrderMapper.selectByLOGStatus(true,(byte)2,(byte)11,b1.intValue(),e1.intValue());
        //根据骑士进行分组
        Map<Long,List<ImsCrowdsourcingOrder>> checkMap = new HashMap<>();
        carryList.forEach((checkOrder)->{
            if(checkMap.containsKey(checkOrder.getCourier())){
                checkMap.get(checkOrder.getCourier()).add(checkOrder);
            }else{
                List<ImsCrowdsourcingOrder> cL = new ArrayList<>();
                cL.add(checkOrder);
                checkMap.put(checkOrder.getCourier(),cL);
            }
        });
		//单个用户全部结算成功 ，则执行结转
        checkMap.forEach((k,v)->{
            CarryoverKnightDto carryDto = carryMap.get(k);
            //用户结算单据条数 == 原始单据条数
            if(v.size() == carryDto.getSnList().size()){
                String settlementSN = financeRemoteService.TaskKnightCarryover(carryDto);
                logger.info(k + "结算成功 ->"+settlementSN);
                //记录订单结转单号
                for(ImsCrowdsourcingOrder sv : v){
                    imsCrowdsourcingOrderLogService.addLog(sv.getId(),settlementSN,(byte)12);
                }
            }else{
                logger.error("结转数据检验不一至，不予结算.请检查 "+JSON.toJSONString(v)+"<->"+JSON.toJSONString(carryDto));
            }
        });
	}*/


	/**
	 * 超级订订单，当status=1时，paytime超过24小时（24小时可配置），设置status=3，finishtime=系统时间
	 */
	public void hotelOrderCheckInHotel(){
		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		example.createCriteria().andOrderTypeEqualTo(OrderType.SUPER_BOOK).andStatusEqualTo(OrderStatus.WAIT_SEND_GOODS);
		List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectByExample(example);
		if (orderList.isEmpty()) {
			return;
		}
		int checkInHours = SystemProperties.SYS_CHECK_IN_HOURS;
		long d2 = System.currentTimeMillis();
		for(ImsEweiShopOrder ims : orderList){
			long d1 = Long.valueOf(ims.getFetchtime())*1000;
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


	/**
	 * 获取上级代理信息
	 * @param parentId
	 * @return
	 */
	private CustomerDto[] getHotelProxyIdentity(long parentId) {
		List<ImsEweiShopMemberIdentity> list = new LinkedList<>();
		parentProxyIdentity(parentId,list);
		CustomerDto[] parents = new CustomerDto[list.size()];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
            parents[i] = this.convertIdentityToCustomer(list.get(i));
            sb.append(list.get(i).getIdentity().toString()).append("-");
        }
		return parents;
	}

	private CustomerDto[] getMrcardProxyIdentity(long merchId,long parentId,String openId) {
		List<ImsEweiShopMemberIdentity> list = new LinkedList<>();
		//proxy
		parentProxyIdentity(parentId,list);
		//warrior 6
		ImsEweiShopMemberIdentity warrior = warriorProxyIdentity(merchId,(byte)6);
		if(null != warrior)
			list.add(warrior);
		//vip 7
		ImsEweiShopMemberIdentity vip = vipProxyIdentity(openId);
		if(null != vip) {
			list.add(vip);
		}
		//knight 8
		ImsEweiShopMemberIdentity knight = warriorProxyIdentity(merchId,(byte)8);
		if(null != knight)
			list.add(knight);

		CustomerDto[] parents = new CustomerDto[list.size()];
		for (int i = 0; i < list.size(); i++) {
            parents[i] = this.convertIdentityToCustomer(list.get(i));
        }
		return parents;
	}

	/**
	 * 查询已完成（状态为3和6）订单 做预结算
	 * @param orderType
	 * @return
	 */
	private List<ImsEweiShopOrder> getFinishOrders(Byte orderType) {
		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		example.createCriteria().andOrderTypeEqualTo(orderType).andIsparentEqualTo(false).andIssettlementEqualTo(0).andStatusOr(OrderStatus.ALREADY_RECEIVE_GOODS, OrderStatus.ALREADY_FINISH);
		List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectByExample(example);
		if (orderList.isEmpty()) {
			return null;
        }
		return orderList;
	}

	/**
	 * 根据时间查询已经预结算过的订单，做结算
	 * @param settleTime
	 * @param orderType
	 * @return
	 */
	private List<ImsEweiShopOrder> getSettlementOrders(Date settleTime,Byte orderType) {
		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		example.createCriteria().andOrderTypeEqualTo(orderType).andIssettlementEqualTo(1)
                .andFinishtimeLessThan(DateUtil.dateToSecond(settleTime));
		List<ImsEweiShopOrder> orderList = this.imsEweiShopOrderMapper.selectByExample(example);
		if (orderList.isEmpty()) {
			return null;
        }
		return orderList;
	}

	public ImsEweiShopOrder getImsEweiShopOrderById(Long orderId){
		return this.imsEweiShopOrderMapper.selectByPrimaryKey(orderId);
	}



	/**
	 * 查找商户身份
	 * @param status
	 * @param identity
	 * @param merchId
	 * @return
	 */
	private ImsEweiShopMemberIdentity checkMerchIdentity(byte status,byte identity,long merchId){
		ImsEweiShopMemberIdentityExample identityExample = new ImsEweiShopMemberIdentityExample();
		identityExample.createCriteria().andStatusEqualTo(status).andIdentityEqualTo(identity).andMerchidEqualTo(merchId);
		List<ImsEweiShopMemberIdentity> identityList = this.imsEweiShopMemberIdentityMapper.selectByExample(identityExample);
		if (identityList.size() != 1) {
//			this.logger.info(String.format("商户%s的Identity身份不正常，请手工结算，订单号%s", order.getMerchid(), order.getId()));
			return null;
		}else
			return identityList.get(0);
	}

	/**
	 * 	// 全国 省级 市级 县级
	 * 四种身份的，可以直接在ims_ewei_shop_member_identity表中查找到，通过parent_id查找上级
	 * @param parentId
	 * @return
	 */
	private List<ImsEweiShopMemberIdentity> parentProxyIdentity(long parentId ,List<ImsEweiShopMemberIdentity> identityList){
		ImsEweiShopMemberIdentity identity = this.imsEweiShopMemberIdentityMapper.selectByPrimaryKey(parentId);
		identityList.add(identity);
		if(null != identity && identity.getParentId() != 0){
			return parentProxyIdentity(identity.getParentId(),identityList);
		}
		return identityList;
	}

	/**
	 * Vip 身份获取
	 */
	private ImsEweiShopMemberIdentity vipProxyIdentity(String openId){
		// 卡先生的勇士、骑士、vip要单独处理
		ImsEweiShopMemberIdentity identity = null;
		ImsEweiShopMember user = this.memberDao.selectByOpenId(openId);
		if (user.getReferee() != null) {
			// 查询推荐用户
			ImsUserPanterExample userPanterExample = new ImsUserPanterExample();
			userPanterExample.createCriteria().andUserIdEqualTo(user.getReferee());
			List<ImsUserPanter> userPanterList = this.imsUserPanterMapper.selectByExample(userPanterExample);
			if (!userPanterList.isEmpty()) {
				ImsUserPanter userPanter = userPanterList.get(0);
				if (userPanter.getIsVip() == 1) {
					identity = new ImsEweiShopMemberIdentity();
					// 如果是vip，则构造身份
					identity = new ImsEweiShopMemberIdentity();
					identity.setIdentity((byte) 7);
					identity.setMemberId(user.getReferee());
					identity.setMerchId((long) 0);
				}
			}
		}
		return identity;
	}

	/**
	 *勇士，骑士身份获取
	 */
	private ImsEweiShopMemberIdentity warriorProxyIdentity(long merchId,byte identity){
		// 骑士和勇士
		ImsEweiShopMerchUser merchUser = this.imsEweiShopMerchUserMapper.selectByPrimaryKey(merchId);
		if (merchUser.getReferee() != null) {
			ImsEweiShopMemberIdentityExample memberIdentityExample = new ImsEweiShopMemberIdentityExample();
			memberIdentityExample.createCriteria().andStatusEqualTo((byte) 1).andMemberidEqualTo(merchUser.getReferee().longValue()).andIdentityEqualTo(identity);
			List<ImsEweiShopMemberIdentity> merhlist = this.imsEweiShopMemberIdentityMapper.selectByExample(memberIdentityExample);
			if(!merhlist.isEmpty())
				return merhlist.get(0);
		}
		return null;
	}

	/**
	 * 卡先生 商家分润获取
	 * @param merchId
	 * @return
	 */
	private BigDecimal getMrcardPrate(long merchId){
		ImsEweiShopMerchUser merchUser = getMerchInfo(merchId);
		return new BigDecimal(100).subtract(merchUser.getPayrate());
	}

	/**
	 * 获取商户资料
	 * @param merchId
	 * @return
	 */
	private ImsEweiShopMerchUser getMerchInfo(long merchId){
		ImsEweiShopMerchUser merchUser = this.imsEweiShopMerchUserMapper.selectByPrimaryKey(merchId);
		return merchUser;
	}

	/**
	 * 超级定 商家分润获取
	 * 查询商家活动配置 有则使用商家配置
	 * 					无则使用系统统一配置
	 * 				活动编号(1:零点半价,2:全天半价,3:小时订)
	 * @param merchId
	 * @param activityId
	 * @return
	 */
	private BigDecimal getHotelPrate(long merchId,int activityId){
		BigDecimal parte = new BigDecimal(0);
		ImsEweiShopMerchConfigExample merchConfig = new ImsEweiShopMerchConfigExample();
		merchConfig.createCriteria().andMerchIdEqualTo(merchId);
		List<ImsEweiShopMerchConfig> merchConfigList = shopMerchConfigMapper.selectByExample(merchConfig);
		if (null != merchConfigList && !merchConfigList.isEmpty()) {
			ImsEweiShopMerchConfig mc = merchConfigList.get(0);
			switch (activityId) {
				case 1:
					parte = mc.getLdbjPlatformProportion();
					break;
				case 2:
					parte = mc.getCjtjPlatformProportion();
					break;
				case 3:
					parte = mc.getXsdPlatformProportion();
					break;
			}
		} else {
			ImsEweiShopActivity activity = shopActivityMapper.selectByPrimaryKey(activityId);
			if (activity != null) {
				parte = activity.getPlatformProportion();
			}
		}
//		int parte = SystemConfig.getIntValue("SUPER_BOOK_PAYRATE");
		return  new BigDecimal(100).subtract(parte);
	}

	/**
	 * 预结算订单
	 * @param order
	 * @return
	 */
	public boolean preSettlement(ImsEweiShopOrder order) {
		CommissionDto commission = getCommissionData(order);
		if(null != commission)
		delayQueueService.putCommissionToQueue(order.getId(),commission);
		return true;
	}
	public boolean preSettlementSync(ImsEweiShopOrder order) {
		CommissionDto commission = getCommissionData(order);
		boolean issuccess = false;
		if(null != commission) {
			try {
				issuccess = financeRemoteService.Commisstion(commission);
			}
			catch(Exception ex) {
				logger.error("预结算失败:" + ex.getMessage());
				ex.printStackTrace();
			}
			if (issuccess) {//执行成功则修改订单状态
				changeOrderStatus(order.getId(), (byte) 1);
				logger.info("结算结果：" + issuccess);
			}
		}
		return issuccess;
	}

	private CommissionDto getCommissionData(ImsEweiShopOrder order){
		logger.info(String.format("预结算订单数据 %s", JSON.toJSONString(order)));

		CommissionDto commission = new CommissionDto();
		//order
		commission.setOrderSn(order.getOrdersn());
		commission.setOrderType(order.getOrderType().intValue());
		commission.setTotalAmount(order.getPrice());

		//check merch and identity
		ImsEweiShopMemberIdentity merchIdentity = checkMerchIdentity((byte)1,(byte)21,(long)order.getMerchid());
		if(null == merchIdentity){
			logger.info(String.format("商户%s的Identity身份不正常，请手工结算，订单号%s", order.getMerchid(), order.getId()));
			changeOrderStatus(order.getId(),(byte)-1);
			return null;
		}

		//check user identity
		if(order.getActivityId() == 2){
			CustomerDto userInfo = new CustomerDto();
			userInfo.setMemberId(order.getMemberId());
			userInfo.setIdentity((byte)0);
			userInfo.setMerchId(0L);
			userInfo.setProportion((short)40);
			userInfo.setRemark(CommissionFlowType.SALE_REWARD);
			commission.setUserInfo(userInfo);
			commission.setUserprice(order.getSubsidyprice());
			commission.setSysprice(order.getPrice().subtract(order.getSubsidyprice()));
		}else{
			//零点半价,消费者有推荐人且为合伙人时,给合伙人分享利润
			
			CustomerDto merchInfo = this.convertIdentityToCustomer(merchIdentity);
//			merchInfo.setRemark();
			commission.setMerchInfo(merchInfo);
			//商家分润所有的结算价格
			commission.getMerchInfo().setProportion((short)100);

			commission.setCostprice(order.getCostprice());
			commission.setSysprice(order.getPrice().subtract(order.getCostprice()));
			//消费者有推荐人
			ImsUserRecommend userRecommend = recommendMapper.selectByPrimaryKey(order.getMemberId());
			if(userRecommend!=null) {
				userRecommend = recommendMapper.selectByPrimaryKey(userRecommend.getLevel1ParentId());
				if(userRecommend!=null&&userRecommend.getVipType()>0&&userRecommend.getVipType()<10) {
					commission.setRecMemberInfo(getRemMember(userRecommend.getMemberId()));
				}
			}
			//酒店推荐人
			ImsEweiShopMerchUser merch = imsEweiShopMerchUserMapper.selectByPrimaryKey((long)order.getMerchid());
			if(merch.getReferee()!=null&&merch.getReferee()>0) {
				ImsEweiShopMember member = memberDao.selectByPrimaryKey(merch.getReferee());
				if(member!=null) {
					commission.setRecMerchInfo(getRemMember(member.getId()));
				}
			}
		}
		commission.setMerchType(merchIdentity.getIdentity().intValue());
		//get proxy identity
		CustomerDto [] parentCustomer = getHotelProxyIdentity(merchIdentity.getParentId());
		commission.setParentCustomer(parentCustomer);
		commission.setFlowType((byte)1);
		//commission keyword
		commission.setKeyWord(keyWords(order.getOrderType(),parentCustomer));

		this.logger.info(String.format("超级订订单%s结算参数:%s", order.getId(), JSON.toJSONString(commission)));
		return commission;
	}
	/**
	 * 获取推荐人
	 * @param memberId
	 * @return
	 */
	private CustomerDto getRemMember(Long memberId) {
		CustomerDto recInfo = new CustomerDto();
		recInfo.setMemberId(memberId);
		recInfo.setIdentity((byte)0);
		recInfo.setMerchId(0L);
		//推荐人抽层比例
		recInfo.setProportion(SystemProperties.RECOMMEND_MEMBER_ORDER);
		recInfo.setRemark(CommissionFlowType.SALE_BOUND);
		return recInfo;
	}
	/**
	 * 结算订单
	 * @param orderSn
	 * @return
	 */
	public boolean settlement(Integer orderId,String orderSn) {
		boolean result = false;
		try {
			result = this.financeRemoteService.TaskBound(orderSn);
		} catch (Exception ex) {
			String msg = String.format("订单%s结算失败", orderSn);
			this.logger.error(msg, ex);
		}
		if(result) {
			logger.info("结算成功:" + orderSn);
			changeOrderStatus(orderId, (byte) 2);
		}
		return result;
	}

	/**
	 * 更新本地订单状态
	 * 		结算状态(-1结算失败，0:未结算,1: 预结算，2已结算)
	 * @param orderId
	 * @param settlement
	 * @return
	 */
	public boolean changeOrderStatus(Integer orderId,byte settlement){
		ImsEweiShopOrder updateParam = new ImsEweiShopOrder();
		updateParam.setIssettlement(settlement);
		updateParam.setId(orderId);
		int num = this.imsEweiShopOrderMapper.updateByPrimaryKeySelective(updateParam);
		logger.info("订单状态更新"+orderId);
		return num >0 ? true : false;
	}

	/**
	 * 更改小飞侠订单状态
	 * @param orderId
	 * @param settlement
	 * @return
	 */
	public boolean changeOrderStatusByKnight(Long orderId,byte settlement){
		ImsCrowdsourcingOrder updateParam = new ImsCrowdsourcingOrder();
		updateParam.setIsSettlement(settlement);
		updateParam.setId(orderId);
		int num = this.imsCrowdsourcingOrderMapper.updateByPrimaryKeySelective(updateParam);
		logger.info("订单状态更新"+orderId);
		return num >0 ? true : false;
	}

	/**
	 * 根据上级代理，生成keyword
	 * 		财务系统匹配其对应的分成比例
	 * @param proxy
	 * @return
	 */
	private String keyWords(byte orderType ,CustomerDto[] proxy){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < proxy.length; i++) {
			sb.append(proxy[i].getIdentity()).append("-");
		}

		String key = sb.toString();

		StringBuilder keyword = new StringBuilder();

		if (orderType == OrderType.CARD||orderType == OrderType.FACE_PAY) {
			for (int i = 2; i <= 8; i++) {
				keyword.append(key.contains(String.valueOf(i)) ? i : 0).append("_");
			}
		} else if(orderType == OrderType.SUPER_BOOK) {
			for (int i = 22; i <= 26; i++) {
				keyword.append(key.contains(String.valueOf(i)) ? i : 0).append("_");
			}
		}else if (orderType == OrderType.SUPER_KNIGHT){
			for (int i = 32; i <= 35; i++) {
				keyword.append(key.contains(String.valueOf(i)) ? i : 0).append("_");
			}
		}
		String result = keyword.substring(0, keyword.length() - 1);
		return result;
	}

	/**
	 * 没有用映射框架就先自己写转换了
	 */
	private CustomerDto convertIdentityToCustomer(ImsEweiShopMemberIdentity memberIdentity) {
		CustomerDto merchInfo = new CustomerDto();
		merchInfo.setIdentity(memberIdentity.getIdentity());
		merchInfo.setMerchId(memberIdentity.getMerchId());
		merchInfo.setMemberId(memberIdentity.getMemberId());
		merchInfo.setMemberName(memberIdentity.getName());
		return merchInfo;
	}

	/**
	 * 超级定自动提现功能 ，为商家打款
	 * @param dbOrder
	 * @return
	 */
	@Transactional
	public Long widthDrawByHotel(ImsEweiShopOrder dbOrder){
		BigDecimal prate = getHotelPrate(dbOrder.getMerchid(),dbOrder.getActivityId());
		ImsEweiShopMemberIdentity merchIdentity = checkMerchIdentity((byte)1,(byte)21,(long)dbOrder.getMerchid());
		ImsEweiShopCash cash = new ImsEweiShopCash();
		cash.setOrdersn(com.microsilver.mrcard.common.Utils.createOrderSn("TX"));
		cash.setMerchid((long)dbOrder.getMerchid());
		cash.setMemberid(merchIdentity.getMemberId());
		ImsEweiMemberCard memberCard = getMemberCard(merchIdentity.getMemberId(),merchIdentity.getIdentity());
		if(null != memberCard) {
			cash.setBankname(memberCard.getBankName());
			cash.setBankcard(memberCard.getAccountNumber());
			cash.setTruename(memberCard.getAccountName());
			cash.setType(1);
			cash.setStatus(1);
//		}else{
//			cash.setStatus(5);
//		}
			cash.setCreatetime(DateUtil.getNowDate());
//		DecimalFormat decimalFormat = new DecimalFormat("#.##");
//		decimalFormat.setRoundingMode(RoundingMode.FLOOR);
//		BigDecimal money = dbOrder.getPrice().multiply(prate.divide(new BigDecimal(100)));
			cash.setMoneys(dbOrder.getCostprice());
			cash.setIdentity(21);
			cash.setPayrates(prate.intValue());

			cash.setCashType(1);
			int num = imsEweiShopCashMapper.insertSelective(cash);
			logger.debug("系统生成商户提现流水:" + JSON.toJSONString(cash));
			if (num > 0) {
				WithdrawDto withdraw = new WithdrawDto();
				withdraw.setOrdersn(cash.getId() + "");
				withdraw.setIdentity(cash.getIdentity().shortValue());
				withdraw.setMemberId(cash.getMemberid());
				withdraw.setMerchId(cash.getMerchid());
				withdraw.setMemberName(cash.getTruename());
				withdraw.setAmount(cash.getMoneys());
				withdraw.setRemark("系统自动提现");
				Long withDrawId = financeRemoteService.withdraw(withdraw);
				logger.info(String.format("系统生成商户提现流水:提现记录编号%s，财务流水编号%s", cash.getId(), withDrawId));
//			cash.setStatus(1);
//			imsEweiShopCashMapper.updateByPrimaryKey(cash);
				return cash.getId();
			}
		}
		return 0L;
	}

	/**
	 * 查询用户银行账户
	 * 自动打款需要默认支付宝账户
	 */
	private ImsEweiMemberCard getMemberCard(Long memberId,Byte identity){
		ImsEweiMemberCardExample example = new ImsEweiMemberCardExample();
		example.createCriteria()
				.andMemberIdEqualTo(memberId).andIdentityEqualTo(identity)
				.andTypeEqualTo((byte)1).andIsDefaultEqualTo(true);
		List<ImsEweiMemberCard> cardList = imsEweiMemberCardMapper.selectByExample(example);
		if(cardList != null && !cardList.isEmpty() && cardList.size() == 1){
			logger.info("查询到用户支付宝账号："+JSON.toJSONString(cardList.get(0)));
			return cardList.get(0);
		}else{
			logger.info("未查询到用户支付宝账号："+memberId+"-"+identity);
		}
		return null;
	}

	/**
	 * 定时检查支付异常的订单，自动进行打款
	 */
	public void autoCashPayToAlipay(){
		ImsEweiShopCashExample example = new ImsEweiShopCashExample();
		example.createCriteria().andStatusEqualTo(4).andCashTypeEqualTo(1).andIdentityEqualTo(21);
		example.setOrderByClause(" id desc ");
		List<ImsEweiShopCash> payList = imsEweiShopCashMapper.selectByExample(example);
		payList.forEach((pay)->{
			try {
				//pay to success ,auto change status = 3 by interface
				String url = SystemProperties.HTTP_PHP_ALIPAYURL + pay.getId();
				String result =  HttpClientUtils.doGet(url);
				logger.info("auto pay 【"+pay.getId()+"】 to  Alipay result :"+result);
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		});
	}

}
