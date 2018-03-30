package com.microsilver.mrcard.mq;

public class MemberMQ {
	/**
	 * 新注册用户
	 */
	private Long regMemberId;
	/**
	 * 类型(1:推荐用户)
	 */
	private int type;
	/**
	 * 推荐人
	 */
	private Long refereeMemberId;

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getRegMemberId() {
		return regMemberId;
	}

	public void setRegMemberId(Long regMemberId) {
		this.regMemberId = regMemberId;
	}

	public Long getRefereeMemberId() {
		return refereeMemberId;
	}

	public void setRefereeMemberId(Long refereeMemberId) {
		this.refereeMemberId = refereeMemberId;
	}

	
}
