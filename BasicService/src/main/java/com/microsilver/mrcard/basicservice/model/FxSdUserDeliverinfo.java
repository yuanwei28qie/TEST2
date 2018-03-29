package com.microsilver.mrcard.basicservice.model;

import java.util.Arrays;

public class FxSdUserDeliverinfo {
    private Long id;

    private String mobile;

    private String pwd;

    private String salt;

    private String realname;

    private String avatar;

    private Byte sex;

    private String address;

    private String alipayAccount;

    private String identityCardNo;

    private String identityCardFront;

    private String identityCardBack;

    private String identityCardGroup;

    private Integer createTime;

    private Byte checkStatus;

    @Override
	public String toString() {
		return "FxSdUserDeliverinfo [id=" + id + ", mobile=" + mobile + ", pwd=" + pwd + ", salt=" + salt
				+ ", realname=" + realname + ", avatar=" + avatar + ", sex=" + sex + ", address=" + address
				+ ", alipayAccount=" + alipayAccount + ", identityCardNo=" + identityCardNo + ", identityCardFront="
				+ identityCardFront + ", identityCardBack=" + identityCardBack + ", identityCardGroup="
				+ identityCardGroup + ", createTime=" + createTime + ", checkStatus=" + checkStatus + ", province="
				+ province + ", city=" + city + ", county=" + county + ", remark=" + remark + ", otherphoneno="
				+ otherphoneno + ", occupation=" + occupation + ", identifier=" + identifier + ", imToken=" + imToken
				+ ", referee=" + referee + ", financeId=" + financeId + ", token=" + Arrays.toString(token) + "]";
	}

	private Long province;

    private Long city;

    private Long county;

    private String remark;

    private String otherphoneno;

    private String occupation;

    private String identifier;

    private String imToken;

    private Long referee;

    private Long financeId;

    private byte[] token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo == null ? null : identityCardNo.trim();
    }

    public String getIdentityCardFront() {
        return identityCardFront;
    }

    public void setIdentityCardFront(String identityCardFront) {
        this.identityCardFront = identityCardFront == null ? null : identityCardFront.trim();
    }

    public String getIdentityCardBack() {
        return identityCardBack;
    }

    public void setIdentityCardBack(String identityCardBack) {
        this.identityCardBack = identityCardBack == null ? null : identityCardBack.trim();
    }

    public String getIdentityCardGroup() {
        return identityCardGroup;
    }

    public void setIdentityCardGroup(String identityCardGroup) {
        this.identityCardGroup = identityCardGroup == null ? null : identityCardGroup.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOtherphoneno() {
        return otherphoneno;
    }

    public void setOtherphoneno(String otherphoneno) {
        this.otherphoneno = otherphoneno == null ? null : otherphoneno.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken == null ? null : imToken.trim();
    }

    public Long getReferee() {
        return referee;
    }

    public void setReferee(Long referee) {
        this.referee = referee;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }
}