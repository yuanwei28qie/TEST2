package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "商品分类")
public class ImsEweiShopCategory implements Serializable {
	@ApiModelProperty("分类id")
	private Integer id;

	private Integer uniacid;

	@ApiModelProperty("分类名称")
	private String name;

	private String thumb;

	@ApiModelProperty("上级分类id")
	private Integer parentid;

	private Integer isrecommand;

	private String description;

	private Byte displayorder;

	private Byte enabled;

	private Byte ishome;

	private Byte level;

	private String advimg;

	private String advurl;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getIsrecommand() {
		return isrecommand;
	}

	public void setIsrecommand(Integer isrecommand) {
		this.isrecommand = isrecommand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(Byte displayorder) {
		this.displayorder = displayorder;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public Byte getIshome() {
		return ishome;
	}

	public void setIshome(Byte ishome) {
		this.ishome = ishome;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public String getAdvimg() {
		return advimg;
	}

	public void setAdvimg(String advimg) {
		this.advimg = advimg;
	}

	public String getAdvurl() {
		return advurl;
	}

	public void setAdvurl(String advurl) {
		this.advurl = advurl;
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
		ImsEweiShopCategory other = (ImsEweiShopCategory) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUniacid() == null ? other.getUniacid() == null
						: this.getUniacid().equals(other.getUniacid()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getThumb() == null ? other.getThumb() == null : this.getThumb().equals(other.getThumb()))
				&& (this.getParentid() == null ? other.getParentid() == null
						: this.getParentid().equals(other.getParentid()))
				&& (this.getIsrecommand() == null ? other.getIsrecommand() == null
						: this.getIsrecommand().equals(other.getIsrecommand()))
				&& (this.getDescription() == null ? other.getDescription() == null
						: this.getDescription().equals(other.getDescription()))
				&& (this.getDisplayorder() == null ? other.getDisplayorder() == null
						: this.getDisplayorder().equals(other.getDisplayorder()))
				&& (this.getEnabled() == null ? other.getEnabled() == null
						: this.getEnabled().equals(other.getEnabled()))
				&& (this.getIshome() == null ? other.getIshome() == null : this.getIshome().equals(other.getIshome()))
				&& (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
				&& (this.getAdvimg() == null ? other.getAdvimg() == null : this.getAdvimg().equals(other.getAdvimg()))
				&& (this.getAdvurl() == null ? other.getAdvurl() == null : this.getAdvurl().equals(other.getAdvurl()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getThumb() == null) ? 0 : getThumb().hashCode());
		result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
		result = prime * result + ((getIsrecommand() == null) ? 0 : getIsrecommand().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getDisplayorder() == null) ? 0 : getDisplayorder().hashCode());
		result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
		result = prime * result + ((getIshome() == null) ? 0 : getIshome().hashCode());
		result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
		result = prime * result + ((getAdvimg() == null) ? 0 : getAdvimg().hashCode());
		result = prime * result + ((getAdvurl() == null) ? 0 : getAdvurl().hashCode());
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
		sb.append(", name=").append(name);
		sb.append(", thumb=").append(thumb);
		sb.append(", parentid=").append(parentid);
		sb.append(", isrecommand=").append(isrecommand);
		sb.append(", description=").append(description);
		sb.append(", displayorder=").append(displayorder);
		sb.append(", enabled=").append(enabled);
		sb.append(", ishome=").append(ishome);
		sb.append(", level=").append(level);
		sb.append(", advimg=").append(advimg);
		sb.append(", advurl=").append(advurl);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}