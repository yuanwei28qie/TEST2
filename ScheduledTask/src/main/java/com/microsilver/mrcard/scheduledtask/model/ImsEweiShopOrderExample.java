package com.microsilver.mrcard.scheduledtask.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopOrderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ImsEweiShopOrderExample() {
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUniacidIsNull() {
			addCriterion("uniacid is null");
			return (Criteria) this;
		}

		public Criteria andUniacidIsNotNull() {
			addCriterion("uniacid is not null");
			return (Criteria) this;
		}

		public Criteria andUniacidEqualTo(Integer value) {
			addCriterion("uniacid =", value, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidNotEqualTo(Integer value) {
			addCriterion("uniacid <>", value, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidGreaterThan(Integer value) {
			addCriterion("uniacid >", value, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidGreaterThanOrEqualTo(Integer value) {
			addCriterion("uniacid >=", value, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidLessThan(Integer value) {
			addCriterion("uniacid <", value, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidLessThanOrEqualTo(Integer value) {
			addCriterion("uniacid <=", value, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidIn(List<Integer> values) {
			addCriterion("uniacid in", values, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidNotIn(List<Integer> values) {
			addCriterion("uniacid not in", values, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidBetween(Integer value1, Integer value2) {
			addCriterion("uniacid between", value1, value2, "uniacid");
			return (Criteria) this;
		}

		public Criteria andUniacidNotBetween(Integer value1, Integer value2) {
			addCriterion("uniacid not between", value1, value2, "uniacid");
			return (Criteria) this;
		}

		public Criteria andOpenidIsNull() {
			addCriterion("openid is null");
			return (Criteria) this;
		}

		public Criteria andOpenidIsNotNull() {
			addCriterion("openid is not null");
			return (Criteria) this;
		}

		public Criteria andOpenidEqualTo(String value) {
			addCriterion("openid =", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidNotEqualTo(String value) {
			addCriterion("openid <>", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidGreaterThan(String value) {
			addCriterion("openid >", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidGreaterThanOrEqualTo(String value) {
			addCriterion("openid >=", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidLessThan(String value) {
			addCriterion("openid <", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidLessThanOrEqualTo(String value) {
			addCriterion("openid <=", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidLike(String value) {
			addCriterion("openid like", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidNotLike(String value) {
			addCriterion("openid not like", value, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidIn(List<String> values) {
			addCriterion("openid in", values, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidNotIn(List<String> values) {
			addCriterion("openid not in", values, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidBetween(String value1, String value2) {
			addCriterion("openid between", value1, value2, "openid");
			return (Criteria) this;
		}

		public Criteria andOpenidNotBetween(String value1, String value2) {
			addCriterion("openid not between", value1, value2, "openid");
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

		public Criteria andAgentidIsNull() {
			addCriterion("agentid is null");
			return (Criteria) this;
		}

		public Criteria andAgentidIsNotNull() {
			addCriterion("agentid is not null");
			return (Criteria) this;
		}

		public Criteria andAgentidEqualTo(Integer value) {
			addCriterion("agentid =", value, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidNotEqualTo(Integer value) {
			addCriterion("agentid <>", value, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidGreaterThan(Integer value) {
			addCriterion("agentid >", value, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidGreaterThanOrEqualTo(Integer value) {
			addCriterion("agentid >=", value, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidLessThan(Integer value) {
			addCriterion("agentid <", value, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidLessThanOrEqualTo(Integer value) {
			addCriterion("agentid <=", value, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidIn(List<Integer> values) {
			addCriterion("agentid in", values, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidNotIn(List<Integer> values) {
			addCriterion("agentid not in", values, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidBetween(Integer value1, Integer value2) {
			addCriterion("agentid between", value1, value2, "agentid");
			return (Criteria) this;
		}

		public Criteria andAgentidNotBetween(Integer value1, Integer value2) {
			addCriterion("agentid not between", value1, value2, "agentid");
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

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(BigDecimal value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(BigDecimal value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(BigDecimal value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(BigDecimal value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<BigDecimal> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<BigDecimal> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andGoodspriceIsNull() {
			addCriterion("goodsprice is null");
			return (Criteria) this;
		}

		public Criteria andGoodspriceIsNotNull() {
			addCriterion("goodsprice is not null");
			return (Criteria) this;
		}

		public Criteria andGoodspriceEqualTo(BigDecimal value) {
			addCriterion("goodsprice =", value, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceNotEqualTo(BigDecimal value) {
			addCriterion("goodsprice <>", value, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceGreaterThan(BigDecimal value) {
			addCriterion("goodsprice >", value, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goodsprice >=", value, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceLessThan(BigDecimal value) {
			addCriterion("goodsprice <", value, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goodsprice <=", value, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceIn(List<BigDecimal> values) {
			addCriterion("goodsprice in", values, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceNotIn(List<BigDecimal> values) {
			addCriterion("goodsprice not in", values, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goodsprice between", value1, value2, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andGoodspriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goodsprice not between", value1, value2, "goodsprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceIsNull() {
			addCriterion("discountprice is null");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceIsNotNull() {
			addCriterion("discountprice is not null");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceEqualTo(BigDecimal value) {
			addCriterion("discountprice =", value, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceNotEqualTo(BigDecimal value) {
			addCriterion("discountprice <>", value, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceGreaterThan(BigDecimal value) {
			addCriterion("discountprice >", value, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("discountprice >=", value, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceLessThan(BigDecimal value) {
			addCriterion("discountprice <", value, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("discountprice <=", value, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceIn(List<BigDecimal> values) {
			addCriterion("discountprice in", values, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceNotIn(List<BigDecimal> values) {
			addCriterion("discountprice not in", values, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discountprice between", value1, value2, "discountprice");
			return (Criteria) this;
		}

		public Criteria andDiscountpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("discountprice not between", value1, value2, "discountprice");
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
		
		public Criteria andStatusOr(Byte value1, Byte value2) {
			addCriterion("(status = " + value1 + " or status =  " + value2 + " )");
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

		public Criteria andPaytypeIsNull() {
			addCriterion("paytype is null");
			return (Criteria) this;
		}

		public Criteria andPaytypeIsNotNull() {
			addCriterion("paytype is not null");
			return (Criteria) this;
		}

		public Criteria andPaytypeEqualTo(Boolean value) {
			addCriterion("paytype =", value, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeNotEqualTo(Boolean value) {
			addCriterion("paytype <>", value, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeGreaterThan(Boolean value) {
			addCriterion("paytype >", value, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("paytype >=", value, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeLessThan(Boolean value) {
			addCriterion("paytype <", value, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeLessThanOrEqualTo(Boolean value) {
			addCriterion("paytype <=", value, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeIn(List<Boolean> values) {
			addCriterion("paytype in", values, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeNotIn(List<Boolean> values) {
			addCriterion("paytype not in", values, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeBetween(Boolean value1, Boolean value2) {
			addCriterion("paytype between", value1, value2, "paytype");
			return (Criteria) this;
		}

		public Criteria andPaytypeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("paytype not between", value1, value2, "paytype");
			return (Criteria) this;
		}

		public Criteria andTransidIsNull() {
			addCriterion("transid is null");
			return (Criteria) this;
		}

		public Criteria andTransidIsNotNull() {
			addCriterion("transid is not null");
			return (Criteria) this;
		}

		public Criteria andTransidEqualTo(String value) {
			addCriterion("transid =", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidNotEqualTo(String value) {
			addCriterion("transid <>", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidGreaterThan(String value) {
			addCriterion("transid >", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidGreaterThanOrEqualTo(String value) {
			addCriterion("transid >=", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidLessThan(String value) {
			addCriterion("transid <", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidLessThanOrEqualTo(String value) {
			addCriterion("transid <=", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidLike(String value) {
			addCriterion("transid like", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidNotLike(String value) {
			addCriterion("transid not like", value, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidIn(List<String> values) {
			addCriterion("transid in", values, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidNotIn(List<String> values) {
			addCriterion("transid not in", values, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidBetween(String value1, String value2) {
			addCriterion("transid between", value1, value2, "transid");
			return (Criteria) this;
		}

		public Criteria andTransidNotBetween(String value1, String value2) {
			addCriterion("transid not between", value1, value2, "transid");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andAddressidIsNull() {
			addCriterion("addressid is null");
			return (Criteria) this;
		}

		public Criteria andAddressidIsNotNull() {
			addCriterion("addressid is not null");
			return (Criteria) this;
		}

		public Criteria andAddressidEqualTo(Integer value) {
			addCriterion("addressid =", value, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidNotEqualTo(Integer value) {
			addCriterion("addressid <>", value, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidGreaterThan(Integer value) {
			addCriterion("addressid >", value, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidGreaterThanOrEqualTo(Integer value) {
			addCriterion("addressid >=", value, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidLessThan(Integer value) {
			addCriterion("addressid <", value, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidLessThanOrEqualTo(Integer value) {
			addCriterion("addressid <=", value, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidIn(List<Integer> values) {
			addCriterion("addressid in", values, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidNotIn(List<Integer> values) {
			addCriterion("addressid not in", values, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidBetween(Integer value1, Integer value2) {
			addCriterion("addressid between", value1, value2, "addressid");
			return (Criteria) this;
		}

		public Criteria andAddressidNotBetween(Integer value1, Integer value2) {
			addCriterion("addressid not between", value1, value2, "addressid");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceIsNull() {
			addCriterion("dispatchprice is null");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceIsNotNull() {
			addCriterion("dispatchprice is not null");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceEqualTo(BigDecimal value) {
			addCriterion("dispatchprice =", value, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceNotEqualTo(BigDecimal value) {
			addCriterion("dispatchprice <>", value, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceGreaterThan(BigDecimal value) {
			addCriterion("dispatchprice >", value, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("dispatchprice >=", value, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceLessThan(BigDecimal value) {
			addCriterion("dispatchprice <", value, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("dispatchprice <=", value, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceIn(List<BigDecimal> values) {
			addCriterion("dispatchprice in", values, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceNotIn(List<BigDecimal> values) {
			addCriterion("dispatchprice not in", values, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("dispatchprice between", value1, value2, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("dispatchprice not between", value1, value2, "dispatchprice");
			return (Criteria) this;
		}

		public Criteria andDispatchidIsNull() {
			addCriterion("dispatchid is null");
			return (Criteria) this;
		}

		public Criteria andDispatchidIsNotNull() {
			addCriterion("dispatchid is not null");
			return (Criteria) this;
		}

		public Criteria andDispatchidEqualTo(Integer value) {
			addCriterion("dispatchid =", value, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidNotEqualTo(Integer value) {
			addCriterion("dispatchid <>", value, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidGreaterThan(Integer value) {
			addCriterion("dispatchid >", value, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidGreaterThanOrEqualTo(Integer value) {
			addCriterion("dispatchid >=", value, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidLessThan(Integer value) {
			addCriterion("dispatchid <", value, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidLessThanOrEqualTo(Integer value) {
			addCriterion("dispatchid <=", value, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidIn(List<Integer> values) {
			addCriterion("dispatchid in", values, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidNotIn(List<Integer> values) {
			addCriterion("dispatchid not in", values, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidBetween(Integer value1, Integer value2) {
			addCriterion("dispatchid between", value1, value2, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andDispatchidNotBetween(Integer value1, Integer value2) {
			addCriterion("dispatchid not between", value1, value2, "dispatchid");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createtime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createtime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Integer value) {
			addCriterion("createtime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Integer value) {
			addCriterion("createtime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Integer value) {
			addCriterion("createtime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("createtime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Integer value) {
			addCriterion("createtime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Integer value) {
			addCriterion("createtime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Integer> values) {
			addCriterion("createtime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Integer> values) {
			addCriterion("createtime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Integer value1, Integer value2) {
			addCriterion("createtime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Integer value1, Integer value2) {
			addCriterion("createtime not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeIsNull() {
			addCriterion("dispatchtype is null");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeIsNotNull() {
			addCriterion("dispatchtype is not null");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeEqualTo(Byte value) {
			addCriterion("dispatchtype =", value, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeNotEqualTo(Byte value) {
			addCriterion("dispatchtype <>", value, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeGreaterThan(Byte value) {
			addCriterion("dispatchtype >", value, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("dispatchtype >=", value, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeLessThan(Byte value) {
			addCriterion("dispatchtype <", value, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeLessThanOrEqualTo(Byte value) {
			addCriterion("dispatchtype <=", value, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeIn(List<Byte> values) {
			addCriterion("dispatchtype in", values, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeNotIn(List<Byte> values) {
			addCriterion("dispatchtype not in", values, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeBetween(Byte value1, Byte value2) {
			addCriterion("dispatchtype between", value1, value2, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andDispatchtypeNotBetween(Byte value1, Byte value2) {
			addCriterion("dispatchtype not between", value1, value2, "dispatchtype");
			return (Criteria) this;
		}

		public Criteria andRefundidIsNull() {
			addCriterion("refundid is null");
			return (Criteria) this;
		}

		public Criteria andRefundidIsNotNull() {
			addCriterion("refundid is not null");
			return (Criteria) this;
		}

		public Criteria andRefundidEqualTo(Integer value) {
			addCriterion("refundid =", value, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidNotEqualTo(Integer value) {
			addCriterion("refundid <>", value, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidGreaterThan(Integer value) {
			addCriterion("refundid >", value, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidGreaterThanOrEqualTo(Integer value) {
			addCriterion("refundid >=", value, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidLessThan(Integer value) {
			addCriterion("refundid <", value, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidLessThanOrEqualTo(Integer value) {
			addCriterion("refundid <=", value, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidIn(List<Integer> values) {
			addCriterion("refundid in", values, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidNotIn(List<Integer> values) {
			addCriterion("refundid not in", values, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidBetween(Integer value1, Integer value2) {
			addCriterion("refundid between", value1, value2, "refundid");
			return (Criteria) this;
		}

		public Criteria andRefundidNotBetween(Integer value1, Integer value2) {
			addCriterion("refundid not between", value1, value2, "refundid");
			return (Criteria) this;
		}

		public Criteria andIscommentIsNull() {
			addCriterion("iscomment is null");
			return (Criteria) this;
		}

		public Criteria andIscommentIsNotNull() {
			addCriterion("iscomment is not null");
			return (Criteria) this;
		}

		public Criteria andIscommentEqualTo(Byte value) {
			addCriterion("iscomment =", value, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentNotEqualTo(Byte value) {
			addCriterion("iscomment <>", value, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentGreaterThan(Byte value) {
			addCriterion("iscomment >", value, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentGreaterThanOrEqualTo(Byte value) {
			addCriterion("iscomment >=", value, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentLessThan(Byte value) {
			addCriterion("iscomment <", value, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentLessThanOrEqualTo(Byte value) {
			addCriterion("iscomment <=", value, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentIn(List<Byte> values) {
			addCriterion("iscomment in", values, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentNotIn(List<Byte> values) {
			addCriterion("iscomment not in", values, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentBetween(Byte value1, Byte value2) {
			addCriterion("iscomment between", value1, value2, "iscomment");
			return (Criteria) this;
		}

		public Criteria andIscommentNotBetween(Byte value1, Byte value2) {
			addCriterion("iscomment not between", value1, value2, "iscomment");
			return (Criteria) this;
		}

		public Criteria andCreditaddIsNull() {
			addCriterion("creditadd is null");
			return (Criteria) this;
		}

		public Criteria andCreditaddIsNotNull() {
			addCriterion("creditadd is not null");
			return (Criteria) this;
		}

		public Criteria andCreditaddEqualTo(Byte value) {
			addCriterion("creditadd =", value, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddNotEqualTo(Byte value) {
			addCriterion("creditadd <>", value, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddGreaterThan(Byte value) {
			addCriterion("creditadd >", value, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddGreaterThanOrEqualTo(Byte value) {
			addCriterion("creditadd >=", value, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddLessThan(Byte value) {
			addCriterion("creditadd <", value, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddLessThanOrEqualTo(Byte value) {
			addCriterion("creditadd <=", value, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddIn(List<Byte> values) {
			addCriterion("creditadd in", values, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddNotIn(List<Byte> values) {
			addCriterion("creditadd not in", values, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddBetween(Byte value1, Byte value2) {
			addCriterion("creditadd between", value1, value2, "creditadd");
			return (Criteria) this;
		}

		public Criteria andCreditaddNotBetween(Byte value1, Byte value2) {
			addCriterion("creditadd not between", value1, value2, "creditadd");
			return (Criteria) this;
		}

		public Criteria andDeletedIsNull() {
			addCriterion("deleted is null");
			return (Criteria) this;
		}

		public Criteria andDeletedIsNotNull() {
			addCriterion("deleted is not null");
			return (Criteria) this;
		}

		public Criteria andDeletedEqualTo(Byte value) {
			addCriterion("deleted =", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotEqualTo(Byte value) {
			addCriterion("deleted <>", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedGreaterThan(Byte value) {
			addCriterion("deleted >", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedGreaterThanOrEqualTo(Byte value) {
			addCriterion("deleted >=", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedLessThan(Byte value) {
			addCriterion("deleted <", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedLessThanOrEqualTo(Byte value) {
			addCriterion("deleted <=", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedIn(List<Byte> values) {
			addCriterion("deleted in", values, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotIn(List<Byte> values) {
			addCriterion("deleted not in", values, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedBetween(Byte value1, Byte value2) {
			addCriterion("deleted between", value1, value2, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotBetween(Byte value1, Byte value2) {
			addCriterion("deleted not between", value1, value2, "deleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedIsNull() {
			addCriterion("userdeleted is null");
			return (Criteria) this;
		}

		public Criteria andUserdeletedIsNotNull() {
			addCriterion("userdeleted is not null");
			return (Criteria) this;
		}

		public Criteria andUserdeletedEqualTo(Byte value) {
			addCriterion("userdeleted =", value, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedNotEqualTo(Byte value) {
			addCriterion("userdeleted <>", value, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedGreaterThan(Byte value) {
			addCriterion("userdeleted >", value, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedGreaterThanOrEqualTo(Byte value) {
			addCriterion("userdeleted >=", value, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedLessThan(Byte value) {
			addCriterion("userdeleted <", value, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedLessThanOrEqualTo(Byte value) {
			addCriterion("userdeleted <=", value, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedIn(List<Byte> values) {
			addCriterion("userdeleted in", values, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedNotIn(List<Byte> values) {
			addCriterion("userdeleted not in", values, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedBetween(Byte value1, Byte value2) {
			addCriterion("userdeleted between", value1, value2, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andUserdeletedNotBetween(Byte value1, Byte value2) {
			addCriterion("userdeleted not between", value1, value2, "userdeleted");
			return (Criteria) this;
		}

		public Criteria andFinishtimeIsNull() {
			addCriterion("finishtime is null");
			return (Criteria) this;
		}

		public Criteria andFinishtimeIsNotNull() {
			addCriterion("finishtime is not null");
			return (Criteria) this;
		}

		public Criteria andFinishtimeEqualTo(Integer value) {
			addCriterion("finishtime =", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotEqualTo(Integer value) {
			addCriterion("finishtime <>", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeGreaterThan(Integer value) {
			addCriterion("finishtime >", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("finishtime >=", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeLessThan(Integer value) {
			addCriterion("finishtime <", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeLessThanOrEqualTo(Integer value) {
			addCriterion("finishtime <=", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeIn(List<Integer> values) {
			addCriterion("finishtime in", values, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotIn(List<Integer> values) {
			addCriterion("finishtime not in", values, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeBetween(Integer value1, Integer value2) {
			addCriterion("finishtime between", value1, value2, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotBetween(Integer value1, Integer value2) {
			addCriterion("finishtime not between", value1, value2, "finishtime");
			return (Criteria) this;
		}

		public Criteria andPaytimeIsNull() {
			addCriterion("paytime is null");
			return (Criteria) this;
		}

		public Criteria andPaytimeIsNotNull() {
			addCriterion("paytime is not null");
			return (Criteria) this;
		}

		public Criteria andPaytimeEqualTo(Integer value) {
			addCriterion("paytime =", value, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeNotEqualTo(Integer value) {
			addCriterion("paytime <>", value, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeGreaterThan(Integer value) {
			addCriterion("paytime >", value, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("paytime >=", value, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeLessThan(Integer value) {
			addCriterion("paytime <", value, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeLessThanOrEqualTo(Integer value) {
			addCriterion("paytime <=", value, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeIn(List<Integer> values) {
			addCriterion("paytime in", values, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeNotIn(List<Integer> values) {
			addCriterion("paytime not in", values, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeBetween(Integer value1, Integer value2) {
			addCriterion("paytime between", value1, value2, "paytime");
			return (Criteria) this;
		}

		public Criteria andPaytimeNotBetween(Integer value1, Integer value2) {
			addCriterion("paytime not between", value1, value2, "paytime");
			return (Criteria) this;
		}

		public Criteria andExpresscomIsNull() {
			addCriterion("expresscom is null");
			return (Criteria) this;
		}

		public Criteria andExpresscomIsNotNull() {
			addCriterion("expresscom is not null");
			return (Criteria) this;
		}

		public Criteria andExpresscomEqualTo(String value) {
			addCriterion("expresscom =", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomNotEqualTo(String value) {
			addCriterion("expresscom <>", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomGreaterThan(String value) {
			addCriterion("expresscom >", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomGreaterThanOrEqualTo(String value) {
			addCriterion("expresscom >=", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomLessThan(String value) {
			addCriterion("expresscom <", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomLessThanOrEqualTo(String value) {
			addCriterion("expresscom <=", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomLike(String value) {
			addCriterion("expresscom like", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomNotLike(String value) {
			addCriterion("expresscom not like", value, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomIn(List<String> values) {
			addCriterion("expresscom in", values, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomNotIn(List<String> values) {
			addCriterion("expresscom not in", values, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomBetween(String value1, String value2) {
			addCriterion("expresscom between", value1, value2, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresscomNotBetween(String value1, String value2) {
			addCriterion("expresscom not between", value1, value2, "expresscom");
			return (Criteria) this;
		}

		public Criteria andExpresssnIsNull() {
			addCriterion("expresssn is null");
			return (Criteria) this;
		}

		public Criteria andExpresssnIsNotNull() {
			addCriterion("expresssn is not null");
			return (Criteria) this;
		}

		public Criteria andExpresssnEqualTo(String value) {
			addCriterion("expresssn =", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnNotEqualTo(String value) {
			addCriterion("expresssn <>", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnGreaterThan(String value) {
			addCriterion("expresssn >", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnGreaterThanOrEqualTo(String value) {
			addCriterion("expresssn >=", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnLessThan(String value) {
			addCriterion("expresssn <", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnLessThanOrEqualTo(String value) {
			addCriterion("expresssn <=", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnLike(String value) {
			addCriterion("expresssn like", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnNotLike(String value) {
			addCriterion("expresssn not like", value, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnIn(List<String> values) {
			addCriterion("expresssn in", values, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnNotIn(List<String> values) {
			addCriterion("expresssn not in", values, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnBetween(String value1, String value2) {
			addCriterion("expresssn between", value1, value2, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpresssnNotBetween(String value1, String value2) {
			addCriterion("expresssn not between", value1, value2, "expresssn");
			return (Criteria) this;
		}

		public Criteria andExpressIsNull() {
			addCriterion("express is null");
			return (Criteria) this;
		}

		public Criteria andExpressIsNotNull() {
			addCriterion("express is not null");
			return (Criteria) this;
		}

		public Criteria andExpressEqualTo(String value) {
			addCriterion("express =", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressNotEqualTo(String value) {
			addCriterion("express <>", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressGreaterThan(String value) {
			addCriterion("express >", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressGreaterThanOrEqualTo(String value) {
			addCriterion("express >=", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressLessThan(String value) {
			addCriterion("express <", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressLessThanOrEqualTo(String value) {
			addCriterion("express <=", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressLike(String value) {
			addCriterion("express like", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressNotLike(String value) {
			addCriterion("express not like", value, "express");
			return (Criteria) this;
		}

		public Criteria andExpressIn(List<String> values) {
			addCriterion("express in", values, "express");
			return (Criteria) this;
		}

		public Criteria andExpressNotIn(List<String> values) {
			addCriterion("express not in", values, "express");
			return (Criteria) this;
		}

		public Criteria andExpressBetween(String value1, String value2) {
			addCriterion("express between", value1, value2, "express");
			return (Criteria) this;
		}

		public Criteria andExpressNotBetween(String value1, String value2) {
			addCriterion("express not between", value1, value2, "express");
			return (Criteria) this;
		}

		public Criteria andSendtimeIsNull() {
			addCriterion("sendtime is null");
			return (Criteria) this;
		}

		public Criteria andSendtimeIsNotNull() {
			addCriterion("sendtime is not null");
			return (Criteria) this;
		}

		public Criteria andSendtimeEqualTo(Integer value) {
			addCriterion("sendtime =", value, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeNotEqualTo(Integer value) {
			addCriterion("sendtime <>", value, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeGreaterThan(Integer value) {
			addCriterion("sendtime >", value, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("sendtime >=", value, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeLessThan(Integer value) {
			addCriterion("sendtime <", value, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeLessThanOrEqualTo(Integer value) {
			addCriterion("sendtime <=", value, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeIn(List<Integer> values) {
			addCriterion("sendtime in", values, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeNotIn(List<Integer> values) {
			addCriterion("sendtime not in", values, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeBetween(Integer value1, Integer value2) {
			addCriterion("sendtime between", value1, value2, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSendtimeNotBetween(Integer value1, Integer value2) {
			addCriterion("sendtime not between", value1, value2, "sendtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeIsNull() {
			addCriterion("sortingtime is null");
			return (Criteria) this;
		}

		public Criteria andSortingtimeIsNotNull() {
			addCriterion("sortingtime is not null");
			return (Criteria) this;
		}

		public Criteria andSortingtimeEqualTo(Integer value) {
			addCriterion("sortingtime =", value, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeNotEqualTo(Integer value) {
			addCriterion("sortingtime <>", value, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeGreaterThan(Integer value) {
			addCriterion("sortingtime >", value, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("sortingtime >=", value, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeLessThan(Integer value) {
			addCriterion("sortingtime <", value, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeLessThanOrEqualTo(Integer value) {
			addCriterion("sortingtime <=", value, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeIn(List<Integer> values) {
			addCriterion("sortingtime in", values, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeNotIn(List<Integer> values) {
			addCriterion("sortingtime not in", values, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeBetween(Integer value1, Integer value2) {
			addCriterion("sortingtime between", value1, value2, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andSortingtimeNotBetween(Integer value1, Integer value2) {
			addCriterion("sortingtime not between", value1, value2, "sortingtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeIsNull() {
			addCriterion("fetchtime is null");
			return (Criteria) this;
		}

		public Criteria andFetchtimeIsNotNull() {
			addCriterion("fetchtime is not null");
			return (Criteria) this;
		}

		public Criteria andFetchtimeEqualTo(Integer value) {
			addCriterion("fetchtime =", value, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeNotEqualTo(Integer value) {
			addCriterion("fetchtime <>", value, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeGreaterThan(Integer value) {
			addCriterion("fetchtime >", value, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("fetchtime >=", value, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeLessThan(Integer value) {
			addCriterion("fetchtime <", value, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeLessThanOrEqualTo(Integer value) {
			addCriterion("fetchtime <=", value, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeIn(List<Integer> values) {
			addCriterion("fetchtime in", values, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeNotIn(List<Integer> values) {
			addCriterion("fetchtime not in", values, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeBetween(Integer value1, Integer value2) {
			addCriterion("fetchtime between", value1, value2, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andFetchtimeNotBetween(Integer value1, Integer value2) {
			addCriterion("fetchtime not between", value1, value2, "fetchtime");
			return (Criteria) this;
		}

		public Criteria andCashIsNull() {
			addCriterion("cash is null");
			return (Criteria) this;
		}

		public Criteria andCashIsNotNull() {
			addCriterion("cash is not null");
			return (Criteria) this;
		}

		public Criteria andCashEqualTo(Byte value) {
			addCriterion("cash =", value, "cash");
			return (Criteria) this;
		}

		public Criteria andCashNotEqualTo(Byte value) {
			addCriterion("cash <>", value, "cash");
			return (Criteria) this;
		}

		public Criteria andCashGreaterThan(Byte value) {
			addCriterion("cash >", value, "cash");
			return (Criteria) this;
		}

		public Criteria andCashGreaterThanOrEqualTo(Byte value) {
			addCriterion("cash >=", value, "cash");
			return (Criteria) this;
		}

		public Criteria andCashLessThan(Byte value) {
			addCriterion("cash <", value, "cash");
			return (Criteria) this;
		}

		public Criteria andCashLessThanOrEqualTo(Byte value) {
			addCriterion("cash <=", value, "cash");
			return (Criteria) this;
		}

		public Criteria andCashIn(List<Byte> values) {
			addCriterion("cash in", values, "cash");
			return (Criteria) this;
		}

		public Criteria andCashNotIn(List<Byte> values) {
			addCriterion("cash not in", values, "cash");
			return (Criteria) this;
		}

		public Criteria andCashBetween(Byte value1, Byte value2) {
			addCriterion("cash between", value1, value2, "cash");
			return (Criteria) this;
		}

		public Criteria andCashNotBetween(Byte value1, Byte value2) {
			addCriterion("cash not between", value1, value2, "cash");
			return (Criteria) this;
		}

		public Criteria andCanceltimeIsNull() {
			addCriterion("canceltime is null");
			return (Criteria) this;
		}

		public Criteria andCanceltimeIsNotNull() {
			addCriterion("canceltime is not null");
			return (Criteria) this;
		}

		public Criteria andCanceltimeEqualTo(Integer value) {
			addCriterion("canceltime =", value, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeNotEqualTo(Integer value) {
			addCriterion("canceltime <>", value, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeGreaterThan(Integer value) {
			addCriterion("canceltime >", value, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("canceltime >=", value, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeLessThan(Integer value) {
			addCriterion("canceltime <", value, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeLessThanOrEqualTo(Integer value) {
			addCriterion("canceltime <=", value, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeIn(List<Integer> values) {
			addCriterion("canceltime in", values, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeNotIn(List<Integer> values) {
			addCriterion("canceltime not in", values, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeBetween(Integer value1, Integer value2) {
			addCriterion("canceltime between", value1, value2, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCanceltimeNotBetween(Integer value1, Integer value2) {
			addCriterion("canceltime not between", value1, value2, "canceltime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeIsNull() {
			addCriterion("cancelpaytime is null");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeIsNotNull() {
			addCriterion("cancelpaytime is not null");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeEqualTo(Integer value) {
			addCriterion("cancelpaytime =", value, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeNotEqualTo(Integer value) {
			addCriterion("cancelpaytime <>", value, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeGreaterThan(Integer value) {
			addCriterion("cancelpaytime >", value, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("cancelpaytime >=", value, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeLessThan(Integer value) {
			addCriterion("cancelpaytime <", value, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeLessThanOrEqualTo(Integer value) {
			addCriterion("cancelpaytime <=", value, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeIn(List<Integer> values) {
			addCriterion("cancelpaytime in", values, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeNotIn(List<Integer> values) {
			addCriterion("cancelpaytime not in", values, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeBetween(Integer value1, Integer value2) {
			addCriterion("cancelpaytime between", value1, value2, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andCancelpaytimeNotBetween(Integer value1, Integer value2) {
			addCriterion("cancelpaytime not between", value1, value2, "cancelpaytime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeIsNull() {
			addCriterion("refundtime is null");
			return (Criteria) this;
		}

		public Criteria andRefundtimeIsNotNull() {
			addCriterion("refundtime is not null");
			return (Criteria) this;
		}

		public Criteria andRefundtimeEqualTo(Integer value) {
			addCriterion("refundtime =", value, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeNotEqualTo(Integer value) {
			addCriterion("refundtime <>", value, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeGreaterThan(Integer value) {
			addCriterion("refundtime >", value, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("refundtime >=", value, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeLessThan(Integer value) {
			addCriterion("refundtime <", value, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeLessThanOrEqualTo(Integer value) {
			addCriterion("refundtime <=", value, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeIn(List<Integer> values) {
			addCriterion("refundtime in", values, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeNotIn(List<Integer> values) {
			addCriterion("refundtime not in", values, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeBetween(Integer value1, Integer value2) {
			addCriterion("refundtime between", value1, value2, "refundtime");
			return (Criteria) this;
		}

		public Criteria andRefundtimeNotBetween(Integer value1, Integer value2) {
			addCriterion("refundtime not between", value1, value2, "refundtime");
			return (Criteria) this;
		}

		public Criteria andIsverifyIsNull() {
			addCriterion("isverify is null");
			return (Criteria) this;
		}

		public Criteria andIsverifyIsNotNull() {
			addCriterion("isverify is not null");
			return (Criteria) this;
		}

		public Criteria andIsverifyEqualTo(Byte value) {
			addCriterion("isverify =", value, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyNotEqualTo(Byte value) {
			addCriterion("isverify <>", value, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyGreaterThan(Byte value) {
			addCriterion("isverify >", value, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyGreaterThanOrEqualTo(Byte value) {
			addCriterion("isverify >=", value, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyLessThan(Byte value) {
			addCriterion("isverify <", value, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyLessThanOrEqualTo(Byte value) {
			addCriterion("isverify <=", value, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyIn(List<Byte> values) {
			addCriterion("isverify in", values, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyNotIn(List<Byte> values) {
			addCriterion("isverify not in", values, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyBetween(Byte value1, Byte value2) {
			addCriterion("isverify between", value1, value2, "isverify");
			return (Criteria) this;
		}

		public Criteria andIsverifyNotBetween(Byte value1, Byte value2) {
			addCriterion("isverify not between", value1, value2, "isverify");
			return (Criteria) this;
		}

		public Criteria andVerifiedIsNull() {
			addCriterion("verified is null");
			return (Criteria) this;
		}

		public Criteria andVerifiedIsNotNull() {
			addCriterion("verified is not null");
			return (Criteria) this;
		}

		public Criteria andVerifiedEqualTo(Byte value) {
			addCriterion("verified =", value, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedNotEqualTo(Byte value) {
			addCriterion("verified <>", value, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedGreaterThan(Byte value) {
			addCriterion("verified >", value, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedGreaterThanOrEqualTo(Byte value) {
			addCriterion("verified >=", value, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedLessThan(Byte value) {
			addCriterion("verified <", value, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedLessThanOrEqualTo(Byte value) {
			addCriterion("verified <=", value, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedIn(List<Byte> values) {
			addCriterion("verified in", values, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedNotIn(List<Byte> values) {
			addCriterion("verified not in", values, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedBetween(Byte value1, Byte value2) {
			addCriterion("verified between", value1, value2, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifiedNotBetween(Byte value1, Byte value2) {
			addCriterion("verified not between", value1, value2, "verified");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidIsNull() {
			addCriterion("verifyopenid is null");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidIsNotNull() {
			addCriterion("verifyopenid is not null");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidEqualTo(String value) {
			addCriterion("verifyopenid =", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidNotEqualTo(String value) {
			addCriterion("verifyopenid <>", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidGreaterThan(String value) {
			addCriterion("verifyopenid >", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidGreaterThanOrEqualTo(String value) {
			addCriterion("verifyopenid >=", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidLessThan(String value) {
			addCriterion("verifyopenid <", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidLessThanOrEqualTo(String value) {
			addCriterion("verifyopenid <=", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidLike(String value) {
			addCriterion("verifyopenid like", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidNotLike(String value) {
			addCriterion("verifyopenid not like", value, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidIn(List<String> values) {
			addCriterion("verifyopenid in", values, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidNotIn(List<String> values) {
			addCriterion("verifyopenid not in", values, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidBetween(String value1, String value2) {
			addCriterion("verifyopenid between", value1, value2, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifyopenidNotBetween(String value1, String value2) {
			addCriterion("verifyopenid not between", value1, value2, "verifyopenid");
			return (Criteria) this;
		}

		public Criteria andVerifytimeIsNull() {
			addCriterion("verifytime is null");
			return (Criteria) this;
		}

		public Criteria andVerifytimeIsNotNull() {
			addCriterion("verifytime is not null");
			return (Criteria) this;
		}

		public Criteria andVerifytimeEqualTo(Integer value) {
			addCriterion("verifytime =", value, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeNotEqualTo(Integer value) {
			addCriterion("verifytime <>", value, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeGreaterThan(Integer value) {
			addCriterion("verifytime >", value, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("verifytime >=", value, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeLessThan(Integer value) {
			addCriterion("verifytime <", value, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeLessThanOrEqualTo(Integer value) {
			addCriterion("verifytime <=", value, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeIn(List<Integer> values) {
			addCriterion("verifytime in", values, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeNotIn(List<Integer> values) {
			addCriterion("verifytime not in", values, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeBetween(Integer value1, Integer value2) {
			addCriterion("verifytime between", value1, value2, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifytimeNotBetween(Integer value1, Integer value2) {
			addCriterion("verifytime not between", value1, value2, "verifytime");
			return (Criteria) this;
		}

		public Criteria andVerifycodeIsNull() {
			addCriterion("verifycode is null");
			return (Criteria) this;
		}

		public Criteria andVerifycodeIsNotNull() {
			addCriterion("verifycode is not null");
			return (Criteria) this;
		}

		public Criteria andVerifycodeEqualTo(String value) {
			addCriterion("verifycode =", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotEqualTo(String value) {
			addCriterion("verifycode <>", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeGreaterThan(String value) {
			addCriterion("verifycode >", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeGreaterThanOrEqualTo(String value) {
			addCriterion("verifycode >=", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeLessThan(String value) {
			addCriterion("verifycode <", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeLessThanOrEqualTo(String value) {
			addCriterion("verifycode <=", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeLike(String value) {
			addCriterion("verifycode like", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotLike(String value) {
			addCriterion("verifycode not like", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeIn(List<String> values) {
			addCriterion("verifycode in", values, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotIn(List<String> values) {
			addCriterion("verifycode not in", values, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeBetween(String value1, String value2) {
			addCriterion("verifycode between", value1, value2, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotBetween(String value1, String value2) {
			addCriterion("verifycode not between", value1, value2, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidIsNull() {
			addCriterion("verifystoreid is null");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidIsNotNull() {
			addCriterion("verifystoreid is not null");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidEqualTo(Integer value) {
			addCriterion("verifystoreid =", value, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidNotEqualTo(Integer value) {
			addCriterion("verifystoreid <>", value, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidGreaterThan(Integer value) {
			addCriterion("verifystoreid >", value, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidGreaterThanOrEqualTo(Integer value) {
			addCriterion("verifystoreid >=", value, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidLessThan(Integer value) {
			addCriterion("verifystoreid <", value, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidLessThanOrEqualTo(Integer value) {
			addCriterion("verifystoreid <=", value, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidIn(List<Integer> values) {
			addCriterion("verifystoreid in", values, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidNotIn(List<Integer> values) {
			addCriterion("verifystoreid not in", values, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidBetween(Integer value1, Integer value2) {
			addCriterion("verifystoreid between", value1, value2, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andVerifystoreidNotBetween(Integer value1, Integer value2) {
			addCriterion("verifystoreid not between", value1, value2, "verifystoreid");
			return (Criteria) this;
		}

		public Criteria andDeductpriceIsNull() {
			addCriterion("deductprice is null");
			return (Criteria) this;
		}

		public Criteria andDeductpriceIsNotNull() {
			addCriterion("deductprice is not null");
			return (Criteria) this;
		}

		public Criteria andDeductpriceEqualTo(BigDecimal value) {
			addCriterion("deductprice =", value, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceNotEqualTo(BigDecimal value) {
			addCriterion("deductprice <>", value, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceGreaterThan(BigDecimal value) {
			addCriterion("deductprice >", value, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("deductprice >=", value, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceLessThan(BigDecimal value) {
			addCriterion("deductprice <", value, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("deductprice <=", value, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceIn(List<BigDecimal> values) {
			addCriterion("deductprice in", values, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceNotIn(List<BigDecimal> values) {
			addCriterion("deductprice not in", values, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deductprice between", value1, value2, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deductprice not between", value1, value2, "deductprice");
			return (Criteria) this;
		}

		public Criteria andDeductcreditIsNull() {
			addCriterion("deductcredit is null");
			return (Criteria) this;
		}

		public Criteria andDeductcreditIsNotNull() {
			addCriterion("deductcredit is not null");
			return (Criteria) this;
		}

		public Criteria andDeductcreditEqualTo(Integer value) {
			addCriterion("deductcredit =", value, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditNotEqualTo(Integer value) {
			addCriterion("deductcredit <>", value, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditGreaterThan(Integer value) {
			addCriterion("deductcredit >", value, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditGreaterThanOrEqualTo(Integer value) {
			addCriterion("deductcredit >=", value, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditLessThan(Integer value) {
			addCriterion("deductcredit <", value, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditLessThanOrEqualTo(Integer value) {
			addCriterion("deductcredit <=", value, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditIn(List<Integer> values) {
			addCriterion("deductcredit in", values, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditNotIn(List<Integer> values) {
			addCriterion("deductcredit not in", values, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditBetween(Integer value1, Integer value2) {
			addCriterion("deductcredit between", value1, value2, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcreditNotBetween(Integer value1, Integer value2) {
			addCriterion("deductcredit not between", value1, value2, "deductcredit");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2IsNull() {
			addCriterion("deductcredit2 is null");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2IsNotNull() {
			addCriterion("deductcredit2 is not null");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2EqualTo(BigDecimal value) {
			addCriterion("deductcredit2 =", value, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2NotEqualTo(BigDecimal value) {
			addCriterion("deductcredit2 <>", value, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2GreaterThan(BigDecimal value) {
			addCriterion("deductcredit2 >", value, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("deductcredit2 >=", value, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2LessThan(BigDecimal value) {
			addCriterion("deductcredit2 <", value, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2LessThanOrEqualTo(BigDecimal value) {
			addCriterion("deductcredit2 <=", value, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2In(List<BigDecimal> values) {
			addCriterion("deductcredit2 in", values, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2NotIn(List<BigDecimal> values) {
			addCriterion("deductcredit2 not in", values, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2Between(BigDecimal value1, BigDecimal value2) {
			addCriterion("deductcredit2 between", value1, value2, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductcredit2NotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deductcredit2 not between", value1, value2, "deductcredit2");
			return (Criteria) this;
		}

		public Criteria andDeductenoughIsNull() {
			addCriterion("deductenough is null");
			return (Criteria) this;
		}

		public Criteria andDeductenoughIsNotNull() {
			addCriterion("deductenough is not null");
			return (Criteria) this;
		}

		public Criteria andDeductenoughEqualTo(BigDecimal value) {
			addCriterion("deductenough =", value, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughNotEqualTo(BigDecimal value) {
			addCriterion("deductenough <>", value, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughGreaterThan(BigDecimal value) {
			addCriterion("deductenough >", value, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("deductenough >=", value, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughLessThan(BigDecimal value) {
			addCriterion("deductenough <", value, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughLessThanOrEqualTo(BigDecimal value) {
			addCriterion("deductenough <=", value, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughIn(List<BigDecimal> values) {
			addCriterion("deductenough in", values, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughNotIn(List<BigDecimal> values) {
			addCriterion("deductenough not in", values, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deductenough between", value1, value2, "deductenough");
			return (Criteria) this;
		}

		public Criteria andDeductenoughNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deductenough not between", value1, value2, "deductenough");
			return (Criteria) this;
		}

		public Criteria andVirtualIsNull() {
			addCriterion("virtual is null");
			return (Criteria) this;
		}

		public Criteria andVirtualIsNotNull() {
			addCriterion("virtual is not null");
			return (Criteria) this;
		}

		public Criteria andVirtualEqualTo(Integer value) {
			addCriterion("virtual =", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotEqualTo(Integer value) {
			addCriterion("virtual <>", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualGreaterThan(Integer value) {
			addCriterion("virtual >", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualGreaterThanOrEqualTo(Integer value) {
			addCriterion("virtual >=", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualLessThan(Integer value) {
			addCriterion("virtual <", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualLessThanOrEqualTo(Integer value) {
			addCriterion("virtual <=", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualIn(List<Integer> values) {
			addCriterion("virtual in", values, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotIn(List<Integer> values) {
			addCriterion("virtual not in", values, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualBetween(Integer value1, Integer value2) {
			addCriterion("virtual between", value1, value2, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotBetween(Integer value1, Integer value2) {
			addCriterion("virtual not between", value1, value2, "virtual");
			return (Criteria) this;
		}

		public Criteria andSysdeletedIsNull() {
			addCriterion("sysdeleted is null");
			return (Criteria) this;
		}

		public Criteria andSysdeletedIsNotNull() {
			addCriterion("sysdeleted is not null");
			return (Criteria) this;
		}

		public Criteria andSysdeletedEqualTo(Byte value) {
			addCriterion("sysdeleted =", value, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedNotEqualTo(Byte value) {
			addCriterion("sysdeleted <>", value, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedGreaterThan(Byte value) {
			addCriterion("sysdeleted >", value, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedGreaterThanOrEqualTo(Byte value) {
			addCriterion("sysdeleted >=", value, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedLessThan(Byte value) {
			addCriterion("sysdeleted <", value, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedLessThanOrEqualTo(Byte value) {
			addCriterion("sysdeleted <=", value, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedIn(List<Byte> values) {
			addCriterion("sysdeleted in", values, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedNotIn(List<Byte> values) {
			addCriterion("sysdeleted not in", values, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedBetween(Byte value1, Byte value2) {
			addCriterion("sysdeleted between", value1, value2, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andSysdeletedNotBetween(Byte value1, Byte value2) {
			addCriterion("sysdeleted not between", value1, value2, "sysdeleted");
			return (Criteria) this;
		}

		public Criteria andOrdersn2IsNull() {
			addCriterion("ordersn2 is null");
			return (Criteria) this;
		}

		public Criteria andOrdersn2IsNotNull() {
			addCriterion("ordersn2 is not null");
			return (Criteria) this;
		}

		public Criteria andOrdersn2EqualTo(Integer value) {
			addCriterion("ordersn2 =", value, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2NotEqualTo(Integer value) {
			addCriterion("ordersn2 <>", value, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2GreaterThan(Integer value) {
			addCriterion("ordersn2 >", value, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2GreaterThanOrEqualTo(Integer value) {
			addCriterion("ordersn2 >=", value, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2LessThan(Integer value) {
			addCriterion("ordersn2 <", value, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2LessThanOrEqualTo(Integer value) {
			addCriterion("ordersn2 <=", value, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2In(List<Integer> values) {
			addCriterion("ordersn2 in", values, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2NotIn(List<Integer> values) {
			addCriterion("ordersn2 not in", values, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2Between(Integer value1, Integer value2) {
			addCriterion("ordersn2 between", value1, value2, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andOrdersn2NotBetween(Integer value1, Integer value2) {
			addCriterion("ordersn2 not between", value1, value2, "ordersn2");
			return (Criteria) this;
		}

		public Criteria andChangepriceIsNull() {
			addCriterion("changeprice is null");
			return (Criteria) this;
		}

		public Criteria andChangepriceIsNotNull() {
			addCriterion("changeprice is not null");
			return (Criteria) this;
		}

		public Criteria andChangepriceEqualTo(BigDecimal value) {
			addCriterion("changeprice =", value, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceNotEqualTo(BigDecimal value) {
			addCriterion("changeprice <>", value, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceGreaterThan(BigDecimal value) {
			addCriterion("changeprice >", value, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("changeprice >=", value, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceLessThan(BigDecimal value) {
			addCriterion("changeprice <", value, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("changeprice <=", value, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceIn(List<BigDecimal> values) {
			addCriterion("changeprice in", values, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceNotIn(List<BigDecimal> values) {
			addCriterion("changeprice not in", values, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("changeprice between", value1, value2, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangepriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("changeprice not between", value1, value2, "changeprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceIsNull() {
			addCriterion("changedispatchprice is null");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceIsNotNull() {
			addCriterion("changedispatchprice is not null");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceEqualTo(BigDecimal value) {
			addCriterion("changedispatchprice =", value, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceNotEqualTo(BigDecimal value) {
			addCriterion("changedispatchprice <>", value, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceGreaterThan(BigDecimal value) {
			addCriterion("changedispatchprice >", value, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("changedispatchprice >=", value, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceLessThan(BigDecimal value) {
			addCriterion("changedispatchprice <", value, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("changedispatchprice <=", value, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceIn(List<BigDecimal> values) {
			addCriterion("changedispatchprice in", values, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceNotIn(List<BigDecimal> values) {
			addCriterion("changedispatchprice not in", values, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("changedispatchprice between", value1, value2, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andChangedispatchpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("changedispatchprice not between", value1, value2, "changedispatchprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceIsNull() {
			addCriterion("oldprice is null");
			return (Criteria) this;
		}

		public Criteria andOldpriceIsNotNull() {
			addCriterion("oldprice is not null");
			return (Criteria) this;
		}

		public Criteria andOldpriceEqualTo(BigDecimal value) {
			addCriterion("oldprice =", value, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceNotEqualTo(BigDecimal value) {
			addCriterion("oldprice <>", value, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceGreaterThan(BigDecimal value) {
			addCriterion("oldprice >", value, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("oldprice >=", value, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceLessThan(BigDecimal value) {
			addCriterion("oldprice <", value, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("oldprice <=", value, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceIn(List<BigDecimal> values) {
			addCriterion("oldprice in", values, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceNotIn(List<BigDecimal> values) {
			addCriterion("oldprice not in", values, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("oldprice between", value1, value2, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOldpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("oldprice not between", value1, value2, "oldprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceIsNull() {
			addCriterion("olddispatchprice is null");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceIsNotNull() {
			addCriterion("olddispatchprice is not null");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceEqualTo(BigDecimal value) {
			addCriterion("olddispatchprice =", value, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceNotEqualTo(BigDecimal value) {
			addCriterion("olddispatchprice <>", value, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceGreaterThan(BigDecimal value) {
			addCriterion("olddispatchprice >", value, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("olddispatchprice >=", value, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceLessThan(BigDecimal value) {
			addCriterion("olddispatchprice <", value, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("olddispatchprice <=", value, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceIn(List<BigDecimal> values) {
			addCriterion("olddispatchprice in", values, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceNotIn(List<BigDecimal> values) {
			addCriterion("olddispatchprice not in", values, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("olddispatchprice between", value1, value2, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andOlddispatchpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("olddispatchprice not between", value1, value2, "olddispatchprice");
			return (Criteria) this;
		}

		public Criteria andIsvirtualIsNull() {
			addCriterion("isvirtual is null");
			return (Criteria) this;
		}

		public Criteria andIsvirtualIsNotNull() {
			addCriterion("isvirtual is not null");
			return (Criteria) this;
		}

		public Criteria andIsvirtualEqualTo(Byte value) {
			addCriterion("isvirtual =", value, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualNotEqualTo(Byte value) {
			addCriterion("isvirtual <>", value, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualGreaterThan(Byte value) {
			addCriterion("isvirtual >", value, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualGreaterThanOrEqualTo(Byte value) {
			addCriterion("isvirtual >=", value, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualLessThan(Byte value) {
			addCriterion("isvirtual <", value, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualLessThanOrEqualTo(Byte value) {
			addCriterion("isvirtual <=", value, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualIn(List<Byte> values) {
			addCriterion("isvirtual in", values, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualNotIn(List<Byte> values) {
			addCriterion("isvirtual not in", values, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualBetween(Byte value1, Byte value2) {
			addCriterion("isvirtual between", value1, value2, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andIsvirtualNotBetween(Byte value1, Byte value2) {
			addCriterion("isvirtual not between", value1, value2, "isvirtual");
			return (Criteria) this;
		}

		public Criteria andCouponidIsNull() {
			addCriterion("couponid is null");
			return (Criteria) this;
		}

		public Criteria andCouponidIsNotNull() {
			addCriterion("couponid is not null");
			return (Criteria) this;
		}

		public Criteria andCouponidEqualTo(Integer value) {
			addCriterion("couponid =", value, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidNotEqualTo(Integer value) {
			addCriterion("couponid <>", value, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidGreaterThan(Integer value) {
			addCriterion("couponid >", value, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidGreaterThanOrEqualTo(Integer value) {
			addCriterion("couponid >=", value, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidLessThan(Integer value) {
			addCriterion("couponid <", value, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidLessThanOrEqualTo(Integer value) {
			addCriterion("couponid <=", value, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidIn(List<Integer> values) {
			addCriterion("couponid in", values, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidNotIn(List<Integer> values) {
			addCriterion("couponid not in", values, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidBetween(Integer value1, Integer value2) {
			addCriterion("couponid between", value1, value2, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponidNotBetween(Integer value1, Integer value2) {
			addCriterion("couponid not between", value1, value2, "couponid");
			return (Criteria) this;
		}

		public Criteria andCouponpriceIsNull() {
			addCriterion("couponprice is null");
			return (Criteria) this;
		}

		public Criteria andCouponpriceIsNotNull() {
			addCriterion("couponprice is not null");
			return (Criteria) this;
		}

		public Criteria andCouponpriceEqualTo(BigDecimal value) {
			addCriterion("couponprice =", value, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceNotEqualTo(BigDecimal value) {
			addCriterion("couponprice <>", value, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceGreaterThan(BigDecimal value) {
			addCriterion("couponprice >", value, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("couponprice >=", value, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceLessThan(BigDecimal value) {
			addCriterion("couponprice <", value, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("couponprice <=", value, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceIn(List<BigDecimal> values) {
			addCriterion("couponprice in", values, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceNotIn(List<BigDecimal> values) {
			addCriterion("couponprice not in", values, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("couponprice between", value1, value2, "couponprice");
			return (Criteria) this;
		}

		public Criteria andCouponpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("couponprice not between", value1, value2, "couponprice");
			return (Criteria) this;
		}

		public Criteria andDiyformidIsNull() {
			addCriterion("diyformid is null");
			return (Criteria) this;
		}

		public Criteria andDiyformidIsNotNull() {
			addCriterion("diyformid is not null");
			return (Criteria) this;
		}

		public Criteria andDiyformidEqualTo(Integer value) {
			addCriterion("diyformid =", value, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidNotEqualTo(Integer value) {
			addCriterion("diyformid <>", value, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidGreaterThan(Integer value) {
			addCriterion("diyformid >", value, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidGreaterThanOrEqualTo(Integer value) {
			addCriterion("diyformid >=", value, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidLessThan(Integer value) {
			addCriterion("diyformid <", value, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidLessThanOrEqualTo(Integer value) {
			addCriterion("diyformid <=", value, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidIn(List<Integer> values) {
			addCriterion("diyformid in", values, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidNotIn(List<Integer> values) {
			addCriterion("diyformid not in", values, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidBetween(Integer value1, Integer value2) {
			addCriterion("diyformid between", value1, value2, "diyformid");
			return (Criteria) this;
		}

		public Criteria andDiyformidNotBetween(Integer value1, Integer value2) {
			addCriterion("diyformid not between", value1, value2, "diyformid");
			return (Criteria) this;
		}

		public Criteria andStoreidIsNull() {
			addCriterion("storeid is null");
			return (Criteria) this;
		}

		public Criteria andStoreidIsNotNull() {
			addCriterion("storeid is not null");
			return (Criteria) this;
		}

		public Criteria andStoreidEqualTo(Integer value) {
			addCriterion("storeid =", value, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidNotEqualTo(Integer value) {
			addCriterion("storeid <>", value, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidGreaterThan(Integer value) {
			addCriterion("storeid >", value, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidGreaterThanOrEqualTo(Integer value) {
			addCriterion("storeid >=", value, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidLessThan(Integer value) {
			addCriterion("storeid <", value, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidLessThanOrEqualTo(Integer value) {
			addCriterion("storeid <=", value, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidIn(List<Integer> values) {
			addCriterion("storeid in", values, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidNotIn(List<Integer> values) {
			addCriterion("storeid not in", values, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidBetween(Integer value1, Integer value2) {
			addCriterion("storeid between", value1, value2, "storeid");
			return (Criteria) this;
		}

		public Criteria andStoreidNotBetween(Integer value1, Integer value2) {
			addCriterion("storeid not between", value1, value2, "storeid");
			return (Criteria) this;
		}

		public Criteria andPrintstateIsNull() {
			addCriterion("printstate is null");
			return (Criteria) this;
		}

		public Criteria andPrintstateIsNotNull() {
			addCriterion("printstate is not null");
			return (Criteria) this;
		}

		public Criteria andPrintstateEqualTo(Boolean value) {
			addCriterion("printstate =", value, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateNotEqualTo(Boolean value) {
			addCriterion("printstate <>", value, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateGreaterThan(Boolean value) {
			addCriterion("printstate >", value, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("printstate >=", value, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateLessThan(Boolean value) {
			addCriterion("printstate <", value, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateLessThanOrEqualTo(Boolean value) {
			addCriterion("printstate <=", value, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateIn(List<Boolean> values) {
			addCriterion("printstate in", values, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateNotIn(List<Boolean> values) {
			addCriterion("printstate not in", values, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateBetween(Boolean value1, Boolean value2) {
			addCriterion("printstate between", value1, value2, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("printstate not between", value1, value2, "printstate");
			return (Criteria) this;
		}

		public Criteria andPrintstate2IsNull() {
			addCriterion("printstate2 is null");
			return (Criteria) this;
		}

		public Criteria andPrintstate2IsNotNull() {
			addCriterion("printstate2 is not null");
			return (Criteria) this;
		}

		public Criteria andPrintstate2EqualTo(Boolean value) {
			addCriterion("printstate2 =", value, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2NotEqualTo(Boolean value) {
			addCriterion("printstate2 <>", value, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2GreaterThan(Boolean value) {
			addCriterion("printstate2 >", value, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2GreaterThanOrEqualTo(Boolean value) {
			addCriterion("printstate2 >=", value, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2LessThan(Boolean value) {
			addCriterion("printstate2 <", value, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2LessThanOrEqualTo(Boolean value) {
			addCriterion("printstate2 <=", value, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2In(List<Boolean> values) {
			addCriterion("printstate2 in", values, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2NotIn(List<Boolean> values) {
			addCriterion("printstate2 not in", values, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2Between(Boolean value1, Boolean value2) {
			addCriterion("printstate2 between", value1, value2, "printstate2");
			return (Criteria) this;
		}

		public Criteria andPrintstate2NotBetween(Boolean value1, Boolean value2) {
			addCriterion("printstate2 not between", value1, value2, "printstate2");
			return (Criteria) this;
		}

		public Criteria andRefundstateIsNull() {
			addCriterion("refundstate is null");
			return (Criteria) this;
		}

		public Criteria andRefundstateIsNotNull() {
			addCriterion("refundstate is not null");
			return (Criteria) this;
		}

		public Criteria andRefundstateEqualTo(Byte value) {
			addCriterion("refundstate =", value, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateNotEqualTo(Byte value) {
			addCriterion("refundstate <>", value, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateGreaterThan(Byte value) {
			addCriterion("refundstate >", value, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateGreaterThanOrEqualTo(Byte value) {
			addCriterion("refundstate >=", value, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateLessThan(Byte value) {
			addCriterion("refundstate <", value, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateLessThanOrEqualTo(Byte value) {
			addCriterion("refundstate <=", value, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateIn(List<Byte> values) {
			addCriterion("refundstate in", values, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateNotIn(List<Byte> values) {
			addCriterion("refundstate not in", values, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateBetween(Byte value1, Byte value2) {
			addCriterion("refundstate between", value1, value2, "refundstate");
			return (Criteria) this;
		}

		public Criteria andRefundstateNotBetween(Byte value1, Byte value2) {
			addCriterion("refundstate not between", value1, value2, "refundstate");
			return (Criteria) this;
		}

		public Criteria andIsmrIsNull() {
			addCriterion("ismr is null");
			return (Criteria) this;
		}

		public Criteria andIsmrIsNotNull() {
			addCriterion("ismr is not null");
			return (Criteria) this;
		}

		public Criteria andIsmrEqualTo(Integer value) {
			addCriterion("ismr =", value, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrNotEqualTo(Integer value) {
			addCriterion("ismr <>", value, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrGreaterThan(Integer value) {
			addCriterion("ismr >", value, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrGreaterThanOrEqualTo(Integer value) {
			addCriterion("ismr >=", value, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrLessThan(Integer value) {
			addCriterion("ismr <", value, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrLessThanOrEqualTo(Integer value) {
			addCriterion("ismr <=", value, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrIn(List<Integer> values) {
			addCriterion("ismr in", values, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrNotIn(List<Integer> values) {
			addCriterion("ismr not in", values, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrBetween(Integer value1, Integer value2) {
			addCriterion("ismr between", value1, value2, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsmrNotBetween(Integer value1, Integer value2) {
			addCriterion("ismr not between", value1, value2, "ismr");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceIsNull() {
			addCriterion("isdiscountprice is null");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceIsNotNull() {
			addCriterion("isdiscountprice is not null");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceEqualTo(BigDecimal value) {
			addCriterion("isdiscountprice =", value, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceNotEqualTo(BigDecimal value) {
			addCriterion("isdiscountprice <>", value, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceGreaterThan(BigDecimal value) {
			addCriterion("isdiscountprice >", value, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("isdiscountprice >=", value, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceLessThan(BigDecimal value) {
			addCriterion("isdiscountprice <", value, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("isdiscountprice <=", value, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceIn(List<BigDecimal> values) {
			addCriterion("isdiscountprice in", values, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceNotIn(List<BigDecimal> values) {
			addCriterion("isdiscountprice not in", values, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("isdiscountprice between", value1, value2, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsdiscountpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("isdiscountprice not between", value1, value2, "isdiscountprice");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendIsNull() {
			addCriterion("isvirtualsend is null");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendIsNotNull() {
			addCriterion("isvirtualsend is not null");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendEqualTo(Boolean value) {
			addCriterion("isvirtualsend =", value, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendNotEqualTo(Boolean value) {
			addCriterion("isvirtualsend <>", value, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendGreaterThan(Boolean value) {
			addCriterion("isvirtualsend >", value, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("isvirtualsend >=", value, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendLessThan(Boolean value) {
			addCriterion("isvirtualsend <", value, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendLessThanOrEqualTo(Boolean value) {
			addCriterion("isvirtualsend <=", value, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendIn(List<Boolean> values) {
			addCriterion("isvirtualsend in", values, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendNotIn(List<Boolean> values) {
			addCriterion("isvirtualsend not in", values, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendBetween(Boolean value1, Boolean value2) {
			addCriterion("isvirtualsend between", value1, value2, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andIsvirtualsendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("isvirtualsend not between", value1, value2, "isvirtualsend");
			return (Criteria) this;
		}

		public Criteria andVerifytypeIsNull() {
			addCriterion("verifytype is null");
			return (Criteria) this;
		}

		public Criteria andVerifytypeIsNotNull() {
			addCriterion("verifytype is not null");
			return (Criteria) this;
		}

		public Criteria andVerifytypeEqualTo(Boolean value) {
			addCriterion("verifytype =", value, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeNotEqualTo(Boolean value) {
			addCriterion("verifytype <>", value, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeGreaterThan(Boolean value) {
			addCriterion("verifytype >", value, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("verifytype >=", value, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeLessThan(Boolean value) {
			addCriterion("verifytype <", value, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeLessThanOrEqualTo(Boolean value) {
			addCriterion("verifytype <=", value, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeIn(List<Boolean> values) {
			addCriterion("verifytype in", values, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeNotIn(List<Boolean> values) {
			addCriterion("verifytype not in", values, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeBetween(Boolean value1, Boolean value2) {
			addCriterion("verifytype between", value1, value2, "verifytype");
			return (Criteria) this;
		}

		public Criteria andVerifytypeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("verifytype not between", value1, value2, "verifytype");
			return (Criteria) this;
		}

		public Criteria andMerchidIsNull() {
			addCriterion("merchid is null");
			return (Criteria) this;
		}

		public Criteria andMerchidIsNotNull() {
			addCriterion("merchid is not null");
			return (Criteria) this;
		}

		public Criteria andMerchidEqualTo(Integer value) {
			addCriterion("merchid =", value, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidNotEqualTo(Integer value) {
			addCriterion("merchid <>", value, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidGreaterThan(Integer value) {
			addCriterion("merchid >", value, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidGreaterThanOrEqualTo(Integer value) {
			addCriterion("merchid >=", value, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidLessThan(Integer value) {
			addCriterion("merchid <", value, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidLessThanOrEqualTo(Integer value) {
			addCriterion("merchid <=", value, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidIn(List<Integer> values) {
			addCriterion("merchid in", values, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidNotIn(List<Integer> values) {
			addCriterion("merchid not in", values, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidBetween(Integer value1, Integer value2) {
			addCriterion("merchid between", value1, value2, "merchid");
			return (Criteria) this;
		}

		public Criteria andMerchidNotBetween(Integer value1, Integer value2) {
			addCriterion("merchid not between", value1, value2, "merchid");
			return (Criteria) this;
		}

		public Criteria andInvoicenameIsNull() {
			addCriterion("invoicename is null");
			return (Criteria) this;
		}

		public Criteria andInvoicenameIsNotNull() {
			addCriterion("invoicename is not null");
			return (Criteria) this;
		}

		public Criteria andInvoicenameEqualTo(String value) {
			addCriterion("invoicename =", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameNotEqualTo(String value) {
			addCriterion("invoicename <>", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameGreaterThan(String value) {
			addCriterion("invoicename >", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameGreaterThanOrEqualTo(String value) {
			addCriterion("invoicename >=", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameLessThan(String value) {
			addCriterion("invoicename <", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameLessThanOrEqualTo(String value) {
			addCriterion("invoicename <=", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameLike(String value) {
			addCriterion("invoicename like", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameNotLike(String value) {
			addCriterion("invoicename not like", value, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameIn(List<String> values) {
			addCriterion("invoicename in", values, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameNotIn(List<String> values) {
			addCriterion("invoicename not in", values, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameBetween(String value1, String value2) {
			addCriterion("invoicename between", value1, value2, "invoicename");
			return (Criteria) this;
		}

		public Criteria andInvoicenameNotBetween(String value1, String value2) {
			addCriterion("invoicename not between", value1, value2, "invoicename");
			return (Criteria) this;
		}

		public Criteria andIsmerchIsNull() {
			addCriterion("ismerch is null");
			return (Criteria) this;
		}

		public Criteria andIsmerchIsNotNull() {
			addCriterion("ismerch is not null");
			return (Criteria) this;
		}

		public Criteria andIsmerchEqualTo(Boolean value) {
			addCriterion("ismerch =", value, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchNotEqualTo(Boolean value) {
			addCriterion("ismerch <>", value, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchGreaterThan(Boolean value) {
			addCriterion("ismerch >", value, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ismerch >=", value, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchLessThan(Boolean value) {
			addCriterion("ismerch <", value, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchLessThanOrEqualTo(Boolean value) {
			addCriterion("ismerch <=", value, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchIn(List<Boolean> values) {
			addCriterion("ismerch in", values, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchNotIn(List<Boolean> values) {
			addCriterion("ismerch not in", values, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchBetween(Boolean value1, Boolean value2) {
			addCriterion("ismerch between", value1, value2, "ismerch");
			return (Criteria) this;
		}

		public Criteria andIsmerchNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ismerch not between", value1, value2, "ismerch");
			return (Criteria) this;
		}

		public Criteria andParentidIsNull() {
			addCriterion("parentid is null");
			return (Criteria) this;
		}

		public Criteria andParentidIsNotNull() {
			addCriterion("parentid is not null");
			return (Criteria) this;
		}

		public Criteria andParentidEqualTo(Integer value) {
			addCriterion("parentid =", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidNotEqualTo(Integer value) {
			addCriterion("parentid <>", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidGreaterThan(Integer value) {
			addCriterion("parentid >", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
			addCriterion("parentid >=", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidLessThan(Integer value) {
			addCriterion("parentid <", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidLessThanOrEqualTo(Integer value) {
			addCriterion("parentid <=", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidIn(List<Integer> values) {
			addCriterion("parentid in", values, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidNotIn(List<Integer> values) {
			addCriterion("parentid not in", values, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidBetween(Integer value1, Integer value2) {
			addCriterion("parentid between", value1, value2, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidNotBetween(Integer value1, Integer value2) {
			addCriterion("parentid not between", value1, value2, "parentid");
			return (Criteria) this;
		}

		public Criteria andIsparentIsNull() {
			addCriterion("isparent is null");
			return (Criteria) this;
		}

		public Criteria andIsparentIsNotNull() {
			addCriterion("isparent is not null");
			return (Criteria) this;
		}

		public Criteria andIsparentEqualTo(Boolean value) {
			addCriterion("isparent =", value, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentNotEqualTo(Boolean value) {
			addCriterion("isparent <>", value, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentGreaterThan(Boolean value) {
			addCriterion("isparent >", value, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentGreaterThanOrEqualTo(Boolean value) {
			addCriterion("isparent >=", value, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentLessThan(Boolean value) {
			addCriterion("isparent <", value, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentLessThanOrEqualTo(Boolean value) {
			addCriterion("isparent <=", value, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentIn(List<Boolean> values) {
			addCriterion("isparent in", values, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentNotIn(List<Boolean> values) {
			addCriterion("isparent not in", values, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentBetween(Boolean value1, Boolean value2) {
			addCriterion("isparent between", value1, value2, "isparent");
			return (Criteria) this;
		}

		public Criteria andIsparentNotBetween(Boolean value1, Boolean value2) {
			addCriterion("isparent not between", value1, value2, "isparent");
			return (Criteria) this;
		}

		public Criteria andGrpriceIsNull() {
			addCriterion("grprice is null");
			return (Criteria) this;
		}

		public Criteria andGrpriceIsNotNull() {
			addCriterion("grprice is not null");
			return (Criteria) this;
		}

		public Criteria andGrpriceEqualTo(BigDecimal value) {
			addCriterion("grprice =", value, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceNotEqualTo(BigDecimal value) {
			addCriterion("grprice <>", value, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceGreaterThan(BigDecimal value) {
			addCriterion("grprice >", value, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("grprice >=", value, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceLessThan(BigDecimal value) {
			addCriterion("grprice <", value, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("grprice <=", value, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceIn(List<BigDecimal> values) {
			addCriterion("grprice in", values, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceNotIn(List<BigDecimal> values) {
			addCriterion("grprice not in", values, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("grprice between", value1, value2, "grprice");
			return (Criteria) this;
		}

		public Criteria andGrpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("grprice not between", value1, value2, "grprice");
			return (Criteria) this;
		}

		public Criteria andMerchshowIsNull() {
			addCriterion("merchshow is null");
			return (Criteria) this;
		}

		public Criteria andMerchshowIsNotNull() {
			addCriterion("merchshow is not null");
			return (Criteria) this;
		}

		public Criteria andMerchshowEqualTo(Boolean value) {
			addCriterion("merchshow =", value, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowNotEqualTo(Boolean value) {
			addCriterion("merchshow <>", value, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowGreaterThan(Boolean value) {
			addCriterion("merchshow >", value, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowGreaterThanOrEqualTo(Boolean value) {
			addCriterion("merchshow >=", value, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowLessThan(Boolean value) {
			addCriterion("merchshow <", value, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowLessThanOrEqualTo(Boolean value) {
			addCriterion("merchshow <=", value, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowIn(List<Boolean> values) {
			addCriterion("merchshow in", values, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowNotIn(List<Boolean> values) {
			addCriterion("merchshow not in", values, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowBetween(Boolean value1, Boolean value2) {
			addCriterion("merchshow between", value1, value2, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchshowNotBetween(Boolean value1, Boolean value2) {
			addCriterion("merchshow not between", value1, value2, "merchshow");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughIsNull() {
			addCriterion("merchdeductenough is null");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughIsNotNull() {
			addCriterion("merchdeductenough is not null");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughEqualTo(BigDecimal value) {
			addCriterion("merchdeductenough =", value, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughNotEqualTo(BigDecimal value) {
			addCriterion("merchdeductenough <>", value, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughGreaterThan(BigDecimal value) {
			addCriterion("merchdeductenough >", value, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("merchdeductenough >=", value, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughLessThan(BigDecimal value) {
			addCriterion("merchdeductenough <", value, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughLessThanOrEqualTo(BigDecimal value) {
			addCriterion("merchdeductenough <=", value, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughIn(List<BigDecimal> values) {
			addCriterion("merchdeductenough in", values, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughNotIn(List<BigDecimal> values) {
			addCriterion("merchdeductenough not in", values, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("merchdeductenough between", value1, value2, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andMerchdeductenoughNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("merchdeductenough not between", value1, value2, "merchdeductenough");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidIsNull() {
			addCriterion("couponmerchid is null");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidIsNotNull() {
			addCriterion("couponmerchid is not null");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidEqualTo(Integer value) {
			addCriterion("couponmerchid =", value, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidNotEqualTo(Integer value) {
			addCriterion("couponmerchid <>", value, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidGreaterThan(Integer value) {
			addCriterion("couponmerchid >", value, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidGreaterThanOrEqualTo(Integer value) {
			addCriterion("couponmerchid >=", value, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidLessThan(Integer value) {
			addCriterion("couponmerchid <", value, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidLessThanOrEqualTo(Integer value) {
			addCriterion("couponmerchid <=", value, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidIn(List<Integer> values) {
			addCriterion("couponmerchid in", values, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidNotIn(List<Integer> values) {
			addCriterion("couponmerchid not in", values, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidBetween(Integer value1, Integer value2) {
			addCriterion("couponmerchid between", value1, value2, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andCouponmerchidNotBetween(Integer value1, Integer value2) {
			addCriterion("couponmerchid not between", value1, value2, "couponmerchid");
			return (Criteria) this;
		}

		public Criteria andIsglobonusIsNull() {
			addCriterion("isglobonus is null");
			return (Criteria) this;
		}

		public Criteria andIsglobonusIsNotNull() {
			addCriterion("isglobonus is not null");
			return (Criteria) this;
		}

		public Criteria andIsglobonusEqualTo(Byte value) {
			addCriterion("isglobonus =", value, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusNotEqualTo(Byte value) {
			addCriterion("isglobonus <>", value, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusGreaterThan(Byte value) {
			addCriterion("isglobonus >", value, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusGreaterThanOrEqualTo(Byte value) {
			addCriterion("isglobonus >=", value, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusLessThan(Byte value) {
			addCriterion("isglobonus <", value, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusLessThanOrEqualTo(Byte value) {
			addCriterion("isglobonus <=", value, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusIn(List<Byte> values) {
			addCriterion("isglobonus in", values, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusNotIn(List<Byte> values) {
			addCriterion("isglobonus not in", values, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusBetween(Byte value1, Byte value2) {
			addCriterion("isglobonus between", value1, value2, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andIsglobonusNotBetween(Byte value1, Byte value2) {
			addCriterion("isglobonus not between", value1, value2, "isglobonus");
			return (Criteria) this;
		}

		public Criteria andMerchapplyIsNull() {
			addCriterion("merchapply is null");
			return (Criteria) this;
		}

		public Criteria andMerchapplyIsNotNull() {
			addCriterion("merchapply is not null");
			return (Criteria) this;
		}

		public Criteria andMerchapplyEqualTo(Boolean value) {
			addCriterion("merchapply =", value, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyNotEqualTo(Boolean value) {
			addCriterion("merchapply <>", value, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyGreaterThan(Boolean value) {
			addCriterion("merchapply >", value, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyGreaterThanOrEqualTo(Boolean value) {
			addCriterion("merchapply >=", value, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyLessThan(Boolean value) {
			addCriterion("merchapply <", value, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyLessThanOrEqualTo(Boolean value) {
			addCriterion("merchapply <=", value, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyIn(List<Boolean> values) {
			addCriterion("merchapply in", values, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyNotIn(List<Boolean> values) {
			addCriterion("merchapply not in", values, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyBetween(Boolean value1, Boolean value2) {
			addCriterion("merchapply between", value1, value2, "merchapply");
			return (Criteria) this;
		}

		public Criteria andMerchapplyNotBetween(Boolean value1, Boolean value2) {
			addCriterion("merchapply not between", value1, value2, "merchapply");
			return (Criteria) this;
		}

		public Criteria andIsabonusIsNull() {
			addCriterion("isabonus is null");
			return (Criteria) this;
		}

		public Criteria andIsabonusIsNotNull() {
			addCriterion("isabonus is not null");
			return (Criteria) this;
		}

		public Criteria andIsabonusEqualTo(Byte value) {
			addCriterion("isabonus =", value, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusNotEqualTo(Byte value) {
			addCriterion("isabonus <>", value, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusGreaterThan(Byte value) {
			addCriterion("isabonus >", value, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusGreaterThanOrEqualTo(Byte value) {
			addCriterion("isabonus >=", value, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusLessThan(Byte value) {
			addCriterion("isabonus <", value, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusLessThanOrEqualTo(Byte value) {
			addCriterion("isabonus <=", value, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusIn(List<Byte> values) {
			addCriterion("isabonus in", values, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusNotIn(List<Byte> values) {
			addCriterion("isabonus not in", values, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusBetween(Byte value1, Byte value2) {
			addCriterion("isabonus between", value1, value2, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsabonusNotBetween(Byte value1, Byte value2) {
			addCriterion("isabonus not between", value1, value2, "isabonus");
			return (Criteria) this;
		}

		public Criteria andIsborrowIsNull() {
			addCriterion("isborrow is null");
			return (Criteria) this;
		}

		public Criteria andIsborrowIsNotNull() {
			addCriterion("isborrow is not null");
			return (Criteria) this;
		}

		public Criteria andIsborrowEqualTo(Byte value) {
			addCriterion("isborrow =", value, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowNotEqualTo(Byte value) {
			addCriterion("isborrow <>", value, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowGreaterThan(Byte value) {
			addCriterion("isborrow >", value, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowGreaterThanOrEqualTo(Byte value) {
			addCriterion("isborrow >=", value, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowLessThan(Byte value) {
			addCriterion("isborrow <", value, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowLessThanOrEqualTo(Byte value) {
			addCriterion("isborrow <=", value, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowIn(List<Byte> values) {
			addCriterion("isborrow in", values, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowNotIn(List<Byte> values) {
			addCriterion("isborrow not in", values, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowBetween(Byte value1, Byte value2) {
			addCriterion("isborrow between", value1, value2, "isborrow");
			return (Criteria) this;
		}

		public Criteria andIsborrowNotBetween(Byte value1, Byte value2) {
			addCriterion("isborrow not between", value1, value2, "isborrow");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidIsNull() {
			addCriterion("borrowopenid is null");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidIsNotNull() {
			addCriterion("borrowopenid is not null");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidEqualTo(String value) {
			addCriterion("borrowopenid =", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidNotEqualTo(String value) {
			addCriterion("borrowopenid <>", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidGreaterThan(String value) {
			addCriterion("borrowopenid >", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidGreaterThanOrEqualTo(String value) {
			addCriterion("borrowopenid >=", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidLessThan(String value) {
			addCriterion("borrowopenid <", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidLessThanOrEqualTo(String value) {
			addCriterion("borrowopenid <=", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidLike(String value) {
			addCriterion("borrowopenid like", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidNotLike(String value) {
			addCriterion("borrowopenid not like", value, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidIn(List<String> values) {
			addCriterion("borrowopenid in", values, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidNotIn(List<String> values) {
			addCriterion("borrowopenid not in", values, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidBetween(String value1, String value2) {
			addCriterion("borrowopenid between", value1, value2, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andBorrowopenidNotBetween(String value1, String value2) {
			addCriterion("borrowopenid not between", value1, value2, "borrowopenid");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceIsNull() {
			addCriterion("merchisdiscountprice is null");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceIsNotNull() {
			addCriterion("merchisdiscountprice is not null");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceEqualTo(BigDecimal value) {
			addCriterion("merchisdiscountprice =", value, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceNotEqualTo(BigDecimal value) {
			addCriterion("merchisdiscountprice <>", value, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceGreaterThan(BigDecimal value) {
			addCriterion("merchisdiscountprice >", value, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("merchisdiscountprice >=", value, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceLessThan(BigDecimal value) {
			addCriterion("merchisdiscountprice <", value, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("merchisdiscountprice <=", value, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceIn(List<BigDecimal> values) {
			addCriterion("merchisdiscountprice in", values, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceNotIn(List<BigDecimal> values) {
			addCriterion("merchisdiscountprice not in", values, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("merchisdiscountprice between", value1, value2, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andMerchisdiscountpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("merchisdiscountprice not between", value1, value2, "merchisdiscountprice");
			return (Criteria) this;
		}

		public Criteria andApppayIsNull() {
			addCriterion("apppay is null");
			return (Criteria) this;
		}

		public Criteria andApppayIsNotNull() {
			addCriterion("apppay is not null");
			return (Criteria) this;
		}

		public Criteria andApppayEqualTo(Byte value) {
			addCriterion("apppay =", value, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayNotEqualTo(Byte value) {
			addCriterion("apppay <>", value, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayGreaterThan(Byte value) {
			addCriterion("apppay >", value, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayGreaterThanOrEqualTo(Byte value) {
			addCriterion("apppay >=", value, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayLessThan(Byte value) {
			addCriterion("apppay <", value, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayLessThanOrEqualTo(Byte value) {
			addCriterion("apppay <=", value, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayIn(List<Byte> values) {
			addCriterion("apppay in", values, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayNotIn(List<Byte> values) {
			addCriterion("apppay not in", values, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayBetween(Byte value1, Byte value2) {
			addCriterion("apppay between", value1, value2, "apppay");
			return (Criteria) this;
		}

		public Criteria andApppayNotBetween(Byte value1, Byte value2) {
			addCriterion("apppay not between", value1, value2, "apppay");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceIsNull() {
			addCriterion("coupongoodprice is null");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceIsNotNull() {
			addCriterion("coupongoodprice is not null");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceEqualTo(BigDecimal value) {
			addCriterion("coupongoodprice =", value, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceNotEqualTo(BigDecimal value) {
			addCriterion("coupongoodprice <>", value, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceGreaterThan(BigDecimal value) {
			addCriterion("coupongoodprice >", value, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("coupongoodprice >=", value, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceLessThan(BigDecimal value) {
			addCriterion("coupongoodprice <", value, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("coupongoodprice <=", value, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceIn(List<BigDecimal> values) {
			addCriterion("coupongoodprice in", values, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceNotIn(List<BigDecimal> values) {
			addCriterion("coupongoodprice not in", values, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("coupongoodprice between", value1, value2, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andCoupongoodpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("coupongoodprice not between", value1, value2, "coupongoodprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceIsNull() {
			addCriterion("buyagainprice is null");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceIsNotNull() {
			addCriterion("buyagainprice is not null");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceEqualTo(BigDecimal value) {
			addCriterion("buyagainprice =", value, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceNotEqualTo(BigDecimal value) {
			addCriterion("buyagainprice <>", value, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceGreaterThan(BigDecimal value) {
			addCriterion("buyagainprice >", value, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("buyagainprice >=", value, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceLessThan(BigDecimal value) {
			addCriterion("buyagainprice <", value, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("buyagainprice <=", value, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceIn(List<BigDecimal> values) {
			addCriterion("buyagainprice in", values, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceNotIn(List<BigDecimal> values) {
			addCriterion("buyagainprice not in", values, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buyagainprice between", value1, value2, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andBuyagainpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buyagainprice not between", value1, value2, "buyagainprice");
			return (Criteria) this;
		}

		public Criteria andIspackageIsNull() {
			addCriterion("ispackage is null");
			return (Criteria) this;
		}

		public Criteria andIspackageIsNotNull() {
			addCriterion("ispackage is not null");
			return (Criteria) this;
		}

		public Criteria andIspackageEqualTo(Byte value) {
			addCriterion("ispackage =", value, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageNotEqualTo(Byte value) {
			addCriterion("ispackage <>", value, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageGreaterThan(Byte value) {
			addCriterion("ispackage >", value, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageGreaterThanOrEqualTo(Byte value) {
			addCriterion("ispackage >=", value, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageLessThan(Byte value) {
			addCriterion("ispackage <", value, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageLessThanOrEqualTo(Byte value) {
			addCriterion("ispackage <=", value, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageIn(List<Byte> values) {
			addCriterion("ispackage in", values, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageNotIn(List<Byte> values) {
			addCriterion("ispackage not in", values, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageBetween(Byte value1, Byte value2) {
			addCriterion("ispackage between", value1, value2, "ispackage");
			return (Criteria) this;
		}

		public Criteria andIspackageNotBetween(Byte value1, Byte value2) {
			addCriterion("ispackage not between", value1, value2, "ispackage");
			return (Criteria) this;
		}

		public Criteria andPackageidIsNull() {
			addCriterion("packageid is null");
			return (Criteria) this;
		}

		public Criteria andPackageidIsNotNull() {
			addCriterion("packageid is not null");
			return (Criteria) this;
		}

		public Criteria andPackageidEqualTo(Integer value) {
			addCriterion("packageid =", value, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidNotEqualTo(Integer value) {
			addCriterion("packageid <>", value, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidGreaterThan(Integer value) {
			addCriterion("packageid >", value, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidGreaterThanOrEqualTo(Integer value) {
			addCriterion("packageid >=", value, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidLessThan(Integer value) {
			addCriterion("packageid <", value, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidLessThanOrEqualTo(Integer value) {
			addCriterion("packageid <=", value, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidIn(List<Integer> values) {
			addCriterion("packageid in", values, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidNotIn(List<Integer> values) {
			addCriterion("packageid not in", values, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidBetween(Integer value1, Integer value2) {
			addCriterion("packageid between", value1, value2, "packageid");
			return (Criteria) this;
		}

		public Criteria andPackageidNotBetween(Integer value1, Integer value2) {
			addCriterion("packageid not between", value1, value2, "packageid");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceIsNull() {
			addCriterion("taskdiscountprice is null");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceIsNotNull() {
			addCriterion("taskdiscountprice is not null");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceEqualTo(BigDecimal value) {
			addCriterion("taskdiscountprice =", value, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceNotEqualTo(BigDecimal value) {
			addCriterion("taskdiscountprice <>", value, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceGreaterThan(BigDecimal value) {
			addCriterion("taskdiscountprice >", value, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("taskdiscountprice >=", value, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceLessThan(BigDecimal value) {
			addCriterion("taskdiscountprice <", value, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("taskdiscountprice <=", value, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceIn(List<BigDecimal> values) {
			addCriterion("taskdiscountprice in", values, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceNotIn(List<BigDecimal> values) {
			addCriterion("taskdiscountprice not in", values, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("taskdiscountprice between", value1, value2, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andTaskdiscountpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("taskdiscountprice not between", value1, value2, "taskdiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceIsNull() {
			addCriterion("seckilldiscountprice is null");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceIsNotNull() {
			addCriterion("seckilldiscountprice is not null");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceEqualTo(BigDecimal value) {
			addCriterion("seckilldiscountprice =", value, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceNotEqualTo(BigDecimal value) {
			addCriterion("seckilldiscountprice <>", value, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceGreaterThan(BigDecimal value) {
			addCriterion("seckilldiscountprice >", value, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("seckilldiscountprice >=", value, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceLessThan(BigDecimal value) {
			addCriterion("seckilldiscountprice <", value, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("seckilldiscountprice <=", value, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceIn(List<BigDecimal> values) {
			addCriterion("seckilldiscountprice in", values, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceNotIn(List<BigDecimal> values) {
			addCriterion("seckilldiscountprice not in", values, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("seckilldiscountprice between", value1, value2, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andSeckilldiscountpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("seckilldiscountprice not between", value1, value2, "seckilldiscountprice");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeIsNull() {
			addCriterion("verifyendtime is null");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeIsNotNull() {
			addCriterion("verifyendtime is not null");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeEqualTo(Integer value) {
			addCriterion("verifyendtime =", value, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeNotEqualTo(Integer value) {
			addCriterion("verifyendtime <>", value, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeGreaterThan(Integer value) {
			addCriterion("verifyendtime >", value, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("verifyendtime >=", value, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeLessThan(Integer value) {
			addCriterion("verifyendtime <", value, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeLessThanOrEqualTo(Integer value) {
			addCriterion("verifyendtime <=", value, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeIn(List<Integer> values) {
			addCriterion("verifyendtime in", values, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeNotIn(List<Integer> values) {
			addCriterion("verifyendtime not in", values, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeBetween(Integer value1, Integer value2) {
			addCriterion("verifyendtime between", value1, value2, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andVerifyendtimeNotBetween(Integer value1, Integer value2) {
			addCriterion("verifyendtime not between", value1, value2, "verifyendtime");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageIsNull() {
			addCriterion("willcancelmessage is null");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageIsNotNull() {
			addCriterion("willcancelmessage is not null");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageEqualTo(Boolean value) {
			addCriterion("willcancelmessage =", value, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageNotEqualTo(Boolean value) {
			addCriterion("willcancelmessage <>", value, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageGreaterThan(Boolean value) {
			addCriterion("willcancelmessage >", value, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageGreaterThanOrEqualTo(Boolean value) {
			addCriterion("willcancelmessage >=", value, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageLessThan(Boolean value) {
			addCriterion("willcancelmessage <", value, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageLessThanOrEqualTo(Boolean value) {
			addCriterion("willcancelmessage <=", value, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageIn(List<Boolean> values) {
			addCriterion("willcancelmessage in", values, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageNotIn(List<Boolean> values) {
			addCriterion("willcancelmessage not in", values, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageBetween(Boolean value1, Boolean value2) {
			addCriterion("willcancelmessage between", value1, value2, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andWillcancelmessageNotBetween(Boolean value1, Boolean value2) {
			addCriterion("willcancelmessage not between", value1, value2, "willcancelmessage");
			return (Criteria) this;
		}

		public Criteria andSendtypeIsNull() {
			addCriterion("sendtype is null");
			return (Criteria) this;
		}

		public Criteria andSendtypeIsNotNull() {
			addCriterion("sendtype is not null");
			return (Criteria) this;
		}

		public Criteria andSendtypeEqualTo(Byte value) {
			addCriterion("sendtype =", value, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeNotEqualTo(Byte value) {
			addCriterion("sendtype <>", value, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeGreaterThan(Byte value) {
			addCriterion("sendtype >", value, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("sendtype >=", value, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeLessThan(Byte value) {
			addCriterion("sendtype <", value, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeLessThanOrEqualTo(Byte value) {
			addCriterion("sendtype <=", value, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeIn(List<Byte> values) {
			addCriterion("sendtype in", values, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeNotIn(List<Byte> values) {
			addCriterion("sendtype not in", values, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeBetween(Byte value1, Byte value2) {
			addCriterion("sendtype between", value1, value2, "sendtype");
			return (Criteria) this;
		}

		public Criteria andSendtypeNotBetween(Byte value1, Byte value2) {
			addCriterion("sendtype not between", value1, value2, "sendtype");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(Float value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(Float value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(Float value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(Float value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(Float value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(Float value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<Float> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<Float> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(Float value1, Float value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(Float value1, Float value2) {
			addCriterion("code not between", value1, value2, "code");
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

		public Criteria andOrderTypeIsNull() {
			addCriterion("order_type is null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIsNotNull() {
			addCriterion("order_type is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeEqualTo(Byte value) {
			addCriterion("order_type =", value, "orderType");
			return (Criteria) this;
		}
		
		public Criteria andOrderTypeOr(Byte value,Byte value1) {
			addCriterion("(order_type ="+value+" or order_type ="+value1+")");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotEqualTo(Byte value) {
			addCriterion("order_type <>", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThan(Byte value) {
			addCriterion("order_type >", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("order_type >=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThan(Byte value) {
			addCriterion("order_type <", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThanOrEqualTo(Byte value) {
			addCriterion("order_type <=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIn(List<Byte> values) {
			addCriterion("order_type in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotIn(List<Byte> values) {
			addCriterion("order_type not in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeBetween(Byte value1, Byte value2) {
			addCriterion("order_type between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("order_type not between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andActivityIdIsNull() {
			addCriterion("activity_id is null");
			return (Criteria) this;
		}

		public Criteria andActivityIdIsNotNull() {
			addCriterion("activity_id is not null");
			return (Criteria) this;
		}

		public Criteria andActivityIdEqualTo(Byte value) {
			addCriterion("activity_id =", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdOr(Byte value,Byte value1) {
			addCriterion("(activity_id ="+value+" or activity_id ="+value1+")");
			return (Criteria) this;
		}

		public Criteria andActivityIdNotEqualTo(Byte value) {
			addCriterion("activity_id <>", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdGreaterThan(Byte value) {
			addCriterion("activity_id >", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdGreaterThanOrEqualTo(Byte value) {
			addCriterion("activity_id >=", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdLessThan(Byte value) {
			addCriterion("activity_id <", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdLessThanOrEqualTo(Byte value) {
			addCriterion("activity_id <=", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdIn(List<Byte> values) {
			addCriterion("activity_id in", values, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdNotIn(List<Byte> values) {
			addCriterion("activity_id not in", values, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdBetween(Byte value1, Byte value2) {
			addCriterion("activity_id between", value1, value2, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdNotBetween(Byte value1, Byte value2) {
			addCriterion("activity_id not between", value1, value2, "activityId");
			return (Criteria) this;
		}
		
		public Criteria andIssettlementEqualTo(int i) {
			addCriterion("is_settlement =", i, "is_settlement");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceIsNull() {
			addCriterion("subsidyprice is null");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceIsNotNull() {
			addCriterion("subsidyprice is not null");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceEqualTo(BigDecimal value) {
			addCriterion("subsidyprice =", value, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceNotEqualTo(BigDecimal value) {
			addCriterion("subsidyprice <>", value, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceGreaterThan(BigDecimal value) {
			addCriterion("subsidyprice >", value, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("subsidyprice >=", value, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceLessThan(BigDecimal value) {
			addCriterion("subsidyprice <", value, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("subsidyprice <=", value, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceIn(List<BigDecimal> values) {
			addCriterion("subsidyprice in", values, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceNotIn(List<BigDecimal> values) {
			addCriterion("subsidyprice not in", values, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("subsidyprice between", value1, value2, "subsidyprice");
			return (Criteria) this;
		}

		public Criteria andSubsidypriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("subsidyprice not between", value1, value2, "subsidyprice");
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