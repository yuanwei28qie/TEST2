package com.microsilver.mrcard.serviceplatform.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ImsCrowdsourcingOrder implements Serializable {
    private Long id;

    private String ordersn;
    @ApiModelProperty(value = "服务描述")
    private String serviceDesc;
    @ApiModelProperty(value = "商品预估费用")
    private BigDecimal goodsEstimatePrice;
    @ApiModelProperty(value = "商品协商费用")
    private BigDecimal goodsConsultPrice;
    @ApiModelProperty(value = "运费")
    private BigDecimal dispatchPrice;
    @ApiModelProperty(value = "小费")
    private BigDecimal tipPrice;
    @ApiModelProperty(value = "会员id")
    private Long memberId;
    @ApiModelProperty(value = "快递员（会员编号）")
    private Long courier;
    @ApiModelProperty(value = "创建时间")
    private Integer createTime;
    @ApiModelProperty(value = "状态(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,8:订单退款,0:订单取消,-1:订单已锁定）")
    private Byte status;
    @ApiModelProperty(value = "收货地址编号")
    private Long addressId;
    @ApiModelProperty(value = "收货人姓名")
    private String receiveName;
    @ApiModelProperty(value = "收货人电话")
    private String receivePhone;
    @ApiModelProperty(value = "收货地址")
    private String receiveAddress;
    @ApiModelProperty(value = "经度")
    private String receiveLat;
    @ApiModelProperty(value = "纬度")
    private String receiveLng;
    //@ApiModelProperty(value = "用户是否删除")
    private Boolean userDelete;
    //@ApiModelProperty(value = "快递是否删除")
    private Boolean courierDelete;
    @ApiModelProperty(value = "用户是否评价")
    private Boolean userAppraise;
    @ApiModelProperty(value = "快递是否评价")
    private Boolean courierAppraise;
    @ApiModelProperty(value = "订单所在区域编号")
    private Integer areaCode;
    @ApiModelProperty(value = "取货码")
    private String pickupNumber;
    
    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "订单来源(1:android,2:ios,3:微信)")
    private Byte sourceType;
    
    @ApiModelProperty("支付类型 1为余额支付 2在线支付 3 货到付款 11 后台付款 21 微信支付 22 支付宝支付 23 银联支付")
    private Byte payType;
    
	@ApiModelProperty("距离")
	private Integer distance;
	
	@ApiModelProperty("用户评分")	
    private BigDecimal userScore;
	@ApiModelProperty("用户头像")	
    private String userAvatar;
	@ApiModelProperty("骑士评分")	
    private BigDecimal courierScore;
	
	@ApiModelProperty("骑士历史完成订单数")	
    private Integer courierTotalFinished;
	
	@ApiModelProperty("骑士头像")	
	private String courierAvatar;
	@ApiModelProperty("骑士真实姓名")	
	private String courierRealname;
	@ApiModelProperty("骑士电话")	
	private String courierMobile;

    // 结算状态(-1结算失败，0:未结算,1: 预结算，2以结算)
    private Byte isSettlement;

    private Long provinceAgentIdttId;

    private Long cityAgentIdttId;

    private Long countyAgentIdttId;

	@ApiModelProperty("总价:以分为单位")	
	private Integer totalAmountCent;
	
    private static final long serialVersionUID = 1L;
   
    
    public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public BigDecimal getCourierScore() {
		return courierScore;
	}

	public void setCourierScore(BigDecimal courierScore) {
		this.courierScore = courierScore;
	}

	public String getCourierAvatar() {
		return courierAvatar;
	}

	public void setCourierAvatar(String courierAvatar) {
		this.courierAvatar = courierAvatar;
	}

	public String getCourierRealname() {
		return courierRealname;
	}

	public void setCourierRealname(String courierRealname) {
		this.courierRealname = courierRealname;
	}

	public String getCourierMobile() {
		return courierMobile;
	}

	public void setCourierMobile(String courierMobile) {
		this.courierMobile = courierMobile;
	}

	public Integer getCourierTotalFinished() {
		return courierTotalFinished;
	}

	public void setCourierTotalFinished(Integer courierTotalFinished) {
		this.courierTotalFinished = courierTotalFinished;
	}

	public BigDecimal getUserScore() {
		return userScore;
	}

	public void setUserScore(BigDecimal userScore) {
		this.userScore = userScore;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalAmountCent() {
		return totalAmount.multiply(new BigDecimal(100)).intValue();
	}

	public void setTotalAmountCent(Integer totalAmountCent) {
		this.totalAmountCent = totalAmountCent;
	}

	public Byte getSourceType() {
		return sourceType;
	}

	public void setSourceType(Byte sourceType) {
		this.sourceType = sourceType;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
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

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public BigDecimal getGoodsEstimatePrice() {
        return goodsEstimatePrice;
    }

    public void setGoodsEstimatePrice(BigDecimal goodsEstimatePrice) {
        this.goodsEstimatePrice = goodsEstimatePrice;
    }

    public BigDecimal getGoodsConsultPrice() {
        return goodsConsultPrice;
    }

    public void setGoodsConsultPrice(BigDecimal goodsConsultPrice) {
        this.goodsConsultPrice = goodsConsultPrice;
    }

    public BigDecimal getDispatchPrice() {
        return dispatchPrice;
    }

    public void setDispatchPrice(BigDecimal dispatchPrice) {
        this.dispatchPrice = dispatchPrice;
    }

    public BigDecimal getTipPrice() {
        return tipPrice;
    }

    public void setTipPrice(BigDecimal tipPrice) {
        this.tipPrice = tipPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCourier() {
        return courier;
    }

    public void setCourier(Long courier) {
        this.courier = courier;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceiveLat() {
        return receiveLat;
    }

    public void setReceiveLat(String receiveLat) {
        this.receiveLat = receiveLat;
    }

    public String getReceiveLng() {
        return receiveLng;
    }

    public void setReceiveLng(String receiveLng) {
        this.receiveLng = receiveLng;
    }

    public Boolean getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(Boolean userDelete) {
        this.userDelete = userDelete;
    }

    public Boolean getCourierDelete() {
        return courierDelete;
    }

    public void setCourierDelete(Boolean courierDelete) {
        this.courierDelete = courierDelete;
    }

    public Boolean getUserAppraise() {
        return userAppraise;
    }

    public void setUserAppraise(Boolean userAppraise) {
        this.userAppraise = userAppraise;
    }

    public Boolean getCourierAppraise() {
        return courierAppraise;
    }

    public void setCourierAppraise(Boolean courierAppraise) {
        this.courierAppraise = courierAppraise;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getPickupNumber() {
        return pickupNumber;
    }

    public void setPickupNumber(String pickupNumber) {
        this.pickupNumber = pickupNumber;
    }

    public Byte getIsSettlement() {
        return isSettlement;
    }

    public void setIsSettlement(Byte isSettlement) {
        this.isSettlement = isSettlement;
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
		return "ImsCrowdsourcingOrder [id=" + id + ", ordersn=" + ordersn + ", serviceDesc=" + serviceDesc
				+ ", goodsEstimatePrice=" + goodsEstimatePrice + ", goodsConsultPrice=" + goodsConsultPrice
				+ ", dispatchPrice=" + dispatchPrice + ", tipPrice=" + tipPrice + ", memberId=" + memberId
				+ ", courier=" + courier + ", createTime=" + createTime + ", status=" + status + ", addressId="
				+ addressId + ", receiveName=" + receiveName + ", receivePhone=" + receivePhone + ", receiveAddress="
				+ receiveAddress + ", receiveLat=" + receiveLat + ", receiveLng=" + receiveLng + ", userDelete="
				+ userDelete + ", courierDelete=" + courierDelete + ", userAppraise=" + userAppraise
				+ ", courierAppraise=" + courierAppraise + ", areaCode=" + areaCode + ", pickupNumber=" + pickupNumber
				+ ", totalAmount=" + totalAmount + ", sourceType=" + sourceType + ", payType=" + payType + ", distance="
				+ distance + ", userScore=" + userScore + ", courierTotalFinished=" + courierTotalFinished
				+ ", courierAvatar=" + courierAvatar + ", courierRealname=" + courierRealname + ", courierMobile="
				+ courierMobile + ", isSettlement=" + isSettlement + "]";
	}

}