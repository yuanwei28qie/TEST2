package com.microsilver.mrcard.mq;

/**
 * Created by Jade on 2017/8/16.
 */
public enum ExtraMessageType {

    //卡先生订单
    EXTRA_MRCARD_ORDER(101),
    //卡先生提现
    EXTRA_MRCARD_WITHDRAW(102);

    private ExtraMessageType(int value) {
        this.value = value;
    }

    private int value;

    public static ExtraMessageType getEnumValue(int index){
        if(101 == index)
            return EXTRA_MRCARD_ORDER;
        if(102 == index)
            return EXTRA_MRCARD_WITHDRAW;
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
