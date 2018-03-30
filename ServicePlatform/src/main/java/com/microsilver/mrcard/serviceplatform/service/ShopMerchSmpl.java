/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.service.ShopMerchSmpl
 * @Description 商户服务实现类
 * 
 * @Author bruce
 * @Version 2017年6月28
 * @Copyright Micro Silver
 *
 */
package com.microsilver.mrcard.serviceplatform.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.IMemberDao;
import com.microsilver.mrcard.serviceplatform.dao.IMemberIdentityDao;
import com.microsilver.mrcard.serviceplatform.dao.IMerchRegDao;
import com.microsilver.mrcard.serviceplatform.dao.IShopOrderDao;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiMemberCardMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopCashMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMerchUserMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsSysGroupResourceMapper;
import com.microsilver.mrcard.serviceplatform.dto.BusinessDto;
import com.microsilver.mrcard.serviceplatform.dto.BusinessIdentityDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchUserIndexDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiMemberCard;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiMemberCardExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCash;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchReg;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchRegExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchRegWithBLOBs;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUserExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupResource;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroupResourceExample;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class ShopMerchSmpl {
	private final static Logger logger = LoggerFactory.getLogger(ShopMerchSmpl.class);

	@Autowired
	ImsEweiShopMerchUserMapper iMerchUserMapper;
	@Autowired
	IMemberDao iMemberDao;
	@Autowired
	IMerchRegDao iMerchRegDao;

	@Autowired
	IMemberIdentityDao iMemberIdentityDao;

	@Autowired
	ImsEweiMemberCardMapper memberCardMapper;

	@Resource
	IShopOrderDao shopOrderDao;

	@Autowired
	IFinanceRemoteSmpl iFinanceRemoteSmpl;
	@Resource
	ImsEweiShopCashMapper shopCashMapper;
	@Resource
	ImsSysGroupResourceMapper groupResourceMapper;

	public ImsEweiShopMerchUser getShopMerch(Long id) {
		return iMerchUserMapper.selectByPrimaryKey(id);
	}

	public RespBaseDto<BusinessDto> checkBusinessAccount(Long memberId, ImsEweiShopMember member, int identity) {
		RespBaseDto<BusinessDto> result = new RespBaseDto<BusinessDto>();
		// 查询申请记录
		ImsEweiShopMerchReg merchReg = iMerchRegDao.selectByMemberId(memberId);
		BusinessDto bdto = new BusinessDto();
		if (merchReg == null || merchReg.getStatus() == 1) {
			// 查询会员身份\
			List<BusinessIdentityDto> miList = null;
			if (identity == -1) {
				miList = iMemberIdentityDao.selectDtoByMemberId(memberId);
			} else {
				ImsEweiShopMemberIdentity recode = new ImsEweiShopMemberIdentity();
				recode.setMemberId(memberId);
				recode.setIdentity((byte) identity);
				recode.setStatus((byte) 1);
				miList = iMemberIdentityDao.selectBusiIdttDto(recode);
			}
			if (miList.size() == 0) {
				bdto.setRegStatus(-2);
			} else {
				
				for (BusinessIdentityDto dto : miList) {
					if (dto.getIdentity() == 14 || dto.getIdentity() == 21) {
						if (dto.getStatus() == 0) {
							// 账号禁用
							bdto.setRegStatus(2);
						} else {
							bdto.setRegStatus(dto.getStatus());
							if(dto.getIdentity()==14) {
								ImsSysGroupResourceExample example = new ImsSysGroupResourceExample();
								example.createCriteria().andUidEqualTo(memberId.intValue());
								List<ImsSysGroupResource> grList = groupResourceMapper.selectByExample(example);
								if(grList.size()>0) {
									dto.setGroupId(grList.get(0).getGroupId());
								}
							}
						}
						break;
					}
				}
				
			}
			result.setMessage("OK");
			bdto.setIdentityList(miList);
		} else {
			// 待审核
			// 审核未通过
			bdto.setRegStatus(merchReg.getStatus());
			result.setMessage("OK");
		}
		bdto.setMemberId(memberId);
		bdto.setOpenId(member.getOpenid());
		bdto.setUniacId(member.getUniacid());
		result.setData(bdto);
		return result;
	}

	public RespBaseDto<BusinessDto> checkEmployeeAccount(ImsEweiShopMember member) {
		RespBaseDto<BusinessDto> result = new RespBaseDto<BusinessDto>();
		List<BusinessIdentityDto> miList = iMemberIdentityDao.selectEmployeeByMemberId(member.getId());
		BusinessDto bdto = new BusinessDto();
		if (miList.size() == 0) {
			result.setState(EWarning.NonExistent.getValue());
			result.setMessage(EWarning.NonExistent.getName());
		} else {
			bdto.setIdentityList(miList);
			bdto.setMemberId(member.getId());
			bdto.setOpenId(member.getOpenid());
			bdto.setUniacId(member.getUniacid());
			result.setData(bdto);
		}
		return result;
	}

	public ImsEweiShopMerchUser selectMerchUserByPrimaryKey(Integer id) {
		return iMerchUserMapper.selectByPrimaryKey1((long) id);
	}

	public int updateMerchUserByPrimaryKey(ImsEweiShopMerchUser record) {
		return iMerchUserMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 资料录入-商户（账号必需是会员） 检查商家是否已经入住 ImsEweiShopMerchUser 已提交审核 ImsEweiShopMerchReg
	 * 资料录入-员工（账号必需是会员） 检查员工是否已经存在 录入员工身份-角色-权限
	 * 
	 * @return
	 */
	public boolean merchInfoInput(ImsEweiShopMerchRegWithBLOBs reg) throws Exception {
		checkMerchUserIsExists(reg.getMemberid(), reg.getMerchname());
		checkMerchUserRegIsExists(reg.getMemberid(), reg.getMerchname());
		int merchId = iMerchRegDao.insertSelective(reg);
		if (merchId > 0)
			return true;
		return false;
	}

	private void checkMerchUserIsExists(Integer memberId, String merchName) throws Exception {
		ImsEweiShopMerchUserExample example = new ImsEweiShopMerchUserExample();
		example.createCriteria().andUserIdEqualTo((long) memberId).andMerchnameEqualTo(merchName);
		List<ImsEweiShopMerchUser> merchList = iMerchUserMapper.selectByExample(example);
		if (!merchList.isEmpty()) {
			logger.error("检查到商户已经入住");
			throw new Exception("商户已经存在");
		}
	}

	private void checkMerchUserRegIsExists(Integer memberId, String merchName) throws Exception {
		ImsEweiShopMerchRegExample example = new ImsEweiShopMerchRegExample();
		example.createCriteria().andMemberidEqualTo(memberId).andMerchnameEqualTo(merchName);
		List<ImsEweiShopMerchReg> merchList = iMerchRegDao.selectByExample(example);
		if (!merchList.isEmpty()) {
			logger.error("检查到商户已经申请");
			throw new Exception("商户已经申请过");
		}
	}

	/**
	 * 添加银行卡 检查此卡是否已经添加 检查是否有默认卡，默认卡只允许有一张
	 * 
	 * @param card
	 * @return
	 */
	public Integer menberCardInput(ImsEweiMemberCard card) throws Exception {
		checkDoubleMemberCardAndCleanDefault(card);
		card.setCreateTime(Utils.getCurrentTime());
		int recordId = memberCardMapper.insert(card);
		return recordId;
	}

	private void checkDoubleMemberCardAndCleanDefault(ImsEweiMemberCard card) throws Exception {
		List<ImsEweiMemberCard> list = getImsEweiMemberCardList(card.getMemberId(), card.getIdentity());

		for (ImsEweiMemberCard imc : list) {
			if (card.getAccountNumber().equals(imc.getAccountNumber())) {
				logger.error("重复添加银行账号");
				throw new Exception("重复添加银行账号");
			}
		}
		if (card.getIsDefault()) {
			for (ImsEweiMemberCard imc : list) {
				if (imc.getIsDefault()) {
					defaultCardClean(imc);
				}
			}
		}
	}

	/**
	 * 查询我已经绑定的银行卡
	 * 
	 * @param memberId
	 * @param identity
	 * @return
	 */
	public List<ImsEweiMemberCard> getImsEweiMemberCardList(Long memberId, Integer identity) {
		ImsEweiMemberCardExample example = new ImsEweiMemberCardExample();

		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo(identity);
		return memberCardMapper.selectByExample(example);
	}

	public Boolean defaultCardClean(ImsEweiMemberCard card) {
		return defaultCardChange(card, false);
	}

	private Boolean defaultCardChange(ImsEweiMemberCard card, Boolean isDefault) {
		card.setIsDefault(isDefault);
		int num = memberCardMapper.updateByPrimaryKey(card);
		return num > 0 ? true : false;
	}

	/**
	 * 设置默认银行卡
	 * 
	 * @param cardId
	 *            记录id
	 * @param memberId
	 *            用户id
	 * @param identity
	 *            身份id
	 * @return
	 */
	public boolean changeDefaultBalanceCard(Long cardId, Long memberId, Integer identity) {
		List<ImsEweiMemberCard> list = getImsEweiMemberCardList(memberId, identity);
		list.forEach((card) -> {
			if (card.getIsDefault() && !cardId.equals(card.getId())) {
				defaultCardChange(card, false);
			}
			if (!card.getIsDefault() && cardId.equals(card.getId())) {
				defaultCardChange(card, true);
			}
		});
		return true;
	}

	public MerchUserIndexDto getMerchUserIndex(Integer merchId) {
		if (merchId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		example.createCriteria().andMerchidEqualTo(merchId).andStatusEqualTo((byte) 1)
				.andOrderTypeEqualTo((byte) Consts.ORDER_TYPE_SUPER)
				.andPaytimeGreaterThanOrEqualTo((int) (Utils.getSomeDay(new Date(), 0).getTime() / 1000))
				.andPaytimeLessThan((int) (Utils.getSomeDay(new Date(), 1).getTime() / 1000));
		List<ImsEweiShopOrder> orders = shopOrderDao.selectTotalByExample(example);
		if (orders.size() != 1) {
			throw new BusinessException(EWarning.Unknown);
		}
		MerchUserIndexDto dto = new MerchUserIndexDto();
		ImsEweiShopOrder imsEweiShopOrder = orders.get(0);
		dto.setEarning(imsEweiShopOrder.getPrice() == null ? new BigDecimal(0) : imsEweiShopOrder.getPrice());
		dto.setTotal(imsEweiShopOrder.getCreatetime());
		dto.setOrders(this.getMerchOrderDtoByStatus(merchId, 1, (byte) 1));
		return dto;
	}

	public List<MerchOrderDto> getMerchOrderDtoByStatus(Integer merchId, Integer pageNum, Byte status) {
		if (merchId == null || pageNum == null || status == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		Criteria c = example.createCriteria().andSoMerchidEqualTo(merchId)
				.andSoOrderTypeEqualTo((byte) Consts.ORDER_TYPE_SUPER);
		if (status != -2) {
			c.andSoStatusEqualTo(status);
		}
		PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		example.setOrderByClause(" so.createtime asc ");
		List<MerchOrderDto> ordersDto = shopOrderDao.selectOrdersByExample(example);
		Map<Integer, ImsEweiShopActivity> activityMap = DictionaryUtils.getActivityMap();
		for (MerchOrderDto merchOrderDto : ordersDto) {
			Integer activityId = merchOrderDto.getActivityId();
			if (activityId != null)
				merchOrderDto.setActivityName(activityMap.get(activityId).getName());
		}
		return ordersDto;
	}

	public int customerIn(Long id) {
		ImsEweiShopOrder order = shopOrderDao.selectByPrimaryKey(id);
		if (order.getStatus() != 1) {
			throw new BusinessException(EWarning.Order_ErrorStatus);
		}
		order.setStatus(Consts.ORDER_STATUS_RECIEVE);
		order.setFinishtime(Utils.getCurrentTime());
		shopOrderDao.updateByPrimaryKeySelective(order);
		return 1;
	}

	public MerchOrderDto selectOrdersDetailsByPrimaryKey(Long id) {
		if (id == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		MerchOrderDto orderDto = shopOrderDao.selectOrdersDetailsByPrimaryKey(id);
		Integer status = orderDto.getStatus();
		switch (status) {
		case 1:
			orderDto.setStatusStr("待入住");
			break;
		case 4:
			orderDto.setStatusStr("已退款");
			break;
		case 6:
			orderDto.setStatusStr("已完成");
			break;
		default:
			break;
		}
		String services = orderDto.getServices();
		List<ImsSysDictionary> listIconService = new ArrayList<>();
		if (services != null && !services.equals("")) {
			String[] servs = services.split(",");
			List<ImsSysDictionary> dics = DictionaryUtils.getDictionaryListByType("hotel_goods_tags");
			for (String str : servs) {
				for (ImsSysDictionary imsSysDictionary : dics) {
					if (imsSysDictionary.getValue().equals(Integer.valueOf(str))) {
						listIconService.add(imsSysDictionary);
						break;
					}
				}
			}
		}
		orderDto.setListIconService(listIconService);
		return orderDto;
	}

	public Map<String, String> constituteIndex(Long memberId, Long merchId, Long identity) {
		MrcardFinanceCustomer financeCustomer = iFinanceRemoteSmpl.searchFinanceCustomer(memberId, merchId, identity);
		Map<String, String> map = new HashMap<String, String>();
		map.put("unrecordedAmount", financeCustomer.getUnrecordedAmount() + "");
		map.put("realAmount", financeCustomer.getRealAmount() + "");
		map.put("totalAmount", financeCustomer.getTotalAmount() + "");
		map.put("accountNumber", "");
		ImsEweiMemberCard card = getDefaultCard(memberId, identity);
		if (card != null) {
			map.put("type", card.getType() + "");
			map.put("bankName", card.getBankName());
			map.put("accountNumber", card.getAccountNumber());
		}
		return map;
	}

	public ImsEweiMemberCard getDefaultCard(Long memberId, Long identity) {
		ImsEweiMemberCardExample example = new ImsEweiMemberCardExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo(identity.intValue())
				.andIsDefaultEqualTo(true);
		List<ImsEweiMemberCard> memberCards = memberCardMapper.selectByExample(example);
		if (memberCards.size() > 1) {
			throw new BusinessException(EWarning.DefaultAccountException);
		}
		ImsEweiMemberCard card = null;
		if (memberCards.size() == 1) {
			card = memberCards.get(0);
		}
		return card;
	}

	@Transactional
	public Long withdraw(Long memberId, Long merchId, Long identity, BigDecimal moneys) {
		if (memberId == null || merchId == null || identity == null || moneys == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		if (moneys.compareTo(new BigDecimal("0")) != 1) {
			throw new BusinessException(EWarning.WithdrawMustMoreThanZero);
		}

		ImsEweiMemberCard card = getDefaultCard(memberId, identity);
		if (card == null) {
			throw new BusinessException(EWarning.None_WithdrawCard);
		}

		ImsEweiShopCash shopCash = new ImsEweiShopCash();
		shopCash.setMemberid(memberId);
		shopCash.setMerchid(merchId);
		shopCash.setIdentity(identity.intValue());
		shopCash.setBankname(card.getBankName());
		shopCash.setBankcard(card.getAccountNumber());
		shopCash.setTruename(card.getAccountName());
		shopCash.setType((int)card.getType());
		shopCash.setMoneys(moneys);
		shopCash.setStatus(0);// 待审核
		shopCash.setCashType(1);// 1为商家,2为骑士收入,3为骑士垫付
		shopCash.setCreatetime((long)Utils.getCurrentTime());
		shopCashMapper.insertSelective(shopCash);
		
		WithdrawDto withdraw = new WithdrawDto();
		withdraw.setOrdersn(Utils.createOrderSn("TX"));
		withdraw.setAlipay(card.getAccountNumber());
		withdraw.setAmount(moneys);
		withdraw.setIdentity(identity.shortValue());
		withdraw.setMemberId(memberId);
		withdraw.setMerchId(merchId);
		Long flowId = iFinanceRemoteSmpl.withdraw(withdraw);
		return flowId;
	}
}
