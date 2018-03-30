package com.microsilver.mrcard.serviceplatform.service;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.MemberDto;
import com.microsilver.mrcard.serviceplatform.dto.StaffInformation;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.StaffInformationSmpl
 * @Description 酒店员工操作
 * @Author Jade
 * @Version 2017/11/21
 * @Copyright Micro Silver
 */
@Service
public class StaffInformationSmpl {

    private final static Logger logger = LoggerFactory.getLogger(StaffInformationSmpl.class);

    @Autowired
    private MemberSmpl memberSmpl;
    @Autowired
    private ImsEweiShopMemberIdentityService identityService;
    @Autowired
    SysResourceServiceSmpl sysResourceServiceSmpl;


    /**
     * 新增员工
     * 1 检查是否是会员shop_member，非会员需要向会员表进行注册
     * 2 添加员工身份shop_member_identiy
     * 3，为员工授权 ims_sys_group_resource
     * @param staffInfo
     * @return
     */
    @Transactional
    public MemberDto staffInformationAdd(StaffInformation staffInfo) throws Exception {
        ImsEweiShopMember oldMember = memberSmpl.selectByMobile(staffInfo.getMobile());
        ImsEweiShopMember newMember = new ImsEweiShopMember();
        logger.info("添加酒店员工："+ JSON.toJSONString(staffInfo));
        //1 检查是否是会员shop_member，非会员需要向会员表进行注册
        if(!Objects.nonNull(oldMember)) {
            newMember.setMobile(staffInfo.getMobile());
            newMember.setRealname(staffInfo.getRealname());
            //default pwd
            newMember.setPwd("111111");
            String nickname = staffInfo.getMobile().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            newMember.setNickname(nickname);

            newMember.setCreatetime(Utils.getCurrentTime());
            try {
                memberSmpl.register(newMember);
                oldMember = newMember;
            } catch (Exception e) {

                logger.error("添加酒店员工信息：",e.getMessage());
                e.printStackTrace();
            }
        }else{
            newMember = oldMember;
        }
        staffInfo.setMemberId(oldMember.getId());
        //2 添加员工身份shop_member_identiy

        //check
        List<ImsEweiShopMemberIdentity> identityList = identityService.getShopMemberIdentityList(newMember.getId());
        for (ImsEweiShopMemberIdentity identity : identityList){
            if(identity.getIdentity() == (byte)21){
                logger.warn("员工已有身份:"+JSON.toJSONString(identity));
                throw new Exception("您已经是酒店人员");
            }else if (identity.getIdentity() == (byte)14){
                logger.warn("员工已有身份:"+JSON.toJSONString(identity));
                throw new Exception("您已经是酒店员工");
            }
        }
        //add
        ImsEweiShopMemberIdentity identity = new ImsEweiShopMemberIdentity();
        identity.setMemberId(newMember.getId());
        identity.setName(newMember.getRealname());
        identity.setIdentity((byte)14);
        identity.setMerchId(staffInfo.getMerchId());
//		identity.setParentId(0);
        identity.setCreatetime(Utils.getCurrentTime());
        identity.setStatus((byte)1);
        identityService.addMemberIdentity(identity);
        //3，为员工授权 ims_sys_group_resource
        sysResourceServiceSmpl.addstaffResource(staffInfo.getMemberId(),staffInfo.getResoureGroupId());

        MemberDto memDto = new MemberDto();
        memDto.setId(newMember.getId());
        memDto.setNickname(newMember.getNickname());
        memDto.setRongcloudToken(newMember.getRongcloudToken());
        memDto.setCheckStatus((byte)-1);
        memDto.setIsblack(0);
        memDto.setPwd(newMember.getPwd());
        return memDto;
    }

    /**
     * 查询员工
     * @param merchInfo
     * @return
     */
    public List<StaffInformation> staffInformationList(Long merchInfo){
        List<StaffInformation> merchList = memberSmpl.selectMemberByMerch(merchInfo);
        return merchList;
    }

    /**
     * 员工详情
     * @param memberId
     * @return
     */
    public MemberDto staffInformation(Long memberId){
        ImsEweiShopMember shopMember = memberSmpl.selectMemberById(memberId);
        MemberDto memDto = new MemberDto();
        memDto.setId(shopMember.getId());
        memDto.setNickname(shopMember.getNickname());
        memDto.setRongcloudToken(shopMember.getRongcloudToken());
//        memDto.setCheckStatus((byte)-1);
        memDto.setIsblack(shopMember.getIsblack());
        memDto.setPwd(shopMember.getPwd());
        return memDto;
    }

    /**
     * 移除员工
     *      -只删除员工身份以及权限
     *      恢复员工会员
     * @param merchId
     * @param memberId
     * @return
     */
    @Transactional
    public ImsEweiShopMember staffInformationDelete(Long merchId,Long memberId){
        ImsEweiShopMember shopMember = memberSmpl.selectMemberById(memberId);
        if(Objects.nonNull(shopMember)) {
            identityService.changeMemberIdentity(merchId,memberId,2);
            sysResourceServiceSmpl.delStaffResource(memberId);
        }
        return shopMember;
    }
}
