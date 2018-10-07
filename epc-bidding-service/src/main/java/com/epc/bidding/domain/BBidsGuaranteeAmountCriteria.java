package com.epc.bidding.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBidsGuaranteeAmountCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBidsGuaranteeAmountCriteria() {
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

        public Criteria andBIssueDocumentsIdIsNull() {
            addCriterion("b_issue_documents_id is null");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdIsNotNull() {
            addCriterion("b_issue_documents_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdEqualTo(Long value) {
            addCriterion("b_issue_documents_id =", value, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdNotEqualTo(Long value) {
            addCriterion("b_issue_documents_id <>", value, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdGreaterThan(Long value) {
            addCriterion("b_issue_documents_id >", value, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("b_issue_documents_id >=", value, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdLessThan(Long value) {
            addCriterion("b_issue_documents_id <", value, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdLessThanOrEqualTo(Long value) {
            addCriterion("b_issue_documents_id <=", value, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdIn(List<Long> values) {
            addCriterion("b_issue_documents_id in", values, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdNotIn(List<Long> values) {
            addCriterion("b_issue_documents_id not in", values, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdBetween(Long value1, Long value2) {
            addCriterion("b_issue_documents_id between", value1, value2, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andBIssueDocumentsIdNotBetween(Long value1, Long value2) {
            addCriterion("b_issue_documents_id not between", value1, value2, "bIssueDocumentsId");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountIsNull() {
            addCriterion("tender_guarantee_amount is null");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountIsNotNull() {
            addCriterion("tender_guarantee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountEqualTo(BigDecimal value) {
            addCriterion("tender_guarantee_amount =", value, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountNotEqualTo(BigDecimal value) {
            addCriterion("tender_guarantee_amount <>", value, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountGreaterThan(BigDecimal value) {
            addCriterion("tender_guarantee_amount >", value, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tender_guarantee_amount >=", value, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountLessThan(BigDecimal value) {
            addCriterion("tender_guarantee_amount <", value, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tender_guarantee_amount <=", value, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountIn(List<BigDecimal> values) {
            addCriterion("tender_guarantee_amount in", values, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountNotIn(List<BigDecimal> values) {
            addCriterion("tender_guarantee_amount not in", values, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tender_guarantee_amount between", value1, value2, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andTenderGuaranteeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tender_guarantee_amount not between", value1, value2, "tenderGuaranteeAmount");
            return (Criteria) this;
        }

        public Criteria andBidsNameIsNull() {
            addCriterion("bids_name is null");
            return (Criteria) this;
        }

        public Criteria andBidsNameIsNotNull() {
            addCriterion("bids_name is not null");
            return (Criteria) this;
        }

        public Criteria andBidsNameEqualTo(String value) {
            addCriterion("bids_name =", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameNotEqualTo(String value) {
            addCriterion("bids_name <>", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameGreaterThan(String value) {
            addCriterion("bids_name >", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameGreaterThanOrEqualTo(String value) {
            addCriterion("bids_name >=", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameLessThan(String value) {
            addCriterion("bids_name <", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameLessThanOrEqualTo(String value) {
            addCriterion("bids_name <=", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameLike(String value) {
            addCriterion("bids_name like", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameNotLike(String value) {
            addCriterion("bids_name not like", value, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameIn(List<String> values) {
            addCriterion("bids_name in", values, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameNotIn(List<String> values) {
            addCriterion("bids_name not in", values, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameBetween(String value1, String value2) {
            addCriterion("bids_name between", value1, value2, "bidsName");
            return (Criteria) this;
        }

        public Criteria andBidsNameNotBetween(String value1, String value2) {
            addCriterion("bids_name not between", value1, value2, "bidsName");
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

        public Criteria andBidsCodeEqualTo(String value) {
            addCriterion("bids_code =", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotEqualTo(String value) {
            addCriterion("bids_code <>", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeGreaterThan(String value) {
            addCriterion("bids_code >", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bids_code >=", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeLessThan(String value) {
            addCriterion("bids_code <", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeLessThanOrEqualTo(String value) {
            addCriterion("bids_code <=", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeLike(String value) {
            addCriterion("bids_code like", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotLike(String value) {
            addCriterion("bids_code not like", value, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeIn(List<String> values) {
            addCriterion("bids_code in", values, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotIn(List<String> values) {
            addCriterion("bids_code not in", values, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeBetween(String value1, String value2) {
            addCriterion("bids_code between", value1, value2, "bidsCode");
            return (Criteria) this;
        }

        public Criteria andBidsCodeNotBetween(String value1, String value2) {
            addCriterion("bids_code not between", value1, value2, "bidsCode");
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

        public Criteria andReceivablesIsNull() {
            addCriterion("receivables is null");
            return (Criteria) this;
        }

        public Criteria andReceivablesIsNotNull() {
            addCriterion("receivables is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablesEqualTo(String value) {
            addCriterion("receivables =", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotEqualTo(String value) {
            addCriterion("receivables <>", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesGreaterThan(String value) {
            addCriterion("receivables >", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesGreaterThanOrEqualTo(String value) {
            addCriterion("receivables >=", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLessThan(String value) {
            addCriterion("receivables <", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLessThanOrEqualTo(String value) {
            addCriterion("receivables <=", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLike(String value) {
            addCriterion("receivables like", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotLike(String value) {
            addCriterion("receivables not like", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesIn(List<String> values) {
            addCriterion("receivables in", values, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotIn(List<String> values) {
            addCriterion("receivables not in", values, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesBetween(String value1, String value2) {
            addCriterion("receivables between", value1, value2, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotBetween(String value1, String value2) {
            addCriterion("receivables not between", value1, value2, "receivables");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
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