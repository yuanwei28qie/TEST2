package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopMemberCollection implements Serializable {
    private Integer id;

    private Long memberId;

    private Byte identity;

    private Byte collecType;

    private Long collecObjectId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Byte getCollecType() {
        return collecType;
    }

    public void setCollecType(Byte collecType) {
        this.collecType = collecType;
    }

    public Long getCollecObjectId() {
        return collecObjectId;
    }

    public void setCollecObjectId(Long collecObjectId) {
        this.collecObjectId = collecObjectId;
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
        ImsEweiShopMemberCollection other = (ImsEweiShopMemberCollection) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getCollecType() == null ? other.getCollecType() == null : this.getCollecType().equals(other.getCollecType()))
            && (this.getCollecObjectId() == null ? other.getCollecObjectId() == null : this.getCollecObjectId().equals(other.getCollecObjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getCollecType() == null) ? 0 : getCollecType().hashCode());
        result = prime * result + ((getCollecObjectId() == null) ? 0 : getCollecObjectId().hashCode());
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
        sb.append(", identity=").append(identity);
        sb.append(", collecType=").append(collecType);
        sb.append(", collecObjectId=").append(collecObjectId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}