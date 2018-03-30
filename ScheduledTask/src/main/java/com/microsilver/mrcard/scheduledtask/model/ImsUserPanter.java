package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;

public class ImsUserPanter implements Serializable {
    private Long id;

    private Long userId;

    private Integer isVip;

    private Integer shopType;

    private Integer pantnrType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        ImsUserPanter other = (ImsUserPanter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIsVip() == null ? other.getIsVip() == null : this.getIsVip().equals(other.getIsVip()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getPantnrType() == null ? other.getPantnrType() == null : this.getPantnrType().equals(other.getPantnrType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIsVip() == null) ? 0 : getIsVip().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getPantnrType() == null) ? 0 : getPantnrType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", isVip=").append(isVip);
        sb.append(", shopType=").append(shopType);
        sb.append(", pantnrType=").append(pantnrType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}