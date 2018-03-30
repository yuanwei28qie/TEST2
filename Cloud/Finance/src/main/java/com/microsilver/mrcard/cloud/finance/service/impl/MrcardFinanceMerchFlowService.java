package com.microsilver.mrcard.cloud.finance.service.impl;

import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceMerchFlowMapper;
import com.microsilver.mrcard.cloud.finance.dto.FinanceMerchFlowResultDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlowExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jade
 * @Description 商户结算记录
 * @create 2017-07-31 下午 2:35
 * @Copyright Micro Silver
 **/

@Service
public class MrcardFinanceMerchFlowService {

    @Autowired
    MrcardFinanceMerchFlowMapper merchFlowMapper;

    @Transactional
    public MrcardFinanceMerchFlow insertMerchFlowRecord(MrcardFinanceMerchFlow merchFlow){
        merchFlowMapper.insert(merchFlow);
        return merchFlow;
    }

    @Transactional
    public MrcardFinanceMerchFlow updateMerchFlowRecord(MrcardFinanceMerchFlow merchFlow){
        merchFlowMapper.updateByPrimaryKey(merchFlow);
        return merchFlow;
    }

    public MrcardFinanceMerchFlow selectByPrimaryKey(Long flowId){
        MrcardFinanceMerchFlow flow = merchFlowMapper.selectByPrimaryKey(flowId);
        return flow;
    }
     public List<MrcardFinanceMerchFlow> selectByExample(MrcardFinanceMerchFlowExample flowExample){
        List<MrcardFinanceMerchFlow> flow = merchFlowMapper.selectByExample(flowExample);
        return flow;
    }

    public List<FinanceMerchFlowResultDto> selectByMerchs(MrcardFinanceMerchFlowExample flowExample){
        List<FinanceMerchFlowResultDto> flow = merchFlowMapper.selectByMerchs(flowExample);
        return flow;
    }

    public List<MrcardFinanceMerchFlow> selectByOrderSn(List<String> ordersn){
        MrcardFinanceMerchFlowExample flowExample = new MrcardFinanceMerchFlowExample();
        flowExample.createCriteria().andOrdersnIn(ordersn).andIsSettlEqualTo(true);
        List<MrcardFinanceMerchFlow> flow = merchFlowMapper.selectByExample(flowExample);
        return flow;
    }

    public boolean updateMerchFlowStatus(List<String> orderSn,boolean status){
        int num = merchFlowMapper.updateByOrderSn(orderSn,status);
        return num >0 ? true:false;
    }


}
