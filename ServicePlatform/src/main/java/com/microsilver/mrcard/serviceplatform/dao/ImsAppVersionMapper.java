package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsAppVersion;
import com.microsilver.mrcard.serviceplatform.model.ImsAppVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsAppVersionMapper {
    int countByExample(ImsAppVersionExample example);

    int deleteByExample(ImsAppVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsAppVersion record);

    int insertSelective(ImsAppVersion record);

    List<ImsAppVersion> selectByExample(ImsAppVersionExample example);

    ImsAppVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsAppVersion record, @Param("example") ImsAppVersionExample example);

    int updateByExample(@Param("record") ImsAppVersion record, @Param("example") ImsAppVersionExample example);

    int updateByPrimaryKeySelective(ImsAppVersion record);

    int updateByPrimaryKey(ImsAppVersion record);
}