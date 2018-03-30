package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
public class MerchOrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@ApiModelProperty("订单状态")
    private Integer status;
	@ApiModelProperty("用户昵称")
	private String nickname;
	@ApiModelProperty("用户手机号")
	private String mobile;
	@ApiModelProperty("商品数量")
	private Integer total;
	@ApiModelProperty("房间图片")
	private String thumb;
	@ApiModelProperty("房间名称")
	private String title;
	@ApiModelProperty("活动ID")
	private Integer activityId;
	@ApiModelProperty("活动名称")
	private String activityName;
	@ApiModelProperty("订单实付价")
	private Double price;
	
	@ApiModelProperty("订单状态中文含义")
	private String statusStr;
	@ApiModelProperty("房间英文名")
	private String engTitle;
	@ApiModelProperty("房间卖价")
	private Double marketprice;
	@ApiModelProperty("房间服务")
	private String services;
	@ApiModelProperty("房间服务图标")
	private List<ImsSysDictionary> listIconService;
	@ApiModelProperty("订单联系人以及联系方式的json字符串")
	private String optionname;
	@ApiModelProperty("房间单价(原价)")
	private Double presellprice;
	@ApiModelProperty("订单补贴")
	private Double subsidyprice;
	@ApiModelProperty("订单结算价")
	private Double costprice;
	@ApiModelProperty("订单编号")
	private String ordersn;
	@ApiModelProperty("订单创建时间")
	private Integer createtime;
	@ApiModelProperty("订单完成时间")
	private Integer finishtime;
	@ApiModelProperty("订单退款时间")
	private Integer refundtime;
	
	
	public MerchOrderDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public String getEngTitle() {
		return engTitle;
	}
	public void setEngTitle(String engTitle) {
		this.engTitle = engTitle;
	}
	public Double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public List<ImsSysDictionary> getListIconService() {
		return listIconService;
	}
	public void setListIconService(List<ImsSysDictionary> listIconService) {
		this.listIconService = listIconService;
	}
	public String getOptionname() {
		return optionname;
	}
	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}
	public Double getPresellprice() {
		return presellprice;
	}
	public void setPresellprice(Double presellprice) {
		this.presellprice = presellprice;
	}
	public Double getSubsidyprice() {
		return subsidyprice;
	}
	public void setSubsidyprice(Double subsidyprice) {
		this.subsidyprice = subsidyprice;
	}
	public Double getCostprice() {
		return costprice;
	}
	public void setCostprice(Double costprice) {
		this.costprice = costprice;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public Integer getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	public Integer getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Integer finishtime) {
		this.finishtime = finishtime;
	}
	public Integer getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(Integer refundtime) {
		this.refundtime = refundtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
