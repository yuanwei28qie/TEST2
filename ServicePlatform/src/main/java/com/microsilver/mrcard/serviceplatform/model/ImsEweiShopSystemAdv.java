package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopSystemAdv implements Serializable {
    private Integer id;

    private String title;

    private String thumb;

    private String appType;

    private Short advBits;

    private Byte objectType;

    private String objectValue;

    private Integer createtime;

    private Integer displayorder;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Short getAdvBits() {
        return advBits;
    }

    public void setAdvBits(Short advBits) {
        this.advBits = advBits;
    }

    public Byte getObjectType() {
        return objectType;
    }

    public void setObjectType(Byte objectType) {
        this.objectType = objectType;
    }

    public String getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(String objectValue) {
        this.objectValue = objectValue;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        ImsEweiShopSystemAdv other = (ImsEweiShopSystemAdv) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getThumb() == null ? other.getThumb() == null : this.getThumb().equals(other.getThumb()))
            && (this.getAppType() == null ? other.getAppType() == null : this.getAppType().equals(other.getAppType()))
            && (this.getAdvBits() == null ? other.getAdvBits() == null : this.getAdvBits().equals(other.getAdvBits()))
            && (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
            && (this.getObjectValue() == null ? other.getObjectValue() == null : this.getObjectValue().equals(other.getObjectValue()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDisplayorder() == null ? other.getDisplayorder() == null : this.getDisplayorder().equals(other.getDisplayorder()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getThumb() == null) ? 0 : getThumb().hashCode());
        result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
        result = prime * result + ((getAdvBits() == null) ? 0 : getAdvBits().hashCode());
        result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
        result = prime * result + ((getObjectValue() == null) ? 0 : getObjectValue().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDisplayorder() == null) ? 0 : getDisplayorder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", thumb=").append(thumb);
        sb.append(", appType=").append(appType);
        sb.append(", advBits=").append(advBits);
        sb.append(", objectType=").append(objectType);
        sb.append(", objectValue=").append(objectValue);
        sb.append(", createtime=").append(createtime);
        sb.append(", displayorder=").append(displayorder);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}