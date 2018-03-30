package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCategory;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopCategoryMapper {
    int countByExample(ImsEweiShopCategoryExample example);

    int deleteByExample(ImsEweiShopCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopCategory record);

    int insertSelective(ImsEweiShopCategory record);

    List<ImsEweiShopCategory> selectByExample(ImsEweiShopCategoryExample example);

    ImsEweiShopCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopCategory record, @Param("example") ImsEweiShopCategoryExample example);

    int updateByExample(@Param("record") ImsEweiShopCategory record, @Param("example") ImsEweiShopCategoryExample example);

    int updateByPrimaryKeySelective(ImsEweiShopCategory record);

    int updateByPrimaryKey(ImsEweiShopCategory record);
}