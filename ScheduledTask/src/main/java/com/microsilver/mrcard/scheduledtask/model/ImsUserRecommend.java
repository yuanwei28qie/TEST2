package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;

public class ImsUserRecommend implements Serializable {
    private Long memberId;

    
    
    private byte vipType;

    private Long level1ParentId;

    private Long level2ParentId;
    
    private Long rootId;

    private Integer beginTime;
    
    private byte isSettlement;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public byte getVipType() {
		return vipType;
	}

	public void setVipType(byte vipType) {
		this.vipType = vipType;
	}

	public Long getLevel1ParentId() {
        return level1ParentId;
    }

    public void setLevel1ParentId(Long level1ParentId) {
        this.level1ParentId = level1ParentId;
    }

    public Long getLevel2ParentId() {
        return level2ParentId;
    }

    public void setLevel2ParentId(Long level2ParentId) {
        this.level2ParentId = level2ParentId;
    }
    
    public Long getRootId() {
		return rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

	public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public byte getIsSettlement() {
		return isSettlement;
	}

	public void setIsSettlement(byte isSettlement) {
		this.isSettlement = isSettlement;
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
        ImsUserRecommend other = (ImsUserRecommend) that;
        return (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            
            && (this.getLevel1ParentId() == null ? other.getLevel1ParentId() == null : this.getLevel1ParentId().equals(other.getLevel1ParentId()))
            && (this.getLevel2ParentId() == null ? other.getLevel2ParentId() == null : this.getLevel2ParentId().equals(other.getLevel2ParentId()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        
        result = prime * result + ((getLevel1ParentId() == null) ? 0 : getLevel1ParentId().hashCode());
        result = prime * result + ((getLevel2ParentId() == null) ? 0 : getLevel2ParentId().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", level1ParentId=").append(level1ParentId);
        sb.append(", level2ParentId=").append(level2ParentId);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}