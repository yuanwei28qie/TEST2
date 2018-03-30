package com.microsilver.mrcard.serviceplatform.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value=Include.NON_NULL)
public class ImsEweiShopOrderGoods implements Serializable {
    private Integer id;

    private Integer uniacid;

    private Long orderid;

    private Integer goodsid;

    private String title;
    private String thumb;
    
    private BigDecimal price;

    private Integer total;

    private Integer optionid;
    
    private String optionname;

    public String getOptionname() {
		return optionname;
	}

	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}

	private Integer createtime;

    private Integer applytime1;

    private Integer checktime1;

    private Integer paytime1;

    private Integer invalidtime1;

    private Integer deletetime1;

    private Byte status1;

    private Integer applytime2;

    private Integer checktime2;

    private Integer paytime2;

    private Integer invalidtime2;

    private Integer deletetime2;

    private Byte status2;

    private Integer applytime3;

    private Integer checktime3;

    private Integer paytime3;

    private Integer invalidtime3;

    private Integer deletetime3;

    private Byte status3;

    private BigDecimal realprice;

    private String goodssn;

    private String productsn;

    private Byte nocommission;

    private BigDecimal changeprice;

    private BigDecimal oldprice;

    private Integer diyformdataid;

    private String openid;

    private Integer diyformid;

    private Byte rstate;

    private Integer refundtime;

    private Integer printstate;

    private Integer printstate2;

    private Integer merchid;

    private Integer parentorderid;

    private Byte merchsale;

    private BigDecimal isdiscountprice;

    private Boolean canbuyagain;

    private Byte seckill;

    private Integer seckillTaskid;

    private Integer seckillRoomid;

    private Integer seckillTimeid;

    private Byte sendtype;

    private String expresscom;

    private String expresssn;

    private String express;

    private Integer sendtime;

    private Integer finishtime;
    
    /**
     * 商品结算价
     */
    private BigDecimal costprice;
    /**
     * 商品卖价
     */
    private BigDecimal presellprice;
    /**
     * 补贴金额
     */
    private BigDecimal subsidyprice;
    
    
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

	public BigDecimal getCostprice() {
		return costprice;
	}

	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}

	public BigDecimal getPresellprice() {
		return presellprice;
	}

	public void setPresellprice(BigDecimal presellprice) {
		this.presellprice = presellprice;
	}

	public BigDecimal getSubsidyprice() {
		return subsidyprice;
	}

	public void setSubsidyprice(BigDecimal subsidyprice) {
		this.subsidyprice = subsidyprice;
	}

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

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOptionid() {
        return optionid;
    }

    public void setOptionid(Integer optionid) {
        this.optionid = optionid;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getApplytime1() {
        return applytime1;
    }

    public void setApplytime1(Integer applytime1) {
        this.applytime1 = applytime1;
    }

    public Integer getChecktime1() {
        return checktime1;
    }

    public void setChecktime1(Integer checktime1) {
        this.checktime1 = checktime1;
    }

    public Integer getPaytime1() {
        return paytime1;
    }

    public void setPaytime1(Integer paytime1) {
        this.paytime1 = paytime1;
    }

    public Integer getInvalidtime1() {
        return invalidtime1;
    }

    public void setInvalidtime1(Integer invalidtime1) {
        this.invalidtime1 = invalidtime1;
    }

    public Integer getDeletetime1() {
        return deletetime1;
    }

    public void setDeletetime1(Integer deletetime1) {
        this.deletetime1 = deletetime1;
    }

    public Byte getStatus1() {
        return status1;
    }

    public void setStatus1(Byte status1) {
        this.status1 = status1;
    }

    public Integer getApplytime2() {
        return applytime2;
    }

    public void setApplytime2(Integer applytime2) {
        this.applytime2 = applytime2;
    }

    public Integer getChecktime2() {
        return checktime2;
    }

    public void setChecktime2(Integer checktime2) {
        this.checktime2 = checktime2;
    }

    public Integer getPaytime2() {
        return paytime2;
    }

    public void setPaytime2(Integer paytime2) {
        this.paytime2 = paytime2;
    }

    public Integer getInvalidtime2() {
        return invalidtime2;
    }

    public void setInvalidtime2(Integer invalidtime2) {
        this.invalidtime2 = invalidtime2;
    }

    public Integer getDeletetime2() {
        return deletetime2;
    }

    public void setDeletetime2(Integer deletetime2) {
        this.deletetime2 = deletetime2;
    }

    public Byte getStatus2() {
        return status2;
    }

    public void setStatus2(Byte status2) {
        this.status2 = status2;
    }

    public Integer getApplytime3() {
        return applytime3;
    }

    public void setApplytime3(Integer applytime3) {
        this.applytime3 = applytime3;
    }

    public Integer getChecktime3() {
        return checktime3;
    }

    public void setChecktime3(Integer checktime3) {
        this.checktime3 = checktime3;
    }

    public Integer getPaytime3() {
        return paytime3;
    }

    public void setPaytime3(Integer paytime3) {
        this.paytime3 = paytime3;
    }

    public Integer getInvalidtime3() {
        return invalidtime3;
    }

    public void setInvalidtime3(Integer invalidtime3) {
        this.invalidtime3 = invalidtime3;
    }

    public Integer getDeletetime3() {
        return deletetime3;
    }

    public void setDeletetime3(Integer deletetime3) {
        this.deletetime3 = deletetime3;
    }

    public Byte getStatus3() {
        return status3;
    }

    public void setStatus3(Byte status3) {
        this.status3 = status3;
    }

    public BigDecimal getRealprice() {
        return realprice;
    }

    public void setRealprice(BigDecimal realprice) {
        this.realprice = realprice;
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

    public Byte getNocommission() {
        return nocommission;
    }

    public void setNocommission(Byte nocommission) {
        this.nocommission = nocommission;
    }

    public BigDecimal getChangeprice() {
        return changeprice;
    }

    public void setChangeprice(BigDecimal changeprice) {
        this.changeprice = changeprice;
    }

    public BigDecimal getOldprice() {
        return oldprice;
    }

    public void setOldprice(BigDecimal oldprice) {
        this.oldprice = oldprice;
    }

    public Integer getDiyformdataid() {
        return diyformdataid;
    }

    public void setDiyformdataid(Integer diyformdataid) {
        this.diyformdataid = diyformdataid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getDiyformid() {
        return diyformid;
    }

    public void setDiyformid(Integer diyformid) {
        this.diyformid = diyformid;
    }

    public Byte getRstate() {
        return rstate;
    }

    public void setRstate(Byte rstate) {
        this.rstate = rstate;
    }

    public Integer getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(Integer refundtime) {
        this.refundtime = refundtime;
    }

    public Integer getPrintstate() {
        return printstate;
    }

    public void setPrintstate(Integer printstate) {
        this.printstate = printstate;
    }

    public Integer getPrintstate2() {
        return printstate2;
    }

    public void setPrintstate2(Integer printstate2) {
        this.printstate2 = printstate2;
    }

    public Integer getMerchid() {
        return merchid;
    }

    public void setMerchid(Integer merchid) {
        this.merchid = merchid;
    }

    public Integer getParentorderid() {
        return parentorderid;
    }

    public void setParentorderid(Integer parentorderid) {
        this.parentorderid = parentorderid;
    }

    public Byte getMerchsale() {
        return merchsale;
    }

    public void setMerchsale(Byte merchsale) {
        this.merchsale = merchsale;
    }

    public BigDecimal getIsdiscountprice() {
        return isdiscountprice;
    }

    public void setIsdiscountprice(BigDecimal isdiscountprice) {
        this.isdiscountprice = isdiscountprice;
    }

    public Boolean getCanbuyagain() {
        return canbuyagain;
    }

    public void setCanbuyagain(Boolean canbuyagain) {
        this.canbuyagain = canbuyagain;
    }

    public Byte getSeckill() {
        return seckill;
    }

    public void setSeckill(Byte seckill) {
        this.seckill = seckill;
    }

    public Integer getSeckillTaskid() {
        return seckillTaskid;
    }

    public void setSeckillTaskid(Integer seckillTaskid) {
        this.seckillTaskid = seckillTaskid;
    }

    public Integer getSeckillRoomid() {
        return seckillRoomid;
    }

    public void setSeckillRoomid(Integer seckillRoomid) {
        this.seckillRoomid = seckillRoomid;
    }

    public Integer getSeckillTimeid() {
        return seckillTimeid;
    }

    public void setSeckillTimeid(Integer seckillTimeid) {
        this.seckillTimeid = seckillTimeid;
    }

    public Byte getSendtype() {
        return sendtype;
    }

    public void setSendtype(Byte sendtype) {
        this.sendtype = sendtype;
    }

    public String getExpresscom() {
        return expresscom;
    }

    public void setExpresscom(String expresscom) {
        this.expresscom = expresscom;
    }

    public String getExpresssn() {
        return expresssn;
    }

    public void setExpresssn(String expresssn) {
        this.expresssn = expresssn;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public Integer getSendtime() {
        return sendtime;
    }

    public void setSendtime(Integer sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Integer finishtime) {
        this.finishtime = finishtime;
    }

	@Override
	public String toString() {
		return "ImsEweiShopOrderGoods [id=" + id + ", uniacid=" + uniacid + ", orderid=" + orderid + ", goodsid="
				+ goodsid + ", price=" + price + ", total=" + total + ", optionid=" + optionid + ", optionname="
				+ optionname + ", createtime=" + createtime + ", applytime1=" + applytime1 + ", checktime1="
				+ checktime1 + ", paytime1=" + paytime1 + ", invalidtime1=" + invalidtime1 + ", deletetime1="
				+ deletetime1 + ", status1=" + status1 + ", applytime2=" + applytime2 + ", checktime2=" + checktime2
				+ ", paytime2=" + paytime2 + ", invalidtime2=" + invalidtime2 + ", deletetime2=" + deletetime2
				+ ", status2=" + status2 + ", applytime3=" + applytime3 + ", checktime3=" + checktime3 + ", paytime3="
				+ paytime3 + ", invalidtime3=" + invalidtime3 + ", deletetime3=" + deletetime3 + ", status3=" + status3
				+ ", realprice=" + realprice + ", goodssn=" + goodssn + ", productsn=" + productsn + ", nocommission="
				+ nocommission + ", changeprice=" + changeprice + ", oldprice=" + oldprice + ", diyformdataid="
				+ diyformdataid + ", openid=" + openid + ", diyformid=" + diyformid + ", rstate=" + rstate
				+ ", refundtime=" + refundtime + ", printstate=" + printstate + ", printstate2=" + printstate2
				+ ", merchid=" + merchid + ", parentorderid=" + parentorderid + ", merchsale=" + merchsale
				+ ", isdiscountprice=" + isdiscountprice + ", canbuyagain=" + canbuyagain + ", seckill=" + seckill
				+ ", seckillTaskid=" + seckillTaskid + ", seckillRoomid=" + seckillRoomid + ", seckillTimeid="
				+ seckillTimeid + ", sendtype=" + sendtype + ", expresscom=" + expresscom + ", expresssn=" + expresssn
				+ ", express=" + express + ", sendtime=" + sendtime + ", finishtime=" + finishtime + ", costprice="
				+ costprice + ", presellprice=" + presellprice + ", subsidyprice=" + subsidyprice + "]";
	}
}