package com.microsliver.model.dao;

import java.io.Serializable;

public class ImsUserRecommend implements Serializable {

	private Long memberId;

	private byte vipType;

	private Long level1ParentId;

	private Long level2ParentId;

	private Long rootId;

	private Integer beginTime;

	private byte isSettlement;

	private static final long serialVersionUID = 1L;

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

	public Long getLevel1ParentId() {
		return level1ParentId;
	}

	public void setLevel1ParentId(Long level1ParentId) {
		this.level1ParentId = level1ParentId;
	}

	public Long getLevel2ParentId() {
		return level2ParentId;
	}

	public void setLevel2ParentId(Long level2ParentId) {
		this.level2ParentId = level2ParentId;
	}

	public Long getRootId() {
		return rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

	public Integer getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	public byte getIsSettlement() {
		return isSettlement;
	}

	public void setIsSettlement(byte isSettlement) {
		this.isSettlement = isSettlement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
