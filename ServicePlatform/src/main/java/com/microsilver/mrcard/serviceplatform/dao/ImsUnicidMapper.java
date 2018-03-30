package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsUnicid;
import com.microsilver.mrcard.serviceplatform.model.ImsUnicidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsUnicidMapper {
    int countByExample(ImsUnicidExample example);

    int deleteByExample(ImsUnicidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsUnicid record);

    int insertSelective(ImsUnicid record);

    List<ImsUnicid> selectByExample(ImsUnicidExample example);

    ImsUnicid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsUnicid record, @Param("example") ImsUnicidExample example);

    int updateByExample(@Param("record") ImsUnicid record, @Param("example") ImsUnicidExample example);

    int updateByPrimaryKeySelective(ImsUnicid record);

    int updateByPrimaryKey(ImsUnicid record);
}