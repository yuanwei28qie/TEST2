package com.microsilver.mrcard.cloud.finance.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by Jade on 2017/7/25 0025.
 * 分润对象
 * totalAmount = sum bouns(商家、平台、代理)
 */
public class CommissionDto {
    @ApiModelProperty(value = " 支付订单号-平台订单号")
    private String orderSn;
    @ApiModelProperty(value = "订单类型：1.卡先生订单 2.面对面支付 3.超级订订单,4.合伙人订单")
    private Integer orderType;
    @ApiModelProperty(value = "支付金额")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "商家结算金额,成本价格")
    private BigDecimal costprice;
    @ApiModelProperty(value = "平台抽成金额-利润、分成")
    private BigDecimal sysprice;
    @ApiModelProperty(value = "用户奖励金(返现)")
    private BigDecimal userprice;
    @ApiModelProperty(value = "消费者推荐人")
    private CustomerDto recMemberInfo;
    @ApiModelProperty(value = "酒店推荐人")
    private CustomerDto recMerchInfo;
    @ApiModelProperty(value = "商户信息")
    private CustomerDto merchInfo;
    @ApiModelProperty(value = "用户信息")
    private CustomerDto userInfo;
    @ApiModelProperty(value = "商户类型，根据类型可获取具体分成比例")
    private Integer merchType;
    @ApiModelProperty(value = "上级信息,匹配字典 value 项\n" +
            "     *  1_2_3_4_5\n" +
            "     *  1_0_1_1_1\n" +
            "     *  多级全部展示，有则为value，无则为0")
    private String keyWord;
    @ApiModelProperty(value = "   * 上级客服\n" +
            "     *      客户基本信息、客户字典信息（代理级别）\n" +
            "     *      【0】平台\n" +
            "     *      【1】省代\n" +
            "     *      【2】市代\n" +
            "     *      【3】县代\n" +
            "     *      【4】勇士")
    private CustomerDto [] parentCustomer;

    @ApiModelProperty(value = "流水类型(1:销售收入,3:垫付货款,8:合伙人收费,9:推荐用户费用)")
    private Byte flowType;
    @ApiModelProperty(value = "备注")
    private String remark;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getSysprice() {
        return sysprice;
    }

    public void setSysprice(BigDecimal sysprice) {
        this.sysprice = sysprice;
    }

    public BigDecimal getUserprice() {
        return userprice;
    }

    public void setUserprice(BigDecimal userprice) {
        this.userprice = userprice;
    }

    public CustomerDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(CustomerDto userInfo) {
        this.userInfo = userInfo;
    }

    public CustomerDto getMerchInfo() {
        return merchInfo;
    }

    public void setMerchInfo(CustomerDto merchInfo) {
        this.merchInfo = merchInfo;
    }

    public Integer getMerchType() {
        return merchType;
    }

    public void setMerchType(Integer merchType) {
        this.merchType = merchType;
    }

    public CustomerDto[] getParentCustomer() {
        return parentCustomer;
    }

    public void setParentCustomer(CustomerDto[] parentCustomer) {
        this.parentCustomer = parentCustomer;
    }

    public Byte getFlowType() {
        return flowType;
    }

    public void setFlowType(Byte flowType) {
        this.flowType = flowType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public CustomerDto getRecMemberInfo() {
		return recMemberInfo;
	}

	public void setRecMemberInfo(CustomerDto recMemberInfo) {
		this.recMemberInfo = recMemberInfo;
	}

	public CustomerDto getRecMerchInfo() {
		return recMerchInfo;
	}

	public void setRecMerchInfo(CustomerDto recMerchInfo) {
		this.recMerchInfo = recMerchInfo;
	}

	
    
}
