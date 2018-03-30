package com.microsilver.mrcard.serviceplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopMemberAdditionalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopMemberAdditionalExample() {
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

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIsNull() {
            addCriterion("alipay_account is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIsNotNull() {
            addCriterion("alipay_account is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountEqualTo(String value) {
            addCriterion("alipay_account =", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotEqualTo(String value) {
            addCriterion("alipay_account <>", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThan(String value) {
            addCriterion("alipay_account >", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_account >=", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThan(String value) {
            addCriterion("alipay_account <", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThanOrEqualTo(String value) {
            addCriterion("alipay_account <=", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLike(String value) {
            addCriterion("alipay_account like", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotLike(String value) {
            addCriterion("alipay_account not like", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIn(List<String> values) {
            addCriterion("alipay_account in", values, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotIn(List<String> values) {
            addCriterion("alipay_account not in", values, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountBetween(String value1, String value2) {
            addCriterion("alipay_account between", value1, value2, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotBetween(String value1, String value2) {
            addCriterion("alipay_account not between", value1, value2, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIsNull() {
            addCriterion("identity_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIsNotNull() {
            addCriterion("identity_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoEqualTo(String value) {
            addCriterion("identity_card_no =", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotEqualTo(String value) {
            addCriterion("identity_card_no <>", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoGreaterThan(String value) {
            addCriterion("identity_card_no >", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_no >=", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLessThan(String value) {
            addCriterion("identity_card_no <", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLessThanOrEqualTo(String value) {
            addCriterion("identity_card_no <=", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLike(String value) {
            addCriterion("identity_card_no like", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotLike(String value) {
            addCriterion("identity_card_no not like", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIn(List<String> values) {
            addCriterion("identity_card_no in", values, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotIn(List<String> values) {
            addCriterion("identity_card_no not in", values, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoBetween(String value1, String value2) {
            addCriterion("identity_card_no between", value1, value2, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotBetween(String value1, String value2) {
            addCriterion("identity_card_no not between", value1, value2, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontIsNull() {
            addCriterion("identity_card_front is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontIsNotNull() {
            addCriterion("identity_card_front is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontEqualTo(String value) {
            addCriterion("identity_card_front =", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotEqualTo(String value) {
            addCriterion("identity_card_front <>", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontGreaterThan(String value) {
            addCriterion("identity_card_front >", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_front >=", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontLessThan(String value) {
            addCriterion("identity_card_front <", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontLessThanOrEqualTo(String value) {
            addCriterion("identity_card_front <=", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontLike(String value) {
            addCriterion("identity_card_front like", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotLike(String value) {
            addCriterion("identity_card_front not like", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontIn(List<String> values) {
            addCriterion("identity_card_front in", values, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotIn(List<String> values) {
            addCriterion("identity_card_front not in", values, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontBetween(String value1, String value2) {
            addCriterion("identity_card_front between", value1, value2, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotBetween(String value1, String value2) {
            addCriterion("identity_card_front not between", value1, value2, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackIsNull() {
            addCriterion("identity_card_back is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackIsNotNull() {
            addCriterion("identity_card_back is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackEqualTo(String value) {
            addCriterion("identity_card_back =", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotEqualTo(String value) {
            addCriterion("identity_card_back <>", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackGreaterThan(String value) {
            addCriterion("identity_card_back >", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_back >=", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackLessThan(String value) {
            addCriterion("identity_card_back <", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackLessThanOrEqualTo(String value) {
            addCriterion("identity_card_back <=", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackLike(String value) {
            addCriterion("identity_card_back like", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotLike(String value) {
            addCriterion("identity_card_back not like", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackIn(List<String> values) {
            addCriterion("identity_card_back in", values, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotIn(List<String> values) {
            addCriterion("identity_card_back not in", values, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackBetween(String value1, String value2) {
            addCriterion("identity_card_back between", value1, value2, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotBetween(String value1, String value2) {
            addCriterion("identity_card_back not between", value1, value2, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupIsNull() {
            addCriterion("identity_card_group is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupIsNotNull() {
            addCriterion("identity_card_group is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupEqualTo(String value) {
            addCriterion("identity_card_group =", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotEqualTo(String value) {
            addCriterion("identity_card_group <>", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupGreaterThan(String value) {
            addCriterion("identity_card_group >", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_group >=", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupLessThan(String value) {
            addCriterion("identity_card_group <", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupLessThanOrEqualTo(String value) {
            addCriterion("identity_card_group <=", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupLike(String value) {
            addCriterion("identity_card_group like", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotLike(String value) {
            addCriterion("identity_card_group not like", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupIn(List<String> values) {
            addCriterion("identity_card_group in", values, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotIn(List<String> values) {
            addCriterion("identity_card_group not in", values, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupBetween(String value1, String value2) {
            addCriterion("identity_card_group between", value1, value2, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotBetween(String value1, String value2) {
            addCriterion("identity_card_group not between", value1, value2, "identityCardGroup");
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

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Byte value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Byte value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Byte value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Byte value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Byte value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Byte> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Byte> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Byte value1, Byte value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
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

        public Criteria andProvinceEqualTo(Long value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Long value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Long value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Long value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Long value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Long value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Long> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Long> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Long value1, Long value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Long value1, Long value2) {
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

        public Criteria andCityEqualTo(Long value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Long value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Long value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Long value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Long value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Long value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Long> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Long> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Long value1, Long value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Long value1, Long value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(Long value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(Long value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(Long value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(Long value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(Long value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(Long value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<Long> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<Long> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(Long value1, Long value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(Long value1, Long value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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