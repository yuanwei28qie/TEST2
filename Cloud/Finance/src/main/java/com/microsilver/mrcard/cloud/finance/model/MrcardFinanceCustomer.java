package com.microsilver.mrcard.cloud.finance.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MrcardFinanceCustomer implements Serializable {

    /**
     * 财务ID
     *    备注：（memberId + merchId + identity）构成唯一财务Id
     */
    private Long id;

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

    /**
     * 未入账金额
     */
    private BigDecimal unrecordedAmount;

    /**
     * 垫付金额
     */
    private BigDecimal advanceAmount;


    private Integer creatTime;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getUnrecordedAmount() {
        return unrecordedAmount;
    }

    public void setUnrecordedAmount(BigDecimal unrecordedAmount) {
        this.unrecordedAmount = unrecordedAmount;
    }

    public BigDecimal getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(BigDecimal advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public Integer getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Integer creatTime) {
        this.creatTime = creatTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MrcardFinanceCustomer other = (MrcardFinanceCustomer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
                && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
                && (this.getMerchId() == null ? other.getMerchId() == null : this.getMerchId().equals(other.getMerchId()))
                && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
                && (this.getRealAmount() == null ? other.getRealAmount() == null : this.getRealAmount().equals(other.getRealAmount()))
                && (this.getAdvanceAmount() == null ? other.getAdvanceAmount() == null : this.getAdvanceAmount().equals(other.getAdvanceAmount()))
                && (this.getUnrecordedAmount() == null ? other.getUnrecordedAmount() == null : this.getUnrecordedAmount().equals(other.getUnrecordedAmount()))
                && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getMerchId() == null) ? 0 : getMerchId().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getRealAmount() == null) ? 0 : getRealAmount().hashCode());
        result = prime * result + ((getAdvanceAmount() == null) ? 0 : getAdvanceAmount().hashCode());
        result = prime * result + ((getUnrecordedAmount() == null) ? 0 : getUnrecordedAmount().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", identity=").append(identity);
        sb.append(", merchId=").append(merchId);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", realAmount=").append(realAmount);
        sb.append(", advanceAmount=").append(advanceAmount);
        sb.append(", unrecordedAmount=").append(unrecordedAmount);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}