package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiMemberCard;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiMemberCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiMemberCardMapper {
    int countByExample(ImsEweiMemberCardExample example);

    int deleteByExample(ImsEweiMemberCardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiMemberCard record);

    int insertSelective(ImsEweiMemberCard record);

    List<ImsEweiMemberCard> selectByExample(ImsEweiMemberCardExample example);

    ImsEweiMemberCard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiMemberCard record, @Param("example") ImsEweiMemberCardExample example);

    int updateByExample(@Param("record") ImsEweiMemberCard record, @Param("example") ImsEweiMemberCardExample example);

    int updateByPrimaryKeySelective(ImsEweiMemberCard record);

    int updateByPrimaryKey(ImsEweiMemberCard record);
}