package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value=Include.NON_NULL)
public class ImsEweiShopMember implements Serializable {
    private Long id;

    private Integer uniacid;

    private Integer uid;

    private Integer groupid;

    private Integer level;

    private Integer agentid;

    private String openid;

    private String realname;

    private String mobile;

    private String pwd;

    private String weixin;

    private Integer createtime;

    private Integer agenttime;

    private Boolean status;

    private Boolean isagent;

    private Integer clickcount;

    private Integer agentlevel;

    private String nickname;

    private BigDecimal credit1;

    private BigDecimal credit2;

    private String birthyear;

    private String birthmonth;

    private String birthday;

    private Byte gender;

    private String avatar;

    private String province;

    private String city;

    private String area;

    private Integer childtime;

    private Integer agentnotupgrade;

    private Integer inviter;

    private Byte agentselectgoods;

    private Integer agentblack;

    private String username;

    private Byte fixagentid;

    private Integer diymemberid;

    private Integer diymemberdataid;

    private Integer diycommissionid;

    private Integer diycommissiondataid;

    private Integer isblack;

    private BigDecimal commissionTotal;

    private Integer endtime2;

    private Byte ispartner;

    private Integer partnertime;

    private Byte partnerstatus;

    private Byte partnerblack;

    private Integer partnerlevel;

    private Byte partnernotupgrade;

    private Integer diyglobonusid;

    private Byte isaagent;

    private Integer aagentlevel;

    private Integer aagenttime;

    private Byte aagentstatus;

    private Byte aagentblack;

    private Byte aagentnotupgrade;

    private Byte aagenttype;

    private Integer diyaagentid;

    private String salt;

    private Byte mobileverify;

    private Byte mobileuser;

    private String carrierMobile;

    private Boolean isauthor;

    private Integer authortime;

    private Boolean authorstatus;

    private Boolean authorblack;

    private Integer authorlevel;

    private Boolean authornotupgrade;

    private Integer diyauthorid;

    private Integer authorid;

    private String comefrom;

    private String openidQq;

    private String openidWx;

    private Byte diymaxcredit;

    private Integer maxcredit;

    private String datavalue;

    private String cardNumber;

    private String accountId;

    private Float moneyTotal;

    private String shopType;

    private String pantnrType;

    private Long referee;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUniacid() {
        return uniacid;
    }

    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getAgenttime() {
        return agenttime;
    }

    public void setAgenttime(Integer agenttime) {
        this.agenttime = agenttime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsagent() {
        return isagent;
    }

    public void setIsagent(Boolean isagent) {
        this.isagent = isagent;
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }

    public Integer getAgentlevel() {
        return agentlevel;
    }

    public void setAgentlevel(Integer agentlevel) {
        this.agentlevel = agentlevel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public BigDecimal getCredit1() {
        return credit1;
    }

    public void setCredit1(BigDecimal credit1) {
        this.credit1 = credit1;
    }

    public BigDecimal getCredit2() {
        return credit2;
    }

    public void setCredit2(BigDecimal credit2) {
        this.credit2 = credit2;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public String getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(String birthmonth) {
        this.birthmonth = birthmonth;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getChildtime() {
        return childtime;
    }

    public void setChildtime(Integer childtime) {
        this.childtime = childtime;
    }

    public Integer getAgentnotupgrade() {
        return agentnotupgrade;
    }

    public void setAgentnotupgrade(Integer agentnotupgrade) {
        this.agentnotupgrade = agentnotupgrade;
    }

    public Integer getInviter() {
        return inviter;
    }

    public void setInviter(Integer inviter) {
        this.inviter = inviter;
    }

    public Byte getAgentselectgoods() {
        return agentselectgoods;
    }

    public void setAgentselectgoods(Byte agentselectgoods) {
        this.agentselectgoods = agentselectgoods;
    }

    public Integer getAgentblack() {
        return agentblack;
    }

    public void setAgentblack(Integer agentblack) {
        this.agentblack = agentblack;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Byte getFixagentid() {
        return fixagentid;
    }

    public void setFixagentid(Byte fixagentid) {
        this.fixagentid = fixagentid;
    }

    public Integer getDiymemberid() {
        return diymemberid;
    }

    public void setDiymemberid(Integer diymemberid) {
        this.diymemberid = diymemberid;
    }

    public Integer getDiymemberdataid() {
        return diymemberdataid;
    }

    public void setDiymemberdataid(Integer diymemberdataid) {
        this.diymemberdataid = diymemberdataid;
    }

    public Integer getDiycommissionid() {
        return diycommissionid;
    }

    public void setDiycommissionid(Integer diycommissionid) {
        this.diycommissionid = diycommissionid;
    }

    public Integer getDiycommissiondataid() {
        return diycommissiondataid;
    }

    public void setDiycommissiondataid(Integer diycommissiondataid) {
        this.diycommissiondataid = diycommissiondataid;
    }

    public Integer getIsblack() {
        return isblack;
    }

    public void setIsblack(Integer isblack) {
        this.isblack = isblack;
    }

    public BigDecimal getCommissionTotal() {
        return commissionTotal;
    }

    public void setCommissionTotal(BigDecimal commissionTotal) {
        this.commissionTotal = commissionTotal;
    }

    public Integer getEndtime2() {
        return endtime2;
    }

    public void setEndtime2(Integer endtime2) {
        this.endtime2 = endtime2;
    }

    public Byte getIspartner() {
        return ispartner;
    }

    public void setIspartner(Byte ispartner) {
        this.ispartner = ispartner;
    }

    public Integer getPartnertime() {
        return partnertime;
    }

    public void setPartnertime(Integer partnertime) {
        this.partnertime = partnertime;
    }

    public Byte getPartnerstatus() {
        return partnerstatus;
    }

    public void setPartnerstatus(Byte partnerstatus) {
        this.partnerstatus = partnerstatus;
    }

    public Byte getPartnerblack() {
        return partnerblack;
    }

    public void setPartnerblack(Byte partnerblack) {
        this.partnerblack = partnerblack;
    }

    public Integer getPartnerlevel() {
        return partnerlevel;
    }

    public void setPartnerlevel(Integer partnerlevel) {
        this.partnerlevel = partnerlevel;
    }

    public Byte getPartnernotupgrade() {
        return partnernotupgrade;
    }

    public void setPartnernotupgrade(Byte partnernotupgrade) {
        this.partnernotupgrade = partnernotupgrade;
    }

    public Integer getDiyglobonusid() {
        return diyglobonusid;
    }

    public void setDiyglobonusid(Integer diyglobonusid) {
        this.diyglobonusid = diyglobonusid;
    }

    public Byte getIsaagent() {
        return isaagent;
    }

    public void setIsaagent(Byte isaagent) {
        this.isaagent = isaagent;
    }

    public Integer getAagentlevel() {
        return aagentlevel;
    }

    public void setAagentlevel(Integer aagentlevel) {
        this.aagentlevel = aagentlevel;
    }

    public Integer getAagenttime() {
        return aagenttime;
    }

    public void setAagenttime(Integer aagenttime) {
        this.aagenttime = aagenttime;
    }

    public Byte getAagentstatus() {
        return aagentstatus;
    }

    public void setAagentstatus(Byte aagentstatus) {
        this.aagentstatus = aagentstatus;
    }

    public Byte getAagentblack() {
        return aagentblack;
    }

    public void setAagentblack(Byte aagentblack) {
        this.aagentblack = aagentblack;
    }

    public Byte getAagentnotupgrade() {
        return aagentnotupgrade;
    }

    public void setAagentnotupgrade(Byte aagentnotupgrade) {
        this.aagentnotupgrade = aagentnotupgrade;
    }

    public Byte getAagenttype() {
        return aagenttype;
    }

    public void setAagenttype(Byte aagenttype) {
        this.aagenttype = aagenttype;
    }

    public Integer getDiyaagentid() {
        return diyaagentid;
    }

    public void setDiyaagentid(Integer diyaagentid) {
        this.diyaagentid = diyaagentid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Byte getMobileverify() {
        return mobileverify;
    }

    public void setMobileverify(Byte mobileverify) {
        this.mobileverify = mobileverify;
    }

    public Byte getMobileuser() {
        return mobileuser;
    }

    public void setMobileuser(Byte mobileuser) {
        this.mobileuser = mobileuser;
    }

    public String getCarrierMobile() {
        return carrierMobile;
    }

    public void setCarrierMobile(String carrierMobile) {
        this.carrierMobile = carrierMobile;
    }

    public Boolean getIsauthor() {
        return isauthor;
    }

    public void setIsauthor(Boolean isauthor) {
        this.isauthor = isauthor;
    }

    public Integer getAuthortime() {
        return authortime;
    }

    public void setAuthortime(Integer authortime) {
        this.authortime = authortime;
    }

    public Boolean getAuthorstatus() {
        return authorstatus;
    }

    public void setAuthorstatus(Boolean authorstatus) {
        this.authorstatus = authorstatus;
    }

    public Boolean getAuthorblack() {
        return authorblack;
    }

    public void setAuthorblack(Boolean authorblack) {
        this.authorblack = authorblack;
    }

    public Integer getAuthorlevel() {
        return authorlevel;
    }

    public void setAuthorlevel(Integer authorlevel) {
        this.authorlevel = authorlevel;
    }

    public Boolean getAuthornotupgrade() {
        return authornotupgrade;
    }

    public void setAuthornotupgrade(Boolean authornotupgrade) {
        this.authornotupgrade = authornotupgrade;
    }

    public Integer getDiyauthorid() {
        return diyauthorid;
    }

    public void setDiyauthorid(Integer diyauthorid) {
        this.diyauthorid = diyauthorid;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public String getOpenidQq() {
        return openidQq;
    }

    public void setOpenidQq(String openidQq) {
        this.openidQq = openidQq;
    }

    public String getOpenidWx() {
        return openidWx;
    }

    public void setOpenidWx(String openidWx) {
        this.openidWx = openidWx;
    }

    public Byte getDiymaxcredit() {
        return diymaxcredit;
    }

    public void setDiymaxcredit(Byte diymaxcredit) {
        this.diymaxcredit = diymaxcredit;
    }

    public Integer getMaxcredit() {
        return maxcredit;
    }

    public void setMaxcredit(Integer maxcredit) {
        this.maxcredit = maxcredit;
    }

    public String getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(String datavalue) {
        this.datavalue = datavalue;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Float getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(Float moneyTotal) {
        this.moneyTotal = moneyTotal;
    }
    
    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getPantnrType() {
        return pantnrType;
    }

    public void setPantnrType(String pantnrType) {
        this.pantnrType = pantnrType;
    }

    public Long getReferee() {
        return referee;
    }

    public void setReferee(Long referee) {
        this.referee = referee;
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
        ImsEweiShopMember other = (ImsEweiShopMember) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getGroupid() == null ? other.getGroupid() == null : this.getGroupid().equals(other.getGroupid()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getAgentid() == null ? other.getAgentid() == null : this.getAgentid().equals(other.getAgentid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getAgenttime() == null ? other.getAgenttime() == null : this.getAgenttime().equals(other.getAgenttime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsagent() == null ? other.getIsagent() == null : this.getIsagent().equals(other.getIsagent()))
            && (this.getClickcount() == null ? other.getClickcount() == null : this.getClickcount().equals(other.getClickcount()))
            && (this.getAgentlevel() == null ? other.getAgentlevel() == null : this.getAgentlevel().equals(other.getAgentlevel()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getCredit1() == null ? other.getCredit1() == null : this.getCredit1().equals(other.getCredit1()))
            && (this.getCredit2() == null ? other.getCredit2() == null : this.getCredit2().equals(other.getCredit2()))
            && (this.getBirthyear() == null ? other.getBirthyear() == null : this.getBirthyear().equals(other.getBirthyear()))
            && (this.getBirthmonth() == null ? other.getBirthmonth() == null : this.getBirthmonth().equals(other.getBirthmonth()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getChildtime() == null ? other.getChildtime() == null : this.getChildtime().equals(other.getChildtime()))
            && (this.getAgentnotupgrade() == null ? other.getAgentnotupgrade() == null : this.getAgentnotupgrade().equals(other.getAgentnotupgrade()))
            && (this.getInviter() == null ? other.getInviter() == null : this.getInviter().equals(other.getInviter()))
            && (this.getAgentselectgoods() == null ? other.getAgentselectgoods() == null : this.getAgentselectgoods().equals(other.getAgentselectgoods()))
            && (this.getAgentblack() == null ? other.getAgentblack() == null : this.getAgentblack().equals(other.getAgentblack()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getFixagentid() == null ? other.getFixagentid() == null : this.getFixagentid().equals(other.getFixagentid()))
            && (this.getDiymemberid() == null ? other.getDiymemberid() == null : this.getDiymemberid().equals(other.getDiymemberid()))
            && (this.getDiymemberdataid() == null ? other.getDiymemberdataid() == null : this.getDiymemberdataid().equals(other.getDiymemberdataid()))
            && (this.getDiycommissionid() == null ? other.getDiycommissionid() == null : this.getDiycommissionid().equals(other.getDiycommissionid()))
            && (this.getDiycommissiondataid() == null ? other.getDiycommissiondataid() == null : this.getDiycommissiondataid().equals(other.getDiycommissiondataid()))
            && (this.getIsblack() == null ? other.getIsblack() == null : this.getIsblack().equals(other.getIsblack()))
            && (this.getCommissionTotal() == null ? other.getCommissionTotal() == null : this.getCommissionTotal().equals(other.getCommissionTotal()))
            && (this.getEndtime2() == null ? other.getEndtime2() == null : this.getEndtime2().equals(other.getEndtime2()))
            && (this.getIspartner() == null ? other.getIspartner() == null : this.getIspartner().equals(other.getIspartner()))
            && (this.getPartnertime() == null ? other.getPartnertime() == null : this.getPartnertime().equals(other.getPartnertime()))
            && (this.getPartnerstatus() == null ? other.getPartnerstatus() == null : this.getPartnerstatus().equals(other.getPartnerstatus()))
            && (this.getPartnerblack() == null ? other.getPartnerblack() == null : this.getPartnerblack().equals(other.getPartnerblack()))
            && (this.getPartnerlevel() == null ? other.getPartnerlevel() == null : this.getPartnerlevel().equals(other.getPartnerlevel()))
            && (this.getPartnernotupgrade() == null ? other.getPartnernotupgrade() == null : this.getPartnernotupgrade().equals(other.getPartnernotupgrade()))
            && (this.getDiyglobonusid() == null ? other.getDiyglobonusid() == null : this.getDiyglobonusid().equals(other.getDiyglobonusid()))
            && (this.getIsaagent() == null ? other.getIsaagent() == null : this.getIsaagent().equals(other.getIsaagent()))
            && (this.getAagentlevel() == null ? other.getAagentlevel() == null : this.getAagentlevel().equals(other.getAagentlevel()))
            && (this.getAagenttime() == null ? other.getAagenttime() == null : this.getAagenttime().equals(other.getAagenttime()))
            && (this.getAagentstatus() == null ? other.getAagentstatus() == null : this.getAagentstatus().equals(other.getAagentstatus()))
            && (this.getAagentblack() == null ? other.getAagentblack() == null : this.getAagentblack().equals(other.getAagentblack()))
            && (this.getAagentnotupgrade() == null ? other.getAagentnotupgrade() == null : this.getAagentnotupgrade().equals(other.getAagentnotupgrade()))
            && (this.getAagenttype() == null ? other.getAagenttype() == null : this.getAagenttype().equals(other.getAagenttype()))
            && (this.getDiyaagentid() == null ? other.getDiyaagentid() == null : this.getDiyaagentid().equals(other.getDiyaagentid()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getMobileverify() == null ? other.getMobileverify() == null : this.getMobileverify().equals(other.getMobileverify()))
            && (this.getMobileuser() == null ? other.getMobileuser() == null : this.getMobileuser().equals(other.getMobileuser()))
            && (this.getCarrierMobile() == null ? other.getCarrierMobile() == null : this.getCarrierMobile().equals(other.getCarrierMobile()))
            && (this.getIsauthor() == null ? other.getIsauthor() == null : this.getIsauthor().equals(other.getIsauthor()))
            && (this.getAuthortime() == null ? other.getAuthortime() == null : this.getAuthortime().equals(other.getAuthortime()))
            && (this.getAuthorstatus() == null ? other.getAuthorstatus() == null : this.getAuthorstatus().equals(other.getAuthorstatus()))
            && (this.getAuthorblack() == null ? other.getAuthorblack() == null : this.getAuthorblack().equals(other.getAuthorblack()))
            && (this.getAuthorlevel() == null ? other.getAuthorlevel() == null : this.getAuthorlevel().equals(other.getAuthorlevel()))
            && (this.getAuthornotupgrade() == null ? other.getAuthornotupgrade() == null : this.getAuthornotupgrade().equals(other.getAuthornotupgrade()))
            && (this.getDiyauthorid() == null ? other.getDiyauthorid() == null : this.getDiyauthorid().equals(other.getDiyauthorid()))
            && (this.getAuthorid() == null ? other.getAuthorid() == null : this.getAuthorid().equals(other.getAuthorid()))
            && (this.getComefrom() == null ? other.getComefrom() == null : this.getComefrom().equals(other.getComefrom()))
            && (this.getOpenidQq() == null ? other.getOpenidQq() == null : this.getOpenidQq().equals(other.getOpenidQq()))
            && (this.getOpenidWx() == null ? other.getOpenidWx() == null : this.getOpenidWx().equals(other.getOpenidWx()))
            && (this.getDiymaxcredit() == null ? other.getDiymaxcredit() == null : this.getDiymaxcredit().equals(other.getDiymaxcredit()))
            && (this.getMaxcredit() == null ? other.getMaxcredit() == null : this.getMaxcredit().equals(other.getMaxcredit()))
            && (this.getDatavalue() == null ? other.getDatavalue() == null : this.getDatavalue().equals(other.getDatavalue()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getMoneyTotal() == null ? other.getMoneyTotal() == null : this.getMoneyTotal().equals(other.getMoneyTotal()))
            
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getPantnrType() == null ? other.getPantnrType() == null : this.getPantnrType().equals(other.getPantnrType()))
            && (this.getReferee() == null ? other.getReferee() == null : this.getReferee().equals(other.getReferee()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getGroupid() == null) ? 0 : getGroupid().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getAgentid() == null) ? 0 : getAgentid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getAgenttime() == null) ? 0 : getAgenttime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsagent() == null) ? 0 : getIsagent().hashCode());
        result = prime * result + ((getClickcount() == null) ? 0 : getClickcount().hashCode());
        result = prime * result + ((getAgentlevel() == null) ? 0 : getAgentlevel().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getCredit1() == null) ? 0 : getCredit1().hashCode());
        result = prime * result + ((getCredit2() == null) ? 0 : getCredit2().hashCode());
        result = prime * result + ((getBirthyear() == null) ? 0 : getBirthyear().hashCode());
        result = prime * result + ((getBirthmonth() == null) ? 0 : getBirthmonth().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getChildtime() == null) ? 0 : getChildtime().hashCode());
        result = prime * result + ((getAgentnotupgrade() == null) ? 0 : getAgentnotupgrade().hashCode());
        result = prime * result + ((getInviter() == null) ? 0 : getInviter().hashCode());
        result = prime * result + ((getAgentselectgoods() == null) ? 0 : getAgentselectgoods().hashCode());
        result = prime * result + ((getAgentblack() == null) ? 0 : getAgentblack().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getFixagentid() == null) ? 0 : getFixagentid().hashCode());
        result = prime * result + ((getDiymemberid() == null) ? 0 : getDiymemberid().hashCode());
        result = prime * result + ((getDiymemberdataid() == null) ? 0 : getDiymemberdataid().hashCode());
        result = prime * result + ((getDiycommissionid() == null) ? 0 : getDiycommissionid().hashCode());
        result = prime * result + ((getDiycommissiondataid() == null) ? 0 : getDiycommissiondataid().hashCode());
        result = prime * result + ((getIsblack() == null) ? 0 : getIsblack().hashCode());
        result = prime * result + ((getCommissionTotal() == null) ? 0 : getCommissionTotal().hashCode());
        result = prime * result + ((getEndtime2() == null) ? 0 : getEndtime2().hashCode());
        result = prime * result + ((getIspartner() == null) ? 0 : getIspartner().hashCode());
        result = prime * result + ((getPartnertime() == null) ? 0 : getPartnertime().hashCode());
        result = prime * result + ((getPartnerstatus() == null) ? 0 : getPartnerstatus().hashCode());
        result = prime * result + ((getPartnerblack() == null) ? 0 : getPartnerblack().hashCode());
        result = prime * result + ((getPartnerlevel() == null) ? 0 : getPartnerlevel().hashCode());
        result = prime * result + ((getPartnernotupgrade() == null) ? 0 : getPartnernotupgrade().hashCode());
        result = prime * result + ((getDiyglobonusid() == null) ? 0 : getDiyglobonusid().hashCode());
        result = prime * result + ((getIsaagent() == null) ? 0 : getIsaagent().hashCode());
        result = prime * result + ((getAagentlevel() == null) ? 0 : getAagentlevel().hashCode());
        result = prime * result + ((getAagenttime() == null) ? 0 : getAagenttime().hashCode());
        result = prime * result + ((getAagentstatus() == null) ? 0 : getAagentstatus().hashCode());
        result = prime * result + ((getAagentblack() == null) ? 0 : getAagentblack().hashCode());
        result = prime * result + ((getAagentnotupgrade() == null) ? 0 : getAagentnotupgrade().hashCode());
        result = prime * result + ((getAagenttype() == null) ? 0 : getAagenttype().hashCode());
        result = prime * result + ((getDiyaagentid() == null) ? 0 : getDiyaagentid().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getMobileverify() == null) ? 0 : getMobileverify().hashCode());
        result = prime * result + ((getMobileuser() == null) ? 0 : getMobileuser().hashCode());
        result = prime * result + ((getCarrierMobile() == null) ? 0 : getCarrierMobile().hashCode());
        result = prime * result + ((getIsauthor() == null) ? 0 : getIsauthor().hashCode());
        result = prime * result + ((getAuthortime() == null) ? 0 : getAuthortime().hashCode());
        result = prime * result + ((getAuthorstatus() == null) ? 0 : getAuthorstatus().hashCode());
        result = prime * result + ((getAuthorblack() == null) ? 0 : getAuthorblack().hashCode());
        result = prime * result + ((getAuthorlevel() == null) ? 0 : getAuthorlevel().hashCode());
        result = prime * result + ((getAuthornotupgrade() == null) ? 0 : getAuthornotupgrade().hashCode());
        result = prime * result + ((getDiyauthorid() == null) ? 0 : getDiyauthorid().hashCode());
        result = prime * result + ((getAuthorid() == null) ? 0 : getAuthorid().hashCode());
        result = prime * result + ((getComefrom() == null) ? 0 : getComefrom().hashCode());
        result = prime * result + ((getOpenidQq() == null) ? 0 : getOpenidQq().hashCode());
        result = prime * result + ((getOpenidWx() == null) ? 0 : getOpenidWx().hashCode());
        result = prime * result + ((getDiymaxcredit() == null) ? 0 : getDiymaxcredit().hashCode());
        result = prime * result + ((getMaxcredit() == null) ? 0 : getMaxcredit().hashCode());
        result = prime * result + ((getDatavalue() == null) ? 0 : getDatavalue().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getMoneyTotal() == null) ? 0 : getMoneyTotal().hashCode());
        
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getPantnrType() == null) ? 0 : getPantnrType().hashCode());
        result = prime * result + ((getReferee() == null) ? 0 : getReferee().hashCode());
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
        sb.append(", uid=").append(uid);
        sb.append(", groupid=").append(groupid);
        sb.append(", level=").append(level);
        sb.append(", agentid=").append(agentid);
        sb.append(", openid=").append(openid);
        sb.append(", realname=").append(realname);
        sb.append(", mobile=").append(mobile);
        sb.append(", pwd=").append(pwd);
        sb.append(", weixin=").append(weixin);
        sb.append(", createtime=").append(createtime);
        sb.append(", agenttime=").append(agenttime);
        sb.append(", status=").append(status);
        sb.append(", isagent=").append(isagent);
        sb.append(", clickcount=").append(clickcount);
        sb.append(", agentlevel=").append(agentlevel);
        sb.append(", nickname=").append(nickname);
        sb.append(", credit1=").append(credit1);
        sb.append(", credit2=").append(credit2);
        sb.append(", birthyear=").append(birthyear);
        sb.append(", birthmonth=").append(birthmonth);
        sb.append(", birthday=").append(birthday);
        sb.append(", gender=").append(gender);
        sb.append(", avatar=").append(avatar);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", childtime=").append(childtime);
        sb.append(", agentnotupgrade=").append(agentnotupgrade);
        sb.append(", inviter=").append(inviter);
        sb.append(", agentselectgoods=").append(agentselectgoods);
        sb.append(", agentblack=").append(agentblack);
        sb.append(", username=").append(username);
        sb.append(", fixagentid=").append(fixagentid);
        sb.append(", diymemberid=").append(diymemberid);
        sb.append(", diymemberdataid=").append(diymemberdataid);
        sb.append(", diycommissionid=").append(diycommissionid);
        sb.append(", diycommissiondataid=").append(diycommissiondataid);
        sb.append(", isblack=").append(isblack);
        sb.append(", commissionTotal=").append(commissionTotal);
        sb.append(", endtime2=").append(endtime2);
        sb.append(", ispartner=").append(ispartner);
        sb.append(", partnertime=").append(partnertime);
        sb.append(", partnerstatus=").append(partnerstatus);
        sb.append(", partnerblack=").append(partnerblack);
        sb.append(", partnerlevel=").append(partnerlevel);
        sb.append(", partnernotupgrade=").append(partnernotupgrade);
        sb.append(", diyglobonusid=").append(diyglobonusid);
        sb.append(", isaagent=").append(isaagent);
        sb.append(", aagentlevel=").append(aagentlevel);
        sb.append(", aagenttime=").append(aagenttime);
        sb.append(", aagentstatus=").append(aagentstatus);
        sb.append(", aagentblack=").append(aagentblack);
        sb.append(", aagentnotupgrade=").append(aagentnotupgrade);
        sb.append(", aagenttype=").append(aagenttype);
        sb.append(", diyaagentid=").append(diyaagentid);
        sb.append(", salt=").append(salt);
        sb.append(", mobileverify=").append(mobileverify);
        sb.append(", mobileuser=").append(mobileuser);
        sb.append(", carrierMobile=").append(carrierMobile);
        sb.append(", isauthor=").append(isauthor);
        sb.append(", authortime=").append(authortime);
        sb.append(", authorstatus=").append(authorstatus);
        sb.append(", authorblack=").append(authorblack);
        sb.append(", authorlevel=").append(authorlevel);
        sb.append(", authornotupgrade=").append(authornotupgrade);
        sb.append(", diyauthorid=").append(diyauthorid);
        sb.append(", authorid=").append(authorid);
        sb.append(", comefrom=").append(comefrom);
        sb.append(", openidQq=").append(openidQq);
        sb.append(", openidWx=").append(openidWx);
        sb.append(", diymaxcredit=").append(diymaxcredit);
        sb.append(", maxcredit=").append(maxcredit);
        sb.append(", datavalue=").append(datavalue);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", accountId=").append(accountId);
        sb.append(", moneyTotal=").append(moneyTotal);
        
        sb.append(", shopType=").append(shopType);
        sb.append(", pantnrType=").append(pantnrType);
        sb.append(", referee=").append(referee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}