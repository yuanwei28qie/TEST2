package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderComment;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopOrderCommentMapper {
    int countByExample(ImsEweiShopOrderCommentExample example);

    int deleteByExample(ImsEweiShopOrderCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopOrderComment record);

    int insertSelective(ImsEweiShopOrderComment record);

    List<ImsEweiShopOrderComment> selectByExample(ImsEweiShopOrderCommentExample example);

    ImsEweiShopOrderComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopOrderComment record, @Param("example") ImsEweiShopOrderCommentExample example);

    int updateByExample(@Param("record") ImsEweiShopOrderComment record, @Param("example") ImsEweiShopOrderCommentExample example);

    int updateByPrimaryKeySelective(ImsEweiShopOrderComment record);

    int updateByPrimaryKey(ImsEweiShopOrderComment record);
}