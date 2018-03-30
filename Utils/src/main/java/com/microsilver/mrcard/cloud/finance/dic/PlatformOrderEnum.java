package com.microsilver.mrcard.cloud.finance.dic;

/**
 * @author Jade
 * @Description 平台订单类型定义
 * 1.卡先生订单 2.面对面支付
 * 3.超级订订单 4,小飞侠
 * @create 2017-08-02 下午 3:53
 * @Copyright Micro Silver
 **/

public enum PlatformOrderEnum {

    MRCARD_ORDER(1),MRCARD_FACE(2),HOTEL_ORDER(3),KNIGHT_ORDER(4),RECOMMEND_ORDER(5);

    private int value;

    private PlatformOrderEnum(int value) {
        this.value = value;
    }

    public static PlatformOrderEnum getEnumValue(int index){
        if(index == 1)
            return MRCARD_ORDER;
        if(index == 2)
            return MRCARD_FACE;
        if(index == 3)
            return HOTEL_ORDER;
        if(index == 4)
            return KNIGHT_ORDER;
        if(index == 5){
            return RECOMMEND_ORDER;
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
