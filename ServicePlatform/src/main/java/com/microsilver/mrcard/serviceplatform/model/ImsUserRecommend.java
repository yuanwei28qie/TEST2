package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsUserRecommend implements Serializable {
    private Long memberId;
    
    private Byte vipType;
    
    private Long areaCode;
    
    private String areaName;

    private Long level1ParentId;

    private Long level2ParentId;
    
    private Long rootId;

    /**
     * 会员服务开始时间
     */
    private Integer beginTime;
    
    private Integer batch;

    private static final long serialVersionUID = 1L;

    
    
    public void setVipType(Byte vipType) {
		this.vipType = vipType;
	}

	public Long getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}

	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

	public Byte getVipType() {
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
    

	public Integer getBatch() {
		return batch;
	}

	public void setBatch(Integer batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "ImsUserRecommend [memberId=" + memberId + ", vipType=" + vipType + ", areaCode=" + areaCode
				+ ", level1ParentId=" + level1ParentId + ", level2ParentId=" + level2ParentId + ", rootId=" + rootId
				+ ", beginTime=" + beginTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result + ((level1ParentId == null) ? 0 : level1ParentId.hashCode());
		result = prime * result + ((level2ParentId == null) ? 0 : level2ParentId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((rootId == null) ? 0 : rootId.hashCode());
		result = prime * result + vipType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImsUserRecommend other = (ImsUserRecommend) obj;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (level1ParentId == null) {
			if (other.level1ParentId != null)
				return false;
		} else if (!level1ParentId.equals(other.level1ParentId))
			return false;
		if (level2ParentId == null) {
			if (other.level2ParentId != null)
				return false;
		} else if (!level2ParentId.equals(other.level2ParentId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (rootId == null) {
			if (other.rootId != null)
				return false;
		} else if (!rootId.equals(other.rootId))
			return false;
		if (vipType != other.vipType)
			return false;
		return true;
	}

}