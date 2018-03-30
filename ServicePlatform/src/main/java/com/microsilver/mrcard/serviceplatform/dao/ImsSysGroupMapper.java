package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsSysGroup;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsSysGroupMapper {
    int countByExample(ImsSysGroupExample example);

    int deleteByExample(ImsSysGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsSysGroup record);

    int insertSelective(ImsSysGroup record);

    List<ImsSysGroup> selectByExampleWithBLOBs(ImsSysGroupExample example);

    List<ImsSysGroup> selectByExample(ImsSysGroupExample example);

    ImsSysGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsSysGroup record, @Param("example") ImsSysGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") ImsSysGroup record, @Param("example") ImsSysGroupExample example);

    int updateByExample(@Param("record") ImsSysGroup record, @Param("example") ImsSysGroupExample example);

    int updateByPrimaryKeySelective(ImsSysGroup record);

    int updateByPrimaryKeyWithBLOBs(ImsSysGroup record);

    int updateByPrimaryKey(ImsSysGroup record);
}