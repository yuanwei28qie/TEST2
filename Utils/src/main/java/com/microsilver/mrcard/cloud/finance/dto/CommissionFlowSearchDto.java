package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jade on 2017/8/18.
 */
public class CommissionFlowSearchDto  extends PageDto  implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Long memberId;
    @ApiModelProperty(value = "身份")
    private Short identity;
    @ApiModelProperty(value = "商户ID")
    private Long merchId;
    @ApiModelProperty(value = "财务流水Id（业务Id）")
    private String ordersn;
    @ApiModelProperty(value = "多个财务流水Id（业务Id）")
    private List<String> ordersnList;

    @ApiModelProperty(value = "时间区间-起始时间")
    private Integer beginTime;
    @ApiModelProperty(value = "时间区间-结束时间")
    private Integer endTime;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Short getIdentity() {
        return identity;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public List<String> getOrdersnList() {
        return ordersnList;
    }

    public void setOrdersnList(List<String> ordersnList) {
        this.ordersnList = ordersnList;
    }
}
