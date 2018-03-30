package com.microsilver.mrcard.serviceplatform.service;

import com.microsilver.mrcard.serviceplatform.dao.ImsSysGroupMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsSysGroupResourceMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsSysResourcesMapper;
import com.microsilver.mrcard.serviceplatform.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.SysResourceServiceSmpl
 * @Description 用户权限相关
 * @Author Jade
 * @Version 2017/11/8
 * @Copyright Micro Silver
 */
@Service
public class SysResourceServiceSmpl {

    @Autowired
    ImsSysResourcesMapper resourcesMapper;//resource
    @Autowired
    ImsSysGroupMapper groupMapper;//resource group
    @Autowired
    ImsSysGroupResourceMapper groupResourceMapper;//user group

    /**
     * 添加权限
     * @param memberId
     * @param resourceId
     * @return
     */
    public boolean addstaffResource(Long memberId,Integer resourceId){
        ImsSysGroup sysGroup = groupMapper.selectByPrimaryKey(resourceId);
        if(Objects.nonNull(sysGroup)){
            ImsSysGroupResource gr = new ImsSysGroupResource();
            gr.setGroupId(resourceId);
            gr.setUid(memberId.intValue());
            int num = groupResourceMapper.insert(gr);
            return num > 0 ? true:false;
        }
        return false;
    }
    public ImsSysGroup getstaffResource(Integer memberId){
        ImsSysGroupResourceExample example = new ImsSysGroupResourceExample();
        example.createCriteria().andUidEqualTo(memberId);
        List<ImsSysGroupResource> sysGroup = groupResourceMapper.selectByExample(example);
        if(!sysGroup.isEmpty()){
            ImsSysGroup staffResource = groupMapper.selectByPrimaryKey(sysGroup.get(0).getGroupId());
            return staffResource;
        }
        return null;
    }

    public  List<ImsSysGroup> getSysGroup(Integer identity){
        ImsSysGroupExample example = new ImsSysGroupExample();
        example.createCriteria().andIdentityEqualTo(identity);
        List<ImsSysGroup> groupList = groupMapper.selectByExample(example);
        return groupList;
    }

    /**
     * 删除权限
     * @param memberId
     * @return
     */
    public boolean delStaffResource(Long memberId){
        ImsSysGroupResourceExample example = new ImsSysGroupResourceExample();
        ImsSysGroupResourceExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(memberId.intValue());
        List<ImsSysGroupResource> list = groupResourceMapper.selectByExample(example);
        if(!list.isEmpty()){
            ImsSysGroupResource gr = list.get(0);
            criteria.andUidEqualTo(gr.getGroupId());
        }
        int num = groupResourceMapper.deleteByExample(example);
        return num > 0 ? true:false;
    }
}
