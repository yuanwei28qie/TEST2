package com.microsilver.mrcard.serviceplatform.common;

import com.microsilver.mrcard.common.SystemConfig;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.common.Consts
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年6月29日 下午1:58:04
 * @Copyright Micro Silver
 *
 */
public class Consts {
	/**
	 * 是否对APP进行token检查 
	 */
	public static final boolean CHECK_TOKEN = SystemConfig.getBooleanValue("CHECK_TOKEN");
	
	public static final String XIAO_FEI_XIA_DES_KEY = SystemConfig.getValue("XIAO_FEI_XIA_DES_KEY");
	/**
	 * token秘钥 
	 */
	public static final String APP_TOKEN_DES_KEY = SystemConfig.getValue("APP_TOKEN_DES_KEY");
	/**
	 * 短信Key
	 */
	public static final String JUHE_APPKEY = SystemConfig.getValue("JUHE_APPKEY");
	/**
	 * 订单分拣状态
	 */
	public static final int ORDER_STATUS_SORTING = 11;
	/**
	 * 订单(快递员)抢单状态
	 */
	public static final int ORDER_STATUS_FETCH = 12;
	/**
	 * 商家已发货
	 */
	public static final int ORDER_STATUS_SEND = 2;
	/**
	 * 买家已收货
	 */
	public static final int ORDER_STATUS_RECIEVE = 3;
	/**
	 * 买家已付款
	 */
	public static final int ORDER_STATUS_PAY = 1;
	/**
	 * 订单已取消
	 */
	public static final int ORDER_STATUS_CANCLE = 5;

	/**
	 * 订单类型 1.卡先生订单 2.面对面支付 3.超级订订单
	 */
	public static final int ORDER_TYPE_SUPER = 3;
	
	/**
	 * 商品状态 0 下架 1 上架 2 审核不通过
	 */
	public static final byte GOODS_STATUS_UNDERCARRIAGE = 0;
	public static final byte GOODS_STATUS_ONSALE = 1;
	public static final byte GOODS_STATUS_CHECKEDFAILED = 2;
	
	
	/**
	 * 审核状态(1:待审核,0:已审核)
	 */
	public static final byte GOODS_CHECKED_AUDIT = 1;
	public static final byte GOODS_CHECKED_PASS = 0;
	
	/**
	 * 删除
	 */
	public static final byte GOODS_DELETED_YES = 1;
	public static final byte GOODS_DELETED_NO = 0;
	
	/**
	 * activity类型 1.超级订 2.超级特价
	 */
	public static final byte ACTIVITY_TYPE_SUPER= 1;
	public static final byte ACTIVITY_TYPE_DISCOUNT= 2;


	
	/**
	 * 短信校验码有效时间 
	 */
	public static final int CHECK_CODE_EFFECTIVE_MINUTE = SystemConfig.getIntValue("CHECK_CODE_EFFECTIVE_MINUTE");
	
	public static final int TOKEN_EFFECTIVE_SECOND = SystemConfig.getIntValue("TOKEN_EFFECTIVE_SECOND");
	/**
	 * 有效IP，无效校验token
	 */
	public static final String EFFECTIVE_IP = SystemConfig.getValue("EFFECTIVE_IP");
	
	public static final int PAGE_SIZE = SystemConfig.getIntValue("PAGE_SIZE");
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
	 * 百度地图小飞侠服务端APP_AK
	 */
	public static final String BAIDUMAP_APP_AK=SystemConfig.getValue("BAIDUMAP_APP_AK");
	/**
	 * 百度地图BASE_URL
	 */
	public static final String BAIDUMAP_BASE_URL=SystemConfig.getValue("BAIDUMAP_BASE_URL");
	/**
	 * 百度地图获取路线规划距离和行驶时间
	 */
	public static final String BAIDUMAP_ROUTEMATRIX=SystemConfig.getValue("BAIDUMAP_ROUTEMATRIX");	
	
	/**
	 * 小飞侠骑手与买家订单的最远距离
	 */
	public static final Integer ORDER_DISTANCE=SystemConfig.getIntValue("ORDER_DISTANCE");	
	/**
	 * 合伙人费用
	 */
	public static final String PARTNER_COST = SystemConfig.getValue("PARTNER_COST");
	
	public static final String HTTP_PHP_ALIPAYURL = SystemConfig.getValue("HTTP_PHP_ALIPAYURL");
	
	
	public static final String SENIOR_PANTER_COST = SystemConfig.getValue("SENIOR_PANTER_COST");
	public static final String SUPER_PANTER_COST = SystemConfig.getValue("SUPER_PANTER_COST");
	
	public static final String VIP_MEMBER_COST = SystemConfig.getValue("VIP_MEMBER_COST");
	/*
	 * 合伙人当前批次
	 */
	public static final int PARTER_CURRENT_BATCH=2;
	/**
	 * 超级合伙人区域数量限制
	 */
	public static final int SVP_area_count=35;
	/**
	 * 高级合伙人区域数量限制
	 */
	public static final int SP_AREA_COUNT=10;
	/**
	 * 创业合伙人区域数量限制
	 */
	public static final int VP_AREA_COUNT=100;
	/**
	 * 会员提现不审核金额限制
	 */
	public static final String MEMBER_CASH_NO_CHECK_MAX = "500";
	/**
	 * 会员一天提现金额限制
	 */
	public static final String MEMBER_CASH_LIMIT_FOR_DAY = "2000";
}
