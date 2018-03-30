package com.microsilver.mrcard.serviceplatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingDispatch;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddress;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Name com.microsilver.mrcard.serviceplatform.dto.PreOrderData
 * @Description 创建订单页面，字典数据
 * @Author Jade
 * @Version 2017/9/1
 * @Copyright Micro Silver
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PreOrderData {

    /**
     * 标签数据
     */
    @ApiModelProperty(value = "标签数据")
    private List<ImsSysDictionary> buyLabel;

    /**
     * 默认/最后一次收货地址
     */
    @ApiModelProperty(value = "默认/最后一次收货地址")
    private ImsEweiShopMemberAddress defaultAddress;

    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private ImsCrowdsourcingDispatch dispatch;

    public List<ImsSysDictionary> getBuyLabel() {
        return buyLabel;
    }

    public void setBuyLabel(List<ImsSysDictionary> buyLabel) {
        this.buyLabel = buyLabel;
    }

    public ImsEweiShopMemberAddress getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(ImsEweiShopMemberAddress defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public ImsCrowdsourcingDispatch getDispatch() {
        return dispatch;
    }

    public void setDispatch(ImsCrowdsourcingDispatch dispatch) {
        this.dispatch = dispatch;
    }
}
