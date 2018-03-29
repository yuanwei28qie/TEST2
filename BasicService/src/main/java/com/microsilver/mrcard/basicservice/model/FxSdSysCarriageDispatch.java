package com.microsilver.mrcard.basicservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class FxSdSysCarriageDispatch implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long areaCode;

    private BigDecimal basePrice;

    private Byte baseMileage;

    private Short beginTime;

    private Short endTime;

    private BigDecimal nightMarkup;

    private BigDecimal mileageMarkup;

    private BigDecimal specialMarkup;

    private BigDecimal weightMarkup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Long areaCode) {
        this.areaCode = areaCode;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Byte getBaseMileage() {
        return baseMileage;
    }

    public void setBaseMileage(Byte baseMileage) {
        this.baseMileage = baseMileage;
    }

    public Short getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Short beginTime) {
        this.beginTime = beginTime;
    }

    public Short getEndTime() {
        return endTime;
    }

    public void setEndTime(Short endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getNightMarkup() {
        return nightMarkup;
    }

    public void setNightMarkup(BigDecimal nightMarkup) {
        this.nightMarkup = nightMarkup;
    }

    public BigDecimal getMileageMarkup() {
        return mileageMarkup;
    }

    public void setMileageMarkup(BigDecimal mileageMarkup) {
        this.mileageMarkup = mileageMarkup;
    }

    public BigDecimal getSpecialMarkup() {
        return specialMarkup;
    }

    public void setSpecialMarkup(BigDecimal specialMarkup) {
        this.specialMarkup = specialMarkup;
    }

    public BigDecimal getWeightMarkup() {
        return weightMarkup;
    }

    public void setWeightMarkup(BigDecimal weightMarkup) {
        this.weightMarkup = weightMarkup;
    }
}