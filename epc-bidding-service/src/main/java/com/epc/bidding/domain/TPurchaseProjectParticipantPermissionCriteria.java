package com.epc.bidding.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPurchaseProjectParticipantPermissionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaseProjectParticipantPermissionCriteria() {
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

        public Criteria andParticipantIdIsNull() {
            addCriterion("participant_id is null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdIsNotNull() {
            addCriterion("participant_id is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdEqualTo(Long value) {
            addCriterion("participant_id =", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotEqualTo(Long value) {
            addCriterion("participant_id <>", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdGreaterThan(Long value) {
            addCriterion("participant_id >", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("participant_id >=", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLessThan(Long value) {
            addCriterion("participant_id <", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLessThanOrEqualTo(Long value) {
            addCriterion("participant_id <=", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdIn(List<Long> values) {
            addCriterion("participant_id in", values, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotIn(List<Long> values) {
            addCriterion("participant_id not in", values, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdBetween(Long value1, Long value2) {
            addCriterion("participant_id between", value1, value2, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotBetween(Long value1, Long value2) {
            addCriterion("participant_id not between", value1, value2, "participantId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeIsNull() {
            addCriterion("participant_type is null");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeIsNotNull() {
            addCriterion("participant_type is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeEqualTo(Integer value) {
            addCriterion("participant_type =", value, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeNotEqualTo(Integer value) {
            addCriterion("participant_type <>", value, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeGreaterThan(Integer value) {
            addCriterion("participant_type >", value, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("participant_type >=", value, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeLessThan(Integer value) {
            addCriterion("participant_type <", value, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeLessThanOrEqualTo(Integer value) {
            addCriterion("participant_type <=", value, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeIn(List<Integer> values) {
            addCriterion("participant_type in", values, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeNotIn(List<Integer> values) {
            addCriterion("participant_type not in", values, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeBetween(Integer value1, Integer value2) {
            addCriterion("participant_type between", value1, value2, "participantType");
            return (Criteria) this;
        }

        public Criteria andParticipantTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("participant_type not between", value1, value2, "participantType");
            return (Criteria) this;
        }

        public Criteria andActionStateIsNull() {
            addCriterion("action_state is null");
            return (Criteria) this;
        }

        public Criteria andActionStateIsNotNull() {
            addCriterion("action_state is not null");
            return (Criteria) this;
        }

        public Criteria andActionStateEqualTo(Integer value) {
            addCriterion("action_state =", value, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateNotEqualTo(Integer value) {
            addCriterion("action_state <>", value, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateGreaterThan(Integer value) {
            addCriterion("action_state >", value, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_state >=", value, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateLessThan(Integer value) {
            addCriterion("action_state <", value, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateLessThanOrEqualTo(Integer value) {
            addCriterion("action_state <=", value, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateIn(List<Integer> values) {
            addCriterion("action_state in", values, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateNotIn(List<Integer> values) {
            addCriterion("action_state not in", values, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateBetween(Integer value1, Integer value2) {
            addCriterion("action_state between", value1, value2, "actionState");
            return (Criteria) this;
        }

        public Criteria andActionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("action_state not between", value1, value2, "actionState");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNull() {
            addCriterion("step_type is null");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNotNull() {
            addCriterion("step_type is not null");
            return (Criteria) this;
        }

        public Criteria andStepTypeEqualTo(String value) {
            addCriterion("step_type =", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotEqualTo(String value) {
            addCriterion("step_type <>", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThan(String value) {
            addCriterion("step_type >", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThanOrEqualTo(String value) {
            addCriterion("step_type >=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThan(String value) {
            addCriterion("step_type <", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThanOrEqualTo(String value) {
            addCriterion("step_type <=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLike(String value) {
            addCriterion("step_type like", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotLike(String value) {
            addCriterion("step_type not like", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeIn(List<String> values) {
            addCriterion("step_type in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotIn(List<String> values) {
            addCriterion("step_type not in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeBetween(String value1, String value2) {
            addCriterion("step_type between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotBetween(String value1, String value2) {
            addCriterion("step_type not between", value1, value2, "stepType");
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

        public Criteria andParticipantPermissionIsNull() {
            addCriterion("participant_permission is null");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionIsNotNull() {
            addCriterion("participant_permission is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionEqualTo(String value) {
            addCriterion("participant_permission =", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionNotEqualTo(String value) {
            addCriterion("participant_permission <>", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionGreaterThan(String value) {
            addCriterion("participant_permission >", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("participant_permission >=", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionLessThan(String value) {
            addCriterion("participant_permission <", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionLessThanOrEqualTo(String value) {
            addCriterion("participant_permission <=", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionLike(String value) {
            addCriterion("participant_permission like", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionNotLike(String value) {
            addCriterion("participant_permission not like", value, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionIn(List<String> values) {
            addCriterion("participant_permission in", values, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionNotIn(List<String> values) {
            addCriterion("participant_permission not in", values, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionBetween(String value1, String value2) {
            addCriterion("participant_permission between", value1, value2, "participantPermission");
            return (Criteria) this;
        }

        public Criteria andParticipantPermissionNotBetween(String value1, String value2) {
            addCriterion("participant_permission not between", value1, value2, "participantPermission");
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