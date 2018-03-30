package com.microsilver.mrcard.serviceplatform.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivity;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionaryExample;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopActivityService;
import com.microsilver.mrcard.serviceplatform.service.ImsSysAreaSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsSysDictionarySmpl;

@Component
public class DictionaryUtils implements InitializingBean{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private ImsSysAreaSmpl areaSmpl;
	@Resource
	ImsSysDictionarySmpl dictionarySmpl;
	
	@Resource
	ImsEweiShopActivityService shopActivityService;


	private static Map<Long, ImsSysArea> areaMap = new HashMap<>();
	private static Map<Integer, ImsEweiShopActivity> activityMap = new HashMap<>();
	private static Map<String,List<ImsSysDictionary>> dictionaryMap = new HashMap<>();
	private static List<ImsSysArea> imsSysAreas = new ArrayList<>();
	
	public static List<ImsSysArea> getSysAreas() {
		return imsSysAreas;
	}
	public static Map<Long, ImsSysArea> getAreaMap() {
		return areaMap;
	}
	public static Map<Integer, ImsEweiShopActivity> getActivityMap() {
		return activityMap;
	}
	public static List<ImsSysDictionary> getDictionaryListByType(String type){
		return dictionaryMap.get(type);
	}
	public void afterPropertiesSet() throws Exception {
		logger.info("----------------系统初始化开始---------------------");
        // 获取特定包下所有的类(包括接口和类)  
        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName("com.microsilver.mrcard.serviceplatform.controller.api");  
        //输出所有使用了特定注解的类的注解值  
        AnnotationUtil.validAnnotation(clsList);  
        logger.info("加载授权接口：{}个",clsList.size());
		
		imsSysAreas = areaSmpl.getAllArea();
		for (ImsSysArea imsSysArea : imsSysAreas) {
			areaMap.put(imsSysArea.getCode(), imsSysArea);
		}
		logger.info("加载区域信息:{}条",imsSysAreas.size());
		logger.info("加载业务数据字典...");
		List<ImsEweiShopActivity> shopActivities = shopActivityService.listShopActivity();
		for (ImsEweiShopActivity sa : shopActivities) {
			activityMap.put(sa.getId(), sa);
		}
		List<ImsSysDictionary> list = dictionarySmpl.selectByExample(new ImsSysDictionaryExample());
		List<ImsSysDictionary> identity = new ArrayList<>();
		List<ImsSysDictionary> star_level = new ArrayList<>();
		List<ImsSysDictionary> shop_tags = new ArrayList<>();
		List<ImsSysDictionary> hotel_goods_tags = new ArrayList<>();
		List<ImsSysDictionary> hotel_type = new ArrayList<>();
		List<ImsSysDictionary> hotel_photo = new ArrayList<>();
		List<ImsSysDictionary> hotel_brand = new ArrayList<>();
		List<ImsSysDictionary> buy_label = new ArrayList<>();
		for (ImsSysDictionary dictionary : list) {
			if(dictionary.getCode().equals("identity")){
				identity.add(dictionary);
			}else if(dictionary.getCode().equals("star_level")){
				star_level.add(dictionary);
			}else if(dictionary.getCode().equals("hotel_tags")){
				shop_tags.add(dictionary);
			}else if(dictionary.getCode().equals("hotel_goods_tags")){
				hotel_goods_tags.add(dictionary);
			}else if(dictionary.getCode().equals("hotel_type")){
				hotel_type.add(dictionary);
			}else if(dictionary.getCode().equals("hotel_photo")){
				hotel_photo.add(dictionary);
			}else if(dictionary.getCode().equals("hotel_brand")){
				hotel_brand.add(dictionary);
			}else if("buy_label".equals(dictionary.getCode())){
				buy_label.add(dictionary);
			}
		}
		dictionaryMap.put("identity", identity);
		dictionaryMap.put("star_level", star_level);
		dictionaryMap.put("hotel_tags", shop_tags);		
		dictionaryMap.put("hotel_goods_tags", hotel_goods_tags);		
		dictionaryMap.put("hotel_type", hotel_type);		
		dictionaryMap.put("hotel_photo", hotel_photo);
		dictionaryMap.put("hotel_brand", hotel_brand);
		dictionaryMap.put("buy_label", buy_label);
		logger.info("----------------系统初始化结束---------------------");
	}
}
