package com.microsilver.mrcard.serviceplatform.service;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.mq.coordinateMQ;
import com.microsilver.mrcard.serviceplatform.common.BaiduUtils;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.IMemberIdentityDao;
import com.microsilver.mrcard.serviceplatform.dao.ImsCrowdsourcingOrderMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMemberIdentityAdditionalMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrderExample;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrderExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrderLog;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddress;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditional;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditionalExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityExample;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.mq.MQSendMsgHelper;

@Service
public class ImsCrowdsourcingOrderService {

	private final static Logger logger = LoggerFactory.getLogger(ImsCrowdsourcingOrderService.class);

	@Resource
	private ImsCrowdsourcingOrderMapper orderMapper;
	@Resource
	ImsCrowdsourcingOrderLogService imsCrowdsourcingOrderLogService;
	@Resource
	IMemberIdentityDao identityDao;
	@Resource
	private ImsEweiShopMemberIdentityService identityService;

	@Resource
	ImsEweiShopMemberIdentityAdditionalMapper additionalMapper;
	@Resource
	MemberSmpl memberSmpl;
	@Resource
	ImsEweiShopMemberAddressSmpl memberAddress;
	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;
	/**
	 * 创建订单
	 * 
	 * @param crowdsourcingOrder
	 * @return 返回订单号
	 */
	@Transactional
	public Long createOrder(ImsCrowdsourcingOrder crowdsourcingOrder) {

		logger.info("创建订单：{}", JSON.toJSONString(crowdsourcingOrder));

		crowdsourcingOrder.setOrdersn(Utils.createOrderSn("FX"));
		crowdsourcingOrder.setCreateTime(Utils.getCurrentTime());
		crowdsourcingOrder.setStatus((byte) 1);
		orderMapper.insertSelective(crowdsourcingOrder);
		imsCrowdsourcingOrderLogService.addLog(crowdsourcingOrder,null);
		return crowdsourcingOrder.getId();
	}

	/**
	 * 添加 小费
	 * 
	 * @param orderId
	 *            订单号
	 * @param tipPrice
	 *            小费
	 * @return
	 */
	@Transactional
	public Boolean addTipPrice(Long orderId, BigDecimal tipPrice) {

		logger.info("{} 添加小费 {}", orderId, tipPrice);
		ImsCrowdsourcingOrder order = queryOrderById(orderId);
		if (null != order && order.getStatus() == 1) {
			BigDecimal oldPrice = order.getTipPrice();
			BigDecimal newPrice = oldPrice.add(tipPrice);
			order.setTipPrice(newPrice);
			order.setTotalAmount(order.getTotalAmount().add(tipPrice));
			int num = orderMapper.updateByPrimaryKeySelective(order);
			return num > 0 ? true : false;
		} else {
			logger.error("订单号[" + orderId + "]不存在或已取消");
		}
		return false;
	}

	public ImsCrowdsourcingOrder queryOrderById(Long orderId) {
		ImsCrowdsourcingOrder imsCrowdsourcingOrder = orderMapper.selectByPrimaryKey(orderId);
		return imsCrowdsourcingOrder;
	}

	public List<Integer>  queryOrderAddressByMemberId(Long memberId) {
		ImsCrowdsourcingOrderExample example = new ImsCrowdsourcingOrderExample();
		example.setDistinct(true);
		example.createCriteria().andMemberIdEqualTo(memberId);
		example.setOrderByClause(" address_id desc ");
		List<ImsCrowdsourcingOrder> imsCrowdsourcingOrder = orderMapper.selectByExample(example);
		List<Integer> addressList = new ArrayList();
		imsCrowdsourcingOrder.forEach((ad)->addressList.add(ad.getAddressId().intValue()));
		return addressList;
	}

	/**
	 * 分页查询订单
	 * 
	 * @param
	 * @return 返回订单号
	 */
	public PageInfo<ImsCrowdsourcingOrder> queryOrder(Long memberId, Long orderId, Byte status, int pageNum,
			int pageSize) {

		logger.debug("分页查询订单：{}-{}-{}-{}-{}", memberId, orderId, status, pageNum, pageSize);

		ImsCrowdsourcingOrderExample example = new ImsCrowdsourcingOrderExample();

		ImsCrowdsourcingOrderExample.Criteria criteria = example.createCriteria();
		criteria.andUserDeleteEqualTo(false);
		if (null != orderId)
			criteria.andIdEqualTo(orderId);
		if (null != memberId)
			criteria.andMemberIdEqualTo(memberId);
		if (null != status){
			criteria.andStatusEqualTo(status);
		}
		
		example.setOrderByClause(" create_time desc ");

		Page<ImsCrowdsourcingOrder> page = PageHelper.startPage(pageNum, pageSize)
				.doSelectPage(() -> orderMapper.selectByExample(example));
		PageInfo pageInfo = new PageInfo(page);
		return pageInfo;
	}

	/**
	 * 统计已完成订单统计
	 * 
	 * @param memberId
	 * @param today 是否只查询当日订单
	 * @return
	 */
	ImsCrowdsourcingOrder selectTodayDetails(Long memberId,Boolean today) {
		ImsCrowdsourcingOrderExample orderExample = new ImsCrowdsourcingOrderExample();
		Criteria criteria = orderExample.createCriteria().andStatusEqualTo((byte) 6) // 状态(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定）
				.andCourierEqualTo(memberId);
		if(today){
			criteria.andCreateTimeGreaterThanOrEqualTo((int) (Utils.getSomeDay(new Date(), 0).getTime() / 1000))
			.andCreateTimeLessThan((int) (Utils.getSomeDay(new Date(), 1).getTime() / 1000));
		}
		ImsCrowdsourcingOrder order = orderMapper.selectTodayDetails(orderExample);
		return order;
	}

	/**
	 * 骑士获取未完成的订单(包含已完成未评价的订单)
	 * 
	 * @param memberId
	 * @return
	 */
	public List<ImsCrowdsourcingOrder> listUnFinishedOrders(Long memberId) {
		ImsCrowdsourcingOrderExample orderExample = new ImsCrowdsourcingOrderExample();
		orderExample.createCriteria().andStatusBetween((byte) 2, (byte) 6) // 状态(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定）
				.andCourierEqualTo(memberId).andCourierDeleteEqualTo(false).andCourierAppraiseEqualTo(false);
		List<ImsCrowdsourcingOrder> orders = orderMapper.selectByExample(orderExample);
		return orders;
	}

	/**
	 * 获取未完成订单(用户)
	 * @param memberId
	 * @return
	 */
	public List<ImsCrowdsourcingOrder> listUnFinishedOrderByKnight(Long memberId) {
		ImsCrowdsourcingOrderExample orderExample = new ImsCrowdsourcingOrderExample();
		//andUserAppraise设置为false用户没有评价过,andUserDeleteEqualTo;用户是否被删除
		//status;状态(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定）
		orderExample.createCriteria().andUserAppraiseEqualTo(false).andUserDeleteEqualTo(false)
				.andMemberIdEqualTo(memberId).andStatusBetween((byte)1,(byte)5);
		List<ImsCrowdsourcingOrder> orders = orderMapper.selectByExample(orderExample);
		return orders;
	}

	/**
	 * 获取我的今日订单
	 * 
	 * @param memberId
	 * @param status
	 * @param pageNum
	 * @param today
	 * @return
	 */
	public List<ImsCrowdsourcingOrder> listMyOrders(Long memberId, Byte status, Integer pageNum,Boolean today) {
		ImsCrowdsourcingOrderExample orderExample = new ImsCrowdsourcingOrderExample();
		Criteria c = orderExample.createCriteria() // 状态(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定）
				.andCourierEqualTo(memberId).andCourierDeleteEqualTo(false);
		if (status != -2) {// 所有
			c.andStatusEqualTo(status);
		}
		if(today){
			c.andCreateTimeGreaterThanOrEqualTo((int) (Utils.getSomeDay(new Date(), 0).getTime() / 1000))
			.andCreateTimeLessThan((int) (Utils.getSomeDay(new Date(), 1).getTime() / 1000));
		}
		orderExample.setOrderByClause(" create_time DESC ");
		if (pageNum != null) {
			PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		}
		List<ImsCrowdsourcingOrder> orders = orderMapper.selectByExample(orderExample);
		return orders;
	}

	/**
	 * 待抢订单
	 * 
	 * @return
	 */
	public List<ImsCrowdsourcingOrder> ordering(String lat, String lng, Integer pageNum) {
		ImsCrowdsourcingOrderExample orderExample = new ImsCrowdsourcingOrderExample();
		orderExample.setLat(lat);
		orderExample.setLng(lng);
		orderExample.setDistance(Consts.ORDER_DISTANCE);
		orderExample.createCriteria().andStatusEqualTo((byte) 1);
		PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		return orderMapper.selectByExampleWithLocation(orderExample);
	}

	/**
	 *骑士抢单 
	 * @param memberId
	 * @param orderId
	 * @return
	 */
	@Transactional
	public int takeOrder(Long memberId, Long orderId) {
		//如果是骑士 查看是否被禁用
		List<ImsEweiShopMemberIdentity> shopMemberIdentity = identityService.getShopMemberIdentity(memberId);
		if(shopMemberIdentity.size()==0){
			throw new BusinessException(EWarning.ErrorIdentity);
		}
		ImsEweiShopMemberIdentity identity = shopMemberIdentity.get(0);
		if(identity.getStatus()==2){
			throw new BusinessException(EWarning.DisableAccount);
		}
		if(identity.getStatus()==0||identity.getStatus()==3){
			throw new BusinessException(EWarning.ErrorStatus);
		}
		
		// 未完成的订单(包含已完成未评价的订单)
		List<ImsCrowdsourcingOrder> orders = this.listUnFinishedOrders(memberId);
		if (orders.size() > 0) {
			throw new BusinessException(EWarning.UnfinishedOrder);
		}
		
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKeyForUpdate(orderId);
		int result = 0;
		if(order.getStatus()==1){
			order.setCourier(memberId);
			order.setStatus((byte)2);
			/**
			 * 做数据权限
			 * 	添加代理属性到订单中
			 * @Jade 2017-09-27
			 * rows 4
			 */
			Long [] parentProxy = identityService.parentIdentityArray(order.getCourier(),0,(byte)13);
			order.setProvinceAgentIdttId(parentProxy[0]);
			order.setCityAgentIdttId(parentProxy[1]);
			order.setCountyAgentIdttId(parentProxy[2]);
			result = orderMapper.updateByPrimaryKeySelective(order);
			if(result==1){
				result = imsCrowdsourcingOrderLogService.addCourierLog(order,null);
			}
		}else {
			throw new BusinessException(EWarning.Too_Slow);
		}
		return result;
	}

	/**
	 *  设置协商价格
	 * @param orderId
	 * @param goodsConsultPrice
	 * @return
	 */
	@Transactional
	public int setGoodsConsultPrice(Long orderId, Double goodsConsultPrice) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKeyForUpdate(orderId);
		if(order.getStatus()!=2){
			logger.debug("当前订单状态应为:2;实际状态{}",order.getStatus());
			throw new BusinessException(EWarning.Order_ErrorStatus);
		}
		
		order.setGoodsConsultPrice(new BigDecimal(goodsConsultPrice));
		BigDecimal dispatchPrice = order.getDispatchPrice();
		BigDecimal tipPrice = order.getTipPrice();
		BigDecimal goodsConsultPrice2 = order.getGoodsConsultPrice();
		order.setTotalAmount(dispatchPrice.add(tipPrice).add(goodsConsultPrice2));
		order.setStatus((byte)3);
		int result = orderMapper.updateByPrimaryKeySelective(order);
		logger.debug("更新订单状态{}",JSON.toJSONString(order));
		if(result==1){
			result = imsCrowdsourcingOrderLogService.addCourierLog(order,null);
		}
		return result;
	}

	/**
	 * 已买到商品
	 * @param orderId
	 * @return
	 */
	@Transactional
	public int buyGoods(Long orderId) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKeyForUpdate(orderId);
		if(order.getStatus()!=4){
			logger.info("当前订单状态应为:4;实际状态{}",order.getStatus());
			throw new BusinessException(EWarning.Order_ErrorStatus);
		}
		order.setStatus((byte)5);
		order.setPickupNumber(Utils.randomIdentifyingCode(4));
		int result = orderMapper.updateByPrimaryKeySelective(order);
		logger.debug("更新订单状态{}",JSON.toJSONString(order));
		if(result==1){
			result = imsCrowdsourcingOrderLogService.addCourierLog(order,null);
		}
		return result;
	}
	
	/**
	 * 配送中
	 * @param orderId 订单号
	 * @param lat 骑士经度
	 * @param lng 骑士纬度
	 * @return
	 */
	@Transactional
	public Map<String,String> sending(Long orderId,String lat,String lng) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKey(orderId);
		String receiveLat = order.getReceiveLat();
		String receiveLng = order.getReceiveLng();
		
		boolean flag = true; //判断下面是否需要更新身份附加信息表的经纬度
		Long courier = order.getCourier();
		ImsEweiShopMemberIdentityAdditionalExample example = new ImsEweiShopMemberIdentityAdditionalExample();
		example.createCriteria().andMemberIdEqualTo(courier).andIdentityEqualTo((byte)13);
		List<ImsEweiShopMemberIdentityAdditional> additionals = additionalMapper.selectByExample(example);
		if(additionals.size()!=1) {
			logger.info("身份附加信息记录异常");
			throw new RuntimeException();
		}
		ImsEweiShopMemberIdentityAdditional additional = additionals.get(0);
		//如果没传经纬度,那么取骑士身份附加信息表里面的经纬度
		if(lat==null||lng==null) {
			flag = false;
			lat = additional.getLat();
			lng = additional.getLng();
		}
		
		if(flag) {
			coordinateMQ coordinate = new coordinateMQ();
			coordinate.setMemberId(courier);
			coordinate.setLat(lat);
			coordinate.setLng(lng);
			coordinate.setIdentity((byte)13);
			mqsendMsgHelper.coordinateMSG(coordinate);
//			additional.setLat(lat);
//			additional.setLng(lng);
//			additionalMapper.updateByPrimaryKeySelective(additional);
			logger.info("已更新骑士"+courier+"的经纬度");
		}
		
		//调用百度地图接口计算距离与时间
		Map<String, String> map = BaiduUtils.calDistanceAndTime(lat+","+lng, receiveLat+","+receiveLng);
		if(map == null) {
			throw new RuntimeException();
		}
		map.put("lat", lat);
		map.put("lng", lng);
		String time = map.get("time");
		int addTime = Integer.parseInt(time)+60*10;//基础时间上加上10分钟
		long endTime = Utils.getCurrentTime()+addTime;
		Calendar calendar = Utils.getCalendar(new Date(endTime*1000));
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		map.put("seconds",addTime/60+"");
		if(minute<10) {
			map.put("time", hour+":0"+minute);			
		}else {
			map.put("time", hour+":"+minute);			
		}
		Long addressId = order.getAddressId();
		ImsEweiShopMemberAddress shopMemberAddress = memberAddress.queryByAddressId(addressId.intValue());
		StringBuilder sb = new StringBuilder();
		sb.append(shopMemberAddress.getProvince()).append(shopMemberAddress.getCity())
		.append(shopMemberAddress.getArea()).append(shopMemberAddress.getStreet());
		map.put("receiveAddress",sb.toString());
		map.put("address",shopMemberAddress.getAddress());
		map.put("orderId", orderId+"");
		return map;
	}
	
	/**
	 * 用户已收货
	 * @param orderId
	 * @param pickupNumber
	 * @return
	 */
	@Transactional
	public int receiveGoods(Long orderId, String pickupNumber) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKeyForUpdate(orderId);
		if(order.getStatus()!=5){
			logger.info("当前订单状态应为:5;实际状态{}",order.getStatus());
			throw new BusinessException(EWarning.Order_ErrorStatus);
		}
		String pickupNumber2 = order.getPickupNumber();
		int result = 0;
		if(pickupNumber != null && pickupNumber.equals(pickupNumber2)){
			order.setStatus((byte)6);
			result = orderMapper.updateByPrimaryKeySelective(order);
			logger.debug("更新订单状态{}",JSON.toJSONString(order));
			if(result==1){
				result = imsCrowdsourcingOrderLogService.addCourierLog(order,null);
			}
		}else{
			throw new BusinessException(EWarning.CheckCodeError);
		}
		return result;
	}

	/**
	 * 获取订单详情
	 * @param orderId
	 * @return
	 */
	public ImsCrowdsourcingOrder getOrderDetails(Long orderId,Long mId) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKey(orderId);
		if(order==null) {
			throw new BusinessException(EWarning.Order_NonExistent);
		}
		Long courier = order.getCourier();
		
		if(mId!=null&&courier!=null&&courier.longValue() != mId.longValue()) {
			throw new BusinessException(EWarning.Too_Slow); 
		}			
		
		Long memberId = order.getMemberId();
		ImsEweiShopMemberIdentityAdditionalExample example = new ImsEweiShopMemberIdentityAdditionalExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo((byte)0);
		List<ImsEweiShopMemberIdentityAdditional> memberAdditional = additionalMapper.selectByExample(example);
		BigDecimal userScore = new BigDecimal(5);
		if(memberAdditional.size()>0){
			userScore = memberAdditional.get(0).getScore();
		}
		order.setUserScore(userScore);
		ImsEweiShopMember user = memberSmpl.selectMemberById(memberId);
		if(user != null && user.getAvatar() != null)
			order.setUserAvatar(user.getAvatar());
		
		if(courier != null) {
			example = new ImsEweiShopMemberIdentityAdditionalExample();
			example.createCriteria().andMemberIdEqualTo(courier).andIdentityEqualTo((byte)13);
			memberAdditional = additionalMapper.selectByExample(example);
			BigDecimal courierScore = new BigDecimal(5);
			if(memberAdditional.size()>0){
				courierScore = memberAdditional.get(0).getScore();
			}
			order.setCourierScore(courierScore);

			ImsCrowdsourcingOrder ord = this.selectTodayDetails(courier, false);		
			Integer total = ord.getCreateTime(); //获取骑士历史已完成订单数
			if(total==null)total=0;
			order.setCourierTotalFinished(total);
			//获取骑士详情
			ImsEweiShopMember shopMember = memberSmpl.selectMemberById(courier);
			if(null != shopMember ) {
				String avatar = shopMember.getAvatar();
				String realname = shopMember.getRealname();
				String mobile = shopMember.getMobile();
				if (null != avatar)
					order.setCourierAvatar(avatar);
				if (null != realname)
					order.setCourierRealname(realname);
				if (null != mobile)
					order.setCourierMobile(mobile);
			}
		}
		//设置订单当前状态下的操作时间
		Byte status = order.getStatus();
		if(status != null && status != 1) {
			ImsCrowdsourcingOrderLog log = imsCrowdsourcingOrderLogService.getLogsByIdAndStatus(orderId, status);
			if(log!=null) {
				order.setCreateTime(log.getOperateTime());
			}else {
				throw new BusinessException(EWarning.Order_LogException);
			}
		}
		return order;
	}

	/**
	 * 锁定订单 禁用骑士
	 * @param orderId
	 * @return
	 */
	@Transactional
	public int lockOrder(Long orderId) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKeyForUpdate(orderId);
		if(order.getStatus()!=5){
			logger.info("当前订单状态应为:5;实际状态{}",order.getStatus());
			throw new BusinessException(EWarning.Order_ErrorStatus);
		}
		order.setStatus((byte)-1);
		int result = orderMapper.updateByPrimaryKeySelective(order);
		logger.debug("更新订单状态{}",JSON.toJSONString(order));
		if(result==1){
			result = imsCrowdsourcingOrderLogService.addCourierLog(order,null);
		}
		if(result==1){
			ImsEweiShopMemberIdentityExample example = new ImsEweiShopMemberIdentityExample();
			example.createCriteria().andMemberidEqualTo(order.getCourier()).andIdentityEqualTo((byte)13).andMerchidEqualTo(0l);		
			ImsEweiShopMemberIdentity memberIdentity = new ImsEweiShopMemberIdentity();			
			memberIdentity.setStatus((byte)2);
			result = identityDao.updateByExampleSelective(memberIdentity, example);	
			logger.info("骑士{}被禁用",order.getCourier());
		}
		return result;
	}
	
	/**
	 * 取消订单
	 * @param orderId 订单id
	 * @param who 由谁取消1.用户 2.骑士
	 * @return
	 */
	public int cancleOrder(Long orderId,String reason,Byte who) {
		ImsCrowdsourcingOrder order = orderMapper.selectByPrimaryKeyForUpdate(orderId);
		if(order.getStatus()>=4&&order.getStatus()<=6) {
			order.setStatus((byte)8);
		}else {
			order.setStatus((byte)0);			
		}
		int result = orderMapper.updateByPrimaryKeySelective(order);
		if(result == 1){
			if(who == 1){
				result = imsCrowdsourcingOrderLogService.addLog(order,reason);				
			}else if(who == 2){
				result = imsCrowdsourcingOrderLogService.addCourierLog(order,reason);				
			}
		}
		return result;
	}

	/**
	 * 重下新订单
	 * @return
	 */
	@Transactional
	public long createNewOrder(Long orderId) {
		ImsCrowdsourcingOrder order = this.queryOrderById(orderId);
		List<ImsCrowdsourcingOrder> orders = listUnFinishedOrderByKnight(order.getMemberId());
		if(orders.size()>0) {
			throw new BusinessException(EWarning.UnfinishedOrder);
		}
		order.setId(null);
		order.setTipPrice(new BigDecimal(0));
		order.setCourier(null);
		order.setCreateTime(Utils.getCurrentTime());
		order.setCourierAppraise(false);
		order.setCourierDelete(false);
		order.setGoodsConsultPrice(null);
		order.setTotalAmount(order.getGoodsEstimatePrice().add(order.getDispatchPrice()));
		order.setUserDelete(false);
		order.setStatus((byte)1);
		order.setPickupNumber(null);
		order.setUserAppraise(false);
		order.setUserDelete(false);
		order.setOrdersn(Utils.createOrderSn("FX"));
		int result = orderMapper.insertSelective(order);
		if(result == 1){
			result = imsCrowdsourcingOrderLogService.addLog(order,null);			
		}
		return order.getId();
	}

	/**
	 * 重下老订单
	 * @return
	 */
	@Transactional
	public int updateOldOrder(Long orderId) {
		ImsCrowdsourcingOrder order = this.queryOrderById(orderId);
		order.setTipPrice(new BigDecimal(0));
		order.setCourier(null);
		order.setCreateTime(Utils.getCurrentTime());
		order.setCourierAppraise(false);
		order.setCourierDelete(false);
		order.setGoodsConsultPrice(null);
		order.setTotalAmount(order.getGoodsEstimatePrice().add(order.getDispatchPrice()));
		order.setUserDelete(false);
		order.setStatus((byte)1);
		order.setPickupNumber(null);
		order.setUserAppraise(false);
		order.setUserDelete(false);		
		int result = orderMapper.updateByPrimaryKeySelective(order);
		if(result == 1){
			order.setStatus((byte)7);
			result = imsCrowdsourcingOrderLogService.addLog(order,null);			
		}
		return result;
	}

	/**
	 * 删除订单
	 * @param orderIds
	 * @param userType
	 * @return
	 */
	public String deleteOrders(String orderIds, Byte userType) {
		String[] orders = orderIds.split(",");
		logger.info("待删除订单 {}", orderIds);
		for (String id : orders) {
			ImsCrowdsourcingOrder order = new ImsCrowdsourcingOrder();
			order.setId(Long.valueOf(id));
			if(userType==1){
				order.setCourierDelete(true);				
			}else{
				order.setUserDelete(true);
			}
			orderMapper.updateByPrimaryKeySelective(order);
		}
		return "OK";
	}

	public List<ImsCrowdsourcingOrder> selectByLOGStatus(Boolean courierAppraise,Byte settlement,Long courier ,Byte status,Integer beginTime ,Integer endTime){
		return orderMapper.selectByLOGStatus(courierAppraise, settlement,courier, status, beginTime, endTime);
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
		int num = this.orderMapper.updateByPrimaryKeySelective(updateParam);
		logger.info("订单状态更新"+orderId);
		return num >0 ? true : false;
	}

}
