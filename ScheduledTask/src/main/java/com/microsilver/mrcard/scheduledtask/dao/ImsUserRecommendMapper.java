package com.microsilver.mrcard.scheduledtask.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommend;
import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommendExample;

public interface ImsUserRecommendMapper {
    int countByExample(ImsUserRecommendExample example);

    int deleteByExample(ImsUserRecommendExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(ImsUserRecommend record);

    int insertSelective(ImsUserRecommend record);

    List<ImsUserRecommend> selectByExample(ImsUserRecommendExample example);

    ImsUserRecommend selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") ImsUserRecommend record, @Param("example") ImsUserRecommendExample example);

    int updateByExample(@Param("record") ImsUserRecommend record, @Param("example") ImsUserRecommendExample example);

    int updateByPrimaryKeySelective(ImsUserRecommend record);

    int updateByPrimaryKey(ImsUserRecommend record);
}