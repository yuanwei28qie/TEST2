package com.microsilver.mrcard.basicservice.model;

import java.io.Serializable;

public class FxSdUserMember  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String mobile;

    private String realname;

    private String nickname;

    private String openid;

    private String pwd;

    private String salt;

    public FxSdUserMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FxSdUserMember(Long id, String mobile, String realname, String nickname, String openid, String pwd,
			String salt, Integer servicescor, Integer levelscore, Integer createtime, String avatar, Boolean status,
			String openidQq, String openidWx, Long financeId, Long referee, String identifier, String token,
			String imToken, String content) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.realname = realname;
		this.nickname = nickname;
		this.openid = openid;
		this.pwd = pwd;
		this.salt = salt;
		this.servicescor = servicescor;
		this.levelscore = levelscore;
		this.createtime = createtime;
		this.avatar = avatar;
		this.status = status;
		this.openidQq = openidQq;
		this.openidWx = openidWx;
		this.financeId = financeId;
		this.referee = referee;
		this.identifier = identifier;
		this.token = token;
		this.imToken = imToken;
		this.content = content;
	}

	private Integer servicescor;

    private Integer levelscore;

    private Integer createtime;

    private String avatar;

    private Boolean status;

    private String openidQq;

    private String openidWx;

    private Long financeId;

    private Long referee;

    private String identifier;

    private String token;

    private String imToken;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getServicescor() {
        return servicescor;
    }

    public void setServicescor(Integer servicescor) {
        this.servicescor = servicescor;
    }

    public Integer getLevelscore() {
        return levelscore;
    }

    public void setLevelscore(Integer levelscore) {
        this.levelscore = levelscore;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getOpenidQq() {
        return openidQq;
    }

    public void setOpenidQq(String openidQq) {
        this.openidQq = openidQq == null ? null : openidQq.trim();
    }

    public String getOpenidWx() {
        return openidWx;
    }

    public void setOpenidWx(String openidWx) {
        this.openidWx = openidWx == null ? null : openidWx.trim();
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public Long getReferee() {
        return referee;
    }

    public void setReferee(Long referee) {
        this.referee = referee;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken == null ? null : imToken.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}