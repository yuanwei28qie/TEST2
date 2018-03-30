package com.microsilver.mrcard.serviceplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopCategoryExample() {
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

        public Criteria andThumbIsNull() {
            addCriterion("thumb is null");
            return (Criteria) this;
        }

        public Criteria andThumbIsNotNull() {
            addCriterion("thumb is not null");
            return (Criteria) this;
        }

        public Criteria andThumbEqualTo(String value) {
            addCriterion("thumb =", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbNotEqualTo(String value) {
            addCriterion("thumb <>", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbGreaterThan(String value) {
            addCriterion("thumb >", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbGreaterThanOrEqualTo(String value) {
            addCriterion("thumb >=", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbLessThan(String value) {
            addCriterion("thumb <", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbLessThanOrEqualTo(String value) {
            addCriterion("thumb <=", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbLike(String value) {
            addCriterion("thumb like", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbNotLike(String value) {
            addCriterion("thumb not like", value, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbIn(List<String> values) {
            addCriterion("thumb in", values, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbNotIn(List<String> values) {
            addCriterion("thumb not in", values, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbBetween(String value1, String value2) {
            addCriterion("thumb between", value1, value2, "thumb");
            return (Criteria) this;
        }

        public Criteria andThumbNotBetween(String value1, String value2) {
            addCriterion("thumb not between", value1, value2, "thumb");
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

        public Criteria andIsrecommandIsNull() {
            addCriterion("isrecommand is null");
            return (Criteria) this;
        }

        public Criteria andIsrecommandIsNotNull() {
            addCriterion("isrecommand is not null");
            return (Criteria) this;
        }

        public Criteria andIsrecommandEqualTo(Integer value) {
            addCriterion("isrecommand =", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandNotEqualTo(Integer value) {
            addCriterion("isrecommand <>", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandGreaterThan(Integer value) {
            addCriterion("isrecommand >", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandGreaterThanOrEqualTo(Integer value) {
            addCriterion("isrecommand >=", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandLessThan(Integer value) {
            addCriterion("isrecommand <", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandLessThanOrEqualTo(Integer value) {
            addCriterion("isrecommand <=", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandIn(List<Integer> values) {
            addCriterion("isrecommand in", values, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandNotIn(List<Integer> values) {
            addCriterion("isrecommand not in", values, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandBetween(Integer value1, Integer value2) {
            addCriterion("isrecommand between", value1, value2, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandNotBetween(Integer value1, Integer value2) {
            addCriterion("isrecommand not between", value1, value2, "isrecommand");
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

        public Criteria andDisplayorderIsNull() {
            addCriterion("displayorder is null");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIsNotNull() {
            addCriterion("displayorder is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayorderEqualTo(Byte value) {
            addCriterion("displayorder =", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotEqualTo(Byte value) {
            addCriterion("displayorder <>", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThan(Byte value) {
            addCriterion("displayorder >", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("displayorder >=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThan(Byte value) {
            addCriterion("displayorder <", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThanOrEqualTo(Byte value) {
            addCriterion("displayorder <=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIn(List<Byte> values) {
            addCriterion("displayorder in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotIn(List<Byte> values) {
            addCriterion("displayorder not in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderBetween(Byte value1, Byte value2) {
            addCriterion("displayorder between", value1, value2, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotBetween(Byte value1, Byte value2) {
            addCriterion("displayorder not between", value1, value2, "displayorder");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Byte value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Byte value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Byte value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Byte value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Byte> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Byte> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Byte value1, Byte value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andIshomeIsNull() {
            addCriterion("ishome is null");
            return (Criteria) this;
        }

        public Criteria andIshomeIsNotNull() {
            addCriterion("ishome is not null");
            return (Criteria) this;
        }

        public Criteria andIshomeEqualTo(Byte value) {
            addCriterion("ishome =", value, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeNotEqualTo(Byte value) {
            addCriterion("ishome <>", value, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeGreaterThan(Byte value) {
            addCriterion("ishome >", value, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ishome >=", value, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeLessThan(Byte value) {
            addCriterion("ishome <", value, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeLessThanOrEqualTo(Byte value) {
            addCriterion("ishome <=", value, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeIn(List<Byte> values) {
            addCriterion("ishome in", values, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeNotIn(List<Byte> values) {
            addCriterion("ishome not in", values, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeBetween(Byte value1, Byte value2) {
            addCriterion("ishome between", value1, value2, "ishome");
            return (Criteria) this;
        }

        public Criteria andIshomeNotBetween(Byte value1, Byte value2) {
            addCriterion("ishome not between", value1, value2, "ishome");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Byte value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Byte value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Byte value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Byte value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Byte value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Byte> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Byte> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Byte value1, Byte value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andAdvimgIsNull() {
            addCriterion("advimg is null");
            return (Criteria) this;
        }

        public Criteria andAdvimgIsNotNull() {
            addCriterion("advimg is not null");
            return (Criteria) this;
        }

        public Criteria andAdvimgEqualTo(String value) {
            addCriterion("advimg =", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgNotEqualTo(String value) {
            addCriterion("advimg <>", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgGreaterThan(String value) {
            addCriterion("advimg >", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgGreaterThanOrEqualTo(String value) {
            addCriterion("advimg >=", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgLessThan(String value) {
            addCriterion("advimg <", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgLessThanOrEqualTo(String value) {
            addCriterion("advimg <=", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgLike(String value) {
            addCriterion("advimg like", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgNotLike(String value) {
            addCriterion("advimg not like", value, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgIn(List<String> values) {
            addCriterion("advimg in", values, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgNotIn(List<String> values) {
            addCriterion("advimg not in", values, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgBetween(String value1, String value2) {
            addCriterion("advimg between", value1, value2, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvimgNotBetween(String value1, String value2) {
            addCriterion("advimg not between", value1, value2, "advimg");
            return (Criteria) this;
        }

        public Criteria andAdvurlIsNull() {
            addCriterion("advurl is null");
            return (Criteria) this;
        }

        public Criteria andAdvurlIsNotNull() {
            addCriterion("advurl is not null");
            return (Criteria) this;
        }

        public Criteria andAdvurlEqualTo(String value) {
            addCriterion("advurl =", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlNotEqualTo(String value) {
            addCriterion("advurl <>", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlGreaterThan(String value) {
            addCriterion("advurl >", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlGreaterThanOrEqualTo(String value) {
            addCriterion("advurl >=", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlLessThan(String value) {
            addCriterion("advurl <", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlLessThanOrEqualTo(String value) {
            addCriterion("advurl <=", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlLike(String value) {
            addCriterion("advurl like", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlNotLike(String value) {
            addCriterion("advurl not like", value, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlIn(List<String> values) {
            addCriterion("advurl in", values, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlNotIn(List<String> values) {
            addCriterion("advurl not in", values, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlBetween(String value1, String value2) {
            addCriterion("advurl between", value1, value2, "advurl");
            return (Criteria) this;
        }

        public Criteria andAdvurlNotBetween(String value1, String value2) {
            addCriterion("advurl not between", value1, value2, "advurl");
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