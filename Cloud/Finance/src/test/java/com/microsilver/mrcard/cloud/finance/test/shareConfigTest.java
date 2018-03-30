package com.microsilver.mrcard.cloud.finance.test;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceAgentConfigService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Jade
 * @Description ${DESCRIPTION}
 * @create 2017-07-31 下午 5:08
 * @Copyright Micro Silver
 **/

public class shareConfigTest {

    @Resource
    MrcardFinanceAgentConfigService configService;

    @Test
    public void agentConfigTest(){
        MrcardFinanceAgentShareConfig config = new MrcardFinanceAgentShareConfig();

        configService.addAgentConfig(config);
    }

}
