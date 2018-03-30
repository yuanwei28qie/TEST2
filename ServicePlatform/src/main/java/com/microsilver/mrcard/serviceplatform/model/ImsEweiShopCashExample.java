package com.microsilver.mrcard.serviceplatform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopCashExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopCashExample() {
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

        public Criteria andMerchidIsNull() {
            addCriterion("merchId is null");
            return (Criteria) this;
        }

        public Criteria andMerchidIsNotNull() {
            addCriterion("merchId is not null");
            return (Criteria) this;
        }

        public Criteria andMerchidEqualTo(Long value) {
            addCriterion("merchId =", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidNotEqualTo(Long value) {
            addCriterion("merchId <>", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidGreaterThan(Long value) {
            addCriterion("merchId >", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidGreaterThanOrEqualTo(Long value) {
            addCriterion("merchId >=", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidLessThan(Long value) {
            addCriterion("merchId <", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidLessThanOrEqualTo(Long value) {
            addCriterion("merchId <=", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidIn(List<Long> values) {
            addCriterion("merchId in", values, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidNotIn(List<Long> values) {
            addCriterion("merchId not in", values, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidBetween(Long value1, Long value2) {
            addCriterion("merchId between", value1, value2, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidNotBetween(Long value1, Long value2) {
            addCriterion("merchId not between", value1, value2, "merchid");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNull() {
            addCriterion("bankname is null");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNotNull() {
            addCriterion("bankname is not null");
            return (Criteria) this;
        }

        public Criteria andBanknameEqualTo(String value) {
            addCriterion("bankname =", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotEqualTo(String value) {
            addCriterion("bankname <>", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThan(String value) {
            addCriterion("bankname >", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThanOrEqualTo(String value) {
            addCriterion("bankname >=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThan(String value) {
            addCriterion("bankname <", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThanOrEqualTo(String value) {
            addCriterion("bankname <=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLike(String value) {
            addCriterion("bankname like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotLike(String value) {
            addCriterion("bankname not like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameIn(List<String> values) {
            addCriterion("bankname in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotIn(List<String> values) {
            addCriterion("bankname not in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameBetween(String value1, String value2) {
            addCriterion("bankname between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotBetween(String value1, String value2) {
            addCriterion("bankname not between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andBankcardIsNull() {
            addCriterion("bankcard is null");
            return (Criteria) this;
        }

        public Criteria andBankcardIsNotNull() {
            addCriterion("bankcard is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardEqualTo(String value) {
            addCriterion("bankcard =", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotEqualTo(String value) {
            addCriterion("bankcard <>", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardGreaterThan(String value) {
            addCriterion("bankcard >", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardGreaterThanOrEqualTo(String value) {
            addCriterion("bankcard >=", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardLessThan(String value) {
            addCriterion("bankcard <", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardLessThanOrEqualTo(String value) {
            addCriterion("bankcard <=", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardLike(String value) {
            addCriterion("bankcard like", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotLike(String value) {
            addCriterion("bankcard not like", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardIn(List<String> values) {
            addCriterion("bankcard in", values, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotIn(List<String> values) {
            addCriterion("bankcard not in", values, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardBetween(String value1, String value2) {
            addCriterion("bankcard between", value1, value2, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotBetween(String value1, String value2) {
            addCriterion("bankcard not between", value1, value2, "bankcard");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNull() {
            addCriterion("truename is null");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNotNull() {
            addCriterion("truename is not null");
            return (Criteria) this;
        }

        public Criteria andTruenameEqualTo(String value) {
            addCriterion("truename =", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotEqualTo(String value) {
            addCriterion("truename <>", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThan(String value) {
            addCriterion("truename >", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("truename >=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThan(String value) {
            addCriterion("truename <", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThanOrEqualTo(String value) {
            addCriterion("truename <=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLike(String value) {
            addCriterion("truename like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotLike(String value) {
            addCriterion("truename not like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameIn(List<String> values) {
            addCriterion("truename in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotIn(List<String> values) {
            addCriterion("truename not in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameBetween(String value1, String value2) {
            addCriterion("truename between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotBetween(String value1, String value2) {
            addCriterion("truename not between", value1, value2, "truename");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andCreatetimeEqualTo(Long value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Long value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Long value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Long value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Long value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Long> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Long> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Long value1, Long value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Long value1, Long value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeIsNull() {
            addCriterion("finshtime is null");
            return (Criteria) this;
        }

        public Criteria andFinshtimeIsNotNull() {
            addCriterion("finshtime is not null");
            return (Criteria) this;
        }

        public Criteria andFinshtimeEqualTo(Long value) {
            addCriterion("finshtime =", value, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeNotEqualTo(Long value) {
            addCriterion("finshtime <>", value, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeGreaterThan(Long value) {
            addCriterion("finshtime >", value, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("finshtime >=", value, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeLessThan(Long value) {
            addCriterion("finshtime <", value, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeLessThanOrEqualTo(Long value) {
            addCriterion("finshtime <=", value, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeIn(List<Long> values) {
            addCriterion("finshtime in", values, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeNotIn(List<Long> values) {
            addCriterion("finshtime not in", values, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeBetween(Long value1, Long value2) {
            addCriterion("finshtime between", value1, value2, "finshtime");
            return (Criteria) this;
        }

        public Criteria andFinshtimeNotBetween(Long value1, Long value2) {
            addCriterion("finshtime not between", value1, value2, "finshtime");
            return (Criteria) this;
        }

        public Criteria andMoneysIsNull() {
            addCriterion("moneys is null");
            return (Criteria) this;
        }

        public Criteria andMoneysIsNotNull() {
            addCriterion("moneys is not null");
            return (Criteria) this;
        }

        public Criteria andMoneysEqualTo(BigDecimal value) {
            addCriterion("moneys =", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysNotEqualTo(BigDecimal value) {
            addCriterion("moneys <>", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysGreaterThan(BigDecimal value) {
            addCriterion("moneys >", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("moneys >=", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysLessThan(BigDecimal value) {
            addCriterion("moneys <", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("moneys <=", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysIn(List<BigDecimal> values) {
            addCriterion("moneys in", values, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysNotIn(List<BigDecimal> values) {
            addCriterion("moneys not in", values, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("moneys between", value1, value2, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("moneys not between", value1, value2, "moneys");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andPayratesIsNull() {
            addCriterion("payrates is null");
            return (Criteria) this;
        }

        public Criteria andPayratesIsNotNull() {
            addCriterion("payrates is not null");
            return (Criteria) this;
        }

        public Criteria andPayratesEqualTo(Integer value) {
            addCriterion("payrates =", value, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesNotEqualTo(Integer value) {
            addCriterion("payrates <>", value, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesGreaterThan(Integer value) {
            addCriterion("payrates >", value, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesGreaterThanOrEqualTo(Integer value) {
            addCriterion("payrates >=", value, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesLessThan(Integer value) {
            addCriterion("payrates <", value, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesLessThanOrEqualTo(Integer value) {
            addCriterion("payrates <=", value, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesIn(List<Integer> values) {
            addCriterion("payrates in", values, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesNotIn(List<Integer> values) {
            addCriterion("payrates not in", values, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesBetween(Integer value1, Integer value2) {
            addCriterion("payrates between", value1, value2, "payrates");
            return (Criteria) this;
        }

        public Criteria andPayratesNotBetween(Integer value1, Integer value2) {
            addCriterion("payrates not between", value1, value2, "payrates");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Long value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Long value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Long value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Long value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Long value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Long value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Long> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Long> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Long value1, Long value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Long value1, Long value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andCashTypeIsNull() {
            addCriterion("cash_type is null");
            return (Criteria) this;
        }

        public Criteria andCashTypeIsNotNull() {
            addCriterion("cash_type is not null");
            return (Criteria) this;
        }

        public Criteria andCashTypeEqualTo(Integer value) {
            addCriterion("cash_type =", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeNotEqualTo(Integer value) {
            addCriterion("cash_type <>", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeGreaterThan(Integer value) {
            addCriterion("cash_type >", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cash_type >=", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeLessThan(Integer value) {
            addCriterion("cash_type <", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cash_type <=", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeIn(List<Integer> values) {
            addCriterion("cash_type in", values, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeNotIn(List<Integer> values) {
            addCriterion("cash_type not in", values, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeBetween(Integer value1, Integer value2) {
            addCriterion("cash_type between", value1, value2, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cash_type not between", value1, value2, "cashType");
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