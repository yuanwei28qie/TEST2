package com.microsilver.mrcard.serviceplatform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nico
 *
 */
public class ImsCrowdsourcingOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private String lat;
    
    private String lng;
    
    private Integer distance;
    
    

    public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public ImsCrowdsourcingOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdersnIsNull() {
            addCriterion("ordersn is null");
            return (Criteria) this;
        }

        public Criteria andOrdersnIsNotNull() {
            addCriterion("ordersn is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersnEqualTo(String value) {
            addCriterion("ordersn =", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnNotEqualTo(String value) {
            addCriterion("ordersn <>", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnGreaterThan(String value) {
            addCriterion("ordersn >", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnGreaterThanOrEqualTo(String value) {
            addCriterion("ordersn >=", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnLessThan(String value) {
            addCriterion("ordersn <", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnLessThanOrEqualTo(String value) {
            addCriterion("ordersn <=", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnLike(String value) {
            addCriterion("ordersn like", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnNotLike(String value) {
            addCriterion("ordersn not like", value, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnIn(List<String> values) {
            addCriterion("ordersn in", values, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnNotIn(List<String> values) {
            addCriterion("ordersn not in", values, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnBetween(String value1, String value2) {
            addCriterion("ordersn between", value1, value2, "ordersn");
            return (Criteria) this;
        }

        public Criteria andOrdersnNotBetween(String value1, String value2) {
            addCriterion("ordersn not between", value1, value2, "ordersn");
            return (Criteria) this;
        }

        public Criteria andServiceDescIsNull() {
            addCriterion("service_desc is null");
            return (Criteria) this;
        }

        public Criteria andServiceDescIsNotNull() {
            addCriterion("service_desc is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDescEqualTo(String value) {
            addCriterion("service_desc =", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotEqualTo(String value) {
            addCriterion("service_desc <>", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescGreaterThan(String value) {
            addCriterion("service_desc >", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescGreaterThanOrEqualTo(String value) {
            addCriterion("service_desc >=", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLessThan(String value) {
            addCriterion("service_desc <", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLessThanOrEqualTo(String value) {
            addCriterion("service_desc <=", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLike(String value) {
            addCriterion("service_desc like", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotLike(String value) {
            addCriterion("service_desc not like", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescIn(List<String> values) {
            addCriterion("service_desc in", values, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotIn(List<String> values) {
            addCriterion("service_desc not in", values, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescBetween(String value1, String value2) {
            addCriterion("service_desc between", value1, value2, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotBetween(String value1, String value2) {
            addCriterion("service_desc not between", value1, value2, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceIsNull() {
            addCriterion("goods_estimate_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceIsNotNull() {
            addCriterion("goods_estimate_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceEqualTo(BigDecimal value) {
            addCriterion("goods_estimate_price =", value, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_estimate_price <>", value, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceGreaterThan(BigDecimal value) {
            addCriterion("goods_estimate_price >", value, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_estimate_price >=", value, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceLessThan(BigDecimal value) {
            addCriterion("goods_estimate_price <", value, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_estimate_price <=", value, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceIn(List<BigDecimal> values) {
            addCriterion("goods_estimate_price in", values, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_estimate_price not in", values, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_estimate_price between", value1, value2, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsEstimatePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_estimate_price not between", value1, value2, "goodsEstimatePrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceIsNull() {
            addCriterion("goods_consult_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceIsNotNull() {
            addCriterion("goods_consult_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceEqualTo(BigDecimal value) {
            addCriterion("goods_consult_price =", value, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_consult_price <>", value, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_consult_price >", value, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_consult_price >=", value, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceLessThan(BigDecimal value) {
            addCriterion("goods_consult_price <", value, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_consult_price <=", value, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceIn(List<BigDecimal> values) {
            addCriterion("goods_consult_price in", values, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_consult_price not in", values, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_consult_price between", value1, value2, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsConsultPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_consult_price not between", value1, value2, "goodsConsultPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceIsNull() {
            addCriterion("dispatch_price is null");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceIsNotNull() {
            addCriterion("dispatch_price is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceEqualTo(BigDecimal value) {
            addCriterion("dispatch_price =", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceNotEqualTo(BigDecimal value) {
            addCriterion("dispatch_price <>", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceGreaterThan(BigDecimal value) {
            addCriterion("dispatch_price >", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dispatch_price >=", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceLessThan(BigDecimal value) {
            addCriterion("dispatch_price <", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dispatch_price <=", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceIn(List<BigDecimal> values) {
            addCriterion("dispatch_price in", values, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceNotIn(List<BigDecimal> values) {
            addCriterion("dispatch_price not in", values, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispatch_price between", value1, value2, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispatch_price not between", value1, value2, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceIsNull() {
            addCriterion("tip_price is null");
            return (Criteria) this;
        }

        public Criteria andTipPriceIsNotNull() {
            addCriterion("tip_price is not null");
            return (Criteria) this;
        }

        public Criteria andTipPriceEqualTo(BigDecimal value) {
            addCriterion("tip_price =", value, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceNotEqualTo(BigDecimal value) {
            addCriterion("tip_price <>", value, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceGreaterThan(BigDecimal value) {
            addCriterion("tip_price >", value, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tip_price >=", value, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceLessThan(BigDecimal value) {
            addCriterion("tip_price <", value, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tip_price <=", value, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceIn(List<BigDecimal> values) {
            addCriterion("tip_price in", values, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceNotIn(List<BigDecimal> values) {
            addCriterion("tip_price not in", values, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tip_price between", value1, value2, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andTipPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tip_price not between", value1, value2, "tipPrice");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andCourierIsNull() {
            addCriterion("courier is null");
            return (Criteria) this;
        }

        public Criteria andCourierIsNotNull() {
            addCriterion("courier is not null");
            return (Criteria) this;
        }

        public Criteria andCourierEqualTo(Long value) {
            addCriterion("courier =", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierNotEqualTo(Long value) {
            addCriterion("courier <>", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierGreaterThan(Long value) {
            addCriterion("courier >", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierGreaterThanOrEqualTo(Long value) {
            addCriterion("courier >=", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierLessThan(Long value) {
            addCriterion("courier <", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierLessThanOrEqualTo(Long value) {
            addCriterion("courier <=", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierIn(List<Long> values) {
            addCriterion("courier in", values, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierNotIn(List<Long> values) {
            addCriterion("courier not in", values, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierBetween(Long value1, Long value2) {
            addCriterion("courier between", value1, value2, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierNotBetween(Long value1, Long value2) {
            addCriterion("courier not between", value1, value2, "courier");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Long value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Long value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Long value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Long value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Long> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Long> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Long value1, Long value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNull() {
            addCriterion("receive_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNotNull() {
            addCriterion("receive_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameEqualTo(String value) {
            addCriterion("receive_name =", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotEqualTo(String value) {
            addCriterion("receive_name <>", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThan(String value) {
            addCriterion("receive_name >", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("receive_name >=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThan(String value) {
            addCriterion("receive_name <", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("receive_name <=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLike(String value) {
            addCriterion("receive_name like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotLike(String value) {
            addCriterion("receive_name not like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIn(List<String> values) {
            addCriterion("receive_name in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotIn(List<String> values) {
            addCriterion("receive_name not in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameBetween(String value1, String value2) {
            addCriterion("receive_name between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotBetween(String value1, String value2) {
            addCriterion("receive_name not between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNull() {
            addCriterion("receive_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNotNull() {
            addCriterion("receive_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneEqualTo(String value) {
            addCriterion("receive_phone =", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotEqualTo(String value) {
            addCriterion("receive_phone <>", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThan(String value) {
            addCriterion("receive_phone >", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receive_phone >=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThan(String value) {
            addCriterion("receive_phone <", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
            addCriterion("receive_phone <=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLike(String value) {
            addCriterion("receive_phone like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotLike(String value) {
            addCriterion("receive_phone not like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIn(List<String> values) {
            addCriterion("receive_phone in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotIn(List<String> values) {
            addCriterion("receive_phone not in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneBetween(String value1, String value2) {
            addCriterion("receive_phone between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotBetween(String value1, String value2) {
            addCriterion("receive_phone not between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("receive_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("receive_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("receive_address =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("receive_address <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("receive_address >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receive_address >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("receive_address <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("receive_address <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("receive_address like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("receive_address not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("receive_address in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("receive_address not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("receive_address between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("receive_address not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveLatIsNull() {
            addCriterion("receive_lat is null");
            return (Criteria) this;
        }

        public Criteria andReceiveLatIsNotNull() {
            addCriterion("receive_lat is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveLatEqualTo(String value) {
            addCriterion("receive_lat =", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatNotEqualTo(String value) {
            addCriterion("receive_lat <>", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatGreaterThan(String value) {
            addCriterion("receive_lat >", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatGreaterThanOrEqualTo(String value) {
            addCriterion("receive_lat >=", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatLessThan(String value) {
            addCriterion("receive_lat <", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatLessThanOrEqualTo(String value) {
            addCriterion("receive_lat <=", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatLike(String value) {
            addCriterion("receive_lat like", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatNotLike(String value) {
            addCriterion("receive_lat not like", value, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatIn(List<String> values) {
            addCriterion("receive_lat in", values, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatNotIn(List<String> values) {
            addCriterion("receive_lat not in", values, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatBetween(String value1, String value2) {
            addCriterion("receive_lat between", value1, value2, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLatNotBetween(String value1, String value2) {
            addCriterion("receive_lat not between", value1, value2, "receiveLat");
            return (Criteria) this;
        }

        public Criteria andReceiveLngIsNull() {
            addCriterion("receive_lng is null");
            return (Criteria) this;
        }

        public Criteria andReceiveLngIsNotNull() {
            addCriterion("receive_lng is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveLngEqualTo(String value) {
            addCriterion("receive_lng =", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngNotEqualTo(String value) {
            addCriterion("receive_lng <>", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngGreaterThan(String value) {
            addCriterion("receive_lng >", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngGreaterThanOrEqualTo(String value) {
            addCriterion("receive_lng >=", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngLessThan(String value) {
            addCriterion("receive_lng <", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngLessThanOrEqualTo(String value) {
            addCriterion("receive_lng <=", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngLike(String value) {
            addCriterion("receive_lng like", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngNotLike(String value) {
            addCriterion("receive_lng not like", value, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngIn(List<String> values) {
            addCriterion("receive_lng in", values, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngNotIn(List<String> values) {
            addCriterion("receive_lng not in", values, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngBetween(String value1, String value2) {
            addCriterion("receive_lng between", value1, value2, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andReceiveLngNotBetween(String value1, String value2) {
            addCriterion("receive_lng not between", value1, value2, "receiveLng");
            return (Criteria) this;
        }

        public Criteria andUserDeleteIsNull() {
            addCriterion("user_delete is null");
            return (Criteria) this;
        }

        public Criteria andUserDeleteIsNotNull() {
            addCriterion("user_delete is not null");
            return (Criteria) this;
        }

        public Criteria andUserDeleteEqualTo(Boolean value) {
            addCriterion("user_delete =", value, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteNotEqualTo(Boolean value) {
            addCriterion("user_delete <>", value, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteGreaterThan(Boolean value) {
            addCriterion("user_delete >", value, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_delete >=", value, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteLessThan(Boolean value) {
            addCriterion("user_delete <", value, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("user_delete <=", value, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteIn(List<Boolean> values) {
            addCriterion("user_delete in", values, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteNotIn(List<Boolean> values) {
            addCriterion("user_delete not in", values, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("user_delete between", value1, value2, "userDelete");
            return (Criteria) this;
        }

        public Criteria andUserDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_delete not between", value1, value2, "userDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteIsNull() {
            addCriterion("courier_delete is null");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteIsNotNull() {
            addCriterion("courier_delete is not null");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteEqualTo(Boolean value) {
            addCriterion("courier_delete =", value, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteNotEqualTo(Boolean value) {
            addCriterion("courier_delete <>", value, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteGreaterThan(Boolean value) {
            addCriterion("courier_delete >", value, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("courier_delete >=", value, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteLessThan(Boolean value) {
            addCriterion("courier_delete <", value, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("courier_delete <=", value, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteIn(List<Boolean> values) {
            addCriterion("courier_delete in", values, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteNotIn(List<Boolean> values) {
            addCriterion("courier_delete not in", values, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("courier_delete between", value1, value2, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andCourierDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("courier_delete not between", value1, value2, "courierDelete");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseIsNull() {
            addCriterion("user_appraise is null");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseIsNotNull() {
            addCriterion("user_appraise is not null");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseEqualTo(Boolean value) {
            addCriterion("user_appraise =", value, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseNotEqualTo(Boolean value) {
            addCriterion("user_appraise <>", value, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseGreaterThan(Boolean value) {
            addCriterion("user_appraise >", value, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_appraise >=", value, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseLessThan(Boolean value) {
            addCriterion("user_appraise <", value, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseLessThanOrEqualTo(Boolean value) {
            addCriterion("user_appraise <=", value, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseIn(List<Boolean> values) {
            addCriterion("user_appraise in", values, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseNotIn(List<Boolean> values) {
            addCriterion("user_appraise not in", values, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseBetween(Boolean value1, Boolean value2) {
            addCriterion("user_appraise between", value1, value2, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andUserAppraiseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_appraise not between", value1, value2, "userAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseIsNull() {
            addCriterion("courier_appraise is null");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseIsNotNull() {
            addCriterion("courier_appraise is not null");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseEqualTo(Boolean value) {
            addCriterion("courier_appraise =", value, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseNotEqualTo(Boolean value) {
            addCriterion("courier_appraise <>", value, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseGreaterThan(Boolean value) {
            addCriterion("courier_appraise >", value, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("courier_appraise >=", value, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseLessThan(Boolean value) {
            addCriterion("courier_appraise <", value, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseLessThanOrEqualTo(Boolean value) {
            addCriterion("courier_appraise <=", value, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseIn(List<Boolean> values) {
            addCriterion("courier_appraise in", values, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseNotIn(List<Boolean> values) {
            addCriterion("courier_appraise not in", values, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseBetween(Boolean value1, Boolean value2) {
            addCriterion("courier_appraise between", value1, value2, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andCourierAppraiseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("courier_appraise not between", value1, value2, "courierAppraise");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(Integer value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(Integer value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(Integer value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(Integer value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(Integer value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<Integer> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<Integer> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(Integer value1, Integer value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andPickupNumberIsNull() {
            addCriterion("pickup_number is null");
            return (Criteria) this;
        }

        public Criteria andPickupNumberIsNotNull() {
            addCriterion("pickup_number is not null");
            return (Criteria) this;
        }

        public Criteria andPickupNumberEqualTo(String value) {
            addCriterion("pickup_number =", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberNotEqualTo(String value) {
            addCriterion("pickup_number <>", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberGreaterThan(String value) {
            addCriterion("pickup_number >", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberGreaterThanOrEqualTo(String value) {
            addCriterion("pickup_number >=", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberLessThan(String value) {
            addCriterion("pickup_number <", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberLessThanOrEqualTo(String value) {
            addCriterion("pickup_number <=", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberLike(String value) {
            addCriterion("pickup_number like", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberNotLike(String value) {
            addCriterion("pickup_number not like", value, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberIn(List<String> values) {
            addCriterion("pickup_number in", values, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberNotIn(List<String> values) {
            addCriterion("pickup_number not in", values, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberBetween(String value1, String value2) {
            addCriterion("pickup_number between", value1, value2, "pickupNumber");
            return (Criteria) this;
        }

        public Criteria andPickupNumberNotBetween(String value1, String value2) {
            addCriterion("pickup_number not between", value1, value2, "pickupNumber");
            return (Criteria) this;
        }
        public Criteria andIsSettlementIsNull() {
            addCriterion("is_settlement is null");
            return (Criteria) this;
        }

        public Criteria andIsSettlementIsNotNull() {
            addCriterion("is_settlement is not null");
            return (Criteria) this;
        }

        public Criteria andIsSettlementEqualTo(Byte value) {
            addCriterion("is_settlement =", value, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementNotEqualTo(Byte value) {
            addCriterion("is_settlement <>", value, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementGreaterThan(Byte value) {
            addCriterion("is_settlement >", value, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_settlement >=", value, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementLessThan(Byte value) {
            addCriterion("is_settlement <", value, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementLessThanOrEqualTo(Byte value) {
            addCriterion("is_settlement <=", value, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementIn(List<Boolean> values) {
            addCriterion("is_settlement in", values, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementNotIn(List<Byte> values) {
            addCriterion("is_settlement not in", values, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementBetween(Byte value1, Byte value2) {
            addCriterion("is_settlement between", value1, value2, "isSettlement");
            return (Criteria) this;
        }

        public Criteria andIsSettlementNotBetween(Byte value1, Byte value2) {
            addCriterion("is_settlement not between", value1, value2, "isSettlement");
            return (Criteria) this;
        }


        public Criteria andProvinceAgentIdttIdIsNull() {
            addCriterion("province_agent_idtt_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdIsNotNull() {
            addCriterion("province_agent_idtt_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdEqualTo(Long value) {
            addCriterion("province_agent_idtt_id =", value, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdNotEqualTo(Long value) {
            addCriterion("province_agent_idtt_id <>", value, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdGreaterThan(Long value) {
            addCriterion("province_agent_idtt_id >", value, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdGreaterThanOrEqualTo(Long value) {
            addCriterion("province_agent_idtt_id >=", value, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdLessThan(Long value) {
            addCriterion("province_agent_idtt_id <", value, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdLessThanOrEqualTo(Long value) {
            addCriterion("province_agent_idtt_id <=", value, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdIn(List<Long> values) {
            addCriterion("province_agent_idtt_id in", values, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdNotIn(List<Long> values) {
            addCriterion("province_agent_idtt_id not in", values, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdBetween(Long value1, Long value2) {
            addCriterion("province_agent_idtt_id between", value1, value2, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andProvinceAgentIdttIdNotBetween(Long value1, Long value2) {
            addCriterion("province_agent_idtt_id not between", value1, value2, "provinceAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdIsNull() {
            addCriterion("city_agent_idtt_id is null");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdIsNotNull() {
            addCriterion("city_agent_idtt_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdEqualTo(Long value) {
            addCriterion("city_agent_idtt_id =", value, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdNotEqualTo(Long value) {
            addCriterion("city_agent_idtt_id <>", value, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdGreaterThan(Long value) {
            addCriterion("city_agent_idtt_id >", value, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdGreaterThanOrEqualTo(Long value) {
            addCriterion("city_agent_idtt_id >=", value, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdLessThan(Long value) {
            addCriterion("city_agent_idtt_id <", value, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdLessThanOrEqualTo(Long value) {
            addCriterion("city_agent_idtt_id <=", value, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdIn(List<Long> values) {
            addCriterion("city_agent_idtt_id in", values, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdNotIn(List<Long> values) {
            addCriterion("city_agent_idtt_id not in", values, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdBetween(Long value1, Long value2) {
            addCriterion("city_agent_idtt_id between", value1, value2, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCityAgentIdttIdNotBetween(Long value1, Long value2) {
            addCriterion("city_agent_idtt_id not between", value1, value2, "cityAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdIsNull() {
            addCriterion("county_agent_idtt_id is null");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdIsNotNull() {
            addCriterion("county_agent_idtt_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdEqualTo(Long value) {
            addCriterion("county_agent_idtt_id =", value, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdNotEqualTo(Long value) {
            addCriterion("county_agent_idtt_id <>", value, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdGreaterThan(Long value) {
            addCriterion("county_agent_idtt_id >", value, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdGreaterThanOrEqualTo(Long value) {
            addCriterion("county_agent_idtt_id >=", value, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdLessThan(Long value) {
            addCriterion("county_agent_idtt_id <", value, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdLessThanOrEqualTo(Long value) {
            addCriterion("county_agent_idtt_id <=", value, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdIn(List<Long> values) {
            addCriterion("county_agent_idtt_id in", values, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdNotIn(List<Long> values) {
            addCriterion("county_agent_idtt_id not in", values, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdBetween(Long value1, Long value2) {
            addCriterion("county_agent_idtt_id between", value1, value2, "countyAgentIdttId");
            return (Criteria) this;
        }

        public Criteria andCountyAgentIdttIdNotBetween(Long value1, Long value2) {
            addCriterion("county_agent_idtt_id not between", value1, value2, "countyAgentIdttId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}