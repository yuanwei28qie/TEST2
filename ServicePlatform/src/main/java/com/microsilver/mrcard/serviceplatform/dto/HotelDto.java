package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value=Include.NON_NULL)
@ApiModel(description="酒店DTO类")
public class HotelDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("商户主键")
	private Integer id;
	@ApiModelProperty("商户名")
	private String merchname;

	private String servicestag;
	
	@ApiModelProperty("服务项列表")
	private List<String> tags;

	private Long code;

	//1.省 2.市 3.区县
	private Byte areaType;
	
	@ApiModelProperty("商户logo")
	private String logo;
	
	private String lat;

	private String lng;
	
	private Integer page = 1;
	
	private Float startPrice;
	
	private Float endPrice;
	
	private String starLevel;

	//返回给客户端的商户类型
	private Integer shopType;
	
	//客户端传过来的商户类型列表
	private String merchType;
	
	private String brandId;

	@ApiModelProperty("优惠开始时间")
	private Integer beginTime;
	
	@ApiModelProperty("优惠结束时间")
	private Integer endTime;
	
	@ApiModelProperty("最低价")
	private Float lowestPrice;

	@ApiModelProperty("评分")
	private Float score;
	
	@ApiModelProperty("评分等级")
	private String scoreLevel;
	@ApiModelProperty("是否有优惠")
	private Boolean isMill;
	@ApiModelProperty("优惠备注")
	private String remark;
	@ApiModelProperty("是否推荐")
	private Boolean isrecommand;
	
	
	public String getScoreLevel() {
		return scoreLevel;
	}

	public void setScoreLevel(String scoreLevel) {
		this.scoreLevel = scoreLevel;
	}

	@ApiModelProperty("距离")
	private Integer distance;
	
	@ApiModelProperty("折扣")
	private Float isPay;

	private Long counts;

	//1.评分优先 2.距离最近 3.折扣最多4.销量最多 5.价格最低
	private Byte sortType;
	
	@ApiModelProperty("商户图片")	
	private String publicitypic;
	
	@ApiModelProperty("商户图片")
	List<ImsEweiShopMerchImages> imageList;
	
	
	public List<ImsEweiShopMerchImages> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImsEweiShopMerchImages> imageList) {
		this.imageList = imageList;
	}

	@ApiModelProperty("商户评论数量")	
	private Integer comment;	

	@ApiModelProperty("商户地址")	
	private String address;	
	
	@ApiModelProperty("是否已收藏")	
	private Byte isCollection;
	
	@ApiModelProperty("查询关键字")	
	private String keyWords;
	
	@ApiModelProperty("活动")	
	private String activity;
	
	@ApiModelProperty("活动集合")	
	private List<ImsEweiShopActivity> shopActivity;
	
	@ApiModelProperty("最高返现")	
	private Float cashbackMax; 
	
	@ApiModelProperty("商家状态")
	private Byte status;
	
	@ApiModelProperty("商家英文名")
	private String engMerchname;
	@ApiModelProperty("商家所属商圈")
	private String tradingArea;
	
	
	public String getEngMerchname() {
		return engMerchname;
	}

	public void setEngMerchname(String engMerchname) {
		this.engMerchname = engMerchname;
	}

	public String getTradingArea() {
		return tradingArea;
	}

	public void setTradingArea(String tradingArea) {
		this.tradingArea = tradingArea;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public List<ImsEweiShopActivity> getShopActivity() {
		return shopActivity;
	}

	public void setShopActivity(List<ImsEweiShopActivity> shopActivity) {
		this.shopActivity = shopActivity;
	}

	public Float getCashbackMax() {
		return cashbackMax;
	}

	public void setCashbackMax(Float cashbackMax) {
		this.cashbackMax = cashbackMax;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Byte getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(Byte isCollection) {
		this.isCollection = isCollection;
	}

	private List<ActivityGoodsDto> activityGoodsDtos;
	
	public List<ActivityGoodsDto> getActivityGoodsDtos() {
		return activityGoodsDtos;
	}

	public void setActivityGoodsDtos(List<ActivityGoodsDto> activityGoodsDtos) {
		this.activityGoodsDtos = activityGoodsDtos;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public String getPublicitypic() {
		return publicitypic;
	}

	public void setPublicitypic(String publicitypic) {
		this.publicitypic = publicitypic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMerchname() {
		return merchname;
	}

	public void setMerchname(String merchname) {
		this.merchname = merchname;
	}

	public String getMerchType() {
		return merchType;
	}

	public void setMerchType(String merchType) {
		this.merchType = merchType;
	}
	

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getServicestag() {
		return servicestag;
	}

	public void setServicestag(String servicestag) {
		this.servicestag = servicestag;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Byte getAreaType() {
		return areaType;
	}

	public void setAreaType(Byte areaType) {
		this.areaType = areaType;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Float getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Float startPrice) {
		this.startPrice = startPrice;
	}

	public Float getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Float endPrice) {
		this.endPrice = endPrice;
	}

	public String getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	public Integer getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Float getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(Float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Float getIsPay() {
		return isPay;
	}

	public void setIsPay(Float isPay) {
		this.isPay = isPay;
	}

	public Long getCounts() {
		return counts;
	}

	public void setCounts(Long counts) {
		this.counts = counts;
	}

	public Byte getSortType() {
		return sortType;
	}

	public void setSortType(Byte sortType) {
		this.sortType = sortType;
	}
	

	public Boolean getIsMill() {
		return isMill;
	}

	public void setIsMill(Boolean isMill) {
		this.isMill = isMill;
	}

	public Boolean getIsrecommand() {
		return isrecommand;
	}

	public void setIsrecommand(Boolean isrecommand) {
		this.isrecommand = isrecommand;
	}
	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "HotelDto [id=" + id + ", merchname=" + merchname + ", servicestag=" + servicestag + ", tags=" + tags
				+ ", code=" + code + ", areaType=" + areaType + ", logo=" + logo + ", lat=" + lat + ", lng=" + lng
				+ ", page=" + page + ", startPrice=" + startPrice + ", endPrice=" + endPrice + ", starLevel="
				+ starLevel + ", shopType=" + shopType + ", merchType=" + merchType + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", lowestPrice=" + lowestPrice + ", score=" + score + ", scoreLevel="
				+ scoreLevel + ", distance=" + distance + ", isPay=" + isPay + ", counts=" + counts + ", sortType="
				+ sortType + ", publicitypic=" + publicitypic + ", imageList=" + imageList + ", comment=" + comment
				+ ", address=" + address + ", isCollection=" + isCollection + ", keyWords=" + keyWords + ", activity="
				+ activity + ", shopActivity=" + shopActivity + ", cashbackMax=" + cashbackMax + ", status=" + status
				+ ", activityGoodsDtos=" + activityGoodsDtos + "]";
	}
}
