package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.dto.EffectiveDistanceDto;
import com.microsilver.mrcard.serviceplatform.dto.IndexKnightResult;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditional;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditionalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMemberIdentityAdditionalMapper {
    int countByExample(ImsEweiShopMemberIdentityAdditionalExample example);

    int deleteByExample(ImsEweiShopMemberIdentityAdditionalExample example);

    int deleteByPrimaryKey(Long idttId);

    int insert(ImsEweiShopMemberIdentityAdditional record);

    int insertSelective(ImsEweiShopMemberIdentityAdditional record);

    List<ImsEweiShopMemberIdentityAdditional> selectByExample(ImsEweiShopMemberIdentityAdditionalExample example);

    List<IndexKnightResult> selectByConditionExample(EffectiveDistanceDto example);

    ImsEweiShopMemberIdentityAdditional selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberIdentityAdditional record, @Param("example") ImsEweiShopMemberIdentityAdditionalExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberIdentityAdditional record, @Param("example") ImsEweiShopMemberIdentityAdditionalExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberIdentityAdditional record);

    int updateByPrimaryKey(ImsEweiShopMemberIdentityAdditional record);
}