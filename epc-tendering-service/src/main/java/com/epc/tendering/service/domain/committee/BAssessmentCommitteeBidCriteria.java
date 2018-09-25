package com.epc.tendering.service.domain.committee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BAssessmentCommitteeBidCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BAssessmentCommitteeBidCriteria() {
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

        public Criteria andCommitteeIdIsNull() {
            addCriterion("committee_id is null");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdIsNotNull() {
            addCriterion("committee_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdEqualTo(Long value) {
            addCriterion("committee_id =", value, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdNotEqualTo(Long value) {
            addCriterion("committee_id <>", value, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdGreaterThan(Long value) {
            addCriterion("committee_id >", value, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("committee_id >=", value, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdLessThan(Long value) {
            addCriterion("committee_id <", value, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdLessThanOrEqualTo(Long value) {
            addCriterion("committee_id <=", value, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdIn(List<Long> values) {
            addCriterion("committee_id in", values, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdNotIn(List<Long> values) {
            addCriterion("committee_id not in", values, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdBetween(Long value1, Long value2) {
            addCriterion("committee_id between", value1, value2, "committeeId");
            return (Criteria) this;
        }

        public Criteria andCommitteeIdNotBetween(Long value1, Long value2) {
            addCriterion("committee_id not between", value1, value2, "committeeId");
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

        public Criteria andProfessionalNumberIsNull() {
            addCriterion("professional_number is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberIsNotNull() {
            addCriterion("professional_number is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberEqualTo(Integer value) {
            addCriterion("professional_number =", value, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberNotEqualTo(Integer value) {
            addCriterion("professional_number <>", value, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberGreaterThan(Integer value) {
            addCriterion("professional_number >", value, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("professional_number >=", value, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberLessThan(Integer value) {
            addCriterion("professional_number <", value, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("professional_number <=", value, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberIn(List<Integer> values) {
            addCriterion("professional_number in", values, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberNotIn(List<Integer> values) {
            addCriterion("professional_number not in", values, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberBetween(Integer value1, Integer value2) {
            addCriterion("professional_number between", value1, value2, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("professional_number not between", value1, value2, "professionalNumber");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameIsNull() {
            addCriterion("professional_name is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameIsNotNull() {
            addCriterion("professional_name is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameEqualTo(String value) {
            addCriterion("professional_name =", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotEqualTo(String value) {
            addCriterion("professional_name <>", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameGreaterThan(String value) {
            addCriterion("professional_name >", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameGreaterThanOrEqualTo(String value) {
            addCriterion("professional_name >=", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameLessThan(String value) {
            addCriterion("professional_name <", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameLessThanOrEqualTo(String value) {
            addCriterion("professional_name <=", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameLike(String value) {
            addCriterion("professional_name like", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotLike(String value) {
            addCriterion("professional_name not like", value, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameIn(List<String> values) {
            addCriterion("professional_name in", values, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotIn(List<String> values) {
            addCriterion("professional_name not in", values, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameBetween(String value1, String value2) {
            addCriterion("professional_name between", value1, value2, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalNameNotBetween(String value1, String value2) {
            addCriterion("professional_name not between", value1, value2, "professionalName");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelIsNull() {
            addCriterion("professional_level is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelIsNotNull() {
            addCriterion("professional_level is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelEqualTo(String value) {
            addCriterion("professional_level =", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelNotEqualTo(String value) {
            addCriterion("professional_level <>", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelGreaterThan(String value) {
            addCriterion("professional_level >", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelGreaterThanOrEqualTo(String value) {
            addCriterion("professional_level >=", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelLessThan(String value) {
            addCriterion("professional_level <", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelLessThanOrEqualTo(String value) {
            addCriterion("professional_level <=", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelLike(String value) {
            addCriterion("professional_level like", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelNotLike(String value) {
            addCriterion("professional_level not like", value, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelIn(List<String> values) {
            addCriterion("professional_level in", values, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelNotIn(List<String> values) {
            addCriterion("professional_level not in", values, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelBetween(String value1, String value2) {
            addCriterion("professional_level between", value1, value2, "professionalLevel");
            return (Criteria) this;
        }

        public Criteria andProfessionalLevelNotBetween(String value1, String value2) {
            addCriterion("professional_level not between", value1, value2, "professionalLevel");
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