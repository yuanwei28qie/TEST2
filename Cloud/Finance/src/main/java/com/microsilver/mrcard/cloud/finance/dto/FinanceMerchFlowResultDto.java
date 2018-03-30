package com.microsilver.mrcard.cloud.finance.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jade on 2017/8/15.
 */
public class FinanceMerchFlowResultDto implements Serializable {

    /**
     * 会员ID
     */
    private Long memberId;
    /**
     *身份
     */
    private Short identity;
    /**
     *商户ID
     */
    private Long merchId;

    /**
     * 总金额，包含历史金额
     */
    private BigDecimal totalAmount;

    /**
     * 实际金额（可提现金额）
     */
    private BigDecimal realAmount;

    private Long id;

    private Long financeId;

    private Byte type;

    private BigDecimal amount;

    private Integer createTime;

    private String ordersn;

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

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
