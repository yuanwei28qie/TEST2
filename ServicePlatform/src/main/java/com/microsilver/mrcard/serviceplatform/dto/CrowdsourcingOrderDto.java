package com.microsilver.mrcard.serviceplatform.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class CrowdsourcingOrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务描述")
    private String serviceDesc;
    @ApiModelProperty(value = "商品预估费用")
    private BigDecimal goodsEstimatePrice;
    @ApiModelProperty(value = "运费")
    private BigDecimal dispatchPrice;
    @ApiModelProperty(value = "小费")
    private BigDecimal tipPrice;
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "收货地址编号")
    private Long addressId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public BigDecimal getGoodsEstimatePrice() {
        return goodsEstimatePrice;
    }

    public void setGoodsEstimatePrice(BigDecimal goodsEstimatePrice) {
        this.goodsEstimatePrice = goodsEstimatePrice;
    }

    public BigDecimal getDispatchPrice() {
        return dispatchPrice;
    }

    public void setDispatchPrice(BigDecimal dispatchPrice) {
        this.dispatchPrice = dispatchPrice;
    }

    public BigDecimal getTipPrice() {
        return tipPrice;
    }

    public void setTipPrice(BigDecimal tipPrice) {
        this.tipPrice = tipPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

}