package com.microsilver.mrcard.serviceplatform.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
public class ActivityGoodsDto extends ImsEweiShopActivityGoods {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer total;
	private String thumb;
	private String thumbUrl;
	private List<String> thumbUrls;
	private String title;
	private BigDecimal productprice;
	private String services;
	private List<String> listService;
	@ApiModelProperty("房间服务图标")
	private List<ImsSysDictionary> listIconService;
	private BigDecimal marketprice;
	private BigDecimal cashbackMax;
	private String activityName;
	private Boolean isRemind;
	
	private Integer startTime;
	@ApiModelProperty("零点半价折扣")
	private BigDecimal discount;
	@ApiModelProperty("超级特价折扣")
	private BigDecimal superDiscount;
	
	@ApiModelProperty("房间英文名")
	private String engTitle;
	private BigDecimal costprice;
	private BigDecimal presellprice;
	private BigDecimal zeroCostprice;
	private BigDecimal zeroPresellprice;
	private BigDecimal prePay; //超级特价预付金
	private BigDecimal cashBackPercent; //超级特价补贴点数
	private String starLevel; 
	
	


	public BigDecimal getCashBackPercent() {
		return cashBackPercent;
	}

	public void setCashBackPercent(BigDecimal cashBackPercent) {
		this.cashBackPercent = cashBackPercent;
	}

	public BigDecimal getPrePay() {
		return prePay;
	}

	public void setPrePay(BigDecimal prePay) {
		this.prePay = prePay;
	}

	public String getEngTitle() {
		return engTitle;
	}

	public void setEngTitle(String engTitle) {
		this.engTitle = engTitle;
	}

	public BigDecimal getCostprice() {
		return costprice;
	}

	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}

	public BigDecimal getPresellprice() {
		return presellprice;
	}

	public void setPresellprice(BigDecimal presellprice) {
		this.presellprice = presellprice;
	}

	public BigDecimal getZeroCostprice() {
		return zeroCostprice;
	}

	public void setZeroCostprice(BigDecimal zeroCostprice) {
		this.zeroCostprice = zeroCostprice;
	}

	public BigDecimal getZeroPresellprice() {
		return zeroPresellprice;
	}

	public void setZeroPresellprice(BigDecimal zeroPresellprice) {
		this.zeroPresellprice = zeroPresellprice;
	}

	public BigDecimal getSuperDiscount() {
		return superDiscount;
	}

	public void setSuperDiscount(BigDecimal superDiscount) {
		this.superDiscount = superDiscount;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Boolean getIsRemind() {
		return isRemind;
	}

	public void setIsRemind(Boolean isRemind) {
		this.isRemind = isRemind;
	}

	public List<String> getThumbUrls() {
    	thumbUrls = Utils.unserializePHParray(getThumbUrl());
		return thumbUrls;
	}

	public void setThumbUrls(List<String> thumbUrls) {
		this.thumbUrls = thumbUrls;
	}

	public List<String> getListService() {
		return listService;
	}

	public void setListService(List<String> listService) {
		this.listService = listService;
	}

	public List<ImsSysDictionary> getListIconService() {
		return listIconService;
	}

	public void setListIconService(List<ImsSysDictionary> listIconService) {
		this.listIconService = listIconService;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public BigDecimal getCashbackMax() {
		return cashbackMax;
	}

	public void setCashbackMax(BigDecimal cashbackMax) {
		this.cashbackMax = cashbackMax;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getProductprice() {
		return productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public BigDecimal getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}

	public String getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}

	@Override
	public String toString() {
		return "ActivityGoodsDto [total=" + total + ", thumb=" + thumb + ", thumbUrl=" + thumbUrl + ", thumbUrls="
				+ thumbUrls + ", title=" + title + ", productprice=" + productprice + ", services=" + services
				+ ", listService=" + listService + ", listIconService=" + listIconService + ", marketprice="
				+ marketprice + ", cashbackMax=" + cashbackMax + ", activityName=" + activityName + ", isRemind="
				+ isRemind + ", startTime=" + startTime + ", discount=" + discount + ", superDiscount=" + superDiscount
				+ ", engTitle=" + engTitle + ", costprice=" + costprice + ", presellprice=" + presellprice
				+ ", zeroCostprice=" + zeroCostprice + ", zeroPresellprice=" + zeroPresellprice + ", prePay=" + prePay
				+ ", cashBackPercent=" + cashBackPercent + "]";
	}

}
