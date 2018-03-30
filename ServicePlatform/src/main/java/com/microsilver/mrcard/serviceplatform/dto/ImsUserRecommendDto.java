package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;

import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;

public class ImsUserRecommendDto extends ImsUserRecommend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String avatar;
	private String nickname;
	private String mobile;
	private String vipTypeName;
	/**
	 * 普通用户注册时间
	 */
	private Integer createtime;
	
	
	public Integer getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getVipTypeName() {
		return this.vipTypeName;
	}
	public void setVipTypeName(String vipTypeName) {
		this.vipTypeName = vipTypeName;
	}
	@Override
	public String toString() {
		return "ImsUserRecommendDto [avatar=" + avatar + ", nickname=" + nickname + ", mobile=" + mobile
				+ ", vipTypeName=" + vipTypeName + ", createtime=" + createtime + "]";
	}
}
