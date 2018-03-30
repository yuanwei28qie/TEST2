package com.microsilver.mrcard.serviceplatform.service;

import com.microsilver.mrcard.serviceplatform.dao.ImsCrowdsourcingDispatchMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingDispatch;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingDispatchExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.ImsCrowdsourcingDispatchSmpl
 * @Description 运费配置   根据区域编号查询运费，有则返回当前结果，没有则返回默认统一配置 区域编号=0
 * @Author Jade
 * @Version 2017/9/1
 * @Copyright Micro Silver
 */
@Service
public class ImsCrowdsourcingDispatchSmpl {

    @Resource
    ImsCrowdsourcingDispatchMapper imsCrowdsourcingDispatchMapper;

    /**
     * areaCode 区域编码(区县级)
     * type 白天:1,晚上:2
     * @param areaCode
     * @param currentTime  到小时
     * @return
     */
    public ImsCrowdsourcingDispatch getCurrentDispatch(Long areaCode,Short currentTime){
        List<ImsCrowdsourcingDispatch> areaDispatch = selectDispatch(areaCode);
        if(null == areaDispatch || areaDispatch.isEmpty()){
            areaDispatch = selectDispatch(0L);
        }
        StringBuffer remark = new StringBuffer("");
        ImsCrowdsourcingDispatch result = new ImsCrowdsourcingDispatch();
        for(ImsCrowdsourcingDispatch dispatch : areaDispatch){
            if(1 == dispatch.getType()){
                remark.append(dispatch.getEndTime()+"之前下单费用为"+dispatch.getPrice()+"元\n");
            }else{
                remark.append(dispatch.getBeginTime()+"之后下单费用为"+dispatch.getPrice()+"元");
            }
            if(currentTime >= dispatch.getBeginTime() && currentTime < dispatch.getEndTime()){
               if(1 == dispatch.getType()){
                   result =dispatch;
               }
            }else if( currentTime >= dispatch.getBeginTime() || currentTime < dispatch.getEndTime()){
                if(2 == dispatch.getType()){
                    result = dispatch;
                }
            }
        }
        if(!"".equals(remark)) {
            result.setRemark(remark.toString());
        }
        return result;
    }

    private List<ImsCrowdsourcingDispatch> selectDispatch(Long areaCode) {
        ImsCrowdsourcingDispatchExample example = new ImsCrowdsourcingDispatchExample();
        ImsCrowdsourcingDispatchExample.Criteria criteria = example.createCriteria();
        criteria .andAreaCodeEqualTo(areaCode);
        return imsCrowdsourcingDispatchMapper.selectByExample(example);
    }

}
