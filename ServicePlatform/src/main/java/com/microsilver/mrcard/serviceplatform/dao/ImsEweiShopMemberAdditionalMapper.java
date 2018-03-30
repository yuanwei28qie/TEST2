package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAdditional;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAdditionalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMemberAdditionalMapper {
    int countByExample(ImsEweiShopMemberAdditionalExample example);

    int deleteByExample(ImsEweiShopMemberAdditionalExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(ImsEweiShopMemberAdditional record);

    int insertSelective(ImsEweiShopMemberAdditional record);

    List<ImsEweiShopMemberAdditional> selectByExample(ImsEweiShopMemberAdditionalExample example);

    ImsEweiShopMemberAdditional selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberAdditional record, @Param("example") ImsEweiShopMemberAdditionalExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberAdditional record, @Param("example") ImsEweiShopMemberAdditionalExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberAdditional record);

    int updateByPrimaryKey(ImsEweiShopMemberAdditional record);
}