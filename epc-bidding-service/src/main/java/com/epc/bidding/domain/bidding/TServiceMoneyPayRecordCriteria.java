package com.epc.bidding.domain.bidding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TServiceMoneyPayRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TServiceMoneyPayRecordCriteria() {
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

        public Criteria andMoneyPayIdIsNull() {
            addCriterion("money_pay_id is null");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdIsNotNull() {
            addCriterion("money_pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdEqualTo(Long value) {
            addCriterion("money_pay_id =", value, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdNotEqualTo(Long value) {
            addCriterion("money_pay_id <>", value, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdGreaterThan(Long value) {
            addCriterion("money_pay_id >", value, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("money_pay_id >=", value, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdLessThan(Long value) {
            addCriterion("money_pay_id <", value, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdLessThanOrEqualTo(Long value) {
            addCriterion("money_pay_id <=", value, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdIn(List<Long> values) {
            addCriterion("money_pay_id in", values, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdNotIn(List<Long> values) {
            addCriterion("money_pay_id not in", values, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdBetween(Long value1, Long value2) {
            addCriterion("money_pay_id between", value1, value2, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andMoneyPayIdNotBetween(Long value1, Long value2) {
            addCriterion("money_pay_id not between", value1, value2, "moneyPayId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdIsNull() {
            addCriterion("operater_id is null");
            return (Criteria) this;
        }

        public Criteria andOperaterIdIsNotNull() {
            addCriterion("operater_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterIdEqualTo(Long value) {
            addCriterion("operater_id =", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotEqualTo(Long value) {
            addCriterion("operater_id <>", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdGreaterThan(Long value) {
            addCriterion("operater_id >", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operater_id >=", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdLessThan(Long value) {
            addCriterion("operater_id <", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdLessThanOrEqualTo(Long value) {
            addCriterion("operater_id <=", value, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdIn(List<Long> values) {
            addCriterion("operater_id in", values, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotIn(List<Long> values) {
            addCriterion("operater_id not in", values, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdBetween(Long value1, Long value2) {
            addCriterion("operater_id between", value1, value2, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterIdNotBetween(Long value1, Long value2) {
            addCriterion("operater_id not between", value1, value2, "operaterId");
            return (Criteria) this;
        }

        public Criteria andOperaterNameIsNull() {
            addCriterion("operater_name is null");
            return (Criteria) this;
        }

        public Criteria andOperaterNameIsNotNull() {
            addCriterion("operater_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterNameEqualTo(String value) {
            addCriterion("operater_name =", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameNotEqualTo(String value) {
            addCriterion("operater_name <>", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameGreaterThan(String value) {
            addCriterion("operater_name >", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameGreaterThanOrEqualTo(String value) {
            addCriterion("operater_name >=", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameLessThan(String value) {
            addCriterion("operater_name <", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameLessThanOrEqualTo(String value) {
            addCriterion("operater_name <=", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameLike(String value) {
            addCriterion("operater_name like", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameNotLike(String value) {
            addCriterion("operater_name not like", value, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameIn(List<String> values) {
            addCriterion("operater_name in", values, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameNotIn(List<String> values) {
            addCriterion("operater_name not in", values, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameBetween(String value1, String value2) {
            addCriterion("operater_name between", value1, value2, "operaterName");
            return (Criteria) this;
        }

        public Criteria andOperaterNameNotBetween(String value1, String value2) {
            addCriterion("operater_name not between", value1, value2, "operaterName");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealIsNull() {
            addCriterion("guarantee_payment_real is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealIsNotNull() {
            addCriterion("guarantee_payment_real is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment_real =", value, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealNotEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment_real <>", value, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealGreaterThan(BigDecimal value) {
            addCriterion("guarantee_payment_real >", value, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment_real >=", value, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealLessThan(BigDecimal value) {
            addCriterion("guarantee_payment_real <", value, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealLessThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment_real <=", value, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealIn(List<BigDecimal> values) {
            addCriterion("guarantee_payment_real in", values, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealNotIn(List<BigDecimal> values) {
            addCriterion("guarantee_payment_real not in", values, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_payment_real between", value1, value2, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentRealNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_payment_real not between", value1, value2, "guaranteePaymentReal");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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