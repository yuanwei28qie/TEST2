package com.microsilver.mrcard.scheduledtask.utils;

import cn.jiguang.common.ClientConfig;
import com.microsilver.mrcard.scheduledtask.constant.AppConstant;

import cn.jpush.api.JPushClient;

import java.util.HashMap;
import java.util.Map;

public class JPushUtil {
	static Map<Byte,JPushClient> jpushClient ;
	public static JPushClient initJpushClient(Byte appType){
		jpushClient = new HashMap<>();
		if(!jpushClient.containsKey(appType)) {
			ClientConfig clientConfig = ClientConfig.getInstance();
			/**
			 * APP类型 1:卡先生消费者版本 2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠
			 */
			JPushClient config =  null;
			switch (appType){
				case 1:
					//config = new JPushClient(AppConstant.JPUSH_Master_Secret_CARD, AppConstant.JPUSH_AppKey_CARD, null, clientConfig);
					break;
				case 2:
					config = new JPushClient(AppConstant.JPUSH_Master_Secret_MASTER, AppConstant.JPUSH_AppKey_MASTER, null, clientConfig);
					break;
				case 3:
					//config = new JPushClient(AppConstant.JPUSH_Master_Secret_MASTER, AppConstant.JPUSH_AppKey_MASTER, null, clientConfig);
					break;
				case 4:
					config = new JPushClient(AppConstant.JPUSH_Master_Secret_HOTEL, AppConstant.JPUSH_AppKey_HOTEL, null, clientConfig);
					break;
				case 5:
					config = new JPushClient(AppConstant.JPUSH_Master_Secret_KNIGHT, AppConstant.JPUSH_AppKey_KNIGHT, null, clientConfig);
					break;
				default:

			}
			if(config != null) {
				jpushClient.put(appType, config);
			}
		}
		return jpushClient.get(appType);
	}
}
