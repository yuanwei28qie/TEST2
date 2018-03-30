package com.microsilver.mrcard.mq;

/**
 * @Name com.microsilver.mrcard.mq.OrderMQ
 * @Description 订单异步业务处理
 * @Author Jade
 * @Version 2017/9/19
 * @Copyright Micro Silver
 */
public class OrderMQ {
    private Integer memberId;
    private Integer identity;
    private Integer merchId;
    //订单id
    int orderId;
    //业务单号
    String orderSn;
    //操作类型 1，发送抢单通知,2:超级订订单结算,3:合伙人订单结算
    int type;
    //城市编码
    private Long city;
    //经度
    String lat;
    //纬度
    String lng;
    //距离
    Integer effectiveDistance;
    private Integer device;
    //("APP类型 1:卡先生消费者版本2:卡先生商家版 3:卡先生雇员版 4:超级订消费者版 5:小飞侠")
    private Byte appName;
    //("应用对应版本号")
    private String appVersion;
    //("推送注册Id")
    private String registration;
    //("推送设置tags")
    private String tags;
    //("推送设置alias")
    private String alias;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getMerchId() {
        return merchId;
    }

    public void setMerchId(Integer merchId) {
        this.merchId = merchId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
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

    public Integer getEffectiveDistance() {
        return effectiveDistance;
    }

    public void setEffectiveDistance(Integer effectiveDistance) {
        this.effectiveDistance = effectiveDistance;
    }

    public Byte getAppName() {
        return appName;
    }

    public void setAppName(Byte appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
