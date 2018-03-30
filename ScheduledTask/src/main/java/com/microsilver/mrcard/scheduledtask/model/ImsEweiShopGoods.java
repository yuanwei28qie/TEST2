package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ImsEweiShopGoods implements Serializable {
    private Integer id;

    private Integer uniacid;

    private Integer pcate;

    private Integer ccate;

    private Integer tcate;

    private Boolean type;

    private Boolean status;

    private Integer displayorder;

    private String title;

    private String thumb;
    
    private String thumbUrl;
    
    private List<String> thumbUrls;

    public List<String> getThumbUrls() {
		return thumbUrls;
	}

	public void setThumbUrls(List<String> thumbUrls) {
		this.thumbUrls = thumbUrls;
	}

	private String unit;

    private String description;

    private String goodssn;

    private String productsn;

    private BigDecimal productprice;

    private BigDecimal marketprice;

    private BigDecimal costprice;

    private BigDecimal originalprice;

    private Integer total;

    private Integer totalcnf;

    private Integer sales;

    private Integer salesreal;

    private String spec;

    private Integer createtime;

    private BigDecimal weight;

    private String credit;

    private Integer maxbuy;

    private Integer usermaxbuy;

    private Integer hasoption;

    private Integer dispatch;

    private Boolean isnew;

    private Boolean ishot;

    private Boolean isdiscount;

    private String isdiscountTitle;

    private Integer isdiscountTime;

    private Boolean isrecommand;

    private Boolean issendfree;

    private Boolean istime;

    private Boolean iscomment;

    private Integer timestart;

    private Integer timeend;

    private Integer viewcount;

    private Byte deleted;

    private Byte hascommission;

    private BigDecimal commission1Rate;

    private BigDecimal commission1Pay;

    private BigDecimal commission2Rate;

    private BigDecimal commission2Pay;

    private BigDecimal commission3Rate;

    private BigDecimal commission3Pay;

    private BigDecimal score;

    private String taobaoid;

    private String taotaoid;

    private String taobaourl;

    private Integer updatetime;

    private String shareTitle;

    private String shareIcon;

    private Byte cash;

    private String commissionThumb;

    private Byte isnodiscount;

    private Byte isverify;

    private String noticeopenid;

    private Byte needfollow;

    private String followurl;

    private String followtip;

    private BigDecimal deduct;

    private String shorttitle;

    private Integer virtual;

    private Byte nocommission;

    private Byte hidecommission;

    private String detailLogo;

    private String detailShopname;

    private String detailTotaltitle;

    private String detailBtntext1;

    private String detailBtnurl1;

    private String detailBtntext2;

    private String detailBtnurl2;

    private Integer artid;

    private BigDecimal deduct2;

    private Integer ednum;

    private BigDecimal edmoney;

    private Boolean diyformtype;

    private Integer diyformid;

    private Boolean diymode;

    private Boolean dispatchtype;

    private Integer dispatchid;

    private BigDecimal dispatchprice;

    private Boolean manydeduct;

    private Byte saleupdate37975;

    private Integer shopid;

    private Integer minbuy;

    private Byte invoice;

    private Byte repair;

    private Byte seven;

    private String money;

    private BigDecimal minprice;

    private BigDecimal maxprice;

    private String province;

    private String city;

    private Boolean buyshow;

    private Byte saleupdate51117;

    private Boolean virtualsend;

    private Boolean verifytype;

    private Integer diysaveid;

    private Boolean diysave;

    private Byte quality;

    private Boolean groupstype;

    private Boolean showtotal;

    private String subtitle;

    private Boolean sharebtn;

    private Integer merchid;

    private Byte checked;

    private Byte thumbFirst;

    private Boolean showtotaladd;

    private Boolean merchsale;

    private String keywords;

    private String catchId;

    private String catchUrl;

    private String catchSource;

    private Integer autoreceive;

    private Byte cannotrefund;

    private Integer bargain;

    private BigDecimal buyagain;

    private Boolean buyagainIslong;

    private Boolean buyagainCondition;

    private Boolean buyagainSale;

    private Integer diypage;

    private Boolean cashier;

    private Byte isendtime;

    private Integer usetime;

    private Integer endtime;

    private Integer merchdisplayorder;

    private Integer exchangeStock;

    private BigDecimal exchangePostage;

    private Byte ispresell;

    private BigDecimal presellprice;

    private Byte presellover;

    private Integer presellovertime;

    private Byte presellstart;

    private Integer preselltimestart;

    private Byte presellend;

    private Integer preselltimeend;

    private Byte presellsendtype;

    private Integer presellsendstatrttime;

    private Integer presellsendtime;

    private String edareasCode;

    private Integer isMill;

    private Integer orderType;

    private String services;
    
    private List<String> listService;
    
    private BigDecimal zeroCostprice;

    private BigDecimal zeroPresellprice;

    
    
    public BigDecimal getZeroCostprice() {
		return zeroCostprice;
	}

	public void setZeroCostprice(BigDecimal zeroCostprice) {
		this.zeroCostprice = zeroCostprice;
	}

	public BigDecimal getZeroPresellprice() {
		return zeroPresellprice;
	}

	public void setZeroPresellprice(BigDecimal zeroPresellprice) {
		this.zeroPresellprice = zeroPresellprice;
	}

	public List<String> getListService() {
		return listService;
	}

	public void setListService(List<String> listService) {
		this.listService = listService;
	}

	private Byte joinSource;

    private BigDecimal extraDiscount;
    private BigDecimal discounts;

    private static final long serialVersionUID = 1L;

    
	public BigDecimal getDiscounts() {
		return discounts;
	}

	public void setDiscounts(BigDecimal discounts) {
		this.discounts = discounts;
	}

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

	public Integer getPcate() {
		return pcate;
	}

	public void setPcate(Integer pcate) {
		this.pcate = pcate;
	}

	public Integer getCcate() {
		return ccate;
	}

	public void setCcate(Integer ccate) {
		this.ccate = ccate;
	}

	public Integer getTcate() {
		return tcate;
	}

	public void setTcate(Integer tcate) {
		this.tcate = tcate;
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

	public Integer getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoodssn() {
		return goodssn;
	}

	public void setGoodssn(String goodssn) {
		this.goodssn = goodssn;
	}

	public String getProductsn() {
		return productsn;
	}

	public void setProductsn(String productsn) {
		this.productsn = productsn;
	}

	public BigDecimal getProductprice() {
		return productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public BigDecimal getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}

	public BigDecimal getCostprice() {
		return costprice;
	}

	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}

	public BigDecimal getOriginalprice() {
		return originalprice;
	}

	public void setOriginalprice(BigDecimal originalprice) {
		this.originalprice = originalprice;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalcnf() {
		return totalcnf;
	}

	public void setTotalcnf(Integer totalcnf) {
		this.totalcnf = totalcnf;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getSalesreal() {
		return salesreal;
	}

	public void setSalesreal(Integer salesreal) {
		this.salesreal = salesreal;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public Integer getMaxbuy() {
		return maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public Integer getUsermaxbuy() {
		return usermaxbuy;
	}

	public void setUsermaxbuy(Integer usermaxbuy) {
		this.usermaxbuy = usermaxbuy;
	}

	public Integer getHasoption() {
		return hasoption;
	}

	public void setHasoption(Integer hasoption) {
		this.hasoption = hasoption;
	}

	public Integer getDispatch() {
		return dispatch;
	}

	public void setDispatch(Integer dispatch) {
		this.dispatch = dispatch;
	}

	public Boolean getIsnew() {
		return isnew;
	}

	public void setIsnew(Boolean isnew) {
		this.isnew = isnew;
	}

	public Boolean getIshot() {
		return ishot;
	}

	public void setIshot(Boolean ishot) {
		this.ishot = ishot;
	}

	public Boolean getIsdiscount() {
		return isdiscount;
	}

	public void setIsdiscount(Boolean isdiscount) {
		this.isdiscount = isdiscount;
	}

	public String getIsdiscountTitle() {
		return isdiscountTitle;
	}

	public void setIsdiscountTitle(String isdiscountTitle) {
		this.isdiscountTitle = isdiscountTitle;
	}

	public Integer getIsdiscountTime() {
		return isdiscountTime;
	}

	public void setIsdiscountTime(Integer isdiscountTime) {
		this.isdiscountTime = isdiscountTime;
	}

	public Boolean getIsrecommand() {
		return isrecommand;
	}

	public void setIsrecommand(Boolean isrecommand) {
		this.isrecommand = isrecommand;
	}

	public Boolean getIssendfree() {
		return issendfree;
	}

	public void setIssendfree(Boolean issendfree) {
		this.issendfree = issendfree;
	}

	public Boolean getIstime() {
		return istime;
	}

	public void setIstime(Boolean istime) {
		this.istime = istime;
	}

	public Boolean getIscomment() {
		return iscomment;
	}

	public void setIscomment(Boolean iscomment) {
		this.iscomment = iscomment;
	}

	public Integer getTimestart() {
		return timestart;
	}

	public void setTimestart(Integer timestart) {
		this.timestart = timestart;
	}

	public Integer getTimeend() {
		return timeend;
	}

	public void setTimeend(Integer timeend) {
		this.timeend = timeend;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public Byte getDeleted() {
		return deleted;
	}

	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	public Byte getHascommission() {
		return hascommission;
	}

	public void setHascommission(Byte hascommission) {
		this.hascommission = hascommission;
	}

	public BigDecimal getCommission1Rate() {
		return commission1Rate;
	}

	public void setCommission1Rate(BigDecimal commission1Rate) {
		this.commission1Rate = commission1Rate;
	}

	public BigDecimal getCommission1Pay() {
		return commission1Pay;
	}

	public void setCommission1Pay(BigDecimal commission1Pay) {
		this.commission1Pay = commission1Pay;
	}

	public BigDecimal getCommission2Rate() {
		return commission2Rate;
	}

	public void setCommission2Rate(BigDecimal commission2Rate) {
		this.commission2Rate = commission2Rate;
	}

	public BigDecimal getCommission2Pay() {
		return commission2Pay;
	}

	public void setCommission2Pay(BigDecimal commission2Pay) {
		this.commission2Pay = commission2Pay;
	}

	public BigDecimal getCommission3Rate() {
		return commission3Rate;
	}

	public void setCommission3Rate(BigDecimal commission3Rate) {
		this.commission3Rate = commission3Rate;
	}

	public BigDecimal getCommission3Pay() {
		return commission3Pay;
	}

	public void setCommission3Pay(BigDecimal commission3Pay) {
		this.commission3Pay = commission3Pay;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getTaobaoid() {
		return taobaoid;
	}

	public void setTaobaoid(String taobaoid) {
		this.taobaoid = taobaoid;
	}

	public String getTaotaoid() {
		return taotaoid;
	}

	public void setTaotaoid(String taotaoid) {
		this.taotaoid = taotaoid;
	}

	public String getTaobaourl() {
		return taobaourl;
	}

	public void setTaobaourl(String taobaourl) {
		this.taobaourl = taobaourl;
	}

	public Integer getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareIcon() {
		return shareIcon;
	}

	public void setShareIcon(String shareIcon) {
		this.shareIcon = shareIcon;
	}

	public Byte getCash() {
		return cash;
	}

	public void setCash(Byte cash) {
		this.cash = cash;
	}

	public String getCommissionThumb() {
		return commissionThumb;
	}

	public void setCommissionThumb(String commissionThumb) {
		this.commissionThumb = commissionThumb;
	}

	public Byte getIsnodiscount() {
		return isnodiscount;
	}

	public void setIsnodiscount(Byte isnodiscount) {
		this.isnodiscount = isnodiscount;
	}

	public Byte getIsverify() {
		return isverify;
	}

	public void setIsverify(Byte isverify) {
		this.isverify = isverify;
	}

	public String getNoticeopenid() {
		return noticeopenid;
	}

	public void setNoticeopenid(String noticeopenid) {
		this.noticeopenid = noticeopenid;
	}

	public Byte getNeedfollow() {
		return needfollow;
	}

	public void setNeedfollow(Byte needfollow) {
		this.needfollow = needfollow;
	}

	public String getFollowurl() {
		return followurl;
	}

	public void setFollowurl(String followurl) {
		this.followurl = followurl;
	}

	public String getFollowtip() {
		return followtip;
	}

	public void setFollowtip(String followtip) {
		this.followtip = followtip;
	}

	public BigDecimal getDeduct() {
		return deduct;
	}

	public void setDeduct(BigDecimal deduct) {
		this.deduct = deduct;
	}

	public String getShorttitle() {
		return shorttitle;
	}

	public void setShorttitle(String shorttitle) {
		this.shorttitle = shorttitle;
	}

	public Integer getVirtual() {
		return virtual;
	}

	public void setVirtual(Integer virtual) {
		this.virtual = virtual;
	}

	public Byte getNocommission() {
		return nocommission;
	}

	public void setNocommission(Byte nocommission) {
		this.nocommission = nocommission;
	}

	public Byte getHidecommission() {
		return hidecommission;
	}

	public void setHidecommission(Byte hidecommission) {
		this.hidecommission = hidecommission;
	}

	public String getDetailLogo() {
		return detailLogo;
	}

	public void setDetailLogo(String detailLogo) {
		this.detailLogo = detailLogo;
	}

	public String getDetailShopname() {
		return detailShopname;
	}

	public void setDetailShopname(String detailShopname) {
		this.detailShopname = detailShopname;
	}

	public String getDetailTotaltitle() {
		return detailTotaltitle;
	}

	public void setDetailTotaltitle(String detailTotaltitle) {
		this.detailTotaltitle = detailTotaltitle;
	}

	public String getDetailBtntext1() {
		return detailBtntext1;
	}

	public void setDetailBtntext1(String detailBtntext1) {
		this.detailBtntext1 = detailBtntext1;
	}

	public String getDetailBtnurl1() {
		return detailBtnurl1;
	}

	public void setDetailBtnurl1(String detailBtnurl1) {
		this.detailBtnurl1 = detailBtnurl1;
	}

	public String getDetailBtntext2() {
		return detailBtntext2;
	}

	public void setDetailBtntext2(String detailBtntext2) {
		this.detailBtntext2 = detailBtntext2;
	}

	public String getDetailBtnurl2() {
		return detailBtnurl2;
	}

	public void setDetailBtnurl2(String detailBtnurl2) {
		this.detailBtnurl2 = detailBtnurl2;
	}

	public Integer getArtid() {
		return artid;
	}

	public void setArtid(Integer artid) {
		this.artid = artid;
	}

	public BigDecimal getDeduct2() {
		return deduct2;
	}

	public void setDeduct2(BigDecimal deduct2) {
		this.deduct2 = deduct2;
	}

	public Integer getEdnum() {
		return ednum;
	}

	public void setEdnum(Integer ednum) {
		this.ednum = ednum;
	}

	public BigDecimal getEdmoney() {
		return edmoney;
	}

	public void setEdmoney(BigDecimal edmoney) {
		this.edmoney = edmoney;
	}

	public Boolean getDiyformtype() {
		return diyformtype;
	}

	public void setDiyformtype(Boolean diyformtype) {
		this.diyformtype = diyformtype;
	}

	public Integer getDiyformid() {
		return diyformid;
	}

	public void setDiyformid(Integer diyformid) {
		this.diyformid = diyformid;
	}

	public Boolean getDiymode() {
		return diymode;
	}

	public void setDiymode(Boolean diymode) {
		this.diymode = diymode;
	}

	public Boolean getDispatchtype() {
		return dispatchtype;
	}

	public void setDispatchtype(Boolean dispatchtype) {
		this.dispatchtype = dispatchtype;
	}

	public Integer getDispatchid() {
		return dispatchid;
	}

	public void setDispatchid(Integer dispatchid) {
		this.dispatchid = dispatchid;
	}

	public BigDecimal getDispatchprice() {
		return dispatchprice;
	}

	public void setDispatchprice(BigDecimal dispatchprice) {
		this.dispatchprice = dispatchprice;
	}

	public Boolean getManydeduct() {
		return manydeduct;
	}

	public void setManydeduct(Boolean manydeduct) {
		this.manydeduct = manydeduct;
	}

	public Byte getSaleupdate37975() {
		return saleupdate37975;
	}

	public void setSaleupdate37975(Byte saleupdate37975) {
		this.saleupdate37975 = saleupdate37975;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getMinbuy() {
		return minbuy;
	}

	public void setMinbuy(Integer minbuy) {
		this.minbuy = minbuy;
	}

	public Byte getInvoice() {
		return invoice;
	}

	public void setInvoice(Byte invoice) {
		this.invoice = invoice;
	}

	public Byte getRepair() {
		return repair;
	}

	public void setRepair(Byte repair) {
		this.repair = repair;
	}

	public Byte getSeven() {
		return seven;
	}

	public void setSeven(Byte seven) {
		this.seven = seven;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public BigDecimal getMinprice() {
		return minprice;
	}

	public void setMinprice(BigDecimal minprice) {
		this.minprice = minprice;
	}

	public BigDecimal getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(BigDecimal maxprice) {
		this.maxprice = maxprice;
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

	public Boolean getBuyshow() {
		return buyshow;
	}

	public void setBuyshow(Boolean buyshow) {
		this.buyshow = buyshow;
	}

	public Byte getSaleupdate51117() {
		return saleupdate51117;
	}

	public void setSaleupdate51117(Byte saleupdate51117) {
		this.saleupdate51117 = saleupdate51117;
	}

	public Boolean getVirtualsend() {
		return virtualsend;
	}

	public void setVirtualsend(Boolean virtualsend) {
		this.virtualsend = virtualsend;
	}

	public Boolean getVerifytype() {
		return verifytype;
	}

	public void setVerifytype(Boolean verifytype) {
		this.verifytype = verifytype;
	}

	public Integer getDiysaveid() {
		return diysaveid;
	}

	public void setDiysaveid(Integer diysaveid) {
		this.diysaveid = diysaveid;
	}

	public Boolean getDiysave() {
		return diysave;
	}

	public void setDiysave(Boolean diysave) {
		this.diysave = diysave;
	}

	public Byte getQuality() {
		return quality;
	}

	public void setQuality(Byte quality) {
		this.quality = quality;
	}

	public Boolean getGroupstype() {
		return groupstype;
	}

	public void setGroupstype(Boolean groupstype) {
		this.groupstype = groupstype;
	}

	public Boolean getShowtotal() {
		return showtotal;
	}

	public void setShowtotal(Boolean showtotal) {
		this.showtotal = showtotal;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Boolean getSharebtn() {
		return sharebtn;
	}

	public void setSharebtn(Boolean sharebtn) {
		this.sharebtn = sharebtn;
	}

	public Integer getMerchid() {
		return merchid;
	}

	public void setMerchid(Integer merchid) {
		this.merchid = merchid;
	}

	public Byte getChecked() {
		return checked;
	}

	public void setChecked(Byte checked) {
		this.checked = checked;
	}

	public Byte getThumbFirst() {
		return thumbFirst;
	}

	public void setThumbFirst(Byte thumbFirst) {
		this.thumbFirst = thumbFirst;
	}

	public Boolean getShowtotaladd() {
		return showtotaladd;
	}

	public void setShowtotaladd(Boolean showtotaladd) {
		this.showtotaladd = showtotaladd;
	}

	public Boolean getMerchsale() {
		return merchsale;
	}

	public void setMerchsale(Boolean merchsale) {
		this.merchsale = merchsale;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getCatchId() {
		return catchId;
	}

	public void setCatchId(String catchId) {
		this.catchId = catchId;
	}

	public String getCatchUrl() {
		return catchUrl;
	}

	public void setCatchUrl(String catchUrl) {
		this.catchUrl = catchUrl;
	}

	public String getCatchSource() {
		return catchSource;
	}

	public void setCatchSource(String catchSource) {
		this.catchSource = catchSource;
	}

	public Integer getAutoreceive() {
		return autoreceive;
	}

	public void setAutoreceive(Integer autoreceive) {
		this.autoreceive = autoreceive;
	}

	public Byte getCannotrefund() {
		return cannotrefund;
	}

	public void setCannotrefund(Byte cannotrefund) {
		this.cannotrefund = cannotrefund;
	}

	public Integer getBargain() {
		return bargain;
	}

	public void setBargain(Integer bargain) {
		this.bargain = bargain;
	}

	public BigDecimal getBuyagain() {
		return buyagain;
	}

	public void setBuyagain(BigDecimal buyagain) {
		this.buyagain = buyagain;
	}

	public Boolean getBuyagainIslong() {
		return buyagainIslong;
	}

	public void setBuyagainIslong(Boolean buyagainIslong) {
		this.buyagainIslong = buyagainIslong;
	}

	public Boolean getBuyagainCondition() {
		return buyagainCondition;
	}

	public void setBuyagainCondition(Boolean buyagainCondition) {
		this.buyagainCondition = buyagainCondition;
	}

	public Boolean getBuyagainSale() {
		return buyagainSale;
	}

	public void setBuyagainSale(Boolean buyagainSale) {
		this.buyagainSale = buyagainSale;
	}

	public Integer getDiypage() {
		return diypage;
	}

	public void setDiypage(Integer diypage) {
		this.diypage = diypage;
	}

	public Boolean getCashier() {
		return cashier;
	}

	public void setCashier(Boolean cashier) {
		this.cashier = cashier;
	}

	public Byte getIsendtime() {
		return isendtime;
	}

	public void setIsendtime(Byte isendtime) {
		this.isendtime = isendtime;
	}

	public Integer getUsetime() {
		return usetime;
	}

	public void setUsetime(Integer usetime) {
		this.usetime = usetime;
	}

	public Integer getEndtime() {
		return endtime;
	}

	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}

	public Integer getMerchdisplayorder() {
		return merchdisplayorder;
	}

	public void setMerchdisplayorder(Integer merchdisplayorder) {
		this.merchdisplayorder = merchdisplayorder;
	}

	public Integer getExchangeStock() {
		return exchangeStock;
	}

	public void setExchangeStock(Integer exchangeStock) {
		this.exchangeStock = exchangeStock;
	}

	public BigDecimal getExchangePostage() {
		return exchangePostage;
	}

	public void setExchangePostage(BigDecimal exchangePostage) {
		this.exchangePostage = exchangePostage;
	}

	public Byte getIspresell() {
		return ispresell;
	}

	public void setIspresell(Byte ispresell) {
		this.ispresell = ispresell;
	}

	public BigDecimal getPresellprice() {
		return presellprice;
	}

	public void setPresellprice(BigDecimal presellprice) {
		this.presellprice = presellprice;
	}

	public Byte getPresellover() {
		return presellover;
	}

	public void setPresellover(Byte presellover) {
		this.presellover = presellover;
	}

	public Integer getPresellovertime() {
		return presellovertime;
	}

	public void setPresellovertime(Integer presellovertime) {
		this.presellovertime = presellovertime;
	}

	public Byte getPresellstart() {
		return presellstart;
	}

	public void setPresellstart(Byte presellstart) {
		this.presellstart = presellstart;
	}

	public Integer getPreselltimestart() {
		return preselltimestart;
	}

	public void setPreselltimestart(Integer preselltimestart) {
		this.preselltimestart = preselltimestart;
	}

	public Byte getPresellend() {
		return presellend;
	}

	public void setPresellend(Byte presellend) {
		this.presellend = presellend;
	}

	public Integer getPreselltimeend() {
		return preselltimeend;
	}

	public void setPreselltimeend(Integer preselltimeend) {
		this.preselltimeend = preselltimeend;
	}

	public Byte getPresellsendtype() {
		return presellsendtype;
	}

	public void setPresellsendtype(Byte presellsendtype) {
		this.presellsendtype = presellsendtype;
	}

	public Integer getPresellsendstatrttime() {
		return presellsendstatrttime;
	}

	public void setPresellsendstatrttime(Integer presellsendstatrttime) {
		this.presellsendstatrttime = presellsendstatrttime;
	}

	public Integer getPresellsendtime() {
		return presellsendtime;
	}

	public void setPresellsendtime(Integer presellsendtime) {
		this.presellsendtime = presellsendtime;
	}

	public String getEdareasCode() {
		return edareasCode;
	}

	public void setEdareasCode(String edareasCode) {
		this.edareasCode = edareasCode;
	}

	public Integer getIsMill() {
		return isMill;
	}

	public void setIsMill(Integer isMill) {
		this.isMill = isMill;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public Byte getJoinSource() {
		return joinSource;
	}

	public void setJoinSource(Byte joinSource) {
		this.joinSource = joinSource;
	}

	public BigDecimal getExtraDiscount() {
		return extraDiscount;
	}

	public void setExtraDiscount(BigDecimal extraDiscount) {
		this.extraDiscount = extraDiscount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImsEweiShopGoods [id=" + id + ", uniacid=" + uniacid + ", pcate=" + pcate + ", ccate=" + ccate
				+ ", tcate=" + tcate + ", type=" + type + ", status=" + status + ", displayorder=" + displayorder
				+ ", title=" + title + ", thumb=" + thumb + ", thumbUrl=" + thumbUrl + ", unit=" + unit
				+ ", description=" + description + ", goodssn=" + goodssn + ", productsn=" + productsn
				+ ", productprice=" + productprice + ", marketprice=" + marketprice + ", costprice=" + costprice
				+ ", originalprice=" + originalprice + ", total=" + total + ", totalcnf=" + totalcnf + ", sales="
				+ sales + ", salesreal=" + salesreal + ", spec=" + spec + ", createtime=" + createtime + ", weight="
				+ weight + ", credit=" + credit + ", maxbuy=" + maxbuy + ", usermaxbuy=" + usermaxbuy + ", hasoption="
				+ hasoption + ", dispatch=" + dispatch + ", isnew=" + isnew + ", ishot=" + ishot + ", isdiscount="
				+ isdiscount + ", isdiscountTitle=" + isdiscountTitle + ", isdiscountTime=" + isdiscountTime
				+ ", isrecommand=" + isrecommand + ", issendfree=" + issendfree + ", istime=" + istime + ", iscomment="
				+ iscomment + ", timestart=" + timestart + ", timeend=" + timeend + ", viewcount=" + viewcount
				+ ", deleted=" + deleted + ", hascommission=" + hascommission + ", commission1Rate=" + commission1Rate
				+ ", commission1Pay=" + commission1Pay + ", commission2Rate=" + commission2Rate + ", commission2Pay="
				+ commission2Pay + ", commission3Rate=" + commission3Rate + ", commission3Pay=" + commission3Pay
				+ ", score=" + score + ", taobaoid=" + taobaoid + ", taotaoid=" + taotaoid + ", taobaourl=" + taobaourl
				+ ", updatetime=" + updatetime + ", shareTitle=" + shareTitle + ", shareIcon=" + shareIcon + ", cash="
				+ cash + ", commissionThumb=" + commissionThumb + ", isnodiscount=" + isnodiscount + ", isverify="
				+ isverify + ", noticeopenid=" + noticeopenid + ", needfollow=" + needfollow + ", followurl="
				+ followurl + ", followtip=" + followtip + ", deduct=" + deduct + ", shorttitle=" + shorttitle
				+ ", virtual=" + virtual + ", nocommission=" + nocommission + ", hidecommission=" + hidecommission
				+ ", detailLogo=" + detailLogo + ", detailShopname=" + detailShopname + ", detailTotaltitle="
				+ detailTotaltitle + ", detailBtntext1=" + detailBtntext1 + ", detailBtnurl1=" + detailBtnurl1
				+ ", detailBtntext2=" + detailBtntext2 + ", detailBtnurl2=" + detailBtnurl2 + ", artid=" + artid
				+ ", deduct2=" + deduct2 + ", ednum=" + ednum + ", edmoney=" + edmoney + ", diyformtype=" + diyformtype
				+ ", diyformid=" + diyformid + ", diymode=" + diymode + ", dispatchtype=" + dispatchtype
				+ ", dispatchid=" + dispatchid + ", dispatchprice=" + dispatchprice + ", manydeduct=" + manydeduct
				+ ", saleupdate37975=" + saleupdate37975 + ", shopid=" + shopid + ", minbuy=" + minbuy + ", invoice="
				+ invoice + ", repair=" + repair + ", seven=" + seven + ", money=" + money + ", minprice=" + minprice
				+ ", maxprice=" + maxprice + ", province=" + province + ", city=" + city + ", buyshow=" + buyshow
				+ ", saleupdate51117=" + saleupdate51117 + ", virtualsend=" + virtualsend + ", verifytype=" + verifytype
				+ ", diysaveid=" + diysaveid + ", diysave=" + diysave + ", quality=" + quality + ", groupstype="
				+ groupstype + ", showtotal=" + showtotal + ", subtitle=" + subtitle + ", sharebtn=" + sharebtn
				+ ", merchid=" + merchid + ", checked=" + checked + ", thumbFirst=" + thumbFirst + ", showtotaladd="
				+ showtotaladd + ", merchsale=" + merchsale + ", keywords=" + keywords + ", catchId=" + catchId
				+ ", catchUrl=" + catchUrl + ", catchSource=" + catchSource + ", autoreceive=" + autoreceive
				+ ", cannotrefund=" + cannotrefund + ", bargain=" + bargain + ", buyagain=" + buyagain
				+ ", buyagainIslong=" + buyagainIslong + ", buyagainCondition=" + buyagainCondition + ", buyagainSale="
				+ buyagainSale + ", diypage=" + diypage + ", cashier=" + cashier + ", isendtime=" + isendtime
				+ ", usetime=" + usetime + ", endtime=" + endtime + ", merchdisplayorder=" + merchdisplayorder
				+ ", exchangeStock=" + exchangeStock + ", exchangePostage=" + exchangePostage + ", ispresell="
				+ ispresell + ", presellprice=" + presellprice + ", presellover=" + presellover + ", presellovertime="
				+ presellovertime + ", presellstart=" + presellstart + ", preselltimestart=" + preselltimestart
				+ ", presellend=" + presellend + ", preselltimeend=" + preselltimeend + ", presellsendtype="
				+ presellsendtype + ", presellsendstatrttime=" + presellsendstatrttime + ", presellsendtime="
				+ presellsendtime + ", edareasCode=" + edareasCode + ", isMill=" + isMill + ", orderType=" + orderType
				+ ", services=" + services + ", joinSource=" + joinSource + ", extraDiscount=" + extraDiscount + "]";
	}
}