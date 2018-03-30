package com.microsilver.mrcard.cloud.finance.model;

import java.util.ArrayList;
import java.util.List;

public class MrcardFinanceAgentShareConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MrcardFinanceAgentShareConfigExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNull() {
            addCriterion("key_word is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNotNull() {
            addCriterion("key_word is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordEqualTo(String value) {
            addCriterion("key_word =", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotEqualTo(String value) {
            addCriterion("key_word <>", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThan(String value) {
            addCriterion("key_word >", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThanOrEqualTo(String value) {
            addCriterion("key_word >=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThan(String value) {
            addCriterion("key_word <", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThanOrEqualTo(String value) {
            addCriterion("key_word <=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLike(String value) {
            addCriterion("key_word like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotLike(String value) {
            addCriterion("key_word not like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordIn(List<String> values) {
            addCriterion("key_word in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotIn(List<String> values) {
            addCriterion("key_word not in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordBetween(String value1, String value2) {
            addCriterion("key_word between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotBetween(String value1, String value2) {
            addCriterion("key_word not between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionIsNull() {
            addCriterion("platform_proportion is null");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionIsNotNull() {
            addCriterion("platform_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionEqualTo(Short value) {
            addCriterion("platform_proportion =", value, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionNotEqualTo(Short value) {
            addCriterion("platform_proportion <>", value, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionGreaterThan(Short value) {
            addCriterion("platform_proportion >", value, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("platform_proportion >=", value, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionLessThan(Short value) {
            addCriterion("platform_proportion <", value, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionLessThanOrEqualTo(Short value) {
            addCriterion("platform_proportion <=", value, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionIn(List<Short> values) {
            addCriterion("platform_proportion in", values, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionNotIn(List<Short> values) {
            addCriterion("platform_proportion not in", values, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionBetween(Short value1, Short value2) {
            addCriterion("platform_proportion between", value1, value2, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andPlatformProportionNotBetween(Short value1, Short value2) {
            addCriterion("platform_proportion not between", value1, value2, "platformProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionIsNull() {
            addCriterion("province_proportion is null");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionIsNotNull() {
            addCriterion("province_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionEqualTo(Short value) {
            addCriterion("province_proportion =", value, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionNotEqualTo(Short value) {
            addCriterion("province_proportion <>", value, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionGreaterThan(Short value) {
            addCriterion("province_proportion >", value, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("province_proportion >=", value, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionLessThan(Short value) {
            addCriterion("province_proportion <", value, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionLessThanOrEqualTo(Short value) {
            addCriterion("province_proportion <=", value, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionIn(List<Short> values) {
            addCriterion("province_proportion in", values, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionNotIn(List<Short> values) {
            addCriterion("province_proportion not in", values, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionBetween(Short value1, Short value2) {
            addCriterion("province_proportion between", value1, value2, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andProvinceProportionNotBetween(Short value1, Short value2) {
            addCriterion("province_proportion not between", value1, value2, "provinceProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionIsNull() {
            addCriterion("city_proportion is null");
            return (Criteria) this;
        }

        public Criteria andCityProportionIsNotNull() {
            addCriterion("city_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andCityProportionEqualTo(Short value) {
            addCriterion("city_proportion =", value, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionNotEqualTo(Short value) {
            addCriterion("city_proportion <>", value, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionGreaterThan(Short value) {
            addCriterion("city_proportion >", value, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("city_proportion >=", value, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionLessThan(Short value) {
            addCriterion("city_proportion <", value, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionLessThanOrEqualTo(Short value) {
            addCriterion("city_proportion <=", value, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionIn(List<Short> values) {
            addCriterion("city_proportion in", values, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionNotIn(List<Short> values) {
            addCriterion("city_proportion not in", values, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionBetween(Short value1, Short value2) {
            addCriterion("city_proportion between", value1, value2, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCityProportionNotBetween(Short value1, Short value2) {
            addCriterion("city_proportion not between", value1, value2, "cityProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionIsNull() {
            addCriterion("county_proportion is null");
            return (Criteria) this;
        }

        public Criteria andCountyProportionIsNotNull() {
            addCriterion("county_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andCountyProportionEqualTo(Short value) {
            addCriterion("county_proportion =", value, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionNotEqualTo(Short value) {
            addCriterion("county_proportion <>", value, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionGreaterThan(Short value) {
            addCriterion("county_proportion >", value, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("county_proportion >=", value, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionLessThan(Short value) {
            addCriterion("county_proportion <", value, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionLessThanOrEqualTo(Short value) {
            addCriterion("county_proportion <=", value, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionIn(List<Short> values) {
            addCriterion("county_proportion in", values, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionNotIn(List<Short> values) {
            addCriterion("county_proportion not in", values, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionBetween(Short value1, Short value2) {
            addCriterion("county_proportion between", value1, value2, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andCountyProportionNotBetween(Short value1, Short value2) {
            addCriterion("county_proportion not between", value1, value2, "countyProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionIsNull() {
            addCriterion("warrior_proportion is null");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionIsNotNull() {
            addCriterion("warrior_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionEqualTo(Short value) {
            addCriterion("warrior_proportion =", value, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionNotEqualTo(Short value) {
            addCriterion("warrior_proportion <>", value, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionGreaterThan(Short value) {
            addCriterion("warrior_proportion >", value, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("warrior_proportion >=", value, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionLessThan(Short value) {
            addCriterion("warrior_proportion <", value, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionLessThanOrEqualTo(Short value) {
            addCriterion("warrior_proportion <=", value, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionIn(List<Short> values) {
            addCriterion("warrior_proportion in", values, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionNotIn(List<Short> values) {
            addCriterion("warrior_proportion not in", values, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionBetween(Short value1, Short value2) {
            addCriterion("warrior_proportion between", value1, value2, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andWarriorProportionNotBetween(Short value1, Short value2) {
            addCriterion("warrior_proportion not between", value1, value2, "warriorProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionIsNull() {
            addCriterion("knight_proportion is null");
            return (Criteria) this;
        }

        public Criteria andKnightProportionIsNotNull() {
            addCriterion("knight_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andKnightProportionEqualTo(Short value) {
            addCriterion("knight_proportion =", value, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionNotEqualTo(Short value) {
            addCriterion("knight_proportion <>", value, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionGreaterThan(Short value) {
            addCriterion("knight_proportion >", value, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("knight_proportion >=", value, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionLessThan(Short value) {
            addCriterion("knight_proportion <", value, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionLessThanOrEqualTo(Short value) {
            addCriterion("knight_proportion <=", value, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionIn(List<Short> values) {
            addCriterion("knight_proportion in", values, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionNotIn(List<Short> values) {
            addCriterion("knight_proportion not in", values, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionBetween(Short value1, Short value2) {
            addCriterion("knight_proportion between", value1, value2, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andKnightProportionNotBetween(Short value1, Short value2) {
            addCriterion("knight_proportion not between", value1, value2, "knightProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionIsNull() {
            addCriterion("vip_proportion is null");
            return (Criteria) this;
        }

        public Criteria andVipProportionIsNotNull() {
            addCriterion("vip_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andVipProportionEqualTo(Short value) {
            addCriterion("vip_proportion =", value, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionNotEqualTo(Short value) {
            addCriterion("vip_proportion <>", value, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionGreaterThan(Short value) {
            addCriterion("vip_proportion >", value, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionGreaterThanOrEqualTo(Short value) {
            addCriterion("vip_proportion >=", value, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionLessThan(Short value) {
            addCriterion("vip_proportion <", value, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionLessThanOrEqualTo(Short value) {
            addCriterion("vip_proportion <=", value, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionIn(List<Short> values) {
            addCriterion("vip_proportion in", values, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionNotIn(List<Short> values) {
            addCriterion("vip_proportion not in", values, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionBetween(Short value1, Short value2) {
            addCriterion("vip_proportion between", value1, value2, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andVipProportionNotBetween(Short value1, Short value2) {
            addCriterion("vip_proportion not between", value1, value2, "vipProportion");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNull() {
            addCriterion("agent_type is null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNotNull() {
            addCriterion("agent_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeEqualTo(Byte value) {
            addCriterion("agent_type =", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotEqualTo(Byte value) {
            addCriterion("agent_type <>", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThan(Byte value) {
            addCriterion("agent_type >", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("agent_type >=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThan(Byte value) {
            addCriterion("agent_type <", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThanOrEqualTo(Byte value) {
            addCriterion("agent_type <=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIn(List<Byte> values) {
            addCriterion("agent_type in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotIn(List<Byte> values) {
            addCriterion("agent_type not in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeBetween(Byte value1, Byte value2) {
            addCriterion("agent_type between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("agent_type not between", value1, value2, "agentType");
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