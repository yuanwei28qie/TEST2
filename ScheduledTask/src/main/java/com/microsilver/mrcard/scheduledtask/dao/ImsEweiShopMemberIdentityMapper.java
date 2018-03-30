package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMemberIdentityMapper {
    int countByExample(ImsEweiShopMemberIdentityExample example);

    List<ImsEweiShopMemberIdentity> selectByExample(ImsEweiShopMemberIdentityExample example);

    ImsEweiShopMemberIdentity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberIdentity record, @Param("example") ImsEweiShopMemberIdentityExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberIdentity record);

    int updateByPrimaryKey(ImsEweiShopMemberIdentity record);
}