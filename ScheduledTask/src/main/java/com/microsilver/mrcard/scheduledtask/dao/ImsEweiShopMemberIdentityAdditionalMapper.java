package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityAdditional;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityAdditionalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImsEweiShopMemberIdentityAdditionalMapper {
    int countByExample(ImsEweiShopMemberIdentityAdditionalExample example);

    int deleteByExample(ImsEweiShopMemberIdentityAdditionalExample example);

    int deleteByPrimaryKey(Long idttId);

    int insert(ImsEweiShopMemberIdentityAdditional record);

    int insertSelective(ImsEweiShopMemberIdentityAdditional record);

    List<ImsEweiShopMemberIdentityAdditional> selectByExample(ImsEweiShopMemberIdentityAdditionalExample example);

    ImsEweiShopMemberIdentityAdditional selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberIdentityAdditional record, @Param("example") ImsEweiShopMemberIdentityAdditionalExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberIdentityAdditional record, @Param("example") ImsEweiShopMemberIdentityAdditionalExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberIdentityAdditional record);

    int updateByPrimaryKey(ImsEweiShopMemberIdentityAdditional record);

    List<OrderMQ> selectByConditionExample(OrderMQ order);
}