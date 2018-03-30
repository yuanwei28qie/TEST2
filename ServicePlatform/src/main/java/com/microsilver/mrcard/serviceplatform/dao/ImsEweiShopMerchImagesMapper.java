package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImages;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMerchImagesMapper {
    int countByExample(ImsEweiShopMerchImagesExample example);

    int deleteByExample(ImsEweiShopMerchImagesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopMerchImages record);

    int insertSelective(ImsEweiShopMerchImages record);

    List<ImsEweiShopMerchImages> selectByExample(ImsEweiShopMerchImagesExample example);

    ImsEweiShopMerchImages selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopMerchImages record, @Param("example") ImsEweiShopMerchImagesExample example);

    int updateByExample(@Param("record") ImsEweiShopMerchImages record, @Param("example") ImsEweiShopMerchImagesExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMerchImages record);

    int updateByPrimaryKey(ImsEweiShopMerchImages record);
}