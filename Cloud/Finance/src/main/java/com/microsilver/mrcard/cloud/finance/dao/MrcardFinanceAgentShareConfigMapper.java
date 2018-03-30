package com.microsilver.mrcard.cloud.finance.dao;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MrcardFinanceAgentShareConfigMapper {
    int countByExample(MrcardFinanceAgentShareConfigExample example);

    int deleteByExample(MrcardFinanceAgentShareConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MrcardFinanceAgentShareConfig record);

    int insertSelective(MrcardFinanceAgentShareConfig record);

    List<MrcardFinanceAgentShareConfig> selectByExample(MrcardFinanceAgentShareConfigExample example);

    MrcardFinanceAgentShareConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MrcardFinanceAgentShareConfig record, @Param("example") MrcardFinanceAgentShareConfigExample example);

    int updateByExample(@Param("record") MrcardFinanceAgentShareConfig record, @Param("example") MrcardFinanceAgentShareConfigExample example);

    int updateByPrimaryKeySelective(MrcardFinanceAgentShareConfig record);

    int updateByPrimaryKey(MrcardFinanceAgentShareConfig record);
}