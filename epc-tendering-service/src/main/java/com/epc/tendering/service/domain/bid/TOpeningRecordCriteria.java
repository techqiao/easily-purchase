package com.epc.tendering.service.domain.bid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOpeningRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOpeningRecordCriteria() {
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

        public Criteria andTenderMessageIdIsNull() {
            addCriterion("tender_message_id is null");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdIsNotNull() {
            addCriterion("tender_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdEqualTo(Long value) {
            addCriterion("tender_message_id =", value, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdNotEqualTo(Long value) {
            addCriterion("tender_message_id <>", value, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdGreaterThan(Long value) {
            addCriterion("tender_message_id >", value, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tender_message_id >=", value, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdLessThan(Long value) {
            addCriterion("tender_message_id <", value, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("tender_message_id <=", value, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdIn(List<Long> values) {
            addCriterion("tender_message_id in", values, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdNotIn(List<Long> values) {
            addCriterion("tender_message_id not in", values, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdBetween(Long value1, Long value2) {
            addCriterion("tender_message_id between", value1, value2, "tenderMessageId");
            return (Criteria) this;
        }

        public Criteria andTenderMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("tender_message_id not between", value1, value2, "tenderMessageId");
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

        public Criteria andSupplierCompanyIdIsNull() {
            addCriterion("supplier_company_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdIsNotNull() {
            addCriterion("supplier_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdEqualTo(Long value) {
            addCriterion("supplier_company_id =", value, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdNotEqualTo(Long value) {
            addCriterion("supplier_company_id <>", value, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdGreaterThan(Long value) {
            addCriterion("supplier_company_id >", value, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_company_id >=", value, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdLessThan(Long value) {
            addCriterion("supplier_company_id <", value, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_company_id <=", value, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdIn(List<Long> values) {
            addCriterion("supplier_company_id in", values, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdNotIn(List<Long> values) {
            addCriterion("supplier_company_id not in", values, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdBetween(Long value1, Long value2) {
            addCriterion("supplier_company_id between", value1, value2, "supplierCompanyId");
            return (Criteria) this;
        }

        public Criteria andSupplierCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_company_id not between", value1, value2, "supplierCompanyId");
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

        public Criteria andIsPayBondIsNull() {
            addCriterion("is_pay_bond is null");
            return (Criteria) this;
        }

        public Criteria andIsPayBondIsNotNull() {
            addCriterion("is_pay_bond is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayBondEqualTo(Integer value) {
            addCriterion("is_pay_bond =", value, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondNotEqualTo(Integer value) {
            addCriterion("is_pay_bond <>", value, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondGreaterThan(Integer value) {
            addCriterion("is_pay_bond >", value, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pay_bond >=", value, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondLessThan(Integer value) {
            addCriterion("is_pay_bond <", value, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondLessThanOrEqualTo(Integer value) {
            addCriterion("is_pay_bond <=", value, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondIn(List<Integer> values) {
            addCriterion("is_pay_bond in", values, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondNotIn(List<Integer> values) {
            addCriterion("is_pay_bond not in", values, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondBetween(Integer value1, Integer value2) {
            addCriterion("is_pay_bond between", value1, value2, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsPayBondNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pay_bond not between", value1, value2, "isPayBond");
            return (Criteria) this;
        }

        public Criteria andIsSignIsNull() {
            addCriterion("is_sign is null");
            return (Criteria) this;
        }

        public Criteria andIsSignIsNotNull() {
            addCriterion("is_sign is not null");
            return (Criteria) this;
        }

        public Criteria andIsSignEqualTo(Integer value) {
            addCriterion("is_sign =", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotEqualTo(Integer value) {
            addCriterion("is_sign <>", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignGreaterThan(Integer value) {
            addCriterion("is_sign >", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sign >=", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignLessThan(Integer value) {
            addCriterion("is_sign <", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignLessThanOrEqualTo(Integer value) {
            addCriterion("is_sign <=", value, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignIn(List<Integer> values) {
            addCriterion("is_sign in", values, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotIn(List<Integer> values) {
            addCriterion("is_sign not in", values, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignBetween(Integer value1, Integer value2) {
            addCriterion("is_sign between", value1, value2, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsSignNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sign not between", value1, value2, "isSign");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedIsNull() {
            addCriterion("is_bidding_qualified is null");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedIsNotNull() {
            addCriterion("is_bidding_qualified is not null");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedEqualTo(Integer value) {
            addCriterion("is_bidding_qualified =", value, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedNotEqualTo(Integer value) {
            addCriterion("is_bidding_qualified <>", value, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedGreaterThan(Integer value) {
            addCriterion("is_bidding_qualified >", value, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_bidding_qualified >=", value, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedLessThan(Integer value) {
            addCriterion("is_bidding_qualified <", value, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedLessThanOrEqualTo(Integer value) {
            addCriterion("is_bidding_qualified <=", value, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedIn(List<Integer> values) {
            addCriterion("is_bidding_qualified in", values, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedNotIn(List<Integer> values) {
            addCriterion("is_bidding_qualified not in", values, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedBetween(Integer value1, Integer value2) {
            addCriterion("is_bidding_qualified between", value1, value2, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingQualifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_bidding_qualified not between", value1, value2, "isBiddingQualified");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseIsNull() {
            addCriterion("is_bidding_refuse is null");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseIsNotNull() {
            addCriterion("is_bidding_refuse is not null");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseEqualTo(Integer value) {
            addCriterion("is_bidding_refuse =", value, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseNotEqualTo(Integer value) {
            addCriterion("is_bidding_refuse <>", value, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseGreaterThan(Integer value) {
            addCriterion("is_bidding_refuse >", value, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_bidding_refuse >=", value, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseLessThan(Integer value) {
            addCriterion("is_bidding_refuse <", value, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseLessThanOrEqualTo(Integer value) {
            addCriterion("is_bidding_refuse <=", value, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseIn(List<Integer> values) {
            addCriterion("is_bidding_refuse in", values, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseNotIn(List<Integer> values) {
            addCriterion("is_bidding_refuse not in", values, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseBetween(Integer value1, Integer value2) {
            addCriterion("is_bidding_refuse between", value1, value2, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andIsBiddingRefuseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_bidding_refuse not between", value1, value2, "isBiddingRefuse");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonIsNull() {
            addCriterion("bidding_refuse_reason is null");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonIsNotNull() {
            addCriterion("bidding_refuse_reason is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonEqualTo(String value) {
            addCriterion("bidding_refuse_reason =", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonNotEqualTo(String value) {
            addCriterion("bidding_refuse_reason <>", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonGreaterThan(String value) {
            addCriterion("bidding_refuse_reason >", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("bidding_refuse_reason >=", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonLessThan(String value) {
            addCriterion("bidding_refuse_reason <", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("bidding_refuse_reason <=", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonLike(String value) {
            addCriterion("bidding_refuse_reason like", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonNotLike(String value) {
            addCriterion("bidding_refuse_reason not like", value, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonIn(List<String> values) {
            addCriterion("bidding_refuse_reason in", values, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonNotIn(List<String> values) {
            addCriterion("bidding_refuse_reason not in", values, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonBetween(String value1, String value2) {
            addCriterion("bidding_refuse_reason between", value1, value2, "biddingRefuseReason");
            return (Criteria) this;
        }

        public Criteria andBiddingRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("bidding_refuse_reason not between", value1, value2, "biddingRefuseReason");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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