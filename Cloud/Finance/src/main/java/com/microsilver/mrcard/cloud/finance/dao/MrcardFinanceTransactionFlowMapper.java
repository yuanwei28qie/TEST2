package com.microsilver.mrcard.cloud.finance.dao;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MrcardFinanceTransactionFlowMapper {
    int countByExample(MrcardFinanceTransactionFlowExample example);

    int deleteByExample(MrcardFinanceTransactionFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MrcardFinanceTransactionFlow record);

    int insertSelective(MrcardFinanceTransactionFlow record);

    List<MrcardFinanceTransactionFlow> selectByExample(MrcardFinanceTransactionFlowExample example);

    MrcardFinanceTransactionFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MrcardFinanceTransactionFlow record, @Param("example") MrcardFinanceTransactionFlowExample example);

    int updateByExample(@Param("record") MrcardFinanceTransactionFlow record, @Param("example") MrcardFinanceTransactionFlowExample example);

    int updateByPrimaryKeySelective(MrcardFinanceTransactionFlow record);

    int updateByPrimaryKey(MrcardFinanceTransactionFlow record);
}