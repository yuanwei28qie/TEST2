package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopSystemAdv;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopSystemAdvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopSystemAdvMapper {
    int countByExample(ImsEweiShopSystemAdvExample example);

    int deleteByExample(ImsEweiShopSystemAdvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopSystemAdv record);

    int insertSelective(ImsEweiShopSystemAdv record);

    List<ImsEweiShopSystemAdv> selectByExample(ImsEweiShopSystemAdvExample example);

    ImsEweiShopSystemAdv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopSystemAdv record, @Param("example") ImsEweiShopSystemAdvExample example);

    int updateByExample(@Param("record") ImsEweiShopSystemAdv record, @Param("example") ImsEweiShopSystemAdvExample example);

    int updateByPrimaryKeySelective(ImsEweiShopSystemAdv record);

    int updateByPrimaryKey(ImsEweiShopSystemAdv record);
}