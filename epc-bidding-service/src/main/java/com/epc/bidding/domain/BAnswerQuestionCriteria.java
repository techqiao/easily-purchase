package com.epc.bidding.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BAnswerQuestionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BAnswerQuestionCriteria() {
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

        public Criteria andQuestionerIdIsNull() {
            addCriterion("questioner_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdIsNotNull() {
            addCriterion("questioner_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdEqualTo(Long value) {
            addCriterion("questioner_id =", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdNotEqualTo(Long value) {
            addCriterion("questioner_id <>", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdGreaterThan(Long value) {
            addCriterion("questioner_id >", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("questioner_id >=", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdLessThan(Long value) {
            addCriterion("questioner_id <", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdLessThanOrEqualTo(Long value) {
            addCriterion("questioner_id <=", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdIn(List<Long> values) {
            addCriterion("questioner_id in", values, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdNotIn(List<Long> values) {
            addCriterion("questioner_id not in", values, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdBetween(Long value1, Long value2) {
            addCriterion("questioner_id between", value1, value2, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdNotBetween(Long value1, Long value2) {
            addCriterion("questioner_id not between", value1, value2, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("question_type is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("question_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(String value) {
            addCriterion("question_type =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(String value) {
            addCriterion("question_type <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(String value) {
            addCriterion("question_type >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("question_type >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(String value) {
            addCriterion("question_type <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(String value) {
            addCriterion("question_type <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLike(String value) {
            addCriterion("question_type like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotLike(String value) {
            addCriterion("question_type not like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<String> values) {
            addCriterion("question_type in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<String> values) {
            addCriterion("question_type not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(String value1, String value2) {
            addCriterion("question_type between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(String value1, String value2) {
            addCriterion("question_type not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameIsNull() {
            addCriterion("questioner_name is null");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameIsNotNull() {
            addCriterion("questioner_name is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameEqualTo(String value) {
            addCriterion("questioner_name =", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameNotEqualTo(String value) {
            addCriterion("questioner_name <>", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameGreaterThan(String value) {
            addCriterion("questioner_name >", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameGreaterThanOrEqualTo(String value) {
            addCriterion("questioner_name >=", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameLessThan(String value) {
            addCriterion("questioner_name <", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameLessThanOrEqualTo(String value) {
            addCriterion("questioner_name <=", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameLike(String value) {
            addCriterion("questioner_name like", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameNotLike(String value) {
            addCriterion("questioner_name not like", value, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameIn(List<String> values) {
            addCriterion("questioner_name in", values, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameNotIn(List<String> values) {
            addCriterion("questioner_name not in", values, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameBetween(String value1, String value2) {
            addCriterion("questioner_name between", value1, value2, "questionerName");
            return (Criteria) this;
        }

        public Criteria andQuestionerNameNotBetween(String value1, String value2) {
            addCriterion("questioner_name not between", value1, value2, "questionerName");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Long value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Long value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Long value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Long value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Long> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Long> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Long value1, Long value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Long value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Long value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Long value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Long value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Long value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Long> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Long> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Long value1, Long value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Long value1, Long value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIsNull() {
            addCriterion("answer_name is null");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIsNotNull() {
            addCriterion("answer_name is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerNameEqualTo(String value) {
            addCriterion("answer_name =", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotEqualTo(String value) {
            addCriterion("answer_name <>", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameGreaterThan(String value) {
            addCriterion("answer_name >", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameGreaterThanOrEqualTo(String value) {
            addCriterion("answer_name >=", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLessThan(String value) {
            addCriterion("answer_name <", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLessThanOrEqualTo(String value) {
            addCriterion("answer_name <=", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLike(String value) {
            addCriterion("answer_name like", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotLike(String value) {
            addCriterion("answer_name not like", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIn(List<String> values) {
            addCriterion("answer_name in", values, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotIn(List<String> values) {
            addCriterion("answer_name not in", values, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameBetween(String value1, String value2) {
            addCriterion("answer_name between", value1, value2, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotBetween(String value1, String value2) {
            addCriterion("answer_name not between", value1, value2, "answerName");
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

        public Criteria andAnswerPersonTypeIsNull() {
            addCriterion("answer_person_type is null");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeIsNotNull() {
            addCriterion("answer_person_type is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeEqualTo(String value) {
            addCriterion("answer_person_type =", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeNotEqualTo(String value) {
            addCriterion("answer_person_type <>", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeGreaterThan(String value) {
            addCriterion("answer_person_type >", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("answer_person_type >=", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeLessThan(String value) {
            addCriterion("answer_person_type <", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeLessThanOrEqualTo(String value) {
            addCriterion("answer_person_type <=", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeLike(String value) {
            addCriterion("answer_person_type like", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeNotLike(String value) {
            addCriterion("answer_person_type not like", value, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeIn(List<String> values) {
            addCriterion("answer_person_type in", values, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeNotIn(List<String> values) {
            addCriterion("answer_person_type not in", values, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeBetween(String value1, String value2) {
            addCriterion("answer_person_type between", value1, value2, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andAnswerPersonTypeNotBetween(String value1, String value2) {
            addCriterion("answer_person_type not between", value1, value2, "answerPersonType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeIsNull() {
            addCriterion("questioner_from_type is null");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeIsNotNull() {
            addCriterion("questioner_from_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeEqualTo(String value) {
            addCriterion("questioner_from_type =", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeNotEqualTo(String value) {
            addCriterion("questioner_from_type <>", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeGreaterThan(String value) {
            addCriterion("questioner_from_type >", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeGreaterThanOrEqualTo(String value) {
            addCriterion("questioner_from_type >=", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeLessThan(String value) {
            addCriterion("questioner_from_type <", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeLessThanOrEqualTo(String value) {
            addCriterion("questioner_from_type <=", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeLike(String value) {
            addCriterion("questioner_from_type like", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeNotLike(String value) {
            addCriterion("questioner_from_type not like", value, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeIn(List<String> values) {
            addCriterion("questioner_from_type in", values, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeNotIn(List<String> values) {
            addCriterion("questioner_from_type not in", values, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeBetween(String value1, String value2) {
            addCriterion("questioner_from_type between", value1, value2, "questionerFromType");
            return (Criteria) this;
        }

        public Criteria andQuestionerFromTypeNotBetween(String value1, String value2) {
            addCriterion("questioner_from_type not between", value1, value2, "questionerFromType");
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