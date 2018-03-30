package com.microsilver.mrcard.cloud.finance.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MrcardFinanceSettlementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MrcardFinanceSettlementExample() {
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

        public Criteria andSettlementsnIsNull() {
            addCriterion("settlementsn is null");
            return (Criteria) this;
        }

        public Criteria andSettlementsnIsNotNull() {
            addCriterion("settlementsn is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementsnEqualTo(String value) {
            addCriterion("settlementsn =", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnNotEqualTo(String value) {
            addCriterion("settlementsn <>", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnGreaterThan(String value) {
            addCriterion("settlementsn >", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnGreaterThanOrEqualTo(String value) {
            addCriterion("settlementsn >=", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnLessThan(String value) {
            addCriterion("settlementsn <", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnLessThanOrEqualTo(String value) {
            addCriterion("settlementsn <=", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnLike(String value) {
            addCriterion("settlementsn like", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnNotLike(String value) {
            addCriterion("settlementsn not like", value, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnIn(List<String> values) {
            addCriterion("settlementsn in", values, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnNotIn(List<String> values) {
            addCriterion("settlementsn not in", values, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnBetween(String value1, String value2) {
            addCriterion("settlementsn between", value1, value2, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andSettlementsnNotBetween(String value1, String value2) {
            addCriterion("settlementsn not between", value1, value2, "settlementsn");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNull() {
            addCriterion("finance_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("finance_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(Long value) {
            addCriterion("finance_id =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(Long value) {
            addCriterion("finance_id <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(Long value) {
            addCriterion("finance_id >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("finance_id >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(Long value) {
            addCriterion("finance_id <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(Long value) {
            addCriterion("finance_id <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<Long> values) {
            addCriterion("finance_id in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<Long> values) {
            addCriterion("finance_id not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(Long value1, Long value2) {
            addCriterion("finance_id between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(Long value1, Long value2) {
            addCriterion("finance_id not between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginIsNull() {
            addCriterion("account_period_begin is null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginIsNotNull() {
            addCriterion("account_period_begin is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginEqualTo(Integer value) {
            addCriterion("account_period_begin =", value, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginNotEqualTo(Integer value) {
            addCriterion("account_period_begin <>", value, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginGreaterThan(Integer value) {
            addCriterion("account_period_begin >", value, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_period_begin >=", value, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginLessThan(Integer value) {
            addCriterion("account_period_begin <", value, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginLessThanOrEqualTo(Integer value) {
            addCriterion("account_period_begin <=", value, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginIn(List<Integer> values) {
            addCriterion("account_period_begin in", values, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginNotIn(List<Integer> values) {
            addCriterion("account_period_begin not in", values, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginBetween(Integer value1, Integer value2) {
            addCriterion("account_period_begin between", value1, value2, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodBeginNotBetween(Integer value1, Integer value2) {
            addCriterion("account_period_begin not between", value1, value2, "accountPeriodBegin");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndIsNull() {
            addCriterion("account_period_end is null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndIsNotNull() {
            addCriterion("account_period_end is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndEqualTo(Integer value) {
            addCriterion("account_period_end =", value, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndNotEqualTo(Integer value) {
            addCriterion("account_period_end <>", value, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndGreaterThan(Integer value) {
            addCriterion("account_period_end >", value, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_period_end >=", value, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndLessThan(Integer value) {
            addCriterion("account_period_end <", value, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndLessThanOrEqualTo(Integer value) {
            addCriterion("account_period_end <=", value, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndIn(List<Integer> values) {
            addCriterion("account_period_end in", values, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndNotIn(List<Integer> values) {
            addCriterion("account_period_end not in", values, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndBetween(Integer value1, Integer value2) {
            addCriterion("account_period_end between", value1, value2, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAccountPeriodEndNotBetween(Integer value1, Integer value2) {
            addCriterion("account_period_end not between", value1, value2, "accountPeriodEnd");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountIsNull() {
            addCriterion("advance_amount is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountIsNotNull() {
            addCriterion("advance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountEqualTo(BigDecimal value) {
            addCriterion("advance_amount =", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountNotEqualTo(BigDecimal value) {
            addCriterion("advance_amount <>", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountGreaterThan(BigDecimal value) {
            addCriterion("advance_amount >", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("advance_amount >=", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountLessThan(BigDecimal value) {
            addCriterion("advance_amount <", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("advance_amount <=", value, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountIn(List<BigDecimal> values) {
            addCriterion("advance_amount in", values, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountNotIn(List<BigDecimal> values) {
            addCriterion("advance_amount not in", values, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advance_amount between", value1, value2, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advance_amount not between", value1, value2, "advanceAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountIsNull() {
            addCriterion("dispatch_amount is null");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountIsNotNull() {
            addCriterion("dispatch_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountEqualTo(BigDecimal value) {
            addCriterion("dispatch_amount =", value, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountNotEqualTo(BigDecimal value) {
            addCriterion("dispatch_amount <>", value, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountGreaterThan(BigDecimal value) {
            addCriterion("dispatch_amount >", value, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dispatch_amount >=", value, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountLessThan(BigDecimal value) {
            addCriterion("dispatch_amount <", value, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dispatch_amount <=", value, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountIn(List<BigDecimal> values) {
            addCriterion("dispatch_amount in", values, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountNotIn(List<BigDecimal> values) {
            addCriterion("dispatch_amount not in", values, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispatch_amount between", value1, value2, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispatch_amount not between", value1, value2, "dispatchAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountIsNull() {
            addCriterion("tip_amount is null");
            return (Criteria) this;
        }

        public Criteria andTipAmountIsNotNull() {
            addCriterion("tip_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTipAmountEqualTo(BigDecimal value) {
            addCriterion("tip_amount =", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountNotEqualTo(BigDecimal value) {
            addCriterion("tip_amount <>", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountGreaterThan(BigDecimal value) {
            addCriterion("tip_amount >", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tip_amount >=", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountLessThan(BigDecimal value) {
            addCriterion("tip_amount <", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tip_amount <=", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountIn(List<BigDecimal> values) {
            addCriterion("tip_amount in", values, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountNotIn(List<BigDecimal> values) {
            addCriterion("tip_amount not in", values, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tip_amount between", value1, value2, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tip_amount not between", value1, value2, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountIsNull() {
            addCriterion("pumping_amount is null");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountIsNotNull() {
            addCriterion("pumping_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountEqualTo(BigDecimal value) {
            addCriterion("pumping_amount =", value, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountNotEqualTo(BigDecimal value) {
            addCriterion("pumping_amount <>", value, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountGreaterThan(BigDecimal value) {
            addCriterion("pumping_amount >", value, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pumping_amount >=", value, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountLessThan(BigDecimal value) {
            addCriterion("pumping_amount <", value, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pumping_amount <=", value, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountIn(List<BigDecimal> values) {
            addCriterion("pumping_amount in", values, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountNotIn(List<BigDecimal> values) {
            addCriterion("pumping_amount not in", values, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pumping_amount between", value1, value2, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andPumpingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pumping_amount not between", value1, value2, "pumpingAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
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

        public Criteria andCheckNameIsNull() {
            addCriterion("check_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNotNull() {
            addCriterion("check_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNameEqualTo(String value) {
            addCriterion("check_name =", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotEqualTo(String value) {
            addCriterion("check_name <>", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThan(String value) {
            addCriterion("check_name >", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_name >=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThan(String value) {
            addCriterion("check_name <", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThanOrEqualTo(String value) {
            addCriterion("check_name <=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLike(String value) {
            addCriterion("check_name like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotLike(String value) {
            addCriterion("check_name not like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameIn(List<String> values) {
            addCriterion("check_name in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotIn(List<String> values) {
            addCriterion("check_name not in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameBetween(String value1, String value2) {
            addCriterion("check_name between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotBetween(String value1, String value2) {
            addCriterion("check_name not between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Integer value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Integer value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Integer value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Integer value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Integer value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Integer> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Integer> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Integer value1, Integer value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
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