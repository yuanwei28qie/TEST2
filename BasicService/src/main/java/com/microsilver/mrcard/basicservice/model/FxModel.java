package com.microsilver.mrcard.basicservice.model;

import java.io.Serializable;

public class FxModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String title;

    private Integer extend;

    private String relation;

    private Boolean needPk;

    private String fieldGroup;

    private String templateList;

    private String templateAdd;

    private String templateEdit;

    private Short listRow;

    private String searchKey;

    private String searchList;

    private Integer createTime;

    private Integer updateTime;

    private Byte status;

    private String engineType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getExtend() {
        return extend;
    }

    public void setExtend(Integer extend) {
        this.extend = extend;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public Boolean getNeedPk() {
        return needPk;
    }

    public void setNeedPk(Boolean needPk) {
        this.needPk = needPk;
    }

    public String getFieldGroup() {
        return fieldGroup;
    }

    public void setFieldGroup(String fieldGroup) {
        this.fieldGroup = fieldGroup == null ? null : fieldGroup.trim();
    }

    public String getTemplateList() {
        return templateList;
    }

    public void setTemplateList(String templateList) {
        this.templateList = templateList == null ? null : templateList.trim();
    }

    public String getTemplateAdd() {
        return templateAdd;
    }

    public void setTemplateAdd(String templateAdd) {
        this.templateAdd = templateAdd == null ? null : templateAdd.trim();
    }

    public String getTemplateEdit() {
        return templateEdit;
    }

    public void setTemplateEdit(String templateEdit) {
        this.templateEdit = templateEdit == null ? null : templateEdit.trim();
    }

    public Short getListRow() {
        return listRow;
    }

    public void setListRow(Short listRow) {
        this.listRow = listRow;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public String getSearchList() {
        return searchList;
    }

    public void setSearchList(String searchList) {
        this.searchList = searchList == null ? null : searchList.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType == null ? null : engineType.trim();
    }
}