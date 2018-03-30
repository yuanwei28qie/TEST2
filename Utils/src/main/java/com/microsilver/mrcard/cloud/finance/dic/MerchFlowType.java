package com.microsilver.mrcard.cloud.finance.dic;

/**
 * @author Jade
 * @Description 客户财务流水类型
 * 类型
(
1:销售收入,
2:销售分层收入,
11:充值,
21:代理费收入
22:代理费分层
4,
6,平台返现
51:提现
61:系统退款
)
 * @create 2017-07-31 下午 3:53
 * @Copyright Micro Silver
 **/
public enum MerchFlowType {
    /**
     * @Update 2017-08-01
     * 修改类型：1 订单流水（销售收入），5 提现流水,51提现流水【系统】
     */
    SALE(1),BOUND_SALE(2),BUY(4),RECHARGE(11),AGENT(21),BOUND_AGENT(22),WITHDRAW(5),WITHDRAWSYS(51),REWARD(6),REFUND(61);
    private int value;
    private MerchFlowType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static MerchFlowType getEnumValue(int index){
        return SALE;
    }
}
