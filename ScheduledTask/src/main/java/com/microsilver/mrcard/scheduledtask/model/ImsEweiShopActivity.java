package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopActivity implements Serializable {
    private Integer id;

    private String name;

    private BigDecimal platformProportion;

    private BigDecimal cashbackProportion;

    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPlatformProportion() {
        return platformProportion;
    }

    public void setPlatformProportion(BigDecimal platformProportion) {
        this.platformProportion = platformProportion;
    }

    public BigDecimal getCashbackProportion() {
        return cashbackProportion;
    }

    public void setCashbackProportion(BigDecimal cashbackProportion) {
        this.cashbackProportion = cashbackProportion;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
        ImsEweiShopActivity other = (ImsEweiShopActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPlatformProportion() == null ? other.getPlatformProportion() == null : this.getPlatformProportion().equals(other.getPlatformProportion()))
            && (this.getCashbackProportion() == null ? other.getCashbackProportion() == null : this.getCashbackProportion().equals(other.getCashbackProportion()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPlatformProportion() == null) ? 0 : getPlatformProportion().hashCode());
        result = prime * result + ((getCashbackProportion() == null) ? 0 : getCashbackProportion().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", platformProportion=").append(platformProportion);
        sb.append(", cashbackProportion=").append(cashbackProportion);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}