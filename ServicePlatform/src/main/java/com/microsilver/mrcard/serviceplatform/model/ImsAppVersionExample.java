package com.microsilver.mrcard.serviceplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ImsAppVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsAppVersionExample() {
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

        public Criteria andAppTypeIsNull() {
            addCriterion("app_Type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_Type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Integer value) {
            addCriterion("app_Type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Integer value) {
            addCriterion("app_Type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Integer value) {
            addCriterion("app_Type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_Type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Integer value) {
            addCriterion("app_Type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Integer value) {
            addCriterion("app_Type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Integer> values) {
            addCriterion("app_Type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Integer> values) {
            addCriterion("app_Type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Integer value1, Integer value2) {
            addCriterion("app_Type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_Type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNull() {
            addCriterion("client_Type is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("client_Type is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(Byte value) {
            addCriterion("client_Type =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotEqualTo(Byte value) {
            addCriterion("client_Type <>", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThan(Byte value) {
            addCriterion("client_Type >", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("client_Type >=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThan(Byte value) {
            addCriterion("client_Type <", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(Byte value) {
            addCriterion("client_Type <=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIn(List<Byte> values) {
            addCriterion("client_Type in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotIn(List<Byte> values) {
            addCriterion("client_Type not in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeBetween(Byte value1, Byte value2) {
            addCriterion("client_Type between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("client_Type not between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andIsForceIsNull() {
            addCriterion("is_Force is null");
            return (Criteria) this;
        }

        public Criteria andIsForceIsNotNull() {
            addCriterion("is_Force is not null");
            return (Criteria) this;
        }

        public Criteria andIsForceEqualTo(Byte value) {
            addCriterion("is_Force =", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceNotEqualTo(Byte value) {
            addCriterion("is_Force <>", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceGreaterThan(Byte value) {
            addCriterion("is_Force >", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_Force >=", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceLessThan(Byte value) {
            addCriterion("is_Force <", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceLessThanOrEqualTo(Byte value) {
            addCriterion("is_Force <=", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceIn(List<Byte> values) {
            addCriterion("is_Force in", values, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceNotIn(List<Byte> values) {
            addCriterion("is_Force not in", values, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceBetween(Byte value1, Byte value2) {
            addCriterion("is_Force between", value1, value2, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_Force not between", value1, value2, "isForce");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDownAddressIsNull() {
            addCriterion("down_Address is null");
            return (Criteria) this;
        }

        public Criteria andDownAddressIsNotNull() {
            addCriterion("down_Address is not null");
            return (Criteria) this;
        }

        public Criteria andDownAddressEqualTo(String value) {
            addCriterion("down_Address =", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressNotEqualTo(String value) {
            addCriterion("down_Address <>", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressGreaterThan(String value) {
            addCriterion("down_Address >", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressGreaterThanOrEqualTo(String value) {
            addCriterion("down_Address >=", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressLessThan(String value) {
            addCriterion("down_Address <", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressLessThanOrEqualTo(String value) {
            addCriterion("down_Address <=", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressLike(String value) {
            addCriterion("down_Address like", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressNotLike(String value) {
            addCriterion("down_Address not like", value, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressIn(List<String> values) {
            addCriterion("down_Address in", values, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressNotIn(List<String> values) {
            addCriterion("down_Address not in", values, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressBetween(String value1, String value2) {
            addCriterion("down_Address between", value1, value2, "downAddress");
            return (Criteria) this;
        }

        public Criteria andDownAddressNotBetween(String value1, String value2) {
            addCriterion("down_Address not between", value1, value2, "downAddress");
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