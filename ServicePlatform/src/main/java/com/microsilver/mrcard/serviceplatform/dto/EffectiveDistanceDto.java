package com.microsilver.mrcard.serviceplatform.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 * @Name com.microsilver.mrcard.serviceplatform.dto.EffectiveDistanceDto
 * @Description 帮我买首页 查询附近的骑手
 * @Author Jade
 * @Version 2017/8/28
 * @Copyright Micro Silver
 */
public class EffectiveDistanceDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "经度")
    private String lat;

    @ApiModelProperty(value = "纬度")
    private String lng;

    @ApiModelProperty(value = "有效距离（m）")
    private Integer effectiveDistance;

    @ApiModelProperty(value = "城市编码")
    private Long city;


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

    public Integer getEffectiveDistance() {
        return effectiveDistance;
    }

    public void setEffectiveDistance(Integer effectiveDistance) {
        this.effectiveDistance = effectiveDistance;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
