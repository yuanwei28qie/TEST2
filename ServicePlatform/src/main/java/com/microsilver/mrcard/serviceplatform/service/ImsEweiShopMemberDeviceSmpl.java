package com.microsilver.mrcard.serviceplatform.service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMemberDeviceMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberDevice;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberDeviceExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jade on 2017/8/11.
 * 设备信息收集
 */
@Service
public class ImsEweiShopMemberDeviceSmpl {

    @Resource
    ImsEweiShopMemberDeviceMapper deviceMapper;

    @Transactional
    public boolean synchronizeMemberDeviceInfo(ImsEweiShopMemberDevice device){
        ImsEweiShopMemberDevice devInfo =  getMemberDevice(device.getMemberId(),device.getMerchId(),device.getIdentity(),device.getAppName());
        device.setCreateTime((int) (System.currentTimeMillis()/1000));
        int num;
        if(null == devInfo)
           num = deviceMapper.insert(device);
        else {
            device.setId(devInfo.getId());
            num = deviceMapper.updateByPrimaryKeySelective(device);
        }
        return num > 0?true:false;
    }

    public ImsEweiShopMemberDevice getMemberDevice(long memberId,long merchId,byte identity,byte appName){
        ImsEweiShopMemberDevice device = null;
        ImsEweiShopMemberDeviceExample example = new ImsEweiShopMemberDeviceExample();
        example.createCriteria()
                .andMemberIdEqualTo(memberId)
                .andMerchIdEqualTo(merchId)
                .andIdentityEqualTo(identity)
                .andAppNameEqualTo(appName);
        List<ImsEweiShopMemberDevice> deviceList = deviceMapper.selectByExample(example);
        if(deviceList != null && deviceList.size() > 0)
            device = deviceList.get(0);
        return device;
    }

}
