package com.epc.tendering.service.domain.bid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BSaleDocumentsFileCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSaleDocumentsFileCriteria() {
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

        public Criteria andSaleDocumentsIdIsNull() {
            addCriterion("sale_documents_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdIsNotNull() {
            addCriterion("sale_documents_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdEqualTo(Long value) {
            addCriterion("sale_documents_id =", value, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdNotEqualTo(Long value) {
            addCriterion("sale_documents_id <>", value, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdGreaterThan(Long value) {
            addCriterion("sale_documents_id >", value, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sale_documents_id >=", value, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdLessThan(Long value) {
            addCriterion("sale_documents_id <", value, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdLessThanOrEqualTo(Long value) {
            addCriterion("sale_documents_id <=", value, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdIn(List<Long> values) {
            addCriterion("sale_documents_id in", values, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdNotIn(List<Long> values) {
            addCriterion("sale_documents_id not in", values, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdBetween(Long value1, Long value2) {
            addCriterion("sale_documents_id between", value1, value2, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andSaleDocumentsIdNotBetween(Long value1, Long value2) {
            addCriterion("sale_documents_id not between", value1, value2, "saleDocumentsId");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlIsNull() {
            addCriterion("announcement_url is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlIsNotNull() {
            addCriterion("announcement_url is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlEqualTo(String value) {
            addCriterion("announcement_url =", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlNotEqualTo(String value) {
            addCriterion("announcement_url <>", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlGreaterThan(String value) {
            addCriterion("announcement_url >", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_url >=", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlLessThan(String value) {
            addCriterion("announcement_url <", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlLessThanOrEqualTo(String value) {
            addCriterion("announcement_url <=", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlLike(String value) {
            addCriterion("announcement_url like", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlNotLike(String value) {
            addCriterion("announcement_url not like", value, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlIn(List<String> values) {
            addCriterion("announcement_url in", values, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlNotIn(List<String> values) {
            addCriterion("announcement_url not in", values, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlBetween(String value1, String value2) {
            addCriterion("announcement_url between", value1, value2, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andAnnouncementUrlNotBetween(String value1, String value2) {
            addCriterion("announcement_url not between", value1, value2, "announcementUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlIsNull() {
            addCriterion("notice_bidder_url is null");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlIsNotNull() {
            addCriterion("notice_bidder_url is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlEqualTo(String value) {
            addCriterion("notice_bidder_url =", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlNotEqualTo(String value) {
            addCriterion("notice_bidder_url <>", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlGreaterThan(String value) {
            addCriterion("notice_bidder_url >", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notice_bidder_url >=", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlLessThan(String value) {
            addCriterion("notice_bidder_url <", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlLessThanOrEqualTo(String value) {
            addCriterion("notice_bidder_url <=", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlLike(String value) {
            addCriterion("notice_bidder_url like", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlNotLike(String value) {
            addCriterion("notice_bidder_url not like", value, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlIn(List<String> values) {
            addCriterion("notice_bidder_url in", values, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlNotIn(List<String> values) {
            addCriterion("notice_bidder_url not in", values, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlBetween(String value1, String value2) {
            addCriterion("notice_bidder_url between", value1, value2, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeBidderUrlNotBetween(String value1, String value2) {
            addCriterion("notice_bidder_url not between", value1, value2, "noticeBidderUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlIsNull() {
            addCriterion("technical_requirement_url is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlIsNotNull() {
            addCriterion("technical_requirement_url is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlEqualTo(String value) {
            addCriterion("technical_requirement_url =", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlNotEqualTo(String value) {
            addCriterion("technical_requirement_url <>", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlGreaterThan(String value) {
            addCriterion("technical_requirement_url >", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlGreaterThanOrEqualTo(String value) {
            addCriterion("technical_requirement_url >=", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlLessThan(String value) {
            addCriterion("technical_requirement_url <", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlLessThanOrEqualTo(String value) {
            addCriterion("technical_requirement_url <=", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlLike(String value) {
            addCriterion("technical_requirement_url like", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlNotLike(String value) {
            addCriterion("technical_requirement_url not like", value, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlIn(List<String> values) {
            addCriterion("technical_requirement_url in", values, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlNotIn(List<String> values) {
            addCriterion("technical_requirement_url not in", values, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlBetween(String value1, String value2) {
            addCriterion("technical_requirement_url between", value1, value2, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTechnicalRequirementUrlNotBetween(String value1, String value2) {
            addCriterion("technical_requirement_url not between", value1, value2, "technicalRequirementUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlIsNull() {
            addCriterion("terms_contract_url is null");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlIsNotNull() {
            addCriterion("terms_contract_url is not null");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlEqualTo(String value) {
            addCriterion("terms_contract_url =", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlNotEqualTo(String value) {
            addCriterion("terms_contract_url <>", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlGreaterThan(String value) {
            addCriterion("terms_contract_url >", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlGreaterThanOrEqualTo(String value) {
            addCriterion("terms_contract_url >=", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlLessThan(String value) {
            addCriterion("terms_contract_url <", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlLessThanOrEqualTo(String value) {
            addCriterion("terms_contract_url <=", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlLike(String value) {
            addCriterion("terms_contract_url like", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlNotLike(String value) {
            addCriterion("terms_contract_url not like", value, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlIn(List<String> values) {
            addCriterion("terms_contract_url in", values, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlNotIn(List<String> values) {
            addCriterion("terms_contract_url not in", values, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlBetween(String value1, String value2) {
            addCriterion("terms_contract_url between", value1, value2, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andTermsContractUrlNotBetween(String value1, String value2) {
            addCriterion("terms_contract_url not between", value1, value2, "termsContractUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlIsNull() {
            addCriterion("evaluation_url is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlIsNotNull() {
            addCriterion("evaluation_url is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlEqualTo(String value) {
            addCriterion("evaluation_url =", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlNotEqualTo(String value) {
            addCriterion("evaluation_url <>", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlGreaterThan(String value) {
            addCriterion("evaluation_url >", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation_url >=", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlLessThan(String value) {
            addCriterion("evaluation_url <", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlLessThanOrEqualTo(String value) {
            addCriterion("evaluation_url <=", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlLike(String value) {
            addCriterion("evaluation_url like", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlNotLike(String value) {
            addCriterion("evaluation_url not like", value, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlIn(List<String> values) {
            addCriterion("evaluation_url in", values, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlNotIn(List<String> values) {
            addCriterion("evaluation_url not in", values, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlBetween(String value1, String value2) {
            addCriterion("evaluation_url between", value1, value2, "evaluationUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluationUrlNotBetween(String value1, String value2) {
            addCriterion("evaluation_url not between", value1, value2, "evaluationUrl");
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