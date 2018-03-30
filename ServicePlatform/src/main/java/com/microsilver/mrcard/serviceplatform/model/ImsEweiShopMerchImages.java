package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopMerchImages implements Serializable {
    private Long id;

    private Long merchId;

    private Integer dictValue;

    private String url;

    private String typeName;
    
    private static final long serialVersionUID = 1L;
    

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public Integer getDictValue() {
        return dictValue;
    }

    public void setDictValue(Integer dictValue) {
        this.dictValue = dictValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	@Override
	public String toString() {
		return "ImsEweiShopMerchImages [id=" + id + ", merchId=" + merchId + ", dictValue=" + dictValue + ", url=" + url
				+ ", typeName=" + typeName + "]";
	}

}