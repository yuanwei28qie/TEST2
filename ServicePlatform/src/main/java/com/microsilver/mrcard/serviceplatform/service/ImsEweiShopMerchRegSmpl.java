package com.microsilver.mrcard.serviceplatform.service;

import org.springframework.stereotype.Service;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMerchRegSmpl
 * @Description 商家资料录入，商家员工资料录入
 * @Author Jade
 * @Version 2017/11/7
 * @Copyright Micro Silver
 */

@Service
public class ImsEweiShopMerchRegSmpl {

    /**
     * 资料录入-商户（账号必需是会员）
     *      检查商家是否已经入住
     *          ImsEweiShopMerchUser
     *                  已提交审核
     *          ImsEweiShopMerchReg
     * 资料录入-员工（账号必需是会员）
     *      检查员工是否已经存在
     *      录入员工身份-角色-权限
     * @return
     */
    public boolean merchInfoInput(){
        return false;
    }

}
