package com.microsilver.mrcard.cloud.finance.dic;

/**
 * @Name com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType
 * @Description
 * @Author Jade
 * @Version 2017/8/31
 * @Copyright Micro Silver
 */
public enum CommissionFlowType {

    //流水类型(1:销售收入,3:垫付货款)
    SALE_BOUND("订单分润",0),SALE_NONE("订单收入到账",1),SALE_TIP("小费",1),SALE_ADVANCE("商品垫付到账",3),
    SALE_REWARD("平台返现",6),
    VIP_COST("VIP用户缴费",8),
    RECOMMEND_BOUND("推荐用户分润",9);

    // 成员变量
    private String name;
    private int index;

    private CommissionFlowType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (CommissionFlowType c : CommissionFlowType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
