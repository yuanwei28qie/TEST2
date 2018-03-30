package com.microsilver.mrcard.serviceplatform.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ImsEweiShopMemberDevice implements Serializable {
    private Long id;

    private Long memberId;

    private Long merchId;

    private Byte identity;

    @ApiModelProperty("终端类型(1:android,2:ios)")
    private Byte device;
    @ApiModelProperty("APP类型\n" +
            "            1:卡先生消费者版本 \n" +
            "            2:卡先生商家版\n" +
            "            3:卡先生雇员版\n" +
            "            4:超级订消费者版" +
            "            5:小飞侠")
    private Byte appName;
    @ApiModelProperty("应用对应版本号")
    private String appVersion;
    @ApiModelProperty("推送注册Id")
    private String registration;
    @ApiModelProperty("推送设置tags")
    private String tags;
    @ApiModelProperty("推送设置alias")
    private String alias;

    private Integer createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
    }

    public Byte getDevice() {
        return device;
    }

    public void setDevice(Byte device) {
        this.device = device;
    }

    public Byte getAppName() {
        return appName;
    }

    public void setAppName(Byte appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
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
        ImsEweiShopMemberDevice other = (ImsEweiShopMemberDevice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMerchId() == null ? other.getMerchId() == null : this.getMerchId().equals(other.getMerchId()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getDevice() == null ? other.getDevice() == null : this.getDevice().equals(other.getDevice()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getAppVersion() == null ? other.getAppVersion() == null : this.getAppVersion().equals(other.getAppVersion()))
            && (this.getRegistration() == null ? other.getRegistration() == null : this.getRegistration().equals(other.getRegistration()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMerchId() == null) ? 0 : getMerchId().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getDevice() == null) ? 0 : getDevice().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getAppVersion() == null) ? 0 : getAppVersion().hashCode());
        result = prime * result + ((getRegistration() == null) ? 0 : getRegistration().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", merchId=").append(merchId);
        sb.append(", identity=").append(identity);
        sb.append(", device=").append(device);
        sb.append(", appName=").append(appName);
        sb.append(", appVersion=").append(appVersion);
        sb.append(", registration=").append(registration);
        sb.append(", tags=").append(tags);
        sb.append(", alias=").append(alias);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}