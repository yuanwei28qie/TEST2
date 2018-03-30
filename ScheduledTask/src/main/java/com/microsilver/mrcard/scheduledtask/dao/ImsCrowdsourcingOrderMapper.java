package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsCrowdsourcingOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsCrowdsourcingOrderMapper {
    int countByExample(ImsCrowdsourcingOrderExample example);

    int deleteByExample(ImsCrowdsourcingOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsCrowdsourcingOrder record);

    int insertSelective(ImsCrowdsourcingOrder record);

    List<ImsCrowdsourcingOrder> selectByExample(ImsCrowdsourcingOrderExample example);

    ImsCrowdsourcingOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsCrowdsourcingOrder record, @Param("example") ImsCrowdsourcingOrderExample example);

    int updateByExample(@Param("record") ImsCrowdsourcingOrder record, @Param("example") ImsCrowdsourcingOrderExample example);

    int updateByPrimaryKeySelective(ImsCrowdsourcingOrder record);

    int updateByPrimaryKey(ImsCrowdsourcingOrder record);

	List<ImsCrowdsourcingOrder> selectByExampleWithOrderLog(ImsCrowdsourcingOrderExample example);

    List<ImsCrowdsourcingOrder> selectByLOGStatus(@Param("courierAppraise") Boolean courierAppraise,@Param("isSettlement") Byte settlement ,@Param("status") Byte status,@Param("beginTime") Integer beginTime , @Param("endTime")Integer endTime);

}