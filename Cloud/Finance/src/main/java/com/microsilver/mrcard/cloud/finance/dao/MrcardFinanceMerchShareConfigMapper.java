package com.microsilver.mrcard.cloud.finance.dao;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchShareConfig;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchShareConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MrcardFinanceMerchShareConfigMapper {
    int countByExample(MrcardFinanceMerchShareConfigExample example);

    int deleteByExample(MrcardFinanceMerchShareConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MrcardFinanceMerchShareConfig record);

    int insertSelective(MrcardFinanceMerchShareConfig record);

    List<MrcardFinanceMerchShareConfig> selectByExample(MrcardFinanceMerchShareConfigExample example);

    MrcardFinanceMerchShareConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MrcardFinanceMerchShareConfig record, @Param("example") MrcardFinanceMerchShareConfigExample example);

    int updateByExample(@Param("record") MrcardFinanceMerchShareConfig record, @Param("example") MrcardFinanceMerchShareConfigExample example);

    int updateByPrimaryKeySelective(MrcardFinanceMerchShareConfig record);

    int updateByPrimaryKey(MrcardFinanceMerchShareConfig record);
}