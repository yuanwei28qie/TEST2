package com.microsilver.mrcard.serviceplatform.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.ImsUserRecommendMapper;
import com.microsilver.mrcard.serviceplatform.dto.ImsUserRecommendDto;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommendExample;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommendExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.enums.EVIPType;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class ImsUserRecommendService {
	@Resource
	ImsUserRecommendMapper recommendMapper;
	@Resource
	ImsSysAreaSmpl area;
	
	public ImsUserRecommend selectByPrimaryKey(Long memberId) {
		if (memberId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return recommendMapper.selectByPrimaryKey(memberId);
	}

	public Map<String, Object> getMyPartner(Long memberId) {
		if (memberId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		Map<String, Object> partnerGroup = new HashMap<>();
		List<ImsUserRecommendDto> lv1Partner = new ArrayList<>();
		List<ImsUserRecommendDto> lv2Partner = new ArrayList<>();
		List<ImsUserRecommendDto> lv1Vip = new ArrayList<>();
		List<ImsUserRecommendDto> lv2Vip = new ArrayList<>();
		List<ImsUserRecommendDto> userRecommendDtos = recommendMapper.selectPartner(memberId);
		for (ImsUserRecommendDto imsUserRecommendDto : userRecommendDtos) {
			if (imsUserRecommendDto.getVipType() >= 1) {
				if (imsUserRecommendDto.getLevel1ParentId().equals(memberId)) {
					lv1Partner.add(imsUserRecommendDto);
				}
				if (imsUserRecommendDto.getLevel2ParentId().equals(memberId)) {
					lv2Partner.add(imsUserRecommendDto);
				}
			} else {
				if (imsUserRecommendDto.getLevel1ParentId().equals(memberId)) {
					lv1Vip.add(imsUserRecommendDto);
				}
				if (imsUserRecommendDto.getLevel2ParentId().equals(memberId)) {
					lv2Vip.add(imsUserRecommendDto);
				}
			}
		}
		ImsUserRecommend recommend = this.selectByPrimaryKey(memberId);
		EVIPType[] values = EVIPType.values();
		for (EVIPType evipType : values) {
			if (evipType.getValue() == recommend.getVipType()) {
				partnerGroup.put("vipTypeChinese", evipType.getCname());
				partnerGroup.put("vipTypeEnglish", evipType.getName());
				partnerGroup.put("authorization", evipType.getName()+(String.valueOf(recommend.getAreaCode()).substring(0, 2))+memberId);
				break;
			}
		}
		partnerGroup.put("vipType", recommend.getVipType());

		partnerGroup.put("area", recommend.getAreaName());
		partnerGroup.put("lv1Partner", lv1Partner.size());
		partnerGroup.put("lv2Partner", lv2Partner.size());
		partnerGroup.put("lv1Vip", lv1Vip.size());
		partnerGroup.put("lv2Vip", lv2Vip.size());
		return partnerGroup;
	}

	public List<ImsUserRecommendDto> getMyPartnerByType(Long memberId, Byte type, Byte vipType,String keyWords, Integer pageNum) {
		if (memberId == null || type == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		ImsUserRecommendExample example = new ImsUserRecommendExample();
		Criteria criteria = example.createCriteria();
		switch (type) {
		case 1:
			criteria.andVipTypeGreaterThanOrEqualTo((byte) 1).andLevel1ParentIdEqualTo(memberId);
			break;
		case 2:
			criteria.andVipTypeGreaterThanOrEqualTo((byte) 1).andLevel2ParentIdEqualTo(memberId);
			break;
		case 3:
			criteria.andVipTypeEqualTo((byte) 0).andLevel1ParentIdEqualTo(memberId);
			break;
		case 4:
			criteria.andVipTypeEqualTo((byte) 0).andLevel2ParentIdEqualTo(memberId);
			break;
		default:
			break;
		}
		if(vipType!=null) {
			criteria.andVipTypeEqualTo(vipType);
		}
		if(keyWords!=null&&!keyWords.equals("")) {
			criteria.andNickNameOrMobileLike(keyWords);
		}
		List<ImsUserRecommendDto> list = recommendMapper.selectPartnerByExample(example);
		for (ImsUserRecommendDto dto : list) {
			if (dto.getBeginTime() == null) {
				dto.setBeginTime(dto.getCreatetime());
			}
			EVIPType[] values = EVIPType.values();
			for (EVIPType evipType : values) {
				if (evipType.getValue() == dto.getVipType()) {
					dto.setVipTypeName(evipType.getName());
					break;
				}
			}
		}

		return list;
	}
	
	public int countByArea(Long areaCode,byte vipType) {
		ImsUserRecommendExample example = new ImsUserRecommendExample();
		example.createCriteria().andVipTypeEqualTo(vipType).andAreaCodeEqualTo1(areaCode);
		return recommendMapper.countByExample(example);
	}

	public void changeArea(ImsUserRecommend recommend, Long areaCode) {
		if (recommend == null || areaCode == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		//向上递归获取完整地址
		String areaStr = area.recursionUpwardByCode(areaCode,new StringBuffer(""));
		recommendMapper.updateByPrimaryKeySelective(new ImsUserRecommend() {
			private static final long serialVersionUID = 1L;
			{
				this.setMemberId(recommend.getMemberId());
				this.setAreaCode(areaCode);
				this.setAreaName(areaStr);
				this.setBatch(Consts.PARTER_CURRENT_BATCH);
			}
		});
		
		/*
		 * 修改areaCode后要重新计算缓存里面的新与旧区域对应的合伙人数量
		 * 如果有旧的区域则合伙人数量 -1
		 * 新区域直接数量+1
		 */
		Long oldAreaCode = recommend.getAreaCode(); //就得区域值
		Map<Long, ImsSysArea> areaMap = DictionaryUtils.getAreaMap();
		if(oldAreaCode!=null) {
			ImsSysArea imsSysArea = areaMap.get(oldAreaCode);
			imsSysArea.setCounts(imsSysArea.getCounts()-1);
		}
		ImsSysArea imsSysArea = areaMap.get(areaCode);
		imsSysArea.setCounts(imsSysArea.getCounts()+1);
	}
}
