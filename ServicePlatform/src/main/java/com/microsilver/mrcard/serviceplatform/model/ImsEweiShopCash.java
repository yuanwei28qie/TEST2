package com.microsilver.mrcard.serviceplatform.model;

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
    
    private String remark;

    private static final long serialVersionUID = 1L;

    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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
	public String toString() {
		return "ImsEweiShopCash [id=" + id + ", merchid=" + merchid + ", bankname=" + bankname + ", bankcard="
				+ bankcard + ", truename=" + truename + ", type=" + type + ", createtime=" + createtime + ", finshtime="
				+ finshtime + ", moneys=" + moneys + ", status=" + status + ", identity=" + identity + ", payrates="
				+ payrates + ", memberid=" + memberid + ", cashType=" + cashType + ", remark=" + remark + "]";
	}
}