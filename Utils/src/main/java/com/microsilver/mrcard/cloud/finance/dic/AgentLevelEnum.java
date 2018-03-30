package com.microsilver.mrcard.cloud.finance.dic;

/**
 * @author Jade
 * @Description 超级定代理级别
 * @create 2017-07-31 上午 9:59
 * @Copyright Micro Silver
 **/

public enum AgentLevelEnum {
    /**
     * 平台用户
     */
    USER_PLATFORM(0),
    /**
     * 卡先生代理
     卡先生商户	1
     卡先生全国代理商	2
     卡先生省级代理商	3
     卡先生市级代理商	4
     卡先生县级代理商	5
     卡先生勇士	6
     卡先生合伙人(VIP)	7
     卡先生骑士  8
     */
    MRCARD_MERCH(1),MRCARD_PLATFORM(2),MRCARD_COUNTRY(5),MRCARD_WARRIOR(6),MRCARD_VIP(7),MRCARD_KNIGHT(8),
    /**
     * 超级定代理
     超级订商户	21
     超级订全国代理商	22
     超级订省级代理商	23
     超级订市级代理商	24
     超级订县级代理商	25
     */
    AGENT_MERCH(21),AGENT_PLATFORM(22),AGENT_PROVINCE(23),AGENT_CITY(24),AGENT_COUNTRY(25),AGENT_WARRIOR(26),
    /**
     * 超级定代理
     超级订商户	13
     超级订全国代理商	32
     超级订省级代理商	33
     超级订市级代理商	34
     超级订县级代理商	35
     */
    KNIGHT_SELF(13),KNIGHT_PLATFORM(32),KNIGHT_PROVINCE(33),KNIGHT_CITY(34),KNIGHT_COUNTRY(35);
    private AgentLevelEnum(int value) {
        this.value = value;
    }

    private int value;

    public static AgentLevelEnum getEnumValue(int index){
        if(index == 0)
            return USER_PLATFORM;
        if(index == 1)
            return MRCARD_MERCH;
        if(index == 2)
            return MRCARD_PLATFORM;
        if(index == 5)
            return MRCARD_COUNTRY;
        if(index == 6)
            return MRCARD_WARRIOR;
        if(index == 7)
            return MRCARD_VIP;
        if(index == 8)
            return MRCARD_KNIGHT;

        if(index == 21)
            return AGENT_MERCH;
        if(index == 22)
            return AGENT_PLATFORM;
        if(index == 23)
            return AGENT_PROVINCE;
        if(index == 24)
            return AGENT_CITY;
        if(index == 25)
            return AGENT_COUNTRY;
        if(index == 26)
            return AGENT_WARRIOR;

        if(index == 13)
            return KNIGHT_SELF;
        if(index == 32)
            return KNIGHT_PLATFORM;
        if(index == 33)
            return KNIGHT_PROVINCE;
        if(index == 34)
            return KNIGHT_CITY;
        if(index == 35)
            return KNIGHT_COUNTRY;
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
