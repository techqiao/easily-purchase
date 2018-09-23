package com.epc.bidding.domain.bidding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBidOpeningPayCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBidOpeningPayCriteria() {
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

        public Criteria andBidIdIsNull() {
            addCriterion("bid_id is null");
            return (Criteria) this;
        }

        public Criteria andBidIdIsNotNull() {
            addCriterion("bid_id is not null");
            return (Criteria) this;
        }

        public Criteria andBidIdEqualTo(Long value) {
            addCriterion("bid_id =", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotEqualTo(Long value) {
            addCriterion("bid_id <>", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdGreaterThan(Long value) {
            addCriterion("bid_id >", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bid_id >=", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdLessThan(Long value) {
            addCriterion("bid_id <", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdLessThanOrEqualTo(Long value) {
            addCriterion("bid_id <=", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdIn(List<Long> values) {
            addCriterion("bid_id in", values, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotIn(List<Long> values) {
            addCriterion("bid_id not in", values, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdBetween(Long value1, Long value2) {
            addCriterion("bid_id between", value1, value2, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotBetween(Long value1, Long value2) {
            addCriterion("bid_id not between", value1, value2, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdIsNull() {
            addCriterion("bids_guarantee_amount_id is null");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdIsNotNull() {
            addCriterion("bids_guarantee_amount_id is not null");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdEqualTo(Long value) {
            addCriterion("bids_guarantee_amount_id =", value, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdNotEqualTo(Long value) {
            addCriterion("bids_guarantee_amount_id <>", value, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdGreaterThan(Long value) {
            addCriterion("bids_guarantee_amount_id >", value, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bids_guarantee_amount_id >=", value, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdLessThan(Long value) {
            addCriterion("bids_guarantee_amount_id <", value, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdLessThanOrEqualTo(Long value) {
            addCriterion("bids_guarantee_amount_id <=", value, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdIn(List<Long> values) {
            addCriterion("bids_guarantee_amount_id in", values, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdNotIn(List<Long> values) {
            addCriterion("bids_guarantee_amount_id not in", values, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdBetween(Long value1, Long value2) {
            addCriterion("bids_guarantee_amount_id between", value1, value2, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andBidsGuaranteeAmountIdNotBetween(Long value1, Long value2) {
            addCriterion("bids_guarantee_amount_id not between", value1, value2, "bidsGuaranteeAmountId");
            return (Criteria) this;
        }

        public Criteria andTendererIdIsNull() {
            addCriterion("tenderer_id is null");
            return (Criteria) this;
        }

        public Criteria andTendererIdIsNotNull() {
            addCriterion("tenderer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTendererIdEqualTo(Long value) {
            addCriterion("tenderer_id =", value, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdNotEqualTo(Long value) {
            addCriterion("tenderer_id <>", value, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdGreaterThan(Long value) {
            addCriterion("tenderer_id >", value, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenderer_id >=", value, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdLessThan(Long value) {
            addCriterion("tenderer_id <", value, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdLessThanOrEqualTo(Long value) {
            addCriterion("tenderer_id <=", value, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdIn(List<Long> values) {
            addCriterion("tenderer_id in", values, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdNotIn(List<Long> values) {
            addCriterion("tenderer_id not in", values, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdBetween(Long value1, Long value2) {
            addCriterion("tenderer_id between", value1, value2, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererIdNotBetween(Long value1, Long value2) {
            addCriterion("tenderer_id not between", value1, value2, "tendererId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdIsNull() {
            addCriterion("tenderer_company_id is null");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdIsNotNull() {
            addCriterion("tenderer_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdEqualTo(Long value) {
            addCriterion("tenderer_company_id =", value, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdNotEqualTo(Long value) {
            addCriterion("tenderer_company_id <>", value, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdGreaterThan(Long value) {
            addCriterion("tenderer_company_id >", value, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenderer_company_id >=", value, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdLessThan(Long value) {
            addCriterion("tenderer_company_id <", value, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("tenderer_company_id <=", value, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdIn(List<Long> values) {
            addCriterion("tenderer_company_id in", values, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdNotIn(List<Long> values) {
            addCriterion("tenderer_company_id not in", values, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdBetween(Long value1, Long value2) {
            addCriterion("tenderer_company_id between", value1, value2, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("tenderer_company_id not between", value1, value2, "tendererCompanyId");
            return (Criteria) this;
        }

        public Criteria andTendererNameIsNull() {
            addCriterion("tenderer_name is null");
            return (Criteria) this;
        }

        public Criteria andTendererNameIsNotNull() {
            addCriterion("tenderer_name is not null");
            return (Criteria) this;
        }

        public Criteria andTendererNameEqualTo(String value) {
            addCriterion("tenderer_name =", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameNotEqualTo(String value) {
            addCriterion("tenderer_name <>", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameGreaterThan(String value) {
            addCriterion("tenderer_name >", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameGreaterThanOrEqualTo(String value) {
            addCriterion("tenderer_name >=", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameLessThan(String value) {
            addCriterion("tenderer_name <", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameLessThanOrEqualTo(String value) {
            addCriterion("tenderer_name <=", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameLike(String value) {
            addCriterion("tenderer_name like", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameNotLike(String value) {
            addCriterion("tenderer_name not like", value, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameIn(List<String> values) {
            addCriterion("tenderer_name in", values, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameNotIn(List<String> values) {
            addCriterion("tenderer_name not in", values, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameBetween(String value1, String value2) {
            addCriterion("tenderer_name between", value1, value2, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererNameNotBetween(String value1, String value2) {
            addCriterion("tenderer_name not between", value1, value2, "tendererName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameIsNull() {
            addCriterion("tenderer_company_name is null");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameIsNotNull() {
            addCriterion("tenderer_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameEqualTo(Long value) {
            addCriterion("tenderer_company_name =", value, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameNotEqualTo(Long value) {
            addCriterion("tenderer_company_name <>", value, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameGreaterThan(Long value) {
            addCriterion("tenderer_company_name >", value, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameGreaterThanOrEqualTo(Long value) {
            addCriterion("tenderer_company_name >=", value, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameLessThan(Long value) {
            addCriterion("tenderer_company_name <", value, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameLessThanOrEqualTo(Long value) {
            addCriterion("tenderer_company_name <=", value, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameIn(List<Long> values) {
            addCriterion("tenderer_company_name in", values, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameNotIn(List<Long> values) {
            addCriterion("tenderer_company_name not in", values, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameBetween(Long value1, Long value2) {
            addCriterion("tenderer_company_name between", value1, value2, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andTendererCompanyNameNotBetween(Long value1, Long value2) {
            addCriterion("tenderer_company_name not between", value1, value2, "tendererCompanyName");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeIsNull() {
            addCriterion("amount_money_time is null");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeIsNotNull() {
            addCriterion("amount_money_time is not null");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeEqualTo(Date value) {
            addCriterion("amount_money_time =", value, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeNotEqualTo(Date value) {
            addCriterion("amount_money_time <>", value, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeGreaterThan(Date value) {
            addCriterion("amount_money_time >", value, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("amount_money_time >=", value, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeLessThan(Date value) {
            addCriterion("amount_money_time <", value, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeLessThanOrEqualTo(Date value) {
            addCriterion("amount_money_time <=", value, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeIn(List<Date> values) {
            addCriterion("amount_money_time in", values, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeNotIn(List<Date> values) {
            addCriterion("amount_money_time not in", values, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeBetween(Date value1, Date value2) {
            addCriterion("amount_money_time between", value1, value2, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyTimeNotBetween(Date value1, Date value2) {
            addCriterion("amount_money_time not between", value1, value2, "amountMoneyTime");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyIsNull() {
            addCriterion("amount_money is null");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyIsNotNull() {
            addCriterion("amount_money is not null");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyEqualTo(BigDecimal value) {
            addCriterion("amount_money =", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyNotEqualTo(BigDecimal value) {
            addCriterion("amount_money <>", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyGreaterThan(BigDecimal value) {
            addCriterion("amount_money >", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_money >=", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyLessThan(BigDecimal value) {
            addCriterion("amount_money <", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_money <=", value, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyIn(List<BigDecimal> values) {
            addCriterion("amount_money in", values, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyNotIn(List<BigDecimal> values) {
            addCriterion("amount_money not in", values, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_money between", value1, value2, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andAmountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_money not between", value1, value2, "amountMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentNameIsNull() {
            addCriterion("payment_name is null");
            return (Criteria) this;
        }

        public Criteria andPaymentNameIsNotNull() {
            addCriterion("payment_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentNameEqualTo(String value) {
            addCriterion("payment_name =", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameNotEqualTo(String value) {
            addCriterion("payment_name <>", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameGreaterThan(String value) {
            addCriterion("payment_name >", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameGreaterThanOrEqualTo(String value) {
            addCriterion("payment_name >=", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameLessThan(String value) {
            addCriterion("payment_name <", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameLessThanOrEqualTo(String value) {
            addCriterion("payment_name <=", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameLike(String value) {
            addCriterion("payment_name like", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameNotLike(String value) {
            addCriterion("payment_name not like", value, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameIn(List<String> values) {
            addCriterion("payment_name in", values, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameNotIn(List<String> values) {
            addCriterion("payment_name not in", values, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameBetween(String value1, String value2) {
            addCriterion("payment_name between", value1, value2, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentNameNotBetween(String value1, String value2) {
            addCriterion("payment_name not between", value1, value2, "paymentName");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberIsNull() {
            addCriterion("payment_account_number is null");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberIsNotNull() {
            addCriterion("payment_account_number is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberEqualTo(String value) {
            addCriterion("payment_account_number =", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberNotEqualTo(String value) {
            addCriterion("payment_account_number <>", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberGreaterThan(String value) {
            addCriterion("payment_account_number >", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("payment_account_number >=", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberLessThan(String value) {
            addCriterion("payment_account_number <", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("payment_account_number <=", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberLike(String value) {
            addCriterion("payment_account_number like", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberNotLike(String value) {
            addCriterion("payment_account_number not like", value, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberIn(List<String> values) {
            addCriterion("payment_account_number in", values, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberNotIn(List<String> values) {
            addCriterion("payment_account_number not in", values, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberBetween(String value1, String value2) {
            addCriterion("payment_account_number between", value1, value2, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentAccountNumberNotBetween(String value1, String value2) {
            addCriterion("payment_account_number not between", value1, value2, "paymentAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Long value) {
            addCriterion("payment_id =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Long value) {
            addCriterion("payment_id <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Long value) {
            addCriterion("payment_id >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_id >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Long value) {
            addCriterion("payment_id <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Long value) {
            addCriterion("payment_id <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Long> values) {
            addCriterion("payment_id in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Long> values) {
            addCriterion("payment_id not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Long value1, Long value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Long value1, Long value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
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