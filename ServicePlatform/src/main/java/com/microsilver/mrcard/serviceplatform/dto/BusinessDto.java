package com.microsilver.mrcard.serviceplatform.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.BusinessDTO
 * @Description 商家数据传输类
 * 
 * @Author bruce
 * @Version 2017年6月30日 上午9:33:20
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class BusinessDto {
	/**
	 * 申请状态(0:待审核,1:通过,-1:审核未通过,-2:新注册，未填写资料)
	 */
	@ApiModelProperty(value = "申请状态(0:待审核,1:通过,-1:审核未通过,-2:新注册，未填写资料)", required = true)
	private int regStatus;
	
	private Long memberId;
	
	private String openId;
	/**
	 * 总帐号(开通区域账号)
	 */
	@ApiModelProperty(value = "总帐号(开通区域账号)", required = true)
	private Integer uniacId;
	@ApiModelProperty(value = "用户身份列表")
	private List<BusinessIdentityDto> identityList;

	public int getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(int regStatus) {
		this.regStatus = regStatus;
	}

	public List<BusinessIdentityDto> getIdentityList() {
		return identityList;
	}
	
	public void setIdentityList(List<BusinessIdentityDto> identityList) {
		this.identityList = identityList;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getUniacId() {
		return uniacId;
	}

	public void setUniacId(Integer uniacId) {
		this.uniacId = uniacId;
	}
	
	
	
}
