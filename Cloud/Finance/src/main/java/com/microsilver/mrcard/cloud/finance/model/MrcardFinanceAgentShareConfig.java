package com.microsilver.mrcard.cloud.finance.model;

import java.io.Serializable;

public class MrcardFinanceAgentShareConfig implements Serializable {
    private Long id;

    private String name;

    private String keyWord;

    private Short platformProportion;

    private Short provinceProportion;

    private Short cityProportion;

    private Short countyProportion;

    private Short warriorProportion;

    private Short knightProportion;

    private Short vipProportion;

    private Byte agentType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Short getPlatformProportion() {
        return platformProportion;
    }

    public void setPlatformProportion(Short platformProportion) {
        this.platformProportion = platformProportion;
    }

    public Short getProvinceProportion() {
        return provinceProportion;
    }

    public void setProvinceProportion(Short provinceProportion) {
        this.provinceProportion = provinceProportion;
    }

    public Short getCityProportion() {
        return cityProportion;
    }

    public void setCityProportion(Short cityProportion) {
        this.cityProportion = cityProportion;
    }

    public Short getCountyProportion() {
        return countyProportion;
    }

    public void setCountyProportion(Short countyProportion) {
        this.countyProportion = countyProportion;
    }

    public Short getWarriorProportion() {
        return warriorProportion;
    }

    public void setWarriorProportion(Short warriorProportion) {
        this.warriorProportion = warriorProportion;
    }

    public Short getKnightProportion() {
        return knightProportion;
    }

    public void setKnightProportion(Short knightProportion) {
        this.knightProportion = knightProportion;
    }

    public Short getVipProportion() {
        return vipProportion;
    }

    public void setVipProportion(Short vipProportion) {
        this.vipProportion = vipProportion;
    }

    public Byte getAgentType() {
        return agentType;
    }

    public void setAgentType(Byte agentType) {
        this.agentType = agentType;
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
        MrcardFinanceAgentShareConfig other = (MrcardFinanceAgentShareConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getKeyWord() == null ? other.getKeyWord() == null : this.getKeyWord().equals(other.getKeyWord()))
            && (this.getPlatformProportion() == null ? other.getPlatformProportion() == null : this.getPlatformProportion().equals(other.getPlatformProportion()))
            && (this.getProvinceProportion() == null ? other.getProvinceProportion() == null : this.getProvinceProportion().equals(other.getProvinceProportion()))
            && (this.getCityProportion() == null ? other.getCityProportion() == null : this.getCityProportion().equals(other.getCityProportion()))
            && (this.getCountyProportion() == null ? other.getCountyProportion() == null : this.getCountyProportion().equals(other.getCountyProportion()))
            && (this.getWarriorProportion() == null ? other.getWarriorProportion() == null : this.getWarriorProportion().equals(other.getWarriorProportion()))
            && (this.getKnightProportion() == null ? other.getKnightProportion() == null : this.getKnightProportion().equals(other.getKnightProportion()))
            && (this.getVipProportion() == null ? other.getVipProportion() == null : this.getVipProportion().equals(other.getVipProportion()))
            && (this.getAgentType() == null ? other.getAgentType() == null : this.getAgentType().equals(other.getAgentType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getKeyWord() == null) ? 0 : getKeyWord().hashCode());
        result = prime * result + ((getPlatformProportion() == null) ? 0 : getPlatformProportion().hashCode());
        result = prime * result + ((getProvinceProportion() == null) ? 0 : getProvinceProportion().hashCode());
        result = prime * result + ((getCityProportion() == null) ? 0 : getCityProportion().hashCode());
        result = prime * result + ((getCountyProportion() == null) ? 0 : getCountyProportion().hashCode());
        result = prime * result + ((getWarriorProportion() == null) ? 0 : getWarriorProportion().hashCode());
        result = prime * result + ((getKnightProportion() == null) ? 0 : getKnightProportion().hashCode());
        result = prime * result + ((getVipProportion() == null) ? 0 : getVipProportion().hashCode());
        result = prime * result + ((getAgentType() == null) ? 0 : getAgentType().hashCode());
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
        sb.append(", keyWord=").append(keyWord);
        sb.append(", platformProportion=").append(platformProportion);
        sb.append(", provinceProportion=").append(provinceProportion);
        sb.append(", cityProportion=").append(cityProportion);
        sb.append(", countyProportion=").append(countyProportion);
        sb.append(", warriorProportion=").append(warriorProportion);
        sb.append(", knightProportion=").append(knightProportion);
        sb.append(", vipProportion=").append(vipProportion);
        sb.append(", agentType=").append(agentType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}