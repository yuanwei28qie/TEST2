package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsSysResources;
import com.microsilver.mrcard.serviceplatform.model.ImsSysResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsSysResourcesMapper {
    int countByExample(ImsSysResourcesExample example);

    int deleteByExample(ImsSysResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsSysResources record);

    int insertSelective(ImsSysResources record);

    List<ImsSysResources> selectByExampleWithBLOBs(ImsSysResourcesExample example);

    List<ImsSysResources> selectByExample(ImsSysResourcesExample example);

    ImsSysResources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsSysResources record, @Param("example") ImsSysResourcesExample example);

    int updateByExampleWithBLOBs(@Param("record") ImsSysResources record, @Param("example") ImsSysResourcesExample example);

    int updateByExample(@Param("record") ImsSysResources record, @Param("example") ImsSysResourcesExample example);

    int updateByPrimaryKeySelective(ImsSysResources record);

    int updateByPrimaryKeyWithBLOBs(ImsSysResources record);

    int updateByPrimaryKey(ImsSysResources record);
}