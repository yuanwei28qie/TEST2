package com.microsilver.mrcard.serviceplatform.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.CryptoTools;
import com.microsilver.mrcard.mq.MemberMQ;
import com.microsilver.mrcard.serviceplatform.common.RongCloud;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.IMemberDao;
import com.microsilver.mrcard.serviceplatform.dao.IMemberIdentityDao;
import com.microsilver.mrcard.serviceplatform.dao.ImsUserRecommendMapper;
import com.microsilver.mrcard.serviceplatform.dto.IdentityDto;
import com.microsilver.mrcard.serviceplatform.dto.MemberDto;
import com.microsilver.mrcard.serviceplatform.dto.StaffInformation;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchAccount;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.mq.MQSendMsgHelper;


/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.service.MemberSmpl
 * @Description
 * 
 * @Author bruce
 * @Version 2017年7月3日 上午11:14:34
 * @Copyright Micro Silver
 *
 */
@Service
public class MemberSmpl {
	private final static Logger logger = LoggerFactory.getLogger(MemberSmpl.class);
	@Autowired
	IMemberDao iMemberDao;
	@Autowired
	IMemberIdentityDao iMemberIdentityDao;
	@Autowired
	ImsUserRecommendMapper iUserRecommendMapper;
	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;
	
	/**
	 * 无推荐人注册
	 * @param newMember
	 * @return
	 * @throws Exception
	 */
	public Long register(ImsEweiShopMember newMember) throws Exception {
		ImsEweiShopMember member = iMemberDao.selectByMobile(newMember.getMobile());
		if (member != null) {
			throw new Exception(newMember.getMobile()+" 手机号已经存在");
		}
		if(newMember.getPwd()!=null&&!newMember.getPwd().equals("")){
			newMember.setSalt(Utils.getRandomString(16));
			newMember.setPwd(CryptoTools.EncoderByMd5(newMember.getPwd() + newMember.getSalt()));
		}
		iMemberDao.insert(newMember);
		Long memberId = newMember.getId();
		return memberId;
	}
	/**
	 * 有推荐人注册
	 * @param newMember
	 * @param level2ParentId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Long register(ImsEweiShopMember newMember,Long level2ParentId) throws Exception {
		/*ImsEweiShopMember member = iMemberDao.selectByMobile(newMember.getMobile());
		if (member != null) {
			throw new Exception(newMember.getMobile()+" 手机号已经存在");
		}*/
		if(newMember.getPwd()!=null&&!newMember.getPwd().equals("")){
			newMember.setSalt(Utils.getRandomString(16));
			newMember.setPwd(CryptoTools.EncoderByMd5(newMember.getPwd() + newMember.getSalt()));
		}
		iMemberDao.insert(newMember);
		Long memberId = newMember.getId();
		if(newMember.getReferee()!=null) {
			sendMemberRegMq(newMember,level2ParentId);
		}
		return memberId;
	}
	/**
	 * 发送会员注册消息队列
	 * @param newMember
	 * @param level2ParentId
	 */
	private void sendMemberRegMq(ImsEweiShopMember newMember,Long level2ParentId) {
		ImsUserRecommend recommend = null;
		recommend = iUserRecommendMapper.selectByPrimaryKey(newMember.getId());
		if(recommend!=null) {
			logger.info("用户{}已经有推荐人{},不再发送注册消息",newMember.getId(),newMember.getReferee());
			return;
		}
		recommend = new ImsUserRecommend();
		recommend.setMemberId(newMember.getId());
		recommend.setVipType((byte)0);
		recommend.setLevel1ParentId(newMember.getReferee());
		recommend.setLevel2ParentId(level2ParentId);
		recommend.setRootId(newMember.getReferee());
		ImsUserRecommend userRecommend = iUserRecommendMapper.selectByPrimaryKey(newMember.getReferee());
		MemberMQ memberMQ = null;
		if(userRecommend!=null) {
			recommend.setRootId(userRecommend.getRootId());
			if(userRecommend.getVipType()>0) {
				//发送消息队列
				memberMQ =new MemberMQ();
				memberMQ.setRefereeMemberId(newMember.getReferee());
				memberMQ.setRegMemberId(newMember.getId());
				memberMQ.setType(1);
			}
		}
		iUserRecommendMapper.insert(recommend);
		if(memberMQ!=null) {
			mqsendMsgHelper.sendJSONMemberMQ(memberMQ);
			logger.info("VIP用户推荐新用户注册：{}",JSON.toJSONString(memberMQ));
		}
	}

	public ImsEweiShopMember selectByMobile(String mobile) {
		return iMemberDao.selectByMobile(mobile);
	}
	public MemberDto selectDtoByMobile(String mobile,Integer identity){
		MemberDto memDto = null;
		try{
			memDto = iMemberDao.selectDtoByMobile(mobile);
			if(memDto==null) {
				logger.info("没有查询到手机号为:{}的用户",mobile);
				return null;
			}
			if(identity==null||memDto.getIdttList()==null||memDto.getIdttList().size()==0){
				//会员身份
				if(memDto.getRongcloudToken()==null||memDto.getRongcloudToken().equals("")){
					String rongToken = updateRongcloudToken(memDto.getId(),memDto.getNickname(),Utils.getImageURL(memDto.getAvatar()),0);
					memDto.setRongcloudToken(rongToken);
				}
			}
			if(identity==null||identity>0){
				memDto.setIdttList(iMemberIdentityDao.selectMemIdttDto(memDto.getId()));
				//有其他身份
				if(memDto.getCheckStatus()==2){
					for(IdentityDto idtt:memDto.getIdttList()){
						if(idtt.getIdentity()==13){
							if(idtt.getRongcloudToken()==null||idtt.getRongcloudToken().equals("")){
								String rongToken = updateRongcloudToken(memDto.getId(),memDto.getNickname(),Utils.getImageURL(memDto.getAvatar()),13);
								idtt.setRongcloudToken(rongToken);
							}
							break;
						}
					}
				}
			}
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			logger.error("selectDtoByMobile error:{}",ex.getMessage());
		}
		return memDto;
	}

	public ImsEweiShopMember selectMemberById(Long id) {
		return iMemberDao.selectByPrimaryKey(id);
	}

	@Transactional
	public void updatePassword(ImsEweiShopMember record) throws Exception{
		//检查是否是商家,如果是需要同时更新商家pwd和salt
		ImsEweiShopMerchAccount imsEweiShopMerchAccount = checkIsShopMerchByMemberId(record.getId());
		if(imsEweiShopMerchAccount!=null){
			imsEweiShopMerchAccount.setPwd(record.getPwd());
			imsEweiShopMerchAccount.setSalt(record.getSalt());
		}
		iMemberDao.updatePassword(record);
	}	
	
	/**
	 * 通过memberId查看该账号是否是商家
	 * @param memberId
	 * @return
	 */
	public ImsEweiShopMerchAccount checkIsShopMerchByMemberId(Long memberId) {
		ImsEweiShopMerchAccount imsEweiShopMerchAccount = iMemberDao.selectShopMerchByMemberId(memberId);
		return imsEweiShopMerchAccount;
	}

	public void updateUserInfo(ImsEweiShopMember member) {
		
		iMemberDao.updateUserInfo(member);	
	}
	/**
	 * 微信会员注册/绑定手机号
	 * @param newMember
	 */
	@Transactional
	public void wxMemberRegister(ImsEweiShopMember newMember,Long level2ParentId,ImsEweiShopMember wxMember) {
		if(wxMember!=null&&!wxMember.getOpenid().equals("")) {
			newMember.setOpenid(wxMember.getOpenid());
			iMemberDao.deleteByPrimaryKey(wxMember.getId());
			logger.info("删除微信重复用户:{}",wxMember.getId());
		}
		updateByPrimaryKeySelective(newMember);
		if(newMember.getReferee()!=null&&newMember.getReferee().longValue()>0) {
			sendMemberRegMq(newMember,level2ParentId);
		}
	}
	
	public void updateByPrimaryKeySelective(ImsEweiShopMember newMember) {
		if(newMember.getPwd()!=null&&!newMember.getPwd().equals("")){
			newMember.setSalt(Utils.getRandomString(16));
			newMember.setPwd(CryptoTools.EncoderByMd5(newMember.getPwd() + newMember.getSalt()));
		}
		iMemberDao.updateByPrimaryKeySelective(newMember);
	}
	/**
	 * 更新用户的rongcloudToken
	 * @param memberId
	 * @param name
	 * @param avatar
	 * @param identity
	 * @return
	 */
	public String updateRongcloudToken(long memberId,String name,String avatar,int identity){
		String rongToken = RongCloud.getToken(String.valueOf(memberId)+String.valueOf(identity), name,avatar);
		if(rongToken==null||rongToken.equals("")) {
			logger.info("用户:{}未取到融云token",memberId);
			return rongToken;
		}
		if(identity==0){
			ImsEweiShopMember shopMember = new ImsEweiShopMember();
			shopMember.setId(memberId);
			shopMember.setRongcloudToken(rongToken);
			iMemberDao.updateUserInfo(shopMember);
			
		}else if(identity==13){
			ImsEweiShopMemberIdentity memIdtt = new ImsEweiShopMemberIdentity();
			memIdtt.setRongcloudToken(rongToken);
			ImsEweiShopMemberIdentityExample example = new ImsEweiShopMemberIdentityExample();
			example.createCriteria().andMemberidEqualTo(memberId).andMerchidEqualTo(0L).andIdentityEqualTo((byte)identity);
			iMemberIdentityDao.updateByExampleSelective(memIdtt, example);
		}
		return rongToken;
	}
	
	public int updateMobile(Long id,String mobile) {
		if(id==null||mobile==null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopMember member = new ImsEweiShopMember();
		member.setId(id);
		member.setMobile(mobile);
		return iMemberDao.updateMobile(member);
	}

	/**
	 * 通过商户编码查询员工
	 * @param merchId
	 * @return
	 */
	public List<StaffInformation> selectMemberByMerch(Long merchId){
		List<StaffInformation> list  = iMemberDao.selectByMerchId(merchId);
		return list;
	}
	/**
	 * 查询推荐用于
	 * @param refereeMobile
	 * @return
	 * @throws Exception
	 */
	public ImsEweiShopMember getRecommendMember(String refereeMobile) throws Exception {
		ImsEweiShopMember refMember  = null;
		if(refereeMobile.length()==11) {
			refMember = iMemberDao.selectByMobile(refereeMobile);
		}else {
			refMember = iMemberDao.selectByPrimaryKey(Long.valueOf(refereeMobile));
		}
		if(refMember==null) {
			logger.info("注册新用户,有推荐用户，但没有找到推荐人:{}",refereeMobile);
			throw new Exception("没有找到推荐人，请重新确认！");
		}
		return refMember;
	}
}
