package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopOrder implements Serializable {
    private Integer id;

    private Integer uniacid;

    private String openid;

    private Long memberId;

    private Integer agentid;

    private String ordersn;

    private BigDecimal price;

    private BigDecimal goodsprice;

    private BigDecimal discountprice;

    private BigDecimal costprice;

    private BigDecimal subsidyprice;

    private Byte status;

    private Boolean paytype;

    private String transid;

    private String remark;

    private Integer addressid;

    private BigDecimal dispatchprice;

    private Integer dispatchid;

    private Integer createtime;

    private Byte dispatchtype;

    private Integer refundid;

    private Byte iscomment;

    private Byte creditadd;

    private Byte deleted;

    private Byte userdeleted;

    private Integer finishtime;

    private Long paytime;

    private String expresscom;

    private String expresssn;

    private String express;

    private Integer sendtime;

    private Integer sortingtime;

    private Integer fetchtime;

    private Byte cash;

    private Integer canceltime;

    private Integer cancelpaytime;

    private Integer refundtime;

    private Byte isverify;

    private Byte verified;

    private String verifyopenid;

    private Integer verifytime;

    private String verifycode;

    private Integer verifystoreid;

    private BigDecimal deductprice;

    private Integer deductcredit;

    private BigDecimal deductcredit2;

    private BigDecimal deductenough;

    private Integer virtual;

    private Byte sysdeleted;

    private Integer ordersn2;

    private BigDecimal changeprice;

    private BigDecimal changedispatchprice;

    private BigDecimal oldprice;

    private BigDecimal olddispatchprice;

    private Byte isvirtual;

    private Integer couponid;

    private BigDecimal couponprice;

    private Integer diyformid;

    private Integer storeid;

    private Boolean printstate;

    private Boolean printstate2;

    private Byte refundstate;

    private Integer ismr;

    private BigDecimal isdiscountprice;

    private Boolean isvirtualsend;

    private Boolean verifytype;

    private Integer merchid;

    private String invoicename;

    private Boolean ismerch;

    private Integer parentid;

    private Boolean isparent;

    private BigDecimal grprice;

    private Boolean merchshow;

    private BigDecimal merchdeductenough;

    private Integer couponmerchid;

    private Byte isglobonus;

    private Boolean merchapply;

    private Byte isabonus;

    private Byte isborrow;

    private String borrowopenid;

    private BigDecimal merchisdiscountprice;

    private Byte apppay;

    private BigDecimal coupongoodprice;

    private BigDecimal buyagainprice;

    private Byte ispackage;

    private Integer packageid;

    private BigDecimal taskdiscountprice;

    private BigDecimal seckilldiscountprice;

    private Integer verifyendtime;

    private Boolean willcancelmessage;

    private Byte sendtype;

    private Float code;

    private Long courier;

    private Byte orderType;

    // 结算状态(-1结算失败，0:未结算,1: 预结算，2以结算)
    private Byte issettlement;

    private Byte activityId;

    public BigDecimal getSubsidyprice() {
        return subsidyprice;
    }

    public void setSubsidyprice(BigDecimal subsidyprice) {
        this.subsidyprice = subsidyprice;
    }

    public Byte getIssettlement() {
		return issettlement;
	}

	public void setIssettlement(Byte issettlement) {
		this.issettlement = issettlement;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniacid() {
        return uniacid;
    }

    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(BigDecimal goodsprice) {
        this.goodsprice = goodsprice;
    }

    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getPaytype() {
        return paytype;
    }

    public void setPaytype(Boolean paytype) {
        this.paytype = paytype;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public BigDecimal getDispatchprice() {
        return dispatchprice;
    }

    public void setDispatchprice(BigDecimal dispatchprice) {
        this.dispatchprice = dispatchprice;
    }

    public Integer getDispatchid() {
        return dispatchid;
    }

    public void setDispatchid(Integer dispatchid) {
        this.dispatchid = dispatchid;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Byte getDispatchtype() {
        return dispatchtype;
    }

    public void setDispatchtype(Byte dispatchtype) {
        this.dispatchtype = dispatchtype;
    }

    public Integer getRefundid() {
        return refundid;
    }

    public void setRefundid(Integer refundid) {
        this.refundid = refundid;
    }

    public Byte getIscomment() {
        return iscomment;
    }

    public void setIscomment(Byte iscomment) {
        this.iscomment = iscomment;
    }

    public Byte getCreditadd() {
        return creditadd;
    }

    public void setCreditadd(Byte creditadd) {
        this.creditadd = creditadd;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Byte getUserdeleted() {
        return userdeleted;
    }

    public void setUserdeleted(Byte userdeleted) {
        this.userdeleted = userdeleted;
    }

    public Integer getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Integer finishtime) {
        this.finishtime = finishtime;
    }

    public Long getPaytime() {
        return paytime;
    }

    public void setPaytime(Long paytime) {
        this.paytime = paytime;
    }

    public String getExpresscom() {
        return expresscom;
    }

    public void setExpresscom(String expresscom) {
        this.expresscom = expresscom;
    }

    public String getExpresssn() {
        return expresssn;
    }

    public void setExpresssn(String expresssn) {
        this.expresssn = expresssn;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public Integer getSendtime() {
        return sendtime;
    }

    public void setSendtime(Integer sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getSortingtime() {
        return sortingtime;
    }

    public void setSortingtime(Integer sortingtime) {
        this.sortingtime = sortingtime;
    }

    public Integer getFetchtime() {
        return fetchtime;
    }

    public void setFetchtime(Integer fetchtime) {
        this.fetchtime = fetchtime;
    }

    public Byte getCash() {
        return cash;
    }

    public void setCash(Byte cash) {
        this.cash = cash;
    }

    public Integer getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Integer canceltime) {
        this.canceltime = canceltime;
    }

    public Integer getCancelpaytime() {
        return cancelpaytime;
    }

    public void setCancelpaytime(Integer cancelpaytime) {
        this.cancelpaytime = cancelpaytime;
    }

    public Integer getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(Integer refundtime) {
        this.refundtime = refundtime;
    }

    public Byte getIsverify() {
        return isverify;
    }

    public void setIsverify(Byte isverify) {
        this.isverify = isverify;
    }

    public Byte getVerified() {
        return verified;
    }

    public void setVerified(Byte verified) {
        this.verified = verified;
    }

    public String getVerifyopenid() {
        return verifyopenid;
    }

    public void setVerifyopenid(String verifyopenid) {
        this.verifyopenid = verifyopenid;
    }

    public Integer getVerifytime() {
        return verifytime;
    }

    public void setVerifytime(Integer verifytime) {
        this.verifytime = verifytime;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public Integer getVerifystoreid() {
        return verifystoreid;
    }

    public void setVerifystoreid(Integer verifystoreid) {
        this.verifystoreid = verifystoreid;
    }

    public BigDecimal getDeductprice() {
        return deductprice;
    }

    public void setDeductprice(BigDecimal deductprice) {
        this.deductprice = deductprice;
    }

    public Integer getDeductcredit() {
        return deductcredit;
    }

    public void setDeductcredit(Integer deductcredit) {
        this.deductcredit = deductcredit;
    }

    public BigDecimal getDeductcredit2() {
        return deductcredit2;
    }

    public void setDeductcredit2(BigDecimal deductcredit2) {
        this.deductcredit2 = deductcredit2;
    }

    public BigDecimal getDeductenough() {
        return deductenough;
    }

    public void setDeductenough(BigDecimal deductenough) {
        this.deductenough = deductenough;
    }

    public Integer getVirtual() {
        return virtual;
    }

    public void setVirtual(Integer virtual) {
        this.virtual = virtual;
    }

    public Byte getSysdeleted() {
        return sysdeleted;
    }

    public void setSysdeleted(Byte sysdeleted) {
        this.sysdeleted = sysdeleted;
    }

    public Integer getOrdersn2() {
        return ordersn2;
    }

    public void setOrdersn2(Integer ordersn2) {
        this.ordersn2 = ordersn2;
    }

    public BigDecimal getChangeprice() {
        return changeprice;
    }

    public void setChangeprice(BigDecimal changeprice) {
        this.changeprice = changeprice;
    }

    public BigDecimal getChangedispatchprice() {
        return changedispatchprice;
    }

    public void setChangedispatchprice(BigDecimal changedispatchprice) {
        this.changedispatchprice = changedispatchprice;
    }

    public BigDecimal getOldprice() {
        return oldprice;
    }

    public void setOldprice(BigDecimal oldprice) {
        this.oldprice = oldprice;
    }

    public BigDecimal getOlddispatchprice() {
        return olddispatchprice;
    }

    public void setOlddispatchprice(BigDecimal olddispatchprice) {
        this.olddispatchprice = olddispatchprice;
    }

    public Byte getIsvirtual() {
        return isvirtual;
    }

    public void setIsvirtual(Byte isvirtual) {
        this.isvirtual = isvirtual;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public BigDecimal getCouponprice() {
        return couponprice;
    }

    public void setCouponprice(BigDecimal couponprice) {
        this.couponprice = couponprice;
    }

    public Integer getDiyformid() {
        return diyformid;
    }

    public void setDiyformid(Integer diyformid) {
        this.diyformid = diyformid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Boolean getPrintstate() {
        return printstate;
    }

    public void setPrintstate(Boolean printstate) {
        this.printstate = printstate;
    }

    public Boolean getPrintstate2() {
        return printstate2;
    }

    public void setPrintstate2(Boolean printstate2) {
        this.printstate2 = printstate2;
    }

    public Byte getRefundstate() {
        return refundstate;
    }

    public void setRefundstate(Byte refundstate) {
        this.refundstate = refundstate;
    }

    public Integer getIsmr() {
        return ismr;
    }

    public void setIsmr(Integer ismr) {
        this.ismr = ismr;
    }

    public BigDecimal getIsdiscountprice() {
        return isdiscountprice;
    }

    public void setIsdiscountprice(BigDecimal isdiscountprice) {
        this.isdiscountprice = isdiscountprice;
    }

    public Boolean getIsvirtualsend() {
        return isvirtualsend;
    }

    public void setIsvirtualsend(Boolean isvirtualsend) {
        this.isvirtualsend = isvirtualsend;
    }

    public Boolean getVerifytype() {
        return verifytype;
    }

    public void setVerifytype(Boolean verifytype) {
        this.verifytype = verifytype;
    }

    public Integer getMerchid() {
        return merchid;
    }

    public void setMerchid(Integer merchid) {
        this.merchid = merchid;
    }

    public String getInvoicename() {
        return invoicename;
    }

    public void setInvoicename(String invoicename) {
        this.invoicename = invoicename;
    }

    public Boolean getIsmerch() {
        return ismerch;
    }

    public void setIsmerch(Boolean ismerch) {
        this.ismerch = ismerch;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Boolean getIsparent() {
        return isparent;
    }

    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }

    public BigDecimal getGrprice() {
        return grprice;
    }

    public void setGrprice(BigDecimal grprice) {
        this.grprice = grprice;
    }

    public Boolean getMerchshow() {
        return merchshow;
    }

    public void setMerchshow(Boolean merchshow) {
        this.merchshow = merchshow;
    }

    public BigDecimal getMerchdeductenough() {
        return merchdeductenough;
    }

    public void setMerchdeductenough(BigDecimal merchdeductenough) {
        this.merchdeductenough = merchdeductenough;
    }

    public Integer getCouponmerchid() {
        return couponmerchid;
    }

    public void setCouponmerchid(Integer couponmerchid) {
        this.couponmerchid = couponmerchid;
    }

    public Byte getIsglobonus() {
        return isglobonus;
    }

    public void setIsglobonus(Byte isglobonus) {
        this.isglobonus = isglobonus;
    }

    public Boolean getMerchapply() {
        return merchapply;
    }

    public void setMerchapply(Boolean merchapply) {
        this.merchapply = merchapply;
    }

    public Byte getIsabonus() {
        return isabonus;
    }

    public void setIsabonus(Byte isabonus) {
        this.isabonus = isabonus;
    }

    public Byte getIsborrow() {
        return isborrow;
    }

    public void setIsborrow(Byte isborrow) {
        this.isborrow = isborrow;
    }

    public String getBorrowopenid() {
        return borrowopenid;
    }

    public void setBorrowopenid(String borrowopenid) {
        this.borrowopenid = borrowopenid;
    }

    public BigDecimal getMerchisdiscountprice() {
        return merchisdiscountprice;
    }

    public void setMerchisdiscountprice(BigDecimal merchisdiscountprice) {
        this.merchisdiscountprice = merchisdiscountprice;
    }

    public Byte getApppay() {
        return apppay;
    }

    public void setApppay(Byte apppay) {
        this.apppay = apppay;
    }

    public BigDecimal getCoupongoodprice() {
        return coupongoodprice;
    }

    public void setCoupongoodprice(BigDecimal coupongoodprice) {
        this.coupongoodprice = coupongoodprice;
    }

    public BigDecimal getBuyagainprice() {
        return buyagainprice;
    }

    public void setBuyagainprice(BigDecimal buyagainprice) {
        this.buyagainprice = buyagainprice;
    }

    public Byte getIspackage() {
        return ispackage;
    }

    public void setIspackage(Byte ispackage) {
        this.ispackage = ispackage;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public BigDecimal getTaskdiscountprice() {
        return taskdiscountprice;
    }

    public void setTaskdiscountprice(BigDecimal taskdiscountprice) {
        this.taskdiscountprice = taskdiscountprice;
    }

    public BigDecimal getSeckilldiscountprice() {
        return seckilldiscountprice;
    }

    public void setSeckilldiscountprice(BigDecimal seckilldiscountprice) {
        this.seckilldiscountprice = seckilldiscountprice;
    }

    public Integer getVerifyendtime() {
        return verifyendtime;
    }

    public void setVerifyendtime(Integer verifyendtime) {
        this.verifyendtime = verifyendtime;
    }

    public Boolean getWillcancelmessage() {
        return willcancelmessage;
    }

    public void setWillcancelmessage(Boolean willcancelmessage) {
        this.willcancelmessage = willcancelmessage;
    }

    public Byte getSendtype() {
        return sendtype;
    }

    public void setSendtype(Byte sendtype) {
        this.sendtype = sendtype;
    }

    public Float getCode() {
        return code;
    }

    public void setCode(Float code) {
        this.code = code;
    }

    public Long getCourier() {
        return courier;
    }

    public void setCourier(Long courier) {
        this.courier = courier;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getActivityId() {
        return activityId;
    }

    public void setActivityId(Byte activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
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
        ImsEweiShopOrder other = (ImsEweiShopOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getAgentid() == null ? other.getAgentid() == null : this.getAgentid().equals(other.getAgentid()))
            && (this.getOrdersn() == null ? other.getOrdersn() == null : this.getOrdersn().equals(other.getOrdersn()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getGoodsprice() == null ? other.getGoodsprice() == null : this.getGoodsprice().equals(other.getGoodsprice()))
            && (this.getDiscountprice() == null ? other.getDiscountprice() == null : this.getDiscountprice().equals(other.getDiscountprice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()))
            && (this.getTransid() == null ? other.getTransid() == null : this.getTransid().equals(other.getTransid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAddressid() == null ? other.getAddressid() == null : this.getAddressid().equals(other.getAddressid()))
            && (this.getDispatchprice() == null ? other.getDispatchprice() == null : this.getDispatchprice().equals(other.getDispatchprice()))
            && (this.getDispatchid() == null ? other.getDispatchid() == null : this.getDispatchid().equals(other.getDispatchid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDispatchtype() == null ? other.getDispatchtype() == null : this.getDispatchtype().equals(other.getDispatchtype()))
            && (this.getRefundid() == null ? other.getRefundid() == null : this.getRefundid().equals(other.getRefundid()))
            && (this.getIscomment() == null ? other.getIscomment() == null : this.getIscomment().equals(other.getIscomment()))
            && (this.getCreditadd() == null ? other.getCreditadd() == null : this.getCreditadd().equals(other.getCreditadd()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getUserdeleted() == null ? other.getUserdeleted() == null : this.getUserdeleted().equals(other.getUserdeleted()))
            && (this.getFinishtime() == null ? other.getFinishtime() == null : this.getFinishtime().equals(other.getFinishtime()))
            && (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
            && (this.getExpresscom() == null ? other.getExpresscom() == null : this.getExpresscom().equals(other.getExpresscom()))
            && (this.getExpresssn() == null ? other.getExpresssn() == null : this.getExpresssn().equals(other.getExpresssn()))
            && (this.getExpress() == null ? other.getExpress() == null : this.getExpress().equals(other.getExpress()))
            && (this.getSendtime() == null ? other.getSendtime() == null : this.getSendtime().equals(other.getSendtime()))
            && (this.getSortingtime() == null ? other.getSortingtime() == null : this.getSortingtime().equals(other.getSortingtime()))
            && (this.getFetchtime() == null ? other.getFetchtime() == null : this.getFetchtime().equals(other.getFetchtime()))
            && (this.getCash() == null ? other.getCash() == null : this.getCash().equals(other.getCash()))
            && (this.getCanceltime() == null ? other.getCanceltime() == null : this.getCanceltime().equals(other.getCanceltime()))
            && (this.getCancelpaytime() == null ? other.getCancelpaytime() == null : this.getCancelpaytime().equals(other.getCancelpaytime()))
            && (this.getRefundtime() == null ? other.getRefundtime() == null : this.getRefundtime().equals(other.getRefundtime()))
            && (this.getIsverify() == null ? other.getIsverify() == null : this.getIsverify().equals(other.getIsverify()))
            && (this.getVerified() == null ? other.getVerified() == null : this.getVerified().equals(other.getVerified()))
            && (this.getVerifyopenid() == null ? other.getVerifyopenid() == null : this.getVerifyopenid().equals(other.getVerifyopenid()))
            && (this.getVerifytime() == null ? other.getVerifytime() == null : this.getVerifytime().equals(other.getVerifytime()))
            && (this.getVerifycode() == null ? other.getVerifycode() == null : this.getVerifycode().equals(other.getVerifycode()))
            && (this.getVerifystoreid() == null ? other.getVerifystoreid() == null : this.getVerifystoreid().equals(other.getVerifystoreid()))
            && (this.getDeductprice() == null ? other.getDeductprice() == null : this.getDeductprice().equals(other.getDeductprice()))
            && (this.getDeductcredit() == null ? other.getDeductcredit() == null : this.getDeductcredit().equals(other.getDeductcredit()))
            && (this.getDeductcredit2() == null ? other.getDeductcredit2() == null : this.getDeductcredit2().equals(other.getDeductcredit2()))
            && (this.getDeductenough() == null ? other.getDeductenough() == null : this.getDeductenough().equals(other.getDeductenough()))
            && (this.getVirtual() == null ? other.getVirtual() == null : this.getVirtual().equals(other.getVirtual()))
            && (this.getSysdeleted() == null ? other.getSysdeleted() == null : this.getSysdeleted().equals(other.getSysdeleted()))
            && (this.getOrdersn2() == null ? other.getOrdersn2() == null : this.getOrdersn2().equals(other.getOrdersn2()))
            && (this.getChangeprice() == null ? other.getChangeprice() == null : this.getChangeprice().equals(other.getChangeprice()))
            && (this.getChangedispatchprice() == null ? other.getChangedispatchprice() == null : this.getChangedispatchprice().equals(other.getChangedispatchprice()))
            && (this.getOldprice() == null ? other.getOldprice() == null : this.getOldprice().equals(other.getOldprice()))
            && (this.getOlddispatchprice() == null ? other.getOlddispatchprice() == null : this.getOlddispatchprice().equals(other.getOlddispatchprice()))
            && (this.getIsvirtual() == null ? other.getIsvirtual() == null : this.getIsvirtual().equals(other.getIsvirtual()))
            && (this.getCouponid() == null ? other.getCouponid() == null : this.getCouponid().equals(other.getCouponid()))
            && (this.getCouponprice() == null ? other.getCouponprice() == null : this.getCouponprice().equals(other.getCouponprice()))
            && (this.getDiyformid() == null ? other.getDiyformid() == null : this.getDiyformid().equals(other.getDiyformid()))
            && (this.getStoreid() == null ? other.getStoreid() == null : this.getStoreid().equals(other.getStoreid()))
            && (this.getPrintstate() == null ? other.getPrintstate() == null : this.getPrintstate().equals(other.getPrintstate()))
            && (this.getPrintstate2() == null ? other.getPrintstate2() == null : this.getPrintstate2().equals(other.getPrintstate2()))
            && (this.getRefundstate() == null ? other.getRefundstate() == null : this.getRefundstate().equals(other.getRefundstate()))
            && (this.getIsmr() == null ? other.getIsmr() == null : this.getIsmr().equals(other.getIsmr()))
            && (this.getIsdiscountprice() == null ? other.getIsdiscountprice() == null : this.getIsdiscountprice().equals(other.getIsdiscountprice()))
            && (this.getIsvirtualsend() == null ? other.getIsvirtualsend() == null : this.getIsvirtualsend().equals(other.getIsvirtualsend()))
            && (this.getVerifytype() == null ? other.getVerifytype() == null : this.getVerifytype().equals(other.getVerifytype()))
            && (this.getMerchid() == null ? other.getMerchid() == null : this.getMerchid().equals(other.getMerchid()))
            && (this.getInvoicename() == null ? other.getInvoicename() == null : this.getInvoicename().equals(other.getInvoicename()))
            && (this.getIsmerch() == null ? other.getIsmerch() == null : this.getIsmerch().equals(other.getIsmerch()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getIsparent() == null ? other.getIsparent() == null : this.getIsparent().equals(other.getIsparent()))
            && (this.getGrprice() == null ? other.getGrprice() == null : this.getGrprice().equals(other.getGrprice()))
            && (this.getMerchshow() == null ? other.getMerchshow() == null : this.getMerchshow().equals(other.getMerchshow()))
            && (this.getMerchdeductenough() == null ? other.getMerchdeductenough() == null : this.getMerchdeductenough().equals(other.getMerchdeductenough()))
            && (this.getCouponmerchid() == null ? other.getCouponmerchid() == null : this.getCouponmerchid().equals(other.getCouponmerchid()))
            && (this.getIsglobonus() == null ? other.getIsglobonus() == null : this.getIsglobonus().equals(other.getIsglobonus()))
            && (this.getMerchapply() == null ? other.getMerchapply() == null : this.getMerchapply().equals(other.getMerchapply()))
            && (this.getIsabonus() == null ? other.getIsabonus() == null : this.getIsabonus().equals(other.getIsabonus()))
            && (this.getIsborrow() == null ? other.getIsborrow() == null : this.getIsborrow().equals(other.getIsborrow()))
            && (this.getBorrowopenid() == null ? other.getBorrowopenid() == null : this.getBorrowopenid().equals(other.getBorrowopenid()))
            && (this.getMerchisdiscountprice() == null ? other.getMerchisdiscountprice() == null : this.getMerchisdiscountprice().equals(other.getMerchisdiscountprice()))
            && (this.getApppay() == null ? other.getApppay() == null : this.getApppay().equals(other.getApppay()))
            && (this.getCoupongoodprice() == null ? other.getCoupongoodprice() == null : this.getCoupongoodprice().equals(other.getCoupongoodprice()))
            && (this.getBuyagainprice() == null ? other.getBuyagainprice() == null : this.getBuyagainprice().equals(other.getBuyagainprice()))
            && (this.getIspackage() == null ? other.getIspackage() == null : this.getIspackage().equals(other.getIspackage()))
            && (this.getPackageid() == null ? other.getPackageid() == null : this.getPackageid().equals(other.getPackageid()))
            && (this.getTaskdiscountprice() == null ? other.getTaskdiscountprice() == null : this.getTaskdiscountprice().equals(other.getTaskdiscountprice()))
            && (this.getSeckilldiscountprice() == null ? other.getSeckilldiscountprice() == null : this.getSeckilldiscountprice().equals(other.getSeckilldiscountprice()))
            && (this.getVerifyendtime() == null ? other.getVerifyendtime() == null : this.getVerifyendtime().equals(other.getVerifyendtime()))
            && (this.getWillcancelmessage() == null ? other.getWillcancelmessage() == null : this.getWillcancelmessage().equals(other.getWillcancelmessage()))
            && (this.getSendtype() == null ? other.getSendtype() == null : this.getSendtype().equals(other.getSendtype()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCourier() == null ? other.getCourier() == null : this.getCourier().equals(other.getCourier()))
            && (this.getIssettlement() == null ? other.getIssettlement() == null : this.getIssettlement().equals(other.getIssettlement()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getAgentid() == null) ? 0 : getAgentid().hashCode());
        result = prime * result + ((getOrdersn() == null) ? 0 : getOrdersn().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getGoodsprice() == null) ? 0 : getGoodsprice().hashCode());
        result = prime * result + ((getDiscountprice() == null) ? 0 : getDiscountprice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        result = prime * result + ((getTransid() == null) ? 0 : getTransid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAddressid() == null) ? 0 : getAddressid().hashCode());
        result = prime * result + ((getDispatchprice() == null) ? 0 : getDispatchprice().hashCode());
        result = prime * result + ((getDispatchid() == null) ? 0 : getDispatchid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDispatchtype() == null) ? 0 : getDispatchtype().hashCode());
        result = prime * result + ((getRefundid() == null) ? 0 : getRefundid().hashCode());
        result = prime * result + ((getIscomment() == null) ? 0 : getIscomment().hashCode());
        result = prime * result + ((getCreditadd() == null) ? 0 : getCreditadd().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getUserdeleted() == null) ? 0 : getUserdeleted().hashCode());
        result = prime * result + ((getFinishtime() == null) ? 0 : getFinishtime().hashCode());
        result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
        result = prime * result + ((getExpresscom() == null) ? 0 : getExpresscom().hashCode());
        result = prime * result + ((getExpresssn() == null) ? 0 : getExpresssn().hashCode());
        result = prime * result + ((getExpress() == null) ? 0 : getExpress().hashCode());
        result = prime * result + ((getSendtime() == null) ? 0 : getSendtime().hashCode());
        result = prime * result + ((getSortingtime() == null) ? 0 : getSortingtime().hashCode());
        result = prime * result + ((getFetchtime() == null) ? 0 : getFetchtime().hashCode());
        result = prime * result + ((getCash() == null) ? 0 : getCash().hashCode());
        result = prime * result + ((getCanceltime() == null) ? 0 : getCanceltime().hashCode());
        result = prime * result + ((getCancelpaytime() == null) ? 0 : getCancelpaytime().hashCode());
        result = prime * result + ((getRefundtime() == null) ? 0 : getRefundtime().hashCode());
        result = prime * result + ((getIsverify() == null) ? 0 : getIsverify().hashCode());
        result = prime * result + ((getVerified() == null) ? 0 : getVerified().hashCode());
        result = prime * result + ((getVerifyopenid() == null) ? 0 : getVerifyopenid().hashCode());
        result = prime * result + ((getVerifytime() == null) ? 0 : getVerifytime().hashCode());
        result = prime * result + ((getVerifycode() == null) ? 0 : getVerifycode().hashCode());
        result = prime * result + ((getVerifystoreid() == null) ? 0 : getVerifystoreid().hashCode());
        result = prime * result + ((getDeductprice() == null) ? 0 : getDeductprice().hashCode());
        result = prime * result + ((getDeductcredit() == null) ? 0 : getDeductcredit().hashCode());
        result = prime * result + ((getDeductcredit2() == null) ? 0 : getDeductcredit2().hashCode());
        result = prime * result + ((getDeductenough() == null) ? 0 : getDeductenough().hashCode());
        result = prime * result + ((getVirtual() == null) ? 0 : getVirtual().hashCode());
        result = prime * result + ((getSysdeleted() == null) ? 0 : getSysdeleted().hashCode());
        result = prime * result + ((getOrdersn2() == null) ? 0 : getOrdersn2().hashCode());
        result = prime * result + ((getChangeprice() == null) ? 0 : getChangeprice().hashCode());
        result = prime * result + ((getChangedispatchprice() == null) ? 0 : getChangedispatchprice().hashCode());
        result = prime * result + ((getOldprice() == null) ? 0 : getOldprice().hashCode());
        result = prime * result + ((getOlddispatchprice() == null) ? 0 : getOlddispatchprice().hashCode());
        result = prime * result + ((getIsvirtual() == null) ? 0 : getIsvirtual().hashCode());
        result = prime * result + ((getCouponid() == null) ? 0 : getCouponid().hashCode());
        result = prime * result + ((getCouponprice() == null) ? 0 : getCouponprice().hashCode());
        result = prime * result + ((getDiyformid() == null) ? 0 : getDiyformid().hashCode());
        result = prime * result + ((getStoreid() == null) ? 0 : getStoreid().hashCode());
        result = prime * result + ((getPrintstate() == null) ? 0 : getPrintstate().hashCode());
        result = prime * result + ((getPrintstate2() == null) ? 0 : getPrintstate2().hashCode());
        result = prime * result + ((getRefundstate() == null) ? 0 : getRefundstate().hashCode());
        result = prime * result + ((getIsmr() == null) ? 0 : getIsmr().hashCode());
        result = prime * result + ((getIsdiscountprice() == null) ? 0 : getIsdiscountprice().hashCode());
        result = prime * result + ((getIsvirtualsend() == null) ? 0 : getIsvirtualsend().hashCode());
        result = prime * result + ((getVerifytype() == null) ? 0 : getVerifytype().hashCode());
        result = prime * result + ((getMerchid() == null) ? 0 : getMerchid().hashCode());
        result = prime * result + ((getInvoicename() == null) ? 0 : getInvoicename().hashCode());
        result = prime * result + ((getIsmerch() == null) ? 0 : getIsmerch().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getIsparent() == null) ? 0 : getIsparent().hashCode());
        result = prime * result + ((getGrprice() == null) ? 0 : getGrprice().hashCode());
        result = prime * result + ((getMerchshow() == null) ? 0 : getMerchshow().hashCode());
        result = prime * result + ((getMerchdeductenough() == null) ? 0 : getMerchdeductenough().hashCode());
        result = prime * result + ((getCouponmerchid() == null) ? 0 : getCouponmerchid().hashCode());
        result = prime * result + ((getIsglobonus() == null) ? 0 : getIsglobonus().hashCode());
        result = prime * result + ((getMerchapply() == null) ? 0 : getMerchapply().hashCode());
        result = prime * result + ((getIsabonus() == null) ? 0 : getIsabonus().hashCode());
        result = prime * result + ((getIsborrow() == null) ? 0 : getIsborrow().hashCode());
        result = prime * result + ((getBorrowopenid() == null) ? 0 : getBorrowopenid().hashCode());
        result = prime * result + ((getMerchisdiscountprice() == null) ? 0 : getMerchisdiscountprice().hashCode());
        result = prime * result + ((getApppay() == null) ? 0 : getApppay().hashCode());
        result = prime * result + ((getCoupongoodprice() == null) ? 0 : getCoupongoodprice().hashCode());
        result = prime * result + ((getBuyagainprice() == null) ? 0 : getBuyagainprice().hashCode());
        result = prime * result + ((getIspackage() == null) ? 0 : getIspackage().hashCode());
        result = prime * result + ((getPackageid() == null) ? 0 : getPackageid().hashCode());
        result = prime * result + ((getTaskdiscountprice() == null) ? 0 : getTaskdiscountprice().hashCode());
        result = prime * result + ((getSeckilldiscountprice() == null) ? 0 : getSeckilldiscountprice().hashCode());
        result = prime * result + ((getVerifyendtime() == null) ? 0 : getVerifyendtime().hashCode());
        result = prime * result + ((getWillcancelmessage() == null) ? 0 : getWillcancelmessage().hashCode());
        result = prime * result + ((getSendtype() == null) ? 0 : getSendtype().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getCourier() == null) ? 0 : getCourier().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getIssettlement() == null) ? 0 : getIssettlement().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uniacid=").append(uniacid);
        sb.append(", openid=").append(openid);
        sb.append(", memberId=").append(memberId);
        sb.append(", agentid=").append(agentid);
        sb.append(", ordersn=").append(ordersn);
        sb.append(", price=").append(price);
        sb.append(", goodsprice=").append(goodsprice);
        sb.append(", discountprice=").append(discountprice);
        sb.append(", status=").append(status);
        sb.append(", paytype=").append(paytype);
        sb.append(", transid=").append(transid);
        sb.append(", remark=").append(remark);
        sb.append(", addressid=").append(addressid);
        sb.append(", dispatchprice=").append(dispatchprice);
        sb.append(", dispatchid=").append(dispatchid);
        sb.append(", createtime=").append(createtime);
        sb.append(", dispatchtype=").append(dispatchtype);
        sb.append(", refundid=").append(refundid);
        sb.append(", iscomment=").append(iscomment);
        sb.append(", creditadd=").append(creditadd);
        sb.append(", deleted=").append(deleted);
        sb.append(", userdeleted=").append(userdeleted);
        sb.append(", finishtime=").append(finishtime);
        sb.append(", paytime=").append(paytime);
        sb.append(", expresscom=").append(expresscom);
        sb.append(", expresssn=").append(expresssn);
        sb.append(", express=").append(express);
        sb.append(", sendtime=").append(sendtime);
        sb.append(", sortingtime=").append(sortingtime);
        sb.append(", fetchtime=").append(fetchtime);
        sb.append(", cash=").append(cash);
        sb.append(", canceltime=").append(canceltime);
        sb.append(", cancelpaytime=").append(cancelpaytime);
        sb.append(", refundtime=").append(refundtime);
        sb.append(", isverify=").append(isverify);
        sb.append(", verified=").append(verified);
        sb.append(", verifyopenid=").append(verifyopenid);
        sb.append(", verifytime=").append(verifytime);
        sb.append(", verifycode=").append(verifycode);
        sb.append(", verifystoreid=").append(verifystoreid);
        sb.append(", deductprice=").append(deductprice);
        sb.append(", deductcredit=").append(deductcredit);
        sb.append(", deductcredit2=").append(deductcredit2);
        sb.append(", deductenough=").append(deductenough);
        sb.append(", virtual=").append(virtual);
        sb.append(", sysdeleted=").append(sysdeleted);
        sb.append(", ordersn2=").append(ordersn2);
        sb.append(", changeprice=").append(changeprice);
        sb.append(", changedispatchprice=").append(changedispatchprice);
        sb.append(", oldprice=").append(oldprice);
        sb.append(", olddispatchprice=").append(olddispatchprice);
        sb.append(", isvirtual=").append(isvirtual);
        sb.append(", couponid=").append(couponid);
        sb.append(", couponprice=").append(couponprice);
        sb.append(", diyformid=").append(diyformid);
        sb.append(", storeid=").append(storeid);
        sb.append(", printstate=").append(printstate);
        sb.append(", printstate2=").append(printstate2);
        sb.append(", refundstate=").append(refundstate);
        sb.append(", ismr=").append(ismr);
        sb.append(", isdiscountprice=").append(isdiscountprice);
        sb.append(", isvirtualsend=").append(isvirtualsend);
        sb.append(", verifytype=").append(verifytype);
        sb.append(", merchid=").append(merchid);
        sb.append(", invoicename=").append(invoicename);
        sb.append(", ismerch=").append(ismerch);
        sb.append(", parentid=").append(parentid);
        sb.append(", isparent=").append(isparent);
        sb.append(", grprice=").append(grprice);
        sb.append(", merchshow=").append(merchshow);
        sb.append(", merchdeductenough=").append(merchdeductenough);
        sb.append(", couponmerchid=").append(couponmerchid);
        sb.append(", isglobonus=").append(isglobonus);
        sb.append(", merchapply=").append(merchapply);
        sb.append(", isabonus=").append(isabonus);
        sb.append(", isborrow=").append(isborrow);
        sb.append(", borrowopenid=").append(borrowopenid);
        sb.append(", merchisdiscountprice=").append(merchisdiscountprice);
        sb.append(", apppay=").append(apppay);
        sb.append(", coupongoodprice=").append(coupongoodprice);
        sb.append(", buyagainprice=").append(buyagainprice);
        sb.append(", ispackage=").append(ispackage);
        sb.append(", packageid=").append(packageid);
        sb.append(", taskdiscountprice=").append(taskdiscountprice);
        sb.append(", seckilldiscountprice=").append(seckilldiscountprice);
        sb.append(", verifyendtime=").append(verifyendtime);
        sb.append(", willcancelmessage=").append(willcancelmessage);
        sb.append(", sendtype=").append(sendtype);
        sb.append(", code=").append(code);
        sb.append(", courier=").append(courier);
        sb.append(", orderType=").append(orderType);
        sb.append(", issettlement=").append(issettlement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}