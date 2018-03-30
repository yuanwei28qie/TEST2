package com.microsilver.mrcard.cloud.finance.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MrcardFinanceSettlement implements Serializable {
    private Long id;

    private String settlementsn;

    private Long financeId;

    private Integer accountPeriodBegin;

    private Integer accountPeriodEnd;
    //商品垫付金额
    private BigDecimal advanceAmount;
    //运费结算金额
    private BigDecimal dispatchAmount;
    //小费结算金额
    private BigDecimal tipAmount;
    //平台抽成金额
    private BigDecimal pumpingAmount;
    //结算总金额(运费+小费-抽层)
    private BigDecimal totalAmount;
    //状态(-1:未通过,0:待审核,1:已通过,2:已打款)
    private Byte status;

    private Integer createTime;

    private String checkName;

    private Integer checkTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettlementsn() {
        return settlementsn;
    }

    public void setSettlementsn(String settlementsn) {
        this.settlementsn = settlementsn;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public Integer getAccountPeriodBegin() {
        return accountPeriodBegin;
    }

    public void setAccountPeriodBegin(Integer accountPeriodBegin) {
        this.accountPeriodBegin = accountPeriodBegin;
    }

    public Integer getAccountPeriodEnd() {
        return accountPeriodEnd;
    }

    public void setAccountPeriodEnd(Integer accountPeriodEnd) {
        this.accountPeriodEnd = accountPeriodEnd;
    }

    public BigDecimal getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(BigDecimal advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public BigDecimal getDispatchAmount() {
        return dispatchAmount;
    }

    public void setDispatchAmount(BigDecimal dispatchAmount) {
        this.dispatchAmount = dispatchAmount;
    }

    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(BigDecimal tipAmount) {
        this.tipAmount = tipAmount;
    }

    public BigDecimal getPumpingAmount() {
        return pumpingAmount;
    }

    public void setPumpingAmount(BigDecimal pumpingAmount) {
        this.pumpingAmount = pumpingAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public Integer getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
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
        MrcardFinanceSettlement other = (MrcardFinanceSettlement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSettlementsn() == null ? other.getSettlementsn() == null : this.getSettlementsn().equals(other.getSettlementsn()))
            && (this.getFinanceId() == null ? other.getFinanceId() == null : this.getFinanceId().equals(other.getFinanceId()))
            && (this.getAccountPeriodBegin() == null ? other.getAccountPeriodBegin() == null : this.getAccountPeriodBegin().equals(other.getAccountPeriodBegin()))
            && (this.getAccountPeriodEnd() == null ? other.getAccountPeriodEnd() == null : this.getAccountPeriodEnd().equals(other.getAccountPeriodEnd()))
            && (this.getAdvanceAmount() == null ? other.getAdvanceAmount() == null : this.getAdvanceAmount().equals(other.getAdvanceAmount()))
            && (this.getDispatchAmount() == null ? other.getDispatchAmount() == null : this.getDispatchAmount().equals(other.getDispatchAmount()))
            && (this.getTipAmount() == null ? other.getTipAmount() == null : this.getTipAmount().equals(other.getTipAmount()))
            && (this.getPumpingAmount() == null ? other.getPumpingAmount() == null : this.getPumpingAmount().equals(other.getPumpingAmount()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCheckName() == null ? other.getCheckName() == null : this.getCheckName().equals(other.getCheckName()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSettlementsn() == null) ? 0 : getSettlementsn().hashCode());
        result = prime * result + ((getFinanceId() == null) ? 0 : getFinanceId().hashCode());
        result = prime * result + ((getAccountPeriodBegin() == null) ? 0 : getAccountPeriodBegin().hashCode());
        result = prime * result + ((getAccountPeriodEnd() == null) ? 0 : getAccountPeriodEnd().hashCode());
        result = prime * result + ((getAdvanceAmount() == null) ? 0 : getAdvanceAmount().hashCode());
        result = prime * result + ((getDispatchAmount() == null) ? 0 : getDispatchAmount().hashCode());
        result = prime * result + ((getTipAmount() == null) ? 0 : getTipAmount().hashCode());
        result = prime * result + ((getPumpingAmount() == null) ? 0 : getPumpingAmount().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCheckName() == null) ? 0 : getCheckName().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", settlementsn=").append(settlementsn);
        sb.append(", financeId=").append(financeId);
        sb.append(", accountPeriodBegin=").append(accountPeriodBegin);
        sb.append(", accountPeriodEnd=").append(accountPeriodEnd);
        sb.append(", advanceAmount=").append(advanceAmount);
        sb.append(", dispatchAmount=").append(dispatchAmount);
        sb.append(", tipAmount=").append(tipAmount);
        sb.append(", pumpingAmount=").append(pumpingAmount);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", checkName=").append(checkName);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}