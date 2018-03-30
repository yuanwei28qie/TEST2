package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMerchImagesMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImages;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImagesExample;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;

@Service
public class ImsEweiShopMerchImagesService {
	@Resource
	ImsEweiShopMerchImagesMapper mapper;
	
	public List<ImsEweiShopMerchImages> getImsEweiShopMerchImagesByMerchId(Integer id){
		ImsEweiShopMerchImagesExample example = new ImsEweiShopMerchImagesExample();
		example.createCriteria().andMerchIdEqualTo((long)id);
		List<ImsEweiShopMerchImages> list = mapper.selectByExample(example);
		List<ImsSysDictionary> dics = DictionaryUtils.getDictionaryListByType("hotel_photo");
		for (ImsEweiShopMerchImages img : list) {
			for (ImsSysDictionary dic : dics) {
				if(dic.getValue().equals(img.getDictValue())){
					img.setTypeName(dic.getName());		
					break;
				}
			}
		}
		return list;
	}
}
