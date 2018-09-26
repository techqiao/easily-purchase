package com.epc.tendering.service.domain.bid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BTechnologyTenderStandardCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BTechnologyTenderStandardCriteria() {
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

        public Criteria andEvaluationTenderStandardIdIsNull() {
            addCriterion("evaluation_tender_standard_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdIsNotNull() {
            addCriterion("evaluation_tender_standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdEqualTo(Long value) {
            addCriterion("evaluation_tender_standard_id =", value, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdNotEqualTo(Long value) {
            addCriterion("evaluation_tender_standard_id <>", value, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdGreaterThan(Long value) {
            addCriterion("evaluation_tender_standard_id >", value, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evaluation_tender_standard_id >=", value, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdLessThan(Long value) {
            addCriterion("evaluation_tender_standard_id <", value, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdLessThanOrEqualTo(Long value) {
            addCriterion("evaluation_tender_standard_id <=", value, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdIn(List<Long> values) {
            addCriterion("evaluation_tender_standard_id in", values, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdNotIn(List<Long> values) {
            addCriterion("evaluation_tender_standard_id not in", values, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdBetween(Long value1, Long value2) {
            addCriterion("evaluation_tender_standard_id between", value1, value2, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationTenderStandardIdNotBetween(Long value1, Long value2) {
            addCriterion("evaluation_tender_standard_id not between", value1, value2, "evaluationTenderStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsIsNull() {
            addCriterion("evaluation_factors is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsIsNotNull() {
            addCriterion("evaluation_factors is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsEqualTo(String value) {
            addCriterion("evaluation_factors =", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsNotEqualTo(String value) {
            addCriterion("evaluation_factors <>", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsGreaterThan(String value) {
            addCriterion("evaluation_factors >", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation_factors >=", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsLessThan(String value) {
            addCriterion("evaluation_factors <", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsLessThanOrEqualTo(String value) {
            addCriterion("evaluation_factors <=", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsLike(String value) {
            addCriterion("evaluation_factors like", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsNotLike(String value) {
            addCriterion("evaluation_factors not like", value, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsIn(List<String> values) {
            addCriterion("evaluation_factors in", values, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsNotIn(List<String> values) {
            addCriterion("evaluation_factors not in", values, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsBetween(String value1, String value2) {
            addCriterion("evaluation_factors between", value1, value2, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andEvaluationFactorsNotBetween(String value1, String value2) {
            addCriterion("evaluation_factors not between", value1, value2, "evaluationFactors");
            return (Criteria) this;
        }

        public Criteria andExplainIsNull() {
            addCriterion("explain is null");
            return (Criteria) this;
        }

        public Criteria andExplainIsNotNull() {
            addCriterion("explain is not null");
            return (Criteria) this;
        }

        public Criteria andExplainEqualTo(String value) {
            addCriterion("explain =", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotEqualTo(String value) {
            addCriterion("explain <>", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThan(String value) {
            addCriterion("explain >", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThanOrEqualTo(String value) {
            addCriterion("explain >=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThan(String value) {
            addCriterion("explain <", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThanOrEqualTo(String value) {
            addCriterion("explain <=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLike(String value) {
            addCriterion("explain like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotLike(String value) {
            addCriterion("explain not like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainIn(List<String> values) {
            addCriterion("explain in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotIn(List<String> values) {
            addCriterion("explain not in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainBetween(String value1, String value2) {
            addCriterion("explain between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotBetween(String value1, String value2) {
            addCriterion("explain not between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartIsNull() {
            addCriterion("dividing_range_start is null");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartIsNotNull() {
            addCriterion("dividing_range_start is not null");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartEqualTo(String value) {
            addCriterion("dividing_range_start =", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartNotEqualTo(String value) {
            addCriterion("dividing_range_start <>", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartGreaterThan(String value) {
            addCriterion("dividing_range_start >", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartGreaterThanOrEqualTo(String value) {
            addCriterion("dividing_range_start >=", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartLessThan(String value) {
            addCriterion("dividing_range_start <", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartLessThanOrEqualTo(String value) {
            addCriterion("dividing_range_start <=", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartLike(String value) {
            addCriterion("dividing_range_start like", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartNotLike(String value) {
            addCriterion("dividing_range_start not like", value, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartIn(List<String> values) {
            addCriterion("dividing_range_start in", values, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartNotIn(List<String> values) {
            addCriterion("dividing_range_start not in", values, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartBetween(String value1, String value2) {
            addCriterion("dividing_range_start between", value1, value2, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeStartNotBetween(String value1, String value2) {
            addCriterion("dividing_range_start not between", value1, value2, "dividingRangeStart");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndIsNull() {
            addCriterion("dividing_range_end is null");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndIsNotNull() {
            addCriterion("dividing_range_end is not null");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndEqualTo(String value) {
            addCriterion("dividing_range_end =", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndNotEqualTo(String value) {
            addCriterion("dividing_range_end <>", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndGreaterThan(String value) {
            addCriterion("dividing_range_end >", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndGreaterThanOrEqualTo(String value) {
            addCriterion("dividing_range_end >=", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndLessThan(String value) {
            addCriterion("dividing_range_end <", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndLessThanOrEqualTo(String value) {
            addCriterion("dividing_range_end <=", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndLike(String value) {
            addCriterion("dividing_range_end like", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndNotLike(String value) {
            addCriterion("dividing_range_end not like", value, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndIn(List<String> values) {
            addCriterion("dividing_range_end in", values, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndNotIn(List<String> values) {
            addCriterion("dividing_range_end not in", values, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndBetween(String value1, String value2) {
            addCriterion("dividing_range_end between", value1, value2, "dividingRangeEnd");
            return (Criteria) this;
        }

        public Criteria andDividingRangeEndNotBetween(String value1, String value2) {
            addCriterion("dividing_range_end not between", value1, value2, "dividingRangeEnd");
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