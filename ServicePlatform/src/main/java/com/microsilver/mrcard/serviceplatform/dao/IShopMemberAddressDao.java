package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddress;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IShopMemberAddressDao {
    int countByExample(ImsEweiShopMemberAddressExample example);

    int deleteByExample(ImsEweiShopMemberAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopMemberAddress record);

    int insertSelective(ImsEweiShopMemberAddress record);

    List<ImsEweiShopMemberAddress> selectByExample(ImsEweiShopMemberAddressExample example);

    ImsEweiShopMemberAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberAddress record, @Param("example") ImsEweiShopMemberAddressExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberAddress record, @Param("example") ImsEweiShopMemberAddressExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberAddress record);

    int updateByPrimaryKey(ImsEweiShopMemberAddress record);
}