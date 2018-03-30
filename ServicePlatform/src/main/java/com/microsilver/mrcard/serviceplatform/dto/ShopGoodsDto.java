package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "商品Dto")
public class ShopGoodsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("商品id")
	private Integer id;

	@ApiModelProperty("商品区域编号")
	private Integer uniacid;

	@ApiModelProperty("商品一级分类")
	private Integer pcate;

	@ApiModelProperty("商品二级分类")
	private Integer ccate;

	@ApiModelProperty("商品标题")
	private String title;

	@ApiModelProperty("缩略图")
	private String thumb;

	
	private String thumbUrl;
	
	private List<String> thumbUrls;
	public List<String> getThumbUrls() {
		return thumbUrls;
	}
	public void setThumbUrls(List<String> thumbUrls) {
		this.thumbUrls = thumbUrls;
	}

	@ApiModelProperty("商品单位")
	private String unit;

	@ApiModelProperty("商品描述")
	private String description;

	@ApiModelProperty("售价")
	private BigDecimal marketprice;
	
	private BigDecimal productprice;

	@ApiModelProperty("库存")
	private Integer total;
	
	@ApiModelProperty("已售")
	private Integer salesreal;

	@ApiModelProperty("商品重量")
	private BigDecimal weight;

	@ApiModelProperty("商户id")
	private Integer merchid;
	
	@ApiModelProperty("状态 0 下架 1 上架 2 审核不通过")
	private Byte status;
	
	@ApiModelProperty("审核状态(1:待审核,0:已审核)")
	private Byte checked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUniacid() {
		return uniacid;
	}

	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}

	public Integer getPcate() {
		return pcate;
	}

	public void setPcate(Integer pcate) {
		this.pcate = pcate;
	}

	public Integer getCcate() {
		return ccate;
	}

	public void setCcate(Integer ccate) {
		this.ccate = ccate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getSalesreal() {
		return salesreal;
	}

	public void setSalesreal(Integer salesreal) {
		this.salesreal = salesreal;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getMerchid() {
		return merchid;
	}

	public void setMerchid(Integer merchid) {
		this.merchid = merchid;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getChecked() {
		return checked;
	}

	public void setChecked(Byte checked) {
		this.checked = checked;
	}

	public BigDecimal getProductprice() {
		return productprice;
	}
	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}
	@Override
	public String toString() {
		return "ShopGoodsDto [id=" + id + ", uniacid=" + uniacid + ", pcate=" + pcate + ", ccate=" + ccate + ", title="
				+ title + ", thumb=" + thumb + ", thumbUrl=" + thumbUrl + ", thumbUrls=" + thumbUrls + ", unit=" + unit
				+ ", description=" + description + ", marketprice=" + marketprice + ", productprice=" + productprice
				+ ", total=" + total + ", salesreal=" + salesreal + ", weight=" + weight + ", merchid=" + merchid
				+ ", status=" + status + ", checked=" + checked + "]";
	}
}