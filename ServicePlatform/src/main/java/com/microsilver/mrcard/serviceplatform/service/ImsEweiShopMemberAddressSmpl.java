package com.microsilver.mrcard.serviceplatform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.serviceplatform.dao.IShopMemberAddressDao;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddress;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddressExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMemberAddressSmpl
 * @Description 用户收货地址
 * @Author Jade
 * @Version 2017/8/28
 * @Copyright Micro Silver
 */
@Service
public class ImsEweiShopMemberAddressSmpl {

    @Resource
    IShopMemberAddressDao  shopMemberAddressDao;

    /**
     * 保存收货地址
     * @param address
     */
    public boolean insertAddress(ImsEweiShopMemberAddress address){
        //设置当前为最新默认地址
        address.setIsdefault(true);
        //变更原来的地址为非默认地址
        List<ImsEweiShopMemberAddress> list = queryAll(address.getMemberId());
        list.forEach((sma)->{
            sma.setIsdefault(false);
            updateAddress(sma);
        });
        int num =  shopMemberAddressDao.insertSelective(address);
        return num>0?true:false;
    }

    /**
     * 修改收货地址
     * @param address
     * @return
     */
    public boolean updateAddress(ImsEweiShopMemberAddress address){
        int num =  shopMemberAddressDao.updateByPrimaryKeySelective(address);
        return num>0?true:false;
    }

    /**
     * 查询收货地址
     * @param memberId
     * @return
     */
    public PageInfo<ImsEweiShopMemberAddress> queryAllAddress(Long memberId,List<Integer> idList , int pageNum , int pageSize){
        ImsEweiShopMemberAddressExample example = new ImsEweiShopMemberAddressExample();
        example.createCriteria().andMemberIdEqualTo(memberId).andIdIn(idList);
        example.setOrderByClause(" id desc ");
        example.setDistinct(true);
        Page<ImsEweiShopMemberAddress> page = PageHelper.startPage(pageNum,pageSize).doSelectPage(()->shopMemberAddressDao.selectByExample(example));
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    /**
     * 查询默认收货地址
     * @param memberId
     * @return
     */
    public ImsEweiShopMemberAddress queryDefaultAddress(Long memberId){
        ImsEweiShopMemberAddressExample example = new ImsEweiShopMemberAddressExample();
        example.createCriteria().andMemberIdEqualTo(memberId).andIsdefaultEqualTo(true);
        List<ImsEweiShopMemberAddress> list = shopMemberAddressDao.selectByExample(example);
        if(null != list && !list.isEmpty()) {
            return list.get(0);
        }else{

            List<ImsEweiShopMemberAddress> all = queryAll(memberId);
            if(null != all && !all.isEmpty())
                return all.get(0);
            else
                return null;
        }
    }

    public ImsEweiShopMemberAddress queryByAddressId(Integer addressId){
        return shopMemberAddressDao.selectByPrimaryKey(addressId);
    }
    public List<ImsEweiShopMemberAddress> queryAddressByCollection(Long memberId,List<Integer> addressIdList){
        ImsEweiShopMemberAddressExample example = new ImsEweiShopMemberAddressExample();
        example.createCriteria().andMemberIdEqualTo(memberId).andIdIn(addressIdList);
        List<ImsEweiShopMemberAddress> list = shopMemberAddressDao.selectByExample(example);
        if(null != list && !list.isEmpty()) {
            return list;
        }
        return null;
    }

    private List<ImsEweiShopMemberAddress> queryAll(Long memberId){
        ImsEweiShopMemberAddressExample example = new ImsEweiShopMemberAddressExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        example.setOrderByClause(" id desc ");
        return shopMemberAddressDao.selectByExample(example);
    }



}
