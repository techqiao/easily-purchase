package com.epc.platform.service.domain.expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TExpertAttachmentCriteria {
    /**
     * t_expert_attachment
     */
    protected String orderByClause;

    /**
     * t_expert_attachment
     */
    protected boolean distinct;

    /**
     * t_expert_attachment
     */
    protected List<Criteria> oredCriteria;

    public TExpertAttachmentCriteria() {
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

    /**
     * t_expert_attachment 2018-09-28
     */
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

        public Criteria andExpertIdIsNull() {
            addCriterion("expert_id is null");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNotNull() {
            addCriterion("expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpertIdEqualTo(Long value) {
            addCriterion("expert_id =", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotEqualTo(Long value) {
            addCriterion("expert_id <>", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThan(Long value) {
            addCriterion("expert_id >", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThanOrEqualTo(Long value) {
            addCriterion("expert_id >=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThan(Long value) {
            addCriterion("expert_id <", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThanOrEqualTo(Long value) {
            addCriterion("expert_id <=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIn(List<Long> values) {
            addCriterion("expert_id in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotIn(List<Long> values) {
            addCriterion("expert_id not in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdBetween(Long value1, Long value2) {
            addCriterion("expert_id between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotBetween(Long value1, Long value2) {
            addCriterion("expert_id not between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNull() {
            addCriterion("certificate_type is null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("certificate_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeEqualTo(String value) {
            addCriterion("certificate_type =", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotEqualTo(String value) {
            addCriterion("certificate_type <>", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThan(String value) {
            addCriterion("certificate_type >", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_type >=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThan(String value) {
            addCriterion("certificate_type <", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThanOrEqualTo(String value) {
            addCriterion("certificate_type <=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLike(String value) {
            addCriterion("certificate_type like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotLike(String value) {
            addCriterion("certificate_type not like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIn(List<String> values) {
            addCriterion("certificate_type in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotIn(List<String> values) {
            addCriterion("certificate_type not in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeBetween(String value1, String value2) {
            addCriterion("certificate_type between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotBetween(String value1, String value2) {
            addCriterion("certificate_type not between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathIsNull() {
            addCriterion("certificate_file_path is null");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathIsNotNull() {
            addCriterion("certificate_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathEqualTo(String value) {
            addCriterion("certificate_file_path =", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotEqualTo(String value) {
            addCriterion("certificate_file_path <>", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathGreaterThan(String value) {
            addCriterion("certificate_file_path >", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_file_path >=", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathLessThan(String value) {
            addCriterion("certificate_file_path <", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathLessThanOrEqualTo(String value) {
            addCriterion("certificate_file_path <=", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathLike(String value) {
            addCriterion("certificate_file_path like", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotLike(String value) {
            addCriterion("certificate_file_path not like", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathIn(List<String> values) {
            addCriterion("certificate_file_path in", values, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotIn(List<String> values) {
            addCriterion("certificate_file_path not in", values, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathBetween(String value1, String value2) {
            addCriterion("certificate_file_path between", value1, value2, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotBetween(String value1, String value2) {
            addCriterion("certificate_file_path not between", value1, value2, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNull() {
            addCriterion("certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNotNull() {
            addCriterion("certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberEqualTo(String value) {
            addCriterion("certificate_number =", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotEqualTo(String value) {
            addCriterion("certificate_number <>", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThan(String value) {
            addCriterion("certificate_number >", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_number >=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThan(String value) {
            addCriterion("certificate_number <", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("certificate_number <=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLike(String value) {
            addCriterion("certificate_number like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotLike(String value) {
            addCriterion("certificate_number not like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIn(List<String> values) {
            addCriterion("certificate_number in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotIn(List<String> values) {
            addCriterion("certificate_number not in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberBetween(String value1, String value2) {
            addCriterion("certificate_number between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("certificate_number not between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNameIsNull() {
            addCriterion("certificate_name is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNameIsNotNull() {
            addCriterion("certificate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNameEqualTo(String value) {
            addCriterion("certificate_name =", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameNotEqualTo(String value) {
            addCriterion("certificate_name <>", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameGreaterThan(String value) {
            addCriterion("certificate_name >", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_name >=", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameLessThan(String value) {
            addCriterion("certificate_name <", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameLessThanOrEqualTo(String value) {
            addCriterion("certificate_name <=", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameLike(String value) {
            addCriterion("certificate_name like", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameNotLike(String value) {
            addCriterion("certificate_name not like", value, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameIn(List<String> values) {
            addCriterion("certificate_name in", values, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameNotIn(List<String> values) {
            addCriterion("certificate_name not in", values, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameBetween(String value1, String value2) {
            addCriterion("certificate_name between", value1, value2, "certificateName");
            return (Criteria) this;
        }

        public Criteria andCertificateNameNotBetween(String value1, String value2) {
            addCriterion("certificate_name not between", value1, value2, "certificateName");
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

    /**
     * 描述:t_expert_attachment表的实体类
     * @version
     * @author:  01
     * @创建时间: 2018-09-28
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_expert_attachment 2018-09-28
     */
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