package com.microsilver.mrcard.serviceplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopMemberCollectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopMemberCollectionExample() {
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

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(Byte value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(Byte value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(Byte value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(Byte value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(Byte value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(Byte value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<Byte> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<Byte> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(Byte value1, Byte value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(Byte value1, Byte value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andCollecTypeIsNull() {
            addCriterion("collec_type is null");
            return (Criteria) this;
        }

        public Criteria andCollecTypeIsNotNull() {
            addCriterion("collec_type is not null");
            return (Criteria) this;
        }

        public Criteria andCollecTypeEqualTo(Byte value) {
            addCriterion("collec_type =", value, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeNotEqualTo(Byte value) {
            addCriterion("collec_type <>", value, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeGreaterThan(Byte value) {
            addCriterion("collec_type >", value, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("collec_type >=", value, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeLessThan(Byte value) {
            addCriterion("collec_type <", value, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeLessThanOrEqualTo(Byte value) {
            addCriterion("collec_type <=", value, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeIn(List<Byte> values) {
            addCriterion("collec_type in", values, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeNotIn(List<Byte> values) {
            addCriterion("collec_type not in", values, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeBetween(Byte value1, Byte value2) {
            addCriterion("collec_type between", value1, value2, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("collec_type not between", value1, value2, "collecType");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdIsNull() {
            addCriterion("collec_object_id is null");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdIsNotNull() {
            addCriterion("collec_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdEqualTo(Long value) {
            addCriterion("collec_object_id =", value, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdNotEqualTo(Long value) {
            addCriterion("collec_object_id <>", value, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdGreaterThan(Long value) {
            addCriterion("collec_object_id >", value, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collec_object_id >=", value, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdLessThan(Long value) {
            addCriterion("collec_object_id <", value, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("collec_object_id <=", value, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdIn(List<Long> values) {
            addCriterion("collec_object_id in", values, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdNotIn(List<Long> values) {
            addCriterion("collec_object_id not in", values, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdBetween(Long value1, Long value2) {
            addCriterion("collec_object_id between", value1, value2, "collecObjectId");
            return (Criteria) this;
        }

        public Criteria andCollecObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("collec_object_id not between", value1, value2, "collecObjectId");
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