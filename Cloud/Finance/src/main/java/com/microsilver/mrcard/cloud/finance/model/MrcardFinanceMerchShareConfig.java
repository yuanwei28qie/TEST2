package com.microsilver.mrcard.cloud.finance.model;

import java.io.Serializable;

public class MrcardFinanceMerchShareConfig implements Serializable {
    private Long id;

    private Byte identity;

    private Integer merchCateId;

    private Short proportion;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
    }

    public Integer getMerchCateId() {
        return merchCateId;
    }

    public void setMerchCateId(Integer merchCateId) {
        this.merchCateId = merchCateId;
    }

    public Short getProportion() {
        return proportion;
    }

    public void setProportion(Short proportion) {
        this.proportion = proportion;
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
        MrcardFinanceMerchShareConfig other = (MrcardFinanceMerchShareConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getMerchCateId() == null ? other.getMerchCateId() == null : this.getMerchCateId().equals(other.getMerchCateId()))
            && (this.getProportion() == null ? other.getProportion() == null : this.getProportion().equals(other.getProportion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getMerchCateId() == null) ? 0 : getMerchCateId().hashCode());
        result = prime * result + ((getProportion() == null) ? 0 : getProportion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", identity=").append(identity);
        sb.append(", merchCateId=").append(merchCateId);
        sb.append(", proportion=").append(proportion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}