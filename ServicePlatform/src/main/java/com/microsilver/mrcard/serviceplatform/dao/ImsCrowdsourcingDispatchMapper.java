package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingDispatch;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingDispatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsCrowdsourcingDispatchMapper {
    int countByExample(ImsCrowdsourcingDispatchExample example);

    int deleteByExample(ImsCrowdsourcingDispatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsCrowdsourcingDispatch record);

    int insertSelective(ImsCrowdsourcingDispatch record);

    List<ImsCrowdsourcingDispatch> selectByExample(ImsCrowdsourcingDispatchExample example);

    ImsCrowdsourcingDispatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsCrowdsourcingDispatch record, @Param("example") ImsCrowdsourcingDispatchExample example);

    int updateByExample(@Param("record") ImsCrowdsourcingDispatch record, @Param("example") ImsCrowdsourcingDispatchExample example);

    int updateByPrimaryKeySelective(ImsCrowdsourcingDispatch record);

    int updateByPrimaryKey(ImsCrowdsourcingDispatch record);
}