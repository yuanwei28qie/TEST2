package com.microsilver.mrcard.serviceplatform.dao;

import java.util.Map;

import com.microsilver.mrcard.serviceplatform.model.ImsCheckCode;

public interface ICheckCodeDao {
    int deleteByPrimaryKey(Long id);

    int insert(ImsCheckCode record);

    int insertSelective(ImsCheckCode record);

    ImsCheckCode selectByCheckCode(Map<String, Object> map);

    int updateByPrimaryKeySelective(ImsCheckCode record);

    int updateByPhone(ImsCheckCode record);
    
    int countByModel(ImsCheckCode record);
}