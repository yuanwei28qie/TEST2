package com.microsilver.mrcard.cloud.finance.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Jade on 2017/8/15.
 */
@JsonInclude(value=Include.NON_NULL)
public class FinanceCommissionFlowResultDto implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Long memberId;
    @ApiModelProperty(value = "身份")
    private Short identity;
    @ApiModelProperty(value = "商户ID")
    private Long merchId;
    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "分润总金额")
    private BigDecimal boundAmount;
    @ApiModelProperty(value = "创建时间")
    private Integer createTime;
    @ApiModelProperty(value = "业务单号")
    private String ordersn;

    @ApiModelProperty(value = "流水id")
    private Long id;
    @ApiModelProperty(value = "财务id")
    private Long financeId;
    @ApiModelProperty(value = "状态（0预结算，1结算，2退款）")
    private Byte commState;
    @ApiModelProperty(value = "订单金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "分成金额即收入")
    private BigDecimal commission;
    @ApiModelProperty(value = "备注")
    private String remark;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Short getIdentity() {
        return identity;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getBoundAmount() {
        return boundAmount;
    }

    public void setBoundAmount(BigDecimal boundAmount) {
        this.boundAmount = boundAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public Byte getCommState() {
        return commState;
    }

    public void setCommState(Byte commState) {
        this.commState = commState;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
