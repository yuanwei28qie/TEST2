package com.microsilver.mrcard.scheduledtask.service;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.common.JuheMsg;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.scheduledtask.utils.JPushUtil;

import cn.jpush.api.push.PushResult;

@Service
public class MQHandlerService extends BaseService {

	/**
	 * 消息推送
	 * 
	 * @param msg
	 *            消息实体
	 * @return
	 */
	public boolean pushMsg(PushMsg msg) {
		boolean result = false;
		if (msg.getPushType() == 1) {
			return sendSMS(msg);
		} else if (msg.getPushType() == 0) {
			return pushMSG(msg);
		} else if (msg.getPushType() == 2) {
			// JPush 和 短信
			sendSMS(msg);
			pushMSG(msg);
			result = true;
		}
		return result;
	}

	private boolean sendSMS(PushMsg msg){
		boolean result = false;
		// 发短信
		try {
			logger.debug("Go -"+ JSON.toJSONString(msg));
			if(null != msg.getExtraSMS()){
				result = JuheMsg.sendSMS(msg.getPhone(),msg.getTemplateType(),msg.getExtraSMS().ExtraSMSValueByTemplateId(msg.getTemplateType()));
			}else {
				result = JuheMsg.sendCheckCode(msg.getPhone(), msg.getTitle(), msg.getTemplateType() == null ? 0 : msg.getTemplateType());
			}
			logger.debug("Got result - " + result);
		} catch (Exception e) {
			logger.error("Error response from SMS server. Should review and fix it. ", e);
			logger.info("Error Message: " + e.getMessage());
		}
		return result;
	}

	private boolean pushMSG(PushMsg msg) {
		logger.info("推送源数据 ："+JSON.toJSONString(msg));
		JPushClient pushClient = JPushUtil.initJpushClient(msg.getAppType());
		if(null == pushClient){
			logger.error("未知的推送类型,"+ JSON.toJSONString(msg));
			return false;
		}
		PushResult result = null;
		try {
			logger.debug("Go -"+ JSON.toJSONString(msg));
			if (null != msg.getRegistration())
				switch (msg.getDevice()) {
					case 1:
//                        result = pushClient.sendAndroidNotificationWithRegistrationID(msg.getTitle(), msg.getContent(),null, msg.getRegistration());
						PushPayload android = PushPayload.newBuilder().setPlatform(Platform.android())
								.setAudience(Audience.registrationId(msg.getRegistration()))
								.setNotification(Notification.newBuilder()
										.addPlatformNotification(AndroidNotification.newBuilder()
												.setAlert(msg.getTitle())
												.addExtra("extra",JSON.toJSONString(msg.getContent()))
												.build()).build())
								.setMessage(Message.newBuilder().setTitle(msg.getTitle()).setMsgContent(JSON.toJSONString(msg.getContent())).build())
								.build();
						result = pushClient.sendPush(android);
						break;
					case 2:
//                        result = pushClient.sendIosNotificationWithRegistrationID(msg.getTitle(),null , msg.getRegistration());
						PushPayload ios = PushPayload.newBuilder().setPlatform(Platform.ios())
								.setAudience(Audience.registrationId(msg.getRegistration()))
//                                .setNotification(Notification.alert(msg.getTitle()))
								.setNotification((Notification.newBuilder()
										.addPlatformNotification(IosNotification.newBuilder()
												.setAlert(msg.getTitle())
												.setBadge(5)
												.setSound("happy")
												.addExtra("extra",JSON.toJSONString(msg.getContent()))
												.build()).build()))
								.setMessage(Message.newBuilder().setTitle(msg.getTitle()).setMsgContent(JSON.toJSONString(msg.getContent())).build())
								.build();
						result = pushClient.sendPush(ios);
						break;
					default:
				}
			else
//                switch (msg.getDevice()) {
//                    case 1:
//                        result = pushClient.sendAndroidMessageWithAlias(msg.getTitle(), msg.getContent(), msg.getAlias());
//                        break;
//                    case 2:
//                        result = pushClient.sendIosMessageWithAlias(msg.getTitle(), msg.getContent(), msg.getAlias());
//                        break;
//                    default:
//                }
				logger.info("Got result - " + result);
		} catch (APIConnectionException e) {
			logger.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			logger.error("Error response from JPush server. Should review and fix it. ", e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
			logger.info("Msg ID: " + e.getMsgId());
		}
		if(result != null)
			return result.isResultOK();
		return false;
	}
}
