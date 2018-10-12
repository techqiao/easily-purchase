package com.epc.bidding.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlatformBankAccountCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatformBankAccountCriteria() {
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

        public Criteria andProceedsUnitIsNull() {
            addCriterion("proceeds_unit is null");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitIsNotNull() {
            addCriterion("proceeds_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitEqualTo(String value) {
            addCriterion("proceeds_unit =", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitNotEqualTo(String value) {
            addCriterion("proceeds_unit <>", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitGreaterThan(String value) {
            addCriterion("proceeds_unit >", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("proceeds_unit >=", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitLessThan(String value) {
            addCriterion("proceeds_unit <", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitLessThanOrEqualTo(String value) {
            addCriterion("proceeds_unit <=", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitLike(String value) {
            addCriterion("proceeds_unit like", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitNotLike(String value) {
            addCriterion("proceeds_unit not like", value, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitIn(List<String> values) {
            addCriterion("proceeds_unit in", values, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitNotIn(List<String> values) {
            addCriterion("proceeds_unit not in", values, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitBetween(String value1, String value2) {
            addCriterion("proceeds_unit between", value1, value2, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andProceedsUnitNotBetween(String value1, String value2) {
            addCriterion("proceeds_unit not between", value1, value2, "proceedsUnit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNull() {
            addCriterion("bank_of_deposit is null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNotNull() {
            addCriterion("bank_of_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositEqualTo(String value) {
            addCriterion("bank_of_deposit =", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotEqualTo(String value) {
            addCriterion("bank_of_deposit <>", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThan(String value) {
            addCriterion("bank_of_deposit >", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThanOrEqualTo(String value) {
            addCriterion("bank_of_deposit >=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThan(String value) {
            addCriterion("bank_of_deposit <", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThanOrEqualTo(String value) {
            addCriterion("bank_of_deposit <=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLike(String value) {
            addCriterion("bank_of_deposit like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotLike(String value) {
            addCriterion("bank_of_deposit not like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIn(List<String> values) {
            addCriterion("bank_of_deposit in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotIn(List<String> values) {
            addCriterion("bank_of_deposit not in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositBetween(String value1, String value2) {
            addCriterion("bank_of_deposit between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotBetween(String value1, String value2) {
            addCriterion("bank_of_deposit not between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberIsNull() {
            addCriterion("shroff_account_number is null");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberIsNotNull() {
            addCriterion("shroff_account_number is not null");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberEqualTo(String value) {
            addCriterion("shroff_account_number =", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberNotEqualTo(String value) {
            addCriterion("shroff_account_number <>", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberGreaterThan(String value) {
            addCriterion("shroff_account_number >", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("shroff_account_number >=", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberLessThan(String value) {
            addCriterion("shroff_account_number <", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("shroff_account_number <=", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberLike(String value) {
            addCriterion("shroff_account_number like", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberNotLike(String value) {
            addCriterion("shroff_account_number not like", value, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberIn(List<String> values) {
            addCriterion("shroff_account_number in", values, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberNotIn(List<String> values) {
            addCriterion("shroff_account_number not in", values, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberBetween(String value1, String value2) {
            addCriterion("shroff_account_number between", value1, value2, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andShroffAccountNumberNotBetween(String value1, String value2) {
            addCriterion("shroff_account_number not between", value1, value2, "shroffAccountNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberIsNull() {
            addCriterion("wholesale_line_number is null");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberIsNotNull() {
            addCriterion("wholesale_line_number is not null");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberEqualTo(String value) {
            addCriterion("wholesale_line_number =", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberNotEqualTo(String value) {
            addCriterion("wholesale_line_number <>", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberGreaterThan(String value) {
            addCriterion("wholesale_line_number >", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberGreaterThanOrEqualTo(String value) {
            addCriterion("wholesale_line_number >=", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberLessThan(String value) {
            addCriterion("wholesale_line_number <", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberLessThanOrEqualTo(String value) {
            addCriterion("wholesale_line_number <=", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberLike(String value) {
            addCriterion("wholesale_line_number like", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberNotLike(String value) {
            addCriterion("wholesale_line_number not like", value, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberIn(List<String> values) {
            addCriterion("wholesale_line_number in", values, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberNotIn(List<String> values) {
            addCriterion("wholesale_line_number not in", values, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberBetween(String value1, String value2) {
            addCriterion("wholesale_line_number between", value1, value2, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andWholesaleLineNumberNotBetween(String value1, String value2) {
            addCriterion("wholesale_line_number not between", value1, value2, "wholesaleLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberIsNull() {
            addCriterion("location_line_number is null");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberIsNotNull() {
            addCriterion("location_line_number is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberEqualTo(String value) {
            addCriterion("location_line_number =", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberNotEqualTo(String value) {
            addCriterion("location_line_number <>", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberGreaterThan(String value) {
            addCriterion("location_line_number >", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberGreaterThanOrEqualTo(String value) {
            addCriterion("location_line_number >=", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberLessThan(String value) {
            addCriterion("location_line_number <", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberLessThanOrEqualTo(String value) {
            addCriterion("location_line_number <=", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberLike(String value) {
            addCriterion("location_line_number like", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberNotLike(String value) {
            addCriterion("location_line_number not like", value, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberIn(List<String> values) {
            addCriterion("location_line_number in", values, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberNotIn(List<String> values) {
            addCriterion("location_line_number not in", values, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberBetween(String value1, String value2) {
            addCriterion("location_line_number between", value1, value2, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andLocationLineNumberNotBetween(String value1, String value2) {
            addCriterion("location_line_number not between", value1, value2, "locationLineNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Integer value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Integer value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Integer value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Integer value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Integer> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Integer> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
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