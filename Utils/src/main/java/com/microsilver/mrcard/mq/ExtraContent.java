package com.microsilver.mrcard.mq;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Jade on 2017/8/16.
 * 推送消息拓展类容
 */
public class ExtraContent {

    @ApiModelProperty(value = "消息ID")
    private String msgId;
    @ApiModelProperty(value = "type:消息编号\t去向\n" +
            "101\t卡先生掌柜首页\n" +
            "102\t卡先生掌柜个人中心\n" +
            "200\t小飞侠订单取消通知" +
            "201\t小飞侠待抢订单通知")
    private Integer msgType;
//    @ApiModelProperty(value = "JSON格式消息体内容")
//    private String conent;
    @ApiModelProperty("备用状态：订单消息则为订单状态")
    private Integer status;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
	public String toString() {
		return "ExtraContent [msgId=" + msgId + ", msgType=" + msgType + ", status=" + status + "]";
	}
    
}
