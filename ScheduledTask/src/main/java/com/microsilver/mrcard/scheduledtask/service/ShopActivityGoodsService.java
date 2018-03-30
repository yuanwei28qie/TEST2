package com.microsilver.mrcard.scheduledtask.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsilver.mrcard.scheduledtask.constant.SystemProperties;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopActivityConfigMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopActivityGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopActivityMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopGoodsMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMerchConfigMapper;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMerchUserMapper;
import com.microsilver.mrcard.scheduledtask.exception.BusiException;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivity;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityConfig;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityConfigExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityExample;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchConfig;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.scheduledtask.utils.DateUtil;
import com.microsilver.mrcard.scheduledtask.utils.NumberFormat;

@Service
public class ShopActivityGoodsService extends BaseService{
	@Resource
	private ImsEweiShopActivityGoodsMapper activityGoodsMapper;

	@Resource
	private ImsEweiShopGoodsMapper eweiShopGoodsMapper;

	@Resource
	private ImsEweiShopActivityConfigMapper activityConfigMapper;
	
	@Resource
	ImsEweiShopMerchConfigMapper merchConfigMapper;
	
	@Resource
	ImsEweiShopActivityMapper activityMapper;
	
	@Resource
	ImsEweiShopMerchUserMapper merchUserMapper;
	
	public List<ImsEweiShopActivityGoods> getSuperOrderActivityGoods() {
		List<ImsEweiShopActivityGoods> list = activityGoodsMapper.selectActivityGoods();
		return list;
	}

	@Transactional
	public void updateActivityGoods(List<ImsEweiShopActivityGoods> list) {
		if(list !=null){
			//记录如果有商品下架 则重新计算活动最低价
			boolean flag = false;
			Set<Long> merches = new HashSet<Long>();
			for (ImsEweiShopActivityGoods activityGoods : list) {
				if(activityGoods.getDefaultQuantity()>=1){
					Integer endTime = activityGoods.getEndTime();
					if (endTime==null||endTime <= DateUtil.getNowDate()) {
						StringBuilder sb = new StringBuilder();
						long goodsId = activityGoods.getGoodsId();
						ImsEweiShopGoods goods = eweiShopGoodsMapper.selectByPrimaryKey(goodsId);
						if(goods == null) {
							logger.info("商品编号为 "+goodsId+" 的商品已删除");
							activityGoodsMapper.deleteByPrimaryKey(activityGoods.getId());
							continue;
						}
						goods.setTotal(activityGoods.getDefaultQuantity());
						goods.setStatus(true);
						goods.setSalesreal(0);
						//计算商品售价marketprice
						Integer activityId = activityGoods.getActivityId();
						Long merchId = activityGoods.getMerchId();
						ImsEweiShopActivity activity = this.calMerchCashBackAndPlatformProportion(activityId,merchId);
						if(activityId==1) {
							goods.setMarketprice(NumberFormat.formatBigDecimal(goods.getZeroCostprice().multiply(new BigDecimal(1).add(activity.getPlatformProportion()))));
						}else if(activityId==2) {
							BigDecimal costprice = goods.getCostprice();//结算价
							BigDecimal presellprice = goods.getPresellprice();//卖价productprice
							BigDecimal cashback = NumberFormat.formatBigDecimal((presellprice.subtract(costprice)).multiply(activity.getCashbackProportion()));//平台补贴
							goods.setMarketprice(presellprice.subtract(cashback));
						}
						
						int count = eweiShopGoodsMapper.updateByPrimaryKeySelective(goods);
						if(count==1){
							sb.append("商品编号为").append(activityGoods.getGoodsId()).append(" 的商品已上架,");
						}
						ImsEweiShopActivityConfigExample example = new ImsEweiShopActivityConfigExample();
						example.createCriteria().andMerchIdEqualTo(merchId).andActivityIdEqualTo(activityId);
						List<ImsEweiShopActivityConfig> listShopActivity = activityConfigMapper.selectByExample(example);
						if(listShopActivity.size()==1){
							ImsEweiShopActivityConfig imsEweiShopActivityConfig = listShopActivity.get(0);
							Integer shopBeginTime = imsEweiShopActivityConfig.getBeginTime();
							Integer shopEndTime = imsEweiShopActivityConfig.getEndTime();
							if(imsEweiShopActivityConfig.getActivityId()==2){
								shopEndTime = imsEweiShopActivityConfig.getBeginTime();
							}
							Integer begin = DateUtil.getTime(shopBeginTime, 0);
							Integer end = DateUtil.getTime(shopEndTime, 1);
							
							if(imsEweiShopActivityConfig.getActivityId()==1){
								if(imsEweiShopActivityConfig.getExecuteBegin()==null ||
										imsEweiShopActivityConfig.getExecuteBegin()<DateUtil.getNowDate()){
									imsEweiShopActivityConfig.setExecuteBegin(begin);
									imsEweiShopActivityConfig.setExecuteEnd(end);
								}
							}
							
							activityConfigMapper.updateByPrimaryKeySelective(imsEweiShopActivityConfig);
							
							activityGoods.setBeginTime(begin);
							activityGoods.setEndTime(end);
							sb.append("活动时间已更新为:").append(DateUtil.dateToString(DateUtil.secondToDate(activityGoods.getBeginTime())))
							.append(" 开始,").append(DateUtil.dateToString(DateUtil.secondToDate(activityGoods.getEndTime()))).append("结束");
							activityGoodsMapper.updateByPrimaryKeySelective(activityGoods);
							logger.info(sb.toString());
							flag=true;
							merches.add(activityGoods.getMerchId());
						}else{
							throw new BusiException("商户活动配置错误");
						}
					}					
				}else{
					Integer endTime = activityGoods.getEndTime();
					if (endTime==null||(endTime <= DateUtil.getNowDate()&&endTime!=0)) {
						//如果取消了自动上架 把开始时间与结束时间设为0 避免定时器下个时刻重复计算
						activityGoods.setBeginTime(0);
						activityGoods.setEndTime(0);
						activityGoodsMapper.updateByPrimaryKeySelective(activityGoods);				
						//如果取消了自动上架 则本期活动结束时把商品状态设置为下架
						long goodsId = activityGoods.getGoodsId();
						ImsEweiShopGoods goods = new ImsEweiShopGoods();
						goods.setId((int) goodsId);
						goods.setTotal(0);
						goods.setStatus(false);
						goods.setSalesreal(0);
						int count = eweiShopGoodsMapper.updateByPrimaryKeySelective(goods);
						if(count==1){
							flag = true;
							merches.add(activityGoods.getMerchId());
							logger.info("商品编号为 "+activityGoods.getGoodsId()+" 的商品已下架");							
						}
					}
				}
			}	
			//查询有些酒店房间全部下架的酒店活动 
			List<ImsEweiShopActivityGoods> activityGoods = activityGoodsMapper.selectMerchActivityOff();
			ImsEweiShopActivityConfig record = new ImsEweiShopActivityConfig();
			record.setCashbackMax(new BigDecimal("0"));
			record.setLowestPrice(new BigDecimal("0"));
			for (ImsEweiShopActivityGoods ag : activityGoods) {
				ImsEweiShopActivityConfigExample example = new ImsEweiShopActivityConfigExample();
				example.createCriteria().andMerchIdEqualTo(ag.getMerchId()).andActivityIdEqualTo(ag.getActivityId()).andLowestPriceNotEqualTo(new BigDecimal("0"));
				activityConfigMapper.updateByExampleSelective(record, example);
			}
			
			//如果有酒店上/下架则重新计算最低价和最高返现价
			if(flag){
				ImsEweiShopActivityConfigExample example = new ImsEweiShopActivityConfigExample();
				example.createCriteria().andACMerchIdIn(new ArrayList<Long>(merches)).andAGEndTimeGreaterThan(0).andGoodsStatusEqualTo((byte)1).andDeletedEqualTo((byte)0);
				List<ImsEweiShopActivityConfig> activityConfigs = activityConfigMapper.calLowestPriceAndCashBackMax(example);
				
				for (ImsEweiShopActivityConfig imsEweiShopActivityConfig : activityConfigs) {
					Integer activityId = imsEweiShopActivityConfig.getActivityId();
					ImsEweiShopActivity ac = this.calMerchCashBackAndPlatformProportion(activityId, imsEweiShopActivityConfig.getMerchId());					
					if(activityId==1) {
						BigDecimal maxZeroPresellprice = imsEweiShopActivityConfig.getMaxZeroPresellprice();
						imsEweiShopActivityConfig.setCashbackMax(maxZeroPresellprice.subtract(imsEweiShopActivityConfig.getCashbackMax()));								
						//imsEweiShopActivityConfig.setCashbackMax(maxZeroPresellprice.subtract(NumberFormat.formatBigDecimal(imsEweiShopActivityConfig.getMaxZeroCostprice().multiply(new BigDecimal(1).add(platformProportion)))));		
						//imsEweiShopActivityConfig.setLowestPrice(NumberFormat.formatBigDecimal(imsEweiShopActivityConfig.getMinZeroCostprice().multiply(new BigDecimal(1).add(platformProportion))));
					}else if(activityId==2) {
						BigDecimal maxPresellprice = imsEweiShopActivityConfig.getMaxPresellprice();
						BigDecimal maxCostprice = imsEweiShopActivityConfig.getMaxCostprice();
						imsEweiShopActivityConfig.setCashbackMax(NumberFormat.formatBigDecimal((maxPresellprice.subtract(maxCostprice)).multiply(ac.getCashbackProportion())));								
						//imsEweiShopActivityConfig.setCashbackMax(maxPresellprice.subtract(NumberFormat.formatBigDecimal(imsEweiShopActivityConfig.getMaxCostprice().multiply(new BigDecimal(1).add(platformProportion)))));		
						//imsEweiShopActivityConfig.setLowestPrice(NumberFormat.formatBigDecimal(imsEweiShopActivityConfig.getMinCostprice().multiply(new BigDecimal(1).add(platformProportion))));					
					}
				
					//更新最低价与最高返现价
					activityConfigMapper.updateByPrimaryKeySelective(imsEweiShopActivityConfig);
					logger.info(String.format("活动ID为%s的活动更新了最低价和最高返现价",imsEweiShopActivityConfig.getId()));					
				}				
			}
			logger.info("待重新计算权重的商户id为"+merches);
			//重新计算权重值
			for (Long merchId : merches) {
				this.calSortWeight(merchId);
			}
		}
	}
	
	/**
	 * 重新计算并更新该酒店的权重排序值
	 * @param merchId 商户Id
	 */
	public int calSortWeight(long merchId){
		int score = cal(merchId);
		// 更新酒店权重值
		ImsEweiShopMerchUser merchUser = new ImsEweiShopMerchUser();
		merchUser.setId((int)merchId);
		merchUser.setSortWeight(score);
		merchUserMapper.updateByPrimaryKeySelective(merchUser);
		return score;
	}

	private int cal(Long merchId) {
		int sortWeight = 0;
		List<Integer> sortList = new ArrayList<Integer>();
		ImsEweiShopMerchUser merch = merchUserMapper.selectByPrimaryKey(merchId);
		if(merch.getIsrecommand()!=null&&merch.getIsrecommand()) {
			sortList.add(SystemProperties.MERCH_RECOMMEND);
		}
		if(merch.getStarLevel()!=null&&merch.getStarLevel()==5) {
			sortList.add(SystemProperties.FIVE_STAR_HOTEL);
		}
		if(merch.getIsMill()!=null&&merch.getIsMill().intValue()==1) {
			sortList.add(SystemProperties.MERCH_DISCOUNT);
		}
		
		ImsEweiShopActivityConfigExample example = new ImsEweiShopActivityConfigExample();
		example.createCriteria().andACMerchIdEqualTo(merchId).andAGEndTimeGreaterThan((int)DateUtil.getNowDate()).andGoodsStatusEqualTo((byte)1).andDeletedEqualTo((byte)0);
		ImsEweiShopActivityConfig config = activityConfigMapper.calSortWeight(example);
		if(config !=null){
			if(config.getTotal()>0){
				//sortWeight+=SystemProperties.NOT_SOLDOUT;
				sortList.add(SystemProperties.NOT_SOLDOUT);
			}
			if(config.getCashbackMax().doubleValue()>0){
				//sortWeight+=SystemProperties.RED_PACKET;
				sortList.add(SystemProperties.RED_PACKET);
			}
			String activity = config.getActivity();
			if(activity!=null){
				Set<Integer> ac = new HashSet<>();
				String[] split = activity.split(",");
				for (String s : split) {
					ac.add(new Integer(s));
				}
				for (Integer activityId : ac) {
					if(activityId==1){
						//sortWeight+=SystemProperties.HALF_OFF;
						sortList.add(SystemProperties.HALF_OFF);
					}else if(activityId==2){
						//sortWeight+=SystemProperties.SUPER_DISCOUNT;
						sortList.add(SystemProperties.SUPER_DISCOUNT);
					}
				}
			}			
		}
		for(int sort:sortList) {
			//logger.info("分值:"+sort);
			sortWeight+=sort;
		}
		//logger.info("权重:"+sortWeight);
		return sortWeight;
	}
	
	/**
	 * 		根据商家id与活动id计算该商家最终返现比例与平台抽成比例 
	 */
	ImsEweiShopActivity calMerchCashBackAndPlatformProportion(Integer activityId,Long merchId){
		ImsEweiShopMerchConfig shopMerchConfig = merchConfigMapper.selectByPrimaryKey(merchId);
		BigDecimal redPacket = null;//红包返现
		BigDecimal platformProportion = null;//平台抽成
		if(shopMerchConfig !=null){
			if(activityId==1){
				redPacket=shopMerchConfig.getLdbjCashbackProportion();
				platformProportion=shopMerchConfig.getLdbjPlatformProportion();
			}else if(activityId==2){
				redPacket=shopMerchConfig.getCjtjCashbackProportion();
				platformProportion=shopMerchConfig.getCjtjPlatformProportion();
			}
		}
		ImsEweiShopActivityExample exam = new ImsEweiShopActivityExample();
		exam.createCriteria().andIdEqualTo(activityId);
		ImsEweiShopActivity activity = activityMapper.selectByExample(exam).get(0);
		if(redPacket==null){
			redPacket = activity.getCashbackProportion();
		}
		if(platformProportion==null) {
			platformProportion=activity.getPlatformProportion();
		}
		//最终红包返现百分比
		redPacket =  redPacket.divide(new BigDecimal(100));
		//最终平台抽成百分比
		platformProportion=platformProportion.divide(new BigDecimal(100));
		activity.setCashbackProportion(redPacket);
		activity.setPlatformProportion(platformProportion);
		return activity;
	}
}
