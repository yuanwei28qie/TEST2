package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopMemberAdditional implements Serializable {
    private Long memberId;

    private String avatar;

    private String realname;

    private String alipayAccount;

    private String identityCardNo;

    private String identityCardFront;

    private String identityCardBack;

    private String identityCardGroup;

    private Integer createTime;
/**
 * 审核状态(0:审核未通过,1:待审核,2:已审核)
 */
    private Byte checkStatus;

    private Long province;

    private Long city;

    private Long county;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getIdentityCardFront() {
        return identityCardFront;
    }

    public void setIdentityCardFront(String identityCardFront) {
        this.identityCardFront = identityCardFront;
    }

    public String getIdentityCardBack() {
        return identityCardBack;
    }

    public void setIdentityCardBack(String identityCardBack) {
        this.identityCardBack = identityCardBack;
    }

    public String getIdentityCardGroup() {
        return identityCardGroup;
    }

    public void setIdentityCardGroup(String identityCardGroup) {
        this.identityCardGroup = identityCardGroup;
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
        this.remark = remark;
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
        ImsEweiShopMemberAdditional other = (ImsEweiShopMemberAdditional) that;
        return (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getAlipayAccount() == null ? other.getAlipayAccount() == null : this.getAlipayAccount().equals(other.getAlipayAccount()))
            && (this.getIdentityCardNo() == null ? other.getIdentityCardNo() == null : this.getIdentityCardNo().equals(other.getIdentityCardNo()))
            && (this.getIdentityCardFront() == null ? other.getIdentityCardFront() == null : this.getIdentityCardFront().equals(other.getIdentityCardFront()))
            && (this.getIdentityCardBack() == null ? other.getIdentityCardBack() == null : this.getIdentityCardBack().equals(other.getIdentityCardBack()))
            && (this.getIdentityCardGroup() == null ? other.getIdentityCardGroup() == null : this.getIdentityCardGroup().equals(other.getIdentityCardGroup()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getAlipayAccount() == null) ? 0 : getAlipayAccount().hashCode());
        result = prime * result + ((getIdentityCardNo() == null) ? 0 : getIdentityCardNo().hashCode());
        result = prime * result + ((getIdentityCardFront() == null) ? 0 : getIdentityCardFront().hashCode());
        result = prime * result + ((getIdentityCardBack() == null) ? 0 : getIdentityCardBack().hashCode());
        result = prime * result + ((getIdentityCardGroup() == null) ? 0 : getIdentityCardGroup().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", avatar=").append(avatar);
        sb.append(", realname=").append(realname);
        sb.append(", alipayAccount=").append(alipayAccount);
        sb.append(", identityCardNo=").append(identityCardNo);
        sb.append(", identityCardFront=").append(identityCardFront);
        sb.append(", identityCardBack=").append(identityCardBack);
        sb.append(", identityCardGroup=").append(identityCardGroup);
        sb.append(", createTime=").append(createTime);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}