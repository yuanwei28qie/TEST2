package com.microsilver.mrcard.cloud.finance.dic;

/**
 * @Name com.microsilver.mrcard.cloud.finance.dic.AgentType
 * @Description 定义代理类型
 * @Author Jade
 * @Version 2017/8/31
 * @Copyright Micro Silver
 */
public enum AgentType {

    //卡先生代理  超级定商家代理  超级定小飞侠代理
    MRCARD_CARD(1),MRCARD_HOTEL(2),MRCARD_KNIGHT(3);
    private int value;
    private AgentType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static AgentType getEnumValue(int index){
        if(1 == index)
            return MRCARD_CARD;
        if(2 == index)
            return MRCARD_HOTEL;
        if(3 == index)
            return MRCARD_KNIGHT;
        return null;
    }
}
