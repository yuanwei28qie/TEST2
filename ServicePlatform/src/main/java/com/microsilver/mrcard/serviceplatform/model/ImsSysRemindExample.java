package com.microsilver.mrcard.serviceplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ImsSysRemindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsSysRemindExample() {
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

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(Integer value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(Integer value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(Integer value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(Integer value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(Integer value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(Integer value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<Integer> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<Integer> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(Integer value1, Integer value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(Integer value1, Integer value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(Byte value) {
            addCriterion("object_type =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(Byte value) {
            addCriterion("object_type <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(Byte value) {
            addCriterion("object_type >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("object_type >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(Byte value) {
            addCriterion("object_type <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(Byte value) {
            addCriterion("object_type <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<Byte> values) {
            addCriterion("object_type in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<Byte> values) {
            addCriterion("object_type not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(Byte value1, Byte value2) {
            addCriterion("object_type between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("object_type not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(Long value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(Long value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(Long value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(Long value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<Long> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<Long> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(Long value1, Long value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andRemindWayIsNull() {
            addCriterion("remind_way is null");
            return (Criteria) this;
        }

        public Criteria andRemindWayIsNotNull() {
            addCriterion("remind_way is not null");
            return (Criteria) this;
        }

        public Criteria andRemindWayEqualTo(Byte value) {
            addCriterion("remind_way =", value, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayNotEqualTo(Byte value) {
            addCriterion("remind_way <>", value, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayGreaterThan(Byte value) {
            addCriterion("remind_way >", value, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("remind_way >=", value, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayLessThan(Byte value) {
            addCriterion("remind_way <", value, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayLessThanOrEqualTo(Byte value) {
            addCriterion("remind_way <=", value, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayIn(List<Byte> values) {
            addCriterion("remind_way in", values, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayNotIn(List<Byte> values) {
            addCriterion("remind_way not in", values, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayBetween(Byte value1, Byte value2) {
            addCriterion("remind_way between", value1, value2, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindWayNotBetween(Byte value1, Byte value2) {
            addCriterion("remind_way not between", value1, value2, "remindWay");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNull() {
            addCriterion("remind_time is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNotNull() {
            addCriterion("remind_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeEqualTo(Integer value) {
            addCriterion("remind_time =", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotEqualTo(Integer value) {
            addCriterion("remind_time <>", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThan(Integer value) {
            addCriterion("remind_time >", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("remind_time >=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThan(Integer value) {
            addCriterion("remind_time <", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThanOrEqualTo(Integer value) {
            addCriterion("remind_time <=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIn(List<Integer> values) {
            addCriterion("remind_time in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotIn(List<Integer> values) {
            addCriterion("remind_time not in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeBetween(Integer value1, Integer value2) {
            addCriterion("remind_time between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("remind_time not between", value1, value2, "remindTime");
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