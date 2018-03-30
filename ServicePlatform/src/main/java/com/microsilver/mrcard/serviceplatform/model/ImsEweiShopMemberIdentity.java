package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ImsEweiShopMemberIdentity implements Serializable {
    private Long id;

    private Long memberId;

    @ApiModelProperty(value = "用户身份(11:平台运营人员,12:快递员,14:超级订商户员工,21:超级订商户)")
    private Byte identity;

    private Integer createtime;

    private Long merchId;

    private String name;

    private Long parentId;

    private Byte status;

    private String areas;
    
    private String rongcloudToken;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    

    public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMerchId() {
		return merchId;
	}

	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

	public String getRongcloudToken() {
		return rongcloudToken;
	}

	public void setRongcloudToken(String rongcloudToken) {
		this.rongcloudToken = rongcloudToken;
	}

	@Override
	public String toString() {
		return "ImsEweiShopMemberIdentity [id=" + id + ", memberid=" + memberId + ", identity=" + identity
				+ ", createtime=" + createtime + ", merchid=" + merchId + ", name=" + name + ", parentId=" + parentId
				+ ", status=" + status + ", areas=" + areas + ", rongcloudToken=" + rongcloudToken + "]";
	}
}