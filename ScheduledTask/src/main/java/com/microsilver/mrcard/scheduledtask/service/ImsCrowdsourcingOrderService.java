package com.microsilver.mrcard.scheduledtask.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.HttpClientUtils;
import com.microsilver.mrcard.mq.ExtraContent;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.scheduledtask.constant.RongCloud;
import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import com.microsilver.mrcard.scheduledtask.dao.ImsCrowdsourcingOrderMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMemberDeviceMapper;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrderExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberDevice;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberDeviceExample;
import com.microsilver.mrcard.scheduledtask.model.RespBaseDto;
import com.microsilver.mrcard.scheduledtask.utils.DateUtil;

@Service
public class ImsCrowdsourcingOrderService extends BaseService{

	@Resource
	ImsCrowdsourcingOrderMapper crowdsourcingOrderMapper;
	@Resource
	ImsCrowdsourcingOrderLogService imsCrowdsourcingOrderLogService;
	@Resource
	ImsEweiShopMemberDeviceMapper deviceMapper;
	@Resource
	MQService mqService;

	public ImsCrowdsourcingOrder selectByPrimaryKey(Long id){
		return crowdsourcingOrderMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void cancleCrowdsourcingOrder() {
		Date now = new Date();
		int expireMinutes = SystemProperties.LITTLE_WING_EXPIRE;
		Date expireTime = DateUtil.addMinutes(now, -expireMinutes);
		ImsCrowdsourcingOrderExample example = new ImsCrowdsourcingOrderExample();
		example.createCriteria().andStatusEqualTo((byte)1)//已创建状态
		.andCreateTimeLessThanOrEqualTo(DateUtil.dateToSecond(expireTime));
		List<ImsCrowdsourcingOrder> listOrders = crowdsourcingOrderMapper.selectByExample(example);
		for (ImsCrowdsourcingOrder order : listOrders) {
			order.setStatus((byte)0);
			int result = crowdsourcingOrderMapper.updateByPrimaryKeySelective(order);
			if(result==1) {
				result = imsCrowdsourcingOrderLogService.addLog(order);				
			}
			logger.info(String.format("订单:%s取消成功,", order.getId()));
			pushMessageToClient(order,(byte)1);
		}
		
		expireMinutes = SystemProperties.LITTLE_WING_UNPAY_EXPIRE;
		expireTime = DateUtil.addMinutes(now, -expireMinutes);
		example = new ImsCrowdsourcingOrderExample();
		example.createCriteria().andStatusEqualTo((byte)3).andOperateStatusEqualTo((byte)3)
		.andOperateTimeLessThanOrEqualTo(DateUtil.dateToSecond(expireTime));
		listOrders=crowdsourcingOrderMapper.selectByExampleWithOrderLog(example);
		for (ImsCrowdsourcingOrder order : listOrders) {
			order.setStatus((byte)0);
			int result = crowdsourcingOrderMapper.updateByPrimaryKeySelective(order);
			if(result==1) {
				result = imsCrowdsourcingOrderLogService.addLog(order);				
			}
			logger.info(String.format("订单:%s取消成功,", order.getId()));
			pushMessageToClient(order,(byte)3);
		}
	}
	
	public void pushMessageToClient(ImsCrowdsourcingOrder order,Byte orderStatus) {
		Long id = order.getId();
		Long memberId = order.getMemberId();
		Long courier = order.getCourier();
		logger.info(JSON.toJSONString(order));
		if(memberId != null) {
			boolean online = RongCloud.checkOnline(memberId+""+0)==1;
			if(online) {
				int publishResult = RongCloud.systemPublish(memberId+"0", id);
				if(publishResult==200) {
					logger.info(String.format("已给用户:%s发送消息;",memberId));
				}
			}else {
				sendJpush(memberId,id, (byte)0,(byte)4,orderStatus);//APP类型 1:卡先生消费者版本 2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠
			}
		}
		if(courier != null) {
			boolean online = RongCloud.checkOnline(courier+""+13)==1;
			if(online) {
				int publishResult = RongCloud.systemPublish(courier+"13", id);
				if(publishResult==200) {
					logger.info(String.format("已给骑士:%s发送消息.",courier));
				}
			}else {
				sendJpush(courier,id,(byte)13,(byte)5,orderStatus);
			}
		}
	}
	
	public void sendJpush(Long memberId,Long orderId,Byte identity,Byte appType,Byte orderStatus) {
		ImsEweiShopMemberDeviceExample example = new ImsEweiShopMemberDeviceExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo(identity);
		List<ImsEweiShopMemberDevice> device = deviceMapper.selectByExample(example);
		if(device.size()>=1) {
			PushMsg msg = new PushMsg();
			ExtraContent content = new ExtraContent();
			content.setMsgId(orderId+"");
			content.setMsgType(200);
			content.setStatus(0);
			msg.setContent(content);
			msg.setDevice(device.get(0).getDevice());
			msg.setPushType(0);
			msg.setRegistration(device.get(0).getRegistration());
			msg.setAppType(appType);
			if(5 == appType) {
				msg.setTitle("买家支付超时，订单已经被取消啦。重新去寻找任务吧！");
			}else if(4==appType){
				if(orderStatus==1)
					msg.setTitle("您的订单暂无骑手骑手接单，已为您自动取消。");
				else
					msg.setTitle("您的订单支付超时，已为您自动取消。");
			}
			RespBaseDto result = mqService.pushMessageToMQForFeign(msg);
			if(result.getState()==0) {
				logger.info(String.format("Jpush已给%s推送消息;",memberId));
			}
			
//			Map<String,String> map = new HashMap<String,String>();
//			map.put("registration", device.get(0).getRegistration());
//			map.put("device", device.get(0).getDevice()+"");
//			map.put("pushType", "0");//// 推送消息种类 0 JPUSH / 1 短信 / 2 JPUSH和短信
//			if(5 == appType) {
//				map.put("title", "买家支付超时，订单已经被取消啦。重新去寻找任务吧！");
//			}else if(4==appType){
//				if(orderStatus==1)
//					map.put("title","您的订单暂无骑手骑手接单，已为您自动取消。");
//				else
//					map.put("title","您的订单支付超时，已为您自动取消。");
//			}
//			map.put("content.msgId", orderId+"");
//			map.put("content.msgType", "200");
//			map.put("content.status", "0");
//			map.put("appType",""+appType);//APP类型 1:卡先生消费者版本 2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠
//			String doPost = HttpClientUtils.doPost(SystemProperties.HTTP_URL+"/api/Common/pushMessageToMQ", map,null);
//			Map result = JSON.parseObject(doPost, Map.class);
//			if(result.containsKey("state")){
//				Object object = result.get("state");
//				if(object instanceof Integer && (Integer)object == 0){
//					logger.info(String.format("Jpush已给%s推送消息;",memberId));
//				}
//			}	
		}
	
	}
}
