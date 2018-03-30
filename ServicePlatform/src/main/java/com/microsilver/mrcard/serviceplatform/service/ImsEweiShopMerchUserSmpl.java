package com.microsilver.mrcard.serviceplatform.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.IMemberDao;
import com.microsilver.mrcard.serviceplatform.dao.IShopOrderDao;
import com.microsilver.mrcard.serviceplatform.dao.IShopOrderGoodsDao;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopActivityGoodsMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopActivityMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopGoodsMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMerchConfigMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMerchUserMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopOrderCommentMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopSystemAdvMapper;
import com.microsilver.mrcard.serviceplatform.dto.ActivityGoodsDto;
import com.microsilver.mrcard.serviceplatform.dto.HotelDto;
import com.microsilver.mrcard.serviceplatform.dto.HotelIndexDto;
import com.microsilver.mrcard.serviceplatform.dto.HotelOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.ShopOrderGoodsDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityGoodsExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopGoods;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchConfig;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImages;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUserExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUserExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderComment;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderGoods;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopSystemAdv;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopSystemAdvExample;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import com.microsilver.mrcard.serviceplatform.model.ImsSysRemind;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class ImsEweiShopMerchUserSmpl {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ImsEweiShopMerchUserMapper eweiShopMerchUserMapper;
	@Resource
	ImsEweiShopGoodsMapper eweiShopGoodsMapper;
	@Resource
	ImsEweiShopActivityGoodsMapper activityGoodsMapper;
	@Resource
	IShopOrderDao shopOrderDao;
	@Resource
	IShopOrderGoodsDao shopOrderGoodsDao;
	@Resource
	ImsEweiShopMemberCollectionSmpl collectionSmpl;
	@Resource
	ImsEweiShopMerchImagesService shopMerchImagesService;
	@Resource
	ImsEweiShopMerchConfigMapper merchConfigMapper;
	@Resource
	ImsEweiShopActivityMapper activityMapper;
	@Resource
	ImsSysRemindService remindService;
	@Resource
	IMemberDao memberDao;
	@Resource
	ImsEweiShopOrderCommentMapper shopOrderCommentMapper;
	@Resource
	private ImsEweiShopMemberIdentityService identityService;
	@Resource
	ImsEweiShopSystemAdvMapper advMapper;


	public List<ImsEweiShopMerchUser> getLatestPreferentialShopsByUniacId(Integer uniacId) {
		ImsEweiShopMerchUserExample example = new ImsEweiShopMerchUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUniacidEqualTo(uniacId);
		criteria.andIsPayLessThan(10f);
		criteria.andStatusNotEqualTo((byte) 2);
		example.setOrderByClause(" jointime desc ");
		PageHelper.startPage(1, 10);
		List<ImsEweiShopMerchUser> imsEweiShopMerchUsers = eweiShopMerchUserMapper.selectByExample(example);
		return imsEweiShopMerchUsers;
	}

	public List<ImsEweiShopMerchUser> getRecommendShopByUniacId(Integer uniacId, Integer page, Integer pageSize) {
		ImsEweiShopMerchUserExample example = new ImsEweiShopMerchUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUniacidEqualTo(uniacId);
		criteria.andStatusNotEqualTo((byte) 2);
		criteria.andIsrecommandEqualTo(true);
		PageHelper.startPage(page, pageSize);
		List<ImsEweiShopMerchUser> imsEweiShopMerchUsers = eweiShopMerchUserMapper.selectByExample(example);
		return imsEweiShopMerchUsers;
	}

	public List<ImsEweiShopMerchUser> selectByExample(ImsEweiShopMerchUserExample example) {
		List<ImsEweiShopMerchUser> list = eweiShopMerchUserMapper.selectByExample(example);
		return list;
	}

	public ImsEweiShopMerchUser selectByPrimaryKey(Long id) {
		return eweiShopMerchUserMapper.selectByPrimaryKey(id);
	}

	public ImsEweiShopMerchUser selectByPrimaryKeyWithPrice(Long id) {
		return eweiShopMerchUserMapper.selectByPrimaryKeyWithPrice(id);
	}

	public List<HotelDto> searchHotels(HotelDto hotelDto) throws Exception {
		ImsEweiShopMerchUserExample example = new ImsEweiShopMerchUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo((byte) 2);
		criteria.andLowestPriceGreaterThan(0f);
		Integer page = hotelDto.getPage();
		if (page != null) {
			PageHelper.startPage(page, Consts.PAGE_SIZE);
		} else {
			PageHelper.startPage(1, Consts.PAGE_SIZE);
		}
		Float startPrice = hotelDto.getStartPrice();
		if (startPrice != null) {
			// criteria.andLowestPriceGreaterThanOrEqualTo(startPrice);
			example.setStartPrice(startPrice);
		}
		Float endPrice = hotelDto.getEndPrice();
		if (endPrice != null) {
			// criteria.andLowestPriceLessThanOrEqualTo(endPrice);
			example.setEndPrice(endPrice);
		}
		String starLevel = hotelDto.getStarLevel();
		if (starLevel != null && !starLevel.equals("")) {
			List<Integer> list = new ArrayList<>();
			String[] str = starLevel.split(",");
			for (String string : str) {
				list.add(Integer.parseInt(string));
			}
			criteria.andStarLevelIn(list);
		}
		String merchType = hotelDto.getMerchType();
		if (merchType != null && !merchType.equals("")) {
			String[] merchTypes = merchType.split(",");
			List<Integer> list = new ArrayList<>();
			for (String str : merchTypes) {
				list.add(Integer.valueOf(str));
			}
			criteria.andShopTypeIn(list);
		}
		
		//酒店品牌
		String brandId = hotelDto.getBrandId();
		if (brandId != null && !brandId.equals("")) {
			String[] brandIds = brandId.split(",");
			List<Integer> list = new ArrayList<>();
			for (String str : brandIds) {
				list.add(Integer.valueOf(str));
			}
			criteria.andBrandIdIn(list);
		}
		
		String servicestag = hotelDto.getServicestag();
		if (servicestag != null && !servicestag.equals("")) {
			String[] tags = servicestag.split(",");
			for (String str : tags) {
				criteria.findServicestag(str);
			}
		}
		String activity = hotelDto.getActivity();
		if (activity != null && !activity.equals("")) {
			example.setActivity(activity);
		}

		Float cashBack = hotelDto.getCashbackMax();
		if (cashBack != null) {
			if (cashBack != 0) {
				example.setCashbackMax(0f);
			}
		}
		// 关键字搜索
		String keyWords = hotelDto.getKeyWords();
		if (keyWords != null && !keyWords.trim().equals("")) {
			keyWords = keyWords.trim();
			criteria.andMerchnameLike(keyWords);
		}
		String lat = hotelDto.getLat();
		String lng = hotelDto.getLng();
		// 1.评分优先  2.折扣最多3.销量最多 4.价格最低,5.距离最近 6.价格由高到低
		Byte sortType = hotelDto.getSortType();
		if (sortType != null) {
			switch (sortType) {
			case 1:
				example.setOrderByClause(" score desc ");
				break;
			case 2:
				example.setOrderByClause(" is_pay asc ");
				break;
			case 3:
				example.setOrderByClause(" counts desc ");
				break;
			case 4:
				example.setOrderByClause(" lowest_price asc ");
				break;
			case 5:
				example.setOrderByClause(" distance asc ");
				break;
			case 6:
				example.setOrderByClause(" lowest_price desc ");
				break;
			default:
				break;
			}
		} else {
			//StringBuilder sb = new StringBuilder(" star_level asc, sort_weight desc ");
			StringBuilder sb = new StringBuilder(" sort_weight desc ");
			if (lat != null && lng != null) {
				sb.append(" ,distance asc");
			}
			example.setOrderByClause(sb.toString());
		}
		List<ImsEweiShopMerchUser> list = new ArrayList<>();
		Long code = hotelDto.getCode();
		Byte areaType = hotelDto.getAreaType();
		if (code != null && areaType != null) {
			if (areaType == 1) {
				criteria.andProvinceEqualTo(code);
			} else if (areaType == 2) {
				criteria.andCityEqualTo(code);
			} else if(areaType == 3) {
				criteria.andCountyEqualTo(code);
			}
		}
		if (lat == null || lng == null) {
			list = this.selectByExampleWithActivity(example);
		} else {
			example.setLat(lat);
			example.setLng(lng);
			list = this.selectByExampleWithActivityAndLocation(example);
		}
		List<HotelDto> hotels = new ArrayList<>();
		for (ImsEweiShopMerchUser imsEweiShopMerchUser : list) {
			HotelDto hotel = constituteHotelDto(imsEweiShopMerchUser);
			hotels.add(hotel);
		}
		return hotels;
	}

	private HotelDto constituteHotelDto(ImsEweiShopMerchUser imsEweiShopMerchUser)
			throws IllegalAccessException, InvocationTargetException {
		String activity;
		HotelDto hotel = new HotelDto();
		BeanUtils.copyProperties(hotel, imsEweiShopMerchUser);

		Integer shopType = hotel.getShopType();
		if(shopType!=null) {
			List<ImsSysDictionary> dictionaryListByType = DictionaryUtils.getDictionaryListByType("hotel_type");
			for (ImsSysDictionary imsSysDictionary : dictionaryListByType) {
				if(imsSysDictionary.getValue().equals(shopType)) {
					hotel.setMerchType(imsSysDictionary.getName());
					break;
				}
			}			
		}
		
		Float score = hotel.getScore();
		if (score != null) {
			if (score > 4.5) {
				hotel.setScoreLevel(score + " 很好");
			} else {
				hotel.setScoreLevel(score + " 好");
			}
		}
		String tags = hotel.getServicestag();
		List<String> listTags = new ArrayList<>();
		if (tags != null && !tags.equals("")) {
			String[] tag = tags.split(",");
			List<ImsSysDictionary> dics = DictionaryUtils.getDictionaryListByType("hotel_tags");
			for (String str : tag) {
				for (ImsSysDictionary imsSysDictionary : dics) {
					if (imsSysDictionary.getValue().equals(Integer.valueOf(str))) {
						listTags.add(imsSysDictionary.getName());
						break;
					}
				}
			}
		}
		hotel.setTags(listTags);

		activity = hotel.getActivity();
		List<ImsEweiShopActivity> shopActivity = new ArrayList<>();
		if (activity != null && !activity.equals("")) {
			String[] split = activity.split(",");
			Map<Integer, ImsEweiShopActivity> activityMap = DictionaryUtils.getActivityMap();
			for (String string : split) {
				Integer key = new Integer(string);
				shopActivity.add(activityMap.get(key));
			}
		}
		hotel.setShopActivity(shopActivity);

		if(hotel.getTradingArea()!=null) {
			int index = hotel.getTradingArea().indexOf(",");
			if(index>0)
				hotel.setTradingArea(hotel.getTradingArea().substring(0, index));
		}

		return hotel;
	}

	public List<ImsEweiShopMerchUser> selectByExampleWithActivity(ImsEweiShopMerchUserExample example) {
		List<ImsEweiShopMerchUser> list = eweiShopMerchUserMapper.selectByExampleWithActivity(example);
		return list;
	}

	public List<ImsEweiShopMerchUser> selectByExampleWithActivityAndLocation(ImsEweiShopMerchUserExample example) {
		List<ImsEweiShopMerchUser> list = eweiShopMerchUserMapper.selectByExampleWithActivityAndLocation(example);
		return list;
	}
/*
	public HotelDto getHotelDetails(Long memberId, Integer merchId) throws Exception {
		HotelDto dto = null;
		ImsEweiShopMerchUser eweiShopMerchUser = eweiShopMerchUserMapper.selectByPrimaryKeyWithComment(merchId);
		if (eweiShopMerchUser != null) {
			dto = constituteHotelDto(eweiShopMerchUser);
			Integer id = eweiShopMerchUser.getId();
			List<ImsEweiShopMerchImages> imageList = shopMerchImagesService.getImsEweiShopMerchImagesByMerchId(id);
			dto.setImageList(imageList);
			// 如果已登录 则检查当前用户是否已收藏该酒店
			if (memberId != null) {
				Byte isCollection = collectionSmpl.checkStatus(memberId, merchId,(byte)1);
				dto.setIsCollection(isCollection);
			}
							
			ImsEweiShopActivityGoodsExample example = new ImsEweiShopActivityGoodsExample();
			com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityGoodsExample.Criteria criteria = example
					.createCriteria();
			criteria.andEndTimeGreaterThanCopy(Utils.getCurrentTime());
			criteria.andMerchIdEqualToCopy((long) merchId);
			criteria.andGoodsStatusEqualTo(Consts.GOODS_STATUS_ONSALE);
			criteria.andDeletedEqualTo(Consts.GOODS_DELETED_NO);
			List<ActivityGoodsDto> activityGoods = activityGoodsMapper.selectActivityGoodsDetails(example);
			Map<Integer, ImsEweiShopActivity> activityMap = DictionaryUtils.getActivityMap();

			for (ActivityGoodsDto activityGoodsDto : activityGoods) {
				Integer activityId = activityGoodsDto.getActivityId();
				activityGoodsDto.setActivityName(activityMap.get(activityId).getName());
				if(memberId !=null){
					//查询该房间是否已设置提醒
						List<ImsSysRemind> remind = remindService.checkIfRemind(activityGoodsDto.getGoodsId(),memberId);
						activityGoodsDto.setIsRemind(remind.size()>0);
					}
				if(dto.getStarLevel()!=null&&dto.getStarLevel().equals("5")) {
					activityGoodsDto.setTotal(0);
				}
				this.calFinalPrice(activityGoodsDto);
			}
			dto.setActivityGoodsDtos(activityGoods);
		} else {
			throw new BusinessException(EWarning.NotExistMerch);
		}
		return dto;
	}*/
	
	// 根据activityId进行分类
		public HotelDto getHotelDetails(Long memberId, Integer merchId, Integer activityId) throws Exception {
			HotelDto dto = null;
			ImsEweiShopMerchUser eweiShopMerchUser = eweiShopMerchUserMapper.selectByPrimaryKeyWithComment(merchId);
			if (eweiShopMerchUser != null) {
				dto = constituteHotelDto(eweiShopMerchUser);
				Integer id = eweiShopMerchUser.getId();
				List<ImsEweiShopMerchImages> imageList = shopMerchImagesService.getImsEweiShopMerchImagesByMerchId(id);
				dto.setImageList(imageList);
				// 如果已登录 则检查当前用户是否已收藏该酒店
				if (memberId != null) {
					Byte isCollection = collectionSmpl.checkStatus(memberId, merchId, (byte) 1);
					dto.setIsCollection(isCollection);
				}

				ImsEweiShopActivityGoodsExample example = new ImsEweiShopActivityGoodsExample();
				com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityGoodsExample.Criteria criteria = example
						.createCriteria();
				criteria.andEndTimeGreaterThanCopy(Utils.getCurrentTime());
				criteria.andMerchIdEqualToCopy((long) merchId);
				criteria.andGoodsStatusEqualTo(Consts.GOODS_STATUS_ONSALE);
				criteria.andDeletedEqualTo(Consts.GOODS_DELETED_NO);
				List<ActivityGoodsDto> activityGoods = activityGoodsMapper.selectActivityGoodsDetails(example);
				Map<Integer, ImsEweiShopActivity> activityMap = DictionaryUtils.getActivityMap();

				for (ActivityGoodsDto activityGoodsDto : activityGoods) {
					if (activityId == 1 || activityId == 2) {
						// Integer activityId1 = activityGoodsDto.getActivityId();
						Integer activityId1 = activityId;// 传进来的activityId
						activityGoodsDto.setActivityName(activityMap.get(activityId1).getName());
						if (memberId != null) {
							// 查询该房间是否已设置提醒
							List<ImsSysRemind> remind = remindService.checkIfRemind(activityGoodsDto.getGoodsId(),
									memberId);
							activityGoodsDto.setIsRemind(remind.size() > 0);
						}
						if (dto.getStarLevel() != null && dto.getStarLevel().equals("5")) {
							activityGoodsDto.setTotal(0);
						}
						this.calFinalPrice(activityGoodsDto);
					} else {

						Integer activityId1 = activityGoodsDto.getActivityId();
						activityGoodsDto.setActivityName(activityMap.get(activityId1).getName());
						if (memberId != null) {
							// 查询该房间是否已设置提醒
							List<ImsSysRemind> remind = remindService.checkIfRemind(activityGoodsDto.getGoodsId(),
									memberId);
							activityGoodsDto.setIsRemind(remind.size() > 0);
						}
						if (dto.getStarLevel() != null && dto.getStarLevel().equals("5")) {
							activityGoodsDto.setTotal(0);
						}
						this.calFinalPrice(activityGoodsDto);

					}

				}
				dto.setActivityGoodsDtos(activityGoods);
			} else {
				throw new BusinessException(EWarning.NotExistMerch);
			}
			return dto;
		}

	public ActivityGoodsDto getRoomIndex(Long goodsId,Long memberId) {
		ActivityGoodsDto activityGoodsDto = eweiShopGoodsMapper.selectByPrimaryKeyDetails(goodsId);
		
		if(activityGoodsDto==null) {
			throw new BusinessException(EWarning.NotExistRoom);
		}
		if(activityGoodsDto.getStarLevel()!=null&&activityGoodsDto.getStarLevel().equals("5")) {
			activityGoodsDto.setTotal(0);
		}
		if(memberId !=null){
		//查询该房间是否已设置提醒
			List<ImsSysRemind> remind = remindService.checkIfRemind(goodsId,memberId);
			activityGoodsDto.setIsRemind(remind.size()>0);
		}
		Map<Integer, ImsEweiShopActivity> activityMap = DictionaryUtils.getActivityMap();
		Integer activityId = activityGoodsDto.getActivityId();
		activityGoodsDto.setActivityName(activityMap.get(activityId).getName());
		this.calFinalPrice(activityGoodsDto);

		String services = activityGoodsDto.getServices();
		List<String> listService = new ArrayList<>();
		List<ImsSysDictionary> listIconService = new ArrayList<>();
		if (services != null && !services.equals("")) {
			String[] servs = services.split(",");
			List<ImsSysDictionary> dics = DictionaryUtils.getDictionaryListByType("hotel_goods_tags");
			for (String str : servs) {
				for (ImsSysDictionary imsSysDictionary : dics) {
					if (imsSysDictionary.getValue().equals(Integer.valueOf(str))) {
						listService.add(imsSysDictionary.getName());
						listIconService.add(imsSysDictionary);
						break;
					}
				}
			}
		}
		activityGoodsDto.setListService(listService);
		activityGoodsDto.setListIconService(listIconService);
		return activityGoodsDto;
	}

	@Transactional
	public HotelOrderDto createOrder(HotelOrderDto orderDto) {
		Integer goodsId = orderDto.getGoodsId();
		Integer goodsNumber = orderDto.getGoodsNumber();
		BigDecimal price = orderDto.getPrice();
		if(orderDto.getDays()==null) {
			orderDto.setDays(1);
		}
		logger.info("用户下单：{}", JSON.toJSONString(orderDto));
		if(goodsId == null || goodsNumber == null || price == null || orderDto.getMemberId()==null){
			throw new BusinessException(EWarning.ErrorParams);
		}
		if(price.floatValue()<=0) {
			throw new BusinessException(EWarning.TotalAmountMustGreatThanZero);
		}
		Integer activityId =-1;
		BigDecimal cashbackMax =new BigDecimal(0);

		ActivityGoodsDto activityGoodsDto = eweiShopGoodsMapper.selectByPrimaryKeyDetails((long)goodsId);
		
		int currentTime = Utils.getCurrentTime();
		if(activityGoodsDto ==null){
			throw new BusinessException(EWarning.NotExistRoom);
		}else{
			activityId = activityGoodsDto.getActivityId();
			calFinalPrice(activityGoodsDto);
			
			cashbackMax = activityGoodsDto.getCashbackMax();
			if(activityId==Consts.ACTIVITY_TYPE_SUPER){
				if(activityGoodsDto.getBeginTime()>currentTime){
					throw new BusinessException(EWarning.ActivityNotStart);
				}				
			}	
		}
		
		ImsEweiShopGoods eweiShopGoods = eweiShopGoodsMapper.selectByPrimaryKeyForUpdate(goodsId);
		Integer total = eweiShopGoods.getTotal();
		if (total >= goodsNumber) {
			BigDecimal marketprice = activityGoodsDto.getMarketprice();
			if(activityId==2) {
				marketprice = activityGoodsDto.getPrePay();
			}
			BigDecimal cal = marketprice.multiply(new BigDecimal(goodsNumber)).multiply(new BigDecimal(orderDto.getDays()));
			BigDecimal redPacket = cashbackMax.multiply(new BigDecimal(goodsNumber)).multiply(new BigDecimal(orderDto.getDays()));;
			BigDecimal originalPrice = cal.add(redPacket);
			if(activityId==2) {
				originalPrice=cal;
			}
			
			if (cal.compareTo(price) == 0) {
				eweiShopGoods.setTotal(total - goodsNumber);
				//下单不加销量,付款后再加
//				eweiShopGoods.setSales(eweiShopGoods.getSales()+goodsNumber);
//				eweiShopGoods.setSalesreal(eweiShopGoods.getSalesreal()+goodsNumber);
				int count = eweiShopGoodsMapper.updateByPrimaryKeySelective(eweiShopGoods);
				if (count == 1) {
					ImsEweiShopOrder order = new ImsEweiShopOrder();
					order.setOrdersn(Utils.createOrderSn());
					order.setMemberId(orderDto.getMemberId());
					order.setMerchid((long)eweiShopGoods.getMerchid());
					order.setPrice(cal);//订单成交价=订单结算价+平台抽成
					order.setGoodsprice(originalPrice);//商品卖价=订单结算价+平台抽成+红包返现
					order.setSubsidyprice(redPacket); //红包返现价
					order.setCreatetime(currentTime);
					order.setStatus(0);
					order.setUniacid(eweiShopGoods.getUniacid());
					order.setOrderType((byte)3);
					order.setActivityId(activityId);
					order.setSourceType(orderDto.getSourceType());
					
					if(activityId==1) {
						order.setCostprice(eweiShopGoods.getZeroCostprice().multiply(new BigDecimal(goodsNumber)));						
					}else if(activityId == 2) {
						order.setCostprice(eweiShopGoods.getCostprice().multiply(new BigDecimal(goodsNumber)));						
					}
					/* 
					 * 设置入住时间与离开时间 
					 */
					order.setFetchtime(orderDto.getFetchTime());			
					order.setSendtime(orderDto.getSendTime());
					
					if(order.getFetchtime()==null||order.getSendtime()==null) {
						order.setFetchtime(currentTime);			
						Integer beginTime = activityGoodsDto.getBeginTime();
						Date dateBeginTime = new Date(beginTime*1000);
						Date dateCurrentTime = new Date(currentTime*1000);
						if(dateCurrentTime.getHours()>=dateBeginTime.getHours()){
							order.setSendtime(	(int) (Utils.getTime(12, 1) / 1000));
						}else{
							order.setSendtime((int) (Utils.getTime(12, 0) / 1000));
						}						
					}
					
					
					/**
					 * 做数据权限
					 * 	添加代理属性到订单中
					 * @Jade 2017-09-27
					 * rows 5
					 */
					ImsEweiShopMerchUser merchInfo = eweiShopMerchUserMapper.selectByPrimaryKey(order.getMerchid());
					Long [] parentProxy = identityService.parentIdentityArray(merchInfo.getUserId(),merchInfo.getId(),(byte)21);
					order.setProvinceAgentIdttId(parentProxy[0]);
					order.setCityAgentIdttId(parentProxy[1]);
					order.setCountyAgentIdttId(parentProxy[2]);
					shopOrderDao.insert(order);
					ImsEweiShopOrderGoods eweiShopOrderGoods = new ImsEweiShopOrderGoods();
					eweiShopOrderGoods.setOrderid(order.getId());
					eweiShopOrderGoods.setMerchid(eweiShopGoods.getMerchid());
					eweiShopOrderGoods.setGoodsid(goodsId);
					eweiShopOrderGoods.setTitle(eweiShopGoods.getTitle());
					eweiShopOrderGoods.setThumb(eweiShopGoods.getThumb());
					eweiShopOrderGoods.setTotal(goodsNumber);//商品数量
					eweiShopOrderGoods.setPrice(marketprice);//商品单价=单个商品结算价+平台抽成
					if(activityId==1) {
						eweiShopOrderGoods.setCostprice(activityGoodsDto.getZeroCostprice());//单个商品结算价
						eweiShopOrderGoods.setPresellprice(activityGoodsDto.getZeroPresellprice());//单个商品卖价=单个商品结算价+平台抽成+返现						
					}else if(activityId==2){
						eweiShopOrderGoods.setCostprice(activityGoodsDto.getCostprice());//单个商品结算价
						eweiShopOrderGoods.setPresellprice(activityGoodsDto.getPresellprice());//单个商品卖价=单个商品结算价+平台抽成+返现								
					}
					eweiShopOrderGoods.setSubsidyprice(cashbackMax);//红包返现
					
					eweiShopOrderGoods.setUniacid(eweiShopGoods.getUniacid());
					eweiShopOrderGoods.setOptionname(orderDto.getCustomers());	
					eweiShopOrderGoods.setCreatetime(currentTime);
					shopOrderGoodsDao.insert(eweiShopOrderGoods);
					HotelOrderDto result = new HotelOrderDto();
					result.setOrderId(order.getId());
					result.setOrdersn(order.getOrdersn());
					result.setPrice(cal);
					result.setActivityId(activityId);
					return result;
				}
			} else {
				throw new BusinessException(EWarning.ErrorAmount);
			}
		} else {
			throw new BusinessException(EWarning.RoomNotEnough);
		}
		return null;
	}

	public HotelIndexDto constituteIndex(HotelDto hotelDto, String appType, Short advBits) throws IllegalAccessException, InvocationTargetException {
		HotelIndexDto dto = new HotelIndexDto();
		//获取首页banner
		List<ImsEweiShopSystemAdv> advs = getAdvs(appType, advBits);
		dto.setAdvs(advs);
		//活动类型 1.零点半价 2.超级特价
		List<HotelDto> ldbjHotels = getHotelByActivityType(hotelDto,"1");
		List<HotelDto> cjtjHotels = getHotelByActivityType(hotelDto,"2");
		dto.setLdbjList(ldbjHotels);
		dto.setCjtjList(cjtjHotels);
		return dto;
	}

	private List<ImsEweiShopSystemAdv> getAdvs(String appType, Short advBits) {
		ImsEweiShopSystemAdvExample example = new ImsEweiShopSystemAdvExample();
		example.createCriteria().andAppTypeEqualTo(appType).andAdvBitsEqualTo(advBits);
		List<ImsEweiShopSystemAdv> advs = advMapper.selectByExample(example);
		return advs;
	}

	private List<HotelDto> getHotelByActivityType(HotelDto hotelDto,String activityType) throws IllegalAccessException, InvocationTargetException {
		ImsEweiShopMerchUserExample example = new ImsEweiShopMerchUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo((byte) 2);
		criteria.andLowestPriceGreaterThan(0f);	
		example.setActivity(activityType);
		String lat = hotelDto.getLat();
		String lng = hotelDto.getLng();
		List<ImsEweiShopMerchUser> list = new ArrayList<>();
		Long code = hotelDto.getCode();
		Byte areaType = hotelDto.getAreaType();
		if (code != null && areaType != null) {
			if (areaType == 1) {
				criteria.andProvinceEqualTo(code);
			} else if (areaType == 2) {
				criteria.andCityEqualTo(code);
			} else {
				criteria.andCountyEqualTo(code);
			}
		}
		PageHelper.startPage(1, 6);
		if (lat == null || lng == null) {
			list = this.selectByExampleWithActivity(example);
		} else {
			example.setOrderByClause(" distance asc ");
			example.setLat(lat);
			example.setLng(lng);
			list = this.selectByExampleWithActivityAndLocation(example);
		}
		List<HotelDto> hotels = new ArrayList<>();
		for (ImsEweiShopMerchUser imsEweiShopMerchUser : list) {
			HotelDto hotel = constituteHotelDto(imsEweiShopMerchUser);
			hotels.add(hotel);
		}
		return hotels;
	}
	
	public void calFinalPrice(ActivityGoodsDto activityGoodsDto) {
		Integer activityId = activityGoodsDto.getActivityId();
		ImsEweiShopMerchConfig shopMerchConfig = merchConfigMapper.selectByPrimaryKey(activityGoodsDto.getMerchId());
		BigDecimal disc = null;
		BigDecimal platformProportion = null;
		if(shopMerchConfig !=null){
			if(activityId==1){
				disc=shopMerchConfig.getLdbjCashbackProportion();
				platformProportion = shopMerchConfig.getLdbjPlatformProportion();
			}else if(activityId==2){
				disc=shopMerchConfig.getCjtjCashbackProportion();
				platformProportion = shopMerchConfig.getCjtjPlatformProportion();
			}
		}
		
		ImsEweiShopActivityExample exam = new ImsEweiShopActivityExample();
		exam.createCriteria().andIdEqualTo(activityId);
		ImsEweiShopActivity activity = activityMapper.selectByExample(exam).get(0);
		if(disc==null){
			disc = activity.getCashbackProportion();
		}
		if(platformProportion==null) {
			platformProportion = activity.getPlatformProportion();
		}
		platformProportion = platformProportion.divide(new BigDecimal(100));//平台扣点百分比
		//最终折扣率
		BigDecimal cashBack =  disc.divide(new BigDecimal(100));
		BigDecimal marketprice = activityGoodsDto.getMarketprice();
		if(activityId==1) {
			activityGoodsDto.setProductprice(activityGoodsDto.getZeroPresellprice().multiply(new BigDecimal(2)));
//			activityGoodsDto.setCashbackMax(Utils.formatBigDecimal(activityGoodsDto.getZeroCostprice().multiply(cashBack)));					
//			activityGoodsDto.setMarketprice(activityGoodsDto.getZeroCostprice().multiply(new BigDecimal(1).add(platformProportion)));
			
			//activityGoodsDto.setMarketprice(Utils.formatBigDecimal(activityGoodsDto.getZeroCostprice().multiply(new BigDecimal(1).add(platformProportion))));
			activityGoodsDto.setCashbackMax(Utils.formatBigDecimal(activityGoodsDto.getZeroPresellprice().subtract(marketprice)));
		}else if(activityId == 2){
			activityGoodsDto.setProductprice(activityGoodsDto.getPresellprice());
//			activityGoodsDto.setCashbackMax(Utils.formatBigDecimal(activityGoodsDto.getCostprice().multiply(cashBack)));			
//			activityGoodsDto.setMarketprice(activityGoodsDto.getProductprice().subtract(activityGoodsDto.getCashbackMax()));
			
			//activityGoodsDto.setMarketprice(Utils.formatBigDecimal(activityGoodsDto.getCostprice().multiply(new BigDecimal(1).add(platformProportion))));
			activityGoodsDto.setPrePay(activityGoodsDto.getPresellprice().subtract(activityGoodsDto.getCostprice()));	
			activityGoodsDto.setCashBackPercent(cashBack);
			activityGoodsDto.setCashbackMax(Utils.formatBigDecimal(activityGoodsDto.getPrePay().multiply(cashBack)));			
		}
	}

	public ImsEweiShopMerchUser getShopMerchUser(Long orderId) {
		if(orderId==null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopOrder order = shopOrderDao.selectByPrimaryKey(orderId);
		Long merchid = order.getMerchid();
		ImsEweiShopMerchUser shopMerchUser = eweiShopMerchUserMapper.selectByPrimaryKeyForComment(merchid);
		return shopMerchUser;
	}

	public void submitComment(ImsEweiShopOrderComment comment,Boolean isAnonymous) {
		Integer orderid = comment.getOrderid();
		if(orderid == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopOrder order = shopOrderDao.selectByPrimaryKey((long)orderid);
		if(order == null) {
			throw new BusinessException(EWarning.Order_NonExistent);
		}
		comment.setUniacid(order.getUniacid());
		comment.setMemberid(order.getMemberId());
		comment.setMerchid(order.getMerchid());
		
		List<ShopOrderGoodsDto> orderGoods = shopOrderGoodsDao.selectDtoByOrderId((long)orderid);
		if(orderGoods.size()>0) {
			comment.setGoodsid(orderGoods.get(0).getGoodsid().intValue());
		}
		Long memberId = order.getMemberId();
		ImsEweiShopMember member = memberDao.selectByPrimaryKey(memberId);
		comment.setOpenid(member.getOpenid());
		comment.setNickname(member.getNickname());
		if(isAnonymous) {
			comment.setNickname("匿名");
		}
		comment.setHeadimgurl(member.getAvatar());
		comment.setCreatetime(Utils.getCurrentTime());
		shopOrderCommentMapper.insertSelective(comment);
		
		order.setStatus(6);
		shopOrderDao.updateByPrimaryKeySelective(order);
	}
}
