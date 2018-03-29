package com.microsilver.mrcard.basicservice.model;

import java.io.Serializable;

public class FxCategory implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String title;

    private Integer pid;

    private Integer sort;

    private Byte listRow;

    private String metaTitle;

    private String keywords;

    private String description;

    private String templateIndex;

    private String templateLists;

    private String templateDetail;

    private String templateEdit;

    private String model;

    private String type;

    private Integer linkId;

    private Byte allowPublish;

    private Byte display;

    private Byte reply;

    private Byte check;

    private String replyModel;

    private Integer createTime;

    private Integer updateTime;

    private Byte status;

    private Integer icon;

    private String extend;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getListRow() {
        return listRow;
    }

    public void setListRow(Byte listRow) {
        this.listRow = listRow;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle == null ? null : metaTitle.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTemplateIndex() {
        return templateIndex;
    }

    public void setTemplateIndex(String templateIndex) {
        this.templateIndex = templateIndex == null ? null : templateIndex.trim();
    }

    public String getTemplateLists() {
        return templateLists;
    }

    public void setTemplateLists(String templateLists) {
        this.templateLists = templateLists == null ? null : templateLists.trim();
    }

    public String getTemplateDetail() {
        return templateDetail;
    }

    public void setTemplateDetail(String templateDetail) {
        this.templateDetail = templateDetail == null ? null : templateDetail.trim();
    }

    public String getTemplateEdit() {
        return templateEdit;
    }

    public void setTemplateEdit(String templateEdit) {
        this.templateEdit = templateEdit == null ? null : templateEdit.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Byte getAllowPublish() {
        return allowPublish;
    }

    public void setAllowPublish(Byte allowPublish) {
        this.allowPublish = allowPublish;
    }

    public Byte getDisplay() {
        return display;
    }

    public void setDisplay(Byte display) {
        this.display = display;
    }

    public Byte getReply() {
        return reply;
    }

    public void setReply(Byte reply) {
        this.reply = reply;
    }

    public Byte getCheck() {
        return check;
    }

    public void setCheck(Byte check) {
        this.check = check;
    }

    public String getReplyModel() {
        return replyModel;
    }

    public void setReplyModel(String replyModel) {
        this.replyModel = replyModel == null ? null : replyModel.trim();
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

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }
}