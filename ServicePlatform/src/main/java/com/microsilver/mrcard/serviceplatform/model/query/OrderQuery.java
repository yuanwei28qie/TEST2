package com.microsilver.mrcard.serviceplatform.model.query;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.model.query.OrderQuery
 * @Description 订单查询类
 * 
 * @Author bruce
 * @Version 2017年7月4日 下午12:56:28
 * @Copyright Micro Silver
 *
 */
public class OrderQuery extends BaseQuery{
	private Long merchId;
	private Long memberId;
	private Integer status;
	/**
	 * 支付时间
	 */
	private Long payTime;
	/**
	 * 快递员
	 */
	private Long courier;


	/**
	 * @Jade 2017-08-07
	 * 2 rows
	 */
	//@ApiModelProperty(value = " 配送方式(0 商家配送 ,1 自提,2 不需要配送)")
	private Integer dispatchtype;
	//@ApiModelProperty(value = "订单类型：超级订，卡先生，优惠买单")
	private Byte orderType;
	
	public Long getMerchId() {
		return merchId;
	}
	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getCourier() {
		return courier;
	}
	public void setCourier(Long courier) {
		this.courier = courier;
	}
	public Long getPayTime() {
		return payTime;
	}
	public void setPayTime(Long payTime) {
		this.payTime = payTime;
	}

	public Integer getDispatchtype() {
		return dispatchtype;
	}

	public void setDispatchtype(Integer dispatchtype) {
		this.dispatchtype = dispatchtype;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}
}
