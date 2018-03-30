package com.microsilver.mrcard.cloud.finance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dto.CommissionFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceCommissionFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceMerchFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowDBSearchDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCommissionService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.StatisticsService;

/**
 * Created by Jade on 2017/8/18.
 * 后台统计查询
 */

@RestController
@RequestMapping("/finance/statistics/")
public class StatisticsDBController {

    @Resource
    MrcardFinanceCustomerService customerService;

    @Resource
    StatisticsService statisticsService;
    
    @Resource
    MrcardFinanceCommissionService commissionService;

    /**
     * 财务流水查询总后台
     * @param dbSearch
     * @return
     */
    @PostMapping("searchflowBD")
    public PageInfo<FinanceMerchFlowResultDto> searchFlow(@RequestBody MerchFlowDBSearchDto dbSearch) throws Exception {
        List<Long> financeIds = new ArrayList<>();

        List<MrcardFinanceCustomer> customer = customerService.getCustomer(dbSearch.getMerchIds());
        customer.forEach(ct -> financeIds.add(ct.getId()));

        return statisticsService.searchMerchFlowBD(financeIds,dbSearch);
    }

    /**
     * 订单分润流水查询总后台
     * @param dbSearch
     * @return
     */
    @PostMapping("searchCommissionDB")
    public PageInfo<FinanceCommissionFlowResultDto> searchCommission(@RequestBody CommissionFlowSearchDto dbSearch){
        return statisticsService.searchCommissionFlowBD(dbSearch);
    }

    /**
     * 订单分润流水查询总后台
     * @param dbSearch
     * @return
     */
    @PostMapping("searchKnightCommissionDB")
    public PageInfo<FinanceCommissionFlowResultDto> searchKnightCommission(@RequestBody CommissionFlowSearchDto dbSearch){
        return statisticsService.searchKnightCommissionFlowBD(dbSearch);
    }
    /**
     * 根据订单编号查询分润记录
     * @param dbSearch
     * @return
     */
    @PostMapping("selectCommissionByOrders")
    public List<FinanceCommissionFlowResultDto> selectCommissionByOrders(@RequestBody CommissionFlowSearchDto dbSearch){
    	return commissionService.selectCommissionByOrders(dbSearch);
    }
}
