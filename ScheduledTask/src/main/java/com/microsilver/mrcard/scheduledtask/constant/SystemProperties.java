package com.microsilver.mrcard.scheduledtask.constant;

import com.microsilver.mrcard.common.SystemConfig;

/**
 * Created by Jade on 2017/8/16.
 */
public class SystemProperties {

    /**
     * 检查用户是否入住酒店
     */
    public static int SYS_CHECK_IN_HOURS = com.microsilver.mrcard.common.SystemConfig.getIntValue("CHECK_IN_HOURS");
    /**
     * 超级特价过期时间
     */
    public static int SYS_CHECK_SUPER_DISCOUNT = com.microsilver.mrcard.common.SystemConfig.getIntValue("CHECK_SUPER_DISCOUNT");
    /**
     * 零点半价过期时间
     */
    public static int SYS_CHECK_HALF_OFF = com.microsilver.mrcard.common.SystemConfig.getIntValue("CHECK_HALF_OFF");
    /**
     * 小飞侠订单未抢时过期时间
     */
    public static int LITTLE_WING_EXPIRE = com.microsilver.mrcard.common.SystemConfig.getIntValue("LITTLE_WING_EXPIRE");
    /**
     * 小飞侠订单未付款过期时间
     */
    public static int LITTLE_WING_UNPAY_EXPIRE = com.microsilver.mrcard.common.SystemConfig.getIntValue("LITTLE_WING_UNPAY_EXPIRE");

    /**
     * 超级特价分值
     */
    public static int SUPER_DISCOUNT = com.microsilver.mrcard.common.SystemConfig.getIntValue("SUPER_DISCOUNT");
    /**
     * 零点半价分值
     */
    public static int HALF_OFF = com.microsilver.mrcard.common.SystemConfig.getIntValue("HALF_OFF");
    /**
     * 红包返现分值
     */
    public static int RED_PACKET = com.microsilver.mrcard.common.SystemConfig.getIntValue("RED_PACKET");
    /**
     * 有房间分值
     */
    public static int NOT_SOLDOUT = com.microsilver.mrcard.common.SystemConfig.getIntValue("NOT_SOLDOUT");
    /**
     * 推荐商家分值
     */
    public static int MERCH_RECOMMEND=50;
    /**
     * 五星酒店分值
     */
    public static int FIVE_STAR_HOTEL = -80;
    /**
     * 酒店优惠分值
     */
    public static int MERCH_DISCOUNT = 10;
    /**
     * http远程连接服务器地址
     */
    public static String HTTP_URL = com.microsilver.mrcard.common.SystemConfig.getValue("HTTP_URL");
    
	/**
	 * 融云APP_KEY
	 */
	public static final String RONGCLOUD_APP_KEY = SystemConfig.getValue("RONGCLOUD_APP_KEY");
	/**
	 * 融云APP_SECRET
	 */
	public static final String RONGCLOUD_APP_SECRET = SystemConfig.getValue("RONGCLOUD_APP_SECRET");
	/**
	 * 融云服务地址
	 */
	public static final String RONGCLOUD_URL = SystemConfig.getValue("RONGCLOUD_URL");	
	/**
	 * 融云获取token
	 */
	public static final String RONGCLOUD_GETTOKEN = SystemConfig.getValue("RONGCLOUD_GETTOKEN");
	/**
	 * 检查用户是否在线接口
	 */
	public static final String RONGCLOUD_CHECKONLINE = SystemConfig.getValue("RONGCLOUD_CHECKONLINE");
	/**
	 * 发送系统消息方法
	 */
	public static final String RONGCLOUD_SYSTEMPUBLISH = SystemConfig.getValue("RONGCLOUD_SYSTEMPUBLISH");

	/**
	 * PHP支付宝接口
	 */
	public static final String HTTP_PHP_ALIPAYURL = SystemConfig.getValue("HTTP_PHP_ALIPAYURL");

	/**
	 * VIP推荐合伙人
	 */
	public static final int VIP_TO_PANTER_LEVEL1 = SystemConfig.getIntValue("VIP_TO_PANTER_LEVEL1_SELLING");
	public static final int VIP_TO_PANTER_LEVEL2 = SystemConfig.getIntValue("VIP_TO_PANTER_LEVEL2_SELLING");
	/**
	 * 会员推荐会员
	 */
	public static final int MEMBER_TO_MEMBER = SystemConfig.getIntValue("MEMBER_TO_MEMBER_SELLING");
	/**
	 * VIP推荐会员
	 */
	public static final int VIP_TO_MEMBER = SystemConfig.getIntValue("VIP_TO_MEMBER_SELLING");
	/**
	 * 高级合伙人推荐会员
	 * 原20改为40
	 * 2018.03.13
	 */
	public static final int VP_TO_MEMBER = 40;
	/**
	 * 超级合伙人推荐会员
	 */
	public static final int SVP_TO_MEMBER = 10;
	
	
	public static final int VIP_TO_CHAOVIP_LEVEL1 = SystemConfig.getIntValue("VIP_TO_CHAOVIP_LEVEL1_SELLING");
	
	public static final int VIP_TO_CHAOVIP_LEVEL2 = SystemConfig.getIntValue("VIP_TO_CHAOVIP_LEVEL2_SELLING");
	/**
	 * 推荐会员消费分润
	 */
	public static final short RECOMMEND_MEMBER_ORDER = 20;
}
