package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsUserPanterOrderMapper {
    int countByExample(ImsUserPanterOrderExample example);

    int deleteByExample(ImsUserPanterOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsUserPanterOrder record);

    int insertSelective(ImsUserPanterOrder record);

    List<ImsUserPanterOrder> selectByExample(ImsUserPanterOrderExample example);

    ImsUserPanterOrder selectByPrimaryKey(Long id);
    
    ImsUserPanterOrder selectByOrdersnKey(String ordersn);//新增根据业务单号查询

    int updateByExampleSelective(@Param("record") ImsUserPanterOrder record, @Param("example") ImsUserPanterOrderExample example);

    int updateByExample(@Param("record") ImsUserPanterOrder record, @Param("example") ImsUserPanterOrderExample example);

    int updateByPrimaryKeySelective(ImsUserPanterOrder record);

    int updateByPrimaryKey(ImsUserPanterOrder record);
}