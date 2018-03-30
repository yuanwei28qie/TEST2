package com.microsilver.mrcard.serviceplatform.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Name com.microsilver.mrcard.serviceplatform.dto.ShopMerchReg
 * @Description
 * @Author Jade
 * @Version 2017/11/7
 * @Copyright Micro Silver
 */
public class ShopMerchReg {

    @ApiModelProperty(value = "用户Id")
    private Integer memberid;
    @ApiModelProperty(value = "联系人")
    private String realname;
    @ApiModelProperty(value = "联系电话")
    private String mobile;
    @ApiModelProperty(value = "商户电话")
    private String tel;
    @ApiModelProperty(value = "经度")
    private String lat;
    @ApiModelProperty(value = "纬度")
    private String lng;
    @ApiModelProperty(value = "详细地址")
    private String address;
    @ApiModelProperty(value = "商户名称")
    private String merchname;
    @ApiModelProperty(value = "酒店类型")
    private Integer shopType;
    @ApiModelProperty(value = "品牌")
    private Integer brandId;
    @ApiModelProperty(value = "省编码")
    private Long province;
    @ApiModelProperty(value = "市编码")
    private Long city;
    @ApiModelProperty(value = "区域编码")
    private Long county;
    @ApiModelProperty(value = "用户身份")
    private Short identity;
    @ApiModelProperty(value = "营业照")
    private String idNo;
    @ApiModelProperty(value = "证件照")
    private String pic;
    @ApiModelProperty(value = "证件照2")
    private String pic2;
    @ApiModelProperty(value = "门头照")
    private String publicitypic;


    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMerchname() {
        return merchname;
    }

    public void setMerchname(String merchname) {
        this.merchname = merchname;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getCounty() {
        return county;
    }

    public void setCounty(Long county) {
        this.county = county;
    }

    public Short getIdentity() {
        return identity;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPublicitypic() {
        return publicitypic;
    }

    public void setPublicitypic(String publicitypic) {
        this.publicitypic = publicitypic;
    }
}
