package com.microsilver.mrcard.cloud.finance.controller;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dic.AgentType;
import com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType;
import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceAgentConfigService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceTaskCommissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author Jade
 * @Description 订单分成任务执行方法
 * 根据订单信息，执行分成。订单【商家，平台，代理、勇士】
 * @create 2017-07-28 下午 2:15
 * @Copyright Micro Silver
 **/

@RestController
@RequestMapping("/finance/task/")
public class FinanceTaskCommissionsController {
    private final static Logger logger = LoggerFactory.getLogger(FinanceTaskCommissionsController.class);
    @Resource
    MrcardFinanceTaskCommissionService commissionService;

    @Resource
    MrcardFinanceAgentConfigService agentConfigService;

    @Resource
    MrcardFinanceCustomerService customerService;

    @PostMapping("commibound")
    @ResponseBody
    public boolean TaskCommisstionAndBound(@RequestBody CommissionDto commission) throws Exception {
        logger.info("commibound :{} ",JSON.toJSONString(commission));
        //check
        boolean isExists = commissionService.checkComminssionData(commission.getOrderSn());
        if(isExists) {
            logger.info("重复提交分成 : {}", commission.getOrderSn());
            return true;
        }
        ProportionDto proportion = getProportionData(commission);
        return commissionService.TaskCommisstion(commission,proportion);
    }

    /*private ProportionDto getProportionData(CommissionDto commission) throws Exception {
        Short merchProportion = null;
        if(commission.getMerchInfo().getProportion() == null) {
                throw new NullPointerException("此商家分类无分润");
        }else{
            merchProportion = commission.getMerchInfo().getProportion();
        }
        if(commission.getMerchInfo().getFinanceId() == null) {
            checkFinanceAccount(commission.getMerchInfo());
        }
        MrcardFinanceAgentShareConfig agent = getParentProportionData(commission);

        return new ProportionDto(merchProportion,agent);
    }*/

    private ProportionDto getProportionData(CommissionDto commission) throws Exception {
        Short merchProportion = null;
        //check parent proxy
        MrcardFinanceAgentShareConfig agent = getParentProportionData(commission);
        //check merchInfo
        if(Objects.nonNull(commission.getMerchInfo())){
        	//零点半价走这里
            if(commission.getMerchInfo().getProportion() == null) {
                throw new NullPointerException("此商家分类无分润");
            }else{
                merchProportion = commission.getMerchInfo().getProportion();
            }
            if(commission.getMerchInfo().getFinanceId() == null) {
                checkFinanceAccount(commission.getMerchInfo());
            }
            if(Objects.nonNull(commission.getRecMemberInfo())){
            	if(commission.getRecMemberInfo().getFinanceId()==null) {
            		checkFinanceAccount(commission.getRecMemberInfo());
            	}
            }
            if(Objects.nonNull(commission.getRecMerchInfo())){
            	if(commission.getRecMerchInfo().getFinanceId()==null) {
            		checkFinanceAccount(commission.getRecMerchInfo());
            	}
            }
            ProportionDto dto = new ProportionDto(merchProportion,agent);
            
            if(commission.getRecMemberInfo()!=null&&commission.getRecMemberInfo().getProportion()!=null)
            	dto.setVIP_PROPORTION(commission.getRecMemberInfo().getProportion());
            if(commission.getRecMerchInfo()!=null&&commission.getRecMerchInfo().getProportion()!=null)
            	dto.setREM_MERCH_PROPORTION(commission.getRecMerchInfo().getProportion());
            return dto;
        }
        //check userInfo
        if(Objects.nonNull(commission.getUserInfo())){
        	//超级特价走这里
            if(commission.getUserInfo().getFinanceId() == null) {
                checkFinanceAccount(commission.getUserInfo());
            }
        }
        
        return new ProportionDto(agent);
    }

    private MrcardFinanceAgentShareConfig getParentProportionData(CommissionDto commission) throws Exception {
        String parent =  commission.getKeyWord();
        if(parent == null)
            throw new NullPointerException("代理商家信息为空");
        if(commission.getParentCustomer() == null || commission.getParentCustomer().length == 0)
            throw new NullPointerException("上级代理信息为空");
        else{
            CustomerDto[] chks = commission.getParentCustomer();
            for(CustomerDto cd : chks){
                if(cd.getFinanceId() == null)
                    checkFinanceAccount(cd);
            }
        }
        MrcardFinanceAgentShareConfig agentShareConfig = new MrcardFinanceAgentShareConfig();
        agentShareConfig.setKeyWord(parent);
        if(AgentType.getEnumValue(commission.getMerchType()) != null)
            agentShareConfig.setAgentType(commission.getMerchType().byteValue());
        List<MrcardFinanceAgentShareConfig> agentConfig = agentConfigService.getAgentConfig(agentShareConfig);
        if(agentConfig == null|| agentConfig.size() == 0)
            throw new Exception("代理商分润信息为空");
        return agentConfig.get(0);
    }

    /**
     * 下单完成预结算
     * @param commission
     * @return
     */
    @PostMapping("commission")
    @ResponseBody
    public Boolean TaskCommisstion(@RequestBody CommissionDto commission) throws Exception {
        //check
        boolean isExists = commissionService.checkComminssionData(commission.getOrderSn());
        if(isExists) {
            logger.info("重复提交分成 : {}", commission.getOrderSn());
            return true;
        }
        //get proportion
        ProportionDto proportion = getProportionData(commission);

       return commissionService.PreSettlementCalculator(commission,proportion);
    }

    /**
     * 下单完成预结算
     * @param orderSn 订单编号
     * @param commission 分为三个，1，代收货款 分成100%，2小费 分成100% ，3运费 按比例分成
     * @return
     */
    @PostMapping("commissionKnight")
    @ResponseBody
    public Boolean TaskCommisstionKnight(@RequestParam String orderSn , @RequestBody List<CommissionDto> commission) throws Exception {
        //check
        boolean isExists = commissionService.checkComminssionData(orderSn);
        if(isExists) {
            logger.info("重复提交分成 : {}", orderSn);
            return true;
        }
        if(null == commission || commission.isEmpty()) {
            logger.info("骑士请求分成数据为空 : {}", orderSn);
            return false;
        }
        /**
         * 查询运费要抽成的上级代理商信息
         */
        MrcardFinanceAgentShareConfig agent = null;
        CommissionDto dto = null;

        /*
         * for .....
         * 检查商家信息
         * 如果有代理需要分润，则检查代理商信息，代码先后顺序不得改变
         */
        for(CommissionDto cd : commission){
            if(dto == null){
                dto = cd;
                checkFinanceAccount(dto.getMerchInfo());
            }
            if(CommissionFlowType.SALE_NONE.getName().equals(cd.getRemark())){
                agent = getParentProportionData(cd);
            }
            cd.setMerchInfo(dto.getMerchInfo());//reset MerchInfo -> financeId
        }
        //check knight info
        if(dto.getMerchInfo().getFinanceId() == null) {
            checkFinanceAccount(dto.getMerchInfo());
        }
        //要参加抽成的代理商比例信息
        ProportionDto proportion =  new ProportionDto(dto.getMerchInfo().getProportion(),agent);

       return commissionService.PreSettlementCalculator(commission,proportion);
    }

    /**
     * 订单完成并到达约定结算时间 结算
     * @return
     */
    @PostMapping("bound")
    @ResponseBody
    public Boolean TaskBound(@RequestBody String orderSn) throws Exception {
        //check
        MrcardFinanceCommissionFlow isExists = commissionService.checkComminssionStatu(orderSn);
        if(isExists == null)
            throw new Exception("不存在订单号:"+orderSn);
        else if(isExists.getCommState() == 1){
            logger.info("重复提交结算 : {}", orderSn);
            return true;
        }
        return commissionService.SettlementCalculator(orderSn);
    }

     /**
     * 订单完成并到达约定结算时间 结算
      *     根据memberId,identity,merchId确定骑士身份
      *     根据订单号确定要结算并结转的订单
     * @return
     */
    @PostMapping("knightBound")
    @ResponseBody
    public Boolean TaskKnightBound(@RequestBody CommissionDto commissionDto) throws Exception {
        //check
        boolean isExists = commissionService.checkComminssionData(commissionDto.getOrderSn());
        if(!isExists)
            throw new Exception("不存在订单号:"+commissionDto.getOrderSn());
        return commissionService.SettlementCalculatorByKnight(commissionDto);
    }

    /**
     * 所有单据结算完成后，执行结转单据生成
     * @param commissionDto
     * @return 返回结转单据编号
     * @throws Exception
     */
    @PostMapping("knightCarryover")
    @ResponseBody
    public String TaskKnightCarryover(@RequestBody CarryoverKnightDto commissionDto) throws Exception {
        //check
        return commissionService.carryoverByKnight(commissionDto);
    }

    /**
     * 推荐人分成
     * @param commission
     * @return
     */
    @PostMapping("recommend")
    @ResponseBody
    public Boolean RecommendPreCommisstion(@RequestBody CommissionDto commission) throws Exception {
        //check
        boolean isExists = commissionService.checkComminssionData(commission.getOrderSn());
        if(isExists) {
            logger.info("预结算重复提交 : {}", commission.getOrderSn());
            return false;
        }
        if(!Objects.nonNull(commission.getParentCustomer())){
            logger.info("缺少推荐人信息");
            return false;
        }else{
            for(CustomerDto cd : commission.getParentCustomer()) {
                cd =checkFinanceAccount(cd);
            }
        }
        //get proportion
        ProportionDto proportion = new ProportionDto();
        BigDecimal prop = new BigDecimal(commission.getParentCustomer()[0].getProportion());
        proportion.VIP_PROPORTION = prop.divide(new BigDecimal(100));
        proportion.PLAT_PROPORTION = new BigDecimal(100);//伪数据，不参与结算
        return commissionService.RecommendPreCalculator(commission,proportion);
    }
    @PostMapping("recommendBound")
    @ResponseBody
    public Boolean RecommendCommisstion(@RequestParam String orderSn) throws Exception {
        return commissionService.RecommendCalculator(orderSn);
    }

    private CustomerDto checkFinanceAccount(CustomerDto chk) {
        MrcardFinanceCustomer financeCustomer = customerService.searchFinanceCustomer(chk.getMemberId(),chk.getIdentity(),chk.getMerchId());
        if(financeCustomer == null)
            throw new NullPointerException("客户未开通财务账号");
        else
            chk.setFinanceId(financeCustomer.getId());
        return chk;
    }

}
