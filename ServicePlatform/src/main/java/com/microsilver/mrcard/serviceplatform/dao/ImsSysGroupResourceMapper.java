package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupResource;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsSysGroupResourceMapper {
    int countByExample(ImsSysGroupResourceExample example);

    int deleteByExample(ImsSysGroupResourceExample example);

    int insert(ImsSysGroupResource record);

    int insertSelective(ImsSysGroupResource record);

    List<ImsSysGroupResource> selectByExample(ImsSysGroupResourceExample example);

    int updateByExampleSelective(@Param("record") ImsSysGroupResource record, @Param("example") ImsSysGroupResourceExample example);

    int updateByExample(@Param("record") ImsSysGroupResource record, @Param("example") ImsSysGroupResourceExample example);
}