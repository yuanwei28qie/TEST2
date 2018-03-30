package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Name com.microsilver.mrcard.cloud.finance.dto.SettlementSearchDto
 * @Description
 * @Author Jade
 * @Version 2017/9/5
 * @Copyright Micro Silver
 */
public class SettlementSearchDto extends PageDto {

    /**
     *类型
     * 1 订单流水（销售收入），5 提现流水
     */
    @ApiModelProperty("1 订单流水（销售收入），5 提现流水")
    private Byte type;
    /**
     * 时间区间-起始时间
     */
    @ApiModelProperty("时间区间-起始时间")
    private Integer beginTime;

    /**
     * 时间区间-结束时间
     */
    @ApiModelProperty("时间区间-结束时间")
    private Integer endTime;

    /**
     *状态(-1:未通过,0:待审核,1:已通过,2:已打款)
     */
    @ApiModelProperty("状态(-1:未通过,0:待审核,1:已通过,2:已打款)")
    private Byte status;

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
