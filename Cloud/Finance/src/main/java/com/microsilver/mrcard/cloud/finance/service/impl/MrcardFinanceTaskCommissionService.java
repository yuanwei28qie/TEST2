package com.microsilver.mrcard.cloud.finance.service.impl;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.calc.Commission;
import com.microsilver.mrcard.cloud.finance.calc.CommissionStrategy;
import com.microsilver.mrcard.cloud.finance.calc.strategy.*;
import com.microsilver.mrcard.cloud.finance.dic.AgentLevelEnum;
import com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType;
import com.microsilver.mrcard.cloud.finance.dic.MerchFlowType;
import com.microsilver.mrcard.cloud.finance.dic.PlatformOrderEnum;
import com.microsilver.mrcard.cloud.finance.dto.*;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Jade
 * @Description 分成控制及算法
 * @create 2017-07-28 下午 2:28
 * @Copyright Micro Silver
 **/

@Service
public class MrcardFinanceTaskCommissionService {
    private final static Logger logger = LoggerFactory.getLogger(MrcardFinanceAgentConfigService.class);

    @Autowired
    MrcardFinanceCommissionService commissionService;

    @Autowired
    MrcardFinanceCustomerService customerService;

    @Autowired
    MrcardFinanceMerchFlowService merchFlowService;

    @Autowired
    MrcardFinanceSettlementService settlementService;

    /**
     * 执行分成
     * 1，订单交易流水
     * 2，各家分成比例
     * 3，分成核算
     * 4，分成复核
     * 5，执行数据持久化
     * 6，返回分成结果
     * @param commissionDto
     * @param proportion
     */
    public boolean TaskCommisstion(CommissionDto commissionDto, ProportionDto proportion) throws Exception {
        logger.info("分成原始数据:{}-{}",JSON.toJSON(commissionDto),JSON.toJSON(proportion));
        /**
         * 计算
         * 根据订单类型，生成具体的分润策略算法
         */
        List<BounsDto> resultList = calculatorCommission(commissionDto, proportion);


        /**
         * 计算结果封装
         */
        List<MrcardFinanceCommissionFlow> comList = initCommissionData(commissionDto, proportion, resultList);

        /**
         * 执行持久化(预结算)
         */
        return commitCommissionData(comList);
    }

    private List<BounsDto> calculatorCommission(CommissionDto commissionDto, ProportionDto proportion) throws Exception {
        /**
         * 计算
         * 根据订单类型，生成具体的分润策略算法
         */
        List<BounsDto> resultList = null;
        if(commissionDto.getOrderType()==null)
            throw new IllegalArgumentException("订单类型不能为空");
        PlatformOrderEnum orderType = PlatformOrderEnum.getEnumValue(commissionDto.getOrderType());
        if(orderType == PlatformOrderEnum.HOTEL_ORDER)
            resultList = calculatorHotelCommissions(commissionDto, proportion);
        else if (orderType == PlatformOrderEnum.MRCARD_ORDER || orderType == PlatformOrderEnum.MRCARD_FACE)
            resultList = calculatorMRCARDCommissions(commissionDto, proportion);
        else if(orderType == PlatformOrderEnum.KNIGHT_ORDER)
            resultList = calculatorKnightCommissions(commissionDto,proportion);
        else if(orderType == PlatformOrderEnum.RECOMMEND_ORDER)
            resultList = calculatorRecommendCommissions(commissionDto,proportion);
        else
            throw new IllegalArgumentException("不存在的订单类型:"+commissionDto.getOrderType());
        logger.info("计算结果：{}", JSON.toJSONString(resultList));
        return resultList;
    }

    /**
     *  预结算，
     *      1，生成预结算流水commissionFlow
     *      2，变更客户账户资金unrecordMoney
     * @param commissionDto
     * @param proportion
     * @return
     * @throws Exception
     */
    @Transactional
    public Boolean RecommendPreCalculator(CommissionDto commissionDto, ProportionDto proportion) throws Exception {
        logger.info("分成原始数据:{}-{}",JSON.toJSON(commissionDto),JSON.toJSON(proportion));
        /**
         * 计算
         * 根据订单类型，生成具体的分润策略算法
         */
        List<BounsDto> resultList = calculatorCommission(commissionDto, proportion);
        /**
         * 计算结果封装
         */
        List<MrcardFinanceCommissionFlow> comList = initCommissionData(commissionDto, proportion, resultList);
        /**
         * 执行持久化
         */
        //1，生成预结算流水commissionFlow
        commissionService.insertCommissionFlows(comList);
        //2，变更客户账户资金unrecordMoney
        for (MrcardFinanceCommissionFlow commissionFlow : comList) {
            customerService.addUnrecordMoney(commissionFlow);
        }
        //List<MrcardFinanceCommissionFlow> commissionFlow = commissionService.getCommissionFlowByOrderSn(commissionDto.getOrderSn());
        //3,添加财务流水
        //commissionFlow.forEach((flow)->initMerchFlowData(flow));
        //变更结算状态
        //commissionService.SettlementCommission(commissionDto.getOrderSn());
        return true;
    }
    @Transactional
    public Boolean RecommendCalculator(String ordersn) throws Exception {
        logger.info("结算数据:"+ordersn);
        List<MrcardFinanceCommissionFlow> commissionFlow = commissionService.getCommissionFlowByOrderSn(ordersn );
        if(commissionFlow.isEmpty()) {
        	logger.error("订单:{}不存在",ordersn);
        	return false;
            //throw new IllegalArgumentException("不存在订单："+ordersn);
        }
        //2，变更客户账户资金unrecordMoney
        for (MrcardFinanceCommissionFlow comm : commissionFlow) {
            if(comm.getCommState() != 0 ){
                throw new IllegalArgumentException(ordersn+" 订单状态异常");
            }
            customerService.addRealMoneyFromUnrecordMoney(comm);
        }
        //3,添加财务流水
        commissionFlow.forEach((flow)->initMerchFlowData(flow));
        //变更结算状态
        commissionService.SettlementCommission(ordersn);
        return true;
    }

    /**
     *  预结算，
     *      1，生成预结算流水commissionFlow
     *      2，变更客户账户资金unrecordMoney
     * @param commissionDto
     * @param proportion
     * @return
     * @throws Exception
     */
    @Transactional
    public Boolean PreSettlementCalculator(CommissionDto commissionDto, ProportionDto proportion) throws Exception {
        logger.info("分成原始数据:{}-{}",JSON.toJSON(commissionDto),JSON.toJSON(proportion));
        /**
         * 计算
         * 根据订单类型，生成具体的分润策略算法
         */
        List<BounsDto> resultList = calculatorCommission(commissionDto, proportion);
        /**
         * 计算结果封装
         */
        List<MrcardFinanceCommissionFlow> comList = initCommissionData(commissionDto, proportion, resultList);
        /**
         * 执行持久化(预结算)
         */
        //1，生成预结算流水commissionFlow
        commissionService.insertCommissionFlows(comList);
        //2，变更客户账户资金unrecordMoney
        customerService.addUnrecordMoneyList(comList);
        return true;
    }

    /**
     *  预结算骑士专用，
     *      1，生成预结算流水commissionFlow
     *      2，变更客户账户资金unrecordMoney
     * @param comList
     * @param proportion
     * @return
     * @throws Exception
     */
    @Transactional
    public boolean PreSettlementCalculator(List<CommissionDto> comList, ProportionDto proportion) throws Exception {
        logger.info("分成原始数据:{}-{}",JSON.toJSON(comList),JSON.toJSON(proportion));

        List<MrcardFinanceCommissionFlow> commissionFlows = new ArrayList<>();
        /**
         * 根据要求结算
         * 1，代收货款 -不结算，直接给骑士
         * 2，服务费 - 小费 不结算，直接给骑士
         * 3，服务费 - 运费 结算，按比例抽成
         */
        for(CommissionDto commission :comList){

            if( commission.getFlowType() == CommissionFlowType.SALE_ADVANCE.getIndex() ||
                commission.getFlowType() == CommissionFlowType.SALE_TIP.getIndex() && CommissionFlowType.SALE_TIP.getName().equals(commission.getRemark())
                    ){
                BounsDto bounsDto = new BounsDto(commission.getMerchInfo(),commission.getOrderSn(),commission.getTotalAmount());
                ProportionDto pd = new ProportionDto((short)100);
                MrcardFinanceCommissionFlow flow = initCommissionData(commission,pd,bounsDto);
                commissionFlows.add(flow);
            }else{
                List<BounsDto> strategyResult = calculatorCommission(commission,proportion);
                if(null != strategyResult && !strategyResult.isEmpty()){
                    List<MrcardFinanceCommissionFlow> strategyList = initCommissionData(commission,proportion,strategyResult);
                    commissionFlows.addAll(strategyList);
                }
            }
        };
        /**
         * 执行持久化(预结算)
         */
        //1，生成预结算流水commissionFlow
        commissionService.insertCommissionFlows(commissionFlows);
        //2，变更客户账户资金
        customerService.addKnightMoneyList(commissionFlows);
        return true;
    }

    /**
     *   结算.
     *     1，生成客户财务流水merchFlow
     *     2，变更预结算流水状态为结算
     *     3，变更账户资金realMoney and totalMoney
     * @param orderSn
     * @return
     * @throws Exception
     */
    @Transactional
    public boolean SettlementCalculator(String orderSn) throws Exception {
        logger.info("订单结算:{}",orderSn);
        /**
         * 根据订单号取得预结算结果
         */
        List<MrcardFinanceCommissionFlow> commissionFlow = commissionService.getCommissionFlowByOrderSn(orderSn);
        /**
         * 生成客户财务流水
         */
        commissionFlow.forEach((flow)->initMerchFlowData(flow));
        /**
         * 变更账户资金
         */
        commissionFlow.forEach((flow)->customerService.addRealMoneyFromUnrecordMoney(flow));

        /**
         * 变更结算状态
         */
        commissionService.SettlementCommission(orderSn);
        return true;
    }

    /**
     *   结算.
     *     1，生成客户财务流水merchFlow-合单
     *      分成明细数据组合成一条数据
     *     2，变更预结算流水状态为结算
     *     3，变更账户资金realMoney and totalMoney @2017-09-22账户资金变更迁移到生成结转单据处进行变更
     *     4，生成结转单
     * @param commissionDto
     * @return
     * @throws Exception
     */
    @Transactional
    public boolean SettlementCalculatorByKnight(CommissionDto commissionDto) throws Exception {
        logger.info("订单结算:{}",JSON.toJSONString(commissionDto));
        /**
         * 根据订单号取得预结算结果
         */
        List<MrcardFinanceCommissionFlow> commissionFlow = commissionService.getCommissionFlowByOrderSn(commissionDto.getOrderSn());
        if(null != commissionFlow && commissionFlow.size() > 0){
            if(commissionFlow.get(0).getCommState() !=0){
                logger.error("已经结算过的数据，不再进行结算");
                return true;
            }
        }

        MrcardFinanceCustomer knight = customerService.getCustomer(commissionDto.getMerchInfo().getMemberId(),commissionDto.getMerchInfo().getIdentity(),commissionDto.getMerchInfo().getMerchId());
        /**
         * 生成客户财务流水
         */
        //新结算单
        List<MrcardFinanceCommissionFlow> calList = new ArrayList<>();
        //销售收入
        MrcardFinanceCommissionFlow sale = null;
        //抽成
        MrcardFinanceCommissionFlow bound = null;
        //防数据被篡改 copy & clone 都会被篡改
        String copyString = JSON.toJSONString(commissionFlow);
        List<MrcardFinanceCommissionFlow> copy = JSON.parseArray(copyString,MrcardFinanceCommissionFlow.class);
        for(MrcardFinanceCommissionFlow flowCopy : copy){
            if(flowCopy.getFinanceId().equals(knight.getId()) && CommissionFlowType.SALE_ADVANCE.getName().equals(flowCopy.getRemark())){
                calList.add(flowCopy);
            }else if(flowCopy.getFinanceId().equals(knight.getId()) &&
                    (CommissionFlowType.SALE_TIP.getName().equals(flowCopy.getRemark())|| CommissionFlowType.SALE_NONE.getName().equals(flowCopy.getRemark()))){
                if(sale == null){
                    sale = flowCopy;
                    sale.setRemark(CommissionFlowType.SALE_NONE.getName());
                }else{
                    sale.setCommission(sale.getCommission().add(flowCopy.getCommission()));
                }
            }else if(!flowCopy.getFinanceId().equals(knight.getId())){
                calList.add(flowCopy);//其他分润用户不变，原样记录
                //计算客户收入被平台抽成的总计
                if(bound == null){
                    //防原客户记录篡改
                    bound = JSON.parseObject(JSON.toJSONString(flowCopy),MrcardFinanceCommissionFlow.class);
                    bound.setFinanceId(knight.getId());
                    bound.setRemark(CommissionFlowType.SALE_BOUND.getName());
                }else{
                    bound.setCommission(bound.getCommission().add(flowCopy.getCommission()));
                }
            }
        }
        if(null != sale) {
            BigDecimal saleCom = sale.getCommission().add(bound.getCommission());
            sale.setCommission(saleCom);
            calList.add(sale);
        }
        if(null != bound) {
            //计算客户收入被平台抽成的总计
            bound.setCommType(new BigDecimal(100).subtract(new BigDecimal(sale.getCommType().intValue())).shortValue());//抽成比例
            BigDecimal sysBound = new BigDecimal(0).subtract(bound.getCommission());
            bound.setCommission(sysBound);
            calList.add(bound);
        }

        /**
         * 生成客户财务流水
         */
        calList.forEach((flow)->initMerchFlowData(flow));
        /**
         * 变更账户资金 ，只能根据commissionFlow来进行变更，否则使用calList会出现数据不一致
         *  @2017-09-22账户资金变更迁移到生成结转单据处进行变更
         */
        //commissionFlow.forEach((flow)->customerService.addRealMoneyFromUnrecordMoney(flow));
        /**
         * 变更结算状态
         */
        commissionService.SettlementCommission(commissionDto.getOrderSn());
        return true;
    }

    /**
     * 结转单，
     *  1,check单据及生成结转单
     *  2,变更账户资金-addRealMoneyFromUnrecordMoney 冻结骑士收入余额
     *  3，生成结转单
     * @param carryoverKnightDto
     * @return 返回结转单据编号
     */
    public String carryoverByKnight(CarryoverKnightDto carryoverKnightDto){
        logger.debug("结转单生成原始数据",JSON.toJSONString(carryoverKnightDto));
        List<MrcardFinanceMerchFlow> list = merchFlowService.selectByOrderSn(carryoverKnightDto.getSnList());
        if(null != list &&  !list.isEmpty()){
            logger.error("单据已经结转，不允许二次操作",JSON.toJSONString(carryoverKnightDto));
            //检查是否有已经结转，未审核通过的单据，返回此单号
            MrcardFinanceCustomer customer = customerService.getCustomer(carryoverKnightDto.getMemberId(),carryoverKnightDto.getIdentity(),carryoverKnightDto.getMerchId());
            MrcardFinanceSettlement settlement = settlementService.getSettlementByExamine(customer.getId());
            if(settlement != null)
                return settlement.getSettlementsn();
            return null;
        }
        String settlementSn = settlementService.carryoverByKnight(carryoverKnightDto);
        return settlementSn;
    }

    /**
     * 生成客户财务流水
     * @param flow
     * @return
     */
    @Transactional
    private MrcardFinanceMerchFlow initMerchFlowData(MrcardFinanceCommissionFlow flow){
        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setOrdersn(flow.getOrdersn());
        merchFlow.setFinanceId(flow.getFinanceId());
        merchFlow.setRemark(flow.getRemark());
        merchFlow.setType((byte) MerchFlowType.SALE.getValue());
        merchFlow.setIsSettl(false);
        merchFlow.setAmount(flow.getCommission());
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlowService.insertMerchFlowRecord(merchFlow);
        return merchFlow;
    }

    /**
     * 执行数据保存
     * 1，记录分润流水
     * 2，重新计算客户账户金额
     * 3，记录客户财务流水
     * @param comList
     * @return
     */
    @Transactional
    private boolean commitCommissionData(List<MrcardFinanceCommissionFlow> comList ){
        //记录流水
        commissionService.insertCommissionFlows(comList);
        //客户财务账户记录
        comList.forEach((cc) -> merchFlow(cc));
        return true;
    }

    /**
     * 客户财务记录
     * @param flow
     * @return
     */
    @Transactional
    private boolean merchFlow(MrcardFinanceCommissionFlow flow){
        //MrcardFinanceCustomer customer = customerService.getFinanceCustomer(flow.getFinanceId());
      /*
        //添加客户账户金额
        customerService.addUnrecordMoney(flow);
        */
        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setOrdersn(flow.getOrdersn());
        merchFlow.setFinanceId(flow.getFinanceId());
        merchFlow.setRemark("销售收入");
        merchFlow.setType((byte) MerchFlowType.SALE.getValue());
        merchFlow.setAmount(flow.getCommission());
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlowService.insertMerchFlowRecord(merchFlow);
        /*
        //结算
        customerService.addRealMoney(flow);
        */
        /*
         * 此处未做预结算，addUnrecordMoney  addRealMoneyFromUnrecordMoney 成对使用
         */
        customerService.addRealMoney(flow);
        //变更流水记录为结算状态
        commissionService.SettlementCommission(flow.getOrdersn());
        return true;
    }

    private List<MrcardFinanceCommissionFlow> initCommissionData(CommissionDto commissionDto, ProportionDto proportion, List<BounsDto> resultList) {
        List<MrcardFinanceCommissionFlow> comList = new ArrayList<>();
        for(BounsDto bd : resultList){
            MrcardFinanceCommissionFlow com = initCommissionData(commissionDto, proportion, bd);
            comList.add(com);
        }
        return comList;
    }

    private MrcardFinanceCommissionFlow initCommissionData(CommissionDto commissionDto, ProportionDto proportion, BounsDto bd) {
        MrcardFinanceCommissionFlow com = new MrcardFinanceCommissionFlow();
        com.setAmount(commissionDto.getTotalAmount());//交易金额
        com.setCommission(bd.getBouns());//结算金额
        com.setCommState((short) 0);//结算状态：状态（0预结算，1结算，2退款）
        com.setType(commissionDto.getFlowType());//流水类型(1:销售收入,3:垫付货款)
        com.setOrdersn(bd.getOrderId());
        com.setFinanceId(bd.getCustomer().getFinanceId());
        com.setCreateTime((int) (System.currentTimeMillis()/1000));
        //分润比例
        BigDecimal prop = null;
        switch (AgentLevelEnum.getEnumValue(bd.getCustomer().getIdentity())) {
            case AGENT_WARRIOR:
            case MRCARD_WARRIOR:
                prop = proportion.WARRIOR_PROPORTION.multiply(new BigDecimal(100));
                break;
            case AGENT_COUNTRY:
            case MRCARD_COUNTRY:
            case KNIGHT_COUNTRY:
                prop = proportion.COUNTRY_PROPORTION.multiply(new BigDecimal(100));
                break;
            case AGENT_CITY:
            case KNIGHT_CITY:
                prop = proportion.CITY_PROPORTION.multiply(new BigDecimal(100));
                break;
            case AGENT_PROVINCE:
            case KNIGHT_PROVINCE:
                prop = proportion.PROVINCE_PROPORTION.multiply(new BigDecimal(100));
                break;
            case AGENT_PLATFORM:
            case MRCARD_PLATFORM:
            case KNIGHT_PLATFORM:
                prop = proportion.PLAT_PROPORTION.multiply(new BigDecimal(100));
                break;
            case MRCARD_MERCH:
            case KNIGHT_SELF:
                prop = proportion.MERCH_PROPORTION.multiply(new BigDecimal(100));
                break;
            case MRCARD_VIP:
                prop = proportion.VIP_PROPORTION.multiply(new BigDecimal(100));
                break;
            case MRCARD_KNIGHT:
                prop = proportion.KNIGHT_PROPORTION.multiply(new BigDecimal(100));
                break; 
            default:
            	if(bd.getCustomer()!=null&&bd.getCustomer().getProportion()!=null)
            		prop = new BigDecimal(bd.getCustomer().getProportion());
            	else
            		prop = new BigDecimal(100);
                break;
        }
        com.setCommType(prop.shortValueExact());
        if(Objects.nonNull(bd.getCustomer().getRemark())){
           com.setRemark(bd.getCustomer().getRemark().getName());
        }else if(Objects.nonNull(commissionDto.getRemark())){
            com.setRemark(commissionDto.getRemark());
        }else{
            com.setRemark("系统分润");
        }
        return com;
    }

    /**
     * 超级定
     * @param commissionDto
     * @param proportion
     * @return
     * @throws Exception
     */
    private List<BounsDto> calculatorHotelCommissions(CommissionDto commissionDto, ProportionDto proportion) throws Exception{
        CommissionStrategy comm = new HotelStrategy();
        Commission commission = new Commission(comm);

        List<BounsDto> resultList = commission.getBounds(commissionDto,proportion);
        return resultList;
    }

    /**
     * 骑士
     * @param commissionDto
     * @param proportion
     * @return
     * @throws Exception
     */
    private List<BounsDto> calculatorKnightCommissions(CommissionDto commissionDto, ProportionDto proportion) throws Exception{
        CommissionStrategy comm = new KnightStrategy();
        Commission commission = new Commission(comm);

        List<BounsDto> resultList = commission.getBounds(commissionDto,proportion);
        return resultList;
    }

    /**
     * 卡先生
     * @param commissionDto
     * @param proportion
     * @return
     * @throws Exception
     */
    private List<BounsDto> calculatorMRCARDCommissions(CommissionDto commissionDto, ProportionDto proportion) throws Exception{
        CommissionStrategy comm = new MrcardStrategy();
        Commission commission = new Commission(comm);

        List<BounsDto> resultList = commission.getBounds(commissionDto,proportion);
        return resultList;
    }

    /**
     * 推荐人
     * @param commissionDto
     * @param proportion
     * @return
     * @throws Exception
     */
    private List<BounsDto> calculatorRecommendCommissions(CommissionDto commissionDto, ProportionDto proportion) throws Exception{
        CommissionStrategy comm = new RecommendStrategy();
        Commission commission = new Commission(comm);

        List<BounsDto> resultList = commission.getBounds(commissionDto,proportion);
        return resultList;
    }

    public boolean checkComminssionData(String orderSn){
        List<MrcardFinanceCommissionFlow> list = commissionService.getCommissionFlowByOrderSn(orderSn);
        if(null != list && list.size() > 0) {
            return true;
        }
        return false;
    }
    public MrcardFinanceCommissionFlow checkComminssionStatu(String orderSn){
        List<MrcardFinanceCommissionFlow> list = commissionService.getCommissionFlowByOrderSn(orderSn);
        if(null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


}
