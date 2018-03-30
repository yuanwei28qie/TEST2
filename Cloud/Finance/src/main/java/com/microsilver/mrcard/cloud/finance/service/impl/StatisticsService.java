package com.microsilver.mrcard.cloud.finance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dto.CommissionFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceCommissionFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceMerchFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowDBSearchDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlowExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jade on 2017/8/18.
 * 统计查询
 */

@Service
public class StatisticsService {

    private final static Logger logger = LoggerFactory.getLogger(StatisticsService.class);

    @Resource
    MrcardFinanceCustomerService customerService;

    @Resource
    MrcardFinanceMerchFlowService merchFlowService;

    @Resource
    MrcardFinanceCommissionService commissionService;

    public PageInfo<FinanceMerchFlowResultDto> searchMerchFlowBD(List<Long> financeIds, MerchFlowDBSearchDto dbSearch){
        MrcardFinanceMerchFlowExample condition = new MrcardFinanceMerchFlowExample();
        MrcardFinanceMerchFlowExample.Criteria criteria = condition.createCriteria();
        if(null != financeIds && financeIds.size() == 1)
            criteria.andFinanceIdEqualTo(financeIds.get(0));
        else if(null != financeIds && financeIds.size() >= 1)
            criteria.andFinanceIdIn(financeIds);

        if(dbSearch.getType() != null)
            criteria.andTypeEqualTo(dbSearch.getType());
        if(dbSearch.getBeginTime() != null && dbSearch.getEndTime() != null)
            criteria.andCreateTimeBetween(dbSearch.getBeginTime(),dbSearch.getEndTime());


        condition.setOrderByClause(" create_time desc ");
        Page<FinanceMerchFlowResultDto> page = PageHelper.startPage(dbSearch.getPageNum(), dbSearch.getPageSize()).doSelectPage(()->merchFlowService.selectByMerchs(condition));
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public PageInfo<FinanceCommissionFlowResultDto> searchCommissionFlowBD(CommissionFlowSearchDto dbSearch){
        Page<FinanceMerchFlowResultDto> page = PageHelper.startPage(dbSearch.getPageNum(), dbSearch.getPageSize()).doSelectPage(()->commissionService.selectCommissionByExample(dbSearch));
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public PageInfo<FinanceCommissionFlowResultDto> searchKnightCommissionFlowBD(CommissionFlowSearchDto dbSearch){
        Page<FinanceMerchFlowResultDto> page = PageHelper.startPage(dbSearch.getPageNum(), dbSearch.getPageSize()).doSelectPage(()->commissionService.selectKnightCommissionByExample(dbSearch));
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }
}
