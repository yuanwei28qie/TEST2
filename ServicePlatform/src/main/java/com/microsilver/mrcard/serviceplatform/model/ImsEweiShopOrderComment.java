package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;

public class ImsEweiShopOrderComment implements Serializable {
    private Integer id;

    private Integer uniacid;

    private Integer orderid;

    private Integer goodsid;

    private String openid;

    private String nickname;

    private String headimgurl;

    private Float level;

    private String content;

    private String images;

    private Integer createtime;

    private Byte deleted;

    private String appendContent;

    private String appendImages;

    private String replyContent;

    private String replyImages;

    private String appendReplyContent;

    private String appendReplyImages;

    private Byte istop;

    private Byte checked;

    private Byte replychecked;

    private Long merchid;

    private Long memberid;

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

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Float getLevel() {
        return level;
    }

    public void setLevel(Float level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public String getAppendContent() {
        return appendContent;
    }

    public void setAppendContent(String appendContent) {
        this.appendContent = appendContent;
    }

    public String getAppendImages() {
        return appendImages;
    }

    public void setAppendImages(String appendImages) {
        this.appendImages = appendImages;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyImages() {
        return replyImages;
    }

    public void setReplyImages(String replyImages) {
        this.replyImages = replyImages;
    }

    public String getAppendReplyContent() {
        return appendReplyContent;
    }

    public void setAppendReplyContent(String appendReplyContent) {
        this.appendReplyContent = appendReplyContent;
    }

    public String getAppendReplyImages() {
        return appendReplyImages;
    }

    public void setAppendReplyImages(String appendReplyImages) {
        this.appendReplyImages = appendReplyImages;
    }

    public Byte getIstop() {
        return istop;
    }

    public void setIstop(Byte istop) {
        this.istop = istop;
    }

    public Byte getChecked() {
        return checked;
    }

    public void setChecked(Byte checked) {
        this.checked = checked;
    }

    public Byte getReplychecked() {
        return replychecked;
    }

    public void setReplychecked(Byte replychecked) {
        this.replychecked = replychecked;
    }

    public Long getMerchid() {
        return merchid;
    }

    public void setMerchid(Long merchid) {
        this.merchid = merchid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
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
        ImsEweiShopOrderComment other = (ImsEweiShopOrderComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getGoodsid() == null ? other.getGoodsid() == null : this.getGoodsid().equals(other.getGoodsid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getHeadimgurl() == null ? other.getHeadimgurl() == null : this.getHeadimgurl().equals(other.getHeadimgurl()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getImages() == null ? other.getImages() == null : this.getImages().equals(other.getImages()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getAppendContent() == null ? other.getAppendContent() == null : this.getAppendContent().equals(other.getAppendContent()))
            && (this.getAppendImages() == null ? other.getAppendImages() == null : this.getAppendImages().equals(other.getAppendImages()))
            && (this.getReplyContent() == null ? other.getReplyContent() == null : this.getReplyContent().equals(other.getReplyContent()))
            && (this.getReplyImages() == null ? other.getReplyImages() == null : this.getReplyImages().equals(other.getReplyImages()))
            && (this.getAppendReplyContent() == null ? other.getAppendReplyContent() == null : this.getAppendReplyContent().equals(other.getAppendReplyContent()))
            && (this.getAppendReplyImages() == null ? other.getAppendReplyImages() == null : this.getAppendReplyImages().equals(other.getAppendReplyImages()))
            && (this.getIstop() == null ? other.getIstop() == null : this.getIstop().equals(other.getIstop()))
            && (this.getChecked() == null ? other.getChecked() == null : this.getChecked().equals(other.getChecked()))
            && (this.getReplychecked() == null ? other.getReplychecked() == null : this.getReplychecked().equals(other.getReplychecked()))
            && (this.getMerchid() == null ? other.getMerchid() == null : this.getMerchid().equals(other.getMerchid()))
            && (this.getMemberid() == null ? other.getMemberid() == null : this.getMemberid().equals(other.getMemberid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getGoodsid() == null) ? 0 : getGoodsid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getHeadimgurl() == null) ? 0 : getHeadimgurl().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getImages() == null) ? 0 : getImages().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getAppendContent() == null) ? 0 : getAppendContent().hashCode());
        result = prime * result + ((getAppendImages() == null) ? 0 : getAppendImages().hashCode());
        result = prime * result + ((getReplyContent() == null) ? 0 : getReplyContent().hashCode());
        result = prime * result + ((getReplyImages() == null) ? 0 : getReplyImages().hashCode());
        result = prime * result + ((getAppendReplyContent() == null) ? 0 : getAppendReplyContent().hashCode());
        result = prime * result + ((getAppendReplyImages() == null) ? 0 : getAppendReplyImages().hashCode());
        result = prime * result + ((getIstop() == null) ? 0 : getIstop().hashCode());
        result = prime * result + ((getChecked() == null) ? 0 : getChecked().hashCode());
        result = prime * result + ((getReplychecked() == null) ? 0 : getReplychecked().hashCode());
        result = prime * result + ((getMerchid() == null) ? 0 : getMerchid().hashCode());
        result = prime * result + ((getMemberid() == null) ? 0 : getMemberid().hashCode());
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
        sb.append(", orderid=").append(orderid);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", level=").append(level);
        sb.append(", content=").append(content);
        sb.append(", images=").append(images);
        sb.append(", createtime=").append(createtime);
        sb.append(", deleted=").append(deleted);
        sb.append(", appendContent=").append(appendContent);
        sb.append(", appendImages=").append(appendImages);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", replyImages=").append(replyImages);
        sb.append(", appendReplyContent=").append(appendReplyContent);
        sb.append(", appendReplyImages=").append(appendReplyImages);
        sb.append(", istop=").append(istop);
        sb.append(", checked=").append(checked);
        sb.append(", replychecked=").append(replychecked);
        sb.append(", merchid=").append(merchid);
        sb.append(", memberid=").append(memberid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}