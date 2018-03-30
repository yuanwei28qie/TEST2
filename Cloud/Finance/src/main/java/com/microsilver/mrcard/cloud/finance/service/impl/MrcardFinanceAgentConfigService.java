package com.microsilver.mrcard.cloud.finance.service.impl;

import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceAgentShareConfigMapper;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfigExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 代理商分润比例配置
 *
 * @author Jade
 * @create 2017-07-27 上午 11:13
 * @Copyright Micro Silver
 **/

@Service
public class MrcardFinanceAgentConfigService {

    private final static Logger logger = LoggerFactory.getLogger(MrcardFinanceAgentConfigService.class);

    @Autowired
    MrcardFinanceAgentShareConfigMapper iagentShareConfig;

    @Transactional
    public boolean addAgentConfig(MrcardFinanceAgentShareConfig agentConfig){
        int result = iagentShareConfig.insert(agentConfig);
        if(result == 1)
            return true;
        return false;
    }

    @Transactional
    public boolean updateAgentConfig(MrcardFinanceAgentShareConfig agentConfig){
        int result = iagentShareConfig.updateByPrimaryKeySelective(agentConfig);
        if(result == 1)
            return true;
        return false;
    }

    @Transactional
    public boolean deleteAgentConfig(long id){
        int result = iagentShareConfig.deleteByPrimaryKey(id);
        if(result == 1)
            return true;
        return false;
    }

    public List<MrcardFinanceAgentShareConfig> getAgentConfig(MrcardFinanceAgentShareConfig agentConfig){
        MrcardFinanceAgentShareConfigExample agent = new MrcardFinanceAgentShareConfigExample();
        MrcardFinanceAgentShareConfigExample.Criteria criteria = agent.createCriteria();
        if(null != agentConfig.getKeyWord())
            criteria.andKeyWordEqualTo(agentConfig.getKeyWord());
        if(null != agentConfig.getAgentType())
            criteria.andAgentTypeEqualTo(agentConfig.getAgentType());
        List<MrcardFinanceAgentShareConfig> list = iagentShareConfig.selectByExample(agent);
        return list;
    }

    public MrcardFinanceAgentShareConfig getAgentConfigById(long Id){
        return iagentShareConfig.selectByPrimaryKey(Id);
    }

}
