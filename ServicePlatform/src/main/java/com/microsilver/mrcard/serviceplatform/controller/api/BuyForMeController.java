package com.microsilver.mrcard.serviceplatform.controller.api;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.CrowdsourcingOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.EffectiveDistanceDto;
import com.microsilver.mrcard.serviceplatform.dto.IndexKnightResult;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddress;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollection;
import com.microsilver.mrcard.serviceplatform.dto.*;
import com.microsilver.mrcard.serviceplatform.model.*;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.mq.MQSendMsgHelper;
import com.microsilver.mrcard.serviceplatform.service.*;
import io.swagger.annotations.*;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.serviceplatform.controller.api.BuyForMeController
 * @Description 帮我买模块
 * @Author Jade
 * @Version 2017/8/28
 * @Copyright Micro Silver
 */


@Api(value = "/api/buyforme", description = "帮我买模块API")
@Controller
@RequestMapping("/api/buyforme")
public class BuyForMeController extends BaseController{

    @Autowired
    ImsEweiShopMemberIdentityAdditionalSmpl imsEweiShopMemberIdentityAdditionalSmpl;
    @Autowired
    MemberSmpl memberSmpl;
    @Autowired
    ImsCrowdsourcingOrderService imsCrowdsourcingOrderService;

    @Autowired
    ImsEweiShopMemberAddressSmpl imsEweiShopMemberAddressSmpl;

    @Autowired
    ImsEweiShopMemberCollectionSmpl imsEweiShopMemberCollectionSmpl;

    @Autowired
    ImsCrowdsourcingDispatchSmpl imsCrowdsourcingDispatchSmpl;

    @Autowired
    private MQSendMsgHelper mqsendMsgHelper;


    @ApiOperation(value = "在有效范围内的骑手获取", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId",value = "会员编号"),
            @ApiImplicitParam(name = "lat",value = "定点经度"),
            @ApiImplicitParam(name = "lng",value = "定点纬度"),
            @ApiImplicitParam(name = "effectiveDistance",value = "有效距离")
    })
    @RequestMapping(value = "/index")
    @ResponseBody
    public RespBaseDto<IndexDataResult> indexKnight(
            @RequestParam(name = "memberId")Long memberId,
            @RequestParam(name = "lat")  String lat,
            @RequestParam(name = "lng") String lng ,
            @RequestParam(name = "city",required = false) Long city,
            @RequestParam(name = "effectiveDistance",defaultValue = "5000") Integer effectiveDistance){
        RespBaseDto<IndexDataResult> result = new RespBaseDto<IndexDataResult>();
        IndexDataResult indexDataResult = new IndexDataResult();

        List<ImsCrowdsourcingOrder> orderList = imsCrowdsourcingOrderService.listUnFinishedOrderByKnight(memberId);
        ImsCrowdsourcingOrder order = null;
        if(null != orderList && !orderList.isEmpty()){
        	//骑手
            order = orderList.get(0);
            ImsCrowdsourcingOrder orderDetails = imsCrowdsourcingOrderService.getOrderDetails(order.getId(),null);
            indexDataResult.setOrder(orderDetails);
        }

        EffectiveDistanceDto distanceDto = new EffectiveDistanceDto();
        distanceDto.setLat(lat);
        distanceDto.setLng(lng);
        distanceDto.setCity(city);
        if(Consts.ORDER_DISTANCE != null){
            distanceDto.setEffectiveDistance(Consts.ORDER_DISTANCE);
        }else {
            distanceDto.setEffectiveDistance(effectiveDistance);
        }

        List<IndexKnightResult> list = imsEweiShopMemberIdentityAdditionalSmpl.getIndexKnight(distanceDto);

        IndexKnightResult currentCourier = null;
        //courier创建时间
        if(order != null && order.getCourier() != null){
            ImsEweiShopMember shopMember = memberSmpl.selectMemberById(order.getCourier());
            currentCourier = new IndexKnightResult();
            ImsCrowdsourcingOrder orderDetails = indexDataResult.getOrder();
            currentCourier.setId(shopMember.getId().intValue());
            currentCourier.setMobile(orderDetails.getCourierMobile());
            currentCourier.setAvatar(orderDetails.getCourierAvatar());
            currentCourier.setRealname(orderDetails.getCourierRealname());
            currentCourier.setDistance(orderDetails.getDistance());
            currentCourier.setTotalFinished(orderDetails.getCourierTotalFinished());
            currentCourier.setScore(orderDetails.getCourierScore());

            //实时坐标
            for (IndexKnightResult cour : list) {
                if (cour.getMemberId() == order.getCourier().intValue()) {
                    currentCourier.setLat(cour.getLat());
                    currentCourier.setLng(cour.getLng());
                    break;
                }
            }
            indexDataResult.setKnight(currentCourier);
        }
        if(order == null || order.getCourier() == null){
            if(null == list || list.isEmpty())
                list = new ArrayList<>();
            indexDataResult.setKnightList(list);
        }
        result.setData(indexDataResult);
        result.setMessage("OK");
        return result;
    }

    @ApiOperation(value = "获取下单页面默认数据", httpMethod = "POST")
    @RequestMapping(value = "/getPreData")
    @ResponseBody
    public RespBaseDto<PreOrderData> getPreOrderData(@RequestParam(name = "memberId")Long memberId){
        /**
         * 下单页面所需数据
         * 1，动态标签（热门商品）
         * 2，默认收货地址/最近一次收货地址
         * 3，运费列表
         * .....
         */
        PreOrderData preOrderData = new PreOrderData();

        List<ImsSysDictionary> buyLabel = DictionaryUtils.getDictionaryListByType("buy_label");
        preOrderData.setBuyLabel(buyLabel);

        ImsEweiShopMemberAddress def_add = imsEweiShopMemberAddressSmpl.queryDefaultAddress(memberId);
        preOrderData.setDefaultAddress(def_add);

        Long areaCode = 0L;
        if(def_add != null && !"".equals(def_add.getDatavalue())){
            areaCode = Long.valueOf(def_add.getDatavalue());
        }
        DateTime dateTime = new DateTime();
        ImsCrowdsourcingDispatch dispatch = imsCrowdsourcingDispatchSmpl.getCurrentDispatch(areaCode, (short) dateTime.getHourOfDay());
        preOrderData.setDispatch(dispatch);

        RespBaseDto<PreOrderData> respBaseDto = new RespBaseDto<>();
        respBaseDto.setData(preOrderData);
        respBaseDto.setMessage("OK");
        return respBaseDto;
    }

    @ApiOperation(value = "创建帮我买订单", httpMethod = "POST")
    @RequestMapping(value = "/order")
    @ResponseBody
    public RespBaseDto<Long> createOrder(HttpServletRequest request, CrowdsourcingOrderDto orderDto){
        RespBaseDto<Long> respBaseDto = new RespBaseDto<>();
        this.logger.info("创建帮我买订单："+ JSON.toJSONString(orderDto));
        List<ImsCrowdsourcingOrder> orderList = imsCrowdsourcingOrderService.listUnFinishedOrderByKnight(orderDto.getMemberId());
        if(null != orderList && !orderList.isEmpty()){
            logger.error("用户有未完成的订单", JSON.toJSONString(orderList));
            respBaseDto.setState(EWarning.UnfinishedOrder.getValue());
            respBaseDto.setMessage(EWarning.UnfinishedOrder.getName());
            return respBaseDto;
        }
        if(null == orderDto.getAddressId()){
            logger.error("收货地址不存在");
            respBaseDto.setState(EWarning.Unknown.getValue());
            respBaseDto.setMessage("收货地址不存在");
            return respBaseDto;
        }
        ImsEweiShopMemberAddress add = imsEweiShopMemberAddressSmpl.queryByAddressId(orderDto.getAddressId().intValue());
        if(null == add){
            logger.error("收货地址不存在:"+orderDto.getAddressId());
            respBaseDto.setState(EWarning.Unknown.getValue());
            respBaseDto.setMessage("收货地址不存在");
            return respBaseDto;
        }
        String headers = request.getHeader("clienttype");
        ImsCrowdsourcingOrder createOrder = new ImsCrowdsourcingOrder();
        createOrder.setServiceDesc(orderDto.getServiceDesc());
        createOrder.setGoodsEstimatePrice(orderDto.getGoodsEstimatePrice());
        createOrder.setDispatchPrice(orderDto.getDispatchPrice());
        createOrder.setTipPrice(orderDto.getTipPrice());
        createOrder.setMemberId(orderDto.getMemberId());
        createOrder.setStatus((byte)1);//create status
        if(null != headers && !"".equals(headers)) {
            createOrder.setSourceType(Byte.parseByte(headers));
        }
//        createOrder.setAreaCode(orderDto.getAreaCode());
        BigDecimal total = orderDto.getDispatchPrice().add(orderDto.getGoodsEstimatePrice());
        if(orderDto.getTipPrice() != null){
            total = total.add(orderDto.getTipPrice());
        }
        createOrder.setTotalAmount(total);
        createOrder.setAddressId(orderDto.getAddressId());
        createOrder.setReceiveName(add.getRealname());
        createOrder.setReceivePhone(add.getMobile());
        String province = add.getProvince();
        if(province==null)province="";
		String city = add.getCity();
        if(city==null)city="";
		String area = add.getArea();
        if(area==null)area="";
		String street = add.getStreet();
        if(street==null)street="";
		String address = add.getAddress();
        if(address==null)address="";
		createOrder.setReceiveAddress(new StringBuilder(province).append(city).append(area).append(street).append(address).toString());
        createOrder.setReceiveLat(add.getLat());
        createOrder.setReceiveLng(add.getLng());
//        if(add.getDatavalue() != null) {
//            createOrder.setAreaCode(Integer.parseInt(add.getDatavalue()));
//        }

        Long orderId = imsCrowdsourcingOrderService.createOrder(createOrder);
        this.logger.info("创建帮我买订单："+ orderId);
        try {
            OrderMQ mq = new OrderMQ();
            mq.setType(1);//抢单
            mq.setAppName((byte)5);//小飞侠
            mq.setOrderId(orderId.intValue());
            mq.setLat(createOrder.getReceiveLat());
            mq.setLng(createOrder.getReceiveLng());
            mq.setEffectiveDistance(Consts.ORDER_DISTANCE);
            mqsendMsgHelper.sendJSONOrderMQ(mq);
        }catch (Exception ex){
            logger.error("订单添加MQ通知异常",ex);
        }
        respBaseDto.setData(orderId);
        respBaseDto.setMessage("OK");
        return respBaseDto;
    }

    @ApiOperation(value = "添加小费", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId",value = "订单编号"),
            @ApiImplicitParam(name = "tipPrice",value = "小费"),
    })
    @RequestMapping(value = "/tipOrder")
    @ResponseBody
    public RespBaseDto<Boolean> createTipOrder(
            @RequestParam(name = "orderId")  Long orderId,
            @RequestParam(name = "tipPrice") BigDecimal tipPrice
    ){
        RespBaseDto<Boolean> respBaseDto = new RespBaseDto<>();
        this.logger.info("订单["+orderId+"]添加小费："+tipPrice);
        Boolean status = false;
        try {
            status = imsCrowdsourcingOrderService.addTipPrice(orderId,tipPrice);
            if(status) {
                respBaseDto.setMessage("OK");
            }else{
                respBaseDto.setState(EWarning.Order_ADDTIP_Exception.getValue());
            }
            respBaseDto.setData(status);
        } catch (Exception e) {
            respBaseDto.setState(EWarning.Order_NonExistent.getValue());
            respBaseDto.setMessage(EWarning.Order_NonExistent.getName());
            respBaseDto.setData(false);
            this.logger.error("添加小费出错",e);
        }
        return respBaseDto;
    }

    @ApiOperation(value = "收货验证码", httpMethod = "POST")
    @RequestMapping(value = "/pickUpNumber")
    @ResponseBody
    public RespBaseDto<String> receivingCode(  @RequestParam(name = "orderId")Long orderId){

        ImsCrowdsourcingOrder order = imsCrowdsourcingOrderService.queryOrderById(orderId);

        RespBaseDto<String> respBaseDto = new RespBaseDto<>();

        if(5 != order.getStatus()){
            respBaseDto.setMessage("无取货码");
            respBaseDto.setState(EWarning.Unknown.getValue());
        }else {
            respBaseDto.setData(order.getPickupNumber());
            respBaseDto.setMessage("OK");
        }
        return respBaseDto;
    }

    @ApiOperation(value = "我的订单", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId",value = "会员编号"),
            @ApiImplicitParam(name = "orderId",value = "订单号"),
            @ApiImplicitParam(name = "status",value = "1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定")
    })
    @RequestMapping(value = "/listOrder")
    @ResponseBody
    public RespBaseDto<List<ImsCrowdsourcingOrder>> getOrder(
            @RequestParam(name = "memberId",required = false)Long memberId,
            @RequestParam(name = "orderId",required = false)Long orderId,
            @RequestParam(name = "status",required = false)Byte status,
            @RequestParam(name = "pageNum",defaultValue = "1")int pageNum){

        RespBaseDto<List<ImsCrowdsourcingOrder>> respBaseDto = new RespBaseDto<>();
        PageInfo<ImsCrowdsourcingOrder> pageInfo = imsCrowdsourcingOrderService.queryOrder(memberId, orderId, status, pageNum, Consts.PAGE_SIZE);
        List<ImsCrowdsourcingOrder> list = pageInfo.getList();
        if(null == list || list.isEmpty())
            list = new ArrayList<>();
        respBaseDto.setData(list);
        respBaseDto.setMessage("OK");
        return respBaseDto;
    }

    @ApiOperation(value = "收货地址保存", httpMethod = "POST")
    @RequestMapping(value = "/address")
    @ResponseBody
    public RespBaseDto<ImsEweiShopMemberAddress> createAddress(ImsEweiShopMemberAddress address){
        logger.info(address.getMemberId()+" : 新增收货地址 "+ JSON.toJSONString(address));

        RespBaseDto<ImsEweiShopMemberAddress> respBaseDto = new RespBaseDto<>();

        boolean is = imsEweiShopMemberAddressSmpl.insertAddress(address);
        if(is){
            ImsEweiShopMemberAddress def_add = imsEweiShopMemberAddressSmpl.queryDefaultAddress(address.getMemberId());
            logger.debug(address.getMemberId() +" : 默认收货地址" + JSON.toJSONString(def_add));
            respBaseDto.setData(def_add);
            respBaseDto.setMessage("OK");
        }
        return respBaseDto;
    }

    @ApiOperation(value = "历史收货地址查询", httpMethod = "POST")
    @RequestMapping(value = "/listAddress")
    @ResponseBody
    public RespBaseDto<List<ImsEweiShopMemberAddress>> getAddress(
            @RequestParam(name = "memberId")Long memberId,
            @RequestParam(name = "pageNum",defaultValue = "1")int pageNum){
        RespBaseDto<List<ImsEweiShopMemberAddress>> respBaseDto = new RespBaseDto<>();
        List<Integer> orderAddress = imsCrowdsourcingOrderService.queryOrderAddressByMemberId(memberId);
        List<ImsEweiShopMemberAddress> list = new ArrayList<>();
        if(orderAddress != null &&  !orderAddress.isEmpty()){
            PageInfo<ImsEweiShopMemberAddress> pageInfo = imsEweiShopMemberAddressSmpl.queryAllAddress(memberId, orderAddress, pageNum, 20);
            list = pageInfo.getList();
            List<ImsEweiShopMemberAddress> listCollection = searchCollectionAddress(memberId);
            if (listCollection != null) {
                for (ImsEweiShopMemberAddress coll : listCollection) {
                    for (ImsEweiShopMemberAddress add : list) {
                        if (add.getId() == coll.getId()) {
                            add.setCollection(true);
                            break;
                        }
                    }
                }
            }
        }
        respBaseDto.setData(list);
        return respBaseDto;
    }

    /*@ApiOperation(value = "收藏地址", httpMethod = "POST")
    @RequestMapping(value = "/collectionAddress")
    @ResponseBody
    public RespBaseDto<Boolean> CollectionAddress(@RequestParam(name = "memberId")Long memberId,@RequestParam(name = "addressId")Integer addressId){
        RespBaseDto<Boolean> respBaseDto = new RespBaseDto<>();
        //成员  收藏地址  1 ，地址
        int num = imsEweiShopMemberCollectionSmpl.changeStatus(memberId,addressId,(byte)1,(byte)2);
        respBaseDto.setMessage("OK");
        respBaseDto.setData(num > 0?true:false);
        return respBaseDto;
    }*/

    @ApiOperation(value = "收藏地址查询", httpMethod = "POST")
    @RequestMapping(value = "/listCollectionAddress")
    @ResponseBody
    public RespBaseDto<List<ImsEweiShopMemberAddress>> getCollectionAddress(@RequestParam(name = "memberId")Long memberId){
        RespBaseDto<List<ImsEweiShopMemberAddress>> respBaseDto = new RespBaseDto<>();
        List<ImsEweiShopMemberAddress> resultList = searchCollectionAddress(memberId);

        respBaseDto.setMessage("OK");
        respBaseDto.setData(resultList);
        return respBaseDto;
    }

    private List<ImsEweiShopMemberAddress> searchCollectionAddress(Long memberId) {
        //收藏对象(1:酒店,2:地址)
        List<ImsEweiShopMemberCollection> list = imsEweiShopMemberCollectionSmpl.selectByMemberId(memberId,(byte)2);
        List<Integer> addList = new ArrayList<>();

        List<ImsEweiShopMemberAddress> resultList = null;
        list.forEach((smc)-> addList.add(smc.getCollecObjectId().intValue()));
        if(null != addList && !addList.isEmpty()) {
            resultList = imsEweiShopMemberAddressSmpl.queryAddressByCollection(memberId, addList);
            if(null == resultList || resultList.isEmpty()){
                resultList  = new ArrayList<>();
            }else{
                resultList.forEach((add)->add.setCollection(true));
            }
        }else{
            resultList  = new ArrayList<>();
        }
        return resultList;
    }

    @ApiOperation(value = "重下订单(新订单)", httpMethod = "POST")
    @RequestMapping(value = "/createNewOrder")
    @ResponseBody
    public RespBaseDto<Long> createNewOrder(Long orderId){
        RespBaseDto<Long> result = new RespBaseDto<>();
        try {
        	long newOrderId = imsCrowdsourcingOrderService.createNewOrder(orderId);
        	result.setData(newOrderId);
    	} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
    }

    @ApiOperation(value = "重下订单(老订单)", httpMethod = "POST")
    @RequestMapping(value = "/updateOldOrder")
    @ResponseBody
    public RespBaseDto<String> updateOldOrder(Long orderId){
        RespBaseDto<String> result = new RespBaseDto<>();
        try {
        	int r = imsCrowdsourcingOrderService.updateOldOrder(orderId);
        	if(r==1){
        		result.setMessage("OK");
        	}
    	} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
    }
}
