package com.epc.platform.service.domain.expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TExpertDetailInfoCriteria {
    /**
     * t_expert_detail_info
     */
    protected String orderByClause;

    /**
     * t_expert_detail_info
     */
    protected boolean distinct;

    /**
     * t_expert_detail_info
     */
    protected List<Criteria> oredCriteria;

    public TExpertDetailInfoCriteria() {
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
     * t_expert_detail_info 2018-10-03
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeIsNull() {
            addCriterion("uniform_credit_code is null");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeIsNotNull() {
            addCriterion("uniform_credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeEqualTo(String value) {
            addCriterion("uniform_credit_code =", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeNotEqualTo(String value) {
            addCriterion("uniform_credit_code <>", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeGreaterThan(String value) {
            addCriterion("uniform_credit_code >", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("uniform_credit_code >=", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeLessThan(String value) {
            addCriterion("uniform_credit_code <", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("uniform_credit_code <=", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeLike(String value) {
            addCriterion("uniform_credit_code like", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeNotLike(String value) {
            addCriterion("uniform_credit_code not like", value, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeIn(List<String> values) {
            addCriterion("uniform_credit_code in", values, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeNotIn(List<String> values) {
            addCriterion("uniform_credit_code not in", values, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeBetween(String value1, String value2) {
            addCriterion("uniform_credit_code between", value1, value2, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformCreditCodeNotBetween(String value1, String value2) {
            addCriterion("uniform_credit_code not between", value1, value2, "uniformCreditCode");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameIsNull() {
            addCriterion("public_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameIsNotNull() {
            addCriterion("public_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameEqualTo(String value) {
            addCriterion("public_bank_name =", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameNotEqualTo(String value) {
            addCriterion("public_bank_name <>", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameGreaterThan(String value) {
            addCriterion("public_bank_name >", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("public_bank_name >=", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameLessThan(String value) {
            addCriterion("public_bank_name <", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameLessThanOrEqualTo(String value) {
            addCriterion("public_bank_name <=", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameLike(String value) {
            addCriterion("public_bank_name like", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameNotLike(String value) {
            addCriterion("public_bank_name not like", value, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameIn(List<String> values) {
            addCriterion("public_bank_name in", values, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameNotIn(List<String> values) {
            addCriterion("public_bank_name not in", values, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameBetween(String value1, String value2) {
            addCriterion("public_bank_name between", value1, value2, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBankNameNotBetween(String value1, String value2) {
            addCriterion("public_bank_name not between", value1, value2, "publicBankName");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberIsNull() {
            addCriterion("public_ban_account_number is null");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberIsNotNull() {
            addCriterion("public_ban_account_number is not null");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberEqualTo(String value) {
            addCriterion("public_ban_account_number =", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberNotEqualTo(String value) {
            addCriterion("public_ban_account_number <>", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberGreaterThan(String value) {
            addCriterion("public_ban_account_number >", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("public_ban_account_number >=", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberLessThan(String value) {
            addCriterion("public_ban_account_number <", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("public_ban_account_number <=", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberLike(String value) {
            addCriterion("public_ban_account_number like", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberNotLike(String value) {
            addCriterion("public_ban_account_number not like", value, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberIn(List<String> values) {
            addCriterion("public_ban_account_number in", values, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberNotIn(List<String> values) {
            addCriterion("public_ban_account_number not in", values, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberBetween(String value1, String value2) {
            addCriterion("public_ban_account_number between", value1, value2, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andPublicBanAccountNumberNotBetween(String value1, String value2) {
            addCriterion("public_ban_account_number not between", value1, value2, "publicBanAccountNumber");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldIsNull() {
            addCriterion("extended_field is null");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldIsNotNull() {
            addCriterion("extended_field is not null");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldEqualTo(String value) {
            addCriterion("extended_field =", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldNotEqualTo(String value) {
            addCriterion("extended_field <>", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldGreaterThan(String value) {
            addCriterion("extended_field >", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldGreaterThanOrEqualTo(String value) {
            addCriterion("extended_field >=", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldLessThan(String value) {
            addCriterion("extended_field <", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldLessThanOrEqualTo(String value) {
            addCriterion("extended_field <=", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldLike(String value) {
            addCriterion("extended_field like", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldNotLike(String value) {
            addCriterion("extended_field not like", value, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldIn(List<String> values) {
            addCriterion("extended_field in", values, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldNotIn(List<String> values) {
            addCriterion("extended_field not in", values, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldBetween(String value1, String value2) {
            addCriterion("extended_field between", value1, value2, "extendedField");
            return (Criteria) this;
        }

        public Criteria andExtendedFieldNotBetween(String value1, String value2) {
            addCriterion("extended_field not between", value1, value2, "extendedField");
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

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }
    }

    /**
     * 描述:t_expert_detail_info表的实体类
     * @version
     * @author:  01
     * @创建时间: 2018-10-03
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_expert_detail_info 2018-10-03
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