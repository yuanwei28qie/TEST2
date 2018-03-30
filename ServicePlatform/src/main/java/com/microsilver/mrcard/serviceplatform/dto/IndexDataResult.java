package com.microsilver.mrcard.serviceplatform.dto;

import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Name com.microsilver.mrcard.serviceplatform.dto.IndexDataResult
 * @Description 首页数据返回
 * @Author Jade
 * @Version 2017/9/1
 * @Copyright Micro Silver
 */
public class IndexDataResult {

    /**
     * 未完成的订单
     */
    @ApiModelProperty(value = "未完成的订单")
    private ImsCrowdsourcingOrder order;

    /**
     * order 状态 为抢单的，需要返回骑士
     */
    @ApiModelProperty(value = "order 状态 为抢单的，需要返回骑士")
    private IndexKnightResult knight;

    /**
     * 首页骑士列表,附近在工作的骑士
     */
    @ApiModelProperty(value = "首页骑士列表,附近在工作的骑士")
    private List<IndexKnightResult> knightList;


    public ImsCrowdsourcingOrder getOrder() {
        return order;
    }

    public void setOrder(ImsCrowdsourcingOrder order) {
        this.order = order;
    }

    public IndexKnightResult getKnight() {
        return knight;
    }

    public void setKnight(IndexKnightResult knight) {
        this.knight = knight;
    }

    public List<IndexKnightResult> getKnightList() {
        return knightList;
    }

    public void setKnightList(List<IndexKnightResult> knightList) {
        this.knightList = knightList;
    }
}
