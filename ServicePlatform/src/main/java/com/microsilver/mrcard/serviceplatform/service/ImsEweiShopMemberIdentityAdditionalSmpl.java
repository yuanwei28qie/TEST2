package com.microsilver.mrcard.serviceplatform.service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMemberIdentityAdditionalMapper;
import com.microsilver.mrcard.serviceplatform.dto.EffectiveDistanceDto;
import com.microsilver.mrcard.serviceplatform.dto.IndexKnightResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMemberIdentityAdditionalSmpl
 * @Description 身份附加信息表
 * @Author Jade
 * @Version 2017/8/28
 * @Copyright Micro Silver
 */

@Service
public class ImsEweiShopMemberIdentityAdditionalSmpl {

    @Resource
    ImsEweiShopMemberIdentityAdditionalMapper shopMemberIdentityAdditionalMapper;

    public List<IndexKnightResult> getIndexKnight(EffectiveDistanceDto distanceDto){
        return shopMemberIdentityAdditionalMapper.selectByConditionExample(distanceDto);
    }
}
