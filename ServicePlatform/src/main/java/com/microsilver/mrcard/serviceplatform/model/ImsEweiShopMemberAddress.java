package com.microsilver.mrcard.serviceplatform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ImsEweiShopMemberAddress implements Serializable {
    private Integer id;
    @ApiModelProperty(value = "姓名")
    private String realname;
    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区域")
    private String area;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "是否默认")
    private Boolean isdefault;
    @ApiModelProperty(value = "街道")
    private String street;
    @ApiModelProperty(value = "区域编码")
    private String datavalue;
    @ApiModelProperty(value = "会员Id")
    private Long memberId;
    @ApiModelProperty(value = "经度")
    private String lat;
    @ApiModelProperty(value = "纬度")
    private String lng;
    @ApiModelProperty(value = "创建时间")
    private Integer createTime;
    @ApiModelProperty("是否收藏")
    private Boolean isCollection = false;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(String datavalue) {
        this.datavalue = datavalue;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Boolean getCollection() {
        return isCollection;
    }

    public void setCollection(Boolean collection) {
        isCollection = collection;
    }
}