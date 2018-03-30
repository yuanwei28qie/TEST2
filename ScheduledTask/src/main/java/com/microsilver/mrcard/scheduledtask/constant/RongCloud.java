package com.microsilver.mrcard.scheduledtask.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.HttpClientUtils;

public class RongCloud {
	
	private static Map<String,String> headers = new HashMap<String,String>();
	static{
		headers.put("App-Key", SystemProperties.RONGCLOUD_APP_KEY);
		long currentTimeMillis = System.currentTimeMillis();
		int nonce = new Random().nextInt(10000);	
		headers.put("Nonce", nonce+"");
		headers.put("Timestamp", currentTimeMillis+"");
		headers.put("Signature", DigestUtils.sha1Hex( SystemProperties.RONGCLOUD_APP_SECRET+nonce+currentTimeMillis));
	}
	/**
	 * 融云获取token
	 * @param userId 用户id 最大长度 64 字节。是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
	 * @param name 用户名称，最大长度 128 字节。用来在 Push 推送时显示用户的名称。（必传）
	 * @param portraitUri 用户头像 URI，最大长度 1024 字节。（必传）
	 * @return
	 */
	public static String getToken(String userId,String name,String portraitUri) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("name", name);
		map.put("portraitUri", portraitUri);
		String jsonResult = HttpClientUtils.doPost(SystemProperties.RONGCLOUD_URL+SystemProperties.RONGCLOUD_GETTOKEN, map, headers);
		Map parseObject = JSON.parseObject(jsonResult, Map.class);
		if(parseObject.containsKey("code")) {
			if((int)(parseObject.get("code"))==200) {			 
				Object object = parseObject.get("token");
				return object.toString();
			}
		}
		return null;
	}
	
	/**
	 * 检查用户在线状态
	 * @param userId
	 * @return
	 */
	public static int checkOnline(String userId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		String jsonResult = HttpClientUtils.doPost(SystemProperties.RONGCLOUD_URL+SystemProperties.RONGCLOUD_CHECKONLINE, map, headers);
		//{"code":200,"status":"1"} 1.在线 0.不在线
		Map parseObject = JSON.parseObject(jsonResult, Map.class);
		if(parseObject.containsKey("code")) {
			if((int)(parseObject.get("code"))==200) {			 
				Object object = parseObject.get("status");
				return Integer.parseInt(object.toString());
			}
		}
		return 0;
	}
	
	/**
	 * 发送系统消息方法
	 * @param userId
	 * @return
	 */
	public static int systemPublish(String userId,long orderId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("fromUserId", "0");//系统默认设置为0
		map.put("toUserId", userId);
		map.put("objectName", "RC:TxtMsg");
		Map<String, Object> mapContentData = new HashMap<>();
		mapContentData.put("orderId", orderId+"");
		mapContentData.put("orderStatus", 0+"");	
		Map<String, Object> mapContent = new HashMap<>();
		Map<String, Object> mapContentOwner = new HashMap<>();
		mapContentOwner.put("command", "orderChange");
		mapContentOwner.put("data", mapContentData);
		mapContent.put("content", mapContentOwner);
		mapContent.put("extra", "");		
		map.put("content", JSON.toJSONString(mapContent));

		String jsonResult = HttpClientUtils.doPost(SystemProperties.RONGCLOUD_URL+SystemProperties.RONGCLOUD_SYSTEMPUBLISH, map, headers);
		//{"code":200}
		Map parseObject = JSON.parseObject(jsonResult, Map.class);
		if(parseObject.containsKey("code")) {
			return (int)parseObject.get("code");
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(systemPublish("12013",1));
	}
}
