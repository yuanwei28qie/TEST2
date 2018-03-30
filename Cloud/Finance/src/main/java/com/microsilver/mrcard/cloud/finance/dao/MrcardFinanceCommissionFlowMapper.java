package com.microsilver.mrcard.cloud.finance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.microsilver.mrcard.cloud.finance.dto.CommissionFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceCommissionFlowResultDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlowExample;

public interface MrcardFinanceCommissionFlowMapper {
    int countByExample(MrcardFinanceCommissionFlowExample example);

    int deleteByExample(MrcardFinanceCommissionFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MrcardFinanceCommissionFlow record);

    int insertSelective(MrcardFinanceCommissionFlow record);

    List<MrcardFinanceCommissionFlow> selectByExample(MrcardFinanceCommissionFlowExample example);
    
    List<FinanceCommissionFlowResultDto> selectCommissionByOrders(CommissionFlowSearchDto example);

    Page<MrcardFinanceCommissionFlow> selectCommissionByExample(CommissionFlowSearchDto example);

    Page<MrcardFinanceCommissionFlow> selectKnightCommissionByExample(CommissionFlowSearchDto example);

    MrcardFinanceCommissionFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MrcardFinanceCommissionFlow record, @Param("example") MrcardFinanceCommissionFlowExample example);

    int updateByExample(@Param("record") MrcardFinanceCommissionFlow record, @Param("example") MrcardFinanceCommissionFlowExample example);

    int updateByPrimaryKeySelective(MrcardFinanceCommissionFlow record);

    int updateByPrimaryKey(MrcardFinanceCommissionFlow record);
}