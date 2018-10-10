package com.epc.bidding.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPurchaseProjectBidsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaseProjectBidsCriteria() {
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

        public Criteria andPurchaseProjectIdIsNull() {
            addCriterion("purchase_project_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdIsNotNull() {
            addCriterion("purchase_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdEqualTo(Long value) {
            addCriterion("purchase_project_id =", value, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdNotEqualTo(Long value) {
            addCriterion("purchase_project_id <>", value, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdGreaterThan(Long value) {
            addCriterion("purchase_project_id >", value, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_project_id >=", value, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdLessThan(Long value) {
            addCriterion("purchase_project_id <", value, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("purchase_project_id <=", value, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdIn(List<Long> values) {
            addCriterion("purchase_project_id in", values, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdNotIn(List<Long> values) {
            addCriterion("purchase_project_id not in", values, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdBetween(Long value1, Long value2) {
            addCriterion("purchase_project_id between", value1, value2, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("purchase_project_id not between", value1, value2, "purchaseProjectId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameIsNull() {
            addCriterion("purchase_project_name is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameIsNotNull() {
            addCriterion("purchase_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameEqualTo(String value) {
            addCriterion("purchase_project_name =", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameNotEqualTo(String value) {
            addCriterion("purchase_project_name <>", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameGreaterThan(String value) {
            addCriterion("purchase_project_name >", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_project_name >=", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameLessThan(String value) {
            addCriterion("purchase_project_name <", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameLessThanOrEqualTo(String value) {
            addCriterion("purchase_project_name <=", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameLike(String value) {
            addCriterion("purchase_project_name like", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameNotLike(String value) {
            addCriterion("purchase_project_name not like", value, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameIn(List<String> values) {
            addCriterion("purchase_project_name in", values, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameNotIn(List<String> values) {
            addCriterion("purchase_project_name not in", values, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameBetween(String value1, String value2) {
            addCriterion("purchase_project_name between", value1, value2, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNameNotBetween(String value1, String value2) {
            addCriterion("purchase_project_name not between", value1, value2, "purchaseProjectName");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeIsNull() {
            addCriterion("purchase_project_code is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeIsNotNull() {
            addCriterion("purchase_project_code is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeEqualTo(String value) {
            addCriterion("purchase_project_code =", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeNotEqualTo(String value) {
            addCriterion("purchase_project_code <>", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeGreaterThan(String value) {
            addCriterion("purchase_project_code >", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_project_code >=", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeLessThan(String value) {
            addCriterion("purchase_project_code <", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("purchase_project_code <=", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeLike(String value) {
            addCriterion("purchase_project_code like", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeNotLike(String value) {
            addCriterion("purchase_project_code not like", value, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeIn(List<String> values) {
            addCriterion("purchase_project_code in", values, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeNotIn(List<String> values) {
            addCriterion("purchase_project_code not in", values, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeBetween(String value1, String value2) {
            addCriterion("purchase_project_code between", value1, value2, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectCodeNotBetween(String value1, String value2) {
            addCriterion("purchase_project_code not between", value1, value2, "purchaseProjectCode");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeIsNull() {
            addCriterion("bid_code is null");
            return (Criteria) this;
        }

        public Criteria andBidCodeIsNotNull() {
            addCriterion("bid_code is not null");
            return (Criteria) this;
        }

        public Criteria andBidCodeEqualTo(String value) {
            addCriterion("bid_code =", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotEqualTo(String value) {
            addCriterion("bid_code <>", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeGreaterThan(String value) {
            addCriterion("bid_code >", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bid_code >=", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeLessThan(String value) {
            addCriterion("bid_code <", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeLessThanOrEqualTo(String value) {
            addCriterion("bid_code <=", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeLike(String value) {
            addCriterion("bid_code like", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotLike(String value) {
            addCriterion("bid_code not like", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeIn(List<String> values) {
            addCriterion("bid_code in", values, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotIn(List<String> values) {
            addCriterion("bid_code not in", values, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeBetween(String value1, String value2) {
            addCriterion("bid_code between", value1, value2, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotBetween(String value1, String value2) {
            addCriterion("bid_code not between", value1, value2, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidNameIsNull() {
            addCriterion("bid_name is null");
            return (Criteria) this;
        }

        public Criteria andBidNameIsNotNull() {
            addCriterion("bid_name is not null");
            return (Criteria) this;
        }

        public Criteria andBidNameEqualTo(String value) {
            addCriterion("bid_name =", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotEqualTo(String value) {
            addCriterion("bid_name <>", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameGreaterThan(String value) {
            addCriterion("bid_name >", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameGreaterThanOrEqualTo(String value) {
            addCriterion("bid_name >=", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameLessThan(String value) {
            addCriterion("bid_name <", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameLessThanOrEqualTo(String value) {
            addCriterion("bid_name <=", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameLike(String value) {
            addCriterion("bid_name like", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotLike(String value) {
            addCriterion("bid_name not like", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameIn(List<String> values) {
            addCriterion("bid_name in", values, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotIn(List<String> values) {
            addCriterion("bid_name not in", values, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameBetween(String value1, String value2) {
            addCriterion("bid_name between", value1, value2, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotBetween(String value1, String value2) {
            addCriterion("bid_name not between", value1, value2, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountIsNull() {
            addCriterion("bid_budgetary_amount is null");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountIsNotNull() {
            addCriterion("bid_budgetary_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountEqualTo(BigDecimal value) {
            addCriterion("bid_budgetary_amount =", value, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountNotEqualTo(BigDecimal value) {
            addCriterion("bid_budgetary_amount <>", value, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountGreaterThan(BigDecimal value) {
            addCriterion("bid_budgetary_amount >", value, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_budgetary_amount >=", value, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountLessThan(BigDecimal value) {
            addCriterion("bid_budgetary_amount <", value, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_budgetary_amount <=", value, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountIn(List<BigDecimal> values) {
            addCriterion("bid_budgetary_amount in", values, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountNotIn(List<BigDecimal> values) {
            addCriterion("bid_budgetary_amount not in", values, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_budgetary_amount between", value1, value2, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andBidBudgetaryAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_budgetary_amount not between", value1, value2, "bidBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentIsNull() {
            addCriterion("guarantee_payment is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentIsNotNull() {
            addCriterion("guarantee_payment is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment =", value, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentNotEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment <>", value, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentGreaterThan(BigDecimal value) {
            addCriterion("guarantee_payment >", value, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment >=", value, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentLessThan(BigDecimal value) {
            addCriterion("guarantee_payment <", value, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_payment <=", value, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentIn(List<BigDecimal> values) {
            addCriterion("guarantee_payment in", values, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentNotIn(List<BigDecimal> values) {
            addCriterion("guarantee_payment not in", values, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_payment between", value1, value2, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andGuaranteePaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_payment not between", value1, value2, "guaranteePayment");
            return (Criteria) this;
        }

        public Criteria andBidFilePathIsNull() {
            addCriterion("bid_file_path is null");
            return (Criteria) this;
        }

        public Criteria andBidFilePathIsNotNull() {
            addCriterion("bid_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andBidFilePathEqualTo(String value) {
            addCriterion("bid_file_path =", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathNotEqualTo(String value) {
            addCriterion("bid_file_path <>", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathGreaterThan(String value) {
            addCriterion("bid_file_path >", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("bid_file_path >=", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathLessThan(String value) {
            addCriterion("bid_file_path <", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathLessThanOrEqualTo(String value) {
            addCriterion("bid_file_path <=", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathLike(String value) {
            addCriterion("bid_file_path like", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathNotLike(String value) {
            addCriterion("bid_file_path not like", value, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathIn(List<String> values) {
            addCriterion("bid_file_path in", values, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathNotIn(List<String> values) {
            addCriterion("bid_file_path not in", values, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathBetween(String value1, String value2) {
            addCriterion("bid_file_path between", value1, value2, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andBidFilePathNotBetween(String value1, String value2) {
            addCriterion("bid_file_path not between", value1, value2, "bidFilePath");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNull() {
            addCriterion("operate_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNotNull() {
            addCriterion("operate_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIdEqualTo(Long value) {
            addCriterion("operate_id =", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotEqualTo(Long value) {
            addCriterion("operate_id <>", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThan(Long value) {
            addCriterion("operate_id >", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operate_id >=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThan(Long value) {
            addCriterion("operate_id <", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThanOrEqualTo(Long value) {
            addCriterion("operate_id <=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIn(List<Long> values) {
            addCriterion("operate_id in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotIn(List<Long> values) {
            addCriterion("operate_id not in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdBetween(Long value1, Long value2) {
            addCriterion("operate_id between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotBetween(Long value1, Long value2) {
            addCriterion("operate_id not between", value1, value2, "operateId");
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