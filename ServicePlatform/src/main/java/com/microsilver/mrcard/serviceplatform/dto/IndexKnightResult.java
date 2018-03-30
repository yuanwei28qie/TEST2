package com.microsilver.mrcard.serviceplatform.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Name com.microsilver.mrcard.serviceplatform.dto.IndexKnightResult
 * @Description
 * @Author Jade
 * @Version 2017/8/28
 * @Copyright Micro Silver
 */
public class IndexKnightResult {

    private Integer id;
    private Integer memberId;
    private Integer identity;
    private Integer merchId;

    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "评分")
    private BigDecimal score;

    @ApiModelProperty(value = "骑手")
    private String name;
    @ApiModelProperty(value = "经度")
    private String lat;
    @ApiModelProperty(value = "纬度")
    private String lng;
    @ApiModelProperty(value = "距离(m)")
    private Integer distance;
    @ApiModelProperty("骑士历史完成订单数")
    private Integer totalFinished;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getMerchId() {
        return merchId;
    }

    public void setMerchId(Integer merchId) {
        this.merchId = merchId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getTotalFinished() {
        return totalFinished;
    }

    public void setTotalFinished(Integer totalFinished) {
        this.totalFinished = totalFinished;
    }
}
