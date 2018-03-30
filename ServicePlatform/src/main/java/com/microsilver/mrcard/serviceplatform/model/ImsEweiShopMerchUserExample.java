package com.microsilver.mrcard.serviceplatform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopMerchUserExample {
    protected String orderByClause;

    protected boolean distinct;
    
    private String lat;
    private String lng;
	private Float startPrice;
	private Float endPrice;
	private String activity;
	private Float cashbackMax;
	


    public Float getCashbackMax() {
		return cashbackMax;
	}

	public void setCashbackMax(Float cashbackMax) {
		this.cashbackMax = cashbackMax;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Float getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Float startPrice) {
		this.startPrice = startPrice;
	}

	public Float getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Float endPrice) {
		this.endPrice = endPrice;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	protected List<Criteria> oredCriteria;

    public ImsEweiShopMerchUserExample() {
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

        public Criteria andRegidIsNull() {
            addCriterion("regid is null");
            return (Criteria) this;
        }

        public Criteria andRegidIsNotNull() {
            addCriterion("regid is not null");
            return (Criteria) this;
        }

        public Criteria andRegidEqualTo(Integer value) {
            addCriterion("regid =", value, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidNotEqualTo(Integer value) {
            addCriterion("regid <>", value, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidGreaterThan(Integer value) {
            addCriterion("regid >", value, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidGreaterThanOrEqualTo(Integer value) {
            addCriterion("regid >=", value, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidLessThan(Integer value) {
            addCriterion("regid <", value, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidLessThanOrEqualTo(Integer value) {
            addCriterion("regid <=", value, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidIn(List<Integer> values) {
            addCriterion("regid in", values, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidNotIn(List<Integer> values) {
            addCriterion("regid not in", values, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidBetween(Integer value1, Integer value2) {
            addCriterion("regid between", value1, value2, "regid");
            return (Criteria) this;
        }

        public Criteria andRegidNotBetween(Integer value1, Integer value2) {
            addCriterion("regid not between", value1, value2, "regid");
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

        public Criteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(Integer value) {
            addCriterion("groupid =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(Integer value) {
            addCriterion("groupid <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(Integer value) {
            addCriterion("groupid >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(Integer value) {
            addCriterion("groupid >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(Integer value) {
            addCriterion("groupid <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(Integer value) {
            addCriterion("groupid <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<Integer> values) {
            addCriterion("groupid in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<Integer> values) {
            addCriterion("groupid not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(Integer value1, Integer value2) {
            addCriterion("groupid between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(Integer value1, Integer value2) {
            addCriterion("groupid not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andMerchnoIsNull() {
            addCriterion("merchno is null");
            return (Criteria) this;
        }

        public Criteria andMerchnoIsNotNull() {
            addCriterion("merchno is not null");
            return (Criteria) this;
        }

        public Criteria andMerchnoEqualTo(String value) {
            addCriterion("merchno =", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotEqualTo(String value) {
            addCriterion("merchno <>", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoGreaterThan(String value) {
            addCriterion("merchno >", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoGreaterThanOrEqualTo(String value) {
            addCriterion("merchno >=", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLessThan(String value) {
            addCriterion("merchno <", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLessThanOrEqualTo(String value) {
            addCriterion("merchno <=", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLike(String value) {
            addCriterion("merchno like", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotLike(String value) {
            addCriterion("merchno not like", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoIn(List<String> values) {
            addCriterion("merchno in", values, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotIn(List<String> values) {
            addCriterion("merchno not in", values, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoBetween(String value1, String value2) {
            addCriterion("merchno between", value1, value2, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotBetween(String value1, String value2) {
            addCriterion("merchno not between", value1, value2, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnameIsNull() {
            addCriterion("merchname is null");
            return (Criteria) this;
        }

        public Criteria andMerchnameIsNotNull() {
            addCriterion("merchname is not null");
            return (Criteria) this;
        }

        public Criteria andMerchnameEqualTo(String value) {
            addCriterion("merchname =", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotEqualTo(String value) {
            addCriterion("merchname <>", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameGreaterThan(String value) {
            addCriterion("merchname >", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameGreaterThanOrEqualTo(String value) {
            addCriterion("merchname >=", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameLessThan(String value) {
            addCriterion("merchname <", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameLessThanOrEqualTo(String value) {
            addCriterion("merchname <=", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameLike(String value) {
            addCriterion("merchname like '%"+value+"%'");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotLike(String value) {
            addCriterion("merchname not like", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameIn(List<String> values) {
            addCriterion("merchname in", values, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotIn(List<String> values) {
            addCriterion("merchname not in", values, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameBetween(String value1, String value2) {
            addCriterion("merchname between", value1, value2, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotBetween(String value1, String value2) {
            addCriterion("merchname not between", value1, value2, "merchname");
            return (Criteria) this;
        }

        public Criteria andSalecateIsNull() {
            addCriterion("salecate is null");
            return (Criteria) this;
        }

        public Criteria andSalecateIsNotNull() {
            addCriterion("salecate is not null");
            return (Criteria) this;
        }

        public Criteria andSalecateEqualTo(String value) {
            addCriterion("salecate =", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateNotEqualTo(String value) {
            addCriterion("salecate <>", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateGreaterThan(String value) {
            addCriterion("salecate >", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateGreaterThanOrEqualTo(String value) {
            addCriterion("salecate >=", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateLessThan(String value) {
            addCriterion("salecate <", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateLessThanOrEqualTo(String value) {
            addCriterion("salecate <=", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateLike(String value) {
            addCriterion("salecate like", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateNotLike(String value) {
            addCriterion("salecate not like", value, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateIn(List<String> values) {
            addCriterion("salecate in", values, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateNotIn(List<String> values) {
            addCriterion("salecate not in", values, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateBetween(String value1, String value2) {
            addCriterion("salecate between", value1, value2, "salecate");
            return (Criteria) this;
        }

        public Criteria andSalecateNotBetween(String value1, String value2) {
            addCriterion("salecate not between", value1, value2, "salecate");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
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

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAccounttimeIsNull() {
            addCriterion("accounttime is null");
            return (Criteria) this;
        }

        public Criteria andAccounttimeIsNotNull() {
            addCriterion("accounttime is not null");
            return (Criteria) this;
        }

        public Criteria andAccounttimeEqualTo(Integer value) {
            addCriterion("accounttime =", value, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeNotEqualTo(Integer value) {
            addCriterion("accounttime <>", value, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeGreaterThan(Integer value) {
            addCriterion("accounttime >", value, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("accounttime >=", value, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeLessThan(Integer value) {
            addCriterion("accounttime <", value, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeLessThanOrEqualTo(Integer value) {
            addCriterion("accounttime <=", value, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeIn(List<Integer> values) {
            addCriterion("accounttime in", values, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeNotIn(List<Integer> values) {
            addCriterion("accounttime not in", values, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeBetween(Integer value1, Integer value2) {
            addCriterion("accounttime between", value1, value2, "accounttime");
            return (Criteria) this;
        }

        public Criteria andAccounttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("accounttime not between", value1, value2, "accounttime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Integer value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Integer value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Integer value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Integer value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Integer value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Integer> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Integer> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Integer value1, Integer value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Integer value1, Integer value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andAccounttotalIsNull() {
            addCriterion("accounttotal is null");
            return (Criteria) this;
        }

        public Criteria andAccounttotalIsNotNull() {
            addCriterion("accounttotal is not null");
            return (Criteria) this;
        }

        public Criteria andAccounttotalEqualTo(Integer value) {
            addCriterion("accounttotal =", value, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalNotEqualTo(Integer value) {
            addCriterion("accounttotal <>", value, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalGreaterThan(Integer value) {
            addCriterion("accounttotal >", value, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("accounttotal >=", value, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalLessThan(Integer value) {
            addCriterion("accounttotal <", value, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalLessThanOrEqualTo(Integer value) {
            addCriterion("accounttotal <=", value, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalIn(List<Integer> values) {
            addCriterion("accounttotal in", values, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalNotIn(List<Integer> values) {
            addCriterion("accounttotal not in", values, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalBetween(Integer value1, Integer value2) {
            addCriterion("accounttotal between", value1, value2, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andAccounttotalNotBetween(Integer value1, Integer value2) {
            addCriterion("accounttotal not between", value1, value2, "accounttotal");
            return (Criteria) this;
        }

        public Criteria andJointimeIsNull() {
            addCriterion("jointime is null");
            return (Criteria) this;
        }

        public Criteria andJointimeIsNotNull() {
            addCriterion("jointime is not null");
            return (Criteria) this;
        }

        public Criteria andJointimeEqualTo(Integer value) {
            addCriterion("jointime =", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotEqualTo(Integer value) {
            addCriterion("jointime <>", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeGreaterThan(Integer value) {
            addCriterion("jointime >", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jointime >=", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeLessThan(Integer value) {
            addCriterion("jointime <", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeLessThanOrEqualTo(Integer value) {
            addCriterion("jointime <=", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeIn(List<Integer> values) {
            addCriterion("jointime in", values, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotIn(List<Integer> values) {
            addCriterion("jointime not in", values, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeBetween(Integer value1, Integer value2) {
            addCriterion("jointime between", value1, value2, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotBetween(Integer value1, Integer value2) {
            addCriterion("jointime not between", value1, value2, "jointime");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNull() {
            addCriterion("accountid is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("accountid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(Integer value) {
            addCriterion("accountid =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(Integer value) {
            addCriterion("accountid <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(Integer value) {
            addCriterion("accountid >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("accountid >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(Integer value) {
            addCriterion("accountid <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("accountid <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<Integer> values) {
            addCriterion("accountid in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<Integer> values) {
            addCriterion("accountid not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(Integer value1, Integer value2) {
            addCriterion("accountid between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("accountid not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andPayopenidIsNull() {
            addCriterion("payopenid is null");
            return (Criteria) this;
        }

        public Criteria andPayopenidIsNotNull() {
            addCriterion("payopenid is not null");
            return (Criteria) this;
        }

        public Criteria andPayopenidEqualTo(String value) {
            addCriterion("payopenid =", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotEqualTo(String value) {
            addCriterion("payopenid <>", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidGreaterThan(String value) {
            addCriterion("payopenid >", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidGreaterThanOrEqualTo(String value) {
            addCriterion("payopenid >=", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidLessThan(String value) {
            addCriterion("payopenid <", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidLessThanOrEqualTo(String value) {
            addCriterion("payopenid <=", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidLike(String value) {
            addCriterion("payopenid like", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotLike(String value) {
            addCriterion("payopenid not like", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidIn(List<String> values) {
            addCriterion("payopenid in", values, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotIn(List<String> values) {
            addCriterion("payopenid not in", values, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidBetween(String value1, String value2) {
            addCriterion("payopenid between", value1, value2, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotBetween(String value1, String value2) {
            addCriterion("payopenid not between", value1, value2, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayrateIsNull() {
            addCriterion("payrate is null");
            return (Criteria) this;
        }

        public Criteria andPayrateIsNotNull() {
            addCriterion("payrate is not null");
            return (Criteria) this;
        }

        public Criteria andPayrateEqualTo(BigDecimal value) {
            addCriterion("payrate =", value, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateNotEqualTo(BigDecimal value) {
            addCriterion("payrate <>", value, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateGreaterThan(BigDecimal value) {
            addCriterion("payrate >", value, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payrate >=", value, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateLessThan(BigDecimal value) {
            addCriterion("payrate <", value, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payrate <=", value, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateIn(List<BigDecimal> values) {
            addCriterion("payrate in", values, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateNotIn(List<BigDecimal> values) {
            addCriterion("payrate not in", values, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payrate between", value1, value2, "payrate");
            return (Criteria) this;
        }

        public Criteria andPayrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payrate not between", value1, value2, "payrate");
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

        public Criteria andServicestagIsNull() {
            addCriterion("servicestag is null");
            return (Criteria) this;
        }

        public Criteria andServicestagIsNotNull() {
            addCriterion("servicestag is not null");
            return (Criteria) this;
        }

        public Criteria andServicestagEqualTo(String value) {
            addCriterion("servicestag =", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagNotEqualTo(String value) {
            addCriterion("servicestag <>", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagGreaterThan(String value) {
            addCriterion("servicestag >", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagGreaterThanOrEqualTo(String value) {
            addCriterion("servicestag >=", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagLessThan(String value) {
            addCriterion("servicestag <", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagLessThanOrEqualTo(String value) {
            addCriterion("servicestag <=", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagLike(String value) {
            addCriterion("servicestag like", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagNotLike(String value) {
            addCriterion("servicestag not like", value, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagIn(List<String> values) {
            addCriterion("servicestag in", values, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagNotIn(List<String> values) {
            addCriterion("servicestag not in", values, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagBetween(String value1, String value2) {
            addCriterion("servicestag between", value1, value2, "servicestag");
            return (Criteria) this;
        }

        public Criteria andServicestagNotBetween(String value1, String value2) {
            addCriterion("servicestag not between", value1, value2, "servicestag");
            return (Criteria) this;
        }

        public Criteria andCateidIsNull() {
            addCriterion("cateid is null");
            return (Criteria) this;
        }

        public Criteria andCateidIsNotNull() {
            addCriterion("cateid is not null");
            return (Criteria) this;
        }

        public Criteria andCateidEqualTo(Integer value) {
            addCriterion("cateid =", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotEqualTo(Integer value) {
            addCriterion("cateid <>", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThan(Integer value) {
            addCriterion("cateid >", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cateid >=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThan(Integer value) {
            addCriterion("cateid <", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThanOrEqualTo(Integer value) {
            addCriterion("cateid <=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidIn(List<Integer> values) {
            addCriterion("cateid in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotIn(List<Integer> values) {
            addCriterion("cateid not in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidBetween(Integer value1, Integer value2) {
            addCriterion("cateid between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotBetween(Integer value1, Integer value2) {
            addCriterion("cateid not between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Float value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Float value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Float value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Float value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Float value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Float value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Float> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Float> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Float value1, Float value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Float value1, Float value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsShopIsNull() {
            addCriterion("is_shop is null");
            return (Criteria) this;
        }

        public Criteria andIsShopIsNotNull() {
            addCriterion("is_shop is not null");
            return (Criteria) this;
        }

        public Criteria andIsShopEqualTo(Integer value) {
            addCriterion("is_shop =", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotEqualTo(Integer value) {
            addCriterion("is_shop <>", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopGreaterThan(Integer value) {
            addCriterion("is_shop >", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_shop >=", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopLessThan(Integer value) {
            addCriterion("is_shop <", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopLessThanOrEqualTo(Integer value) {
            addCriterion("is_shop <=", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopIn(List<Integer> values) {
            addCriterion("is_shop in", values, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotIn(List<Integer> values) {
            addCriterion("is_shop not in", values, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopBetween(Integer value1, Integer value2) {
            addCriterion("is_shop between", value1, value2, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_shop not between", value1, value2, "isShop");
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

        public Criteria andCodeEqualTo(Float value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Float value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Float value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Float value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Float value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Float value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Float> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Float> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Float value1, Float value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Float value1, Float value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andLv2IsNull() {
            addCriterion("lv2 is null");
            return (Criteria) this;
        }

        public Criteria andLv2IsNotNull() {
            addCriterion("lv2 is not null");
            return (Criteria) this;
        }

        public Criteria andLv2EqualTo(Integer value) {
            addCriterion("lv2 =", value, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2NotEqualTo(Integer value) {
            addCriterion("lv2 <>", value, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2GreaterThan(Integer value) {
            addCriterion("lv2 >", value, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2GreaterThanOrEqualTo(Integer value) {
            addCriterion("lv2 >=", value, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2LessThan(Integer value) {
            addCriterion("lv2 <", value, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2LessThanOrEqualTo(Integer value) {
            addCriterion("lv2 <=", value, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2In(List<Integer> values) {
            addCriterion("lv2 in", values, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2NotIn(List<Integer> values) {
            addCriterion("lv2 not in", values, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2Between(Integer value1, Integer value2) {
            addCriterion("lv2 between", value1, value2, "lv2");
            return (Criteria) this;
        }

        public Criteria andLv2NotBetween(Integer value1, Integer value2) {
            addCriterion("lv2 not between", value1, value2, "lv2");
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

        public Criteria andSendSmsIsNull() {
            addCriterion("send_sms is null");
            return (Criteria) this;
        }

        public Criteria andSendSmsIsNotNull() {
            addCriterion("send_sms is not null");
            return (Criteria) this;
        }

        public Criteria andSendSmsEqualTo(Long value) {
            addCriterion("send_sms =", value, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsNotEqualTo(Long value) {
            addCriterion("send_sms <>", value, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsGreaterThan(Long value) {
            addCriterion("send_sms >", value, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsGreaterThanOrEqualTo(Long value) {
            addCriterion("send_sms >=", value, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsLessThan(Long value) {
            addCriterion("send_sms <", value, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsLessThanOrEqualTo(Long value) {
            addCriterion("send_sms <=", value, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsIn(List<Long> values) {
            addCriterion("send_sms in", values, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsNotIn(List<Long> values) {
            addCriterion("send_sms not in", values, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsBetween(Long value1, Long value2) {
            addCriterion("send_sms between", value1, value2, "sendSms");
            return (Criteria) this;
        }

        public Criteria andSendSmsNotBetween(Long value1, Long value2) {
            addCriterion("send_sms not between", value1, value2, "sendSms");
            return (Criteria) this;
        }

        public Criteria andPic1IsNull() {
            addCriterion("pic1 is null");
            return (Criteria) this;
        }

        public Criteria andPic1IsNotNull() {
            addCriterion("pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andPic1EqualTo(String value) {
            addCriterion("pic1 =", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotEqualTo(String value) {
            addCriterion("pic1 <>", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThan(String value) {
            addCriterion("pic1 >", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThanOrEqualTo(String value) {
            addCriterion("pic1 >=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThan(String value) {
            addCriterion("pic1 <", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThanOrEqualTo(String value) {
            addCriterion("pic1 <=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Like(String value) {
            addCriterion("pic1 like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotLike(String value) {
            addCriterion("pic1 not like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1In(List<String> values) {
            addCriterion("pic1 in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotIn(List<String> values) {
            addCriterion("pic1 not in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Between(String value1, String value2) {
            addCriterion("pic1 between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotBetween(String value1, String value2) {
            addCriterion("pic1 not between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic2IsNull() {
            addCriterion("pic2 is null");
            return (Criteria) this;
        }

        public Criteria andPic2IsNotNull() {
            addCriterion("pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andPic2EqualTo(String value) {
            addCriterion("pic2 =", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotEqualTo(String value) {
            addCriterion("pic2 <>", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThan(String value) {
            addCriterion("pic2 >", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThanOrEqualTo(String value) {
            addCriterion("pic2 >=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThan(String value) {
            addCriterion("pic2 <", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThanOrEqualTo(String value) {
            addCriterion("pic2 <=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Like(String value) {
            addCriterion("pic2 like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotLike(String value) {
            addCriterion("pic2 not like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2In(List<String> values) {
            addCriterion("pic2 in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotIn(List<String> values) {
            addCriterion("pic2 not in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Between(String value1, String value2) {
            addCriterion("pic2 between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotBetween(String value1, String value2) {
            addCriterion("pic2 not between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("referee is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("referee is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(Long value) {
            addCriterion("referee =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(Long value) {
            addCriterion("referee <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(Long value) {
            addCriterion("referee >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(Long value) {
            addCriterion("referee >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(Long value) {
            addCriterion("referee <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(Long value) {
            addCriterion("referee <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<Long> values) {
            addCriterion("referee in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<Long> values) {
            addCriterion("referee not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(Long value1, Long value2) {
            addCriterion("referee between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(Long value1, Long value2) {
            addCriterion("referee not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(Integer value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(Integer value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(Integer value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(Integer value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<Integer> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<Integer> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(Integer value1, Integer value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeIsNull() {
            addCriterion("pantnr_type is null");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeIsNotNull() {
            addCriterion("pantnr_type is not null");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeEqualTo(Integer value) {
            addCriterion("pantnr_type =", value, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeNotEqualTo(Integer value) {
            addCriterion("pantnr_type <>", value, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeGreaterThan(Integer value) {
            addCriterion("pantnr_type >", value, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pantnr_type >=", value, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeLessThan(Integer value) {
            addCriterion("pantnr_type <", value, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pantnr_type <=", value, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeIn(List<Integer> values) {
            addCriterion("pantnr_type in", values, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeNotIn(List<Integer> values) {
            addCriterion("pantnr_type not in", values, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeBetween(Integer value1, Integer value2) {
            addCriterion("pantnr_type between", value1, value2, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andPantnrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pantnr_type not between", value1, value2, "pantnrType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
        
        public Criteria andLowestPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("lowest_price >=", value, "lowestPrice");
            return (Criteria) this;
        }
        
        public Criteria andLowestPriceGreaterThan(Float value) {
            addCriterion("lowest_price >", value, "lowestPrice");
            return (Criteria) this;
        }
        
        public Criteria andLowestPriceLessThanOrEqualTo(Float value) {
            addCriterion("lowest_price <=", value, "lowestPrice");
            return (Criteria) this;
        }
        public Criteria andStarLevelEqualTo(Byte value) {
            addCriterion("star_level =", value, "starLevel");
            return (Criteria) this;
        } 
        public Criteria andStarLevelIn(List<Integer> values) {
            addCriterion("star_level in", values, "starLevel");
            return (Criteria) this;
        }
        public Criteria findServicestag(String value) {
            addCriterion("FIND_IN_SET('"+value+"',servicestag)");
            return (Criteria) this;
        } 
        public Criteria andCashBackMaxGreatThan(Float value) {
            addCriterion("cashback_max >", value, "cashbackMax");
            return (Criteria) this;
        } 
        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
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