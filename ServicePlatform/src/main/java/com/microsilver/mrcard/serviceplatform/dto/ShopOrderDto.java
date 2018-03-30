package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.dto.ShopOrderDto
 * @Description 商城订单传输实体类
 * 
 * @Author bruce
 * @Version 2017年7月4日 上午11:57:49
 * @Copyright Micro Silver
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class ShopOrderDto implements Serializable{
	/**
	 * 订单ID
	 */
	@ApiModelProperty(value = "订单ID")
	private Long orderId;
	/**
	 * 订单编号
	 */
	@ApiModelProperty(value = "订单编号")
	private String ordersn;
	/**
	 * 商家编号
	 */
	private Long merchId;
	/**
	 * 商家名称
	 */
	private String merchname;
	/**
	 * 商家联系点哈
	 */
	@ApiModelProperty(value = "商家联系电话")
	private String merchNameTel;
	/**
	 * 订单金额(含运费)
	 */
	@ApiModelProperty(value = "订单金额(含运费)")
	private BigDecimal price;
	/**
	 * 商品金额(不含运费)
	 */
	@ApiModelProperty(value = "商品金额(不含运费)")
	private BigDecimal goodsprice;
	/**
	 * 运费
	 */
	@ApiModelProperty(value = "运费")
	private BigDecimal dispatchprice;
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "订单状态(0:未付款,1:(用户)已付款,11:(商家)分拣,12:(快递员)抢单,2：(商家)已发货,3:(用户)已收货,待评价，4：退款,5.已取消,6.已完成)")
	private int status;
	/**
	 * 收货人地址Id
	 */
	private Long addressid;
	/**
	 * 商品图片,多个以逗号分隔
	 */
	@ApiModelProperty(value = "商品图片,多个以逗号分隔")
	private String thumb;
	/**
	 * 商品名称,多个以逗号分隔
	 */
	@ApiModelProperty(value = "商品名称,多个以逗号分隔")
	private String title;
	
	@ApiModelProperty(value = "下单时间")
	private Long createtime;
	
	/**
	 * 付款时间
	 */
	@ApiModelProperty(value = "付款时间")
	private Long paytime;
	/**
	 * 分拣时间
	 */
	@ApiModelProperty(value = "分拣时间")
	private Long sortingtime;
	/**
	 * 抢单时间
	 */
	@ApiModelProperty(value = "抢单时间")
	private Long fetchtime;
	/**
	 * 发货时间
	 */
	@ApiModelProperty(value = "发货时间")
	private Long sendtime;
	/**
	 * 完成时间
	 */
	@ApiModelProperty(value = "完成时间")
	private Long finishtime;
	/**
	 * 收货人
	 */
	@ApiModelProperty(value = "收货人")
	private String receiver;
	/**
	 * 收货人电话
	 */
	private String receiverPhone;
	/**
	 * 收货人地址
	 */
	private String receiverAddress;
	/**
	 * 卖家备注
	 */
	@ApiModelProperty(value = "卖家备注")
	private String remarksaler;
	/**
	 * 买家备注
	 */
	@ApiModelProperty(value = "买家备注")
	private String remark;
	/**
	 * 商家地址
	 */
	private String merchAddress;
	@ApiModelProperty(value = "快递员姓名备注")
	private String courierName;
	@ApiModelProperty(value = "快递员手机号")
	private String courierPhone;

	/**
	 * @Jade 2017-08-07
	 * 配送方式(0 商家配送 ,1 自提,2 不需要配送)
	 */
	@ApiModelProperty(value = " 配送方式(0 商家配送 ,1 自提,2 不需要配送)")
	private Integer dispatchtype;

	/**
	 * @Jade 2017-08-07
	 * 订单类型：1.卡先生订单 2.面对面支付 3.超级订订单,
	 */
	@ApiModelProperty(value = "订单类型：1.卡先生订单 2.面对面支付 3.超级订订单")
	private Byte orderType;
	/**
	 * @Jade 顾客昵称
	 */
	@ApiModelProperty(value = "顾客昵称")
	private String nickName;
	
	/**
	 * @Jade 顾客昵称
	 */
	@ApiModelProperty(value = "活动编号")
	private Integer activityId;
	
	private List<ShopOrderGoodsDto> goodsList;
	
	
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	
	public Long getMerchId() {
		return merchId;
	}
	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}
	public String getMerchname() {
		return merchname;
	}
	public void setMerchname(String merchname) {
		this.merchname = merchname;
	}
	
	public String getMerchNameTel() {
		return merchNameTel;
	}
	public void setMerchNameTel(String merchNameTel) {
		this.merchNameTel = merchNameTel;
	}

	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Long getAddressid() {
		return addressid;
	}
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
	public Long getPaytime() {
		return paytime;
	}
	public void setPaytime(Long paytime) {
		this.paytime = paytime;
	}
	public Long getSortingtime() {
		return sortingtime;
	}
	public void setSortingtime(Long sortingtime) {
		this.sortingtime = sortingtime;
	}
	public Long getFetchtime() {
		return fetchtime;
	}
	public void setFetchtime(Long fetchtime) {
		this.fetchtime = fetchtime;
	}
	public Long getSendtime() {
		return sendtime;
	}
	public void setSendtime(Long sendtime) {
		this.sendtime = sendtime;
	}
	public Long getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Long finishtime) {
		this.finishtime = finishtime;
	}
	
	public BigDecimal getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(BigDecimal goodsprice) {
		this.goodsprice = goodsprice;
	}
	public BigDecimal getDispatchprice() {
		return dispatchprice;
	}
	public void setDispatchprice(BigDecimal dispatchprice) {
		this.dispatchprice = dispatchprice;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getRemarksaler() {
		return remarksaler;
	}
	public void setRemarksaler(String remarksaler) {
		this.remarksaler = remarksaler;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<ShopOrderGoodsDto> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<ShopOrderGoodsDto> goodsList) {
		this.goodsList = goodsList;
	}
	public String getMerchAddress() {
		return merchAddress;
	}
	public void setMerchAddress(String merchAddress) {
		this.merchAddress = merchAddress;
	}
	
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public String getCourierPhone() {
		return courierPhone;
	}
	public void setCourierPhone(String courierPhone) {
		this.courierPhone = courierPhone;
	}

	public Integer getDispatchtype() {
		return dispatchtype;
	}

	public void setDispatchtype(Integer dispatchtype) {
		this.dispatchtype = dispatchtype;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "ShopOrderDto [orderId=" + orderId + ", ordersn=" + ordersn + ", merchId=" + merchId + ", merchname="
				+ merchname + ", price=" + price + ", goodsprice=" + goodsprice + ", dispatchprice=" + dispatchprice
				+ ", status=" + status + ", addressid=" + addressid + ", thumb=" + thumb + ", title=" + title
				+ ", paytime=" + paytime + ", sortingtime=" + sortingtime + ", fetchtime=" + fetchtime + ", sendtime="
				+ sendtime + ", finishtime=" + finishtime + ", receiver=" + receiver + ", receiverPhone="
				+ receiverPhone + ", receiverAddress=" + receiverAddress + ", remarksaler=" + remarksaler + ", remark="
				+ remark + ", merchAddress=" + merchAddress + ", goodsList=" + goodsList + "]";
	}
	
	
}
