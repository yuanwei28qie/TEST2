package com.microsilver.mrcard.cloud.finance.test;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchShareConfig;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceAgentConfigService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceMerchConfigService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceTaskCommissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jade
 * @Description ${DESCRIPTION}
 * @create 2017-07-31 下午 4:45
 * @Copyright Micro Silver
 **/

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TaskCommissionTest {
    private final static Logger logger = LoggerFactory.getLogger(TaskCommissionTest.class);

    @Autowired
    MrcardFinanceTaskCommissionService commissionService;

    @Autowired
    MrcardFinanceMerchConfigService merchConfigService;

    @Autowired
    MrcardFinanceAgentConfigService agentConfigService;

    @Autowired
    MrcardFinanceCustomerService customerService;

    @Test
    public void taskCommissionDataTest() {
        CommissionDto commission = initCommissionData();

        logger.info(JSON.toJSONString(commission));

        MrcardFinanceMerchShareConfig merchShareConfig = new MrcardFinanceMerchShareConfig();
        merchShareConfig.setMerchCateId(commission.getMerchType());
        merchShareConfig.setIdentity((byte) commission.getMerchInfo().getIdentity());
        List<MrcardFinanceMerchShareConfig> merchConfig = merchConfigService.getMerchConfig(merchShareConfig);
        if (merchConfig == null || merchConfig.size() == 0)
            logger.info("此商家分类无分润");

        String parent = commission.getKeyWord();
        if (parent == null)
            logger.info("代理商家信息为空");
        if (commission.getParentCustomer() == null || commission.getParentCustomer().length == 0)
            logger.info("上级代理信息为空");
        MrcardFinanceAgentShareConfig agentShareConfig = new MrcardFinanceAgentShareConfig();
        agentShareConfig.setKeyWord(parent);
        List<MrcardFinanceAgentShareConfig> agentConfig = agentConfigService.getAgentConfig(agentShareConfig);
        if (agentConfig == null || agentConfig.size() == 0)
            logger.info("代理商分润信息为空");
        MrcardFinanceAgentShareConfig agent = agentConfig.get(0);

        ProportionDto proportion = new ProportionDto(merchConfig.get(0).getProportion(),agent);

        try {
            commissionService.TaskCommisstion(commission, proportion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void TaskCommisstion() throws Exception {
        CommissionDto commission = initCommissionData();
        checkFinanceAccount(commission.getMerchInfo());
        CustomerDto[] ploxy = commission.getParentCustomer();
        for(CustomerDto cd :ploxy){
            checkFinanceAccount(cd);
        }
        //check
        boolean isExists = commissionService.checkComminssionData(commission.getOrderSn());
        if(isExists)
            try {
                throw new Exception("重复提交分成 : "+commission.getOrderSn());

            } catch (Exception e) {
                e.printStackTrace();
            }
        //get proportion
        ProportionDto proportion = null;
        try {
            proportion = getProportionData(commission);
            commissionService.PreSettlementCalculator(commission,proportion);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 订单完成并到达约定结算时间 结算
     * @return
     */
    @Test
    public void TaskBound() throws Exception {
        String orderSn = "333";
        //check
        boolean isExists = commissionService.checkComminssionData(orderSn);
        if(!isExists)
            throw new Exception("不存在订单号:"+orderSn);
        commissionService.SettlementCalculator(orderSn);
    }

    private CustomerDto checkFinanceAccount(CustomerDto chk) {
        MrcardFinanceCustomer financeCustomer = customerService.searchFinanceCustomer(chk.getMemberId(),chk.getIdentity(),chk.getMerchId());
        if(financeCustomer == null)
            throw new NullPointerException("商户未开通财务账号");
        else
            chk.setFinanceId(financeCustomer.getId());
        return chk;
    }
    private ProportionDto getProportionData(CommissionDto commission) throws Exception {
        Short merchProportion = null;
        if(commission.getMerchInfo().getProportion() == null) {
            MrcardFinanceMerchShareConfig merchShareConfig = new MrcardFinanceMerchShareConfig();
            merchShareConfig.setMerchCateId(commission.getMerchType());
            merchShareConfig.setIdentity((byte) commission.getMerchInfo().getIdentity());
            List<MrcardFinanceMerchShareConfig> merchList = merchConfigService.getMerchConfig(merchShareConfig);
            if (merchList == null || merchList.size() == 0)
                throw new NullPointerException("此商家分类无分润");
            merchProportion = merchList.get(0).getProportion();
        }else{
            merchProportion = commission.getMerchInfo().getProportion();
        }
        String parent =  commission.getKeyWord();
        if(parent == null)
            throw new NullPointerException("代理商家信息为空");
        if(commission.getParentCustomer() == null || commission.getParentCustomer().length == 0)
            throw new NullPointerException("上级代理信息为空");

        MrcardFinanceAgentShareConfig agentShareConfig = new MrcardFinanceAgentShareConfig();
        agentShareConfig.setKeyWord(parent);
        List<MrcardFinanceAgentShareConfig> agentConfig = agentConfigService.getAgentConfig(agentShareConfig);
        if(agentConfig == null|| agentConfig.size() == 0)
            throw new Exception("代理商分润信息为空");
        MrcardFinanceAgentShareConfig agent = agentConfig.get(0);

        return new ProportionDto(merchProportion,agent);
    }

    /**
     * 组装客户数据
     * @return
     */
    private CommissionDto initCommissionData() {
        CommissionDto customer = new CommissionDto();
        customer.setKeyWord("2_0_0_0_0_0_0");
        customer.setOrderType(1);
        CustomerDto cd = new CustomerDto();
        cd.setFinanceId(1L);
        cd.setIdentity((short) 21);
        cd.setMemberName("商户");
        cd.setMerchId(1L);
        cd.setMemberId(1L);
        customer.setMerchType(0);
        customer.setMerchInfo(cd);

        customer.setOrderSn("333");
        customer.setTotalAmount(new BigDecimal(100));

        CustomerDto [] dtos = new CustomerDto[5];

        CustomerDto c0 = new CustomerDto();
        c0.setFinanceId(2L);
        c0.setIdentity((short)2);
        c0.setMemberId(2L);
        c0.setMerchId(2L);
        c0.setMemberName("平台");
        dtos[0] = c0;

        CustomerDto c1 = new CustomerDto();
        c1.setFinanceId(3L);
        c1.setIdentity((short)23);
        c1.setMemberId(3L);
        c1.setMerchId(3L);
        c1.setMemberName("省代");
        dtos[1] = c1;

        CustomerDto c2 = new CustomerDto();
        c2.setFinanceId(4L);
        c2.setIdentity((short)24);
        c2.setMemberId(4L);
        c2.setMerchId(4L);
        c2.setMemberName("市代");
        dtos[2] = c2;

        CustomerDto c3 = new CustomerDto();
        c3.setFinanceId(5L);
        c3.setIdentity((short)25);
        c3.setMemberId(5L);
        c3.setMerchId(5L);
        c3.setMemberName("县代");
        dtos[3] = c3;

        CustomerDto c4 = new CustomerDto();
        c4.setFinanceId(6L);
        c4.setIdentity((short)26);
        c4.setMemberId(6L);
        c4.setMerchId(6L);
        c4.setMemberName("勇士");
        dtos[4] = c4;

        customer.setParentCustomer(dtos);
        return customer;
    }
}
