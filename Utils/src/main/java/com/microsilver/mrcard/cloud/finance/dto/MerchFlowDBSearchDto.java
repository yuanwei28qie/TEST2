package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jade
 * @Description 财务流水记录查询
 * @create 2017-08-02 下午 6:11
 * @Copyright Micro Silver
 **/

public class MerchFlowDBSearchDto extends PageDto{

    @ApiModelProperty(value = "会员ID")
    private List<Long> memberIds;
    @ApiModelProperty(value = "商户ID")
    private List<Long> merchIds;
    @ApiModelProperty(value = "身份")
    private List<Short> ides;

    @ApiModelProperty(value = "1 订单流水（销售收入），5 提现流水")
    private Byte type;
    @ApiModelProperty(value = "时间区间-起始时间")
    private Integer beginTime;
    @ApiModelProperty(value = "时间区间-结束时间")
    private Integer endTime;

    public List<Long> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Long> memberIds) {
        this.memberIds = memberIds;
    }

    public List<Long> getMerchIds() {
        return merchIds;
    }

    public void setMerchIds(List<Long> merchIds) {
        this.merchIds = merchIds;
    }

    public List<Short> getIdes() {
        return ides;
    }

    public void setIdes(List<Short> ides) {
        this.ides = ides;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
}
