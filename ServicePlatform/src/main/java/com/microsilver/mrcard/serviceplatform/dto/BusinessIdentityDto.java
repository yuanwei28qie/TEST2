package com.microsilver.mrcard.serviceplatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.BusinessIdentityDto
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月5日 上午11:43:16
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class BusinessIdentityDto extends ImsEweiShopMemberIdentity{
	private String merchname;
	private String logo;
	private Integer groupId;
	/**
	 * 服务到期时间
	 */
	@ApiModelProperty(value = "服务到期时间")
	private Long accounttime;
	
	public String getMerchname() {
		return merchname;
	}
	public void setMerchname(String merchname) {
		this.merchname = merchname;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Long getAccounttime() {
		return accounttime;
	}
	public void setAccounttime(Long accounttime) {
		this.accounttime = accounttime;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
}
