package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchReg;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchRegExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchRegWithBLOBs;
import feign.Param;

import java.util.List;

public interface IMerchRegDao {

    ImsEweiShopMerchReg selectByMemberId(Long id);

    int deleteByPrimaryKey(Integer id);

    int countByExample(ImsEweiShopMerchRegExample example);

    int deleteByExample(ImsEweiShopMerchRegExample example);

    int insert(ImsEweiShopMerchRegWithBLOBs record);

    int insertSelective(ImsEweiShopMerchRegWithBLOBs record);

    List<ImsEweiShopMerchRegWithBLOBs> selectByExampleWithBLOBs(ImsEweiShopMerchRegExample example);

    List<ImsEweiShopMerchReg> selectByExample(ImsEweiShopMerchRegExample example);

    ImsEweiShopMerchRegWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopMerchRegWithBLOBs record, @Param("example") ImsEweiShopMerchRegExample example);

    int updateByExampleWithBLOBs(@Param("record") ImsEweiShopMerchRegWithBLOBs record, @Param("example") ImsEweiShopMerchRegExample example);

    int updateByExample(@Param("record") ImsEweiShopMerchReg record, @Param("example") ImsEweiShopMerchRegExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMerchRegWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ImsEweiShopMerchRegWithBLOBs record);
}