package com.microsilver.mrcard.cloud.finance.test;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceAgentConfigService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceWithdrawService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jade
 * @Description ${DESCRIPTION}
 * @create 2017-08-02 下午 5:51
 * @Copyright Micro Silver
 **/
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
public class WithDrawTest {

    private final static Logger logger = LoggerFactory.getLogger(WithDrawTest.class);

    @Resource
    MrcardFinanceCustomerService customerService;

    @Resource
    MrcardFinanceWithdrawService withdrawService;

    @Test
    public void mainTEST(){
        List<Long> longList = new ArrayList<>();
        longList.add((long) 1);
        longList.add((long) 2);
        System.out.println(JSON.toJSONString(longList));
    }

    @Test
    public void loggerTest(){
        long memberId = 99;
        short identity = 21;
        long merchId = 99;
        BigDecimal money = new BigDecimal(100);
        WithdrawDto withdraw = new WithdrawDto();
        withdraw.setAmount(money);
        withdraw.setMemberId(memberId);
        withdraw.setMerchId(merchId);
        withdraw.setIdentity(identity);
        logger.info("xxxx{}yyyyyy{}","AAAAA",withdraw);

    }

    @Test
    public void checkGetPrimaryKey(){
        long memberId = 99;
        short identity = 21;
        long merchId = 99;
        BigDecimal money = new BigDecimal(100);
        WithdrawDto withdraw = new WithdrawDto();
        withdraw.setAmount(money);
        withdraw.setMemberId(memberId);
        withdraw.setMerchId(merchId);
        withdraw.setIdentity(identity);
        MrcardFinanceCustomer customer = customerService.searchFinanceCustomer(withdraw.getMemberId(),withdraw.getIdentity(),withdraw.getMerchId());
        System.out.println(JSON.toJSONString(customer));
    }

    @Test
    public void withdraw() throws Exception {
        long memberId = 118;
        short identity = 21;
        long merchId = 824;
        BigDecimal money = new BigDecimal(100);
        WithdrawDto withdraw = new WithdrawDto();
        withdraw.setAmount(money);
        withdraw.setMemberId(memberId);
        withdraw.setMerchId(merchId);
        withdraw.setIdentity(identity);

        MrcardFinanceCustomer customer = customerService.getCustomer(withdraw.getMemberId(),withdraw.getIdentity(),withdraw.getMerchId());
        if(withdraw.getAmount().doubleValue() < 0 || withdraw.getAmount().doubleValue() > customer.getRealAmount().doubleValue())
            throw new Exception("账户余额不足");
        withdraw.setFinanceId(customer.getId());
        System.out.println(withdrawService.withdraw(withdraw));
    }

    @Test
    public void topUP(){
        String id = "132";
        System.out.println(withdrawService.topUP(id));
    }
}
