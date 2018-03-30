package com.microsilver.mrcard.scheduledtask.constant;

import com.microsilver.mrcard.common.SystemConfig;

public class AppConstant {

	/**
	 * get from Android
	 * AppKey： f6c2ea9084e9941fe45f6a5e
	 * Master Secret：cea4e677ccd3c3b3d21a8844
	 */

	/**
	 * 
	 * AppKey : ab934008944a1ff9f4c6c46d
	 * Master Secret: 9d793747104df6674d48762c
	 */
	/**
	 * 小飞侠
	 * JPUSH_KEY = "f53053ea5748039608e106c5";
 		JPUSH_MASTERSECRET = "0939ac0b0c2432ab5adc5663";
	 */
	String JPUSH_KEY = "f53053ea5748039608e106c5";
	
	String JPUSH_MASTERSECRET = "0939ac0b0c2432ab5adc5663";

	/**
	 * 卡先生
	 */
	public static final String JPUSH_AppKey_CARD = SystemConfig.getValue("AppKey_CARD");
	public static final String JPUSH_Master_Secret_CARD = SystemConfig.getValue("Master_Secret_CARD");
	/**
	 * 掌柜
	 */
	public static final String JPUSH_AppKey_MASTER = SystemConfig.getValue("AppKey_MASTER");
	public static final String JPUSH_Master_Secret_MASTER = SystemConfig.getValue("Master_Secret_MASTER");
	/**
	 * 小飞侠
	 */
	public static final String JPUSH_AppKey_KNIGHT = SystemConfig.getValue("AppKey_KNIGHT");
	public static final String JPUSH_Master_Secret_KNIGHT = SystemConfig.getValue("Master_Secret_KNIGHT");
	/**
	 * 超级定
	 */
	public static final String JPUSH_AppKey_HOTEL = SystemConfig.getValue("AppKey_HOTEL");
	public static final String JPUSH_Master_Secret_HOTEL = SystemConfig.getValue("Master_Secret_HOTEL");


}
