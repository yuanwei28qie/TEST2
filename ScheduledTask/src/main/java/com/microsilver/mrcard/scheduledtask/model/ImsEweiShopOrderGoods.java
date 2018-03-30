package com.microsilver.mrcard.scheduledtask.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImsEweiShopOrderGoods implements Serializable {
    private Integer id;

    private Integer uniacid;

    private Long orderid;

    private Integer goodsid;

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
        ImsEweiShopOrderGoods other = (ImsEweiShopOrderGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniacid() == null ? other.getUniacid() == null : this.getUniacid().equals(other.getUniacid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getGoodsid() == null ? other.getGoodsid() == null : this.getGoodsid().equals(other.getGoodsid()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getOptionid() == null ? other.getOptionid() == null : this.getOptionid().equals(other.getOptionid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getApplytime1() == null ? other.getApplytime1() == null : this.getApplytime1().equals(other.getApplytime1()))
            && (this.getChecktime1() == null ? other.getChecktime1() == null : this.getChecktime1().equals(other.getChecktime1()))
            && (this.getPaytime1() == null ? other.getPaytime1() == null : this.getPaytime1().equals(other.getPaytime1()))
            && (this.getInvalidtime1() == null ? other.getInvalidtime1() == null : this.getInvalidtime1().equals(other.getInvalidtime1()))
            && (this.getDeletetime1() == null ? other.getDeletetime1() == null : this.getDeletetime1().equals(other.getDeletetime1()))
            && (this.getStatus1() == null ? other.getStatus1() == null : this.getStatus1().equals(other.getStatus1()))
            && (this.getApplytime2() == null ? other.getApplytime2() == null : this.getApplytime2().equals(other.getApplytime2()))
            && (this.getChecktime2() == null ? other.getChecktime2() == null : this.getChecktime2().equals(other.getChecktime2()))
            && (this.getPaytime2() == null ? other.getPaytime2() == null : this.getPaytime2().equals(other.getPaytime2()))
            && (this.getInvalidtime2() == null ? other.getInvalidtime2() == null : this.getInvalidtime2().equals(other.getInvalidtime2()))
            && (this.getDeletetime2() == null ? other.getDeletetime2() == null : this.getDeletetime2().equals(other.getDeletetime2()))
            && (this.getStatus2() == null ? other.getStatus2() == null : this.getStatus2().equals(other.getStatus2()))
            && (this.getApplytime3() == null ? other.getApplytime3() == null : this.getApplytime3().equals(other.getApplytime3()))
            && (this.getChecktime3() == null ? other.getChecktime3() == null : this.getChecktime3().equals(other.getChecktime3()))
            && (this.getPaytime3() == null ? other.getPaytime3() == null : this.getPaytime3().equals(other.getPaytime3()))
            && (this.getInvalidtime3() == null ? other.getInvalidtime3() == null : this.getInvalidtime3().equals(other.getInvalidtime3()))
            && (this.getDeletetime3() == null ? other.getDeletetime3() == null : this.getDeletetime3().equals(other.getDeletetime3()))
            && (this.getStatus3() == null ? other.getStatus3() == null : this.getStatus3().equals(other.getStatus3()))
            && (this.getRealprice() == null ? other.getRealprice() == null : this.getRealprice().equals(other.getRealprice()))
            && (this.getGoodssn() == null ? other.getGoodssn() == null : this.getGoodssn().equals(other.getGoodssn()))
            && (this.getProductsn() == null ? other.getProductsn() == null : this.getProductsn().equals(other.getProductsn()))
            && (this.getNocommission() == null ? other.getNocommission() == null : this.getNocommission().equals(other.getNocommission()))
            && (this.getChangeprice() == null ? other.getChangeprice() == null : this.getChangeprice().equals(other.getChangeprice()))
            && (this.getOldprice() == null ? other.getOldprice() == null : this.getOldprice().equals(other.getOldprice()))
            && (this.getDiyformdataid() == null ? other.getDiyformdataid() == null : this.getDiyformdataid().equals(other.getDiyformdataid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getDiyformid() == null ? other.getDiyformid() == null : this.getDiyformid().equals(other.getDiyformid()))
            && (this.getRstate() == null ? other.getRstate() == null : this.getRstate().equals(other.getRstate()))
            && (this.getRefundtime() == null ? other.getRefundtime() == null : this.getRefundtime().equals(other.getRefundtime()))
            && (this.getPrintstate() == null ? other.getPrintstate() == null : this.getPrintstate().equals(other.getPrintstate()))
            && (this.getPrintstate2() == null ? other.getPrintstate2() == null : this.getPrintstate2().equals(other.getPrintstate2()))
            && (this.getMerchid() == null ? other.getMerchid() == null : this.getMerchid().equals(other.getMerchid()))
            && (this.getParentorderid() == null ? other.getParentorderid() == null : this.getParentorderid().equals(other.getParentorderid()))
            && (this.getMerchsale() == null ? other.getMerchsale() == null : this.getMerchsale().equals(other.getMerchsale()))
            && (this.getIsdiscountprice() == null ? other.getIsdiscountprice() == null : this.getIsdiscountprice().equals(other.getIsdiscountprice()))
            && (this.getCanbuyagain() == null ? other.getCanbuyagain() == null : this.getCanbuyagain().equals(other.getCanbuyagain()))
            && (this.getSeckill() == null ? other.getSeckill() == null : this.getSeckill().equals(other.getSeckill()))
            && (this.getSeckillTaskid() == null ? other.getSeckillTaskid() == null : this.getSeckillTaskid().equals(other.getSeckillTaskid()))
            && (this.getSeckillRoomid() == null ? other.getSeckillRoomid() == null : this.getSeckillRoomid().equals(other.getSeckillRoomid()))
            && (this.getSeckillTimeid() == null ? other.getSeckillTimeid() == null : this.getSeckillTimeid().equals(other.getSeckillTimeid()))
            && (this.getSendtype() == null ? other.getSendtype() == null : this.getSendtype().equals(other.getSendtype()))
            && (this.getExpresscom() == null ? other.getExpresscom() == null : this.getExpresscom().equals(other.getExpresscom()))
            && (this.getExpresssn() == null ? other.getExpresssn() == null : this.getExpresssn().equals(other.getExpresssn()))
            && (this.getExpress() == null ? other.getExpress() == null : this.getExpress().equals(other.getExpress()))
            && (this.getSendtime() == null ? other.getSendtime() == null : this.getSendtime().equals(other.getSendtime()))
            && (this.getFinishtime() == null ? other.getFinishtime() == null : this.getFinishtime().equals(other.getFinishtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniacid() == null) ? 0 : getUniacid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getGoodsid() == null) ? 0 : getGoodsid().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getOptionid() == null) ? 0 : getOptionid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getApplytime1() == null) ? 0 : getApplytime1().hashCode());
        result = prime * result + ((getChecktime1() == null) ? 0 : getChecktime1().hashCode());
        result = prime * result + ((getPaytime1() == null) ? 0 : getPaytime1().hashCode());
        result = prime * result + ((getInvalidtime1() == null) ? 0 : getInvalidtime1().hashCode());
        result = prime * result + ((getDeletetime1() == null) ? 0 : getDeletetime1().hashCode());
        result = prime * result + ((getStatus1() == null) ? 0 : getStatus1().hashCode());
        result = prime * result + ((getApplytime2() == null) ? 0 : getApplytime2().hashCode());
        result = prime * result + ((getChecktime2() == null) ? 0 : getChecktime2().hashCode());
        result = prime * result + ((getPaytime2() == null) ? 0 : getPaytime2().hashCode());
        result = prime * result + ((getInvalidtime2() == null) ? 0 : getInvalidtime2().hashCode());
        result = prime * result + ((getDeletetime2() == null) ? 0 : getDeletetime2().hashCode());
        result = prime * result + ((getStatus2() == null) ? 0 : getStatus2().hashCode());
        result = prime * result + ((getApplytime3() == null) ? 0 : getApplytime3().hashCode());
        result = prime * result + ((getChecktime3() == null) ? 0 : getChecktime3().hashCode());
        result = prime * result + ((getPaytime3() == null) ? 0 : getPaytime3().hashCode());
        result = prime * result + ((getInvalidtime3() == null) ? 0 : getInvalidtime3().hashCode());
        result = prime * result + ((getDeletetime3() == null) ? 0 : getDeletetime3().hashCode());
        result = prime * result + ((getStatus3() == null) ? 0 : getStatus3().hashCode());
        result = prime * result + ((getRealprice() == null) ? 0 : getRealprice().hashCode());
        result = prime * result + ((getGoodssn() == null) ? 0 : getGoodssn().hashCode());
        result = prime * result + ((getProductsn() == null) ? 0 : getProductsn().hashCode());
        result = prime * result + ((getNocommission() == null) ? 0 : getNocommission().hashCode());
        result = prime * result + ((getChangeprice() == null) ? 0 : getChangeprice().hashCode());
        result = prime * result + ((getOldprice() == null) ? 0 : getOldprice().hashCode());
        result = prime * result + ((getDiyformdataid() == null) ? 0 : getDiyformdataid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getDiyformid() == null) ? 0 : getDiyformid().hashCode());
        result = prime * result + ((getRstate() == null) ? 0 : getRstate().hashCode());
        result = prime * result + ((getRefundtime() == null) ? 0 : getRefundtime().hashCode());
        result = prime * result + ((getPrintstate() == null) ? 0 : getPrintstate().hashCode());
        result = prime * result + ((getPrintstate2() == null) ? 0 : getPrintstate2().hashCode());
        result = prime * result + ((getMerchid() == null) ? 0 : getMerchid().hashCode());
        result = prime * result + ((getParentorderid() == null) ? 0 : getParentorderid().hashCode());
        result = prime * result + ((getMerchsale() == null) ? 0 : getMerchsale().hashCode());
        result = prime * result + ((getIsdiscountprice() == null) ? 0 : getIsdiscountprice().hashCode());
        result = prime * result + ((getCanbuyagain() == null) ? 0 : getCanbuyagain().hashCode());
        result = prime * result + ((getSeckill() == null) ? 0 : getSeckill().hashCode());
        result = prime * result + ((getSeckillTaskid() == null) ? 0 : getSeckillTaskid().hashCode());
        result = prime * result + ((getSeckillRoomid() == null) ? 0 : getSeckillRoomid().hashCode());
        result = prime * result + ((getSeckillTimeid() == null) ? 0 : getSeckillTimeid().hashCode());
        result = prime * result + ((getSendtype() == null) ? 0 : getSendtype().hashCode());
        result = prime * result + ((getExpresscom() == null) ? 0 : getExpresscom().hashCode());
        result = prime * result + ((getExpresssn() == null) ? 0 : getExpresssn().hashCode());
        result = prime * result + ((getExpress() == null) ? 0 : getExpress().hashCode());
        result = prime * result + ((getSendtime() == null) ? 0 : getSendtime().hashCode());
        result = prime * result + ((getFinishtime() == null) ? 0 : getFinishtime().hashCode());
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
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append(", optionid=").append(optionid);
        sb.append(", createtime=").append(createtime);
        sb.append(", applytime1=").append(applytime1);
        sb.append(", checktime1=").append(checktime1);
        sb.append(", paytime1=").append(paytime1);
        sb.append(", invalidtime1=").append(invalidtime1);
        sb.append(", deletetime1=").append(deletetime1);
        sb.append(", status1=").append(status1);
        sb.append(", applytime2=").append(applytime2);
        sb.append(", checktime2=").append(checktime2);
        sb.append(", paytime2=").append(paytime2);
        sb.append(", invalidtime2=").append(invalidtime2);
        sb.append(", deletetime2=").append(deletetime2);
        sb.append(", status2=").append(status2);
        sb.append(", applytime3=").append(applytime3);
        sb.append(", checktime3=").append(checktime3);
        sb.append(", paytime3=").append(paytime3);
        sb.append(", invalidtime3=").append(invalidtime3);
        sb.append(", deletetime3=").append(deletetime3);
        sb.append(", status3=").append(status3);
        sb.append(", realprice=").append(realprice);
        sb.append(", goodssn=").append(goodssn);
        sb.append(", productsn=").append(productsn);
        sb.append(", nocommission=").append(nocommission);
        sb.append(", changeprice=").append(changeprice);
        sb.append(", oldprice=").append(oldprice);
        sb.append(", diyformdataid=").append(diyformdataid);
        sb.append(", openid=").append(openid);
        sb.append(", diyformid=").append(diyformid);
        sb.append(", rstate=").append(rstate);
        sb.append(", refundtime=").append(refundtime);
        sb.append(", printstate=").append(printstate);
        sb.append(", printstate2=").append(printstate2);
        sb.append(", merchid=").append(merchid);
        sb.append(", parentorderid=").append(parentorderid);
        sb.append(", merchsale=").append(merchsale);
        sb.append(", isdiscountprice=").append(isdiscountprice);
        sb.append(", canbuyagain=").append(canbuyagain);
        sb.append(", seckill=").append(seckill);
        sb.append(", seckillTaskid=").append(seckillTaskid);
        sb.append(", seckillRoomid=").append(seckillRoomid);
        sb.append(", seckillTimeid=").append(seckillTimeid);
        sb.append(", sendtype=").append(sendtype);
        sb.append(", expresscom=").append(expresscom);
        sb.append(", expresssn=").append(expresssn);
        sb.append(", express=").append(express);
        sb.append(", sendtime=").append(sendtime);
        sb.append(", finishtime=").append(finishtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}