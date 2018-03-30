package com.microsilver.mrcard.serviceplatform.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.MerchInfoDto
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月25日 上午10:46:10
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class MerchInfoDto extends ImsEweiShopMerchUser{
	@ApiModelProperty(value = "收入总金额")
	private BigDecimal totalAmount;
	/**
	 * 可提现金额
	 */
	@ApiModelProperty(value = "可提现金额")
	private BigDecimal realAmount;
	@ApiModelProperty(value = "未入账金额")
	private BigDecimal unrecordedAmount;
	@ApiModelProperty(value = "垫付金额")
	private BigDecimal advanceAmount;
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}
	public BigDecimal getUnrecordedAmount() {
		return unrecordedAmount;
	}
	public void setUnrecordedAmount(BigDecimal unrecordedAmount) {
		this.unrecordedAmount = unrecordedAmount;
	}
	public BigDecimal getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	
}
