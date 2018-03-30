package com.microsilver.mrcard.serviceplatform.model;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchAccount
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年6月28
 * @Copyright Micro Silver
 *
 */
import java.io.Serializable;

public class ImsEweiShopMerchAccount implements Serializable {
	private Integer id;

	private Integer uniacid;

	private String openid;

	private Integer merchid;

	private String username;

	private String pwd;

	private String salt;

	private Byte status;

	private Byte isfounder;

	private String lastip;

	private String lastvisit;

	private Integer roleid;

	private String idNo;

	private String pic;

	private Long province;

	private Long city;

	private Long county;

	private String perms;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUniacid() {
		return uniacid;
	}

	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getMerchid() {
		return merchid;
	}

	public void setMerchid(Integer merchid) {
		this.merchid = merchid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getIsfounder() {
		return isfounder;
	}

	public void setIsfounder(Byte isfounder) {
		this.isfounder = isfounder;
	}

	public String getLastip() {
		return lastip;
	}

	public void setLastip(String lastip) {
		this.lastip = lastip;
	}

	public String getLastvisit() {
		return lastvisit;
	}

	public void setLastvisit(String lastvisit) {
		this.lastvisit = lastvisit;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public Long getCounty() {
		return county;
	}

	public void setCounty(Long county) {
		this.county = county;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
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
		ImsEweiShopMerchAccount other = (ImsEweiShopMerchAccount) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUniacid() == null ? other.getUniacid() == null
						: this.getUniacid().equals(other.getUniacid()))
				&& (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
				&& (this.getMerchid() == null ? other.getMerchid() == null
						: this.getMerchid().equals(other.getMerchid()))
				&& (this.getUsername() == null ? other.getUsername() == null
						: this.getUsername().equals(other.getUsername()))
				&& (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
				&& (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getIsfounder() == null ? other.getIsfounder() == null
						: this.getIsfounder().equals(other.getIsfounder()))
				&& (this.getLastip() == null ? other.getLastip() == null : this.getLastip().equals(other.getLastip()))
				&& (this.getLastvisit() == null ? other.getLastvisit() == null
						: this.getLastvisit().equals(other.getLastvisit()))
				&& (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
				&& (this.getIdNo() == null ? other.getIdNo() == null : this.getIdNo().equals(other.getIdNo()))
				&& (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
				&& (this.getProvince() == null ? other.getProvince() == null
						: this.getProvince().equals(other.getProvince()))
				&& (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
				&& (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
				&& (this.getPerms() == null ? other.getPerms() == null : this.getPerms().equals(other.getPerms()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
		result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
		result = prime * result + ((getMerchid() == null) ? 0 : getMerchid().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
		result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getIsfounder() == null) ? 0 : getIsfounder().hashCode());
		result = prime * result + ((getLastip() == null) ? 0 : getLastip().hashCode());
		result = prime * result + ((getLastvisit() == null) ? 0 : getLastvisit().hashCode());
		result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
		result = prime * result + ((getIdNo() == null) ? 0 : getIdNo().hashCode());
		result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
		result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
		result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
		result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
		result = prime * result + ((getPerms() == null) ? 0 : getPerms().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", uniacid=").append(uniacid);
		sb.append(", openid=").append(openid);
		sb.append(", merchid=").append(merchid);
		sb.append(", username=").append(username);
		sb.append(", pwd=").append(pwd);
		sb.append(", salt=").append(salt);
		sb.append(", status=").append(status);
		sb.append(", isfounder=").append(isfounder);
		sb.append(", lastip=").append(lastip);
		sb.append(", lastvisit=").append(lastvisit);
		sb.append(", roleid=").append(roleid);
		sb.append(", idNo=").append(idNo);
		sb.append(", pic=").append(pic);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", county=").append(county);
		sb.append(", perms=").append(perms);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}