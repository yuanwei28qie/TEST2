package com.microsilver.mrcard.serviceplatform.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.MerchStatDto
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月6日 下午3:49:28
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class MerchStatDto {
	//今天的订单数量
	private Integer countForToday;
	//订单总数量
	private Integer totalCount;
	//今天总金额
	private BigDecimal amountForToday;
	//订单总金额
	private BigDecimal totalAmount;
	//可提现金额
	private BigDecimal realAmount;
	public Integer getCountForToday() {
		return countForToday;
	}
	public void setCountForToday(Integer countForToday) {
		this.countForToday = countForToday;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public BigDecimal getAmountForToday() {
		return amountForToday;
	}
	public void setAmountForToday(BigDecimal amountForToday) {
		this.amountForToday = amountForToday;
	}
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
}
