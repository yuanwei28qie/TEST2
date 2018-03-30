package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopAdv implements Serializable {
    private Integer id;

    private Integer uniacid;

    private String advname;

    private String link;

    private String thumb;

    private Integer displayorder;

    private Integer enabled;

    private Integer shopid;

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

    public String getAdvname() {
        return advname;
    }

    public void setAdvname(String advname) {
        this.advname = advname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
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
        ImsEweiShopAdv other = (ImsEweiShopAdv) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
            && (this.getAdvname() == null ? other.getAdvname() == null : this.getAdvname().equals(other.getAdvname()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getThumb() == null ? other.getThumb() == null : this.getThumb().equals(other.getThumb()))
            && (this.getDisplayorder() == null ? other.getDisplayorder() == null : this.getDisplayorder().equals(other.getDisplayorder()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()))
            && (this.getShopid() == null ? other.getShopid() == null : this.getShopid().equals(other.getShopid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getAdvname() == null) ? 0 : getAdvname().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getThumb() == null) ? 0 : getThumb().hashCode());
        result = prime * result + ((getDisplayorder() == null) ? 0 : getDisplayorder().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        result = prime * result + ((getShopid() == null) ? 0 : getShopid().hashCode());
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
        sb.append(", advname=").append(advname);
        sb.append(", link=").append(link);
        sb.append(", thumb=").append(thumb);
        sb.append(", displayorder=").append(displayorder);
        sb.append(", enabled=").append(enabled);
        sb.append(", shopid=").append(shopid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}