package com.microsilver.mrcard.serviceplatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
@JsonInclude(value=Include.NON_NULL)
public class ImsSysAreaDto extends ImsSysArea {
	private Integer unicid;

	public ImsSysAreaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImsSysAreaDto(Integer unicid) {
		super();
		this.unicid = unicid;
	}

	public Integer getUnicid() {
		return unicid;
	}

	public void setUnicid(Integer unicid) {
		this.unicid = unicid;
	}

	@Override
	public String toString() {
		return "ImsSysAreaDto [unicid=" + unicid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((unicid == null) ? 0 : unicid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImsSysAreaDto other = (ImsSysAreaDto) obj;
		if (unicid == null) {
			if (other.unicid != null)
				return false;
		} else if (!unicid.equals(other.unicid))
			return false;
		return true;
	}
}
