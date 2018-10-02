package com.epc.tendering.service.domain.bid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BExpertScoreCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BExpertScoreCriteria() {
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

        public Criteria andBidsIdIsNull() {
            addCriterion("bids_id is null");
            return (Criteria) this;
        }

        public Criteria andBidsIdIsNotNull() {
            addCriterion("bids_id is not null");
            return (Criteria) this;
        }

        public Criteria andBidsIdEqualTo(Long value) {
            addCriterion("bids_id =", value, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdNotEqualTo(Long value) {
            addCriterion("bids_id <>", value, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdGreaterThan(Long value) {
            addCriterion("bids_id >", value, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bids_id >=", value, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdLessThan(Long value) {
            addCriterion("bids_id <", value, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdLessThanOrEqualTo(Long value) {
            addCriterion("bids_id <=", value, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdIn(List<Long> values) {
            addCriterion("bids_id in", values, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdNotIn(List<Long> values) {
            addCriterion("bids_id not in", values, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdBetween(Long value1, Long value2) {
            addCriterion("bids_id between", value1, value2, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsIdNotBetween(Long value1, Long value2) {
            addCriterion("bids_id not between", value1, value2, "bidsId");
            return (Criteria) this;
        }

        public Criteria andBidsCodeIsNull() {
            addCriterion("bids_code is null");
            return (Criteria) this;
        }

        public Criteria andBidsCodeIsNotNull() {
            addCriterion("bids_code is not null");
            return (Criteria) this;
        }

        public Criteria andBidsCodeEqualTo(Long value) {
            addCriterion("bids_code =", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotEqualTo(Long value) {
            addCriterion("bids_code <>", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeGreaterThan(Long value) {
            addCriterion("bids_code >", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("bids_code >=", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeLessThan(Long value) {
            addCriterion("bids_code <", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeLessThanOrEqualTo(Long value) {
            addCriterion("bids_code <=", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeIn(List<Long> values) {
            addCriterion("bids_code in", values, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotIn(List<Long> values) {
            addCriterion("bids_code not in", values, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeBetween(Long value1, Long value2) {
            addCriterion("bids_code between", value1, value2, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotBetween(Long value1, Long value2) {
            addCriterion("bids_code not between", value1, value2, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdIsNull() {
            addCriterion("procurement_project_id is null");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdIsNotNull() {
            addCriterion("procurement_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdEqualTo(Long value) {
            addCriterion("procurement_project_id =", value, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdNotEqualTo(Long value) {
            addCriterion("procurement_project_id <>", value, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdGreaterThan(Long value) {
            addCriterion("procurement_project_id >", value, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("procurement_project_id >=", value, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdLessThan(Long value) {
            addCriterion("procurement_project_id <", value, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("procurement_project_id <=", value, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdIn(List<Long> values) {
            addCriterion("procurement_project_id in", values, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdNotIn(List<Long> values) {
            addCriterion("procurement_project_id not in", values, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdBetween(Long value1, Long value2) {
            addCriterion("procurement_project_id between", value1, value2, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andProcurementProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("procurement_project_id not between", value1, value2, "procurementProjectId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Long value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Long value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Long value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Long value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Long> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Long> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Long value1, Long value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameIsNull() {
            addCriterion("supplier_company_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameIsNotNull() {
            addCriterion("supplier_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameEqualTo(String value) {
            addCriterion("supplier_company_name =", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameNotEqualTo(String value) {
            addCriterion("supplier_company_name <>", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameGreaterThan(String value) {
            addCriterion("supplier_company_name >", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_company_name >=", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameLessThan(String value) {
            addCriterion("supplier_company_name <", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_company_name <=", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameLike(String value) {
            addCriterion("supplier_company_name like", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameNotLike(String value) {
            addCriterion("supplier_company_name not like", value, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameIn(List<String> values) {
            addCriterion("supplier_company_name in", values, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameNotIn(List<String> values) {
            addCriterion("supplier_company_name not in", values, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameBetween(String value1, String value2) {
            addCriterion("supplier_company_name between", value1, value2, "supplierCompanyName");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyNameNotBetween(String value1, String value2) {
            addCriterion("supplier_company_name not between", value1, value2, "supplierCompanyName");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStandardTypeIsNull() {
            addCriterion("standard_type is null");
            return (Criteria) this;
        }

        public Criteria andStandardTypeIsNotNull() {
            addCriterion("standard_type is not null");
            return (Criteria) this;
        }

        public Criteria andStandardTypeEqualTo(String value) {
            addCriterion("standard_type =", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotEqualTo(String value) {
            addCriterion("standard_type <>", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeGreaterThan(String value) {
            addCriterion("standard_type >", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("standard_type >=", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeLessThan(String value) {
            addCriterion("standard_type <", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeLessThanOrEqualTo(String value) {
            addCriterion("standard_type <=", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeLike(String value) {
            addCriterion("standard_type like", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotLike(String value) {
            addCriterion("standard_type not like", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeIn(List<String> values) {
            addCriterion("standard_type in", values, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotIn(List<String> values) {
            addCriterion("standard_type not in", values, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeBetween(String value1, String value2) {
            addCriterion("standard_type between", value1, value2, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotBetween(String value1, String value2) {
            addCriterion("standard_type not between", value1, value2, "standardType");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreIsNull() {
            addCriterion("tech_type_score is null");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreIsNotNull() {
            addCriterion("tech_type_score is not null");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreEqualTo(Integer value) {
            addCriterion("tech_type_score =", value, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreNotEqualTo(Integer value) {
            addCriterion("tech_type_score <>", value, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreGreaterThan(Integer value) {
            addCriterion("tech_type_score >", value, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("tech_type_score >=", value, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreLessThan(Integer value) {
            addCriterion("tech_type_score <", value, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreLessThanOrEqualTo(Integer value) {
            addCriterion("tech_type_score <=", value, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreIn(List<Integer> values) {
            addCriterion("tech_type_score in", values, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreNotIn(List<Integer> values) {
            addCriterion("tech_type_score not in", values, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreBetween(Integer value1, Integer value2) {
            addCriterion("tech_type_score between", value1, value2, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andTechTypeScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("tech_type_score not between", value1, value2, "techTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreIsNull() {
            addCriterion("commerce_type_score is null");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreIsNotNull() {
            addCriterion("commerce_type_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreEqualTo(Integer value) {
            addCriterion("commerce_type_score =", value, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreNotEqualTo(Integer value) {
            addCriterion("commerce_type_score <>", value, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreGreaterThan(Integer value) {
            addCriterion("commerce_type_score >", value, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("commerce_type_score >=", value, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreLessThan(Integer value) {
            addCriterion("commerce_type_score <", value, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreLessThanOrEqualTo(Integer value) {
            addCriterion("commerce_type_score <=", value, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreIn(List<Integer> values) {
            addCriterion("commerce_type_score in", values, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreNotIn(List<Integer> values) {
            addCriterion("commerce_type_score not in", values, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreBetween(Integer value1, Integer value2) {
            addCriterion("commerce_type_score between", value1, value2, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andCommerceTypeScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("commerce_type_score not between", value1, value2, "commerceTypeScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreIsNull() {
            addCriterion("final_score is null");
            return (Criteria) this;
        }

        public Criteria andFinalScoreIsNotNull() {
            addCriterion("final_score is not null");
            return (Criteria) this;
        }

        public Criteria andFinalScoreEqualTo(Integer value) {
            addCriterion("final_score =", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreNotEqualTo(Integer value) {
            addCriterion("final_score <>", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreGreaterThan(Integer value) {
            addCriterion("final_score >", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("final_score >=", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreLessThan(Integer value) {
            addCriterion("final_score <", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("final_score <=", value, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreIn(List<Integer> values) {
            addCriterion("final_score in", values, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreNotIn(List<Integer> values) {
            addCriterion("final_score not in", values, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreBetween(Integer value1, Integer value2) {
            addCriterion("final_score between", value1, value2, "finalScore");
            return (Criteria) this;
        }

        public Criteria andFinalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("final_score not between", value1, value2, "finalScore");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNull() {
            addCriterion("expert_id is null");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNotNull() {
            addCriterion("expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpertIdEqualTo(Long value) {
            addCriterion("expert_id =", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotEqualTo(Long value) {
            addCriterion("expert_id <>", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThan(Long value) {
            addCriterion("expert_id >", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThanOrEqualTo(Long value) {
            addCriterion("expert_id >=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThan(Long value) {
            addCriterion("expert_id <", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThanOrEqualTo(Long value) {
            addCriterion("expert_id <=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIn(List<Long> values) {
            addCriterion("expert_id in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotIn(List<Long> values) {
            addCriterion("expert_id not in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdBetween(Long value1, Long value2) {
            addCriterion("expert_id between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotBetween(Long value1, Long value2) {
            addCriterion("expert_id not between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNull() {
            addCriterion("expert_name is null");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNotNull() {
            addCriterion("expert_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpertNameEqualTo(String value) {
            addCriterion("expert_name =", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotEqualTo(String value) {
            addCriterion("expert_name <>", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThan(String value) {
            addCriterion("expert_name >", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThanOrEqualTo(String value) {
            addCriterion("expert_name >=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThan(String value) {
            addCriterion("expert_name <", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThanOrEqualTo(String value) {
            addCriterion("expert_name <=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLike(String value) {
            addCriterion("expert_name like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotLike(String value) {
            addCriterion("expert_name not like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameIn(List<String> values) {
            addCriterion("expert_name in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotIn(List<String> values) {
            addCriterion("expert_name not in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameBetween(String value1, String value2) {
            addCriterion("expert_name between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotBetween(String value1, String value2) {
            addCriterion("expert_name not between", value1, value2, "expertName");
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