package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
public class PersonalCenterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("骑士真实姓名")
	private String realName;

	@ApiModelProperty("头像")
	private String avatar;

	@ApiModelProperty("荣誉")
	private String honor;

	@ApiModelProperty("评分")
	private BigDecimal score;

	@ApiModelProperty("今日已完成订单数量")
	private Integer todayFinishedOrder;

	@ApiModelProperty("今日收入")
	private BigDecimal todayMoney;

	@ApiModelProperty("历史已完成订单数量")
	private Integer totalFinishedOrder;

	@ApiModelProperty("历史收入")
	private BigDecimal totalMoney;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getHonor() {
		return honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Integer getTodayFinishedOrder() {
		return todayFinishedOrder;
	}

	public void setTodayFinishedOrder(Integer todayFinishedOrder) {
		this.todayFinishedOrder = todayFinishedOrder;
	}

	public BigDecimal getTodayMoney() {
		return todayMoney;
	}

	public void setTodayMoney(BigDecimal todayMoney) {
		this.todayMoney = todayMoney;
	}

	public Integer getTotalFinishedOrder() {
		return totalFinishedOrder;
	}

	public void setTotalFinishedOrder(Integer totalFinishedOrder) {
		this.totalFinishedOrder = totalFinishedOrder;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
}
