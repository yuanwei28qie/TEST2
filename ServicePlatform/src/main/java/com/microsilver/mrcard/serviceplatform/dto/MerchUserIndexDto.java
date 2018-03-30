package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;

import io.swagger.annotations.ApiModelProperty;

public class MerchUserIndexDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("今日总单数")
	private Integer total;

	@ApiModelProperty("今日营收")
	private BigDecimal earning;

	@ApiModelProperty("订单列表")
	private List<MerchOrderDto> orders;

	public MerchUserIndexDto(Integer total, BigDecimal earning, List<MerchOrderDto> orders) {
		super();
		this.total = total;
		this.earning = earning;
		this.orders = orders;
	}
	public MerchUserIndexDto() {
		super();
	}
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public BigDecimal getEarning() {
		return earning;
	}
	public void setEarning(BigDecimal earning) {
		this.earning = earning;
	}
	public List<MerchOrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<MerchOrderDto> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "MerchUserIndexDto [total=" + total + ", earning=" + earning + ", orders=" + orders + "]";
	}
	
}
