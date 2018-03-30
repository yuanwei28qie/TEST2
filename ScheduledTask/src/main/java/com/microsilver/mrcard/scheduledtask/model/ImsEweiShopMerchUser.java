package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopMerchUser implements Serializable {

	private Integer id;

	private Integer uniacid;

	private Integer regid;

	private String openid;

	private Integer groupid;

	private String merchno;

	private String merchname;

	private String salecate;

	private String desc;

	private String realname;

	private String mobile;

	private Byte status;

	private Integer accounttime;

	private Integer applytime;

	private Integer accounttotal;

	private Integer jointime;

	private Integer accountid;

	private String logo;

	private String payopenid;

	private BigDecimal payrate;

	private Boolean isrecommand;

	private String servicestag;

	private Integer cateid;

	private String address;

	private String tel;

	private String lat;

	private String lng;

	private Float isPay;

	private Integer isShop;

	private Float code;

	private Integer isMill;

	private Integer catid;

	private Integer lv2;

	private Long province;

	private Long city;

	private Long county;

	private Long sendSms;

	private String pic1;

	private String pic2;

	private String publicitypic;
	
	private String idNo;

	private Long referee;

	private Integer isVip;

	private Integer shopType;

	private Integer pantnrType;

	private Long userId;

	private Float score;

	private Long counts;

	private Byte starLevel;

	private Integer beginTime;

	private Integer endTime;
	private Float lowestPrice;
	private Integer distance;
	private Integer comment;
	private Integer sortWeight;
	
	private Boolean supportBiaoshi;
	private Boolean supportPickUp;

	private String alipay;
	
	
	
	public Boolean getSupportBiaoshi() {
		return supportBiaoshi;
	}

	public void setSupportBiaoshi(Boolean supportBiaoshi) {
		this.supportBiaoshi = supportBiaoshi;
	}

	public Boolean getSupportPickUp() {
		return supportPickUp;
	}

	public void setSupportPickUp(Boolean supportPickUp) {
		this.supportPickUp = supportPickUp;
	}

	public Integer getSortWeight() {
		return sortWeight;
	}

	public void setSortWeight(Integer sortWeight) {
		this.sortWeight = sortWeight;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Long getCounts() {
		return counts;
	}

	public void setCounts(Long counts) {
		this.counts = counts;
	}

	public Byte getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(Byte starLevel) {
		this.starLevel = starLevel;
	}

	public Integer getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Float getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(Float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUniacid() {
		return uniacid;
	}

	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}

	public Integer getRegid() {
		return regid;
	}

	public void setRegid(Integer regid) {
		this.regid = regid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getMerchno() {
		return merchno;
	}

	public void setMerchno(String merchno) {
		this.merchno = merchno;
	}

	public String getMerchname() {
		return merchname;
	}

	public void setMerchname(String merchname) {
		this.merchname = merchname;
	}

	public String getSalecate() {
		return salecate;
	}

	public void setSalecate(String salecate) {
		this.salecate = salecate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getAccounttime() {
		return accounttime;
	}

	public void setAccounttime(Integer accounttime) {
		this.accounttime = accounttime;
	}

	public Integer getApplytime() {
		return applytime;
	}

	public void setApplytime(Integer applytime) {
		this.applytime = applytime;
	}

	public Integer getAccounttotal() {
		return accounttotal;
	}

	public void setAccounttotal(Integer accounttotal) {
		this.accounttotal = accounttotal;
	}

	public Integer getJointime() {
		return jointime;
	}

	public void setJointime(Integer jointime) {
		this.jointime = jointime;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPayopenid() {
		return payopenid;
	}

	public void setPayopenid(String payopenid) {
		this.payopenid = payopenid;
	}

	public BigDecimal getPayrate() {
		return payrate;
	}

	public void setPayrate(BigDecimal payrate) {
		this.payrate = payrate;
	}

	public Boolean getIsrecommand() {
		return isrecommand;
	}

	public void setIsrecommand(Boolean isrecommand) {
		this.isrecommand = isrecommand;
	}

	public String getServicestag() {
		return servicestag;
	}

	public void setServicestag(String servicestag) {
		this.servicestag = servicestag;
	}

	public Integer getCateid() {
		return cateid;
	}

	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Float getIsPay() {
		return isPay;
	}

	public void setIsPay(Float isPay) {
		this.isPay = isPay;
	}

	public Integer getIsShop() {
		return isShop;
	}

	public void setIsShop(Integer isShop) {
		this.isShop = isShop;
	}

	public Float getCode() {
		return code;
	}

	public void setCode(Float code) {
		this.code = code;
	}

	public Integer getIsMill() {
		return isMill;
	}

	public void setIsMill(Integer isMill) {
		this.isMill = isMill;
	}

	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}

	public Integer getLv2() {
		return lv2;
	}

	public void setLv2(Integer lv2) {
		this.lv2 = lv2;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public Long getCounty() {
		return county;
	}

	public void setCounty(Long county) {
		this.county = county;
	}

	public Long getSendSms() {
		return sendSms;
	}

	public void setSendSms(Long sendSms) {
		this.sendSms = sendSms;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPublicitypic() {
		return publicitypic;
	}

	public void setPublicitypic(String publicitypic) {
		this.publicitypic = publicitypic;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Long getReferee() {
		return referee;
	}

	public void setReferee(Long referee) {
		this.referee = referee;
	}

	public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	public Integer getPantnrType() {
		return pantnrType;
	}

	public void setPantnrType(Integer pantnrType) {
		this.pantnrType = pantnrType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	@Override
	public String toString() {
		return "ImsEweiShopMerchUser [id=" + id + ", uniacid=" + uniacid + ", regid=" + regid + ", openid=" + openid
				+ ", groupid=" + groupid + ", merchno=" + merchno + ", merchname=" + merchname + ", salecate="
				+ salecate + ", desc=" + desc + ", realname=" + realname + ", mobile=" + mobile + ", status=" + status
				+ ", accounttime=" + accounttime + ", applytime=" + applytime + ", accounttotal=" + accounttotal
				+ ", jointime=" + jointime + ", accountid=" + accountid + ", logo=" + logo + ", payopenid=" + payopenid
				+ ", payrate=" + payrate + ", isrecommand=" + isrecommand + ", servicestag=" + servicestag + ", cateid="
				+ cateid + ", address=" + address + ", tel=" + tel + ", lat=" + lat + ", lng=" + lng + ", isPay="
				+ isPay + ", isShop=" + isShop + ", code=" + code + ", isMill=" + isMill + ", catid=" + catid + ", lv2="
				+ lv2 + ", province=" + province + ", city=" + city + ", county=" + county + ", sendSms=" + sendSms
				+ ", pic1=" + pic1 + ", pic2=" + pic2 + ", publicitypic=" + publicitypic + ", idNo=" + idNo
				+ ", referee=" + referee + ", isVip=" + isVip + ", shopType=" + shopType + ", pantnrType=" + pantnrType
				+ ", userId=" + userId + ", score=" + score + ", counts=" + counts + ", starLevel=" + starLevel
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + ", lowestPrice=" + lowestPrice + ", distance="
				+ distance + "]";
	}
}