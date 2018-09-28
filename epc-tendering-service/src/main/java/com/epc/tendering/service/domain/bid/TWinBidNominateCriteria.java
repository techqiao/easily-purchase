package com.epc.tendering.service.domain.bid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TWinBidNominateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TWinBidNominateCriteria() {
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

        public Criteria andPurchaserIdIsNull() {
            addCriterion("purchaser_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdIsNotNull() {
            addCriterion("purchaser_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdEqualTo(Long value) {
            addCriterion("purchaser_id =", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdNotEqualTo(Long value) {
            addCriterion("purchaser_id <>", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdGreaterThan(Long value) {
            addCriterion("purchaser_id >", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchaser_id >=", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdLessThan(Long value) {
            addCriterion("purchaser_id <", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdLessThanOrEqualTo(Long value) {
            addCriterion("purchaser_id <=", value, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdIn(List<Long> values) {
            addCriterion("purchaser_id in", values, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdNotIn(List<Long> values) {
            addCriterion("purchaser_id not in", values, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdBetween(Long value1, Long value2) {
            addCriterion("purchaser_id between", value1, value2, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIdNotBetween(Long value1, Long value2) {
            addCriterion("purchaser_id not between", value1, value2, "purchaserId");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameIsNull() {
            addCriterion("purchaser_name is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameIsNotNull() {
            addCriterion("purchaser_name is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameEqualTo(String value) {
            addCriterion("purchaser_name =", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameNotEqualTo(String value) {
            addCriterion("purchaser_name <>", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameGreaterThan(String value) {
            addCriterion("purchaser_name >", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameGreaterThanOrEqualTo(String value) {
            addCriterion("purchaser_name >=", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameLessThan(String value) {
            addCriterion("purchaser_name <", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameLessThanOrEqualTo(String value) {
            addCriterion("purchaser_name <=", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameLike(String value) {
            addCriterion("purchaser_name like", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameNotLike(String value) {
            addCriterion("purchaser_name not like", value, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameIn(List<String> values) {
            addCriterion("purchaser_name in", values, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameNotIn(List<String> values) {
            addCriterion("purchaser_name not in", values, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameBetween(String value1, String value2) {
            addCriterion("purchaser_name between", value1, value2, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andPurchaserNameNotBetween(String value1, String value2) {
            addCriterion("purchaser_name not between", value1, value2, "purchaserName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIsNull() {
            addCriterion("agency_name is null");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIsNotNull() {
            addCriterion("agency_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyNameEqualTo(String value) {
            addCriterion("agency_name =", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotEqualTo(String value) {
            addCriterion("agency_name <>", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameGreaterThan(String value) {
            addCriterion("agency_name >", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("agency_name >=", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLessThan(String value) {
            addCriterion("agency_name <", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLessThanOrEqualTo(String value) {
            addCriterion("agency_name <=", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLike(String value) {
            addCriterion("agency_name like", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotLike(String value) {
            addCriterion("agency_name not like", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIn(List<String> values) {
            addCriterion("agency_name in", values, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotIn(List<String> values) {
            addCriterion("agency_name not in", values, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameBetween(String value1, String value2) {
            addCriterion("agency_name between", value1, value2, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotBetween(String value1, String value2) {
            addCriterion("agency_name not between", value1, value2, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIsNull() {
            addCriterion("agency_phone is null");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIsNotNull() {
            addCriterion("agency_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneEqualTo(String value) {
            addCriterion("agency_phone =", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotEqualTo(String value) {
            addCriterion("agency_phone <>", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneGreaterThan(String value) {
            addCriterion("agency_phone >", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("agency_phone >=", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLessThan(String value) {
            addCriterion("agency_phone <", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLessThanOrEqualTo(String value) {
            addCriterion("agency_phone <=", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLike(String value) {
            addCriterion("agency_phone like", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotLike(String value) {
            addCriterion("agency_phone not like", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIn(List<String> values) {
            addCriterion("agency_phone in", values, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotIn(List<String> values) {
            addCriterion("agency_phone not in", values, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneBetween(String value1, String value2) {
            addCriterion("agency_phone between", value1, value2, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotBetween(String value1, String value2) {
            addCriterion("agency_phone not between", value1, value2, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyIsNull() {
            addCriterion("is_power_Agency is null");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyIsNotNull() {
            addCriterion("is_power_Agency is not null");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyEqualTo(Integer value) {
            addCriterion("is_power_Agency =", value, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyNotEqualTo(Integer value) {
            addCriterion("is_power_Agency <>", value, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyGreaterThan(Integer value) {
            addCriterion("is_power_Agency >", value, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_power_Agency >=", value, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyLessThan(Integer value) {
            addCriterion("is_power_Agency <", value, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyLessThanOrEqualTo(Integer value) {
            addCriterion("is_power_Agency <=", value, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyIn(List<Integer> values) {
            addCriterion("is_power_Agency in", values, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyNotIn(List<Integer> values) {
            addCriterion("is_power_Agency not in", values, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyBetween(Integer value1, Integer value2) {
            addCriterion("is_power_Agency between", value1, value2, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andIsPowerAgencyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_power_Agency not between", value1, value2, "isPowerAgency");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
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

        public Criteria andBidIdIsNull() {
            addCriterion("bid_id is null");
            return (Criteria) this;
        }

        public Criteria andBidIdIsNotNull() {
            addCriterion("bid_id is not null");
            return (Criteria) this;
        }

        public Criteria andBidIdEqualTo(Long value) {
            addCriterion("bid_id =", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotEqualTo(Long value) {
            addCriterion("bid_id <>", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdGreaterThan(Long value) {
            addCriterion("bid_id >", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bid_id >=", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdLessThan(Long value) {
            addCriterion("bid_id <", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdLessThanOrEqualTo(Long value) {
            addCriterion("bid_id <=", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdIn(List<Long> values) {
            addCriterion("bid_id in", values, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotIn(List<Long> values) {
            addCriterion("bid_id not in", values, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdBetween(Long value1, Long value2) {
            addCriterion("bid_id between", value1, value2, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotBetween(Long value1, Long value2) {
            addCriterion("bid_id not between", value1, value2, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidNameIsNull() {
            addCriterion("bid_name is null");
            return (Criteria) this;
        }

        public Criteria andBidNameIsNotNull() {
            addCriterion("bid_name is not null");
            return (Criteria) this;
        }

        public Criteria andBidNameEqualTo(String value) {
            addCriterion("bid_name =", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotEqualTo(String value) {
            addCriterion("bid_name <>", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameGreaterThan(String value) {
            addCriterion("bid_name >", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameGreaterThanOrEqualTo(String value) {
            addCriterion("bid_name >=", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameLessThan(String value) {
            addCriterion("bid_name <", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameLessThanOrEqualTo(String value) {
            addCriterion("bid_name <=", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameLike(String value) {
            addCriterion("bid_name like", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotLike(String value) {
            addCriterion("bid_name not like", value, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameIn(List<String> values) {
            addCriterion("bid_name in", values, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotIn(List<String> values) {
            addCriterion("bid_name not in", values, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameBetween(String value1, String value2) {
            addCriterion("bid_name between", value1, value2, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidNameNotBetween(String value1, String value2) {
            addCriterion("bid_name not between", value1, value2, "bidName");
            return (Criteria) this;
        }

        public Criteria andBidCodeIsNull() {
            addCriterion("bid_code is null");
            return (Criteria) this;
        }

        public Criteria andBidCodeIsNotNull() {
            addCriterion("bid_code is not null");
            return (Criteria) this;
        }

        public Criteria andBidCodeEqualTo(String value) {
            addCriterion("bid_code =", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotEqualTo(String value) {
            addCriterion("bid_code <>", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeGreaterThan(String value) {
            addCriterion("bid_code >", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bid_code >=", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeLessThan(String value) {
            addCriterion("bid_code <", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeLessThanOrEqualTo(String value) {
            addCriterion("bid_code <=", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeLike(String value) {
            addCriterion("bid_code like", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotLike(String value) {
            addCriterion("bid_code not like", value, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeIn(List<String> values) {
            addCriterion("bid_code in", values, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotIn(List<String> values) {
            addCriterion("bid_code not in", values, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeBetween(String value1, String value2) {
            addCriterion("bid_code between", value1, value2, "bidCode");
            return (Criteria) this;
        }

        public Criteria andBidCodeNotBetween(String value1, String value2) {
            addCriterion("bid_code not between", value1, value2, "bidCode");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridIsNull() {
            addCriterion("first_supplierId is null");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridIsNotNull() {
            addCriterion("first_supplierId is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridEqualTo(Long value) {
            addCriterion("first_supplierId =", value, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridNotEqualTo(Long value) {
            addCriterion("first_supplierId <>", value, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridGreaterThan(Long value) {
            addCriterion("first_supplierId >", value, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridGreaterThanOrEqualTo(Long value) {
            addCriterion("first_supplierId >=", value, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridLessThan(Long value) {
            addCriterion("first_supplierId <", value, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridLessThanOrEqualTo(Long value) {
            addCriterion("first_supplierId <=", value, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridIn(List<Long> values) {
            addCriterion("first_supplierId in", values, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridNotIn(List<Long> values) {
            addCriterion("first_supplierId not in", values, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridBetween(Long value1, Long value2) {
            addCriterion("first_supplierId between", value1, value2, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstSupplieridNotBetween(Long value1, Long value2) {
            addCriterion("first_supplierId not between", value1, value2, "firstSupplierid");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameIsNull() {
            addCriterion("first_companyName is null");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameIsNotNull() {
            addCriterion("first_companyName is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameEqualTo(String value) {
            addCriterion("first_companyName =", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameNotEqualTo(String value) {
            addCriterion("first_companyName <>", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameGreaterThan(String value) {
            addCriterion("first_companyName >", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("first_companyName >=", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameLessThan(String value) {
            addCriterion("first_companyName <", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameLessThanOrEqualTo(String value) {
            addCriterion("first_companyName <=", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameLike(String value) {
            addCriterion("first_companyName like", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameNotLike(String value) {
            addCriterion("first_companyName not like", value, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameIn(List<String> values) {
            addCriterion("first_companyName in", values, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameNotIn(List<String> values) {
            addCriterion("first_companyName not in", values, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameBetween(String value1, String value2) {
            addCriterion("first_companyName between", value1, value2, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstCompanynameNotBetween(String value1, String value2) {
            addCriterion("first_companyName not between", value1, value2, "firstCompanyname");
            return (Criteria) this;
        }

        public Criteria andFirstPriceIsNull() {
            addCriterion("first_price is null");
            return (Criteria) this;
        }

        public Criteria andFirstPriceIsNotNull() {
            addCriterion("first_price is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPriceEqualTo(BigDecimal value) {
            addCriterion("first_price =", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceNotEqualTo(BigDecimal value) {
            addCriterion("first_price <>", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceGreaterThan(BigDecimal value) {
            addCriterion("first_price >", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_price >=", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceLessThan(BigDecimal value) {
            addCriterion("first_price <", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_price <=", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceIn(List<BigDecimal> values) {
            addCriterion("first_price in", values, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceNotIn(List<BigDecimal> values) {
            addCriterion("first_price not in", values, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_price between", value1, value2, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_price not between", value1, value2, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridIsNull() {
            addCriterion("two_supplierId is null");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridIsNotNull() {
            addCriterion("two_supplierId is not null");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridEqualTo(Long value) {
            addCriterion("two_supplierId =", value, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridNotEqualTo(Long value) {
            addCriterion("two_supplierId <>", value, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridGreaterThan(Long value) {
            addCriterion("two_supplierId >", value, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridGreaterThanOrEqualTo(Long value) {
            addCriterion("two_supplierId >=", value, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridLessThan(Long value) {
            addCriterion("two_supplierId <", value, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridLessThanOrEqualTo(Long value) {
            addCriterion("two_supplierId <=", value, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridIn(List<Long> values) {
            addCriterion("two_supplierId in", values, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridNotIn(List<Long> values) {
            addCriterion("two_supplierId not in", values, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridBetween(Long value1, Long value2) {
            addCriterion("two_supplierId between", value1, value2, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoSupplieridNotBetween(Long value1, Long value2) {
            addCriterion("two_supplierId not between", value1, value2, "twoSupplierid");
            return (Criteria) this;
        }

        public Criteria andTwoPriceIsNull() {
            addCriterion("two_price is null");
            return (Criteria) this;
        }

        public Criteria andTwoPriceIsNotNull() {
            addCriterion("two_price is not null");
            return (Criteria) this;
        }

        public Criteria andTwoPriceEqualTo(BigDecimal value) {
            addCriterion("two_price =", value, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceNotEqualTo(BigDecimal value) {
            addCriterion("two_price <>", value, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceGreaterThan(BigDecimal value) {
            addCriterion("two_price >", value, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("two_price >=", value, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceLessThan(BigDecimal value) {
            addCriterion("two_price <", value, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("two_price <=", value, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceIn(List<BigDecimal> values) {
            addCriterion("two_price in", values, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceNotIn(List<BigDecimal> values) {
            addCriterion("two_price not in", values, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("two_price between", value1, value2, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("two_price not between", value1, value2, "twoPrice");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameIsNull() {
            addCriterion("two_companyName is null");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameIsNotNull() {
            addCriterion("two_companyName is not null");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameEqualTo(String value) {
            addCriterion("two_companyName =", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameNotEqualTo(String value) {
            addCriterion("two_companyName <>", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameGreaterThan(String value) {
            addCriterion("two_companyName >", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("two_companyName >=", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameLessThan(String value) {
            addCriterion("two_companyName <", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameLessThanOrEqualTo(String value) {
            addCriterion("two_companyName <=", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameLike(String value) {
            addCriterion("two_companyName like", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameNotLike(String value) {
            addCriterion("two_companyName not like", value, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameIn(List<String> values) {
            addCriterion("two_companyName in", values, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameNotIn(List<String> values) {
            addCriterion("two_companyName not in", values, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameBetween(String value1, String value2) {
            addCriterion("two_companyName between", value1, value2, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andTwoCompanynameNotBetween(String value1, String value2) {
            addCriterion("two_companyName not between", value1, value2, "twoCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridIsNull() {
            addCriterion("three_supplierId is null");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridIsNotNull() {
            addCriterion("three_supplierId is not null");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridEqualTo(Long value) {
            addCriterion("three_supplierId =", value, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridNotEqualTo(Long value) {
            addCriterion("three_supplierId <>", value, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridGreaterThan(Long value) {
            addCriterion("three_supplierId >", value, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridGreaterThanOrEqualTo(Long value) {
            addCriterion("three_supplierId >=", value, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridLessThan(Long value) {
            addCriterion("three_supplierId <", value, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridLessThanOrEqualTo(Long value) {
            addCriterion("three_supplierId <=", value, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridIn(List<Long> values) {
            addCriterion("three_supplierId in", values, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridNotIn(List<Long> values) {
            addCriterion("three_supplierId not in", values, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridBetween(Long value1, Long value2) {
            addCriterion("three_supplierId between", value1, value2, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreeSupplieridNotBetween(Long value1, Long value2) {
            addCriterion("three_supplierId not between", value1, value2, "threeSupplierid");
            return (Criteria) this;
        }

        public Criteria andThreePriceIsNull() {
            addCriterion("three_price is null");
            return (Criteria) this;
        }

        public Criteria andThreePriceIsNotNull() {
            addCriterion("three_price is not null");
            return (Criteria) this;
        }

        public Criteria andThreePriceEqualTo(BigDecimal value) {
            addCriterion("three_price =", value, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceNotEqualTo(BigDecimal value) {
            addCriterion("three_price <>", value, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceGreaterThan(BigDecimal value) {
            addCriterion("three_price >", value, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("three_price >=", value, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceLessThan(BigDecimal value) {
            addCriterion("three_price <", value, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("three_price <=", value, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceIn(List<BigDecimal> values) {
            addCriterion("three_price in", values, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceNotIn(List<BigDecimal> values) {
            addCriterion("three_price not in", values, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("three_price between", value1, value2, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("three_price not between", value1, value2, "threePrice");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameIsNull() {
            addCriterion("three_companyName is null");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameIsNotNull() {
            addCriterion("three_companyName is not null");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameEqualTo(String value) {
            addCriterion("three_companyName =", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameNotEqualTo(String value) {
            addCriterion("three_companyName <>", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameGreaterThan(String value) {
            addCriterion("three_companyName >", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("three_companyName >=", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameLessThan(String value) {
            addCriterion("three_companyName <", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameLessThanOrEqualTo(String value) {
            addCriterion("three_companyName <=", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameLike(String value) {
            addCriterion("three_companyName like", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameNotLike(String value) {
            addCriterion("three_companyName not like", value, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameIn(List<String> values) {
            addCriterion("three_companyName in", values, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameNotIn(List<String> values) {
            addCriterion("three_companyName not in", values, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameBetween(String value1, String value2) {
            addCriterion("three_companyName between", value1, value2, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andThreeCompanynameNotBetween(String value1, String value2) {
            addCriterion("three_companyName not between", value1, value2, "threeCompanyname");
            return (Criteria) this;
        }

        public Criteria andOpenStartIsNull() {
            addCriterion("open_start is null");
            return (Criteria) this;
        }

        public Criteria andOpenStartIsNotNull() {
            addCriterion("open_start is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStartEqualTo(Date value) {
            addCriterion("open_start =", value, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartNotEqualTo(Date value) {
            addCriterion("open_start <>", value, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartGreaterThan(Date value) {
            addCriterion("open_start >", value, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartGreaterThanOrEqualTo(Date value) {
            addCriterion("open_start >=", value, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartLessThan(Date value) {
            addCriterion("open_start <", value, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartLessThanOrEqualTo(Date value) {
            addCriterion("open_start <=", value, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartIn(List<Date> values) {
            addCriterion("open_start in", values, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartNotIn(List<Date> values) {
            addCriterion("open_start not in", values, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartBetween(Date value1, Date value2) {
            addCriterion("open_start between", value1, value2, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenStartNotBetween(Date value1, Date value2) {
            addCriterion("open_start not between", value1, value2, "openStart");
            return (Criteria) this;
        }

        public Criteria andOpenEndIsNull() {
            addCriterion("open_end is null");
            return (Criteria) this;
        }

        public Criteria andOpenEndIsNotNull() {
            addCriterion("open_end is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEndEqualTo(Date value) {
            addCriterion("open_end =", value, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndNotEqualTo(Date value) {
            addCriterion("open_end <>", value, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndGreaterThan(Date value) {
            addCriterion("open_end >", value, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndGreaterThanOrEqualTo(Date value) {
            addCriterion("open_end >=", value, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndLessThan(Date value) {
            addCriterion("open_end <", value, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndLessThanOrEqualTo(Date value) {
            addCriterion("open_end <=", value, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndIn(List<Date> values) {
            addCriterion("open_end in", values, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndNotIn(List<Date> values) {
            addCriterion("open_end not in", values, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndBetween(Date value1, Date value2) {
            addCriterion("open_end between", value1, value2, "openEnd");
            return (Criteria) this;
        }

        public Criteria andOpenEndNotBetween(Date value1, Date value2) {
            addCriterion("open_end not between", value1, value2, "openEnd");
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