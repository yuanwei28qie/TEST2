package com.microsilver.mrcard.cloud.finance.dto;

import com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/7/25 0025.
 * 客户
 */
public class CustomerDto {

    @ApiModelProperty(value = "财务id")
    private Long financeId;
    @ApiModelProperty(value = "会员ID")
    private Long memberId;
    @ApiModelProperty(value = "商户ID")
    private Long merchId;
    @ApiModelProperty(value = "身份")
    private short identity;
    @ApiModelProperty(value = "客服名字")
    private String memberName;
    @ApiModelProperty(value = "商家分润比例")
    private Short proportion;
    @ApiModelProperty(value = "描述类型")
    private CommissionFlowType remark;



    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public short getIdentity() {
        return identity;
    }

    public void setIdentity(short identity) {
        this.identity = identity;
    }

    public Short getProportion() {
        return proportion;
    }

    public void setProportion(Short proportion) {
        this.proportion = proportion;
    }

    public CommissionFlowType getRemark() {
        return remark;
    }

    public void setRemark(CommissionFlowType remark) {
        this.remark = remark;
    }
}
