package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.enums.EVIPType;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value=Include.NON_NULL)
public class MemberPanterDto implements Serializable{
	private Long memberId;
	@ApiModelProperty(value = "vip类型 (1:合伙人,2:超站,3:管理中心)")
	private byte vipType;
	private String vipName;
	private List<VipType> vipTypeList;
		
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	public String getVipName() {
		EVIPType enumType = EVIPType.getEnumValue(vipType);
		vipName = enumType.getCname()+"("+enumType.getName()+")";
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public byte getVipType() {
		return vipType;
	}
	public void setVipType(byte vipType) {
		this.vipType = vipType;
	}
	
	public List<VipType> getVipTypeList() {
		return vipTypeList;
	}
	public void setVipTypeList(List<VipType> vipTypeList) {
		this.vipTypeList = vipTypeList;
	}
	
}

