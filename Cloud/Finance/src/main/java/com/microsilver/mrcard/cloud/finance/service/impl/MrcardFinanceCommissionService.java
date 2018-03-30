package com.microsilver.mrcard.cloud.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceCommissionFlowMapper;
import com.microsilver.mrcard.cloud.finance.dto.CommissionFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceCommissionFlowResultDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlowExample;

/**
 * @author Jade
 * @Description 分润流水记录
 * @create 2017-07-31 上午 11:28
 * @Copyright Micro Silver
 **/

@Service
public class MrcardFinanceCommissionService {

    @Autowired
    MrcardFinanceCommissionFlowMapper commissionFlowMapper;
    
    @Transactional
    public boolean insertCommissionFlows(List<MrcardFinanceCommissionFlow> list){
        list.forEach((flow)-> insertCommissionFlow(flow));
        return true;
    }
    
    public int insertCommissionFlow(MrcardFinanceCommissionFlow commissionFlow){
        return commissionFlowMapper.insert(commissionFlow);
    }

    /**
     * 结算
     * @param orderSn
     * @return
     */
    @Transactional
    public boolean SettlementCommission(String orderSn){
        List<MrcardFinanceCommissionFlow> list = getCommissionFlowByOrderSn(orderSn);
        list.forEach((cc)->cc.setCommState((short)1));
        return updateCommission(list);
    }

    /**
     * 退款
     * @param orderSn
     * @return
     */
    @Transactional
    public boolean RefuondCommission(String orderSn){
        List<MrcardFinanceCommissionFlow> list = getCommissionFlowByOrderSn(orderSn);
        list.forEach((cc)->cc.setCommState((short)2));
        return updateCommission(list);
    }

    private boolean updateCommission(List<MrcardFinanceCommissionFlow> list) {
        list.forEach((ff)->commissionFlowMapper.updateByPrimaryKey(ff));
        return true;
    }

    public List<MrcardFinanceCommissionFlow> getCommissionFlowByOrderSn(String orderSn){
        MrcardFinanceCommissionFlowExample com = new MrcardFinanceCommissionFlowExample();
        com.createCriteria().andOrdersnEqualTo(orderSn);
        List<MrcardFinanceCommissionFlow> list = commissionFlowMapper.selectByExample(com);
        return list;
    }
    public List<MrcardFinanceCommissionFlow> getCommissionFlowByOrderSn(List<String> orderSn){
        MrcardFinanceCommissionFlowExample com = new MrcardFinanceCommissionFlowExample();
        com.createCriteria().andOrdersnIn(orderSn);
        List<MrcardFinanceCommissionFlow> list = commissionFlowMapper.selectByExample(com);
        return list;
    }
    public List<MrcardFinanceCommissionFlow> selectCommissionByExample(CommissionFlowSearchDto example){
        List<MrcardFinanceCommissionFlow> list = commissionFlowMapper.selectCommissionByExample(example);
        return list;
    }
    public List<MrcardFinanceCommissionFlow> selectKnightCommissionByExample(CommissionFlowSearchDto example){
        List<MrcardFinanceCommissionFlow> list = commissionFlowMapper.selectKnightCommissionByExample(example);
        return list;
    }
    /**
     * 根据订单编号查询分润流水
     * @param example
     * @return
     */
    public List<FinanceCommissionFlowResultDto> selectCommissionByOrders(CommissionFlowSearchDto example){
    	return commissionFlowMapper.selectCommissionByOrders(example);
    }

}
