package com.microsilver.mrcard.mq;

import io.swagger.annotations.ApiModelProperty;

import static com.microsilver.mrcard.mq.ESMSTemplate.*;

/**
 * @Name com.microsilver.mrcard.mq.ExtraSMS
 * @Description 短信消息体构造
 * @Author Jade
 * @Version 2017/9/14
 * @Copyright Micro Silver
 */
public class ExtraSMS {

    @ApiModelProperty(value = "验证码")
    private String code;
    @ApiModelProperty(value = "接收短信用户")
    private String name;
    @ApiModelProperty(value = "客户")
    private String userName;
    @ApiModelProperty(value = "金额")
    private String money;
    @ApiModelProperty(value = "订单id")
    private String orderid;
    @ApiModelProperty(value = "酒店")
    private String hotel;
    @ApiModelProperty(value = "房间")
    private String home;
    private String room;
    @ApiModelProperty(value = "订单类型")
    private String type;
    @ApiModelProperty(value = "用户电话")
    private String userPhone;
    @ApiModelProperty(value = "酒店电话")
    private String hotelPhone;
    @ApiModelProperty(value = "时间 mm-dd HH:ss")
    private String time;



    public String ExtraSMSValueByTemplateId(int templateId) {
        String smsValue = null;
        switch (ESMSTemplate.valueOf(templateId)) {
            case SMS_CARD_CHECKCODE:
                smsValue = SMS_CARD_CHECKCODE.getValue(this.code);
                break;
            case SMS_CARD_PAYORDER_REMIND:
                smsValue = SMS_CARD_PAYORDER_REMIND.getValue(this.name, this.userName, this.money, this.orderid);
                break;
            case SMS_CARD_PAYORDER_REMIND2:
                smsValue = SMS_CARD_PAYORDER_REMIND2.getValue(this.name, this.userName, this.money);
                break;
            case SMS_CARD_RECEIVE_ORDER:
                smsValue = SMS_CARD_RECEIVE_ORDER.getValue(this.name, this.userName, this.orderid);
                break;
            case SMS_CARD_FIND_PWD:
                smsValue = SMS_CARD_FIND_PWD.getValue(this.code);
                break;
            case SMS_KNIGHT_CHECKCODE:
                smsValue = SMS_KNIGHT_CHECKCODE.getValue(this.code);
                break;
            case SMS_KNIGHT_CARRYOVER:
                smsValue = SMS_KNIGHT_CARRYOVER.getValue();
                break;
            case SMS_KNIGHT_WITHDRAW:
                smsValue = SMS_KNIGHT_WITHDRAW.getValue();
                break;
            case SMS_HOTEL_ORDER_EXCEPTION:
                smsValue = SMS_HOTEL_ORDER_EXCEPTION.getValue();
                break;
            case SMS_HOTEL_CHECKCODE:
                smsValue = SMS_HOTEL_CHECKCODE.getValue(this.code);
                break;
            case SMS_HOTEL_BUY_SUCCESS:
                smsValue = SMS_HOTEL_BUY_SUCCESS.getValue(this.hotel);
                break;
            case SMS_HOTEL_TYPE_SUCCESS:
                smsValue = SMS_HOTEL_TYPE_SUCCESS.getValue(this.home, this.type);
                break;
            case SMS_HOTEL_REMIND:
                smsValue = SMS_HOTEL_REMIND.getValue();
                break;
            case SMS_HOTEL_WITHDRAW:
                smsValue = SMS_HOTEL_WITHDRAW.getValue();
                break;
            case SMS_CUSTOMER_SERVICE:
                smsValue = SMS_CUSTOMER_SERVICE.getValue(this.userName,this.userPhone,this.hotelPhone,this.hotel,this.home,this.time);
            default:
                //do nothing

        }
        return smsValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
