package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Name com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto
 * @Description
 * @Author Jade
 * @Version 2017/9/4
 * @Copyright Micro Silver
 */
public class CarryoverKnightDto {

    /**
     * 会员ID
     */
    @ApiModelProperty("会员ID")
    private Long memberId;

    /**
     * 商户ID
     */
    @ApiModelProperty("商户ID")
    private Long merchId;

    /**
     * 身份
     */
    @ApiModelProperty("身份")
    private short identity;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Long beginTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Long endTime;

    /**
     * 结转单据编号
     */
    @ApiModelProperty("结转单据编号")
    private String settlementSn;

    /**
     * 订单列表
     */
    @ApiModelProperty("订单列表")
    private List<String> snList;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public short getIdentity() {
        return identity;
    }

    public void setIdentity(short identity) {
        this.identity = identity;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getSettlementSn() {
        return settlementSn;
    }

    public void setSettlementSn(String settlementSn) {
        this.settlementSn = settlementSn;
    }

    public List<String> getSnList() {
        return snList;
    }

    public void setSnList(List<String> snList) {
        this.snList = snList;
    }
}
