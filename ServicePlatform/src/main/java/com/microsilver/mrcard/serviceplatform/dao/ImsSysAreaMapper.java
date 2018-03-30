package com.microsilver.mrcard.serviceplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsSysAreaExample;

@Repository 
public interface ImsSysAreaMapper {
    int countByExample(ImsSysAreaExample example);

    int deleteByExample(ImsSysAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsSysArea record);

    int insertSelective(ImsSysArea record);

    List<ImsSysArea> selectByExample(ImsSysAreaExample example);

    ImsSysArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsSysArea record, @Param("example") ImsSysAreaExample example);

    int updateByExample(@Param("record") ImsSysArea record, @Param("example") ImsSysAreaExample example);

    int updateByPrimaryKeySelective(ImsSysArea record);

    int updateByPrimaryKey(ImsSysArea record);

	List<ImsSysArea> selectByExampleWithCounts(ImsSysAreaExample areaExample);
}