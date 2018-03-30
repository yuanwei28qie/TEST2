package com.microsilver.mrcard.serviceplatform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopGoodsExample() {
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

        public Criteria andPcateIsNull() {
            addCriterion("pcate is null");
            return (Criteria) this;
        }

        public Criteria andPcateIsNotNull() {
            addCriterion("pcate is not null");
            return (Criteria) this;
        }

        public Criteria andPcateEqualTo(Integer value) {
            addCriterion("pcate =", value, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateNotEqualTo(Integer value) {
            addCriterion("pcate <>", value, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateGreaterThan(Integer value) {
            addCriterion("pcate >", value, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcate >=", value, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateLessThan(Integer value) {
            addCriterion("pcate <", value, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateLessThanOrEqualTo(Integer value) {
            addCriterion("pcate <=", value, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateIn(List<Integer> values) {
            addCriterion("pcate in", values, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateNotIn(List<Integer> values) {
            addCriterion("pcate not in", values, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateBetween(Integer value1, Integer value2) {
            addCriterion("pcate between", value1, value2, "pcate");
            return (Criteria) this;
        }

        public Criteria andPcateNotBetween(Integer value1, Integer value2) {
            addCriterion("pcate not between", value1, value2, "pcate");
            return (Criteria) this;
        }

        public Criteria andCcateIsNull() {
            addCriterion("ccate is null");
            return (Criteria) this;
        }

        public Criteria andCcateIsNotNull() {
            addCriterion("ccate is not null");
            return (Criteria) this;
        }

        public Criteria andCcateEqualTo(Integer value) {
            addCriterion("ccate =", value, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateNotEqualTo(Integer value) {
            addCriterion("ccate <>", value, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateGreaterThan(Integer value) {
            addCriterion("ccate >", value, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ccate >=", value, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateLessThan(Integer value) {
            addCriterion("ccate <", value, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateLessThanOrEqualTo(Integer value) {
            addCriterion("ccate <=", value, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateIn(List<Integer> values) {
            addCriterion("ccate in", values, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateNotIn(List<Integer> values) {
            addCriterion("ccate not in", values, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateBetween(Integer value1, Integer value2) {
            addCriterion("ccate between", value1, value2, "ccate");
            return (Criteria) this;
        }

        public Criteria andCcateNotBetween(Integer value1, Integer value2) {
            addCriterion("ccate not between", value1, value2, "ccate");
            return (Criteria) this;
        }

        public Criteria andTcateIsNull() {
            addCriterion("tcate is null");
            return (Criteria) this;
        }

        public Criteria andTcateIsNotNull() {
            addCriterion("tcate is not null");
            return (Criteria) this;
        }

        public Criteria andTcateEqualTo(Integer value) {
            addCriterion("tcate =", value, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateNotEqualTo(Integer value) {
            addCriterion("tcate <>", value, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateGreaterThan(Integer value) {
            addCriterion("tcate >", value, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateGreaterThanOrEqualTo(Integer value) {
            addCriterion("tcate >=", value, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateLessThan(Integer value) {
            addCriterion("tcate <", value, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateLessThanOrEqualTo(Integer value) {
            addCriterion("tcate <=", value, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateIn(List<Integer> values) {
            addCriterion("tcate in", values, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateNotIn(List<Integer> values) {
            addCriterion("tcate not in", values, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateBetween(Integer value1, Integer value2) {
            addCriterion("tcate between", value1, value2, "tcate");
            return (Criteria) this;
        }

        public Criteria andTcateNotBetween(Integer value1, Integer value2) {
            addCriterion("tcate not between", value1, value2, "tcate");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Boolean value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Boolean value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Boolean value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Boolean value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Boolean> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Boolean> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andDisplayorderEqualTo(Integer value) {
            addCriterion("displayorder =", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotEqualTo(Integer value) {
            addCriterion("displayorder <>", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThan(Integer value) {
            addCriterion("displayorder >", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("displayorder >=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThan(Integer value) {
            addCriterion("displayorder <", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThanOrEqualTo(Integer value) {
            addCriterion("displayorder <=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIn(List<Integer> values) {
            addCriterion("displayorder in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotIn(List<Integer> values) {
            addCriterion("displayorder not in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderBetween(Integer value1, Integer value2) {
            addCriterion("displayorder between", value1, value2, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotBetween(Integer value1, Integer value2) {
            addCriterion("displayorder not between", value1, value2, "displayorder");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andGoodssnIsNull() {
            addCriterion("goodssn is null");
            return (Criteria) this;
        }

        public Criteria andGoodssnIsNotNull() {
            addCriterion("goodssn is not null");
            return (Criteria) this;
        }

        public Criteria andGoodssnEqualTo(String value) {
            addCriterion("goodssn =", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnNotEqualTo(String value) {
            addCriterion("goodssn <>", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnGreaterThan(String value) {
            addCriterion("goodssn >", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnGreaterThanOrEqualTo(String value) {
            addCriterion("goodssn >=", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnLessThan(String value) {
            addCriterion("goodssn <", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnLessThanOrEqualTo(String value) {
            addCriterion("goodssn <=", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnLike(String value) {
            addCriterion("goodssn like", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnNotLike(String value) {
            addCriterion("goodssn not like", value, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnIn(List<String> values) {
            addCriterion("goodssn in", values, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnNotIn(List<String> values) {
            addCriterion("goodssn not in", values, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnBetween(String value1, String value2) {
            addCriterion("goodssn between", value1, value2, "goodssn");
            return (Criteria) this;
        }

        public Criteria andGoodssnNotBetween(String value1, String value2) {
            addCriterion("goodssn not between", value1, value2, "goodssn");
            return (Criteria) this;
        }

        public Criteria andProductsnIsNull() {
            addCriterion("productsn is null");
            return (Criteria) this;
        }

        public Criteria andProductsnIsNotNull() {
            addCriterion("productsn is not null");
            return (Criteria) this;
        }

        public Criteria andProductsnEqualTo(String value) {
            addCriterion("productsn =", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnNotEqualTo(String value) {
            addCriterion("productsn <>", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnGreaterThan(String value) {
            addCriterion("productsn >", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnGreaterThanOrEqualTo(String value) {
            addCriterion("productsn >=", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnLessThan(String value) {
            addCriterion("productsn <", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnLessThanOrEqualTo(String value) {
            addCriterion("productsn <=", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnLike(String value) {
            addCriterion("productsn like", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnNotLike(String value) {
            addCriterion("productsn not like", value, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnIn(List<String> values) {
            addCriterion("productsn in", values, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnNotIn(List<String> values) {
            addCriterion("productsn not in", values, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnBetween(String value1, String value2) {
            addCriterion("productsn between", value1, value2, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductsnNotBetween(String value1, String value2) {
            addCriterion("productsn not between", value1, value2, "productsn");
            return (Criteria) this;
        }

        public Criteria andProductpriceIsNull() {
            addCriterion("productprice is null");
            return (Criteria) this;
        }

        public Criteria andProductpriceIsNotNull() {
            addCriterion("productprice is not null");
            return (Criteria) this;
        }

        public Criteria andProductpriceEqualTo(BigDecimal value) {
            addCriterion("productprice =", value, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceNotEqualTo(BigDecimal value) {
            addCriterion("productprice <>", value, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceGreaterThan(BigDecimal value) {
            addCriterion("productprice >", value, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("productprice >=", value, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceLessThan(BigDecimal value) {
            addCriterion("productprice <", value, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("productprice <=", value, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceIn(List<BigDecimal> values) {
            addCriterion("productprice in", values, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceNotIn(List<BigDecimal> values) {
            addCriterion("productprice not in", values, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("productprice between", value1, value2, "productprice");
            return (Criteria) this;
        }

        public Criteria andProductpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("productprice not between", value1, value2, "productprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceIsNull() {
            addCriterion("marketprice is null");
            return (Criteria) this;
        }

        public Criteria andMarketpriceIsNotNull() {
            addCriterion("marketprice is not null");
            return (Criteria) this;
        }

        public Criteria andMarketpriceEqualTo(BigDecimal value) {
            addCriterion("marketprice =", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceNotEqualTo(BigDecimal value) {
            addCriterion("marketprice <>", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceGreaterThan(BigDecimal value) {
            addCriterion("marketprice >", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("marketprice >=", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceLessThan(BigDecimal value) {
            addCriterion("marketprice <", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("marketprice <=", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceIn(List<BigDecimal> values) {
            addCriterion("marketprice in", values, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceNotIn(List<BigDecimal> values) {
            addCriterion("marketprice not in", values, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketprice between", value1, value2, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketprice not between", value1, value2, "marketprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceIsNull() {
            addCriterion("costprice is null");
            return (Criteria) this;
        }

        public Criteria andCostpriceIsNotNull() {
            addCriterion("costprice is not null");
            return (Criteria) this;
        }

        public Criteria andCostpriceEqualTo(BigDecimal value) {
            addCriterion("costprice =", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotEqualTo(BigDecimal value) {
            addCriterion("costprice <>", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceGreaterThan(BigDecimal value) {
            addCriterion("costprice >", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("costprice >=", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceLessThan(BigDecimal value) {
            addCriterion("costprice <", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("costprice <=", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceIn(List<BigDecimal> values) {
            addCriterion("costprice in", values, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotIn(List<BigDecimal> values) {
            addCriterion("costprice not in", values, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costprice between", value1, value2, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costprice not between", value1, value2, "costprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceIsNull() {
            addCriterion("originalprice is null");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceIsNotNull() {
            addCriterion("originalprice is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceEqualTo(BigDecimal value) {
            addCriterion("originalprice =", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceNotEqualTo(BigDecimal value) {
            addCriterion("originalprice <>", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceGreaterThan(BigDecimal value) {
            addCriterion("originalprice >", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("originalprice >=", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceLessThan(BigDecimal value) {
            addCriterion("originalprice <", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("originalprice <=", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceIn(List<BigDecimal> values) {
            addCriterion("originalprice in", values, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceNotIn(List<BigDecimal> values) {
            addCriterion("originalprice not in", values, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalprice between", value1, value2, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalprice not between", value1, value2, "originalprice");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalcnfIsNull() {
            addCriterion("totalcnf is null");
            return (Criteria) this;
        }

        public Criteria andTotalcnfIsNotNull() {
            addCriterion("totalcnf is not null");
            return (Criteria) this;
        }

        public Criteria andTotalcnfEqualTo(Integer value) {
            addCriterion("totalcnf =", value, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfNotEqualTo(Integer value) {
            addCriterion("totalcnf <>", value, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfGreaterThan(Integer value) {
            addCriterion("totalcnf >", value, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalcnf >=", value, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfLessThan(Integer value) {
            addCriterion("totalcnf <", value, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfLessThanOrEqualTo(Integer value) {
            addCriterion("totalcnf <=", value, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfIn(List<Integer> values) {
            addCriterion("totalcnf in", values, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfNotIn(List<Integer> values) {
            addCriterion("totalcnf not in", values, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfBetween(Integer value1, Integer value2) {
            addCriterion("totalcnf between", value1, value2, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andTotalcnfNotBetween(Integer value1, Integer value2) {
            addCriterion("totalcnf not between", value1, value2, "totalcnf");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(Integer value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(Integer value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(Integer value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(Integer value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(Integer value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<Integer> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<Integer> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(Integer value1, Integer value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesrealIsNull() {
            addCriterion("salesreal is null");
            return (Criteria) this;
        }

        public Criteria andSalesrealIsNotNull() {
            addCriterion("salesreal is not null");
            return (Criteria) this;
        }

        public Criteria andSalesrealEqualTo(Integer value) {
            addCriterion("salesreal =", value, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealNotEqualTo(Integer value) {
            addCriterion("salesreal <>", value, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealGreaterThan(Integer value) {
            addCriterion("salesreal >", value, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealGreaterThanOrEqualTo(Integer value) {
            addCriterion("salesreal >=", value, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealLessThan(Integer value) {
            addCriterion("salesreal <", value, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealLessThanOrEqualTo(Integer value) {
            addCriterion("salesreal <=", value, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealIn(List<Integer> values) {
            addCriterion("salesreal in", values, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealNotIn(List<Integer> values) {
            addCriterion("salesreal not in", values, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealBetween(Integer value1, Integer value2) {
            addCriterion("salesreal between", value1, value2, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSalesrealNotBetween(Integer value1, Integer value2) {
            addCriterion("salesreal not between", value1, value2, "salesreal");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
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

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(String value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(String value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(String value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(String value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(String value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(String value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLike(String value) {
            addCriterion("credit like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotLike(String value) {
            addCriterion("credit not like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<String> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<String> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(String value1, String value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(String value1, String value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andMaxbuyIsNull() {
            addCriterion("maxbuy is null");
            return (Criteria) this;
        }

        public Criteria andMaxbuyIsNotNull() {
            addCriterion("maxbuy is not null");
            return (Criteria) this;
        }

        public Criteria andMaxbuyEqualTo(Integer value) {
            addCriterion("maxbuy =", value, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyNotEqualTo(Integer value) {
            addCriterion("maxbuy <>", value, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyGreaterThan(Integer value) {
            addCriterion("maxbuy >", value, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxbuy >=", value, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyLessThan(Integer value) {
            addCriterion("maxbuy <", value, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyLessThanOrEqualTo(Integer value) {
            addCriterion("maxbuy <=", value, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyIn(List<Integer> values) {
            addCriterion("maxbuy in", values, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyNotIn(List<Integer> values) {
            addCriterion("maxbuy not in", values, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyBetween(Integer value1, Integer value2) {
            addCriterion("maxbuy between", value1, value2, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andMaxbuyNotBetween(Integer value1, Integer value2) {
            addCriterion("maxbuy not between", value1, value2, "maxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyIsNull() {
            addCriterion("usermaxbuy is null");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyIsNotNull() {
            addCriterion("usermaxbuy is not null");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyEqualTo(Integer value) {
            addCriterion("usermaxbuy =", value, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyNotEqualTo(Integer value) {
            addCriterion("usermaxbuy <>", value, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyGreaterThan(Integer value) {
            addCriterion("usermaxbuy >", value, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("usermaxbuy >=", value, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyLessThan(Integer value) {
            addCriterion("usermaxbuy <", value, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyLessThanOrEqualTo(Integer value) {
            addCriterion("usermaxbuy <=", value, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyIn(List<Integer> values) {
            addCriterion("usermaxbuy in", values, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyNotIn(List<Integer> values) {
            addCriterion("usermaxbuy not in", values, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyBetween(Integer value1, Integer value2) {
            addCriterion("usermaxbuy between", value1, value2, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andUsermaxbuyNotBetween(Integer value1, Integer value2) {
            addCriterion("usermaxbuy not between", value1, value2, "usermaxbuy");
            return (Criteria) this;
        }

        public Criteria andHasoptionIsNull() {
            addCriterion("hasoption is null");
            return (Criteria) this;
        }

        public Criteria andHasoptionIsNotNull() {
            addCriterion("hasoption is not null");
            return (Criteria) this;
        }

        public Criteria andHasoptionEqualTo(Integer value) {
            addCriterion("hasoption =", value, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionNotEqualTo(Integer value) {
            addCriterion("hasoption <>", value, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionGreaterThan(Integer value) {
            addCriterion("hasoption >", value, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionGreaterThanOrEqualTo(Integer value) {
            addCriterion("hasoption >=", value, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionLessThan(Integer value) {
            addCriterion("hasoption <", value, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionLessThanOrEqualTo(Integer value) {
            addCriterion("hasoption <=", value, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionIn(List<Integer> values) {
            addCriterion("hasoption in", values, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionNotIn(List<Integer> values) {
            addCriterion("hasoption not in", values, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionBetween(Integer value1, Integer value2) {
            addCriterion("hasoption between", value1, value2, "hasoption");
            return (Criteria) this;
        }

        public Criteria andHasoptionNotBetween(Integer value1, Integer value2) {
            addCriterion("hasoption not between", value1, value2, "hasoption");
            return (Criteria) this;
        }

        public Criteria andDispatchIsNull() {
            addCriterion("dispatch is null");
            return (Criteria) this;
        }

        public Criteria andDispatchIsNotNull() {
            addCriterion("dispatch is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchEqualTo(Integer value) {
            addCriterion("dispatch =", value, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchNotEqualTo(Integer value) {
            addCriterion("dispatch <>", value, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchGreaterThan(Integer value) {
            addCriterion("dispatch >", value, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispatch >=", value, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchLessThan(Integer value) {
            addCriterion("dispatch <", value, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchLessThanOrEqualTo(Integer value) {
            addCriterion("dispatch <=", value, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchIn(List<Integer> values) {
            addCriterion("dispatch in", values, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchNotIn(List<Integer> values) {
            addCriterion("dispatch not in", values, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchBetween(Integer value1, Integer value2) {
            addCriterion("dispatch between", value1, value2, "dispatch");
            return (Criteria) this;
        }

        public Criteria andDispatchNotBetween(Integer value1, Integer value2) {
            addCriterion("dispatch not between", value1, value2, "dispatch");
            return (Criteria) this;
        }

        public Criteria andIsnewIsNull() {
            addCriterion("isnew is null");
            return (Criteria) this;
        }

        public Criteria andIsnewIsNotNull() {
            addCriterion("isnew is not null");
            return (Criteria) this;
        }

        public Criteria andIsnewEqualTo(Boolean value) {
            addCriterion("isnew =", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewNotEqualTo(Boolean value) {
            addCriterion("isnew <>", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewGreaterThan(Boolean value) {
            addCriterion("isnew >", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isnew >=", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewLessThan(Boolean value) {
            addCriterion("isnew <", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewLessThanOrEqualTo(Boolean value) {
            addCriterion("isnew <=", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewIn(List<Boolean> values) {
            addCriterion("isnew in", values, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewNotIn(List<Boolean> values) {
            addCriterion("isnew not in", values, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewBetween(Boolean value1, Boolean value2) {
            addCriterion("isnew between", value1, value2, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isnew not between", value1, value2, "isnew");
            return (Criteria) this;
        }

        public Criteria andIshotIsNull() {
            addCriterion("ishot is null");
            return (Criteria) this;
        }

        public Criteria andIshotIsNotNull() {
            addCriterion("ishot is not null");
            return (Criteria) this;
        }

        public Criteria andIshotEqualTo(Boolean value) {
            addCriterion("ishot =", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotNotEqualTo(Boolean value) {
            addCriterion("ishot <>", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotGreaterThan(Boolean value) {
            addCriterion("ishot >", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ishot >=", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotLessThan(Boolean value) {
            addCriterion("ishot <", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotLessThanOrEqualTo(Boolean value) {
            addCriterion("ishot <=", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotIn(List<Boolean> values) {
            addCriterion("ishot in", values, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotNotIn(List<Boolean> values) {
            addCriterion("ishot not in", values, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotBetween(Boolean value1, Boolean value2) {
            addCriterion("ishot between", value1, value2, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ishot not between", value1, value2, "ishot");
            return (Criteria) this;
        }

        public Criteria andIsdiscountIsNull() {
            addCriterion("isdiscount is null");
            return (Criteria) this;
        }

        public Criteria andIsdiscountIsNotNull() {
            addCriterion("isdiscount is not null");
            return (Criteria) this;
        }

        public Criteria andIsdiscountEqualTo(Boolean value) {
            addCriterion("isdiscount =", value, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountNotEqualTo(Boolean value) {
            addCriterion("isdiscount <>", value, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountGreaterThan(Boolean value) {
            addCriterion("isdiscount >", value, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdiscount >=", value, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountLessThan(Boolean value) {
            addCriterion("isdiscount <", value, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountLessThanOrEqualTo(Boolean value) {
            addCriterion("isdiscount <=", value, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountIn(List<Boolean> values) {
            addCriterion("isdiscount in", values, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountNotIn(List<Boolean> values) {
            addCriterion("isdiscount not in", values, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountBetween(Boolean value1, Boolean value2) {
            addCriterion("isdiscount between", value1, value2, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdiscount not between", value1, value2, "isdiscount");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleIsNull() {
            addCriterion("isdiscount_title is null");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleIsNotNull() {
            addCriterion("isdiscount_title is not null");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleEqualTo(String value) {
            addCriterion("isdiscount_title =", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleNotEqualTo(String value) {
            addCriterion("isdiscount_title <>", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleGreaterThan(String value) {
            addCriterion("isdiscount_title >", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleGreaterThanOrEqualTo(String value) {
            addCriterion("isdiscount_title >=", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleLessThan(String value) {
            addCriterion("isdiscount_title <", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleLessThanOrEqualTo(String value) {
            addCriterion("isdiscount_title <=", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleLike(String value) {
            addCriterion("isdiscount_title like", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleNotLike(String value) {
            addCriterion("isdiscount_title not like", value, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleIn(List<String> values) {
            addCriterion("isdiscount_title in", values, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleNotIn(List<String> values) {
            addCriterion("isdiscount_title not in", values, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleBetween(String value1, String value2) {
            addCriterion("isdiscount_title between", value1, value2, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTitleNotBetween(String value1, String value2) {
            addCriterion("isdiscount_title not between", value1, value2, "isdiscountTitle");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeIsNull() {
            addCriterion("isdiscount_time is null");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeIsNotNull() {
            addCriterion("isdiscount_time is not null");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeEqualTo(Integer value) {
            addCriterion("isdiscount_time =", value, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeNotEqualTo(Integer value) {
            addCriterion("isdiscount_time <>", value, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeGreaterThan(Integer value) {
            addCriterion("isdiscount_time >", value, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdiscount_time >=", value, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeLessThan(Integer value) {
            addCriterion("isdiscount_time <", value, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeLessThanOrEqualTo(Integer value) {
            addCriterion("isdiscount_time <=", value, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeIn(List<Integer> values) {
            addCriterion("isdiscount_time in", values, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeNotIn(List<Integer> values) {
            addCriterion("isdiscount_time not in", values, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeBetween(Integer value1, Integer value2) {
            addCriterion("isdiscount_time between", value1, value2, "isdiscountTime");
            return (Criteria) this;
        }

        public Criteria andIsdiscountTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("isdiscount_time not between", value1, value2, "isdiscountTime");
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

        public Criteria andIsrecommandEqualTo(Boolean value) {
            addCriterion("isrecommand =", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandNotEqualTo(Boolean value) {
            addCriterion("isrecommand <>", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandGreaterThan(Boolean value) {
            addCriterion("isrecommand >", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isrecommand >=", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandLessThan(Boolean value) {
            addCriterion("isrecommand <", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandLessThanOrEqualTo(Boolean value) {
            addCriterion("isrecommand <=", value, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandIn(List<Boolean> values) {
            addCriterion("isrecommand in", values, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandNotIn(List<Boolean> values) {
            addCriterion("isrecommand not in", values, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandBetween(Boolean value1, Boolean value2) {
            addCriterion("isrecommand between", value1, value2, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIsrecommandNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isrecommand not between", value1, value2, "isrecommand");
            return (Criteria) this;
        }

        public Criteria andIssendfreeIsNull() {
            addCriterion("issendfree is null");
            return (Criteria) this;
        }

        public Criteria andIssendfreeIsNotNull() {
            addCriterion("issendfree is not null");
            return (Criteria) this;
        }

        public Criteria andIssendfreeEqualTo(Boolean value) {
            addCriterion("issendfree =", value, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeNotEqualTo(Boolean value) {
            addCriterion("issendfree <>", value, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeGreaterThan(Boolean value) {
            addCriterion("issendfree >", value, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("issendfree >=", value, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeLessThan(Boolean value) {
            addCriterion("issendfree <", value, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeLessThanOrEqualTo(Boolean value) {
            addCriterion("issendfree <=", value, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeIn(List<Boolean> values) {
            addCriterion("issendfree in", values, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeNotIn(List<Boolean> values) {
            addCriterion("issendfree not in", values, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeBetween(Boolean value1, Boolean value2) {
            addCriterion("issendfree between", value1, value2, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIssendfreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("issendfree not between", value1, value2, "issendfree");
            return (Criteria) this;
        }

        public Criteria andIstimeIsNull() {
            addCriterion("istime is null");
            return (Criteria) this;
        }

        public Criteria andIstimeIsNotNull() {
            addCriterion("istime is not null");
            return (Criteria) this;
        }

        public Criteria andIstimeEqualTo(Boolean value) {
            addCriterion("istime =", value, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeNotEqualTo(Boolean value) {
            addCriterion("istime <>", value, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeGreaterThan(Boolean value) {
            addCriterion("istime >", value, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("istime >=", value, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeLessThan(Boolean value) {
            addCriterion("istime <", value, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeLessThanOrEqualTo(Boolean value) {
            addCriterion("istime <=", value, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeIn(List<Boolean> values) {
            addCriterion("istime in", values, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeNotIn(List<Boolean> values) {
            addCriterion("istime not in", values, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeBetween(Boolean value1, Boolean value2) {
            addCriterion("istime between", value1, value2, "istime");
            return (Criteria) this;
        }

        public Criteria andIstimeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("istime not between", value1, value2, "istime");
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

        public Criteria andIscommentEqualTo(Boolean value) {
            addCriterion("iscomment =", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotEqualTo(Boolean value) {
            addCriterion("iscomment <>", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThan(Boolean value) {
            addCriterion("iscomment >", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("iscomment >=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThan(Boolean value) {
            addCriterion("iscomment <", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThanOrEqualTo(Boolean value) {
            addCriterion("iscomment <=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentIn(List<Boolean> values) {
            addCriterion("iscomment in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotIn(List<Boolean> values) {
            addCriterion("iscomment not in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentBetween(Boolean value1, Boolean value2) {
            addCriterion("iscomment between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("iscomment not between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andTimestartIsNull() {
            addCriterion("timestart is null");
            return (Criteria) this;
        }

        public Criteria andTimestartIsNotNull() {
            addCriterion("timestart is not null");
            return (Criteria) this;
        }

        public Criteria andTimestartEqualTo(Integer value) {
            addCriterion("timestart =", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotEqualTo(Integer value) {
            addCriterion("timestart <>", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartGreaterThan(Integer value) {
            addCriterion("timestart >", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartGreaterThanOrEqualTo(Integer value) {
            addCriterion("timestart >=", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLessThan(Integer value) {
            addCriterion("timestart <", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLessThanOrEqualTo(Integer value) {
            addCriterion("timestart <=", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartIn(List<Integer> values) {
            addCriterion("timestart in", values, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotIn(List<Integer> values) {
            addCriterion("timestart not in", values, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartBetween(Integer value1, Integer value2) {
            addCriterion("timestart between", value1, value2, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotBetween(Integer value1, Integer value2) {
            addCriterion("timestart not between", value1, value2, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimeendIsNull() {
            addCriterion("timeend is null");
            return (Criteria) this;
        }

        public Criteria andTimeendIsNotNull() {
            addCriterion("timeend is not null");
            return (Criteria) this;
        }

        public Criteria andTimeendEqualTo(Integer value) {
            addCriterion("timeend =", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotEqualTo(Integer value) {
            addCriterion("timeend <>", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendGreaterThan(Integer value) {
            addCriterion("timeend >", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeend >=", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLessThan(Integer value) {
            addCriterion("timeend <", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLessThanOrEqualTo(Integer value) {
            addCriterion("timeend <=", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendIn(List<Integer> values) {
            addCriterion("timeend in", values, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotIn(List<Integer> values) {
            addCriterion("timeend not in", values, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendBetween(Integer value1, Integer value2) {
            addCriterion("timeend between", value1, value2, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotBetween(Integer value1, Integer value2) {
            addCriterion("timeend not between", value1, value2, "timeend");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNull() {
            addCriterion("viewcount is null");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNotNull() {
            addCriterion("viewcount is not null");
            return (Criteria) this;
        }

        public Criteria andViewcountEqualTo(Integer value) {
            addCriterion("viewcount =", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotEqualTo(Integer value) {
            addCriterion("viewcount <>", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThan(Integer value) {
            addCriterion("viewcount >", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("viewcount >=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThan(Integer value) {
            addCriterion("viewcount <", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThanOrEqualTo(Integer value) {
            addCriterion("viewcount <=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountIn(List<Integer> values) {
            addCriterion("viewcount in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotIn(List<Integer> values) {
            addCriterion("viewcount not in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountBetween(Integer value1, Integer value2) {
            addCriterion("viewcount between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotBetween(Integer value1, Integer value2) {
            addCriterion("viewcount not between", value1, value2, "viewcount");
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

        public Criteria andHascommissionIsNull() {
            addCriterion("hascommission is null");
            return (Criteria) this;
        }

        public Criteria andHascommissionIsNotNull() {
            addCriterion("hascommission is not null");
            return (Criteria) this;
        }

        public Criteria andHascommissionEqualTo(Byte value) {
            addCriterion("hascommission =", value, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionNotEqualTo(Byte value) {
            addCriterion("hascommission <>", value, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionGreaterThan(Byte value) {
            addCriterion("hascommission >", value, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionGreaterThanOrEqualTo(Byte value) {
            addCriterion("hascommission >=", value, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionLessThan(Byte value) {
            addCriterion("hascommission <", value, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionLessThanOrEqualTo(Byte value) {
            addCriterion("hascommission <=", value, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionIn(List<Byte> values) {
            addCriterion("hascommission in", values, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionNotIn(List<Byte> values) {
            addCriterion("hascommission not in", values, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionBetween(Byte value1, Byte value2) {
            addCriterion("hascommission between", value1, value2, "hascommission");
            return (Criteria) this;
        }

        public Criteria andHascommissionNotBetween(Byte value1, Byte value2) {
            addCriterion("hascommission not between", value1, value2, "hascommission");
            return (Criteria) this;
        }

        public Criteria andCommission1RateIsNull() {
            addCriterion("commission1_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommission1RateIsNotNull() {
            addCriterion("commission1_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommission1RateEqualTo(BigDecimal value) {
            addCriterion("commission1_rate =", value, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateNotEqualTo(BigDecimal value) {
            addCriterion("commission1_rate <>", value, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateGreaterThan(BigDecimal value) {
            addCriterion("commission1_rate >", value, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission1_rate >=", value, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateLessThan(BigDecimal value) {
            addCriterion("commission1_rate <", value, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission1_rate <=", value, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateIn(List<BigDecimal> values) {
            addCriterion("commission1_rate in", values, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateNotIn(List<BigDecimal> values) {
            addCriterion("commission1_rate not in", values, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission1_rate between", value1, value2, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1RateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission1_rate not between", value1, value2, "commission1Rate");
            return (Criteria) this;
        }

        public Criteria andCommission1PayIsNull() {
            addCriterion("commission1_pay is null");
            return (Criteria) this;
        }

        public Criteria andCommission1PayIsNotNull() {
            addCriterion("commission1_pay is not null");
            return (Criteria) this;
        }

        public Criteria andCommission1PayEqualTo(BigDecimal value) {
            addCriterion("commission1_pay =", value, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayNotEqualTo(BigDecimal value) {
            addCriterion("commission1_pay <>", value, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayGreaterThan(BigDecimal value) {
            addCriterion("commission1_pay >", value, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission1_pay >=", value, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayLessThan(BigDecimal value) {
            addCriterion("commission1_pay <", value, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission1_pay <=", value, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayIn(List<BigDecimal> values) {
            addCriterion("commission1_pay in", values, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayNotIn(List<BigDecimal> values) {
            addCriterion("commission1_pay not in", values, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission1_pay between", value1, value2, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission1PayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission1_pay not between", value1, value2, "commission1Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2RateIsNull() {
            addCriterion("commission2_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommission2RateIsNotNull() {
            addCriterion("commission2_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommission2RateEqualTo(BigDecimal value) {
            addCriterion("commission2_rate =", value, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateNotEqualTo(BigDecimal value) {
            addCriterion("commission2_rate <>", value, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateGreaterThan(BigDecimal value) {
            addCriterion("commission2_rate >", value, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission2_rate >=", value, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateLessThan(BigDecimal value) {
            addCriterion("commission2_rate <", value, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission2_rate <=", value, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateIn(List<BigDecimal> values) {
            addCriterion("commission2_rate in", values, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateNotIn(List<BigDecimal> values) {
            addCriterion("commission2_rate not in", values, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission2_rate between", value1, value2, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2RateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission2_rate not between", value1, value2, "commission2Rate");
            return (Criteria) this;
        }

        public Criteria andCommission2PayIsNull() {
            addCriterion("commission2_pay is null");
            return (Criteria) this;
        }

        public Criteria andCommission2PayIsNotNull() {
            addCriterion("commission2_pay is not null");
            return (Criteria) this;
        }

        public Criteria andCommission2PayEqualTo(BigDecimal value) {
            addCriterion("commission2_pay =", value, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayNotEqualTo(BigDecimal value) {
            addCriterion("commission2_pay <>", value, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayGreaterThan(BigDecimal value) {
            addCriterion("commission2_pay >", value, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission2_pay >=", value, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayLessThan(BigDecimal value) {
            addCriterion("commission2_pay <", value, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission2_pay <=", value, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayIn(List<BigDecimal> values) {
            addCriterion("commission2_pay in", values, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayNotIn(List<BigDecimal> values) {
            addCriterion("commission2_pay not in", values, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission2_pay between", value1, value2, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission2PayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission2_pay not between", value1, value2, "commission2Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3RateIsNull() {
            addCriterion("commission3_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommission3RateIsNotNull() {
            addCriterion("commission3_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommission3RateEqualTo(BigDecimal value) {
            addCriterion("commission3_rate =", value, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateNotEqualTo(BigDecimal value) {
            addCriterion("commission3_rate <>", value, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateGreaterThan(BigDecimal value) {
            addCriterion("commission3_rate >", value, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission3_rate >=", value, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateLessThan(BigDecimal value) {
            addCriterion("commission3_rate <", value, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission3_rate <=", value, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateIn(List<BigDecimal> values) {
            addCriterion("commission3_rate in", values, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateNotIn(List<BigDecimal> values) {
            addCriterion("commission3_rate not in", values, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission3_rate between", value1, value2, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3RateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission3_rate not between", value1, value2, "commission3Rate");
            return (Criteria) this;
        }

        public Criteria andCommission3PayIsNull() {
            addCriterion("commission3_pay is null");
            return (Criteria) this;
        }

        public Criteria andCommission3PayIsNotNull() {
            addCriterion("commission3_pay is not null");
            return (Criteria) this;
        }

        public Criteria andCommission3PayEqualTo(BigDecimal value) {
            addCriterion("commission3_pay =", value, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayNotEqualTo(BigDecimal value) {
            addCriterion("commission3_pay <>", value, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayGreaterThan(BigDecimal value) {
            addCriterion("commission3_pay >", value, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission3_pay >=", value, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayLessThan(BigDecimal value) {
            addCriterion("commission3_pay <", value, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission3_pay <=", value, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayIn(List<BigDecimal> values) {
            addCriterion("commission3_pay in", values, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayNotIn(List<BigDecimal> values) {
            addCriterion("commission3_pay not in", values, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission3_pay between", value1, value2, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andCommission3PayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission3_pay not between", value1, value2, "commission3Pay");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andTaobaoidIsNull() {
            addCriterion("taobaoid is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoidIsNotNull() {
            addCriterion("taobaoid is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoidEqualTo(String value) {
            addCriterion("taobaoid =", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidNotEqualTo(String value) {
            addCriterion("taobaoid <>", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidGreaterThan(String value) {
            addCriterion("taobaoid >", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidGreaterThanOrEqualTo(String value) {
            addCriterion("taobaoid >=", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidLessThan(String value) {
            addCriterion("taobaoid <", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidLessThanOrEqualTo(String value) {
            addCriterion("taobaoid <=", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidLike(String value) {
            addCriterion("taobaoid like", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidNotLike(String value) {
            addCriterion("taobaoid not like", value, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidIn(List<String> values) {
            addCriterion("taobaoid in", values, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidNotIn(List<String> values) {
            addCriterion("taobaoid not in", values, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidBetween(String value1, String value2) {
            addCriterion("taobaoid between", value1, value2, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaoidNotBetween(String value1, String value2) {
            addCriterion("taobaoid not between", value1, value2, "taobaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidIsNull() {
            addCriterion("taotaoid is null");
            return (Criteria) this;
        }

        public Criteria andTaotaoidIsNotNull() {
            addCriterion("taotaoid is not null");
            return (Criteria) this;
        }

        public Criteria andTaotaoidEqualTo(String value) {
            addCriterion("taotaoid =", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidNotEqualTo(String value) {
            addCriterion("taotaoid <>", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidGreaterThan(String value) {
            addCriterion("taotaoid >", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidGreaterThanOrEqualTo(String value) {
            addCriterion("taotaoid >=", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidLessThan(String value) {
            addCriterion("taotaoid <", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidLessThanOrEqualTo(String value) {
            addCriterion("taotaoid <=", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidLike(String value) {
            addCriterion("taotaoid like", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidNotLike(String value) {
            addCriterion("taotaoid not like", value, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidIn(List<String> values) {
            addCriterion("taotaoid in", values, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidNotIn(List<String> values) {
            addCriterion("taotaoid not in", values, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidBetween(String value1, String value2) {
            addCriterion("taotaoid between", value1, value2, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaotaoidNotBetween(String value1, String value2) {
            addCriterion("taotaoid not between", value1, value2, "taotaoid");
            return (Criteria) this;
        }

        public Criteria andTaobaourlIsNull() {
            addCriterion("taobaourl is null");
            return (Criteria) this;
        }

        public Criteria andTaobaourlIsNotNull() {
            addCriterion("taobaourl is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaourlEqualTo(String value) {
            addCriterion("taobaourl =", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlNotEqualTo(String value) {
            addCriterion("taobaourl <>", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlGreaterThan(String value) {
            addCriterion("taobaourl >", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlGreaterThanOrEqualTo(String value) {
            addCriterion("taobaourl >=", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlLessThan(String value) {
            addCriterion("taobaourl <", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlLessThanOrEqualTo(String value) {
            addCriterion("taobaourl <=", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlLike(String value) {
            addCriterion("taobaourl like", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlNotLike(String value) {
            addCriterion("taobaourl not like", value, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlIn(List<String> values) {
            addCriterion("taobaourl in", values, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlNotIn(List<String> values) {
            addCriterion("taobaourl not in", values, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlBetween(String value1, String value2) {
            addCriterion("taobaourl between", value1, value2, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andTaobaourlNotBetween(String value1, String value2) {
            addCriterion("taobaourl not between", value1, value2, "taobaourl");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Integer value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Integer value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Integer value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Integer value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Integer> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Integer> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Integer value1, Integer value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNull() {
            addCriterion("share_title is null");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNotNull() {
            addCriterion("share_title is not null");
            return (Criteria) this;
        }

        public Criteria andShareTitleEqualTo(String value) {
            addCriterion("share_title =", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotEqualTo(String value) {
            addCriterion("share_title <>", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThan(String value) {
            addCriterion("share_title >", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("share_title >=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThan(String value) {
            addCriterion("share_title <", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThanOrEqualTo(String value) {
            addCriterion("share_title <=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLike(String value) {
            addCriterion("share_title like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotLike(String value) {
            addCriterion("share_title not like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleIn(List<String> values) {
            addCriterion("share_title in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotIn(List<String> values) {
            addCriterion("share_title not in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleBetween(String value1, String value2) {
            addCriterion("share_title between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotBetween(String value1, String value2) {
            addCriterion("share_title not between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareIconIsNull() {
            addCriterion("share_icon is null");
            return (Criteria) this;
        }

        public Criteria andShareIconIsNotNull() {
            addCriterion("share_icon is not null");
            return (Criteria) this;
        }

        public Criteria andShareIconEqualTo(String value) {
            addCriterion("share_icon =", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconNotEqualTo(String value) {
            addCriterion("share_icon <>", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconGreaterThan(String value) {
            addCriterion("share_icon >", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconGreaterThanOrEqualTo(String value) {
            addCriterion("share_icon >=", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconLessThan(String value) {
            addCriterion("share_icon <", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconLessThanOrEqualTo(String value) {
            addCriterion("share_icon <=", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconLike(String value) {
            addCriterion("share_icon like", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconNotLike(String value) {
            addCriterion("share_icon not like", value, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconIn(List<String> values) {
            addCriterion("share_icon in", values, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconNotIn(List<String> values) {
            addCriterion("share_icon not in", values, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconBetween(String value1, String value2) {
            addCriterion("share_icon between", value1, value2, "shareIcon");
            return (Criteria) this;
        }

        public Criteria andShareIconNotBetween(String value1, String value2) {
            addCriterion("share_icon not between", value1, value2, "shareIcon");
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

        public Criteria andCommissionThumbIsNull() {
            addCriterion("commission_thumb is null");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbIsNotNull() {
            addCriterion("commission_thumb is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbEqualTo(String value) {
            addCriterion("commission_thumb =", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbNotEqualTo(String value) {
            addCriterion("commission_thumb <>", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbGreaterThan(String value) {
            addCriterion("commission_thumb >", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbGreaterThanOrEqualTo(String value) {
            addCriterion("commission_thumb >=", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbLessThan(String value) {
            addCriterion("commission_thumb <", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbLessThanOrEqualTo(String value) {
            addCriterion("commission_thumb <=", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbLike(String value) {
            addCriterion("commission_thumb like", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbNotLike(String value) {
            addCriterion("commission_thumb not like", value, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbIn(List<String> values) {
            addCriterion("commission_thumb in", values, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbNotIn(List<String> values) {
            addCriterion("commission_thumb not in", values, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbBetween(String value1, String value2) {
            addCriterion("commission_thumb between", value1, value2, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andCommissionThumbNotBetween(String value1, String value2) {
            addCriterion("commission_thumb not between", value1, value2, "commissionThumb");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountIsNull() {
            addCriterion("isnodiscount is null");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountIsNotNull() {
            addCriterion("isnodiscount is not null");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountEqualTo(Byte value) {
            addCriterion("isnodiscount =", value, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountNotEqualTo(Byte value) {
            addCriterion("isnodiscount <>", value, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountGreaterThan(Byte value) {
            addCriterion("isnodiscount >", value, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountGreaterThanOrEqualTo(Byte value) {
            addCriterion("isnodiscount >=", value, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountLessThan(Byte value) {
            addCriterion("isnodiscount <", value, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountLessThanOrEqualTo(Byte value) {
            addCriterion("isnodiscount <=", value, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountIn(List<Byte> values) {
            addCriterion("isnodiscount in", values, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountNotIn(List<Byte> values) {
            addCriterion("isnodiscount not in", values, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountBetween(Byte value1, Byte value2) {
            addCriterion("isnodiscount between", value1, value2, "isnodiscount");
            return (Criteria) this;
        }

        public Criteria andIsnodiscountNotBetween(Byte value1, Byte value2) {
            addCriterion("isnodiscount not between", value1, value2, "isnodiscount");
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

        public Criteria andNoticeopenidIsNull() {
            addCriterion("noticeopenid is null");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidIsNotNull() {
            addCriterion("noticeopenid is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidEqualTo(String value) {
            addCriterion("noticeopenid =", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidNotEqualTo(String value) {
            addCriterion("noticeopenid <>", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidGreaterThan(String value) {
            addCriterion("noticeopenid >", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidGreaterThanOrEqualTo(String value) {
            addCriterion("noticeopenid >=", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidLessThan(String value) {
            addCriterion("noticeopenid <", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidLessThanOrEqualTo(String value) {
            addCriterion("noticeopenid <=", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidLike(String value) {
            addCriterion("noticeopenid like", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidNotLike(String value) {
            addCriterion("noticeopenid not like", value, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidIn(List<String> values) {
            addCriterion("noticeopenid in", values, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidNotIn(List<String> values) {
            addCriterion("noticeopenid not in", values, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidBetween(String value1, String value2) {
            addCriterion("noticeopenid between", value1, value2, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNoticeopenidNotBetween(String value1, String value2) {
            addCriterion("noticeopenid not between", value1, value2, "noticeopenid");
            return (Criteria) this;
        }

        public Criteria andNeedfollowIsNull() {
            addCriterion("needfollow is null");
            return (Criteria) this;
        }

        public Criteria andNeedfollowIsNotNull() {
            addCriterion("needfollow is not null");
            return (Criteria) this;
        }

        public Criteria andNeedfollowEqualTo(Byte value) {
            addCriterion("needfollow =", value, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowNotEqualTo(Byte value) {
            addCriterion("needfollow <>", value, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowGreaterThan(Byte value) {
            addCriterion("needfollow >", value, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowGreaterThanOrEqualTo(Byte value) {
            addCriterion("needfollow >=", value, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowLessThan(Byte value) {
            addCriterion("needfollow <", value, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowLessThanOrEqualTo(Byte value) {
            addCriterion("needfollow <=", value, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowIn(List<Byte> values) {
            addCriterion("needfollow in", values, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowNotIn(List<Byte> values) {
            addCriterion("needfollow not in", values, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowBetween(Byte value1, Byte value2) {
            addCriterion("needfollow between", value1, value2, "needfollow");
            return (Criteria) this;
        }

        public Criteria andNeedfollowNotBetween(Byte value1, Byte value2) {
            addCriterion("needfollow not between", value1, value2, "needfollow");
            return (Criteria) this;
        }

        public Criteria andFollowurlIsNull() {
            addCriterion("followurl is null");
            return (Criteria) this;
        }

        public Criteria andFollowurlIsNotNull() {
            addCriterion("followurl is not null");
            return (Criteria) this;
        }

        public Criteria andFollowurlEqualTo(String value) {
            addCriterion("followurl =", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlNotEqualTo(String value) {
            addCriterion("followurl <>", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlGreaterThan(String value) {
            addCriterion("followurl >", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlGreaterThanOrEqualTo(String value) {
            addCriterion("followurl >=", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlLessThan(String value) {
            addCriterion("followurl <", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlLessThanOrEqualTo(String value) {
            addCriterion("followurl <=", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlLike(String value) {
            addCriterion("followurl like", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlNotLike(String value) {
            addCriterion("followurl not like", value, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlIn(List<String> values) {
            addCriterion("followurl in", values, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlNotIn(List<String> values) {
            addCriterion("followurl not in", values, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlBetween(String value1, String value2) {
            addCriterion("followurl between", value1, value2, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowurlNotBetween(String value1, String value2) {
            addCriterion("followurl not between", value1, value2, "followurl");
            return (Criteria) this;
        }

        public Criteria andFollowtipIsNull() {
            addCriterion("followtip is null");
            return (Criteria) this;
        }

        public Criteria andFollowtipIsNotNull() {
            addCriterion("followtip is not null");
            return (Criteria) this;
        }

        public Criteria andFollowtipEqualTo(String value) {
            addCriterion("followtip =", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipNotEqualTo(String value) {
            addCriterion("followtip <>", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipGreaterThan(String value) {
            addCriterion("followtip >", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipGreaterThanOrEqualTo(String value) {
            addCriterion("followtip >=", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipLessThan(String value) {
            addCriterion("followtip <", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipLessThanOrEqualTo(String value) {
            addCriterion("followtip <=", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipLike(String value) {
            addCriterion("followtip like", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipNotLike(String value) {
            addCriterion("followtip not like", value, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipIn(List<String> values) {
            addCriterion("followtip in", values, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipNotIn(List<String> values) {
            addCriterion("followtip not in", values, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipBetween(String value1, String value2) {
            addCriterion("followtip between", value1, value2, "followtip");
            return (Criteria) this;
        }

        public Criteria andFollowtipNotBetween(String value1, String value2) {
            addCriterion("followtip not between", value1, value2, "followtip");
            return (Criteria) this;
        }

        public Criteria andDeductIsNull() {
            addCriterion("deduct is null");
            return (Criteria) this;
        }

        public Criteria andDeductIsNotNull() {
            addCriterion("deduct is not null");
            return (Criteria) this;
        }

        public Criteria andDeductEqualTo(BigDecimal value) {
            addCriterion("deduct =", value, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductNotEqualTo(BigDecimal value) {
            addCriterion("deduct <>", value, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductGreaterThan(BigDecimal value) {
            addCriterion("deduct >", value, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct >=", value, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductLessThan(BigDecimal value) {
            addCriterion("deduct <", value, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct <=", value, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductIn(List<BigDecimal> values) {
            addCriterion("deduct in", values, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductNotIn(List<BigDecimal> values) {
            addCriterion("deduct not in", values, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct between", value1, value2, "deduct");
            return (Criteria) this;
        }

        public Criteria andDeductNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct not between", value1, value2, "deduct");
            return (Criteria) this;
        }

        public Criteria andShorttitleIsNull() {
            addCriterion("shorttitle is null");
            return (Criteria) this;
        }

        public Criteria andShorttitleIsNotNull() {
            addCriterion("shorttitle is not null");
            return (Criteria) this;
        }

        public Criteria andShorttitleEqualTo(String value) {
            addCriterion("shorttitle =", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleNotEqualTo(String value) {
            addCriterion("shorttitle <>", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleGreaterThan(String value) {
            addCriterion("shorttitle >", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleGreaterThanOrEqualTo(String value) {
            addCriterion("shorttitle >=", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleLessThan(String value) {
            addCriterion("shorttitle <", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleLessThanOrEqualTo(String value) {
            addCriterion("shorttitle <=", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleLike(String value) {
            addCriterion("shorttitle like", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleNotLike(String value) {
            addCriterion("shorttitle not like", value, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleIn(List<String> values) {
            addCriterion("shorttitle in", values, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleNotIn(List<String> values) {
            addCriterion("shorttitle not in", values, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleBetween(String value1, String value2) {
            addCriterion("shorttitle between", value1, value2, "shorttitle");
            return (Criteria) this;
        }

        public Criteria andShorttitleNotBetween(String value1, String value2) {
            addCriterion("shorttitle not between", value1, value2, "shorttitle");
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

        public Criteria andNocommissionIsNull() {
            addCriterion("nocommission is null");
            return (Criteria) this;
        }

        public Criteria andNocommissionIsNotNull() {
            addCriterion("nocommission is not null");
            return (Criteria) this;
        }

        public Criteria andNocommissionEqualTo(Byte value) {
            addCriterion("nocommission =", value, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionNotEqualTo(Byte value) {
            addCriterion("nocommission <>", value, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionGreaterThan(Byte value) {
            addCriterion("nocommission >", value, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionGreaterThanOrEqualTo(Byte value) {
            addCriterion("nocommission >=", value, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionLessThan(Byte value) {
            addCriterion("nocommission <", value, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionLessThanOrEqualTo(Byte value) {
            addCriterion("nocommission <=", value, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionIn(List<Byte> values) {
            addCriterion("nocommission in", values, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionNotIn(List<Byte> values) {
            addCriterion("nocommission not in", values, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionBetween(Byte value1, Byte value2) {
            addCriterion("nocommission between", value1, value2, "nocommission");
            return (Criteria) this;
        }

        public Criteria andNocommissionNotBetween(Byte value1, Byte value2) {
            addCriterion("nocommission not between", value1, value2, "nocommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionIsNull() {
            addCriterion("hidecommission is null");
            return (Criteria) this;
        }

        public Criteria andHidecommissionIsNotNull() {
            addCriterion("hidecommission is not null");
            return (Criteria) this;
        }

        public Criteria andHidecommissionEqualTo(Byte value) {
            addCriterion("hidecommission =", value, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionNotEqualTo(Byte value) {
            addCriterion("hidecommission <>", value, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionGreaterThan(Byte value) {
            addCriterion("hidecommission >", value, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionGreaterThanOrEqualTo(Byte value) {
            addCriterion("hidecommission >=", value, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionLessThan(Byte value) {
            addCriterion("hidecommission <", value, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionLessThanOrEqualTo(Byte value) {
            addCriterion("hidecommission <=", value, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionIn(List<Byte> values) {
            addCriterion("hidecommission in", values, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionNotIn(List<Byte> values) {
            addCriterion("hidecommission not in", values, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionBetween(Byte value1, Byte value2) {
            addCriterion("hidecommission between", value1, value2, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andHidecommissionNotBetween(Byte value1, Byte value2) {
            addCriterion("hidecommission not between", value1, value2, "hidecommission");
            return (Criteria) this;
        }

        public Criteria andDetailLogoIsNull() {
            addCriterion("detail_logo is null");
            return (Criteria) this;
        }

        public Criteria andDetailLogoIsNotNull() {
            addCriterion("detail_logo is not null");
            return (Criteria) this;
        }

        public Criteria andDetailLogoEqualTo(String value) {
            addCriterion("detail_logo =", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoNotEqualTo(String value) {
            addCriterion("detail_logo <>", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoGreaterThan(String value) {
            addCriterion("detail_logo >", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_logo >=", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoLessThan(String value) {
            addCriterion("detail_logo <", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoLessThanOrEqualTo(String value) {
            addCriterion("detail_logo <=", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoLike(String value) {
            addCriterion("detail_logo like", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoNotLike(String value) {
            addCriterion("detail_logo not like", value, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoIn(List<String> values) {
            addCriterion("detail_logo in", values, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoNotIn(List<String> values) {
            addCriterion("detail_logo not in", values, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoBetween(String value1, String value2) {
            addCriterion("detail_logo between", value1, value2, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailLogoNotBetween(String value1, String value2) {
            addCriterion("detail_logo not between", value1, value2, "detailLogo");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameIsNull() {
            addCriterion("detail_shopname is null");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameIsNotNull() {
            addCriterion("detail_shopname is not null");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameEqualTo(String value) {
            addCriterion("detail_shopname =", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameNotEqualTo(String value) {
            addCriterion("detail_shopname <>", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameGreaterThan(String value) {
            addCriterion("detail_shopname >", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameGreaterThanOrEqualTo(String value) {
            addCriterion("detail_shopname >=", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameLessThan(String value) {
            addCriterion("detail_shopname <", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameLessThanOrEqualTo(String value) {
            addCriterion("detail_shopname <=", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameLike(String value) {
            addCriterion("detail_shopname like", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameNotLike(String value) {
            addCriterion("detail_shopname not like", value, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameIn(List<String> values) {
            addCriterion("detail_shopname in", values, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameNotIn(List<String> values) {
            addCriterion("detail_shopname not in", values, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameBetween(String value1, String value2) {
            addCriterion("detail_shopname between", value1, value2, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailShopnameNotBetween(String value1, String value2) {
            addCriterion("detail_shopname not between", value1, value2, "detailShopname");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleIsNull() {
            addCriterion("detail_totaltitle is null");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleIsNotNull() {
            addCriterion("detail_totaltitle is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleEqualTo(String value) {
            addCriterion("detail_totaltitle =", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleNotEqualTo(String value) {
            addCriterion("detail_totaltitle <>", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleGreaterThan(String value) {
            addCriterion("detail_totaltitle >", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleGreaterThanOrEqualTo(String value) {
            addCriterion("detail_totaltitle >=", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleLessThan(String value) {
            addCriterion("detail_totaltitle <", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleLessThanOrEqualTo(String value) {
            addCriterion("detail_totaltitle <=", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleLike(String value) {
            addCriterion("detail_totaltitle like", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleNotLike(String value) {
            addCriterion("detail_totaltitle not like", value, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleIn(List<String> values) {
            addCriterion("detail_totaltitle in", values, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleNotIn(List<String> values) {
            addCriterion("detail_totaltitle not in", values, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleBetween(String value1, String value2) {
            addCriterion("detail_totaltitle between", value1, value2, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailTotaltitleNotBetween(String value1, String value2) {
            addCriterion("detail_totaltitle not between", value1, value2, "detailTotaltitle");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1IsNull() {
            addCriterion("detail_btntext1 is null");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1IsNotNull() {
            addCriterion("detail_btntext1 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1EqualTo(String value) {
            addCriterion("detail_btntext1 =", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1NotEqualTo(String value) {
            addCriterion("detail_btntext1 <>", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1GreaterThan(String value) {
            addCriterion("detail_btntext1 >", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1GreaterThanOrEqualTo(String value) {
            addCriterion("detail_btntext1 >=", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1LessThan(String value) {
            addCriterion("detail_btntext1 <", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1LessThanOrEqualTo(String value) {
            addCriterion("detail_btntext1 <=", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1Like(String value) {
            addCriterion("detail_btntext1 like", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1NotLike(String value) {
            addCriterion("detail_btntext1 not like", value, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1In(List<String> values) {
            addCriterion("detail_btntext1 in", values, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1NotIn(List<String> values) {
            addCriterion("detail_btntext1 not in", values, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1Between(String value1, String value2) {
            addCriterion("detail_btntext1 between", value1, value2, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext1NotBetween(String value1, String value2) {
            addCriterion("detail_btntext1 not between", value1, value2, "detailBtntext1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1IsNull() {
            addCriterion("detail_btnurl1 is null");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1IsNotNull() {
            addCriterion("detail_btnurl1 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1EqualTo(String value) {
            addCriterion("detail_btnurl1 =", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1NotEqualTo(String value) {
            addCriterion("detail_btnurl1 <>", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1GreaterThan(String value) {
            addCriterion("detail_btnurl1 >", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1GreaterThanOrEqualTo(String value) {
            addCriterion("detail_btnurl1 >=", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1LessThan(String value) {
            addCriterion("detail_btnurl1 <", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1LessThanOrEqualTo(String value) {
            addCriterion("detail_btnurl1 <=", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1Like(String value) {
            addCriterion("detail_btnurl1 like", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1NotLike(String value) {
            addCriterion("detail_btnurl1 not like", value, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1In(List<String> values) {
            addCriterion("detail_btnurl1 in", values, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1NotIn(List<String> values) {
            addCriterion("detail_btnurl1 not in", values, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1Between(String value1, String value2) {
            addCriterion("detail_btnurl1 between", value1, value2, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl1NotBetween(String value1, String value2) {
            addCriterion("detail_btnurl1 not between", value1, value2, "detailBtnurl1");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2IsNull() {
            addCriterion("detail_btntext2 is null");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2IsNotNull() {
            addCriterion("detail_btntext2 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2EqualTo(String value) {
            addCriterion("detail_btntext2 =", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2NotEqualTo(String value) {
            addCriterion("detail_btntext2 <>", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2GreaterThan(String value) {
            addCriterion("detail_btntext2 >", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2GreaterThanOrEqualTo(String value) {
            addCriterion("detail_btntext2 >=", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2LessThan(String value) {
            addCriterion("detail_btntext2 <", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2LessThanOrEqualTo(String value) {
            addCriterion("detail_btntext2 <=", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2Like(String value) {
            addCriterion("detail_btntext2 like", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2NotLike(String value) {
            addCriterion("detail_btntext2 not like", value, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2In(List<String> values) {
            addCriterion("detail_btntext2 in", values, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2NotIn(List<String> values) {
            addCriterion("detail_btntext2 not in", values, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2Between(String value1, String value2) {
            addCriterion("detail_btntext2 between", value1, value2, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtntext2NotBetween(String value1, String value2) {
            addCriterion("detail_btntext2 not between", value1, value2, "detailBtntext2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2IsNull() {
            addCriterion("detail_btnurl2 is null");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2IsNotNull() {
            addCriterion("detail_btnurl2 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2EqualTo(String value) {
            addCriterion("detail_btnurl2 =", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2NotEqualTo(String value) {
            addCriterion("detail_btnurl2 <>", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2GreaterThan(String value) {
            addCriterion("detail_btnurl2 >", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2GreaterThanOrEqualTo(String value) {
            addCriterion("detail_btnurl2 >=", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2LessThan(String value) {
            addCriterion("detail_btnurl2 <", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2LessThanOrEqualTo(String value) {
            addCriterion("detail_btnurl2 <=", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2Like(String value) {
            addCriterion("detail_btnurl2 like", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2NotLike(String value) {
            addCriterion("detail_btnurl2 not like", value, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2In(List<String> values) {
            addCriterion("detail_btnurl2 in", values, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2NotIn(List<String> values) {
            addCriterion("detail_btnurl2 not in", values, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2Between(String value1, String value2) {
            addCriterion("detail_btnurl2 between", value1, value2, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andDetailBtnurl2NotBetween(String value1, String value2) {
            addCriterion("detail_btnurl2 not between", value1, value2, "detailBtnurl2");
            return (Criteria) this;
        }

        public Criteria andArtidIsNull() {
            addCriterion("artid is null");
            return (Criteria) this;
        }

        public Criteria andArtidIsNotNull() {
            addCriterion("artid is not null");
            return (Criteria) this;
        }

        public Criteria andArtidEqualTo(Integer value) {
            addCriterion("artid =", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidNotEqualTo(Integer value) {
            addCriterion("artid <>", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidGreaterThan(Integer value) {
            addCriterion("artid >", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("artid >=", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidLessThan(Integer value) {
            addCriterion("artid <", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidLessThanOrEqualTo(Integer value) {
            addCriterion("artid <=", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidIn(List<Integer> values) {
            addCriterion("artid in", values, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidNotIn(List<Integer> values) {
            addCriterion("artid not in", values, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidBetween(Integer value1, Integer value2) {
            addCriterion("artid between", value1, value2, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidNotBetween(Integer value1, Integer value2) {
            addCriterion("artid not between", value1, value2, "artid");
            return (Criteria) this;
        }

        public Criteria andDeduct2IsNull() {
            addCriterion("deduct2 is null");
            return (Criteria) this;
        }

        public Criteria andDeduct2IsNotNull() {
            addCriterion("deduct2 is not null");
            return (Criteria) this;
        }

        public Criteria andDeduct2EqualTo(BigDecimal value) {
            addCriterion("deduct2 =", value, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2NotEqualTo(BigDecimal value) {
            addCriterion("deduct2 <>", value, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2GreaterThan(BigDecimal value) {
            addCriterion("deduct2 >", value, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct2 >=", value, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2LessThan(BigDecimal value) {
            addCriterion("deduct2 <", value, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct2 <=", value, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2In(List<BigDecimal> values) {
            addCriterion("deduct2 in", values, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2NotIn(List<BigDecimal> values) {
            addCriterion("deduct2 not in", values, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct2 between", value1, value2, "deduct2");
            return (Criteria) this;
        }

        public Criteria andDeduct2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct2 not between", value1, value2, "deduct2");
            return (Criteria) this;
        }

        public Criteria andEdnumIsNull() {
            addCriterion("ednum is null");
            return (Criteria) this;
        }

        public Criteria andEdnumIsNotNull() {
            addCriterion("ednum is not null");
            return (Criteria) this;
        }

        public Criteria andEdnumEqualTo(Integer value) {
            addCriterion("ednum =", value, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumNotEqualTo(Integer value) {
            addCriterion("ednum <>", value, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumGreaterThan(Integer value) {
            addCriterion("ednum >", value, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ednum >=", value, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumLessThan(Integer value) {
            addCriterion("ednum <", value, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumLessThanOrEqualTo(Integer value) {
            addCriterion("ednum <=", value, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumIn(List<Integer> values) {
            addCriterion("ednum in", values, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumNotIn(List<Integer> values) {
            addCriterion("ednum not in", values, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumBetween(Integer value1, Integer value2) {
            addCriterion("ednum between", value1, value2, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdnumNotBetween(Integer value1, Integer value2) {
            addCriterion("ednum not between", value1, value2, "ednum");
            return (Criteria) this;
        }

        public Criteria andEdmoneyIsNull() {
            addCriterion("edmoney is null");
            return (Criteria) this;
        }

        public Criteria andEdmoneyIsNotNull() {
            addCriterion("edmoney is not null");
            return (Criteria) this;
        }

        public Criteria andEdmoneyEqualTo(BigDecimal value) {
            addCriterion("edmoney =", value, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyNotEqualTo(BigDecimal value) {
            addCriterion("edmoney <>", value, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyGreaterThan(BigDecimal value) {
            addCriterion("edmoney >", value, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("edmoney >=", value, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyLessThan(BigDecimal value) {
            addCriterion("edmoney <", value, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("edmoney <=", value, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyIn(List<BigDecimal> values) {
            addCriterion("edmoney in", values, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyNotIn(List<BigDecimal> values) {
            addCriterion("edmoney not in", values, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("edmoney between", value1, value2, "edmoney");
            return (Criteria) this;
        }

        public Criteria andEdmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("edmoney not between", value1, value2, "edmoney");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeIsNull() {
            addCriterion("diyformtype is null");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeIsNotNull() {
            addCriterion("diyformtype is not null");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeEqualTo(Boolean value) {
            addCriterion("diyformtype =", value, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeNotEqualTo(Boolean value) {
            addCriterion("diyformtype <>", value, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeGreaterThan(Boolean value) {
            addCriterion("diyformtype >", value, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("diyformtype >=", value, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeLessThan(Boolean value) {
            addCriterion("diyformtype <", value, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeLessThanOrEqualTo(Boolean value) {
            addCriterion("diyformtype <=", value, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeIn(List<Boolean> values) {
            addCriterion("diyformtype in", values, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeNotIn(List<Boolean> values) {
            addCriterion("diyformtype not in", values, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeBetween(Boolean value1, Boolean value2) {
            addCriterion("diyformtype between", value1, value2, "diyformtype");
            return (Criteria) this;
        }

        public Criteria andDiyformtypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("diyformtype not between", value1, value2, "diyformtype");
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

        public Criteria andDiymodeIsNull() {
            addCriterion("diymode is null");
            return (Criteria) this;
        }

        public Criteria andDiymodeIsNotNull() {
            addCriterion("diymode is not null");
            return (Criteria) this;
        }

        public Criteria andDiymodeEqualTo(Boolean value) {
            addCriterion("diymode =", value, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeNotEqualTo(Boolean value) {
            addCriterion("diymode <>", value, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeGreaterThan(Boolean value) {
            addCriterion("diymode >", value, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("diymode >=", value, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeLessThan(Boolean value) {
            addCriterion("diymode <", value, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeLessThanOrEqualTo(Boolean value) {
            addCriterion("diymode <=", value, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeIn(List<Boolean> values) {
            addCriterion("diymode in", values, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeNotIn(List<Boolean> values) {
            addCriterion("diymode not in", values, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeBetween(Boolean value1, Boolean value2) {
            addCriterion("diymode between", value1, value2, "diymode");
            return (Criteria) this;
        }

        public Criteria andDiymodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("diymode not between", value1, value2, "diymode");
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

        public Criteria andDispatchtypeEqualTo(Boolean value) {
            addCriterion("dispatchtype =", value, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeNotEqualTo(Boolean value) {
            addCriterion("dispatchtype <>", value, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeGreaterThan(Boolean value) {
            addCriterion("dispatchtype >", value, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dispatchtype >=", value, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeLessThan(Boolean value) {
            addCriterion("dispatchtype <", value, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeLessThanOrEqualTo(Boolean value) {
            addCriterion("dispatchtype <=", value, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeIn(List<Boolean> values) {
            addCriterion("dispatchtype in", values, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeNotIn(List<Boolean> values) {
            addCriterion("dispatchtype not in", values, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeBetween(Boolean value1, Boolean value2) {
            addCriterion("dispatchtype between", value1, value2, "dispatchtype");
            return (Criteria) this;
        }

        public Criteria andDispatchtypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dispatchtype not between", value1, value2, "dispatchtype");
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

        public Criteria andManydeductIsNull() {
            addCriterion("manydeduct is null");
            return (Criteria) this;
        }

        public Criteria andManydeductIsNotNull() {
            addCriterion("manydeduct is not null");
            return (Criteria) this;
        }

        public Criteria andManydeductEqualTo(Boolean value) {
            addCriterion("manydeduct =", value, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductNotEqualTo(Boolean value) {
            addCriterion("manydeduct <>", value, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductGreaterThan(Boolean value) {
            addCriterion("manydeduct >", value, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductGreaterThanOrEqualTo(Boolean value) {
            addCriterion("manydeduct >=", value, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductLessThan(Boolean value) {
            addCriterion("manydeduct <", value, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductLessThanOrEqualTo(Boolean value) {
            addCriterion("manydeduct <=", value, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductIn(List<Boolean> values) {
            addCriterion("manydeduct in", values, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductNotIn(List<Boolean> values) {
            addCriterion("manydeduct not in", values, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductBetween(Boolean value1, Boolean value2) {
            addCriterion("manydeduct between", value1, value2, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andManydeductNotBetween(Boolean value1, Boolean value2) {
            addCriterion("manydeduct not between", value1, value2, "manydeduct");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975IsNull() {
            addCriterion("saleupdate37975 is null");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975IsNotNull() {
            addCriterion("saleupdate37975 is not null");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975EqualTo(Byte value) {
            addCriterion("saleupdate37975 =", value, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975NotEqualTo(Byte value) {
            addCriterion("saleupdate37975 <>", value, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975GreaterThan(Byte value) {
            addCriterion("saleupdate37975 >", value, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975GreaterThanOrEqualTo(Byte value) {
            addCriterion("saleupdate37975 >=", value, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975LessThan(Byte value) {
            addCriterion("saleupdate37975 <", value, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975LessThanOrEqualTo(Byte value) {
            addCriterion("saleupdate37975 <=", value, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975In(List<Byte> values) {
            addCriterion("saleupdate37975 in", values, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975NotIn(List<Byte> values) {
            addCriterion("saleupdate37975 not in", values, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975Between(Byte value1, Byte value2) {
            addCriterion("saleupdate37975 between", value1, value2, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andSaleupdate37975NotBetween(Byte value1, Byte value2) {
            addCriterion("saleupdate37975 not between", value1, value2, "saleupdate37975");
            return (Criteria) this;
        }

        public Criteria andShopidIsNull() {
            addCriterion("shopid is null");
            return (Criteria) this;
        }

        public Criteria andShopidIsNotNull() {
            addCriterion("shopid is not null");
            return (Criteria) this;
        }

        public Criteria andShopidEqualTo(Integer value) {
            addCriterion("shopid =", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotEqualTo(Integer value) {
            addCriterion("shopid <>", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThan(Integer value) {
            addCriterion("shopid >", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopid >=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThan(Integer value) {
            addCriterion("shopid <", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThanOrEqualTo(Integer value) {
            addCriterion("shopid <=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidIn(List<Integer> values) {
            addCriterion("shopid in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotIn(List<Integer> values) {
            addCriterion("shopid not in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidBetween(Integer value1, Integer value2) {
            addCriterion("shopid between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotBetween(Integer value1, Integer value2) {
            addCriterion("shopid not between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andMinbuyIsNull() {
            addCriterion("minbuy is null");
            return (Criteria) this;
        }

        public Criteria andMinbuyIsNotNull() {
            addCriterion("minbuy is not null");
            return (Criteria) this;
        }

        public Criteria andMinbuyEqualTo(Integer value) {
            addCriterion("minbuy =", value, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyNotEqualTo(Integer value) {
            addCriterion("minbuy <>", value, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyGreaterThan(Integer value) {
            addCriterion("minbuy >", value, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("minbuy >=", value, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyLessThan(Integer value) {
            addCriterion("minbuy <", value, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyLessThanOrEqualTo(Integer value) {
            addCriterion("minbuy <=", value, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyIn(List<Integer> values) {
            addCriterion("minbuy in", values, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyNotIn(List<Integer> values) {
            addCriterion("minbuy not in", values, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyBetween(Integer value1, Integer value2) {
            addCriterion("minbuy between", value1, value2, "minbuy");
            return (Criteria) this;
        }

        public Criteria andMinbuyNotBetween(Integer value1, Integer value2) {
            addCriterion("minbuy not between", value1, value2, "minbuy");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(Byte value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(Byte value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(Byte value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(Byte value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(Byte value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(Byte value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<Byte> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<Byte> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(Byte value1, Byte value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(Byte value1, Byte value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andRepairIsNull() {
            addCriterion("repair is null");
            return (Criteria) this;
        }

        public Criteria andRepairIsNotNull() {
            addCriterion("repair is not null");
            return (Criteria) this;
        }

        public Criteria andRepairEqualTo(Byte value) {
            addCriterion("repair =", value, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairNotEqualTo(Byte value) {
            addCriterion("repair <>", value, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairGreaterThan(Byte value) {
            addCriterion("repair >", value, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairGreaterThanOrEqualTo(Byte value) {
            addCriterion("repair >=", value, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairLessThan(Byte value) {
            addCriterion("repair <", value, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairLessThanOrEqualTo(Byte value) {
            addCriterion("repair <=", value, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairIn(List<Byte> values) {
            addCriterion("repair in", values, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairNotIn(List<Byte> values) {
            addCriterion("repair not in", values, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairBetween(Byte value1, Byte value2) {
            addCriterion("repair between", value1, value2, "repair");
            return (Criteria) this;
        }

        public Criteria andRepairNotBetween(Byte value1, Byte value2) {
            addCriterion("repair not between", value1, value2, "repair");
            return (Criteria) this;
        }

        public Criteria andSevenIsNull() {
            addCriterion("seven is null");
            return (Criteria) this;
        }

        public Criteria andSevenIsNotNull() {
            addCriterion("seven is not null");
            return (Criteria) this;
        }

        public Criteria andSevenEqualTo(Byte value) {
            addCriterion("seven =", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotEqualTo(Byte value) {
            addCriterion("seven <>", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThan(Byte value) {
            addCriterion("seven >", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThanOrEqualTo(Byte value) {
            addCriterion("seven >=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThan(Byte value) {
            addCriterion("seven <", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThanOrEqualTo(Byte value) {
            addCriterion("seven <=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenIn(List<Byte> values) {
            addCriterion("seven in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotIn(List<Byte> values) {
            addCriterion("seven not in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenBetween(Byte value1, Byte value2) {
            addCriterion("seven between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotBetween(Byte value1, Byte value2) {
            addCriterion("seven not between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(String value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(String value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(String value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(String value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLike(String value) {
            addCriterion("money like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotLike(String value) {
            addCriterion("money not like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<String> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<String> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMinpriceIsNull() {
            addCriterion("minprice is null");
            return (Criteria) this;
        }

        public Criteria andMinpriceIsNotNull() {
            addCriterion("minprice is not null");
            return (Criteria) this;
        }

        public Criteria andMinpriceEqualTo(BigDecimal value) {
            addCriterion("minprice =", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotEqualTo(BigDecimal value) {
            addCriterion("minprice <>", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceGreaterThan(BigDecimal value) {
            addCriterion("minprice >", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("minprice >=", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceLessThan(BigDecimal value) {
            addCriterion("minprice <", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("minprice <=", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceIn(List<BigDecimal> values) {
            addCriterion("minprice in", values, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotIn(List<BigDecimal> values) {
            addCriterion("minprice not in", values, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minprice between", value1, value2, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("minprice not between", value1, value2, "minprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceIsNull() {
            addCriterion("maxprice is null");
            return (Criteria) this;
        }

        public Criteria andMaxpriceIsNotNull() {
            addCriterion("maxprice is not null");
            return (Criteria) this;
        }

        public Criteria andMaxpriceEqualTo(BigDecimal value) {
            addCriterion("maxprice =", value, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceNotEqualTo(BigDecimal value) {
            addCriterion("maxprice <>", value, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceGreaterThan(BigDecimal value) {
            addCriterion("maxprice >", value, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("maxprice >=", value, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceLessThan(BigDecimal value) {
            addCriterion("maxprice <", value, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("maxprice <=", value, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceIn(List<BigDecimal> values) {
            addCriterion("maxprice in", values, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceNotIn(List<BigDecimal> values) {
            addCriterion("maxprice not in", values, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maxprice between", value1, value2, "maxprice");
            return (Criteria) this;
        }

        public Criteria andMaxpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maxprice not between", value1, value2, "maxprice");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andBuyshowIsNull() {
            addCriterion("buyshow is null");
            return (Criteria) this;
        }

        public Criteria andBuyshowIsNotNull() {
            addCriterion("buyshow is not null");
            return (Criteria) this;
        }

        public Criteria andBuyshowEqualTo(Boolean value) {
            addCriterion("buyshow =", value, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowNotEqualTo(Boolean value) {
            addCriterion("buyshow <>", value, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowGreaterThan(Boolean value) {
            addCriterion("buyshow >", value, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("buyshow >=", value, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowLessThan(Boolean value) {
            addCriterion("buyshow <", value, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowLessThanOrEqualTo(Boolean value) {
            addCriterion("buyshow <=", value, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowIn(List<Boolean> values) {
            addCriterion("buyshow in", values, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowNotIn(List<Boolean> values) {
            addCriterion("buyshow not in", values, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowBetween(Boolean value1, Boolean value2) {
            addCriterion("buyshow between", value1, value2, "buyshow");
            return (Criteria) this;
        }

        public Criteria andBuyshowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("buyshow not between", value1, value2, "buyshow");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117IsNull() {
            addCriterion("saleupdate51117 is null");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117IsNotNull() {
            addCriterion("saleupdate51117 is not null");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117EqualTo(Byte value) {
            addCriterion("saleupdate51117 =", value, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117NotEqualTo(Byte value) {
            addCriterion("saleupdate51117 <>", value, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117GreaterThan(Byte value) {
            addCriterion("saleupdate51117 >", value, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117GreaterThanOrEqualTo(Byte value) {
            addCriterion("saleupdate51117 >=", value, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117LessThan(Byte value) {
            addCriterion("saleupdate51117 <", value, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117LessThanOrEqualTo(Byte value) {
            addCriterion("saleupdate51117 <=", value, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117In(List<Byte> values) {
            addCriterion("saleupdate51117 in", values, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117NotIn(List<Byte> values) {
            addCriterion("saleupdate51117 not in", values, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117Between(Byte value1, Byte value2) {
            addCriterion("saleupdate51117 between", value1, value2, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andSaleupdate51117NotBetween(Byte value1, Byte value2) {
            addCriterion("saleupdate51117 not between", value1, value2, "saleupdate51117");
            return (Criteria) this;
        }

        public Criteria andVirtualsendIsNull() {
            addCriterion("virtualsend is null");
            return (Criteria) this;
        }

        public Criteria andVirtualsendIsNotNull() {
            addCriterion("virtualsend is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualsendEqualTo(Boolean value) {
            addCriterion("virtualsend =", value, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendNotEqualTo(Boolean value) {
            addCriterion("virtualsend <>", value, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendGreaterThan(Boolean value) {
            addCriterion("virtualsend >", value, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("virtualsend >=", value, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendLessThan(Boolean value) {
            addCriterion("virtualsend <", value, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendLessThanOrEqualTo(Boolean value) {
            addCriterion("virtualsend <=", value, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendIn(List<Boolean> values) {
            addCriterion("virtualsend in", values, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendNotIn(List<Boolean> values) {
            addCriterion("virtualsend not in", values, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendBetween(Boolean value1, Boolean value2) {
            addCriterion("virtualsend between", value1, value2, "virtualsend");
            return (Criteria) this;
        }

        public Criteria andVirtualsendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("virtualsend not between", value1, value2, "virtualsend");
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

        public Criteria andDiysaveidIsNull() {
            addCriterion("diysaveid is null");
            return (Criteria) this;
        }

        public Criteria andDiysaveidIsNotNull() {
            addCriterion("diysaveid is not null");
            return (Criteria) this;
        }

        public Criteria andDiysaveidEqualTo(Integer value) {
            addCriterion("diysaveid =", value, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidNotEqualTo(Integer value) {
            addCriterion("diysaveid <>", value, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidGreaterThan(Integer value) {
            addCriterion("diysaveid >", value, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidGreaterThanOrEqualTo(Integer value) {
            addCriterion("diysaveid >=", value, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidLessThan(Integer value) {
            addCriterion("diysaveid <", value, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidLessThanOrEqualTo(Integer value) {
            addCriterion("diysaveid <=", value, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidIn(List<Integer> values) {
            addCriterion("diysaveid in", values, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidNotIn(List<Integer> values) {
            addCriterion("diysaveid not in", values, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidBetween(Integer value1, Integer value2) {
            addCriterion("diysaveid between", value1, value2, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveidNotBetween(Integer value1, Integer value2) {
            addCriterion("diysaveid not between", value1, value2, "diysaveid");
            return (Criteria) this;
        }

        public Criteria andDiysaveIsNull() {
            addCriterion("diysave is null");
            return (Criteria) this;
        }

        public Criteria andDiysaveIsNotNull() {
            addCriterion("diysave is not null");
            return (Criteria) this;
        }

        public Criteria andDiysaveEqualTo(Boolean value) {
            addCriterion("diysave =", value, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveNotEqualTo(Boolean value) {
            addCriterion("diysave <>", value, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveGreaterThan(Boolean value) {
            addCriterion("diysave >", value, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("diysave >=", value, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveLessThan(Boolean value) {
            addCriterion("diysave <", value, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveLessThanOrEqualTo(Boolean value) {
            addCriterion("diysave <=", value, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveIn(List<Boolean> values) {
            addCriterion("diysave in", values, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveNotIn(List<Boolean> values) {
            addCriterion("diysave not in", values, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveBetween(Boolean value1, Boolean value2) {
            addCriterion("diysave between", value1, value2, "diysave");
            return (Criteria) this;
        }

        public Criteria andDiysaveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("diysave not between", value1, value2, "diysave");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Byte value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Byte value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Byte value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Byte value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Byte value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Byte value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Byte> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Byte> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Byte value1, Byte value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Byte value1, Byte value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andGroupstypeIsNull() {
            addCriterion("groupstype is null");
            return (Criteria) this;
        }

        public Criteria andGroupstypeIsNotNull() {
            addCriterion("groupstype is not null");
            return (Criteria) this;
        }

        public Criteria andGroupstypeEqualTo(Boolean value) {
            addCriterion("groupstype =", value, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeNotEqualTo(Boolean value) {
            addCriterion("groupstype <>", value, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeGreaterThan(Boolean value) {
            addCriterion("groupstype >", value, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("groupstype >=", value, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeLessThan(Boolean value) {
            addCriterion("groupstype <", value, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeLessThanOrEqualTo(Boolean value) {
            addCriterion("groupstype <=", value, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeIn(List<Boolean> values) {
            addCriterion("groupstype in", values, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeNotIn(List<Boolean> values) {
            addCriterion("groupstype not in", values, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeBetween(Boolean value1, Boolean value2) {
            addCriterion("groupstype between", value1, value2, "groupstype");
            return (Criteria) this;
        }

        public Criteria andGroupstypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("groupstype not between", value1, value2, "groupstype");
            return (Criteria) this;
        }

        public Criteria andShowtotalIsNull() {
            addCriterion("showtotal is null");
            return (Criteria) this;
        }

        public Criteria andShowtotalIsNotNull() {
            addCriterion("showtotal is not null");
            return (Criteria) this;
        }

        public Criteria andShowtotalEqualTo(Boolean value) {
            addCriterion("showtotal =", value, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalNotEqualTo(Boolean value) {
            addCriterion("showtotal <>", value, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalGreaterThan(Boolean value) {
            addCriterion("showtotal >", value, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("showtotal >=", value, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalLessThan(Boolean value) {
            addCriterion("showtotal <", value, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalLessThanOrEqualTo(Boolean value) {
            addCriterion("showtotal <=", value, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalIn(List<Boolean> values) {
            addCriterion("showtotal in", values, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalNotIn(List<Boolean> values) {
            addCriterion("showtotal not in", values, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalBetween(Boolean value1, Boolean value2) {
            addCriterion("showtotal between", value1, value2, "showtotal");
            return (Criteria) this;
        }

        public Criteria andShowtotalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("showtotal not between", value1, value2, "showtotal");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSharebtnIsNull() {
            addCriterion("sharebtn is null");
            return (Criteria) this;
        }

        public Criteria andSharebtnIsNotNull() {
            addCriterion("sharebtn is not null");
            return (Criteria) this;
        }

        public Criteria andSharebtnEqualTo(Boolean value) {
            addCriterion("sharebtn =", value, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnNotEqualTo(Boolean value) {
            addCriterion("sharebtn <>", value, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnGreaterThan(Boolean value) {
            addCriterion("sharebtn >", value, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sharebtn >=", value, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnLessThan(Boolean value) {
            addCriterion("sharebtn <", value, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnLessThanOrEqualTo(Boolean value) {
            addCriterion("sharebtn <=", value, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnIn(List<Boolean> values) {
            addCriterion("sharebtn in", values, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnNotIn(List<Boolean> values) {
            addCriterion("sharebtn not in", values, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnBetween(Boolean value1, Boolean value2) {
            addCriterion("sharebtn between", value1, value2, "sharebtn");
            return (Criteria) this;
        }

        public Criteria andSharebtnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sharebtn not between", value1, value2, "sharebtn");
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

        public Criteria andCheckedIsNull() {
            addCriterion("checked is null");
            return (Criteria) this;
        }

        public Criteria andCheckedIsNotNull() {
            addCriterion("checked is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedEqualTo(Byte value) {
            addCriterion("checked =", value, "checked");
            return (Criteria) this;
        }
        
        public Criteria andCheckedEqualToOr(Byte value1,Byte value2) {
            addCriterion("(checked ="+value1+" or status ="+value2+")");
            return (Criteria) this;
        }

        public Criteria andCheckedNotEqualTo(Byte value) {
            addCriterion("checked <>", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedGreaterThan(Byte value) {
            addCriterion("checked >", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedGreaterThanOrEqualTo(Byte value) {
            addCriterion("checked >=", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLessThan(Byte value) {
            addCriterion("checked <", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLessThanOrEqualTo(Byte value) {
            addCriterion("checked <=", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedIn(List<Byte> values) {
            addCriterion("checked in", values, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotIn(List<Byte> values) {
            addCriterion("checked not in", values, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedBetween(Byte value1, Byte value2) {
            addCriterion("checked between", value1, value2, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotBetween(Byte value1, Byte value2) {
            addCriterion("checked not between", value1, value2, "checked");
            return (Criteria) this;
        }

        public Criteria andThumbFirstIsNull() {
            addCriterion("thumb_first is null");
            return (Criteria) this;
        }

        public Criteria andThumbFirstIsNotNull() {
            addCriterion("thumb_first is not null");
            return (Criteria) this;
        }

        public Criteria andThumbFirstEqualTo(Byte value) {
            addCriterion("thumb_first =", value, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstNotEqualTo(Byte value) {
            addCriterion("thumb_first <>", value, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstGreaterThan(Byte value) {
            addCriterion("thumb_first >", value, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstGreaterThanOrEqualTo(Byte value) {
            addCriterion("thumb_first >=", value, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstLessThan(Byte value) {
            addCriterion("thumb_first <", value, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstLessThanOrEqualTo(Byte value) {
            addCriterion("thumb_first <=", value, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstIn(List<Byte> values) {
            addCriterion("thumb_first in", values, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstNotIn(List<Byte> values) {
            addCriterion("thumb_first not in", values, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstBetween(Byte value1, Byte value2) {
            addCriterion("thumb_first between", value1, value2, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andThumbFirstNotBetween(Byte value1, Byte value2) {
            addCriterion("thumb_first not between", value1, value2, "thumbFirst");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdIsNull() {
            addCriterion("showtotaladd is null");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdIsNotNull() {
            addCriterion("showtotaladd is not null");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdEqualTo(Boolean value) {
            addCriterion("showtotaladd =", value, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdNotEqualTo(Boolean value) {
            addCriterion("showtotaladd <>", value, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdGreaterThan(Boolean value) {
            addCriterion("showtotaladd >", value, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("showtotaladd >=", value, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdLessThan(Boolean value) {
            addCriterion("showtotaladd <", value, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdLessThanOrEqualTo(Boolean value) {
            addCriterion("showtotaladd <=", value, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdIn(List<Boolean> values) {
            addCriterion("showtotaladd in", values, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdNotIn(List<Boolean> values) {
            addCriterion("showtotaladd not in", values, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdBetween(Boolean value1, Boolean value2) {
            addCriterion("showtotaladd between", value1, value2, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andShowtotaladdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("showtotaladd not between", value1, value2, "showtotaladd");
            return (Criteria) this;
        }

        public Criteria andMerchsaleIsNull() {
            addCriterion("merchsale is null");
            return (Criteria) this;
        }

        public Criteria andMerchsaleIsNotNull() {
            addCriterion("merchsale is not null");
            return (Criteria) this;
        }

        public Criteria andMerchsaleEqualTo(Boolean value) {
            addCriterion("merchsale =", value, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleNotEqualTo(Boolean value) {
            addCriterion("merchsale <>", value, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleGreaterThan(Boolean value) {
            addCriterion("merchsale >", value, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("merchsale >=", value, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleLessThan(Boolean value) {
            addCriterion("merchsale <", value, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleLessThanOrEqualTo(Boolean value) {
            addCriterion("merchsale <=", value, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleIn(List<Boolean> values) {
            addCriterion("merchsale in", values, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleNotIn(List<Boolean> values) {
            addCriterion("merchsale not in", values, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleBetween(Boolean value1, Boolean value2) {
            addCriterion("merchsale between", value1, value2, "merchsale");
            return (Criteria) this;
        }

        public Criteria andMerchsaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("merchsale not between", value1, value2, "merchsale");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andCatchIdIsNull() {
            addCriterion("catch_id is null");
            return (Criteria) this;
        }

        public Criteria andCatchIdIsNotNull() {
            addCriterion("catch_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatchIdEqualTo(String value) {
            addCriterion("catch_id =", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdNotEqualTo(String value) {
            addCriterion("catch_id <>", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdGreaterThan(String value) {
            addCriterion("catch_id >", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("catch_id >=", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdLessThan(String value) {
            addCriterion("catch_id <", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdLessThanOrEqualTo(String value) {
            addCriterion("catch_id <=", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdLike(String value) {
            addCriterion("catch_id like", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdNotLike(String value) {
            addCriterion("catch_id not like", value, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdIn(List<String> values) {
            addCriterion("catch_id in", values, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdNotIn(List<String> values) {
            addCriterion("catch_id not in", values, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdBetween(String value1, String value2) {
            addCriterion("catch_id between", value1, value2, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchIdNotBetween(String value1, String value2) {
            addCriterion("catch_id not between", value1, value2, "catchId");
            return (Criteria) this;
        }

        public Criteria andCatchUrlIsNull() {
            addCriterion("catch_url is null");
            return (Criteria) this;
        }

        public Criteria andCatchUrlIsNotNull() {
            addCriterion("catch_url is not null");
            return (Criteria) this;
        }

        public Criteria andCatchUrlEqualTo(String value) {
            addCriterion("catch_url =", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlNotEqualTo(String value) {
            addCriterion("catch_url <>", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlGreaterThan(String value) {
            addCriterion("catch_url >", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlGreaterThanOrEqualTo(String value) {
            addCriterion("catch_url >=", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlLessThan(String value) {
            addCriterion("catch_url <", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlLessThanOrEqualTo(String value) {
            addCriterion("catch_url <=", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlLike(String value) {
            addCriterion("catch_url like", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlNotLike(String value) {
            addCriterion("catch_url not like", value, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlIn(List<String> values) {
            addCriterion("catch_url in", values, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlNotIn(List<String> values) {
            addCriterion("catch_url not in", values, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlBetween(String value1, String value2) {
            addCriterion("catch_url between", value1, value2, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchUrlNotBetween(String value1, String value2) {
            addCriterion("catch_url not between", value1, value2, "catchUrl");
            return (Criteria) this;
        }

        public Criteria andCatchSourceIsNull() {
            addCriterion("catch_source is null");
            return (Criteria) this;
        }

        public Criteria andCatchSourceIsNotNull() {
            addCriterion("catch_source is not null");
            return (Criteria) this;
        }

        public Criteria andCatchSourceEqualTo(String value) {
            addCriterion("catch_source =", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceNotEqualTo(String value) {
            addCriterion("catch_source <>", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceGreaterThan(String value) {
            addCriterion("catch_source >", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceGreaterThanOrEqualTo(String value) {
            addCriterion("catch_source >=", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceLessThan(String value) {
            addCriterion("catch_source <", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceLessThanOrEqualTo(String value) {
            addCriterion("catch_source <=", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceLike(String value) {
            addCriterion("catch_source like", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceNotLike(String value) {
            addCriterion("catch_source not like", value, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceIn(List<String> values) {
            addCriterion("catch_source in", values, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceNotIn(List<String> values) {
            addCriterion("catch_source not in", values, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceBetween(String value1, String value2) {
            addCriterion("catch_source between", value1, value2, "catchSource");
            return (Criteria) this;
        }

        public Criteria andCatchSourceNotBetween(String value1, String value2) {
            addCriterion("catch_source not between", value1, value2, "catchSource");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveIsNull() {
            addCriterion("autoreceive is null");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveIsNotNull() {
            addCriterion("autoreceive is not null");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveEqualTo(Integer value) {
            addCriterion("autoreceive =", value, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveNotEqualTo(Integer value) {
            addCriterion("autoreceive <>", value, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveGreaterThan(Integer value) {
            addCriterion("autoreceive >", value, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("autoreceive >=", value, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveLessThan(Integer value) {
            addCriterion("autoreceive <", value, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveLessThanOrEqualTo(Integer value) {
            addCriterion("autoreceive <=", value, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveIn(List<Integer> values) {
            addCriterion("autoreceive in", values, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveNotIn(List<Integer> values) {
            addCriterion("autoreceive not in", values, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveBetween(Integer value1, Integer value2) {
            addCriterion("autoreceive between", value1, value2, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andAutoreceiveNotBetween(Integer value1, Integer value2) {
            addCriterion("autoreceive not between", value1, value2, "autoreceive");
            return (Criteria) this;
        }

        public Criteria andCannotrefundIsNull() {
            addCriterion("cannotrefund is null");
            return (Criteria) this;
        }

        public Criteria andCannotrefundIsNotNull() {
            addCriterion("cannotrefund is not null");
            return (Criteria) this;
        }

        public Criteria andCannotrefundEqualTo(Byte value) {
            addCriterion("cannotrefund =", value, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundNotEqualTo(Byte value) {
            addCriterion("cannotrefund <>", value, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundGreaterThan(Byte value) {
            addCriterion("cannotrefund >", value, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundGreaterThanOrEqualTo(Byte value) {
            addCriterion("cannotrefund >=", value, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundLessThan(Byte value) {
            addCriterion("cannotrefund <", value, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundLessThanOrEqualTo(Byte value) {
            addCriterion("cannotrefund <=", value, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundIn(List<Byte> values) {
            addCriterion("cannotrefund in", values, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundNotIn(List<Byte> values) {
            addCriterion("cannotrefund not in", values, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundBetween(Byte value1, Byte value2) {
            addCriterion("cannotrefund between", value1, value2, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andCannotrefundNotBetween(Byte value1, Byte value2) {
            addCriterion("cannotrefund not between", value1, value2, "cannotrefund");
            return (Criteria) this;
        }

        public Criteria andBargainIsNull() {
            addCriterion("bargain is null");
            return (Criteria) this;
        }

        public Criteria andBargainIsNotNull() {
            addCriterion("bargain is not null");
            return (Criteria) this;
        }

        public Criteria andBargainEqualTo(Integer value) {
            addCriterion("bargain =", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainNotEqualTo(Integer value) {
            addCriterion("bargain <>", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainGreaterThan(Integer value) {
            addCriterion("bargain >", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainGreaterThanOrEqualTo(Integer value) {
            addCriterion("bargain >=", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainLessThan(Integer value) {
            addCriterion("bargain <", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainLessThanOrEqualTo(Integer value) {
            addCriterion("bargain <=", value, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainIn(List<Integer> values) {
            addCriterion("bargain in", values, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainNotIn(List<Integer> values) {
            addCriterion("bargain not in", values, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainBetween(Integer value1, Integer value2) {
            addCriterion("bargain between", value1, value2, "bargain");
            return (Criteria) this;
        }

        public Criteria andBargainNotBetween(Integer value1, Integer value2) {
            addCriterion("bargain not between", value1, value2, "bargain");
            return (Criteria) this;
        }

        public Criteria andBuyagainIsNull() {
            addCriterion("buyagain is null");
            return (Criteria) this;
        }

        public Criteria andBuyagainIsNotNull() {
            addCriterion("buyagain is not null");
            return (Criteria) this;
        }

        public Criteria andBuyagainEqualTo(BigDecimal value) {
            addCriterion("buyagain =", value, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainNotEqualTo(BigDecimal value) {
            addCriterion("buyagain <>", value, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainGreaterThan(BigDecimal value) {
            addCriterion("buyagain >", value, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buyagain >=", value, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainLessThan(BigDecimal value) {
            addCriterion("buyagain <", value, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buyagain <=", value, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainIn(List<BigDecimal> values) {
            addCriterion("buyagain in", values, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainNotIn(List<BigDecimal> values) {
            addCriterion("buyagain not in", values, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyagain between", value1, value2, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyagain not between", value1, value2, "buyagain");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongIsNull() {
            addCriterion("buyagain_islong is null");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongIsNotNull() {
            addCriterion("buyagain_islong is not null");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongEqualTo(Boolean value) {
            addCriterion("buyagain_islong =", value, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongNotEqualTo(Boolean value) {
            addCriterion("buyagain_islong <>", value, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongGreaterThan(Boolean value) {
            addCriterion("buyagain_islong >", value, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongGreaterThanOrEqualTo(Boolean value) {
            addCriterion("buyagain_islong >=", value, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongLessThan(Boolean value) {
            addCriterion("buyagain_islong <", value, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongLessThanOrEqualTo(Boolean value) {
            addCriterion("buyagain_islong <=", value, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongIn(List<Boolean> values) {
            addCriterion("buyagain_islong in", values, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongNotIn(List<Boolean> values) {
            addCriterion("buyagain_islong not in", values, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongBetween(Boolean value1, Boolean value2) {
            addCriterion("buyagain_islong between", value1, value2, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainIslongNotBetween(Boolean value1, Boolean value2) {
            addCriterion("buyagain_islong not between", value1, value2, "buyagainIslong");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionIsNull() {
            addCriterion("buyagain_condition is null");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionIsNotNull() {
            addCriterion("buyagain_condition is not null");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionEqualTo(Boolean value) {
            addCriterion("buyagain_condition =", value, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionNotEqualTo(Boolean value) {
            addCriterion("buyagain_condition <>", value, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionGreaterThan(Boolean value) {
            addCriterion("buyagain_condition >", value, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionGreaterThanOrEqualTo(Boolean value) {
            addCriterion("buyagain_condition >=", value, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionLessThan(Boolean value) {
            addCriterion("buyagain_condition <", value, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionLessThanOrEqualTo(Boolean value) {
            addCriterion("buyagain_condition <=", value, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionIn(List<Boolean> values) {
            addCriterion("buyagain_condition in", values, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionNotIn(List<Boolean> values) {
            addCriterion("buyagain_condition not in", values, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionBetween(Boolean value1, Boolean value2) {
            addCriterion("buyagain_condition between", value1, value2, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainConditionNotBetween(Boolean value1, Boolean value2) {
            addCriterion("buyagain_condition not between", value1, value2, "buyagainCondition");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleIsNull() {
            addCriterion("buyagain_sale is null");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleIsNotNull() {
            addCriterion("buyagain_sale is not null");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleEqualTo(Boolean value) {
            addCriterion("buyagain_sale =", value, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleNotEqualTo(Boolean value) {
            addCriterion("buyagain_sale <>", value, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleGreaterThan(Boolean value) {
            addCriterion("buyagain_sale >", value, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("buyagain_sale >=", value, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleLessThan(Boolean value) {
            addCriterion("buyagain_sale <", value, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleLessThanOrEqualTo(Boolean value) {
            addCriterion("buyagain_sale <=", value, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleIn(List<Boolean> values) {
            addCriterion("buyagain_sale in", values, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleNotIn(List<Boolean> values) {
            addCriterion("buyagain_sale not in", values, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleBetween(Boolean value1, Boolean value2) {
            addCriterion("buyagain_sale between", value1, value2, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andBuyagainSaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("buyagain_sale not between", value1, value2, "buyagainSale");
            return (Criteria) this;
        }

        public Criteria andDiypageIsNull() {
            addCriterion("diypage is null");
            return (Criteria) this;
        }

        public Criteria andDiypageIsNotNull() {
            addCriterion("diypage is not null");
            return (Criteria) this;
        }

        public Criteria andDiypageEqualTo(Integer value) {
            addCriterion("diypage =", value, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageNotEqualTo(Integer value) {
            addCriterion("diypage <>", value, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageGreaterThan(Integer value) {
            addCriterion("diypage >", value, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageGreaterThanOrEqualTo(Integer value) {
            addCriterion("diypage >=", value, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageLessThan(Integer value) {
            addCriterion("diypage <", value, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageLessThanOrEqualTo(Integer value) {
            addCriterion("diypage <=", value, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageIn(List<Integer> values) {
            addCriterion("diypage in", values, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageNotIn(List<Integer> values) {
            addCriterion("diypage not in", values, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageBetween(Integer value1, Integer value2) {
            addCriterion("diypage between", value1, value2, "diypage");
            return (Criteria) this;
        }

        public Criteria andDiypageNotBetween(Integer value1, Integer value2) {
            addCriterion("diypage not between", value1, value2, "diypage");
            return (Criteria) this;
        }

        public Criteria andCashierIsNull() {
            addCriterion("cashier is null");
            return (Criteria) this;
        }

        public Criteria andCashierIsNotNull() {
            addCriterion("cashier is not null");
            return (Criteria) this;
        }

        public Criteria andCashierEqualTo(Boolean value) {
            addCriterion("cashier =", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotEqualTo(Boolean value) {
            addCriterion("cashier <>", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierGreaterThan(Boolean value) {
            addCriterion("cashier >", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cashier >=", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLessThan(Boolean value) {
            addCriterion("cashier <", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLessThanOrEqualTo(Boolean value) {
            addCriterion("cashier <=", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierIn(List<Boolean> values) {
            addCriterion("cashier in", values, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotIn(List<Boolean> values) {
            addCriterion("cashier not in", values, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierBetween(Boolean value1, Boolean value2) {
            addCriterion("cashier between", value1, value2, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotBetween(Boolean value1, Boolean value2) {
            addCriterion("cashier not between", value1, value2, "cashier");
            return (Criteria) this;
        }

        public Criteria andIsendtimeIsNull() {
            addCriterion("isendtime is null");
            return (Criteria) this;
        }

        public Criteria andIsendtimeIsNotNull() {
            addCriterion("isendtime is not null");
            return (Criteria) this;
        }

        public Criteria andIsendtimeEqualTo(Byte value) {
            addCriterion("isendtime =", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeNotEqualTo(Byte value) {
            addCriterion("isendtime <>", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeGreaterThan(Byte value) {
            addCriterion("isendtime >", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("isendtime >=", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeLessThan(Byte value) {
            addCriterion("isendtime <", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeLessThanOrEqualTo(Byte value) {
            addCriterion("isendtime <=", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeIn(List<Byte> values) {
            addCriterion("isendtime in", values, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeNotIn(List<Byte> values) {
            addCriterion("isendtime not in", values, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeBetween(Byte value1, Byte value2) {
            addCriterion("isendtime between", value1, value2, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeNotBetween(Byte value1, Byte value2) {
            addCriterion("isendtime not between", value1, value2, "isendtime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNull() {
            addCriterion("usetime is null");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNotNull() {
            addCriterion("usetime is not null");
            return (Criteria) this;
        }

        public Criteria andUsetimeEqualTo(Integer value) {
            addCriterion("usetime =", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotEqualTo(Integer value) {
            addCriterion("usetime <>", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThan(Integer value) {
            addCriterion("usetime >", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usetime >=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThan(Integer value) {
            addCriterion("usetime <", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThanOrEqualTo(Integer value) {
            addCriterion("usetime <=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIn(List<Integer> values) {
            addCriterion("usetime in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotIn(List<Integer> values) {
            addCriterion("usetime not in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeBetween(Integer value1, Integer value2) {
            addCriterion("usetime between", value1, value2, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("usetime not between", value1, value2, "usetime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Integer value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Integer value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Integer value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Integer value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Integer value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Integer> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Integer> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Integer value1, Integer value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderIsNull() {
            addCriterion("merchdisplayorder is null");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderIsNotNull() {
            addCriterion("merchdisplayorder is not null");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderEqualTo(Integer value) {
            addCriterion("merchdisplayorder =", value, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderNotEqualTo(Integer value) {
            addCriterion("merchdisplayorder <>", value, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderGreaterThan(Integer value) {
            addCriterion("merchdisplayorder >", value, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchdisplayorder >=", value, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderLessThan(Integer value) {
            addCriterion("merchdisplayorder <", value, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderLessThanOrEqualTo(Integer value) {
            addCriterion("merchdisplayorder <=", value, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderIn(List<Integer> values) {
            addCriterion("merchdisplayorder in", values, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderNotIn(List<Integer> values) {
            addCriterion("merchdisplayorder not in", values, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderBetween(Integer value1, Integer value2) {
            addCriterion("merchdisplayorder between", value1, value2, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andMerchdisplayorderNotBetween(Integer value1, Integer value2) {
            addCriterion("merchdisplayorder not between", value1, value2, "merchdisplayorder");
            return (Criteria) this;
        }

        public Criteria andExchangeStockIsNull() {
            addCriterion("exchange_stock is null");
            return (Criteria) this;
        }

        public Criteria andExchangeStockIsNotNull() {
            addCriterion("exchange_stock is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeStockEqualTo(Integer value) {
            addCriterion("exchange_stock =", value, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockNotEqualTo(Integer value) {
            addCriterion("exchange_stock <>", value, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockGreaterThan(Integer value) {
            addCriterion("exchange_stock >", value, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchange_stock >=", value, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockLessThan(Integer value) {
            addCriterion("exchange_stock <", value, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockLessThanOrEqualTo(Integer value) {
            addCriterion("exchange_stock <=", value, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockIn(List<Integer> values) {
            addCriterion("exchange_stock in", values, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockNotIn(List<Integer> values) {
            addCriterion("exchange_stock not in", values, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockBetween(Integer value1, Integer value2) {
            addCriterion("exchange_stock between", value1, value2, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangeStockNotBetween(Integer value1, Integer value2) {
            addCriterion("exchange_stock not between", value1, value2, "exchangeStock");
            return (Criteria) this;
        }

        public Criteria andExchangePostageIsNull() {
            addCriterion("exchange_postage is null");
            return (Criteria) this;
        }

        public Criteria andExchangePostageIsNotNull() {
            addCriterion("exchange_postage is not null");
            return (Criteria) this;
        }

        public Criteria andExchangePostageEqualTo(BigDecimal value) {
            addCriterion("exchange_postage =", value, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageNotEqualTo(BigDecimal value) {
            addCriterion("exchange_postage <>", value, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageGreaterThan(BigDecimal value) {
            addCriterion("exchange_postage >", value, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_postage >=", value, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageLessThan(BigDecimal value) {
            addCriterion("exchange_postage <", value, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_postage <=", value, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageIn(List<BigDecimal> values) {
            addCriterion("exchange_postage in", values, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageNotIn(List<BigDecimal> values) {
            addCriterion("exchange_postage not in", values, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_postage between", value1, value2, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andExchangePostageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_postage not between", value1, value2, "exchangePostage");
            return (Criteria) this;
        }

        public Criteria andIspresellIsNull() {
            addCriterion("ispresell is null");
            return (Criteria) this;
        }

        public Criteria andIspresellIsNotNull() {
            addCriterion("ispresell is not null");
            return (Criteria) this;
        }

        public Criteria andIspresellEqualTo(Byte value) {
            addCriterion("ispresell =", value, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellNotEqualTo(Byte value) {
            addCriterion("ispresell <>", value, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellGreaterThan(Byte value) {
            addCriterion("ispresell >", value, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellGreaterThanOrEqualTo(Byte value) {
            addCriterion("ispresell >=", value, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellLessThan(Byte value) {
            addCriterion("ispresell <", value, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellLessThanOrEqualTo(Byte value) {
            addCriterion("ispresell <=", value, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellIn(List<Byte> values) {
            addCriterion("ispresell in", values, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellNotIn(List<Byte> values) {
            addCriterion("ispresell not in", values, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellBetween(Byte value1, Byte value2) {
            addCriterion("ispresell between", value1, value2, "ispresell");
            return (Criteria) this;
        }

        public Criteria andIspresellNotBetween(Byte value1, Byte value2) {
            addCriterion("ispresell not between", value1, value2, "ispresell");
            return (Criteria) this;
        }

        public Criteria andPresellpriceIsNull() {
            addCriterion("presellprice is null");
            return (Criteria) this;
        }

        public Criteria andPresellpriceIsNotNull() {
            addCriterion("presellprice is not null");
            return (Criteria) this;
        }

        public Criteria andPresellpriceEqualTo(BigDecimal value) {
            addCriterion("presellprice =", value, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceNotEqualTo(BigDecimal value) {
            addCriterion("presellprice <>", value, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceGreaterThan(BigDecimal value) {
            addCriterion("presellprice >", value, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("presellprice >=", value, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceLessThan(BigDecimal value) {
            addCriterion("presellprice <", value, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("presellprice <=", value, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceIn(List<BigDecimal> values) {
            addCriterion("presellprice in", values, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceNotIn(List<BigDecimal> values) {
            addCriterion("presellprice not in", values, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("presellprice between", value1, value2, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPresellpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("presellprice not between", value1, value2, "presellprice");
            return (Criteria) this;
        }

        public Criteria andPreselloverIsNull() {
            addCriterion("presellover is null");
            return (Criteria) this;
        }

        public Criteria andPreselloverIsNotNull() {
            addCriterion("presellover is not null");
            return (Criteria) this;
        }

        public Criteria andPreselloverEqualTo(Byte value) {
            addCriterion("presellover =", value, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverNotEqualTo(Byte value) {
            addCriterion("presellover <>", value, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverGreaterThan(Byte value) {
            addCriterion("presellover >", value, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverGreaterThanOrEqualTo(Byte value) {
            addCriterion("presellover >=", value, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverLessThan(Byte value) {
            addCriterion("presellover <", value, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverLessThanOrEqualTo(Byte value) {
            addCriterion("presellover <=", value, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverIn(List<Byte> values) {
            addCriterion("presellover in", values, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverNotIn(List<Byte> values) {
            addCriterion("presellover not in", values, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverBetween(Byte value1, Byte value2) {
            addCriterion("presellover between", value1, value2, "presellover");
            return (Criteria) this;
        }

        public Criteria andPreselloverNotBetween(Byte value1, Byte value2) {
            addCriterion("presellover not between", value1, value2, "presellover");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeIsNull() {
            addCriterion("presellovertime is null");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeIsNotNull() {
            addCriterion("presellovertime is not null");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeEqualTo(Integer value) {
            addCriterion("presellovertime =", value, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeNotEqualTo(Integer value) {
            addCriterion("presellovertime <>", value, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeGreaterThan(Integer value) {
            addCriterion("presellovertime >", value, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("presellovertime >=", value, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeLessThan(Integer value) {
            addCriterion("presellovertime <", value, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeLessThanOrEqualTo(Integer value) {
            addCriterion("presellovertime <=", value, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeIn(List<Integer> values) {
            addCriterion("presellovertime in", values, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeNotIn(List<Integer> values) {
            addCriterion("presellovertime not in", values, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeBetween(Integer value1, Integer value2) {
            addCriterion("presellovertime between", value1, value2, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellovertimeNotBetween(Integer value1, Integer value2) {
            addCriterion("presellovertime not between", value1, value2, "presellovertime");
            return (Criteria) this;
        }

        public Criteria andPresellstartIsNull() {
            addCriterion("presellstart is null");
            return (Criteria) this;
        }

        public Criteria andPresellstartIsNotNull() {
            addCriterion("presellstart is not null");
            return (Criteria) this;
        }

        public Criteria andPresellstartEqualTo(Byte value) {
            addCriterion("presellstart =", value, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartNotEqualTo(Byte value) {
            addCriterion("presellstart <>", value, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartGreaterThan(Byte value) {
            addCriterion("presellstart >", value, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartGreaterThanOrEqualTo(Byte value) {
            addCriterion("presellstart >=", value, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartLessThan(Byte value) {
            addCriterion("presellstart <", value, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartLessThanOrEqualTo(Byte value) {
            addCriterion("presellstart <=", value, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartIn(List<Byte> values) {
            addCriterion("presellstart in", values, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartNotIn(List<Byte> values) {
            addCriterion("presellstart not in", values, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartBetween(Byte value1, Byte value2) {
            addCriterion("presellstart between", value1, value2, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPresellstartNotBetween(Byte value1, Byte value2) {
            addCriterion("presellstart not between", value1, value2, "presellstart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartIsNull() {
            addCriterion("preselltimestart is null");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartIsNotNull() {
            addCriterion("preselltimestart is not null");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartEqualTo(Integer value) {
            addCriterion("preselltimestart =", value, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartNotEqualTo(Integer value) {
            addCriterion("preselltimestart <>", value, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartGreaterThan(Integer value) {
            addCriterion("preselltimestart >", value, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartGreaterThanOrEqualTo(Integer value) {
            addCriterion("preselltimestart >=", value, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartLessThan(Integer value) {
            addCriterion("preselltimestart <", value, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartLessThanOrEqualTo(Integer value) {
            addCriterion("preselltimestart <=", value, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartIn(List<Integer> values) {
            addCriterion("preselltimestart in", values, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartNotIn(List<Integer> values) {
            addCriterion("preselltimestart not in", values, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartBetween(Integer value1, Integer value2) {
            addCriterion("preselltimestart between", value1, value2, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPreselltimestartNotBetween(Integer value1, Integer value2) {
            addCriterion("preselltimestart not between", value1, value2, "preselltimestart");
            return (Criteria) this;
        }

        public Criteria andPresellendIsNull() {
            addCriterion("presellend is null");
            return (Criteria) this;
        }

        public Criteria andPresellendIsNotNull() {
            addCriterion("presellend is not null");
            return (Criteria) this;
        }

        public Criteria andPresellendEqualTo(Byte value) {
            addCriterion("presellend =", value, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendNotEqualTo(Byte value) {
            addCriterion("presellend <>", value, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendGreaterThan(Byte value) {
            addCriterion("presellend >", value, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendGreaterThanOrEqualTo(Byte value) {
            addCriterion("presellend >=", value, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendLessThan(Byte value) {
            addCriterion("presellend <", value, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendLessThanOrEqualTo(Byte value) {
            addCriterion("presellend <=", value, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendIn(List<Byte> values) {
            addCriterion("presellend in", values, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendNotIn(List<Byte> values) {
            addCriterion("presellend not in", values, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendBetween(Byte value1, Byte value2) {
            addCriterion("presellend between", value1, value2, "presellend");
            return (Criteria) this;
        }

        public Criteria andPresellendNotBetween(Byte value1, Byte value2) {
            addCriterion("presellend not between", value1, value2, "presellend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendIsNull() {
            addCriterion("preselltimeend is null");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendIsNotNull() {
            addCriterion("preselltimeend is not null");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendEqualTo(Integer value) {
            addCriterion("preselltimeend =", value, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendNotEqualTo(Integer value) {
            addCriterion("preselltimeend <>", value, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendGreaterThan(Integer value) {
            addCriterion("preselltimeend >", value, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendGreaterThanOrEqualTo(Integer value) {
            addCriterion("preselltimeend >=", value, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendLessThan(Integer value) {
            addCriterion("preselltimeend <", value, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendLessThanOrEqualTo(Integer value) {
            addCriterion("preselltimeend <=", value, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendIn(List<Integer> values) {
            addCriterion("preselltimeend in", values, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendNotIn(List<Integer> values) {
            addCriterion("preselltimeend not in", values, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendBetween(Integer value1, Integer value2) {
            addCriterion("preselltimeend between", value1, value2, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPreselltimeendNotBetween(Integer value1, Integer value2) {
            addCriterion("preselltimeend not between", value1, value2, "preselltimeend");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeIsNull() {
            addCriterion("presellsendtype is null");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeIsNotNull() {
            addCriterion("presellsendtype is not null");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeEqualTo(Byte value) {
            addCriterion("presellsendtype =", value, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeNotEqualTo(Byte value) {
            addCriterion("presellsendtype <>", value, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeGreaterThan(Byte value) {
            addCriterion("presellsendtype >", value, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("presellsendtype >=", value, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeLessThan(Byte value) {
            addCriterion("presellsendtype <", value, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeLessThanOrEqualTo(Byte value) {
            addCriterion("presellsendtype <=", value, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeIn(List<Byte> values) {
            addCriterion("presellsendtype in", values, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeNotIn(List<Byte> values) {
            addCriterion("presellsendtype not in", values, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeBetween(Byte value1, Byte value2) {
            addCriterion("presellsendtype between", value1, value2, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("presellsendtype not between", value1, value2, "presellsendtype");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeIsNull() {
            addCriterion("presellsendstatrttime is null");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeIsNotNull() {
            addCriterion("presellsendstatrttime is not null");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeEqualTo(Integer value) {
            addCriterion("presellsendstatrttime =", value, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeNotEqualTo(Integer value) {
            addCriterion("presellsendstatrttime <>", value, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeGreaterThan(Integer value) {
            addCriterion("presellsendstatrttime >", value, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("presellsendstatrttime >=", value, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeLessThan(Integer value) {
            addCriterion("presellsendstatrttime <", value, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeLessThanOrEqualTo(Integer value) {
            addCriterion("presellsendstatrttime <=", value, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeIn(List<Integer> values) {
            addCriterion("presellsendstatrttime in", values, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeNotIn(List<Integer> values) {
            addCriterion("presellsendstatrttime not in", values, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeBetween(Integer value1, Integer value2) {
            addCriterion("presellsendstatrttime between", value1, value2, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendstatrttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("presellsendstatrttime not between", value1, value2, "presellsendstatrttime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeIsNull() {
            addCriterion("presellsendtime is null");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeIsNotNull() {
            addCriterion("presellsendtime is not null");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeEqualTo(Integer value) {
            addCriterion("presellsendtime =", value, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeNotEqualTo(Integer value) {
            addCriterion("presellsendtime <>", value, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeGreaterThan(Integer value) {
            addCriterion("presellsendtime >", value, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("presellsendtime >=", value, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeLessThan(Integer value) {
            addCriterion("presellsendtime <", value, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeLessThanOrEqualTo(Integer value) {
            addCriterion("presellsendtime <=", value, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeIn(List<Integer> values) {
            addCriterion("presellsendtime in", values, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeNotIn(List<Integer> values) {
            addCriterion("presellsendtime not in", values, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeBetween(Integer value1, Integer value2) {
            addCriterion("presellsendtime between", value1, value2, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andPresellsendtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("presellsendtime not between", value1, value2, "presellsendtime");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeIsNull() {
            addCriterion("edareas_code is null");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeIsNotNull() {
            addCriterion("edareas_code is not null");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeEqualTo(String value) {
            addCriterion("edareas_code =", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeNotEqualTo(String value) {
            addCriterion("edareas_code <>", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeGreaterThan(String value) {
            addCriterion("edareas_code >", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeGreaterThanOrEqualTo(String value) {
            addCriterion("edareas_code >=", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeLessThan(String value) {
            addCriterion("edareas_code <", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeLessThanOrEqualTo(String value) {
            addCriterion("edareas_code <=", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeLike(String value) {
            addCriterion("edareas_code like", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeNotLike(String value) {
            addCriterion("edareas_code not like", value, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeIn(List<String> values) {
            addCriterion("edareas_code in", values, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeNotIn(List<String> values) {
            addCriterion("edareas_code not in", values, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeBetween(String value1, String value2) {
            addCriterion("edareas_code between", value1, value2, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andEdareasCodeNotBetween(String value1, String value2) {
            addCriterion("edareas_code not between", value1, value2, "edareasCode");
            return (Criteria) this;
        }

        public Criteria andIsMillIsNull() {
            addCriterion("is_mill is null");
            return (Criteria) this;
        }

        public Criteria andIsMillIsNotNull() {
            addCriterion("is_mill is not null");
            return (Criteria) this;
        }

        public Criteria andIsMillEqualTo(Integer value) {
            addCriterion("is_mill =", value, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillNotEqualTo(Integer value) {
            addCriterion("is_mill <>", value, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillGreaterThan(Integer value) {
            addCriterion("is_mill >", value, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_mill >=", value, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillLessThan(Integer value) {
            addCriterion("is_mill <", value, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillLessThanOrEqualTo(Integer value) {
            addCriterion("is_mill <=", value, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillIn(List<Integer> values) {
            addCriterion("is_mill in", values, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillNotIn(List<Integer> values) {
            addCriterion("is_mill not in", values, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillBetween(Integer value1, Integer value2) {
            addCriterion("is_mill between", value1, value2, "isMill");
            return (Criteria) this;
        }

        public Criteria andIsMillNotBetween(Integer value1, Integer value2) {
            addCriterion("is_mill not between", value1, value2, "isMill");
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

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andServicesIsNull() {
            addCriterion("services is null");
            return (Criteria) this;
        }

        public Criteria andServicesIsNotNull() {
            addCriterion("services is not null");
            return (Criteria) this;
        }

        public Criteria andServicesEqualTo(String value) {
            addCriterion("services =", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotEqualTo(String value) {
            addCriterion("services <>", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThan(String value) {
            addCriterion("services >", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesGreaterThanOrEqualTo(String value) {
            addCriterion("services >=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThan(String value) {
            addCriterion("services <", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLessThanOrEqualTo(String value) {
            addCriterion("services <=", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesLike(String value) {
            addCriterion("services like", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotLike(String value) {
            addCriterion("services not like", value, "services");
            return (Criteria) this;
        }

        public Criteria andServicesIn(List<String> values) {
            addCriterion("services in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotIn(List<String> values) {
            addCriterion("services not in", values, "services");
            return (Criteria) this;
        }

        public Criteria andServicesBetween(String value1, String value2) {
            addCriterion("services between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andServicesNotBetween(String value1, String value2) {
            addCriterion("services not between", value1, value2, "services");
            return (Criteria) this;
        }

        public Criteria andJoinSourceIsNull() {
            addCriterion("join_source is null");
            return (Criteria) this;
        }

        public Criteria andJoinSourceIsNotNull() {
            addCriterion("join_source is not null");
            return (Criteria) this;
        }

        public Criteria andJoinSourceEqualTo(Byte value) {
            addCriterion("join_source =", value, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceNotEqualTo(Byte value) {
            addCriterion("join_source <>", value, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceGreaterThan(Byte value) {
            addCriterion("join_source >", value, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("join_source >=", value, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceLessThan(Byte value) {
            addCriterion("join_source <", value, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceLessThanOrEqualTo(Byte value) {
            addCriterion("join_source <=", value, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceIn(List<Byte> values) {
            addCriterion("join_source in", values, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceNotIn(List<Byte> values) {
            addCriterion("join_source not in", values, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceBetween(Byte value1, Byte value2) {
            addCriterion("join_source between", value1, value2, "joinSource");
            return (Criteria) this;
        }

        public Criteria andJoinSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("join_source not between", value1, value2, "joinSource");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountIsNull() {
            addCriterion("extra_discount is null");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountIsNotNull() {
            addCriterion("extra_discount is not null");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountEqualTo(BigDecimal value) {
            addCriterion("extra_discount =", value, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountNotEqualTo(BigDecimal value) {
            addCriterion("extra_discount <>", value, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountGreaterThan(BigDecimal value) {
            addCriterion("extra_discount >", value, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("extra_discount >=", value, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountLessThan(BigDecimal value) {
            addCriterion("extra_discount <", value, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("extra_discount <=", value, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountIn(List<BigDecimal> values) {
            addCriterion("extra_discount in", values, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountNotIn(List<BigDecimal> values) {
            addCriterion("extra_discount not in", values, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("extra_discount between", value1, value2, "extraDiscount");
            return (Criteria) this;
        }

        public Criteria andExtraDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("extra_discount not between", value1, value2, "extraDiscount");
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