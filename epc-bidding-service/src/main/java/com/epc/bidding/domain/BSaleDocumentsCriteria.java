package com.epc.bidding.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BSaleDocumentsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSaleDocumentsCriteria() {
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

        public Criteria andAuditorIdIsNull() {
            addCriterion("auditor_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIsNotNull() {
            addCriterion("auditor_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorIdEqualTo(Long value) {
            addCriterion("auditor_id =", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotEqualTo(Long value) {
            addCriterion("auditor_id <>", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdGreaterThan(Long value) {
            addCriterion("auditor_id >", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("auditor_id >=", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLessThan(Long value) {
            addCriterion("auditor_id <", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLessThanOrEqualTo(Long value) {
            addCriterion("auditor_id <=", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIn(List<Long> values) {
            addCriterion("auditor_id in", values, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotIn(List<Long> values) {
            addCriterion("auditor_id not in", values, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdBetween(Long value1, Long value2) {
            addCriterion("auditor_id between", value1, value2, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotBetween(Long value1, Long value2) {
            addCriterion("auditor_id not between", value1, value2, "auditorId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdIsNull() {
            addCriterion("replies_id is null");
            return (Criteria) this;
        }

        public Criteria andRepliesIdIsNotNull() {
            addCriterion("replies_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepliesIdEqualTo(Long value) {
            addCriterion("replies_id =", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdNotEqualTo(Long value) {
            addCriterion("replies_id <>", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdGreaterThan(Long value) {
            addCriterion("replies_id >", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdGreaterThanOrEqualTo(Long value) {
            addCriterion("replies_id >=", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdLessThan(Long value) {
            addCriterion("replies_id <", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdLessThanOrEqualTo(Long value) {
            addCriterion("replies_id <=", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdIn(List<Long> values) {
            addCriterion("replies_id in", values, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdNotIn(List<Long> values) {
            addCriterion("replies_id not in", values, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdBetween(Long value1, Long value2) {
            addCriterion("replies_id between", value1, value2, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdNotBetween(Long value1, Long value2) {
            addCriterion("replies_id not between", value1, value2, "repliesId");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlIsNull() {
            addCriterion("bidding_documents_up_url is null");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlIsNotNull() {
            addCriterion("bidding_documents_up_url is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlEqualTo(String value) {
            addCriterion("bidding_documents_up_url =", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlNotEqualTo(String value) {
            addCriterion("bidding_documents_up_url <>", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlGreaterThan(String value) {
            addCriterion("bidding_documents_up_url >", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bidding_documents_up_url >=", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlLessThan(String value) {
            addCriterion("bidding_documents_up_url <", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlLessThanOrEqualTo(String value) {
            addCriterion("bidding_documents_up_url <=", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlLike(String value) {
            addCriterion("bidding_documents_up_url like", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlNotLike(String value) {
            addCriterion("bidding_documents_up_url not like", value, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlIn(List<String> values) {
            addCriterion("bidding_documents_up_url in", values, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlNotIn(List<String> values) {
            addCriterion("bidding_documents_up_url not in", values, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlBetween(String value1, String value2) {
            addCriterion("bidding_documents_up_url between", value1, value2, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUpUrlNotBetween(String value1, String value2) {
            addCriterion("bidding_documents_up_url not between", value1, value2, "biddingDocumentsUpUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlIsNull() {
            addCriterion("bidding_documents_download_url is null");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlIsNotNull() {
            addCriterion("bidding_documents_download_url is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlEqualTo(String value) {
            addCriterion("bidding_documents_download_url =", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlNotEqualTo(String value) {
            addCriterion("bidding_documents_download_url <>", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlGreaterThan(String value) {
            addCriterion("bidding_documents_download_url >", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bidding_documents_download_url >=", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlLessThan(String value) {
            addCriterion("bidding_documents_download_url <", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("bidding_documents_download_url <=", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlLike(String value) {
            addCriterion("bidding_documents_download_url like", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlNotLike(String value) {
            addCriterion("bidding_documents_download_url not like", value, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlIn(List<String> values) {
            addCriterion("bidding_documents_download_url in", values, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlNotIn(List<String> values) {
            addCriterion("bidding_documents_download_url not in", values, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlBetween(String value1, String value2) {
            addCriterion("bidding_documents_download_url between", value1, value2, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("bidding_documents_download_url not between", value1, value2, "biddingDocumentsDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineIsNull() {
            addCriterion("is_under_line is null");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineIsNotNull() {
            addCriterion("is_under_line is not null");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineEqualTo(Integer value) {
            addCriterion("is_under_line =", value, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineNotEqualTo(Integer value) {
            addCriterion("is_under_line <>", value, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineGreaterThan(Integer value) {
            addCriterion("is_under_line >", value, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_under_line >=", value, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineLessThan(Integer value) {
            addCriterion("is_under_line <", value, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineLessThanOrEqualTo(Integer value) {
            addCriterion("is_under_line <=", value, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineIn(List<Integer> values) {
            addCriterion("is_under_line in", values, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineNotIn(List<Integer> values) {
            addCriterion("is_under_line not in", values, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineBetween(Integer value1, Integer value2) {
            addCriterion("is_under_line between", value1, value2, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andIsUnderLineNotBetween(Integer value1, Integer value2) {
            addCriterion("is_under_line not between", value1, value2, "isUnderLine");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeIsNull() {
            addCriterion("bidding_end_time is null");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeIsNotNull() {
            addCriterion("bidding_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeEqualTo(Date value) {
            addCriterion("bidding_end_time =", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeNotEqualTo(Date value) {
            addCriterion("bidding_end_time <>", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeGreaterThan(Date value) {
            addCriterion("bidding_end_time >", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bidding_end_time >=", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeLessThan(Date value) {
            addCriterion("bidding_end_time <", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("bidding_end_time <=", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeIn(List<Date> values) {
            addCriterion("bidding_end_time in", values, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeNotIn(List<Date> values) {
            addCriterion("bidding_end_time not in", values, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeBetween(Date value1, Date value2) {
            addCriterion("bidding_end_time between", value1, value2, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("bidding_end_time not between", value1, value2, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeIsNull() {
            addCriterion("bidding_bond_end_time is null");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeIsNotNull() {
            addCriterion("bidding_bond_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeEqualTo(Date value) {
            addCriterion("bidding_bond_end_time =", value, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeNotEqualTo(Date value) {
            addCriterion("bidding_bond_end_time <>", value, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeGreaterThan(Date value) {
            addCriterion("bidding_bond_end_time >", value, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bidding_bond_end_time >=", value, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeLessThan(Date value) {
            addCriterion("bidding_bond_end_time <", value, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("bidding_bond_end_time <=", value, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeIn(List<Date> values) {
            addCriterion("bidding_bond_end_time in", values, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeNotIn(List<Date> values) {
            addCriterion("bidding_bond_end_time not in", values, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeBetween(Date value1, Date value2) {
            addCriterion("bidding_bond_end_time between", value1, value2, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingBondEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("bidding_bond_end_time not between", value1, value2, "biddingBondEndTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeIsNull() {
            addCriterion("bid_opening_time is null");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeIsNotNull() {
            addCriterion("bid_opening_time is not null");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeEqualTo(Date value) {
            addCriterion("bid_opening_time =", value, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeNotEqualTo(Date value) {
            addCriterion("bid_opening_time <>", value, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeGreaterThan(Date value) {
            addCriterion("bid_opening_time >", value, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bid_opening_time >=", value, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeLessThan(Date value) {
            addCriterion("bid_opening_time <", value, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeLessThanOrEqualTo(Date value) {
            addCriterion("bid_opening_time <=", value, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeIn(List<Date> values) {
            addCriterion("bid_opening_time in", values, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeNotIn(List<Date> values) {
            addCriterion("bid_opening_time not in", values, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeBetween(Date value1, Date value2) {
            addCriterion("bid_opening_time between", value1, value2, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningTimeNotBetween(Date value1, Date value2) {
            addCriterion("bid_opening_time not between", value1, value2, "bidOpeningTime");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceIsNull() {
            addCriterion("bid_opening_place is null");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceIsNotNull() {
            addCriterion("bid_opening_place is not null");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceEqualTo(String value) {
            addCriterion("bid_opening_place =", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceNotEqualTo(String value) {
            addCriterion("bid_opening_place <>", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceGreaterThan(String value) {
            addCriterion("bid_opening_place >", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("bid_opening_place >=", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceLessThan(String value) {
            addCriterion("bid_opening_place <", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceLessThanOrEqualTo(String value) {
            addCriterion("bid_opening_place <=", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceLike(String value) {
            addCriterion("bid_opening_place like", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceNotLike(String value) {
            addCriterion("bid_opening_place not like", value, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceIn(List<String> values) {
            addCriterion("bid_opening_place in", values, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceNotIn(List<String> values) {
            addCriterion("bid_opening_place not in", values, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceBetween(String value1, String value2) {
            addCriterion("bid_opening_place between", value1, value2, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andBidOpeningPlaceNotBetween(String value1, String value2) {
            addCriterion("bid_opening_place not between", value1, value2, "bidOpeningPlace");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeIsNull() {
            addCriterion("clarification_problem_end_time is null");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeIsNotNull() {
            addCriterion("clarification_problem_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeEqualTo(Date value) {
            addCriterion("clarification_problem_end_time =", value, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeNotEqualTo(Date value) {
            addCriterion("clarification_problem_end_time <>", value, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeGreaterThan(Date value) {
            addCriterion("clarification_problem_end_time >", value, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clarification_problem_end_time >=", value, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeLessThan(Date value) {
            addCriterion("clarification_problem_end_time <", value, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("clarification_problem_end_time <=", value, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeIn(List<Date> values) {
            addCriterion("clarification_problem_end_time in", values, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeNotIn(List<Date> values) {
            addCriterion("clarification_problem_end_time not in", values, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeBetween(Date value1, Date value2) {
            addCriterion("clarification_problem_end_time between", value1, value2, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andClarificationProblemEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("clarification_problem_end_time not between", value1, value2, "clarificationProblemEndTime");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodIsNull() {
            addCriterion("decryption_method is null");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodIsNotNull() {
            addCriterion("decryption_method is not null");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodEqualTo(Integer value) {
            addCriterion("decryption_method =", value, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodNotEqualTo(Integer value) {
            addCriterion("decryption_method <>", value, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodGreaterThan(Integer value) {
            addCriterion("decryption_method >", value, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("decryption_method >=", value, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodLessThan(Integer value) {
            addCriterion("decryption_method <", value, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodLessThanOrEqualTo(Integer value) {
            addCriterion("decryption_method <=", value, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodIn(List<Integer> values) {
            addCriterion("decryption_method in", values, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodNotIn(List<Integer> values) {
            addCriterion("decryption_method not in", values, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodBetween(Integer value1, Integer value2) {
            addCriterion("decryption_method between", value1, value2, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andDecryptionMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("decryption_method not between", value1, value2, "decryptionMethod");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("process_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("process_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(Integer value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(Integer value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(Integer value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(Integer value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(Integer value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<Integer> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<Integer> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(Integer value1, Integer value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("process_status not between", value1, value2, "processStatus");
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