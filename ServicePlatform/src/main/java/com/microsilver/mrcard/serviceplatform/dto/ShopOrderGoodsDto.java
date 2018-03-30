package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.ShopOrderGoodsDto
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月5日 上午10:17:46
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class ShopOrderGoodsDto implements Serializable{
	private Long goodsid;
	private String title;
	private String thumb;
	@ApiModelProperty(value = "销售价格")
	private BigDecimal marketprice;
	/**
	 * 数量
	 */
	@ApiModelProperty(value = "数量")
	private int total;
	
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
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
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	
}
