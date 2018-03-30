package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopOrder implements Serializable {
    private Long id;

    private Integer uniacid;

    private String openid;
    
    private Long memberId;

    private Integer agentid;

    private String ordersn;

    private BigDecimal price;
    /**
     * 运费 
     */
    private BigDecimal dispatchprice;

    private BigDecimal goodsprice;
    private BigDecimal subsidyprice;

    public BigDecimal getSubsidyprice() {
		return subsidyprice;
	}

	public void setSubsidyprice(BigDecimal subsidyprice) {
		this.subsidyprice = subsidyprice;
	}

	private BigDecimal discountprice;

    private Integer status;

    private byte paytype;

    private String transid;

    private String remark;
    private Integer addressid;
    private Integer createtime;
    private Byte deleted;
    private Integer finishtime;
    private Integer paytime;
    
    private Integer sortingtime;

    private String expresscom;

    private String expresssn;

    private String express;

    private Integer sendtime;
    /**
     * 配送方式(0 商家配送 ,1 自提,2 不需要配送) 
     */
    private Integer dispatchtype;

    private Integer fetchtime;


    private Integer canceltime;

    private Integer cancelpaytime;

    private Integer refundtime;



    private String remarksaler;
    private Byte sysdeleted;



    private Integer storeid;
    /**
     * 取消发货备注
     */
    private String remarksend;

    private Long merchid;

    private Byte sendtype;

    private Float code;
    /**
     * 快递员
     */
    private Long courier;
    
    private Byte orderType;
    
    private Integer activityId;
    
    private Byte sourceType;
    
    private BigDecimal costprice;
    


	public BigDecimal getCostprice() {
		return costprice;
	}

	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}

    /**
     * 代理商信息
     */
    private Long provinceAgentIdttId;

    private Long cityAgentIdttId;

    private Long countyAgentIdttId;


    public Byte getSourceType() {
		return sourceType;
	}

	public void setSourceType(Byte sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    

	public BigDecimal getDispatchprice() {
		return dispatchprice;
	}

	public void setDispatchprice(BigDecimal dispatchprice) {
		this.dispatchprice = dispatchprice;
	}

	public Integer getDispatchtype() {
		return dispatchtype;
	}

	public void setDispatchtype(Integer dispatchtype) {
		this.dispatchtype = dispatchtype;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public byte getPaytype() {
        return paytype;
    }

    public void setPaytype(byte paytype) {
        this.paytype = paytype;
    }

    
    public String getRemarksaler() {
		return remarksaler;
	}

	public void setRemarksaler(String remarksaler) {
		this.remarksaler = remarksaler;
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

   

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

   

   

    public Integer getSortingtime() {
		return sortingtime;
	}

	public void setSortingtime(Integer sortingtime) {
		this.sortingtime = sortingtime;
	}

	public Long getMerchid() {
		return merchid;
	}

	public void setMerchid(Long merchid) {
		this.merchid = merchid;
	}

	public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    
    public Integer getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Integer finishtime) {
        this.finishtime = finishtime;
    }

    public Integer getPaytime() {
        return paytime;
    }

    public void setPaytime(Integer paytime) {
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

    public Integer getFetchtime() {
        return fetchtime;
    }

    public void setFetchtime(Integer fetchtime) {
        this.fetchtime = fetchtime;
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

    

    public Byte getSysdeleted() {
        return sysdeleted;
    }

    public void setSysdeleted(Byte sysdeleted) {
        this.sysdeleted = sysdeleted;
    }


    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
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
    

    public String getRemarksend() {
		return remarksend;
	}

	public void setRemarksend(String remarksend) {
		this.remarksend = remarksend;
	}

	public Long getCourier() {
		return courier;
	}

	public void setCourier(Long courier) {
		this.courier = courier;
	}

    public Long getProvinceAgentIdttId() {
        return provinceAgentIdttId;
    }

    public void setProvinceAgentIdttId(Long provinceAgentIdttId) {
        this.provinceAgentIdttId = provinceAgentIdttId;
    }

    public Long getCityAgentIdttId() {
        return cityAgentIdttId;
    }

    public void setCityAgentIdttId(Long cityAgentIdttId) {
        this.cityAgentIdttId = cityAgentIdttId;
    }

    public Long getCountyAgentIdttId() {
        return countyAgentIdttId;
    }

    public void setCountyAgentIdttId(Long countyAgentIdttId) {
        this.countyAgentIdttId = countyAgentIdttId;
    }

	@Override
	public String toString() {
		return "ImsEweiShopOrder [id=" + id + ", uniacid=" + uniacid + ", openid=" + openid + ", memberId=" + memberId
				+ ", agentid=" + agentid + ", ordersn=" + ordersn + ", price=" + price + ", dispatchprice="
				+ dispatchprice + ", goodsprice=" + goodsprice + ", subsidyprice=" + subsidyprice + ", discountprice="
				+ discountprice + ", status=" + status + ", paytype=" + paytype + ", transid=" + transid + ", remark="
				+ remark + ", addressid=" + addressid + ", createtime=" + createtime + ", deleted=" + deleted
				+ ", finishtime=" + finishtime + ", paytime=" + paytime + ", sortingtime=" + sortingtime
				+ ", expresscom=" + expresscom + ", expresssn=" + expresssn + ", express=" + express + ", sendtime="
				+ sendtime + ", dispatchtype=" + dispatchtype + ", fetchtime=" + fetchtime + ", canceltime="
				+ canceltime + ", cancelpaytime=" + cancelpaytime + ", refundtime=" + refundtime + ", remarksaler="
				+ remarksaler + ", sysdeleted=" + sysdeleted + ", storeid=" + storeid + ", remarksend=" + remarksend
				+ ", merchid=" + merchid + ", sendtype=" + sendtype + ", code=" + code + ", courier=" + courier
				+ ", orderType=" + orderType + ", activityId=" + activityId + ", sourceType=" + sourceType
				+ ", costprice=" + costprice + ", provinceAgentIdttId=" + provinceAgentIdttId + ", cityAgentIdttId="
				+ cityAgentIdttId + ", countyAgentIdttId=" + countyAgentIdttId + "]";
	}
}