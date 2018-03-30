package com.microsilver.mrcard.scheduledtask.model;

import java.util.ArrayList;
import java.util.List;

public class ImsEweiShopMemberIdentityExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ImsEweiShopMemberIdentityExample() {
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

		public Criteria andIdentityIsNull() {
			addCriterion("identity is null");
			return (Criteria) this;
		}

		public Criteria andIdentityIsNotNull() {
			addCriterion("identity is not null");
			return (Criteria) this;
		}

		public Criteria andIdentityEqualTo(Byte value) {
			addCriterion("identity =", value, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityNotEqualTo(Byte value) {
			addCriterion("identity <>", value, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityGreaterThan(Byte value) {
			addCriterion("identity >", value, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityGreaterThanOrEqualTo(Byte value) {
			addCriterion("identity >=", value, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityLessThan(Byte value) {
			addCriterion("identity <", value, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityLessThanOrEqualTo(Byte value) {
			addCriterion("identity <=", value, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityIn(List<Byte> values) {
			addCriterion("identity in", values, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityOr(Integer value1, Integer value2) {
			addCriterion("(identity = " + value1 + " or identity = " + value2 + ")");
			return (Criteria) this;
		}

		public Criteria andIdentityNotIn(List<Byte> values) {
			addCriterion("identity not in", values, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityBetween(Byte value1, Byte value2) {
			addCriterion("identity between", value1, value2, "identity");
			return (Criteria) this;
		}

		public Criteria andIdentityNotBetween(Byte value1, Byte value2) {
			addCriterion("identity not between", value1, value2, "identity");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createTime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createTime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Integer value) {
			addCriterion("createTime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Integer value) {
			addCriterion("createTime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Integer value) {
			addCriterion("createTime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("createTime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Integer value) {
			addCriterion("createTime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Integer value) {
			addCriterion("createTime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Integer> values) {
			addCriterion("createTime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Integer> values) {
			addCriterion("createTime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Integer value1, Integer value2) {
			addCriterion("createTime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Integer value1, Integer value2) {
			addCriterion("createTime not between", value1, value2, "createtime");
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

		public Criteria andParentIdIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(Long value) {
			addCriterion("parent_id =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(Long value) {
			addCriterion("parent_id <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(Long value) {
			addCriterion("parent_id >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("parent_id >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(Long value) {
			addCriterion("parent_id <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(Long value) {
			addCriterion("parent_id <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<Long> values) {
			addCriterion("parent_id in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<Long> values) {
			addCriterion("parent_id not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(Long value1, Long value2) {
			addCriterion("parent_id between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(Long value1, Long value2) {
			addCriterion("parent_id not between", value1, value2, "parentId");
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

		public Criteria andAreasIsNull() {
			addCriterion("areas is null");
			return (Criteria) this;
		}

		public Criteria andAreasIsNotNull() {
			addCriterion("areas is not null");
			return (Criteria) this;
		}

		public Criteria andAreasEqualTo(String value) {
			addCriterion("areas =", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasNotEqualTo(String value) {
			addCriterion("areas <>", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasGreaterThan(String value) {
			addCriterion("areas >", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasGreaterThanOrEqualTo(String value) {
			addCriterion("areas >=", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasLessThan(String value) {
			addCriterion("areas <", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasLessThanOrEqualTo(String value) {
			addCriterion("areas <=", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasLike(String value) {
			addCriterion("areas like", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasNotLike(String value) {
			addCriterion("areas not like", value, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasIn(List<String> values) {
			addCriterion("areas in", values, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasNotIn(List<String> values) {
			addCriterion("areas not in", values, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasBetween(String value1, String value2) {
			addCriterion("areas between", value1, value2, "areas");
			return (Criteria) this;
		}

		public Criteria andAreasNotBetween(String value1, String value2) {
			addCriterion("areas not between", value1, value2, "areas");
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