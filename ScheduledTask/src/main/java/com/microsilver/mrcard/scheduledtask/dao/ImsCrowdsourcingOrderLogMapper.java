package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrderLog;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrderLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsCrowdsourcingOrderLogMapper {
    int countByExample(ImsCrowdsourcingOrderLogExample example);

    int deleteByExample(ImsCrowdsourcingOrderLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsCrowdsourcingOrderLog record);

    int insertSelective(ImsCrowdsourcingOrderLog record);

    List<ImsCrowdsourcingOrderLog> selectByExample(ImsCrowdsourcingOrderLogExample example);

    ImsCrowdsourcingOrderLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsCrowdsourcingOrderLog record, @Param("example") ImsCrowdsourcingOrderLogExample example);

    int updateByExample(@Param("record") ImsCrowdsourcingOrderLog record, @Param("example") ImsCrowdsourcingOrderLogExample example);

    int updateByPrimaryKeySelective(ImsCrowdsourcingOrderLog record);

    int updateByPrimaryKey(ImsCrowdsourcingOrderLog record);
}