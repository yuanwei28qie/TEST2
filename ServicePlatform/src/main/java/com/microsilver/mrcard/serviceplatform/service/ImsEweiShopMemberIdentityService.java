package com.microsilver.mrcard.serviceplatform.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.IMemberIdentityDao;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityExample;

@Service
public class ImsEweiShopMemberIdentityService {
	@Resource
	IMemberIdentityDao identityDao;
	
	/**
	 * 根据memberid获取骑士身份详情
	 * @param memberId
	 * @return
	 */
    public List<ImsEweiShopMemberIdentity> getShopMemberIdentity(Long memberId){
    	ImsEweiShopMemberIdentityExample example = new ImsEweiShopMemberIdentityExample();
    	example.createCriteria().andMemberidEqualTo(memberId).andIdentityEqualTo((byte)13);
    	List<ImsEweiShopMemberIdentity> identityList = identityDao.selectByExample(example);
    	return identityList;
    }

    public List<ImsEweiShopMemberIdentity> getShopMemberIdentityList(Long memberId){
    	ImsEweiShopMemberIdentityExample example = new ImsEweiShopMemberIdentityExample();
    	example.createCriteria().andMemberidEqualTo(memberId);
    	List<ImsEweiShopMemberIdentity> identityList = identityDao.selectByExample(example);
    	return identityList;
    }

	public int addMemberIdentity(ImsEweiShopMemberIdentity record) {
		return identityDao.insertSelective(record);
	}

	/**
	 * 员工身份改变
	 * 		1，启用
	 * 	    2，禁用
	 * @param merchId
	 * @param memberId
	 * @param status
	 * @return
	 */
	public boolean changeMemberIdentity(long merchId,long memberId,int status) {
		ImsEweiShopMemberIdentityExample example = new ImsEweiShopMemberIdentityExample();
		example.createCriteria().andMemberidEqualTo(memberId).andMerchidEqualTo(merchId).andIdentityEqualTo((byte)14);
		List<ImsEweiShopMemberIdentity> list = identityDao.selectByExample(example);
		list.forEach((idt)->{
			idt.setStatus((byte)status);
			identityDao.updateByPrimaryKeySelective(idt);
		});
		return true;
	}

	/**
	 * 获取骑士信息
	 * @param knightId
	 * @return
	 */
	public ImsEweiShopMemberIdentity getImsEweiShopMemberIdentity(Long knightId) {
		ImsEweiShopMemberIdentity merchIdentity = null;
		List<ImsEweiShopMemberIdentity> merchIdentityList = null;
		ImsEweiShopMemberIdentityExample identityExample = new ImsEweiShopMemberIdentityExample();
		identityExample.createCriteria().andMemberidEqualTo(knightId).andMerchidEqualTo(0L);

		merchIdentityList = identityDao.selectByExample(identityExample);
		if(null != merchIdentityList && !merchIdentityList.isEmpty()){
			merchIdentity = merchIdentityList.get(0);
		}
		return merchIdentity;
	}

	/**
	 * 	// 全国 省级 市级 县级
	 * 四种身份的，可以直接在ims_ewei_shop_member_identity表中查找到，通过parent_id查找上级
	 * @param parentId
	 * @return
	 */
	public List<ImsEweiShopMemberIdentity> parentProxyIdentity(long parentId ,List<ImsEweiShopMemberIdentity> identityList){
		ImsEweiShopMemberIdentity identity = this.identityDao.selectByPrimaryKey(parentId);
		identityList.add(0,identity);
		if(null != identity && identity.getParentId() != 0){
			return parentProxyIdentity(identity.getParentId(),identityList);
		}
		return identityList;
	}

	/** 字典定义
	 1	identity	卡先生商户	1
	 2	identity	卡先生全国代理商	2
	 3	identity	卡先生省级代理商	3
	 4	identity	卡先生市级代理商	4
	 5	identity	卡先生县级代理商	5
	 6	identity	卡先生勇士	6
	 7	identity	卡先生合伙人	7

	 10	identity	超级订商户	21
	 11	identity	超级订全国代理商	22
	 12	identity	超级订省级代理商	23
	 13	identity	超级订市级代理商	24
	 14	identity	超级订县级代理商	25
	 50	identity	超级订勇士(伪代)	26

	 57	identity	小飞侠全国代理商	32
	 58	identity	小飞侠省级代理商	33
	 59	identity	小飞侠市级代理商	34
	 60	identity	小飞侠县级代理商	35
	 61	identity	小飞侠骑手	13
	 */
	public Long [] parentIdentityArray(long memberId,long merchId,byte identity ){
		ImsEweiShopMemberIdentityExample example = new ImsEweiShopMemberIdentityExample();
		example.createCriteria().andMemberidEqualTo(memberId).andMerchidEqualTo(merchId).andIdentityEqualTo(identity);
		ImsEweiShopMemberIdentity member = identityDao.selectByExample(example).get(0);
		List<ImsEweiShopMemberIdentity> parentProxy = new LinkedList<>();
		parentProxyIdentity(member.getParentId(),parentProxy);
		Long [] parent = new Long[]{0L,0L,0L};
		parentProxy.forEach((pxy)->{
			switch (pxy.getIdentity()){
				case 3://省
				case 23:
				case 33:
					parent[0] = pxy.getId();
					break;
				case 4://市
				case 24:
				case 34:
					parent[1] = pxy.getId();
					break;
				case 5://县
				case 25:
				case 35:
					parent[2] = pxy.getId();
					break;
				default:
			}
		});
		return parent;
	}
}
