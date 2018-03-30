package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsSysDictionaryMapper {
    int countByExample(ImsSysDictionaryExample example);

    int deleteByExample(ImsSysDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsSysDictionary record);

    int insertSelective(ImsSysDictionary record);

    List<ImsSysDictionary> selectByExample(ImsSysDictionaryExample example);

    ImsSysDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsSysDictionary record, @Param("example") ImsSysDictionaryExample example);

    int updateByExample(@Param("record") ImsSysDictionary record, @Param("example") ImsSysDictionaryExample example);

    int updateByPrimaryKeySelective(ImsSysDictionary record);

    int updateByPrimaryKey(ImsSysDictionary record);
}