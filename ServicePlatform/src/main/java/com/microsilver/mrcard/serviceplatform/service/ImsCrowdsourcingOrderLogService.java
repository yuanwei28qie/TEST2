package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.dao.ImsCrowdsourcingOrderLogMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrderLog;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrderLogExample;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.ImsCrowdsourcingOrderService
 * @Description 众包订单状态日志
 * @Author Jade
 * @Version 2017/8/28
 * @Copyright Micro Silver
 */
@Service
public class ImsCrowdsourcingOrderLogService {

    private final static Logger logger = LoggerFactory.getLogger(ImsCrowdsourcingOrderLogService.class);

    @Resource
    ImsCrowdsourcingOrderLogMapper imsCrowdsourcingOrderLogMapper;

    /**
     * 添加用户操作日志
     * @param crowdsourcingOrder
     */
    @Transactional
    public int addLog(ImsCrowdsourcingOrder crowdsourcingOrder,String remark) {
        ImsCrowdsourcingOrderLog log = new ImsCrowdsourcingOrderLog();
        log.setOrderId(crowdsourcingOrder.getId());
        log.setIdentity((byte)0);//会员身份为0
        log.setMemberId(crowdsourcingOrder.getMemberId());
        log.setOperateStatus(crowdsourcingOrder.getStatus());
        log.setOperateTime(Utils.getCurrentTime());
        log.setRemark(remark);

        logger.info("处理订单日志：{}", JSON.toJSONString(log));
        return imsCrowdsourcingOrderLogMapper.insert(log);
    }
    
    /**
     * 添加骑士操作日志
     * @param crowdsourcingOrder
     */
    public int addCourierLog(ImsCrowdsourcingOrder crowdsourcingOrder,String remark) {
        ImsCrowdsourcingOrderLog log = new ImsCrowdsourcingOrderLog();
        log.setOrderId(crowdsourcingOrder.getId());
        log.setIdentity((byte)13);//骑士身份为0
        log.setMemberId(crowdsourcingOrder.getCourier());
        log.setOperateStatus(crowdsourcingOrder.getStatus());
        log.setOperateTime(Utils.getCurrentTime());
        log.setRemark(remark);
        logger.info("处理订单日志：{}", JSON.toJSONString(log));
        return imsCrowdsourcingOrderLogMapper.insert(log);
    }
    
    /**
     * 根据订单Id和状态获取操作日志
     * 
     */
    public ImsCrowdsourcingOrderLog getLogsByIdAndStatus(Long orderId,Byte operateStatus) {
    	ImsCrowdsourcingOrderLogExample example = new ImsCrowdsourcingOrderLogExample();
    	example.createCriteria().andOrderIdEqualTo(orderId).andOperateStatusEqualTo(operateStatus);
    	example.setOrderByClause(" operate_status desc ");
    	List<ImsCrowdsourcingOrderLog> logs = imsCrowdsourcingOrderLogMapper.selectByExample(example);
    	if(logs.size()>0)
    		return logs.get(0);
    	return null;
    }
}
