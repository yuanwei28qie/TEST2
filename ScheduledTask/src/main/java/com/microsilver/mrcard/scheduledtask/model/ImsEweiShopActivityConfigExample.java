package com.microsilver.mrcard.scheduledtask.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopActivityConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopActivityConfigExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
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
        
        public Criteria andACMerchIdEqualTo(Long value) {
            addCriterion("ac.merch_id =", value, "merchId");
            return (Criteria) this;
        }
        public Criteria andACMerchIdIn(List<Long> value) {
            addCriterion("ac.merch_id in", value, "merchId");
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Integer value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Integer value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Integer value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Integer value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Integer value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Integer> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Integer> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Integer value1, Integer value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Integer value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Integer value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Integer value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Integer value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Integer> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Integer> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseIsNull() {
            addCriterion("is_auto_release is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseIsNotNull() {
            addCriterion("is_auto_release is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseEqualTo(Boolean value) {
            addCriterion("is_auto_release =", value, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseNotEqualTo(Boolean value) {
            addCriterion("is_auto_release <>", value, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseGreaterThan(Boolean value) {
            addCriterion("is_auto_release >", value, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_auto_release >=", value, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseLessThan(Boolean value) {
            addCriterion("is_auto_release <", value, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseLessThanOrEqualTo(Boolean value) {
            addCriterion("is_auto_release <=", value, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseIn(List<Boolean> values) {
            addCriterion("is_auto_release in", values, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseNotIn(List<Boolean> values) {
            addCriterion("is_auto_release not in", values, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseBetween(Boolean value1, Boolean value2) {
            addCriterion("is_auto_release between", value1, value2, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andIsAutoReleaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_auto_release not between", value1, value2, "isAutoRelease");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIsNull() {
            addCriterion("lowest_price is null");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIsNotNull() {
            addCriterion("lowest_price is not null");
            return (Criteria) this;
        }

        public Criteria andLowestPriceEqualTo(BigDecimal value) {
            addCriterion("lowest_price =", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotEqualTo(BigDecimal value) {
            addCriterion("lowest_price <>", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceGreaterThan(BigDecimal value) {
            addCriterion("lowest_price >", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lowest_price >=", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceLessThan(BigDecimal value) {
            addCriterion("lowest_price <", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lowest_price <=", value, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceIn(List<BigDecimal> values) {
            addCriterion("lowest_price in", values, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotIn(List<BigDecimal> values) {
            addCriterion("lowest_price not in", values, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowest_price between", value1, value2, "lowestPrice");
            return (Criteria) this;
        }

        public Criteria andLowestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowest_price not between", value1, value2, "lowestPrice");
            return (Criteria) this;
        }
        
        public Criteria andAGEndTimeGreaterThan(Integer value) {
            addCriterion("ag.end_time >", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andGoodsStatusEqualTo(byte value) {
            addCriterion(" sg.status =", value, "status");
            return (Criteria) this;
        }
        public Criteria andDeletedEqualTo(byte value) {
            addCriterion(" deleted =", value, "deleted");
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