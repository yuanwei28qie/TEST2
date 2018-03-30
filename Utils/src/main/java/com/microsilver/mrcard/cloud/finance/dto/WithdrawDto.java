package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author Jade
 * @Description 提现记录
 * @create 2017-08-02 下午 5:13
 * @Copyright Micro Silver
 **/

public class WithdrawDto {
    @ApiModelProperty(value = "财务Id")
    private Long financeId;
    @ApiModelProperty(value = "会员ID")
    private Long memberId;
    @ApiModelProperty(value = "商户ID")
    private Long merchId;
    @ApiModelProperty(value = "身份")
    private short identity;
    @ApiModelProperty(value = "业务提现单号")
    private String ordersn;
    @ApiModelProperty(value = "商户名字")
    private String memberName;
    @ApiModelProperty(value = "提现金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "说明")
    private String remark;
    @ApiModelProperty(value = "会员提现使用支付宝账号")
    private String alipay;
    @ApiModelProperty(value = "推荐人会员编号")
    private Long refereeId;

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

    public short getIdentity() {
        return identity;
    }

    public void setIdentity(short identity) {
        this.identity = identity;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}
    
}
