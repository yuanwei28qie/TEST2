package com.microsilver.mrcard.cloud.finance.dao;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlement;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrcardFinanceSettlementMapper {
    int countByExample(MrcardFinanceSettlementExample example);

    int deleteByExample(MrcardFinanceSettlementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MrcardFinanceSettlement record);

    int insertSelective(MrcardFinanceSettlement record);

    List<MrcardFinanceSettlement> selectByExample(MrcardFinanceSettlementExample example);

    MrcardFinanceSettlement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MrcardFinanceSettlement record, @Param("example") MrcardFinanceSettlementExample example);

    int updateByExample(@Param("record") MrcardFinanceSettlement record, @Param("example") MrcardFinanceSettlementExample example);

    int updateByPrimaryKeySelective(MrcardFinanceSettlement record);

    int updateByPrimaryKey(MrcardFinanceSettlement record);
}