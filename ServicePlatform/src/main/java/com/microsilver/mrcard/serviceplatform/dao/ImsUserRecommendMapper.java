package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.dto.ImsUserRecommendDto;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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

	List<ImsUserRecommendDto> selectPartner(Long memberId);

	List<ImsUserRecommendDto> selectPartnerByExample(ImsUserRecommendExample example);
}