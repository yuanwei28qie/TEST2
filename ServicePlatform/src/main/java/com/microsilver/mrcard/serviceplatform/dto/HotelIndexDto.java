package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.util.List;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopSystemAdv;

public class HotelIndexDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//首页轮播图集合
	private List<ImsEweiShopSystemAdv> advs;
	
	//附近零点半价
	private List<HotelDto> ldbjList;
	//附近超级特价
	private List<HotelDto> cjtjList;
	
	
	public HotelIndexDto() {
		super();
	}

	
	public HotelIndexDto(List<ImsEweiShopSystemAdv> advs, List<HotelDto> ldbjList, List<HotelDto> cjtjList) {
		super();
		this.advs = advs;
		this.ldbjList = ldbjList;
		this.cjtjList = cjtjList;
	}


	@Override
	public String toString() {
		return "HotelIndexDto [advs=" + advs + ", ldbjList=" + ldbjList + ", cjtjList=" + cjtjList + "]";
	}


	public List<ImsEweiShopSystemAdv> getAdvs() {
		return advs;
	}
	public void setAdvs(List<ImsEweiShopSystemAdv> advs) {
		this.advs = advs;
	}
	public List<HotelDto> getLdbjList() {
		return ldbjList;
	}
	public void setLdbjList(List<HotelDto> ldbjList) {
		this.ldbjList = ldbjList;
	}
	public List<HotelDto> getCjtjList() {
		return cjtjList;
	}
	public void setCjtjList(List<HotelDto> cjtjList) {
		this.cjtjList = cjtjList;
	}
}
