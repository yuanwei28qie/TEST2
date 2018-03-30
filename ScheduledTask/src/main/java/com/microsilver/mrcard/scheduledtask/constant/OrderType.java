package com.microsilver.mrcard.scheduledtask.constant;

/**
 * 1.卡先生订单 2.面对面支付 3.超级订订单
 *
 */
public interface OrderType {
	// 卡先生订单
	Byte CARD = 1;

	// 面对面支付 
	Byte FACE_PAY = 2;

	// 超级订订单
	Byte SUPER_BOOK = 3;
	// 超级订订单-伪类型
	Byte SUPER_KNIGHT = 4;
}
