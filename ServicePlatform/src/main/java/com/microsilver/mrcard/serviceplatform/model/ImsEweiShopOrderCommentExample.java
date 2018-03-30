package com.microsilver.mrcard.serviceplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopOrderCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsEweiShopOrderCommentExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNull() {
            addCriterion("headimgurl is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNotNull() {
            addCriterion("headimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlEqualTo(String value) {
            addCriterion("headimgurl =", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotEqualTo(String value) {
            addCriterion("headimgurl <>", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThan(String value) {
            addCriterion("headimgurl >", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("headimgurl >=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThan(String value) {
            addCriterion("headimgurl <", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThanOrEqualTo(String value) {
            addCriterion("headimgurl <=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLike(String value) {
            addCriterion("headimgurl like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotLike(String value) {
            addCriterion("headimgurl not like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIn(List<String> values) {
            addCriterion("headimgurl in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotIn(List<String> values) {
            addCriterion("headimgurl not in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlBetween(String value1, String value2) {
            addCriterion("headimgurl between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotBetween(String value1, String value2) {
            addCriterion("headimgurl not between", value1, value2, "headimgurl");
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

        public Criteria andLevelEqualTo(Float value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Float value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Float value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Float value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Float value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Float value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Float> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Float> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Float value1, Float value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Float value1, Float value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("images is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("images is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String value) {
            addCriterion("images =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String value) {
            addCriterion("images <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String value) {
            addCriterion("images >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            addCriterion("images >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String value) {
            addCriterion("images <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            addCriterion("images <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLike(String value) {
            addCriterion("images like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String value) {
            addCriterion("images not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String> values) {
            addCriterion("images in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String> values) {
            addCriterion("images not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String value1, String value2) {
            addCriterion("images between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            addCriterion("images not between", value1, value2, "images");
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

        public Criteria andAppendContentIsNull() {
            addCriterion("append_content is null");
            return (Criteria) this;
        }

        public Criteria andAppendContentIsNotNull() {
            addCriterion("append_content is not null");
            return (Criteria) this;
        }

        public Criteria andAppendContentEqualTo(String value) {
            addCriterion("append_content =", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentNotEqualTo(String value) {
            addCriterion("append_content <>", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentGreaterThan(String value) {
            addCriterion("append_content >", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentGreaterThanOrEqualTo(String value) {
            addCriterion("append_content >=", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentLessThan(String value) {
            addCriterion("append_content <", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentLessThanOrEqualTo(String value) {
            addCriterion("append_content <=", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentLike(String value) {
            addCriterion("append_content like", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentNotLike(String value) {
            addCriterion("append_content not like", value, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentIn(List<String> values) {
            addCriterion("append_content in", values, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentNotIn(List<String> values) {
            addCriterion("append_content not in", values, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentBetween(String value1, String value2) {
            addCriterion("append_content between", value1, value2, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendContentNotBetween(String value1, String value2) {
            addCriterion("append_content not between", value1, value2, "appendContent");
            return (Criteria) this;
        }

        public Criteria andAppendImagesIsNull() {
            addCriterion("append_images is null");
            return (Criteria) this;
        }

        public Criteria andAppendImagesIsNotNull() {
            addCriterion("append_images is not null");
            return (Criteria) this;
        }

        public Criteria andAppendImagesEqualTo(String value) {
            addCriterion("append_images =", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesNotEqualTo(String value) {
            addCriterion("append_images <>", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesGreaterThan(String value) {
            addCriterion("append_images >", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesGreaterThanOrEqualTo(String value) {
            addCriterion("append_images >=", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesLessThan(String value) {
            addCriterion("append_images <", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesLessThanOrEqualTo(String value) {
            addCriterion("append_images <=", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesLike(String value) {
            addCriterion("append_images like", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesNotLike(String value) {
            addCriterion("append_images not like", value, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesIn(List<String> values) {
            addCriterion("append_images in", values, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesNotIn(List<String> values) {
            addCriterion("append_images not in", values, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesBetween(String value1, String value2) {
            addCriterion("append_images between", value1, value2, "appendImages");
            return (Criteria) this;
        }

        public Criteria andAppendImagesNotBetween(String value1, String value2) {
            addCriterion("append_images not between", value1, value2, "appendImages");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("reply_content =", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("reply_content >", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("reply_content <", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLike(String value) {
            addCriterion("reply_content like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("reply_content not like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(List<String> values) {
            addCriterion("reply_content in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(List<String> values) {
            addCriterion("reply_content not in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyImagesIsNull() {
            addCriterion("reply_images is null");
            return (Criteria) this;
        }

        public Criteria andReplyImagesIsNotNull() {
            addCriterion("reply_images is not null");
            return (Criteria) this;
        }

        public Criteria andReplyImagesEqualTo(String value) {
            addCriterion("reply_images =", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesNotEqualTo(String value) {
            addCriterion("reply_images <>", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesGreaterThan(String value) {
            addCriterion("reply_images >", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesGreaterThanOrEqualTo(String value) {
            addCriterion("reply_images >=", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesLessThan(String value) {
            addCriterion("reply_images <", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesLessThanOrEqualTo(String value) {
            addCriterion("reply_images <=", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesLike(String value) {
            addCriterion("reply_images like", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesNotLike(String value) {
            addCriterion("reply_images not like", value, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesIn(List<String> values) {
            addCriterion("reply_images in", values, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesNotIn(List<String> values) {
            addCriterion("reply_images not in", values, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesBetween(String value1, String value2) {
            addCriterion("reply_images between", value1, value2, "replyImages");
            return (Criteria) this;
        }

        public Criteria andReplyImagesNotBetween(String value1, String value2) {
            addCriterion("reply_images not between", value1, value2, "replyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentIsNull() {
            addCriterion("append_reply_content is null");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentIsNotNull() {
            addCriterion("append_reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentEqualTo(String value) {
            addCriterion("append_reply_content =", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentNotEqualTo(String value) {
            addCriterion("append_reply_content <>", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentGreaterThan(String value) {
            addCriterion("append_reply_content >", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("append_reply_content >=", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentLessThan(String value) {
            addCriterion("append_reply_content <", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentLessThanOrEqualTo(String value) {
            addCriterion("append_reply_content <=", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentLike(String value) {
            addCriterion("append_reply_content like", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentNotLike(String value) {
            addCriterion("append_reply_content not like", value, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentIn(List<String> values) {
            addCriterion("append_reply_content in", values, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentNotIn(List<String> values) {
            addCriterion("append_reply_content not in", values, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentBetween(String value1, String value2) {
            addCriterion("append_reply_content between", value1, value2, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyContentNotBetween(String value1, String value2) {
            addCriterion("append_reply_content not between", value1, value2, "appendReplyContent");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesIsNull() {
            addCriterion("append_reply_images is null");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesIsNotNull() {
            addCriterion("append_reply_images is not null");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesEqualTo(String value) {
            addCriterion("append_reply_images =", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesNotEqualTo(String value) {
            addCriterion("append_reply_images <>", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesGreaterThan(String value) {
            addCriterion("append_reply_images >", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesGreaterThanOrEqualTo(String value) {
            addCriterion("append_reply_images >=", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesLessThan(String value) {
            addCriterion("append_reply_images <", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesLessThanOrEqualTo(String value) {
            addCriterion("append_reply_images <=", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesLike(String value) {
            addCriterion("append_reply_images like", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesNotLike(String value) {
            addCriterion("append_reply_images not like", value, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesIn(List<String> values) {
            addCriterion("append_reply_images in", values, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesNotIn(List<String> values) {
            addCriterion("append_reply_images not in", values, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesBetween(String value1, String value2) {
            addCriterion("append_reply_images between", value1, value2, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andAppendReplyImagesNotBetween(String value1, String value2) {
            addCriterion("append_reply_images not between", value1, value2, "appendReplyImages");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("istop is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("istop is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(Byte value) {
            addCriterion("istop =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(Byte value) {
            addCriterion("istop <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(Byte value) {
            addCriterion("istop >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(Byte value) {
            addCriterion("istop >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(Byte value) {
            addCriterion("istop <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(Byte value) {
            addCriterion("istop <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<Byte> values) {
            addCriterion("istop in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<Byte> values) {
            addCriterion("istop not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(Byte value1, Byte value2) {
            addCriterion("istop between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(Byte value1, Byte value2) {
            addCriterion("istop not between", value1, value2, "istop");
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

        public Criteria andReplycheckedIsNull() {
            addCriterion("replychecked is null");
            return (Criteria) this;
        }

        public Criteria andReplycheckedIsNotNull() {
            addCriterion("replychecked is not null");
            return (Criteria) this;
        }

        public Criteria andReplycheckedEqualTo(Byte value) {
            addCriterion("replychecked =", value, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedNotEqualTo(Byte value) {
            addCriterion("replychecked <>", value, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedGreaterThan(Byte value) {
            addCriterion("replychecked >", value, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedGreaterThanOrEqualTo(Byte value) {
            addCriterion("replychecked >=", value, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedLessThan(Byte value) {
            addCriterion("replychecked <", value, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedLessThanOrEqualTo(Byte value) {
            addCriterion("replychecked <=", value, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedIn(List<Byte> values) {
            addCriterion("replychecked in", values, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedNotIn(List<Byte> values) {
            addCriterion("replychecked not in", values, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedBetween(Byte value1, Byte value2) {
            addCriterion("replychecked between", value1, value2, "replychecked");
            return (Criteria) this;
        }

        public Criteria andReplycheckedNotBetween(Byte value1, Byte value2) {
            addCriterion("replychecked not between", value1, value2, "replychecked");
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

        public Criteria andMerchidEqualTo(Long value) {
            addCriterion("merchid =", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidNotEqualTo(Long value) {
            addCriterion("merchid <>", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidGreaterThan(Long value) {
            addCriterion("merchid >", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidGreaterThanOrEqualTo(Long value) {
            addCriterion("merchid >=", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidLessThan(Long value) {
            addCriterion("merchid <", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidLessThanOrEqualTo(Long value) {
            addCriterion("merchid <=", value, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidIn(List<Long> values) {
            addCriterion("merchid in", values, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidNotIn(List<Long> values) {
            addCriterion("merchid not in", values, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidBetween(Long value1, Long value2) {
            addCriterion("merchid between", value1, value2, "merchid");
            return (Criteria) this;
        }

        public Criteria andMerchidNotBetween(Long value1, Long value2) {
            addCriterion("merchid not between", value1, value2, "merchid");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberid is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Long value) {
            addCriterion("memberid =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Long value) {
            addCriterion("memberid <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Long value) {
            addCriterion("memberid >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Long value) {
            addCriterion("memberid >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Long value) {
            addCriterion("memberid <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Long value) {
            addCriterion("memberid <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Long> values) {
            addCriterion("memberid in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Long> values) {
            addCriterion("memberid not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Long value1, Long value2) {
            addCriterion("memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Long value1, Long value2) {
            addCriterion("memberid not between", value1, value2, "memberid");
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