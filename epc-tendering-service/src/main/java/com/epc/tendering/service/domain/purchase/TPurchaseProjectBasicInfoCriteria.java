package com.epc.tendering.service.domain.purchase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPurchaseProjectBasicInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaseProjectBasicInfoCriteria() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
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

        public Criteria andPurchaseStartTimeIsNull() {
            addCriterion("purchase_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeIsNotNull() {
            addCriterion("purchase_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeEqualTo(Date value) {
            addCriterion("purchase_start_time =", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeNotEqualTo(Date value) {
            addCriterion("purchase_start_time <>", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeGreaterThan(Date value) {
            addCriterion("purchase_start_time >", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_start_time >=", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeLessThan(Date value) {
            addCriterion("purchase_start_time <", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_start_time <=", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeIn(List<Date> values) {
            addCriterion("purchase_start_time in", values, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeNotIn(List<Date> values) {
            addCriterion("purchase_start_time not in", values, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_start_time between", value1, value2, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_start_time not between", value1, value2, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeIsNull() {
            addCriterion("purchase_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeIsNotNull() {
            addCriterion("purchase_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeEqualTo(Date value) {
            addCriterion("purchase_end_time =", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeNotEqualTo(Date value) {
            addCriterion("purchase_end_time <>", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeGreaterThan(Date value) {
            addCriterion("purchase_end_time >", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_end_time >=", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeLessThan(Date value) {
            addCriterion("purchase_end_time <", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_end_time <=", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeIn(List<Date> values) {
            addCriterion("purchase_end_time in", values, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeNotIn(List<Date> values) {
            addCriterion("purchase_end_time not in", values, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_end_time between", value1, value2, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_end_time not between", value1, value2, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountIsNull() {
            addCriterion("purchase_project_budgetary_amount is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountIsNotNull() {
            addCriterion("purchase_project_budgetary_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountEqualTo(BigDecimal value) {
            addCriterion("purchase_project_budgetary_amount =", value, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountNotEqualTo(BigDecimal value) {
            addCriterion("purchase_project_budgetary_amount <>", value, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountGreaterThan(BigDecimal value) {
            addCriterion("purchase_project_budgetary_amount >", value, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_project_budgetary_amount >=", value, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountLessThan(BigDecimal value) {
            addCriterion("purchase_project_budgetary_amount <", value, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_project_budgetary_amount <=", value, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountIn(List<BigDecimal> values) {
            addCriterion("purchase_project_budgetary_amount in", values, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountNotIn(List<BigDecimal> values) {
            addCriterion("purchase_project_budgetary_amount not in", values, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_project_budgetary_amount between", value1, value2, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBudgetaryAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_project_budgetary_amount not between", value1, value2, "purchaseProjectBudgetaryAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeIsNull() {
            addCriterion("purchase_mode is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeIsNotNull() {
            addCriterion("purchase_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeEqualTo(String value) {
            addCriterion("purchase_mode =", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeNotEqualTo(String value) {
            addCriterion("purchase_mode <>", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeGreaterThan(String value) {
            addCriterion("purchase_mode >", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_mode >=", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeLessThan(String value) {
            addCriterion("purchase_mode <", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeLessThanOrEqualTo(String value) {
            addCriterion("purchase_mode <=", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeLike(String value) {
            addCriterion("purchase_mode like", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeNotLike(String value) {
            addCriterion("purchase_mode not like", value, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeIn(List<String> values) {
            addCriterion("purchase_mode in", values, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeNotIn(List<String> values) {
            addCriterion("purchase_mode not in", values, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeBetween(String value1, String value2) {
            addCriterion("purchase_mode between", value1, value2, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseModeNotBetween(String value1, String value2) {
            addCriterion("purchase_mode not between", value1, value2, "purchaseMode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryIsNull() {
            addCriterion("purchase_category is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryIsNotNull() {
            addCriterion("purchase_category is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryEqualTo(String value) {
            addCriterion("purchase_category =", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryNotEqualTo(String value) {
            addCriterion("purchase_category <>", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryGreaterThan(String value) {
            addCriterion("purchase_category >", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_category >=", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryLessThan(String value) {
            addCriterion("purchase_category <", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryLessThanOrEqualTo(String value) {
            addCriterion("purchase_category <=", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryLike(String value) {
            addCriterion("purchase_category like", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryNotLike(String value) {
            addCriterion("purchase_category not like", value, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryIn(List<String> values) {
            addCriterion("purchase_category in", values, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryNotIn(List<String> values) {
            addCriterion("purchase_category not in", values, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryBetween(String value1, String value2) {
            addCriterion("purchase_category between", value1, value2, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseCategoryNotBetween(String value1, String value2) {
            addCriterion("purchase_category not between", value1, value2, "purchaseCategory");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIsNull() {
            addCriterion("purchase_type is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIsNotNull() {
            addCriterion("purchase_type is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeEqualTo(String value) {
            addCriterion("purchase_type =", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotEqualTo(String value) {
            addCriterion("purchase_type <>", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeGreaterThan(String value) {
            addCriterion("purchase_type >", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_type >=", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLessThan(String value) {
            addCriterion("purchase_type <", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLessThanOrEqualTo(String value) {
            addCriterion("purchase_type <=", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLike(String value) {
            addCriterion("purchase_type like", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotLike(String value) {
            addCriterion("purchase_type not like", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIn(List<String> values) {
            addCriterion("purchase_type in", values, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotIn(List<String> values) {
            addCriterion("purchase_type not in", values, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeBetween(String value1, String value2) {
            addCriterion("purchase_type between", value1, value2, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotBetween(String value1, String value2) {
            addCriterion("purchase_type not between", value1, value2, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeIsNull() {
            addCriterion("purchase_range is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeIsNotNull() {
            addCriterion("purchase_range is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeEqualTo(Integer value) {
            addCriterion("purchase_range =", value, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeNotEqualTo(Integer value) {
            addCriterion("purchase_range <>", value, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeGreaterThan(Integer value) {
            addCriterion("purchase_range >", value, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_range >=", value, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeLessThan(Integer value) {
            addCriterion("purchase_range <", value, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_range <=", value, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeIn(List<Integer> values) {
            addCriterion("purchase_range in", values, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeNotIn(List<Integer> values) {
            addCriterion("purchase_range not in", values, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeBetween(Integer value1, Integer value2) {
            addCriterion("purchase_range between", value1, value2, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_range not between", value1, value2, "purchaseRange");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusIsNull() {
            addCriterion("purchase_project_status is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusIsNotNull() {
            addCriterion("purchase_project_status is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusEqualTo(String value) {
            addCriterion("purchase_project_status =", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusNotEqualTo(String value) {
            addCriterion("purchase_project_status <>", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusGreaterThan(String value) {
            addCriterion("purchase_project_status >", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_project_status >=", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusLessThan(String value) {
            addCriterion("purchase_project_status <", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusLessThanOrEqualTo(String value) {
            addCriterion("purchase_project_status <=", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusLike(String value) {
            addCriterion("purchase_project_status like", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusNotLike(String value) {
            addCriterion("purchase_project_status not like", value, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusIn(List<String> values) {
            addCriterion("purchase_project_status in", values, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusNotIn(List<String> values) {
            addCriterion("purchase_project_status not in", values, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusBetween(String value1, String value2) {
            addCriterion("purchase_project_status between", value1, value2, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectStatusNotBetween(String value1, String value2) {
            addCriterion("purchase_project_status not between", value1, value2, "purchaseProjectStatus");
            return (Criteria) this;
        }

        public Criteria andIsAdjustIsNull() {
            addCriterion("is_adjust is null");
            return (Criteria) this;
        }

        public Criteria andIsAdjustIsNotNull() {
            addCriterion("is_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdjustEqualTo(Integer value) {
            addCriterion("is_adjust =", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustNotEqualTo(Integer value) {
            addCriterion("is_adjust <>", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustGreaterThan(Integer value) {
            addCriterion("is_adjust >", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_adjust >=", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustLessThan(Integer value) {
            addCriterion("is_adjust <", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustLessThanOrEqualTo(Integer value) {
            addCriterion("is_adjust <=", value, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustIn(List<Integer> values) {
            addCriterion("is_adjust in", values, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustNotIn(List<Integer> values) {
            addCriterion("is_adjust not in", values, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustBetween(Integer value1, Integer value2) {
            addCriterion("is_adjust between", value1, value2, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsAdjustNotBetween(Integer value1, Integer value2) {
            addCriterion("is_adjust not between", value1, value2, "isAdjust");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyIsNull() {
            addCriterion("is_other_agency is null");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyIsNotNull() {
            addCriterion("is_other_agency is not null");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyEqualTo(Integer value) {
            addCriterion("is_other_agency =", value, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyNotEqualTo(Integer value) {
            addCriterion("is_other_agency <>", value, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyGreaterThan(Integer value) {
            addCriterion("is_other_agency >", value, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_other_agency >=", value, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyLessThan(Integer value) {
            addCriterion("is_other_agency <", value, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyLessThanOrEqualTo(Integer value) {
            addCriterion("is_other_agency <=", value, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyIn(List<Integer> values) {
            addCriterion("is_other_agency in", values, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyNotIn(List<Integer> values) {
            addCriterion("is_other_agency not in", values, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyBetween(Integer value1, Integer value2) {
            addCriterion("is_other_agency between", value1, value2, "isOtherAgency");
            return (Criteria) this;
        }

        public Criteria andIsOtherAgencyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_other_agency not between", value1, value2, "isOtherAgency");
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