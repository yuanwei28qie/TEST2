package com.microsilver.mrcard.serviceplatform.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.HttpClientUtils;

public class RongCloud {
	
	private static Map<String,String> headers = new HashMap<String,String>();
	static{
		headers.put("App-Key", Consts.RONGCLOUD_APP_KEY);
		long currentTimeMillis = System.currentTimeMillis();
		int nonce = new Random().nextInt(10000);	
		headers.put("Nonce", nonce+"");
		headers.put("Timestamp", currentTimeMillis+"");
		headers.put("Signature", DigestUtils.sha1Hex( Consts.RONGCLOUD_APP_SECRET+nonce+currentTimeMillis));
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
		String jsonResult = HttpClientUtils.doPost(Consts.RONGCLOUD_URL+Consts.RONGCLOUD_GETTOKEN, map, headers);
		Map parseObject = JSON.parseObject(jsonResult, Map.class);
		if(parseObject.containsKey("code")) {
			if((int)(parseObject.get("code"))==200) {			 
				Object object = parseObject.get("token");
				return object.toString();
			}
		}
		return null;
	}
}
