package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.IdentityDto
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年8月29日 下午2:48:04
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
@ApiModel(description="身份DTO类")
public class IdentityDto implements Serializable{
	@ApiModelProperty(value = "身份编号", required = true)
	private int identity;
	@ApiModelProperty(value = "身份评价分", required = true)
	private BigDecimal score;
	@ApiModelProperty(value = "身份状态(2:禁用)", required = true)
	private byte status;
	@ApiModelProperty(value = "是否工作(1:工作,0:休息)", required = true)
	private boolean iswork;
	@ApiModelProperty(value = "融云token", required = false)
	private String rongcloudToken;
	
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public boolean isIswork() {
		return iswork;
	}
	public void setIswork(boolean iswork) {
		this.iswork = iswork;
	}
	public String getRongcloudToken() {
		return rongcloudToken;
	}
	public void setRongcloudToken(String rongcloudToken) {
		this.rongcloudToken = rongcloudToken;
	}
}
