package com.microsilver.mrcard.cloud.finance.dto;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/25 0025.
 * 分成结果
 *      谁从哪里分到多少钱！
 */
public class BounsDto {

    public BounsDto(CustomerDto customer, String orderId, BigDecimal bouns) {
        this.customer = customer;
        this.orderId = orderId;
        this.bouns = bouns;
    }

    public BounsDto(CustomerDto customer, String orderId, String transId, BigDecimal bouns) {
        this.customer = customer;
        this.orderId = orderId;
        this.transId = transId;
        this.bouns = bouns;
    }

    /**
     * 客服
     */
    private CustomerDto customer;

    /**
     * 支付订单号-平台订单号
     */
    private String orderId;

    /**
     * 三方交易号(微信、支付宝、其他)
     */
    private String transId;


    /**
     * 分得的钱
     */
    private BigDecimal bouns;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public BigDecimal getBouns() {
        return bouns;
    }

    public void setBouns(BigDecimal bouns) {
        this.bouns = bouns;
    }
}
