package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopMerchConfig implements Serializable {
    private Long merchId;

    private BigDecimal cjtjPlatformProportion;

    private BigDecimal cjtjCashbackProportion;

    private BigDecimal ldbjPlatformProportion;

    private BigDecimal ldbjCashbackProportion;

    private BigDecimal xsdPlatformProportion;

    private BigDecimal xsdCashbackProportio;

    private static final long serialVersionUID = 1L;

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public BigDecimal getCjtjPlatformProportion() {
        return cjtjPlatformProportion;
    }

    public void setCjtjPlatformProportion(BigDecimal cjtjPlatformProportion) {
        this.cjtjPlatformProportion = cjtjPlatformProportion;
    }

    public BigDecimal getCjtjCashbackProportion() {
        return cjtjCashbackProportion;
    }

    public void setCjtjCashbackProportion(BigDecimal cjtjCashbackProportion) {
        this.cjtjCashbackProportion = cjtjCashbackProportion;
    }

    public BigDecimal getLdbjPlatformProportion() {
        return ldbjPlatformProportion;
    }

    public void setLdbjPlatformProportion(BigDecimal ldbjPlatformProportion) {
        this.ldbjPlatformProportion = ldbjPlatformProportion;
    }

    public BigDecimal getLdbjCashbackProportion() {
        return ldbjCashbackProportion;
    }

    public void setLdbjCashbackProportion(BigDecimal ldbjCashbackProportion) {
        this.ldbjCashbackProportion = ldbjCashbackProportion;
    }

    public BigDecimal getXsdPlatformProportion() {
        return xsdPlatformProportion;
    }

    public void setXsdPlatformProportion(BigDecimal xsdPlatformProportion) {
        this.xsdPlatformProportion = xsdPlatformProportion;
    }

    public BigDecimal getXsdCashbackProportio() {
        return xsdCashbackProportio;
    }

    public void setXsdCashbackProportio(BigDecimal xsdCashbackProportio) {
        this.xsdCashbackProportio = xsdCashbackProportio;
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
        ImsEweiShopMerchConfig other = (ImsEweiShopMerchConfig) that;
        return (this.getMerchId() == null ? other.getMerchId() == null : this.getMerchId().equals(other.getMerchId()))
            && (this.getCjtjPlatformProportion() == null ? other.getCjtjPlatformProportion() == null : this.getCjtjPlatformProportion().equals(other.getCjtjPlatformProportion()))
            && (this.getCjtjCashbackProportion() == null ? other.getCjtjCashbackProportion() == null : this.getCjtjCashbackProportion().equals(other.getCjtjCashbackProportion()))
            && (this.getLdbjPlatformProportion() == null ? other.getLdbjPlatformProportion() == null : this.getLdbjPlatformProportion().equals(other.getLdbjPlatformProportion()))
            && (this.getLdbjCashbackProportion() == null ? other.getLdbjCashbackProportion() == null : this.getLdbjCashbackProportion().equals(other.getLdbjCashbackProportion()))
            && (this.getXsdPlatformProportion() == null ? other.getXsdPlatformProportion() == null : this.getXsdPlatformProportion().equals(other.getXsdPlatformProportion()))
            && (this.getXsdCashbackProportio() == null ? other.getXsdCashbackProportio() == null : this.getXsdCashbackProportio().equals(other.getXsdCashbackProportio()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMerchId() == null) ? 0 : getMerchId().hashCode());
        result = prime * result + ((getCjtjPlatformProportion() == null) ? 0 : getCjtjPlatformProportion().hashCode());
        result = prime * result + ((getCjtjCashbackProportion() == null) ? 0 : getCjtjCashbackProportion().hashCode());
        result = prime * result + ((getLdbjPlatformProportion() == null) ? 0 : getLdbjPlatformProportion().hashCode());
        result = prime * result + ((getLdbjCashbackProportion() == null) ? 0 : getLdbjCashbackProportion().hashCode());
        result = prime * result + ((getXsdPlatformProportion() == null) ? 0 : getXsdPlatformProportion().hashCode());
        result = prime * result + ((getXsdCashbackProportio() == null) ? 0 : getXsdCashbackProportio().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merchId=").append(merchId);
        sb.append(", cjtjPlatformProportion=").append(cjtjPlatformProportion);
        sb.append(", cjtjCashbackProportion=").append(cjtjCashbackProportion);
        sb.append(", ldbjPlatformProportion=").append(ldbjPlatformProportion);
        sb.append(", ldbjCashbackProportion=").append(ldbjCashbackProportion);
        sb.append(", xsdPlatformProportion=").append(xsdPlatformProportion);
        sb.append(", xsdCashbackProportio=").append(xsdCashbackProportio);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}