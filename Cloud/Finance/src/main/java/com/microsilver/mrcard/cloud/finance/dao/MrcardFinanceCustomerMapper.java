package com.microsilver.mrcard.cloud.finance.dao;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrcardFinanceCustomerMapper {
    int countByExample(MrcardFinanceCustomerExample example);

    int insert(MrcardFinanceCustomer record);

    int insertSelective(MrcardFinanceCustomer record);

    List<MrcardFinanceCustomer> selectByExample(MrcardFinanceCustomerExample example);

    MrcardFinanceCustomer selectByPrimaryKey(Long idttId);

    int updateByExampleSelective(@Param("record") MrcardFinanceCustomer record, @Param("example") MrcardFinanceCustomerExample example);

    int updateByExample(@Param("record") MrcardFinanceCustomer record, @Param("example") MrcardFinanceCustomerExample example);

    int updateByPrimaryKeySelective(MrcardFinanceCustomer record);

    int updateByPrimaryKey(MrcardFinanceCustomer record);
}