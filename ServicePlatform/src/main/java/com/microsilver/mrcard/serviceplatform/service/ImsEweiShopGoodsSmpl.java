package com.microsilver.mrcard.serviceplatform.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopGoodsMapper;
import com.microsilver.mrcard.serviceplatform.dto.ShopGoodsDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopGoods;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopGoodsExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopGoodsExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class ImsEweiShopGoodsSmpl {

	@Resource
	private ImsEweiShopGoodsMapper eweiShopGoodsMapper;
	
    public List<ImsEweiShopGoods> selectByMerchId(Integer id){
    	ImsEweiShopGoodsExample example = new ImsEweiShopGoodsExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andMerchidEqualTo(id);
    	criteria.andStatusEqualTo((byte)1);
    	return eweiShopGoodsMapper.selectByExample(example);
    }
    public ImsEweiShopGoods selectByPrimaryKey(Long id){
    	ImsEweiShopGoods eweiShopGoods = eweiShopGoodsMapper.selectByPrimaryKey(id);
    	return eweiShopGoods;
    }
    public int mergeGoods(ImsEweiShopGoods record){
    	if(record.getId()!=null){
    		return eweiShopGoodsMapper.updateByPrimaryKeySelective(record);
    	}
    	return eweiShopGoodsMapper.insertSelective(record);
    }
	public List<ShopGoodsDto> getGoodsList(Integer merchId, Integer type,Integer pageNum) throws IllegalAccessException, InvocationTargetException {
		if (merchId == null || type == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopGoodsExample example = new ImsEweiShopGoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andMerchidEqualTo(merchId);
		PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		switch (type) {
		case 1:
			criteria.andStatusEqualTo(Consts.GOODS_STATUS_ONSALE).andCheckedEqualTo(Consts.GOODS_CHECKED_PASS)
					.andTotalGreaterThanOrEqualTo(1).andDeletedEqualTo(Consts.GOODS_DELETED_NO);
			break;
		case 2:
			criteria.andCheckedEqualTo(Consts.GOODS_CHECKED_AUDIT).andDeletedEqualTo(Consts.GOODS_DELETED_NO);
			example.setOrderByClause(" updatetime desc ");
			break;
		case 3:
			criteria.andStatusEqualTo(Consts.GOODS_STATUS_ONSALE).andCheckedEqualTo(Consts.GOODS_CHECKED_PASS).andDeletedEqualTo(Consts.GOODS_DELETED_NO)
			.andTotalEqualTo(0);			
			break;
		case 4:
			criteria.andStatusEqualTo(Consts.GOODS_STATUS_UNDERCARRIAGE).andCheckedEqualTo(Consts.GOODS_CHECKED_PASS).andDeletedEqualTo(Consts.GOODS_DELETED_NO);
			break;
		case 5:
			criteria.andDeletedEqualTo(Consts.GOODS_DELETED_YES);
			break;

		default:
			break;
		}
		List<ImsEweiShopGoods> shopGoodsList = eweiShopGoodsMapper.selectByExample(example);
		List<ShopGoodsDto> goodsDto = new ArrayList<>();
		for (ImsEweiShopGoods shopGoods : shopGoodsList) {
			ShopGoodsDto dto = new ShopGoodsDto();
			BeanUtils.copyProperties(dto, shopGoods);
			goodsDto.add(dto);
		}
		return goodsDto;
	}
	public List<ImsEweiShopGoods> getCheckFailedGoods(Integer merchId) {
		ImsEweiShopGoodsExample example = new ImsEweiShopGoodsExample();
		example.createCriteria().andStatusEqualTo(Consts.GOODS_STATUS_CHECKEDFAILED).andMerchidEqualTo(merchId);
		List<ImsEweiShopGoods> list = eweiShopGoodsMapper.selectByExample(example);
		return list;
	}
	public int changeGoodsStatus(ImsEweiShopGoods goods) {
		int result = eweiShopGoodsMapper.updateByPrimaryKeySelective(goods);
		return result;
	}
	
	public ShopGoodsDto getGoodsById(Integer id) throws Exception {
		ImsEweiShopGoods shopGoods = eweiShopGoodsMapper.selectByPrimaryKey((long)id);
		ShopGoodsDto dto = new ShopGoodsDto();
		BeanUtils.copyProperties(dto, shopGoods);
		return dto;
	}
	
	public int deleteGoodsById(Integer id) {
		return eweiShopGoodsMapper.deleteByPrimaryKey(id);
	}
}
