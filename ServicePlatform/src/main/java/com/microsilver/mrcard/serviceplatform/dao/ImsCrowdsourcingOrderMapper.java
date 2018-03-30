package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrderExample;
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
    
    ImsCrowdsourcingOrder selectByPrimaryKeyForUpdate(Long id);

    int updateByExampleSelective(@Param("record") ImsCrowdsourcingOrder record, @Param("example") ImsCrowdsourcingOrderExample example);

    int updateByExample(@Param("record") ImsCrowdsourcingOrder record, @Param("example") ImsCrowdsourcingOrderExample example);

    int updateByPrimaryKeySelective(ImsCrowdsourcingOrder record);

    int updateByPrimaryKey(ImsCrowdsourcingOrder record);

	ImsCrowdsourcingOrder selectTodayDetails(ImsCrowdsourcingOrderExample orderExample);

	List<ImsCrowdsourcingOrder> selectByExampleWithLocation(ImsCrowdsourcingOrderExample orderExample);

    List<ImsCrowdsourcingOrder> selectByLOGStatus(@Param("courierAppraise") Boolean courierAppraise,@Param("settlement") Byte settlement,@Param("courier")Long courier ,@Param("status") Byte status,@Param("beginTime") Integer beginTime , @Param("endTime")Integer endTime);


}