package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value=Include.NON_NULL)
public class HotelOrderDto implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	@ApiModelProperty(value = "订单ID",required = false)
	private Long orderId;
	
	/**
	 * 订单编号
	 */
	@ApiModelProperty(value = "订单编号",required = false)
	private String ordersn;
	/**
	 * 商家编号
	 */
	private Integer merchId;
	
	/**
	 * 顾客ID
	 */
	private Long memberId;
	/**
	 * 商品Id
	 */
	private Integer goodsId;
	
	/**
	 * 商品数量
	 */
	@ApiModelProperty(value = "商品数量",required = true)
	private Integer goodsNumber;
	
	/**
	 * 入住天数
	 */
	@ApiModelProperty(value = "入住天数",required = true)
	private Integer days;
	
	/**
	 * 入住时间
	 */
	@ApiModelProperty(value = "入住时间",required = true)
	private Integer fetchTime;
	
	/**
	 * 离开时间
	 */
	@ApiModelProperty(value = "离开时间",required = true)
	private Integer sendTime;
	
	/**
	 * 总金额
	 */
	@ApiModelProperty(value = "总金额",required = true)
	private BigDecimal price;
	
	/**
	 * 活动类型编号
	 */
    private Integer activityId;

	
	/**
	 * 顾客姓名及联系方式的json串
	 */
	@ApiModelProperty(value = "顾客姓名及联系方式的json串",required = true)
	private String customers;
	
	/**
	 * 订单来源(1:android,2:ios,3:微信)
	 */
	@ApiModelProperty("订单来源(1:android,2:ios,3:微信)")
	private Byte sourceType;
	
	
	public Byte getSourceType() {
		return sourceType;
	}

	public void setSourceType(Byte sourceType) {
		this.sourceType = sourceType;
	}

	public String getCustomers() {
		return customers;
	}

	public void setCustomers(String customers) {
		this.customers = customers;
	}

	
	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrdersn() {
		return ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}

	public Integer getMerchId() {
		return merchId;
	}

	public void setMerchId(Integer merchId) {
		this.merchId = merchId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(Integer fetchTime) {
		this.fetchTime = fetchTime;
	}

	public Integer getSendTime() {
		return sendTime;
	}

	public void setSendTime(Integer sendTime) {
		this.sendTime = sendTime;
	}
	
}
