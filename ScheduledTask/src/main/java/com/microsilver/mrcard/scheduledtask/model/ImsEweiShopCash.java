package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopCash implements Serializable {
    private Long id;
    
    private String ordersn;

    private Long merchid;

    private String bankname;

    private String bankcard;

    private String truename;

    private Integer type;

    private Long createtime;

    private Long finshtime;

    private BigDecimal moneys;

    private Integer status;

    private Integer identity;

    private Integer payrates;

    private Long memberid;

    private Integer cashType;

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

	public Long getMerchid() {
        return merchid;
    }

    public void setMerchid(Long merchid) {
        this.merchid = merchid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getFinshtime() {
        return finshtime;
    }

    public void setFinshtime(Long finshtime) {
        this.finshtime = finshtime;
    }

    public BigDecimal getMoneys() {
        return moneys;
    }

    public void setMoneys(BigDecimal moneys) {
        this.moneys = moneys;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getPayrates() {
        return payrates;
    }

    public void setPayrates(Integer payrates) {
        this.payrates = payrates;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Integer getCashType() {
        return cashType;
    }

    public void setCashType(Integer cashType) {
        this.cashType = cashType;
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
        ImsEweiShopCash other = (ImsEweiShopCash) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMerchid() == null ? other.getMerchid() == null : this.getMerchid().equals(other.getMerchid()))
            && (this.getBankname() == null ? other.getBankname() == null : this.getBankname().equals(other.getBankname()))
            && (this.getBankcard() == null ? other.getBankcard() == null : this.getBankcard().equals(other.getBankcard()))
            && (this.getTruename() == null ? other.getTruename() == null : this.getTruename().equals(other.getTruename()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getFinshtime() == null ? other.getFinshtime() == null : this.getFinshtime().equals(other.getFinshtime()))
            && (this.getMoneys() == null ? other.getMoneys() == null : this.getMoneys().equals(other.getMoneys()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getPayrates() == null ? other.getPayrates() == null : this.getPayrates().equals(other.getPayrates()))
            && (this.getMemberid() == null ? other.getMemberid() == null : this.getMemberid().equals(other.getMemberid()))
            && (this.getCashType() == null ? other.getCashType() == null : this.getCashType().equals(other.getCashType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMerchid() == null) ? 0 : getMerchid().hashCode());
        result = prime * result + ((getBankname() == null) ? 0 : getBankname().hashCode());
        result = prime * result + ((getBankcard() == null) ? 0 : getBankcard().hashCode());
        result = prime * result + ((getTruename() == null) ? 0 : getTruename().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getFinshtime() == null) ? 0 : getFinshtime().hashCode());
        result = prime * result + ((getMoneys() == null) ? 0 : getMoneys().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getPayrates() == null) ? 0 : getPayrates().hashCode());
        result = prime * result + ((getMemberid() == null) ? 0 : getMemberid().hashCode());
        result = prime * result + ((getCashType() == null) ? 0 : getCashType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchid=").append(merchid);
        sb.append(", bankname=").append(bankname);
        sb.append(", bankcard=").append(bankcard);
        sb.append(", truename=").append(truename);
        sb.append(", type=").append(type);
        sb.append(", createtime=").append(createtime);
        sb.append(", finshtime=").append(finshtime);
        sb.append(", moneys=").append(moneys);
        sb.append(", status=").append(status);
        sb.append(", identity=").append(identity);
        sb.append(", payrates=").append(payrates);
        sb.append(", memberid=").append(memberid);
        sb.append(", cashType=").append(cashType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}