package com.microsilver.mrcard.serviceplatform.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Name com.microsilver.mrcard.serviceplatform.dto.StaffInformation
 * @Description  企业员工资料录入
 * @Author Jade
 * @Version 2017/11/8
 * @Copyright Micro Silver
 */
public class StaffInformation {
    @ApiModelProperty(value = "会员编号")
    private Long memberId;
    @ApiModelProperty(value = "商户编号")
    private Long merchId;
    @ApiModelProperty(value = "真实姓名")
    private String realname;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "验证码")
    private String checkCode;
    @ApiModelProperty(value = "权限级别")
    private Integer resoureGroupId;
    @ApiModelProperty(value = "权限级别名称")
    private String resoureGroupName;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getResoureGroupId() {
        return resoureGroupId;
    }

    public void setResoureGroupId(Integer resoureGroupId) {
        this.resoureGroupId = resoureGroupId;
    }

	public String getResoureGroupName() {
		return resoureGroupName;
	}

	public void setResoureGroupName(String resoureGroupName) {
		this.resoureGroupName = resoureGroupName;
	}
    
}
