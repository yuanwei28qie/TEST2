package com.microsilver.mrcard.scheduledtask.job;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.microsilver.mrcard.scheduledtask.service.ImsCrowdsourcingOrderService;
import com.microsilver.mrcard.scheduledtask.service.ShopOrderJobService;

/**
 * 订单业务的定时任务
 */
@Component
@Lazy(value = false)
public class OrderJob {

	// 订单业务
	@Autowired
//	private ShopOrderService shopOrderService;
	private ShopOrderJobService shopOrderService;
	
	@Resource
	private ImsCrowdsourcingOrderService crowdsourcingOrderService;

	/************************************************************************/
	/********************** 超级定业务相关job********************************/
	/************************************************************************/


	/**
	 * 订单在有效期内未支付则失效
	 *
	 * 每1分钟检测一次
	 */
	@Scheduled(cron = "${REG_ONE_MINUTE}")//1min
	// @Scheduled(cron = "*/5 * * * * ?")
	public void orderExpireDate() {
		this.shopOrderService.orderExpireDate();
	}

	/**
	 * 超级订订单，当status=1时，paytime超过24小时（24小时可配置），设置status=3，finishtime=系统时间
	 * 系统指定已经入住
	 * @Jade 2017-08-16
	 */
	@Scheduled(cron = "${REG_ONE_HOUR}")
//	@Scheduled(cron = "0 0 0/1 * * ? ")
	public void hotelOrderCheckInHotel() {
		this.shopOrderService.hotelOrderCheckInHotel();
	}

	/**
	 * 超级订“已完成”状态的订单需要预结算
	 *   @time 2017-10-31
	 *   	2.0需求修改-零点半价及时结算-MQ
	 *   				超级特价入住后结算
	 *
	 * 每小时检测一次
	 */
	// @Scheduled(cron = "0 0 */1 * * ?")
//	@Scheduled(cron = "0 0 0/1 * * ? ")
	// @Scheduled(cron = "0 0/2 * * * ?")
	@Scheduled(cron = "${REG_ONE_HOUR}")
	public void hotelOrderSettlement() {
		this.shopOrderService.hotelOrderPreSettlement();
	}


	/**
	 * 结算订单
	 * 	V1.0
	 * 超级定  3天 结算
	 * 卡先生  7天 结算
	 *	V2.0
	 * 废弃卡先生功能
	 * 零点半价及时结算-MQ
	 * 超级特价入住后结算
	 * 每小时检测一次
	 */
	//2017-09-20 @Jade 根据要求关闭卡先生所有定时任务
	@Scheduled(cron = "${REG_ONE_HOUR}")
//	@Scheduled(cron = "0 0 0/1 * * ? ") // 1h
	public void orderSettlementCommit() {
		this.shopOrderService.OrderSettlement();
	}


	/**
	 * @Jade
	 * @Date 2017-10-31
	 * @version 2.0
	 * @Description 超级特价订单-MQ自动结算及及时打款
	 * 		打款失败的订单-进入异常处理流程
	 * 	检测打款失败并需要再次打款的订单，自动为商家打款
	 */
	@Scheduled(cron = "${REG_ONE_HOUR}")
	public void autoCashPayToAlipay() {
		this.shopOrderService.autoCashPayToAlipay();
	}

	/************************************************************************/
	/********************** 超级定业务相关job end ***************************/
	/************************************************************************/



	/************************************************************************/
	/********************** 小飞侠业务相关job********************************/
	/************************************************************************/

	/**
	 * 取消小飞侠或用户订单
	 * 用户下单超过五分钟没有小飞侠抢单或者协商费用后用户在五分钟之内没有付款 都需要取消订单
	 *
	 * 每分钟检测一次
	 */
	@Scheduled(cron = "${REG_ONE_MINUTE}")
	public void cancleCrowdsourcingOrder() {
		this.crowdsourcingOrderService.cancleCrowdsourcingOrder();
	}


	/**
	 * 超级订-帮我买“已完成”状态的订单需要预结算
	 *
	 * 每分钟检测一次
	 */
	@Scheduled(cron = "${REG_ONE_MINUTE}")
	public void BuyForMePreSettlement() {
		this.shopOrderService.BuyForMePreSettlement();
	}

	/**
	 * 每周四进行 帮我买上周订单结算并生成结转单
	 */
	@Scheduled(cron = "${REG_CARRYOVER}") // 周四 0 30 0/1 * * 4
	public void knightSettlementCommit() {
		this.shopOrderService.KnightSettlement();
	}



	/************************************************************************/
	/********************** 小飞侠业务相关job end ***************************/
	/************************************************************************/



	/************************************************************************/
	/********************** 卡先生业务相关job********************************/
	/************************************************************************/

	/**
	 * 卡先生订单和面对面支付“已完成”状态的订单需要预结算
	 *
	 * 每小时检测一次
	 */
	//2017-09-20 @Jade 根据要求关闭卡先生所有定时任务
	// @Scheduled(cron = "0 0 */1 * * ?")
//	@Scheduled(cron = "0 0 0/1 * * ? ") // 1h
//	 @Scheduled(cron = "${REG_ONE_MINUTE}")// 1m
	public void orderSettlement() {
		this.shopOrderService.cardOrderPreSettlement();
	}

	/**
	 * 结算订单
	 * 卡先生  7天 结算
	 *
	 * 每小时检测一次
	 *  此功能与超级定订单结算功能合并为一个
	 * @see shopOrderService.OrderSettlement()
	 */
/*	//2017-09-20 @Jade 根据要求关闭卡先生所有定时任务
	@Scheduled(cron = "${REG_ONE_HOUR}")
//	@Scheduled(cron = "0 0 0/1 * * ? ") // 1h
	public void orderSettlementCommit() {
		this.shopOrderService.OrderSettlement();
	}*/

	/************************************************************************/
	/********************** 卡先生业务相关job end ***************************/
	/************************************************************************/


}
