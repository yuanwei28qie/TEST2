package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollection;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMemberCollectionMapper {
    int countByExample(ImsEweiShopMemberCollectionExample example);

    int deleteByExample(ImsEweiShopMemberCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopMemberCollection record);

    int insertSelective(ImsEweiShopMemberCollection record);

    List<ImsEweiShopMemberCollection> selectByExample(ImsEweiShopMemberCollectionExample example);

    ImsEweiShopMemberCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberCollection record, @Param("example") ImsEweiShopMemberCollectionExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberCollection record, @Param("example") ImsEweiShopMemberCollectionExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberCollection record);

    int updateByPrimaryKey(ImsEweiShopMemberCollection record);
}