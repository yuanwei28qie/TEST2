package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopMerchRegWithBLOBs extends ImsEweiShopMerchReg implements Serializable {
    private String publicitypic;

    private String diyformdata;

    private String diyformfields;

    private String reason;

    private static final long serialVersionUID = 1L;

    public String getPublicitypic() {
        return publicitypic;
    }

    public void setPublicitypic(String publicitypic) {
        this.publicitypic = publicitypic;
    }

    public String getDiyformdata() {
        return diyformdata;
    }

    public void setDiyformdata(String diyformdata) {
        this.diyformdata = diyformdata;
    }

    public String getDiyformfields() {
        return diyformfields;
    }

    public void setDiyformfields(String diyformfields) {
        this.diyformfields = diyformfields;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        ImsEweiShopMerchRegWithBLOBs other = (ImsEweiShopMerchRegWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
            && (this.getMemberid() == null ? other.getMemberid() == null : this.getMemberid().equals(other.getMemberid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getCateid() == null ? other.getCateid() == null : this.getCateid().equals(other.getCateid()))
            && (this.getLv2() == null ? other.getLv2() == null : this.getLv2().equals(other.getLv2()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPayrate() == null ? other.getPayrate() == null : this.getPayrate().equals(other.getPayrate()))
            && (this.getIsPay() == null ? other.getIsPay() == null : this.getIsPay().equals(other.getIsPay()))
            && (this.getServicestag() == null ? other.getServicestag() == null : this.getServicestag().equals(other.getServicestag()))
            && (this.getMerchname() == null ? other.getMerchname() == null : this.getMerchname().equals(other.getMerchname()))
            && (this.getSalecate() == null ? other.getSalecate() == null : this.getSalecate().equals(other.getSalecate()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getApplytime() == null ? other.getApplytime() == null : this.getApplytime().equals(other.getApplytime()))
            && (this.getIdNo() == null ? other.getIdNo() == null : this.getIdNo().equals(other.getIdNo()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getPic2() == null ? other.getPic2() == null : this.getPic2().equals(other.getPic2()))
            && (this.getIsMill() == null ? other.getIsMill() == null : this.getIsMill().equals(other.getIsMill()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getPublicitypic() == null ? other.getPublicitypic() == null : this.getPublicitypic().equals(other.getPublicitypic()))
            && (this.getDiyformdata() == null ? other.getDiyformdata() == null : this.getDiyformdata().equals(other.getDiyformdata()))
            && (this.getDiyformfields() == null ? other.getDiyformfields() == null : this.getDiyformfields().equals(other.getDiyformfields()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getMemberid() == null) ? 0 : getMemberid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getCateid() == null) ? 0 : getCateid().hashCode());
        result = prime * result + ((getLv2() == null) ? 0 : getLv2().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPayrate() == null) ? 0 : getPayrate().hashCode());
        result = prime * result + ((getIsPay() == null) ? 0 : getIsPay().hashCode());
        result = prime * result + ((getServicestag() == null) ? 0 : getServicestag().hashCode());
        result = prime * result + ((getMerchname() == null) ? 0 : getMerchname().hashCode());
        result = prime * result + ((getSalecate() == null) ? 0 : getSalecate().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getApplytime() == null) ? 0 : getApplytime().hashCode());
        result = prime * result + ((getIdNo() == null) ? 0 : getIdNo().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getPic2() == null) ? 0 : getPic2().hashCode());
        result = prime * result + ((getIsMill() == null) ? 0 : getIsMill().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getPublicitypic() == null) ? 0 : getPublicitypic().hashCode());
        result = prime * result + ((getDiyformdata() == null) ? 0 : getDiyformdata().hashCode());
        result = prime * result + ((getDiyformfields() == null) ? 0 : getDiyformfields().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", publicitypic=").append(publicitypic);
        sb.append(", diyformdata=").append(diyformdata);
        sb.append(", diyformfields=").append(diyformfields);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}