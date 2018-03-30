package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author Jade
 * @Description 财务流水记录查询
 * @create 2017-08-02 下午 6:11
 * @Copyright Micro Silver
 **/

public class MerchFlowSearchDto extends PageDto{
    @ApiModelProperty(value = "财务流水Id（业务Id）")
    private String ordersn;
    @ApiModelProperty(value = "财务id")
    private Long financeId;
    @ApiModelProperty(value = "会员ID")
    private Long memberId;
    @ApiModelProperty(value = "商户ID")
    private Long merchId;
    @ApiModelProperty(value = "身份")
    private short identity;
    @ApiModelProperty(value = "金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "1 订单流水（销售收入），5 提现流水")
    private Byte type;
    @ApiModelProperty(value = "时间区间-起始时间")
    private Integer beginTime;
    @ApiModelProperty(value = "时间区间-结束时间")
    private Integer endTime;

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
