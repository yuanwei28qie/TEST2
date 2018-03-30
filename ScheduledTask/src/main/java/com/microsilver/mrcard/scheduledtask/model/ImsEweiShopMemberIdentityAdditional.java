package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopMemberIdentityAdditional implements Serializable {
    private Long idttId;

    private Long memberId;

    private Byte identity;

    private String lat;

    private String lng;

    private BigDecimal score;

    private Boolean isWork;

    private static final long serialVersionUID = 1L;

    public Long getIdttId() {
        return idttId;
    }

    public void setIdttId(Long idttId) {
        this.idttId = idttId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
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

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Boolean getIsWork() {
        return isWork;
    }

    public void setIsWork(Boolean isWork) {
        this.isWork = isWork;
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
        ImsEweiShopMemberIdentityAdditional other = (ImsEweiShopMemberIdentityAdditional) that;
        return (this.getIdttId() == null ? other.getIdttId() == null : this.getIdttId().equals(other.getIdttId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getIsWork() == null ? other.getIsWork() == null : this.getIsWork().equals(other.getIsWork()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdttId() == null) ? 0 : getIdttId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getIsWork() == null) ? 0 : getIsWork().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idttId=").append(idttId);
        sb.append(", memberId=").append(memberId);
        sb.append(", identity=").append(identity);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", score=").append(score);
        sb.append(", isWork=").append(isWork);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}