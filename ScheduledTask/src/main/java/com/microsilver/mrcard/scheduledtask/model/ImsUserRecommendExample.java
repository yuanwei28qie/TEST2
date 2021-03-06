package com.microsilver.mrcard.scheduledtask.model;

import java.util.ArrayList;
import java.util.List;

public class ImsUserRecommendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsUserRecommendExample() {
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
        public Criteria andVipTypeEqualTo(byte value) {
            addCriterion("vip_type =", value, "isVip");
            return (Criteria) this;
        }
        
        public Criteria andIsVipIsNull() {
            addCriterion("is_vip is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("is_vip is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(Boolean value) {
            addCriterion("is_vip =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(Boolean value) {
            addCriterion("is_vip <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(Boolean value) {
            addCriterion("is_vip >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_vip >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(Boolean value) {
            addCriterion("is_vip <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(Boolean value) {
            addCriterion("is_vip <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<Boolean> values) {
            addCriterion("is_vip in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<Boolean> values) {
            addCriterion("is_vip not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(Boolean value1, Boolean value2) {
            addCriterion("is_vip between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_vip not between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdIsNull() {
            addCriterion("level1_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdIsNotNull() {
            addCriterion("level1_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdEqualTo(Long value) {
            addCriterion("level1_parent_id =", value, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdNotEqualTo(Long value) {
            addCriterion("level1_parent_id <>", value, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdGreaterThan(Long value) {
            addCriterion("level1_parent_id >", value, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("level1_parent_id >=", value, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdLessThan(Long value) {
            addCriterion("level1_parent_id <", value, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdLessThanOrEqualTo(Long value) {
            addCriterion("level1_parent_id <=", value, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdIn(List<Long> values) {
            addCriterion("level1_parent_id in", values, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdNotIn(List<Long> values) {
            addCriterion("level1_parent_id not in", values, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdBetween(Long value1, Long value2) {
            addCriterion("level1_parent_id between", value1, value2, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel1ParentIdNotBetween(Long value1, Long value2) {
            addCriterion("level1_parent_id not between", value1, value2, "level1ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdIsNull() {
            addCriterion("level2_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdIsNotNull() {
            addCriterion("level2_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdEqualTo(Long value) {
            addCriterion("level2_parent_id =", value, "level2ParentId");
            return (Criteria) this;
        }
        

        public Criteria andLevel2ParentIdNotEqualTo(Long value) {
            addCriterion("level2_parent_id <>", value, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdGreaterThan(Long value) {
            addCriterion("level2_parent_id >", value, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("level2_parent_id >=", value, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdLessThan(Long value) {
            addCriterion("level2_parent_id <", value, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdLessThanOrEqualTo(Long value) {
            addCriterion("level2_parent_id <=", value, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdIn(List<Long> values) {
            addCriterion("level2_parent_id in", values, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdNotIn(List<Long> values) {
            addCriterion("level2_parent_id not in", values, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdBetween(Long value1, Long value2) {
            addCriterion("level2_parent_id between", value1, value2, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andLevel2ParentIdNotBetween(Long value1, Long value2) {
            addCriterion("level2_parent_id not between", value1, value2, "level2ParentId");
            return (Criteria) this;
        }

        public Criteria andRootdEqualTo(Long value) {
            addCriterion("root_id =", value, "rootId");
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