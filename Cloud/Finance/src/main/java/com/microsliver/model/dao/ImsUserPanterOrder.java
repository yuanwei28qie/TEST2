package com.microsliver.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsUserPanterOrder implements Serializable {
	   private Long id;

	    private String ordersn;

	    private Long memberId;
	    
	    private byte vipType;

	    private BigDecimal amount;

	    private Integer createTime;

	    private Integer payTime;

	    private Byte payType;

	    private Byte status;

	    private String transId;

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

		public Long getMemberId() {
			return memberId;
		}

		public void setMemberId(Long memberId) {
			this.memberId = memberId;
		}

		public byte getVipType() {
			return vipType;
		}

		public void setVipType(byte vipType) {
			this.vipType = vipType;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public Integer getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Integer createTime) {
			this.createTime = createTime;
		}

		public Integer getPayTime() {
			return payTime;
		}

		public void setPayTime(Integer payTime) {
			this.payTime = payTime;
		}

		public Byte getPayType() {
			return payType;
		}

		public void setPayType(Byte payType) {
			this.payType = payType;
		}

		public Byte getStatus() {
			return status;
		}

		public void setStatus(Byte status) {
			this.status = status;
		}

		public String getTransId() {
			return transId;
		}

		public void setTransId(String transId) {
			this.transId = transId;
		}

		public Byte getIsSettlement() {
			return isSettlement;
		}

		public void setIsSettlement(Byte isSettlement) {
			this.isSettlement = isSettlement;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
