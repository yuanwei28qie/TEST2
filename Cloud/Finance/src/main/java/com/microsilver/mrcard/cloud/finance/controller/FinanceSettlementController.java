package com.microsilver.mrcard.cloud.finance.controller;

import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.SettlementSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlement;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceMerchFlowService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceSettlementService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.cloud.finance.controller.FinanceSettlementController
 * @Description  系统结转骑士单据
 * @Author Jade
 * @Version 2017/9/5
 * @Copyright Micro Silver
 */

@RestController
@RequestMapping("/finance/settlement/")
public class FinanceSettlementController {
    @Resource
    MrcardFinanceCustomerService customerService;
    @Resource
    private MrcardFinanceSettlementService settlementService;
    @Resource
    MrcardFinanceWithdrawService withdrawService;

    /**
     * 查询结算单
     * @return
     */
    @PostMapping("searchSettlement")
    public PageInfo<MrcardFinanceSettlement> searchSettlement(SettlementSearchDto searchDto){
        return settlementService.searchSettlement(searchDto);
    }
    /**
     * 结算单据审核
     * 审核通过，生成提现流水单据
     * @return
     */
    @PostMapping("carryoverExamine")
    public Boolean tobelanceKnight(@RequestParam String operatorName ,@RequestParam String settlementsn,@RequestParam Boolean status) throws Exception {
        MrcardFinanceSettlement settlement = settlementService.selectBYSettlement(settlementsn);
        if(null == settlement){
            throw new Exception("无此账单，请检查后再操作");
        }
        if(status){
            settlement.setCheckName(operatorName);
            settlement.setCheckTime((int) (System.currentTimeMillis()/1000));
            return withdrawByKnight(settlement);
        }else{
            return topUPKnight(settlement);
        }
    }

    /**
     * 手动结算骑士数据
     *  检查是否已经有结转单据
     *  检查状态是否已经打款-已打款的不允许进行清除
     *  清除前面的结转单据
     *  重新进行结转
     * @return
     */
    @PostMapping("carryoverByAdmin")
    public String carryoverByAdmin(@RequestBody CarryoverKnightDto carryoverKnightDto) throws Exception {
        if(carryoverKnightDto != null && carryoverKnightDto.getSettlementSn() != null) {
            MrcardFinanceSettlement settlement = settlementService.selectBYSettlement(carryoverKnightDto.getSettlementSn());
            if(null != settlement && settlement.getStatus() != 2){
                settlementService.deleteBySettlement(settlement.getId());
            }else if(null != settlement && settlement.getStatus() == 2){
                throw new Exception(carryoverKnightDto.getSettlementSn()+":已经打款不允许重复结算");
            }else{
                //do nothing
            }
        }
        String settlementSn = settlementService.carryoverByKnight(carryoverKnightDto);
       return settlementSn;
    }

    /**
     * 提现
     *      生成提现流水单
     *      扣除账户中可提现金额
     *      变更结转单审核状态
     * @param settlement
     * @return
     * @throws Exception
     */
    private Boolean withdrawByKnight(MrcardFinanceSettlement settlement) throws Exception {
            Long recordId =  withdrawService.withdrawByKnight(settlement);
            if(recordId != null){
                settlement.setStatus((byte)2);
                return settlementService.changeSettlementByStatus(settlement);
            }
        return false;
    }

    /**
     * 退回
     *     改变结转单审核状态
     * @param settlement
     * @return
     */
    private boolean topUPKnight(MrcardFinanceSettlement settlement){
        //由于提现才生成流水单，则退回时不进行客户账户扣款退回操作
        //withdrawService.topUPByKnight(settlement.getSettlementsn());
        settlement.setStatus((byte)-1);
        return settlementService.changeSettlementByStatus(settlement);
    }

    /**
     * 提现记录 根据用户申请业务编号生成
     * @return 返回提现记录流水号
     */
    @PostMapping("tobelanceAdvance")
    public Long withdrawByAdvance(@RequestBody WithdrawDto withdraw) throws Exception {
        MrcardFinanceCustomer customer = customerService.getCustomer(withdraw.getMemberId(),withdraw.getIdentity(),withdraw.getMerchId());
        if(withdraw.getAmount().doubleValue() < 0 || withdraw.getAmount().doubleValue() > customer.getAdvanceAmount().doubleValue())
            throw new Exception("账户余额不足");
        withdraw.setFinanceId(customer.getId());
        return withdrawService.withdrawByAdvance(withdraw);
    }
    /**
     * 拒绝提现，退款
     * @param ordersn 提现业务流水id
     */
    @PostMapping("topupAdvance")
    public boolean topUPAdvance(@RequestParam String ordersn){
        return withdrawService.topUPByAdvance(ordersn);
    }

}
