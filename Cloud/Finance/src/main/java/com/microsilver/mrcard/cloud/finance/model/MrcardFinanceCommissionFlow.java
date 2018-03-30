package com.microsilver.mrcard.cloud.finance.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MrcardFinanceCommissionFlow implements Serializable {

    private Long id;

    /**
     *平台订单号
     */
    private String ordersn;

    /**
     * 客户财务编号
     */
    private Long financeId;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     *结算金额
     */
    private BigDecimal commission;
    /**
     *结算时间
     */
    private Integer createTime;
    /**
     *分润比例
     */
    private Short commType;
    /**
     *备注
     */
    private String remark;
    /**
     *状态（0预结算，1结算，2退款）
     */
    private Short commState;

    /**
     * 流水类型(1:销售收入,3:垫付货款)
     */
    private Byte type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Short getCommType() {
        return commType;
    }

    public void setCommType(Short commType) {
        this.commType = commType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Short getCommState() {
        return commState;
    }

    public void setCommState(Short commState) {
        this.commState = commState;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
        MrcardFinanceCommissionFlow other = (MrcardFinanceCommissionFlow) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getOrdersn() == null ? other.getOrdersn() == null : this.getOrdersn().equals(other.getOrdersn()))
                && (this.getFinanceId() == null ? other.getFinanceId() == null : this.getFinanceId().equals(other.getFinanceId()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getCommission() == null ? other.getCommission() == null : this.getCommission().equals(other.getCommission()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getCommType() == null ? other.getCommType() == null : this.getCommType().equals(other.getCommType()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getCommState() == null ? other.getCommState() == null : this.getCommState().equals(other.getCommState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrdersn() == null) ? 0 : getOrdersn().hashCode());
        result = prime * result + ((getFinanceId() == null) ? 0 : getFinanceId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCommission() == null) ? 0 : getCommission().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCommType() == null) ? 0 : getCommType().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCommState() == null) ? 0 : getCommState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ordersn=").append(ordersn);
        sb.append(", financeId=").append(financeId);
        sb.append(", amount=").append(amount);
        sb.append(", commission=").append(commission);
        sb.append(", createTime=").append(createTime);
        sb.append(", commType=").append(commType);
        sb.append(", type=").append(type);
        sb.append(", remark=").append(remark);
        sb.append(", commState=").append(commState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}