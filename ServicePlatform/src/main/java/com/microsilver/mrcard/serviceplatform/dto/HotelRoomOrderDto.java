package com.microsilver.mrcard.serviceplatform.dto;

public class HotelRoomOrderDto {
	private Long orderId;
	private Long memberId;
	private String nickname;
	private String memberMobile;
	private String hotolName;
	private String roomName;
	private String hotelMobile;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMemberMobile() {
		return memberMobile;
	}
	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}
	public String getHotolName() {
		return hotolName;
	}
	public void setHotolName(String hotolName) {
		this.hotolName = hotolName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getHotelMobile() {
		return hotelMobile;
	}
	public void setHotelMobile(String hotelMobile) {
		this.hotelMobile = hotelMobile;
	}
	
	
	
}
