package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsSysRemind;
import com.microsilver.mrcard.serviceplatform.model.ImsSysRemindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsSysRemindMapper {
    int countByExample(ImsSysRemindExample example);

    int deleteByExample(ImsSysRemindExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsSysRemind record);

    int insertSelective(ImsSysRemind record);

    List<ImsSysRemind> selectByExample(ImsSysRemindExample example);

    ImsSysRemind selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsSysRemind record, @Param("example") ImsSysRemindExample example);

    int updateByExample(@Param("record") ImsSysRemind record, @Param("example") ImsSysRemindExample example);

    int updateByPrimaryKeySelective(ImsSysRemind record);

    int updateByPrimaryKey(ImsSysRemind record);
}