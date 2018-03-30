package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterArea;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsUserPanterAreaMapper {
    int countByExample(ImsUserPanterAreaExample example);

    int deleteByExample(ImsUserPanterAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsUserPanterArea record);

    int insertSelective(ImsUserPanterArea record);

    List<ImsUserPanterArea> selectByExample(ImsUserPanterAreaExample example);

    ImsUserPanterArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsUserPanterArea record, @Param("example") ImsUserPanterAreaExample example);

    int updateByExample(@Param("record") ImsUserPanterArea record, @Param("example") ImsUserPanterAreaExample example);

    int updateByPrimaryKeySelective(ImsUserPanterArea record);

    int updateByPrimaryKey(ImsUserPanterArea record);
}