package com.microsilver.mrcard.scheduledtask.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.common.Utils;
import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import com.microsilver.mrcard.scheduledtask.dao.ImsUserPanterOrderMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsUserRecommendMapper;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanterOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommend;
import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommendExample;

@Service
public class PanterOrderService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ImsUserPanterOrderMapper panterOrderMapper;
	@Autowired
	ImsUserRecommendMapper recommendMapper;

	// 分成结算
	@Autowired
	private IFinanceRemoteService financeRemoteService;

	/**
	 * 根据订单查询推荐用户信息
	 * @param orderId
	 * @return
	 */
	public ImsUserRecommend selectUserRecommendByOrder(long orderId) {
		ImsUserPanterOrder paterOrder = panterOrderMapper.selectByPrimaryKey(orderId);
		ImsUserRecommend userRecommend= recommendMapper.selectByPrimaryKey(paterOrder.getMemberId());
		if(userRecommend.getLevel1ParentId()>0) {
			ImsUserRecommend parentRecommend=recommendMapper.selectByPrimaryKey(userRecommend.getLevel1ParentId());
			if(parentRecommend==null||parentRecommend.getVipType()==0) {
				logger.info("合伙人订单：{},一级推荐人:{}不是合伙人或是VIP，一级推荐人不能分润",orderId,userRecommend.getLevel1ParentId());
				return null;
			}else {
				if(userRecommend.getLevel2ParentId()>0) {
					ImsUserRecommend level2Recommend = recommendMapper.selectByPrimaryKey(userRecommend.getLevel2ParentId());
					if(level2Recommend==null||level2Recommend.getVipType()==0) {
						logger.info("合伙人订单：{},二级推荐人:{}不是合伙人或是VIP，二级推荐人不能分润",orderId,userRecommend.getLevel2ParentId());
						userRecommend.setLevel2ParentId(0L);
					}
				}
			}
		}
		return userRecommend;
	}
	/**
	 * 更新推荐用户状态
	 * @param memberId
	 * @param isSettlement
	 */
	public void updateUserRecommend(long memberId,byte isSettlement) {
		ImsUserRecommend userRecommend = new ImsUserRecommend();
		userRecommend.setMemberId(memberId);
		userRecommend.setIsSettlement(isSettlement);
		recommendMapper.updateByPrimaryKeySelective(userRecommend);
		
	}
	/**
	 * 更新订单结算状态(已废弃)
	 * @param orderId
	 * @param status
	 */
	public void updateSettlementStatus(long orderId,byte status) {
		ImsUserPanterOrder panterOrder = new ImsUserPanterOrder();
		panterOrder.setId(orderId);
		panterOrder.setIsSettlement(status);
		panterOrderMapper.updateByPrimaryKeySelective(panterOrder);
	}
	/**
	 * 增加用户推荐用户订单
	 * @param memberId
	 * @return
	 */
	public Long addUserRecommendOrder(long memberId) {
		ImsUserPanterOrder panterOrder = new ImsUserPanterOrder();
		String orderSn = Utils.createOrderSn("PA");
		panterOrder.setMemberId(memberId);
		panterOrder.setVipType((byte)10);
		panterOrder.setOrdersn(orderSn);
		panterOrder.setAmount(new BigDecimal(50));
		panterOrder.setCreateTime(Utils.getCurrentTime());
		panterOrder.setStatus((byte)0);
		panterOrder.setIsSettlement((byte)0);
		panterOrderMapper.insertSelective(panterOrder);
		return panterOrder.getId();
	}

	/**
	 * 推荐VIP/合伙人分成
	 * @param orderId
	 * @param recommend
	 * @return
	 */
	public boolean PreSettlementByRecommend(Long orderId,ImsUserRecommend recommend) {
		boolean result = false;
		short propLevel1 = 0,propLevel2=0;
		String remark="推荐合伙人分润";
		try {
			ImsUserPanterOrder paterOrder = panterOrderMapper.selectByPrimaryKey(orderId);
			switch (paterOrder.getVipType()) {
			case 0:
				//推荐会员
				long parentId=recommend.getLevel1ParentId();
				if(parentId>0) {
					ImsUserRecommend userRecommend = recommendMapper.selectByPrimaryKey(parentId);
					if(userRecommend.getVipType()>0) {
						//推荐者VIP用户
						propLevel1 = (short)SystemProperties.VIP_TO_MEMBER;
					}
					/*else {
						//推荐者为普通用户
						propLevel1 = (short)SystemProperties.MEMBER_TO_MEMBER;
					}*/
				}
				propLevel2 = 0;
				break;
			case 1:
				//推荐合伙人
				propLevel1 = (short)SystemProperties.VIP_TO_PANTER_LEVEL1;
				propLevel2 = (short)SystemProperties.VIP_TO_PANTER_LEVEL2;
				remark = "推荐创业合伙人分润";
				break;
			case 10:
				propLevel1 = (short)SystemProperties.VIP_TO_MEMBER;
				propLevel2 = 10;
				remark = "推荐VIP会员人分润";
				break;
			default:
				//推荐超站,秘书长
				propLevel1 = (short)SystemProperties.VIP_TO_CHAOVIP_LEVEL1;
				propLevel2 = (short)SystemProperties.VIP_TO_CHAOVIP_LEVEL2;
				break;
			}
			CommissionDto commissionDto = new CommissionDto();
			commissionDto.setOrderSn(paterOrder.getOrdersn());
			commissionDto.setTotalAmount(paterOrder.getAmount());
			commissionDto.setOrderType(5);
			commissionDto.setRemark(remark);
			commissionDto.setFlowType((byte)9);
			CustomerDto p1 = new CustomerDto();
			p1.setMemberId(recommend.getLevel1ParentId());
			p1.setMerchId(0L);
			p1.setIdentity((short)0);
			p1.setProportion(propLevel1);
			CustomerDto p2 = new CustomerDto();
			if(paterOrder.getVipType()==10&&!recommend.getLevel1ParentId().equals(recommend.getRootId())) {
				p2.setMemberId(recommend.getRootId());
			}else {
				p2.setMemberId(recommend.getLevel2ParentId());
			}
			p2.setMerchId(0L);
			p2.setIdentity((short)0);
			p2.setProportion(propLevel2);
			CustomerDto p3 = new CustomerDto();
			p3.setMemberId(0L);
			p3.setMerchId(1L);
			p3.setIdentity((short)22);
			p3.setProportion((short)15);
			CustomerDto[] p = new CustomerDto[3];
			p[0] = p1;
			p[1] = p2;
			p[2] = p3;
			commissionDto.setParentCustomer(p);

			/**
			 * 推荐人预结算
			 */
			result = this.financeRemoteService.RecommendPreCommisstion(commissionDto);
		} catch (Exception ex) {
			String msg = String.format("订单%s结算失败", orderId);
			this.logger.error(msg, ex);
			ex.printStackTrace();
		}
		return result;
	}
	/**
	 * 推荐会员预结算
	 * @param orderId
	 * @param recommend
	 */
	public boolean PreSettlementByRecommendMember(Long orderId,ImsUserRecommend recommend) {
		boolean result = false;
		ImsUserPanterOrder paterOrder = panterOrderMapper.selectByPrimaryKey(orderId);
		CommissionDto commissionDto = new CommissionDto();
		commissionDto.setOrderSn(paterOrder.getOrdersn());
		commissionDto.setTotalAmount(paterOrder.getAmount());
		commissionDto.setOrderType(5);
		commissionDto.setRemark("推荐会员分润");
		commissionDto.setFlowType((byte)9);
		
		List<ImsUserRecommend> recomList = getUserRecommendBySort(recommend);
		int i=0;
		CustomerDto[] p = new CustomerDto[recomList.size()+1];
		for(ImsUserRecommend userRecommedn:recomList) {
			CustomerDto cusDto = new CustomerDto();
			cusDto.setMerchId(0L);
			cusDto.setIdentity((short)0);
			cusDto.setMemberId(userRecommedn.getMemberId());
			switch(i) {
				case 0:
					cusDto.setProportion((short)SystemProperties.VIP_TO_MEMBER);
					break;
				default:
					if(userRecommedn.getVipType()==3) {
						cusDto.setProportion((short)SystemProperties.SVP_TO_MEMBER);
					}else if(userRecommedn.getVipType()==2){
						cusDto.setProportion((short)SystemProperties.VP_TO_MEMBER);
					}
					break;
			}
			p[i]=cusDto;
			i++;
		}
		//平台
		CustomerDto plaftDto = new CustomerDto();
		plaftDto.setMemberId(0L);
		plaftDto.setMerchId(1L);
		plaftDto.setIdentity((short)22);
		plaftDto.setProportion((short)15);
		p[p.length-1] = plaftDto;
		commissionDto.setParentCustomer(p);
		/**
		 * 推荐人预结算
		 */
		result = this.financeRemoteService.RecommendPreCommisstion(commissionDto);
		
		return result;
	}
	private List<ImsUserRecommend> getUserRecommendBySort(ImsUserRecommend recommend){
		List<ImsUserRecommend> sortList = new ArrayList<ImsUserRecommend>();
		
		ImsUserRecommendExample example = new ImsUserRecommendExample();
		example.createCriteria().andRootdEqualTo(recommend.getRootId());
		List<ImsUserRecommend> urlist = recommendMapper.selectByExample(example);
		long parentId=recommend.getLevel1ParentId();
		ImsUserRecommend userReeommend =null;
		//是否存在高级合伙人
		boolean isExistSP=false;
		int i=0;
		while((userReeommend=getParentRecommend(parentId,urlist))!=null) {
			i++;
			parentId = userReeommend.getLevel1ParentId();
			if(userReeommend.getVipType()==3) {
				sortList.add(userReeommend);
				break;
			}
			if(i==1) {
				sortList.add(userReeommend);
				if(userReeommend.getVipType()==2) {
					isExistSP = true;
				}
				continue;
			}
			else if(userReeommend.getVipType()==2){
				if(isExistSP) {
					continue;
				}else {
					isExistSP = true;
					sortList.add(userReeommend);
				}
			}
			if(parentId==0) {
				break;
			}
		}
		return sortList;
	}
	private ImsUserRecommend getParentRecommend(Long parentId,List<ImsUserRecommend> urlist) {
		ImsUserRecommend result = null;
		for(ImsUserRecommend ur:urlist) {
			if(ur.getMemberId().equals(parentId)) {
				result = ur;
				break;
			}
		}
		return result;
	}
	/**
	 * 推荐人结算
	 */
	public boolean SettlementByRecommend(Integer orderId){
		ImsUserPanterOrder paterOrder = panterOrderMapper.selectByPrimaryKey(orderId.longValue());
		return this.financeRemoteService.RecommendCommisstion(paterOrder.getOrdersn());
	}
}
