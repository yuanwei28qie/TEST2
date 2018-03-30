package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopTags;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopTagsMapper {
    int countByExample(ImsEweiShopTagsExample example);

    int deleteByExample(ImsEweiShopTagsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopTags record);

    int insertSelective(ImsEweiShopTags record);

    List<ImsEweiShopTags> selectByExample(ImsEweiShopTagsExample example);

    ImsEweiShopTags selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopTags record, @Param("example") ImsEweiShopTagsExample example);

    int updateByExample(@Param("record") ImsEweiShopTags record, @Param("example") ImsEweiShopTagsExample example);

    int updateByPrimaryKeySelective(ImsEweiShopTags record);

    int updateByPrimaryKey(ImsEweiShopTags record);
}