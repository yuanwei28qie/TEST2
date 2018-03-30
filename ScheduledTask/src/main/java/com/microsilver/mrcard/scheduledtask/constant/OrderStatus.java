package com.microsilver.mrcard.scheduledtask.constant;

/**
 * 订单状态 
 */
public interface OrderStatus {
	// 取消状态(交易关闭)
	Byte CLOSE = -1;

	//  待付款
	Byte WAIT_PAY = 0;

	// 已付款，待发货
	Byte WAIT_SEND_GOODS = 1;

	// 已发货
	Byte ALREADY_SEND_GOODS = 2;

	// 已收货
	Byte ALREADY_RECEIVE_GOODS = 3;

	// 退款申请
	Byte REFUND_APPLY = 4;

	// 已取消
	Byte DEAL_CANCEL = 5;

	// 已完成
	Byte ALREADY_FINISH = 6;

	// 商家已捡货
	//Byte CANCEL = 11;

	// 快递员已收单
	//Byte CANCEL = 12;
}
