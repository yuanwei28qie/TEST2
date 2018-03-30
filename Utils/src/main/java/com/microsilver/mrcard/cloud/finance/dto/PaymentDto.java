package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Name com.microsilver.mrcard.cloud.finance.dto.PaymentDto
 * @Description 钱包参数-充值、支付、退款、提现相关
 * @Author Jade
 * @Version 2017/10/18
 * @Copyright Micro Silver
 */
public class PaymentDto {
    @ApiModelProperty(value = "财务Id")
    private Long financeId;
    @ApiModelProperty(value = "会员ID")
    private Long memberId;
    @ApiModelProperty(value = "商户ID")
    private Long merchId;
    @ApiModelProperty(value = "身份")
    private short identity;
    @ApiModelProperty(value = "业务单号")
    private String ordersn;
    @ApiModelProperty(value = "支付类型(1,余额支付22:微信,21:支付宝)")
    private Byte payType;
    @ApiModelProperty(value = "交易类型(1:消费,2:充值)")
    private Byte transType;
    @ApiModelProperty(value = "交易单号(第三方支付单号)")
    private String transactionNo;
    @ApiModelProperty(value = "交易金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "说明")
    private String remark;

    public PaymentDto() {
    }

    public PaymentDto(Long memberId, Long merchId, short identity) {
        this.memberId = memberId;
        this.merchId = merchId;
        this.identity = identity;
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

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getTransType() {
        return transType;
    }

    public void setTransType(Byte transType) {
        this.transType = transType;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
