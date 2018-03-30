package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "APP版本管理实体类")
@JsonInclude(value=Include.NON_NULL)
public class ImsAppVersion implements Serializable {
	private Long id;
	@ApiModelProperty("APP类型1:卡先生消费者版本2:卡先生商家版3:卡先生雇员版4:超级订消费者版")
	private Integer appType;
	
	@ApiModelProperty("终端类型(1:android,2:ios)")
	private Byte clientType;
	
	@ApiModelProperty("版本号")
	private String version;
	
	@ApiModelProperty("版本编号")
	private Integer code;

	@ApiModelProperty("是否强制更新")
	private Byte isForce;

	@ApiModelProperty("更新说明")
	private String description;

	@ApiModelProperty("下载地址")
	private String downAddress;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAppType() {
		return appType;
	}

	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	public Byte getClientType() {
		return clientType;
	}

	public void setClientType(Byte clientType) {
		this.clientType = clientType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Byte getIsForce() {
		return isForce;
	}

	public void setIsForce(Byte isForce) {
		this.isForce = isForce;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDownAddress() {
		return downAddress;
	}

	public void setDownAddress(String downAddress) {
		this.downAddress = downAddress;
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
		ImsAppVersion other = (ImsAppVersion) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getAppType() == null ? other.getAppType() == null
						: this.getAppType().equals(other.getAppType()))
				&& (this.getClientType() == null ? other.getClientType() == null
						: this.getClientType().equals(other.getClientType()))
				&& (this.getVersion() == null ? other.getVersion() == null
						: this.getVersion().equals(other.getVersion()))
				&& (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
				&& (this.getIsForce() == null ? other.getIsForce() == null
						: this.getIsForce().equals(other.getIsForce()))
				&& (this.getDescription() == null ? other.getDescription() == null
						: this.getDescription().equals(other.getDescription()))
				&& (this.getDownAddress() == null ? other.getDownAddress() == null
						: this.getDownAddress().equals(other.getDownAddress()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
		result = prime * result + ((getClientType() == null) ? 0 : getClientType().hashCode());
		result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
		result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
		result = prime * result + ((getIsForce() == null) ? 0 : getIsForce().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getDownAddress() == null) ? 0 : getDownAddress().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", appType=").append(appType);
		sb.append(", clientType=").append(clientType);
		sb.append(", version=").append(version);
		sb.append(", code=").append(code);
		sb.append(", isForce=").append(isForce);
		sb.append(", description=").append(description);
		sb.append(", downAddress=").append(downAddress);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}