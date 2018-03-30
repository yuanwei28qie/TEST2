package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.dto.ActivityGoodsDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopActivityGoodsMapper {
    int countByExample(ImsEweiShopActivityGoodsExample example);

    int deleteByExample(ImsEweiShopActivityGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopActivityGoods record);

    int insertSelective(ImsEweiShopActivityGoods record);

    List<ImsEweiShopActivityGoods> selectByExample(ImsEweiShopActivityGoodsExample example);

    ImsEweiShopActivityGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopActivityGoods record, @Param("example") ImsEweiShopActivityGoodsExample example);

    int updateByExample(@Param("record") ImsEweiShopActivityGoods record, @Param("example") ImsEweiShopActivityGoodsExample example);

    int updateByPrimaryKeySelective(ImsEweiShopActivityGoods record);

    int updateByPrimaryKey(ImsEweiShopActivityGoods record);

	List<ActivityGoodsDto> selectActivityGoodsDetails(ImsEweiShopActivityGoodsExample example);
}