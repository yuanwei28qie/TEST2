package com.microsilver.mrcard.cloud.finance.controller;

import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dic.MerchFlowType;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlement;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceSettlementService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceWithdrawService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jade
 * @Description ${DESCRIPTION}
 * @create 2017-08-02 下午 5:08
 * @Copyright Micro Silver
 **/

@RestController
@RequestMapping("/finance/withdraw/")
public class FinanceWithDrawController {

    @Resource
    MrcardFinanceCustomerService customerService;

    @Resource
    MrcardFinanceWithdrawService withdrawService;

    /**
     * 根据条件查询所有流水
     * @param flowSearch
     * @return
     */
    @PostMapping("searchflow")
    public PageInfo<MrcardFinanceMerchFlow> searchFlow(@RequestBody MerchFlowSearchDto flowSearch){
        MrcardFinanceCustomer customer = customerService.searchFinanceCustomer(flowSearch.getMemberId(),flowSearch.getIdentity(),flowSearch.getMerchId());
        flowSearch.setFinanceId(customer.getId());
        return withdrawService.searchMerchFlow(flowSearch);
    }

    @PostMapping("searchflowKnight")
    public PageInfo<MrcardFinanceMerchFlow> searchFlowByKnight(@RequestBody MerchFlowSearchDto flowSearch){
        MrcardFinanceCustomer customer = customerService.searchFinanceCustomer(flowSearch.getMemberId(),flowSearch.getIdentity(),flowSearch.getMerchId());
        flowSearch.setFinanceId(customer.getId());
        return withdrawService.searchMerchFlow(flowSearch);
    }

    /**
     * 只查询提现流水
     * @param flowSearch
     * @return
     */
    @PostMapping("searchwithdraw")
    public List<MrcardFinanceMerchFlow> searchWithdraw(@RequestBody MerchFlowSearchDto flowSearch){
        MrcardFinanceCustomer customer = customerService.searchFinanceCustomer(flowSearch.getMemberId(),flowSearch.getIdentity(),flowSearch.getMerchId());
        flowSearch.setFinanceId(customer.getId());
        flowSearch.setType((byte) MerchFlowType.WITHDRAW.getValue());
        return withdrawService.searchMerchFlow(flowSearch).getList();
    }

    /**
     * 提现记录
     * @return 返回提现记录流水号
     */
    @PostMapping("tobelance")
    public Long withdraw(@RequestBody WithdrawDto withdraw) throws Exception {
        MrcardFinanceCustomer customer = customerService.searchFinanceCustomer(withdraw.getMemberId(),withdraw.getIdentity(),withdraw.getMerchId());
        if(withdraw.getAmount().doubleValue() < 0 || withdraw.getAmount().doubleValue() > customer.getRealAmount().doubleValue())
            throw new Exception("账户余额不足");
        withdraw.setFinanceId(customer.getId());
        return withdrawService.withdraw(withdraw);
    }
    /**
     * 拒绝提现，退款
     * @param ordersn 提现业务流水id
     */
    @PostMapping("topup")
    public boolean topUP(@RequestParam String ordersn){
       return withdrawService.topUP(ordersn);
    }

}
