package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMemberCollectionMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollection;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollectionExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollectionExample.Criteria;

@Service
public class ImsEweiShopMemberCollectionSmpl {
	@Resource
	ImsEweiShopMemberCollectionMapper collectionMapper;
	
	public List<ImsEweiShopMemberCollection> selectByMemberId(Long memberId,Byte collecType){
    	ImsEweiShopMemberCollectionExample example = new ImsEweiShopMemberCollectionExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andMemberIdEqualTo(memberId);
    	criteria.andCollecTypeEqualTo(collecType);
    	example.setOrderByClause(" id desc ");
		Page<ImsEweiShopMemberCollection> page = PageHelper.startPage(1,20).doSelectPage(()->collectionMapper.selectByExample(example));
		PageInfo pageInfo = new PageInfo(page);
    	List<ImsEweiShopMemberCollection> collections = pageInfo.getList();
    	return  collections;
    }
	
	public Byte checkStatus(Long memberId,Integer merchId,Byte collecType){
		ImsEweiShopMemberCollectionExample example = new ImsEweiShopMemberCollectionExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andMemberIdEqualTo(memberId);
    	criteria.andCollecTypeEqualTo(collecType);
    	criteria.andCollecObjectIdEqualTo((long)merchId);
    	List<ImsEweiShopMemberCollection> collections = collectionMapper.selectByExample(example);
    	Byte isCollection =0;
    	 if(collections.size()!=0){
    		 isCollection=1;
    	 }
    	 return isCollection;
	}
/**
 * 收藏或取消收藏
 * @param memberId
 * @param merchId
 * @param status
 * @return
 */
	public int changeStatus(Long memberId,Integer merchId, Byte status,Byte collecType) {
		int code = 0;
		if(status==1){
	   		 ImsEweiShopMemberCollection collection = new ImsEweiShopMemberCollection();
	   		 collection.setMemberId(memberId);
	   		 collection.setCollecType(collecType);
	   		 collection.setIdentity((byte)0);
	   		 collection.setCollecObjectId((long)merchId);
			 code=collectionMapper.insertSelective(collection);
		}else{
	    	ImsEweiShopMemberCollectionExample example = new ImsEweiShopMemberCollectionExample();
	    	Criteria criteria = example.createCriteria();
	    	criteria.andMemberIdEqualTo(memberId);
	    	criteria.andCollecTypeEqualTo(collecType);
	    	criteria.andCollecObjectIdEqualTo((long)merchId);
	    	code=collectionMapper.deleteByExample(example);
		}
		return code;
	}
}
