package com.epc.bidding.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BReleaseAnnouncementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BReleaseAnnouncementCriteria() {
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

        public Criteria andBiddingDocumentsUrlIsNull() {
            addCriterion("bidding_documents_url is null");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlIsNotNull() {
            addCriterion("bidding_documents_url is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlEqualTo(String value) {
            addCriterion("bidding_documents_url =", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlNotEqualTo(String value) {
            addCriterion("bidding_documents_url <>", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlGreaterThan(String value) {
            addCriterion("bidding_documents_url >", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bidding_documents_url >=", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlLessThan(String value) {
            addCriterion("bidding_documents_url <", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlLessThanOrEqualTo(String value) {
            addCriterion("bidding_documents_url <=", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlLike(String value) {
            addCriterion("bidding_documents_url like", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlNotLike(String value) {
            addCriterion("bidding_documents_url not like", value, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlIn(List<String> values) {
            addCriterion("bidding_documents_url in", values, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlNotIn(List<String> values) {
            addCriterion("bidding_documents_url not in", values, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlBetween(String value1, String value2) {
            addCriterion("bidding_documents_url between", value1, value2, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingDocumentsUrlNotBetween(String value1, String value2) {
            addCriterion("bidding_documents_url not between", value1, value2, "biddingDocumentsUrl");
            return (Criteria) this;
        }

        public Criteria andBiddingStartIsNull() {
            addCriterion("bidding_start is null");
            return (Criteria) this;
        }

        public Criteria andBiddingStartIsNotNull() {
            addCriterion("bidding_start is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingStartEqualTo(Date value) {
            addCriterion("bidding_start =", value, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartNotEqualTo(Date value) {
            addCriterion("bidding_start <>", value, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartGreaterThan(Date value) {
            addCriterion("bidding_start >", value, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartGreaterThanOrEqualTo(Date value) {
            addCriterion("bidding_start >=", value, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartLessThan(Date value) {
            addCriterion("bidding_start <", value, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartLessThanOrEqualTo(Date value) {
            addCriterion("bidding_start <=", value, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartIn(List<Date> values) {
            addCriterion("bidding_start in", values, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartNotIn(List<Date> values) {
            addCriterion("bidding_start not in", values, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartBetween(Date value1, Date value2) {
            addCriterion("bidding_start between", value1, value2, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingStartNotBetween(Date value1, Date value2) {
            addCriterion("bidding_start not between", value1, value2, "biddingStart");
            return (Criteria) this;
        }

        public Criteria andBiddingEndIsNull() {
            addCriterion("bidding_end is null");
            return (Criteria) this;
        }

        public Criteria andBiddingEndIsNotNull() {
            addCriterion("bidding_end is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingEndEqualTo(Date value) {
            addCriterion("bidding_end =", value, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndNotEqualTo(Date value) {
            addCriterion("bidding_end <>", value, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndGreaterThan(Date value) {
            addCriterion("bidding_end >", value, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndGreaterThanOrEqualTo(Date value) {
            addCriterion("bidding_end >=", value, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndLessThan(Date value) {
            addCriterion("bidding_end <", value, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndLessThanOrEqualTo(Date value) {
            addCriterion("bidding_end <=", value, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndIn(List<Date> values) {
            addCriterion("bidding_end in", values, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndNotIn(List<Date> values) {
            addCriterion("bidding_end not in", values, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndBetween(Date value1, Date value2) {
            addCriterion("bidding_end between", value1, value2, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andBiddingEndNotBetween(Date value1, Date value2) {
            addCriterion("bidding_end not between", value1, value2, "biddingEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationStartIsNull() {
            addCriterion("defecation_start is null");
            return (Criteria) this;
        }

        public Criteria andDefecationStartIsNotNull() {
            addCriterion("defecation_start is not null");
            return (Criteria) this;
        }

        public Criteria andDefecationStartEqualTo(Date value) {
            addCriterion("defecation_start =", value, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartNotEqualTo(Date value) {
            addCriterion("defecation_start <>", value, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartGreaterThan(Date value) {
            addCriterion("defecation_start >", value, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartGreaterThanOrEqualTo(Date value) {
            addCriterion("defecation_start >=", value, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartLessThan(Date value) {
            addCriterion("defecation_start <", value, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartLessThanOrEqualTo(Date value) {
            addCriterion("defecation_start <=", value, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartIn(List<Date> values) {
            addCriterion("defecation_start in", values, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartNotIn(List<Date> values) {
            addCriterion("defecation_start not in", values, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartBetween(Date value1, Date value2) {
            addCriterion("defecation_start between", value1, value2, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationStartNotBetween(Date value1, Date value2) {
            addCriterion("defecation_start not between", value1, value2, "defecationStart");
            return (Criteria) this;
        }

        public Criteria andDefecationEndIsNull() {
            addCriterion("defecation_end is null");
            return (Criteria) this;
        }

        public Criteria andDefecationEndIsNotNull() {
            addCriterion("defecation_end is not null");
            return (Criteria) this;
        }

        public Criteria andDefecationEndEqualTo(Date value) {
            addCriterion("defecation_end =", value, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndNotEqualTo(Date value) {
            addCriterion("defecation_end <>", value, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndGreaterThan(Date value) {
            addCriterion("defecation_end >", value, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndGreaterThanOrEqualTo(Date value) {
            addCriterion("defecation_end >=", value, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndLessThan(Date value) {
            addCriterion("defecation_end <", value, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndLessThanOrEqualTo(Date value) {
            addCriterion("defecation_end <=", value, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndIn(List<Date> values) {
            addCriterion("defecation_end in", values, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndNotIn(List<Date> values) {
            addCriterion("defecation_end not in", values, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndBetween(Date value1, Date value2) {
            addCriterion("defecation_end between", value1, value2, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andDefecationEndNotBetween(Date value1, Date value2) {
            addCriterion("defecation_end not between", value1, value2, "defecationEnd");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andProcessStatusEqualTo(String value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(String value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(String value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(String value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(String value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLike(String value) {
            addCriterion("process_status like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotLike(String value) {
            addCriterion("process_status not like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<String> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<String> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(String value1, String value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(String value1, String value2) {
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