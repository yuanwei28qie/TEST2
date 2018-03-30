package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsSysResources implements Serializable {
    private Integer id;

    private Integer pid;

    private String name;

    private String title;

    private String icon;

    private Boolean type;

    private Boolean status;

    private String condition;

    private Boolean islink;

    private Integer o;

    private String tips;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Boolean getIslink() {
        return islink;
    }

    public void setIslink(Boolean islink) {
        this.islink = islink;
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
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
        ImsSysResources other = (ImsSysResources) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCondition() == null ? other.getCondition() == null : this.getCondition().equals(other.getCondition()))
            && (this.getIslink() == null ? other.getIslink() == null : this.getIslink().equals(other.getIslink()))
            && (this.getO() == null ? other.getO() == null : this.getO().equals(other.getO()))
            && (this.getTips() == null ? other.getTips() == null : this.getTips().equals(other.getTips()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCondition() == null) ? 0 : getCondition().hashCode());
        result = prime * result + ((getIslink() == null) ? 0 : getIslink().hashCode());
        result = prime * result + ((getO() == null) ? 0 : getO().hashCode());
        result = prime * result + ((getTips() == null) ? 0 : getTips().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", condition=").append(condition);
        sb.append(", islink=").append(islink);
        sb.append(", o=").append(o);
        sb.append(", tips=").append(tips);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}