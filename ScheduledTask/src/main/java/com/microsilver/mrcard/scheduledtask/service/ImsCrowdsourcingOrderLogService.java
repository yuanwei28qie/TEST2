package com.microsilver.mrcard.scheduledtask.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsilver.mrcard.scheduledtask.dao.ImsCrowdsourcingOrderLogMapper;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrderLog;
import com.microsilver.mrcard.scheduledtask.utils.DateUtil;

@Service
public class ImsCrowdsourcingOrderLogService {
    @Resource
    ImsCrowdsourcingOrderLogMapper imsCrowdsourcingOrderLogMapper;

    /**
     * 添加系统操作日志
     * @param crowdsourcingOrder
     */
    @Transactional
    public int addLog(ImsCrowdsourcingOrder crowdsourcingOrder) {
        ImsCrowdsourcingOrderLog log = new ImsCrowdsourcingOrderLog();
        log.setOrderId(crowdsourcingOrder.getId());
        log.setIdentity((byte)0);//系统取消身份
        log.setMemberId(0l);//系统取消
        log.setOperateStatus(crowdsourcingOrder.getStatus());
        log.setOperateTime((int)DateUtil.getNowDate());

        return imsCrowdsourcingOrderLogMapper.insert(log);
    }
    @Transactional
    public int addLog(Long orderId,String settlementSN ,Byte status) {
        ImsCrowdsourcingOrderLog log = new ImsCrowdsourcingOrderLog();
        log.setOrderId(orderId);
        log.setIdentity((byte)0);//系统取消身份
        log.setMemberId(1L);//系统结算
        log.setOperateStatus(status);
        log.setOperateTime((int)DateUtil.getNowDate());
        log.setRemark(settlementSN);
        return imsCrowdsourcingOrderLogMapper.insert(log);
    }
    
}
