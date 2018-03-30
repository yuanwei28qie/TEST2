package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopMerchReg implements Serializable {
    private Integer id;

    private Integer uniacid;

    private Integer memberid;

    private String openid;

    private Integer cateid;

    private Integer lv2;

    private String tel;

    private String lat;

    private String lng;

    private String address;

    private Integer payrate;

    private BigDecimal isPay;

    private String publicitypic;

    private String servicestag;

    private String merchname;

    private String salecate;

    private String desc;

    private String realname;

    private String mobile;

    private Byte status;

    private Integer applytime;

    private String idNo;

    private String pic;

    private String pic2;

    private Integer isMill;

    private Long province;

    private Long city;

    private Long county;

    private Short identity;

    private Integer shopType;

    private Integer brandId;

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

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public Integer getLv2() {
        return lv2;
    }

    public void setLv2(Integer lv2) {
        this.lv2 = lv2;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPayrate() {
        return payrate;
    }

    public void setPayrate(Integer payrate) {
        this.payrate = payrate;
    }

    public BigDecimal getIsPay() {
        return isPay;
    }

    public void setIsPay(BigDecimal isPay) {
        this.isPay = isPay;
    }

    public String getPublicitypic() {
        return publicitypic;
    }

    public void setPublicitypic(String publicitypic) {
        this.publicitypic = publicitypic;
    }

    public String getServicestag() {
        return servicestag;
    }

    public void setServicestag(String servicestag) {
        this.servicestag = servicestag;
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

    public Integer getApplytime() {
        return applytime;
    }

    public void setApplytime(Integer applytime) {
        this.applytime = applytime;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public Integer getIsMill() {
        return isMill;
    }

    public void setIsMill(Integer isMill) {
        this.isMill = isMill;
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

    public Short getIdentity() {
        return identity;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ImsEweiShopMerchReg other = (ImsEweiShopMerchReg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
                && (this.getMemberid() == null ? other.getMemberid() == null : this.getMemberid().equals(other.getMemberid()))
                && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
                && (this.getCateid() == null ? other.getCateid() == null : this.getCateid().equals(other.getCateid()))
                && (this.getLv2() == null ? other.getLv2() == null : this.getLv2().equals(other.getLv2()))
                && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
                && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
                && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getPayrate() == null ? other.getPayrate() == null : this.getPayrate().equals(other.getPayrate()))
                && (this.getIsPay() == null ? other.getIsPay() == null : this.getIsPay().equals(other.getIsPay()))
                && (this.getPublicitypic() == null ? other.getPublicitypic() == null : this.getPublicitypic().equals(other.getPublicitypic()))
                && (this.getServicestag() == null ? other.getServicestag() == null : this.getServicestag().equals(other.getServicestag()))
                && (this.getMerchname() == null ? other.getMerchname() == null : this.getMerchname().equals(other.getMerchname()))
                && (this.getSalecate() == null ? other.getSalecate() == null : this.getSalecate().equals(other.getSalecate()))
                && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
                && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
                && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getApplytime() == null ? other.getApplytime() == null : this.getApplytime().equals(other.getApplytime()))
                && (this.getIdNo() == null ? other.getIdNo() == null : this.getIdNo().equals(other.getIdNo()))
                && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
                && (this.getPic2() == null ? other.getPic2() == null : this.getPic2().equals(other.getPic2()))
                && (this.getIsMill() == null ? other.getIsMill() == null : this.getIsMill().equals(other.getIsMill()))
                && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
                && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
                && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
                && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
                && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
                && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getMemberid() == null) ? 0 : getMemberid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getCateid() == null) ? 0 : getCateid().hashCode());
        result = prime * result + ((getLv2() == null) ? 0 : getLv2().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPayrate() == null) ? 0 : getPayrate().hashCode());
        result = prime * result + ((getIsPay() == null) ? 0 : getIsPay().hashCode());
        result = prime * result + ((getPublicitypic() == null) ? 0 : getPublicitypic().hashCode());
        result = prime * result + ((getServicestag() == null) ? 0 : getServicestag().hashCode());
        result = prime * result + ((getMerchname() == null) ? 0 : getMerchname().hashCode());
        result = prime * result + ((getSalecate() == null) ? 0 : getSalecate().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getApplytime() == null) ? 0 : getApplytime().hashCode());
        result = prime * result + ((getIdNo() == null) ? 0 : getIdNo().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getPic2() == null) ? 0 : getPic2().hashCode());
        result = prime * result + ((getIsMill() == null) ? 0 : getIsMill().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uniacid=").append(uniacid);
        sb.append(", memberid=").append(memberid);
        sb.append(", openid=").append(openid);
        sb.append(", cateid=").append(cateid);
        sb.append(", lv2=").append(lv2);
        sb.append(", tel=").append(tel);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", address=").append(address);
        sb.append(", payrate=").append(payrate);
        sb.append(", isPay=").append(isPay);
        sb.append(", publicitypic=").append(publicitypic);
        sb.append(", servicestag=").append(servicestag);
        sb.append(", merchname=").append(merchname);
        sb.append(", salecate=").append(salecate);
        sb.append(", desc=").append(desc);
        sb.append(", realname=").append(realname);
        sb.append(", mobile=").append(mobile);
        sb.append(", status=").append(status);
        sb.append(", applytime=").append(applytime);
        sb.append(", idNo=").append(idNo);
        sb.append(", pic=").append(pic);
        sb.append(", pic2=").append(pic2);
        sb.append(", isMill=").append(isMill);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", identity=").append(identity);
        sb.append(", shopType=").append(shopType);
        sb.append(", brandId=").append(brandId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}