package com.microsilver.mrcard.mq;

/**
 * @Name com.microsilver.mrcard.mq.coordinateMQ
 * @Description 更新用户坐标
 * @Author Jade
 * @Version 2017/9/18
 * @Copyright Micro Silver
 */
public class coordinateMQ {

    Long memberId;
    Byte identity;
    String lat;
    String lng;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
