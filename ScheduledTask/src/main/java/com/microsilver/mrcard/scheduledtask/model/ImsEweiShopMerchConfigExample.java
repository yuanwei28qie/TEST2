package com.microsilver.mrcard.scheduledtask.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopMerchConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopMerchConfigExample() {
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

        public Criteria andMerchIdIsNull() {
            addCriterion("merch_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNotNull() {
            addCriterion("merch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchIdEqualTo(Long value) {
            addCriterion("merch_id =", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotEqualTo(Long value) {
            addCriterion("merch_id <>", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThan(Long value) {
            addCriterion("merch_id >", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("merch_id >=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThan(Long value) {
            addCriterion("merch_id <", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThanOrEqualTo(Long value) {
            addCriterion("merch_id <=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIn(List<Long> values) {
            addCriterion("merch_id in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotIn(List<Long> values) {
            addCriterion("merch_id not in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdBetween(Long value1, Long value2) {
            addCriterion("merch_id between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotBetween(Long value1, Long value2) {
            addCriterion("merch_id not between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionIsNull() {
            addCriterion("cjtj_platform_proportion is null");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionIsNotNull() {
            addCriterion("cjtj_platform_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionEqualTo(BigDecimal value) {
            addCriterion("cjtj_platform_proportion =", value, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionNotEqualTo(BigDecimal value) {
            addCriterion("cjtj_platform_proportion <>", value, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionGreaterThan(BigDecimal value) {
            addCriterion("cjtj_platform_proportion >", value, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cjtj_platform_proportion >=", value, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionLessThan(BigDecimal value) {
            addCriterion("cjtj_platform_proportion <", value, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cjtj_platform_proportion <=", value, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionIn(List<BigDecimal> values) {
            addCriterion("cjtj_platform_proportion in", values, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionNotIn(List<BigDecimal> values) {
            addCriterion("cjtj_platform_proportion not in", values, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cjtj_platform_proportion between", value1, value2, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjPlatformProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cjtj_platform_proportion not between", value1, value2, "cjtjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionIsNull() {
            addCriterion("cjtj_cashback_proportion is null");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionIsNotNull() {
            addCriterion("cjtj_cashback_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionEqualTo(BigDecimal value) {
            addCriterion("cjtj_cashback_proportion =", value, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionNotEqualTo(BigDecimal value) {
            addCriterion("cjtj_cashback_proportion <>", value, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionGreaterThan(BigDecimal value) {
            addCriterion("cjtj_cashback_proportion >", value, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cjtj_cashback_proportion >=", value, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionLessThan(BigDecimal value) {
            addCriterion("cjtj_cashback_proportion <", value, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cjtj_cashback_proportion <=", value, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionIn(List<BigDecimal> values) {
            addCriterion("cjtj_cashback_proportion in", values, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionNotIn(List<BigDecimal> values) {
            addCriterion("cjtj_cashback_proportion not in", values, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cjtj_cashback_proportion between", value1, value2, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andCjtjCashbackProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cjtj_cashback_proportion not between", value1, value2, "cjtjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionIsNull() {
            addCriterion("ldbj_platform_proportion is null");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionIsNotNull() {
            addCriterion("ldbj_platform_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionEqualTo(BigDecimal value) {
            addCriterion("ldbj_platform_proportion =", value, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionNotEqualTo(BigDecimal value) {
            addCriterion("ldbj_platform_proportion <>", value, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionGreaterThan(BigDecimal value) {
            addCriterion("ldbj_platform_proportion >", value, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ldbj_platform_proportion >=", value, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionLessThan(BigDecimal value) {
            addCriterion("ldbj_platform_proportion <", value, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ldbj_platform_proportion <=", value, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionIn(List<BigDecimal> values) {
            addCriterion("ldbj_platform_proportion in", values, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionNotIn(List<BigDecimal> values) {
            addCriterion("ldbj_platform_proportion not in", values, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ldbj_platform_proportion between", value1, value2, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjPlatformProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ldbj_platform_proportion not between", value1, value2, "ldbjPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionIsNull() {
            addCriterion("ldbj_cashback_proportion is null");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionIsNotNull() {
            addCriterion("ldbj_cashback_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionEqualTo(BigDecimal value) {
            addCriterion("ldbj_cashback_proportion =", value, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionNotEqualTo(BigDecimal value) {
            addCriterion("ldbj_cashback_proportion <>", value, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionGreaterThan(BigDecimal value) {
            addCriterion("ldbj_cashback_proportion >", value, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ldbj_cashback_proportion >=", value, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionLessThan(BigDecimal value) {
            addCriterion("ldbj_cashback_proportion <", value, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ldbj_cashback_proportion <=", value, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionIn(List<BigDecimal> values) {
            addCriterion("ldbj_cashback_proportion in", values, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionNotIn(List<BigDecimal> values) {
            addCriterion("ldbj_cashback_proportion not in", values, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ldbj_cashback_proportion between", value1, value2, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andLdbjCashbackProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ldbj_cashback_proportion not between", value1, value2, "ldbjCashbackProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionIsNull() {
            addCriterion("xsd_platform_proportion is null");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionIsNotNull() {
            addCriterion("xsd_platform_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionEqualTo(BigDecimal value) {
            addCriterion("xsd_platform_proportion =", value, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionNotEqualTo(BigDecimal value) {
            addCriterion("xsd_platform_proportion <>", value, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionGreaterThan(BigDecimal value) {
            addCriterion("xsd_platform_proportion >", value, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xsd_platform_proportion >=", value, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionLessThan(BigDecimal value) {
            addCriterion("xsd_platform_proportion <", value, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xsd_platform_proportion <=", value, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionIn(List<BigDecimal> values) {
            addCriterion("xsd_platform_proportion in", values, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionNotIn(List<BigDecimal> values) {
            addCriterion("xsd_platform_proportion not in", values, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsd_platform_proportion between", value1, value2, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdPlatformProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsd_platform_proportion not between", value1, value2, "xsdPlatformProportion");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioIsNull() {
            addCriterion("xsd_cashback_proportio is null");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioIsNotNull() {
            addCriterion("xsd_cashback_proportio is not null");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioEqualTo(BigDecimal value) {
            addCriterion("xsd_cashback_proportio =", value, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioNotEqualTo(BigDecimal value) {
            addCriterion("xsd_cashback_proportio <>", value, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioGreaterThan(BigDecimal value) {
            addCriterion("xsd_cashback_proportio >", value, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xsd_cashback_proportio >=", value, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioLessThan(BigDecimal value) {
            addCriterion("xsd_cashback_proportio <", value, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xsd_cashback_proportio <=", value, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioIn(List<BigDecimal> values) {
            addCriterion("xsd_cashback_proportio in", values, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioNotIn(List<BigDecimal> values) {
            addCriterion("xsd_cashback_proportio not in", values, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsd_cashback_proportio between", value1, value2, "xsdCashbackProportio");
            return (Criteria) this;
        }

        public Criteria andXsdCashbackProportioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xsd_cashback_proportio not between", value1, value2, "xsdCashbackProportio");
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