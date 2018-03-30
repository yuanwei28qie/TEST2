package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopActivityConfig implements Serializable {
    private Long id;

    private Integer activityId;

    private Long merchId;

    private Integer beginTime;

    private Integer endTime;

    private Boolean isAutoRelease;

    private BigDecimal lowestPrice;

    private BigDecimal cashbackMax;
    
    private Integer executeBegin;
    private Integer executeEnd;
    
	private String activity;
	private Integer total;
    
    private BigDecimal minCostprice;
    private BigDecimal maxCostprice;
    private BigDecimal maxPresellprice;
    private BigDecimal minZeroCostprice;
    private BigDecimal maxZeroCostprice;
    private BigDecimal maxZeroPresellprice;

    
    public BigDecimal getMaxPresellprice() {
		return maxPresellprice;
	}

	public void setMaxPresellprice(BigDecimal maxPresellprice) {
		this.maxPresellprice = maxPresellprice;
	}

	public BigDecimal getMaxZeroPresellprice() {
		return maxZeroPresellprice;
	}

	public void setMaxZeroPresellprice(BigDecimal maxZeroPresellprice) {
		this.maxZeroPresellprice = maxZeroPresellprice;
	}

	public BigDecimal getMinCostprice() {
		return minCostprice;
	}

	public void setMinCostprice(BigDecimal minCostprice) {
		this.minCostprice = minCostprice;
	}

	public BigDecimal getMaxCostprice() {
		return maxCostprice;
	}

	public void setMaxCostprice(BigDecimal maxCostprice) {
		this.maxCostprice = maxCostprice;
	}

	public BigDecimal getMinZeroCostprice() {
		return minZeroCostprice;
	}

	public void setMinZeroCostprice(BigDecimal minZeroCostprice) {
		this.minZeroCostprice = minZeroCostprice;
	}

	public BigDecimal getMaxZeroCostprice() {
		return maxZeroCostprice;
	}

	public void setMaxZeroCostprice(BigDecimal maxZeroCostprice) {
		this.maxZeroCostprice = maxZeroCostprice;
	}

	public Integer getExecuteBegin() {
		return executeBegin;
	}

	public void setExecuteBegin(Integer executeBegin) {
		this.executeBegin = executeBegin;
	}

	public Integer getExecuteEnd() {
		return executeEnd;
	}

	public void setExecuteEnd(Integer executeEnd) {
		this.executeEnd = executeEnd;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsAutoRelease() {
        return isAutoRelease;
    }

    public void setIsAutoRelease(Boolean isAutoRelease) {
        this.isAutoRelease = isAutoRelease;
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getCashbackMax() {
        return cashbackMax;
    }

    public void setCashbackMax(BigDecimal cashbackMax) {
        this.cashbackMax = cashbackMax;
    }

	@Override
	public String toString() {
		return "ImsEweiShopActivityConfig [id=" + id + ", activityId=" + activityId + ", merchId=" + merchId
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + ", isAutoRelease=" + isAutoRelease
				+ ", lowestPrice=" + lowestPrice + ", cashbackMax=" + cashbackMax + ", executeBegin=" + executeBegin
				+ ", executeEnd=" + executeEnd + ", activity=" + activity + ", total=" + total + ", minCostprice="
				+ minCostprice + ", maxCostprice=" + maxCostprice + ", maxPresellprice=" + maxPresellprice
				+ ", minZeroCostprice=" + minZeroCostprice + ", maxZeroCostprice=" + maxZeroCostprice
				+ ", maxZeroPresellprice=" + maxZeroPresellprice + "]";
	}
}