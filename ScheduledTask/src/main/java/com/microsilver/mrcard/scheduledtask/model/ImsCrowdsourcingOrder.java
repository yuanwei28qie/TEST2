package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsCrowdsourcingOrder implements Serializable {
    private Long id;

    private String ordersn;

    private String serviceDesc;

    private BigDecimal goodsEstimatePrice;

    private BigDecimal goodsConsultPrice;

    private BigDecimal dispatchPrice;

    private BigDecimal tipPrice;

    private BigDecimal totalAmount;

    private Long memberId;

    private Long courier;

    private Integer createTime;

    private Byte status;

    private Long addressId;

    private String receiveName;

    private String receivePhone;

    private String receiveAddress;

    private String receiveLat;

    private String receiveLng;

    private Boolean userDelete;

    private Boolean courierDelete;

    private Boolean userAppraise;

    private Boolean courierAppraise;

    private Integer areaCode;

    private String pickupNumber;

    private Byte sourceType;

    private Byte payType;

    private Byte isSettlement;

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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    public Byte getIsSettlement() {
        return isSettlement;
    }

    public void setIsSettlement(Byte isSettlement) {
        this.isSettlement = isSettlement;
    }

	@Override
	public String toString() {
		return "ImsCrowdsourcingOrder [id=" + id + ", ordersn=" + ordersn + ", serviceDesc=" + serviceDesc
				+ ", goodsEstimatePrice=" + goodsEstimatePrice + ", goodsConsultPrice=" + goodsConsultPrice
				+ ", dispatchPrice=" + dispatchPrice + ", tipPrice=" + tipPrice + ", totalAmount=" + totalAmount
				+ ", memberId=" + memberId + ", courier=" + courier + ", createTime=" + createTime + ", status="
				+ status + ", addressId=" + addressId + ", receiveName=" + receiveName + ", receivePhone="
				+ receivePhone + ", receiveAddress=" + receiveAddress + ", receiveLat=" + receiveLat + ", receiveLng="
				+ receiveLng + ", userDelete=" + userDelete + ", courierDelete=" + courierDelete + ", userAppraise="
				+ userAppraise + ", courierAppraise=" + courierAppraise + ", areaCode=" + areaCode + ", pickupNumber="
				+ pickupNumber + ", sourceType=" + sourceType + ", payType=" + payType + ", isSettlement="
				+ isSettlement + "]";
	}
}