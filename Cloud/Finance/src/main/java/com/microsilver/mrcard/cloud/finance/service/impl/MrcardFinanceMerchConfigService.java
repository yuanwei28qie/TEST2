package com.microsilver.mrcard.cloud.finance.service.impl;

import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceMerchShareConfigMapper;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchShareConfig;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchShareConfigExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 商户分润比例配置
 *
 * @author Jade
 * @create 2017-07-27 上午 11:13
 * @Copyright Micro Silver
 **/
@Service
public class MrcardFinanceMerchConfigService {

    private final static Logger logger = LoggerFactory.getLogger(MrcardFinanceMerchConfigService.class);

    @Autowired
    MrcardFinanceMerchShareConfigMapper imerchConfigMapper;

    @Transactional
    public boolean addMerchConfig(MrcardFinanceMerchShareConfig agentConfig){
        int result = imerchConfigMapper.insert(agentConfig);
        if(result == 1)
            return true;
        return false;
    }

    @Transactional
    public boolean updateMerchConfig(MrcardFinanceMerchShareConfig agentConfig){
        int result = imerchConfigMapper.updateByPrimaryKeySelective(agentConfig);
        if(result == 1)
            return true;
        return false;
    }

    @Transactional
    public boolean deleteMerchConfig(long id){
        int result = imerchConfigMapper.deleteByPrimaryKey(id);
        if(result == 1)
            return true;
        return false;
    }

    public List<MrcardFinanceMerchShareConfig> getMerchConfig(MrcardFinanceMerchShareConfig agentConfig){
        MrcardFinanceMerchShareConfigExample agent = new MrcardFinanceMerchShareConfigExample();
        agent.createCriteria().andIdentityEqualTo(agentConfig.getIdentity()).andMerchCateIdEqualTo(agentConfig.getMerchCateId());
        List<MrcardFinanceMerchShareConfig> list = imerchConfigMapper.selectByExample(agent);
        return list;
    }

    public MrcardFinanceMerchShareConfig getMerchConfigById(long Id){
        return imerchConfigMapper.selectByPrimaryKey(Id);
    }
}
