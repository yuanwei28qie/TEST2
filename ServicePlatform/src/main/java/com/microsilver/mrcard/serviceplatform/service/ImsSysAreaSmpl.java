package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsSysAreaMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsUnicidMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsSysAreaExample;
import com.microsilver.mrcard.serviceplatform.model.ImsSysAreaExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.ImsUnicid;
import com.microsilver.mrcard.serviceplatform.model.ImsUnicidExample;

@Service
public class ImsSysAreaSmpl {

	@Resource
	private ImsSysAreaMapper areaMapper;	
	@Resource
	private ImsUnicidMapper imsUnicidMapper;
	
	public List<ImsSysArea> getAllArea(){
		ImsSysAreaExample areaExample = new ImsSysAreaExample();
		List<ImsSysArea> sysAreas = areaMapper.selectByExampleWithCounts(areaExample);
		return sysAreas;
	}
	
	public List<ImsSysArea> getAllSubArea(Long parentCode){
		ImsSysAreaExample areaExample = new ImsSysAreaExample();
		Criteria criteria = areaExample.createCriteria();
		criteria.andParentCodeEqualTo(parentCode);
		List<ImsSysArea> sysAreas = areaMapper.selectByExample(areaExample);
		return sysAreas;
	}
	
	public List<ImsUnicid> getAllImsUnicid(){
		ImsUnicidExample example = new ImsUnicidExample();
		List<ImsUnicid> list = imsUnicidMapper.selectByExample(example);
		return list;
	}
	
	public ImsUnicid getImsUnicidByCountry(Long countryCode){
		ImsUnicidExample example = new ImsUnicidExample();
		com.microsilver.mrcard.serviceplatform.model.ImsUnicidExample.Criteria criteria = example.createCriteria();
		criteria.andCountyEqualTo(countryCode);
		List<ImsUnicid> imsUnicids = imsUnicidMapper.selectByExample(example);
		if(imsUnicids.size()>0)
			return imsUnicids.get(0);
		return null;
	}

	public String recursionUpwardByCode(Long areaCode,StringBuffer area) {
		if(areaCode==null||areaCode==0) {
			return "";
		}
		ImsSysAreaExample example = new ImsSysAreaExample();
		example.createCriteria().andCodeEqualTo(areaCode);
		List<ImsSysArea> areas = areaMapper.selectByExample(example);
		ImsSysArea imsSysArea = areas.get(0);
		area.insert(0,imsSysArea.getName());
		recursionUpwardByCode(imsSysArea.getParentCode(),area);
		return area.toString();
	}
}
