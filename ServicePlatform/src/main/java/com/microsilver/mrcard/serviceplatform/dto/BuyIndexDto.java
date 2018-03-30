package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.BuyIndexDto
 * @Description 小飞侠首页Dto
 * 
 * @Author null
 * @Version 2017年8月29日 上午12:00:20
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class BuyIndexDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("用户id")	
	private Long memberId;
	
	@ApiModelProperty("评分")	
    private BigDecimal score;

	@ApiModelProperty("今日已完成订单数量")	
    private Integer finishedOrder;
	
	@ApiModelProperty("今日收入")	
    private BigDecimal money;
	
	@ApiModelProperty("正在进行的订单id")
	private Long orderId;
	
	@ApiModelProperty("订单状态")
    private Byte status;
	
	@ApiModelProperty("骑士是否开工")
    private Boolean isWork;

	@ApiModelProperty("骑士是否通过实名认证(审核状态(-1:未申请,0:审核未通过,1:待审核,2:已审核))")
	private Byte checkStatus;
	
	private List<ImsCrowdsourcingOrder> orders;

	
	public Byte getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Byte checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Boolean getIsWork() {
		return isWork;
	}

	public void setIsWork(Boolean isWork) {
		this.isWork = isWork;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Integer getFinishedOrder() {
		return finishedOrder;
	}

	public void setFinishedOrder(Integer finishedOrder) {
		this.finishedOrder = finishedOrder;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public List<ImsCrowdsourcingOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ImsCrowdsourcingOrder> orders) {
		this.orders = orders;
	}
}
