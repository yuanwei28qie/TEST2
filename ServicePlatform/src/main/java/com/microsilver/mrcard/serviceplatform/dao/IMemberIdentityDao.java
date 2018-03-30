package com.microsilver.mrcard.serviceplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.serviceplatform.dto.BusinessIdentityDto;
import com.microsilver.mrcard.serviceplatform.dto.IdentityDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityExample;

public interface IMemberIdentityDao {

    int insert(ImsEweiShopMemberIdentity record);

    int insertSelective(ImsEweiShopMemberIdentity record);

    ImsEweiShopMemberIdentity selectByPrimaryKey(Long id);
    
    List<BusinessIdentityDto> selectDtoByMemberId(Long memberId);
    /**
     * 查询商业用户身份
     * @param recode
     * @return
     */
    List<BusinessIdentityDto> selectBusiIdttDto(ImsEweiShopMemberIdentity recode);
    /**
     * 查询普通用户身份
     * @param memberId
     * @return
     */
    List<IdentityDto> selectMemIdttDto(Long memberId);

    int updateByPrimaryKeySelective(ImsEweiShopMemberIdentity record);

    int updateByPrimaryKey(ImsEweiShopMemberIdentity record);
    /**
     * 查询雇员身份
     * @param memberId
     * @return
     */
    List<BusinessIdentityDto>  selectEmployeeByMemberId(Long memberId);

    int changeStatus(ImsEweiShopMemberIdentity identity);
    
    int countByExample(ImsEweiShopMemberIdentityExample example);

    int deleteByExample(ImsEweiShopMemberIdentityExample example);

    int deleteByPrimaryKey(Long id);

    List<ImsEweiShopMemberIdentity> selectByExample(ImsEweiShopMemberIdentityExample example);


    int updateByExampleSelective(@Param("record") ImsEweiShopMemberIdentity record, @Param("example") ImsEweiShopMemberIdentityExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberIdentity record, @Param("example") ImsEweiShopMemberIdentityExample example);


}