package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsCrowdsourcingOrderLog implements Serializable {
    private Long id;

    private Long orderId;

    private Long memberId;

    private Byte identity;

    private Byte operateStatus;

    private Integer operateTime;
    
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
    }

    public Byte getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Byte operateStatus) {
        this.operateStatus = operateStatus;
    }

    public Integer getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Integer operateTime) {
        this.operateTime = operateTime;
    }

	@Override
	public String toString() {
		return "ImsCrowdsourcingOrderLog [id=" + id + ", orderId=" + orderId + ", memberId=" + memberId + ", identity="
				+ identity + ", operateStatus=" + operateStatus + ", operateTime=" + operateTime + ", remark=" + remark
				+ "]";
	}

}