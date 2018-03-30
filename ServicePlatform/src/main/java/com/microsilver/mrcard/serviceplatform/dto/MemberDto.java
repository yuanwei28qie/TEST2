package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.MemberDto
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年8月29日 上午11:49:46
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
@ApiModel(description="会员DTO类")
public class MemberDto implements Serializable{
	@ApiModelProperty(value = "会员编号", required = true)
	private Long id;
	
	private String pwd;
	private String salt;
	
	@ApiModelProperty(value = "是否加入黑名单(1:已加入,0:未加入)", required = false)
	private int isblack;
	@ApiModelProperty(value = "实名认证状态(-1:未申请,0:审核未通过,1:待审核,2:已审核)", required = true)
	private byte checkStatus;
	@ApiModelProperty(value = "昵称", required = true)
	private String nickname;
	@ApiModelProperty(value = "真实姓名", required = false)
	private String realname;
	@ApiModelProperty(value = "头像", required = true)
	private String avatar;
	@ApiModelProperty(value = "身份附加信息", required = false)
	private List<IdentityDto> idttList;
	@ApiModelProperty(value = "融云token", required = false)
	private String rongcloudToken;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getIsblack() {
		return isblack;
	}
	public void setIsblack(int isblack) {
		this.isblack = isblack;
	}
	
	public byte getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(byte checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public List<IdentityDto> getIdttList() {
		return idttList;
	}
	public void setIdttList(List<IdentityDto> idttList) {
		this.idttList = idttList;
	}
	public String getRongcloudToken() {
		return rongcloudToken;
	}
	public void setRongcloudToken(String rongcloudToken) {
		this.rongcloudToken = rongcloudToken;
	}
	
	
	
	
}
