package com.epc.platform.service.domain.expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TExpertBasicInfoCriteria {
    /**
     * t_expert_basic_info
     */
    protected String orderByClause;

    /**
     * t_expert_basic_info
     */
    protected boolean distinct;

    /**
     * t_expert_basic_info
     */
    protected List<Criteria> oredCriteria;

    public TExpertBasicInfoCriteria() {
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
     * t_expert_basic_info 2018-09-30
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andPositionalIsNull() {
            addCriterion("positional is null");
            return (Criteria) this;
        }

        public Criteria andPositionalIsNotNull() {
            addCriterion("positional is not null");
            return (Criteria) this;
        }

        public Criteria andPositionalEqualTo(String value) {
            addCriterion("positional =", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalNotEqualTo(String value) {
            addCriterion("positional <>", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalGreaterThan(String value) {
            addCriterion("positional >", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalGreaterThanOrEqualTo(String value) {
            addCriterion("positional >=", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalLessThan(String value) {
            addCriterion("positional <", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalLessThanOrEqualTo(String value) {
            addCriterion("positional <=", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalLike(String value) {
            addCriterion("positional like", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalNotLike(String value) {
            addCriterion("positional not like", value, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalIn(List<String> values) {
            addCriterion("positional in", values, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalNotIn(List<String> values) {
            addCriterion("positional not in", values, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalBetween(String value1, String value2) {
            addCriterion("positional between", value1, value2, "positional");
            return (Criteria) this;
        }

        public Criteria andPositionalNotBetween(String value1, String value2) {
            addCriterion("positional not between", value1, value2, "positional");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andIsIdleIsNull() {
            addCriterion("is_idle is null");
            return (Criteria) this;
        }

        public Criteria andIsIdleIsNotNull() {
            addCriterion("is_idle is not null");
            return (Criteria) this;
        }

        public Criteria andIsIdleEqualTo(Integer value) {
            addCriterion("is_idle =", value, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleNotEqualTo(Integer value) {
            addCriterion("is_idle <>", value, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleGreaterThan(Integer value) {
            addCriterion("is_idle >", value, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_idle >=", value, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleLessThan(Integer value) {
            addCriterion("is_idle <", value, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleLessThanOrEqualTo(Integer value) {
            addCriterion("is_idle <=", value, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleIn(List<Integer> values) {
            addCriterion("is_idle in", values, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleNotIn(List<Integer> values) {
            addCriterion("is_idle not in", values, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleBetween(Integer value1, Integer value2) {
            addCriterion("is_idle between", value1, value2, "isIdle");
            return (Criteria) this;
        }

        public Criteria andIsIdleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_idle not between", value1, value2, "isIdle");
            return (Criteria) this;
        }

        public Criteria andCircularDtIsNull() {
            addCriterion("circular_dt is null");
            return (Criteria) this;
        }

        public Criteria andCircularDtIsNotNull() {
            addCriterion("circular_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCircularDtEqualTo(Date value) {
            addCriterion("circular_dt =", value, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtNotEqualTo(Date value) {
            addCriterion("circular_dt <>", value, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtGreaterThan(Date value) {
            addCriterion("circular_dt >", value, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtGreaterThanOrEqualTo(Date value) {
            addCriterion("circular_dt >=", value, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtLessThan(Date value) {
            addCriterion("circular_dt <", value, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtLessThanOrEqualTo(Date value) {
            addCriterion("circular_dt <=", value, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtIn(List<Date> values) {
            addCriterion("circular_dt in", values, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtNotIn(List<Date> values) {
            addCriterion("circular_dt not in", values, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtBetween(Date value1, Date value2) {
            addCriterion("circular_dt between", value1, value2, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularDtNotBetween(Date value1, Date value2) {
            addCriterion("circular_dt not between", value1, value2, "circularDt");
            return (Criteria) this;
        }

        public Criteria andCircularMethodIsNull() {
            addCriterion("circular_method is null");
            return (Criteria) this;
        }

        public Criteria andCircularMethodIsNotNull() {
            addCriterion("circular_method is not null");
            return (Criteria) this;
        }

        public Criteria andCircularMethodEqualTo(String value) {
            addCriterion("circular_method =", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodNotEqualTo(String value) {
            addCriterion("circular_method <>", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodGreaterThan(String value) {
            addCriterion("circular_method >", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodGreaterThanOrEqualTo(String value) {
            addCriterion("circular_method >=", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodLessThan(String value) {
            addCriterion("circular_method <", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodLessThanOrEqualTo(String value) {
            addCriterion("circular_method <=", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodLike(String value) {
            addCriterion("circular_method like", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodNotLike(String value) {
            addCriterion("circular_method not like", value, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodIn(List<String> values) {
            addCriterion("circular_method in", values, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodNotIn(List<String> values) {
            addCriterion("circular_method not in", values, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodBetween(String value1, String value2) {
            addCriterion("circular_method between", value1, value2, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andCircularMethodNotBetween(String value1, String value2) {
            addCriterion("circular_method not between", value1, value2, "circularMethod");
            return (Criteria) this;
        }

        public Criteria andOtherInformationIsNull() {
            addCriterion("other_information is null");
            return (Criteria) this;
        }

        public Criteria andOtherInformationIsNotNull() {
            addCriterion("other_information is not null");
            return (Criteria) this;
        }

        public Criteria andOtherInformationEqualTo(String value) {
            addCriterion("other_information =", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationNotEqualTo(String value) {
            addCriterion("other_information <>", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationGreaterThan(String value) {
            addCriterion("other_information >", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationGreaterThanOrEqualTo(String value) {
            addCriterion("other_information >=", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationLessThan(String value) {
            addCriterion("other_information <", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationLessThanOrEqualTo(String value) {
            addCriterion("other_information <=", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationLike(String value) {
            addCriterion("other_information like", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationNotLike(String value) {
            addCriterion("other_information not like", value, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationIn(List<String> values) {
            addCriterion("other_information in", values, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationNotIn(List<String> values) {
            addCriterion("other_information not in", values, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationBetween(String value1, String value2) {
            addCriterion("other_information between", value1, value2, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andOtherInformationNotBetween(String value1, String value2) {
            addCriterion("other_information not between", value1, value2, "otherInformation");
            return (Criteria) this;
        }

        public Criteria andInviterTypeIsNull() {
            addCriterion("inviter_type is null");
            return (Criteria) this;
        }

        public Criteria andInviterTypeIsNotNull() {
            addCriterion("inviter_type is not null");
            return (Criteria) this;
        }

        public Criteria andInviterTypeEqualTo(Integer value) {
            addCriterion("inviter_type =", value, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeNotEqualTo(Integer value) {
            addCriterion("inviter_type <>", value, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeGreaterThan(Integer value) {
            addCriterion("inviter_type >", value, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("inviter_type >=", value, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeLessThan(Integer value) {
            addCriterion("inviter_type <", value, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeLessThanOrEqualTo(Integer value) {
            addCriterion("inviter_type <=", value, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeIn(List<Integer> values) {
            addCriterion("inviter_type in", values, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeNotIn(List<Integer> values) {
            addCriterion("inviter_type not in", values, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeBetween(Integer value1, Integer value2) {
            addCriterion("inviter_type between", value1, value2, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("inviter_type not between", value1, value2, "inviterType");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNull() {
            addCriterion("inviter_id is null");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNotNull() {
            addCriterion("inviter_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviterIdEqualTo(Long value) {
            addCriterion("inviter_id =", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotEqualTo(Long value) {
            addCriterion("inviter_id <>", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThan(Long value) {
            addCriterion("inviter_id >", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inviter_id >=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThan(Long value) {
            addCriterion("inviter_id <", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThanOrEqualTo(Long value) {
            addCriterion("inviter_id <=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdIn(List<Long> values) {
            addCriterion("inviter_id in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotIn(List<Long> values) {
            addCriterion("inviter_id not in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdBetween(Long value1, Long value2) {
            addCriterion("inviter_id between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotBetween(Long value1, Long value2) {
            addCriterion("inviter_id not between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdIsNull() {
            addCriterion("inviter_company_id is null");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdIsNotNull() {
            addCriterion("inviter_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdEqualTo(Long value) {
            addCriterion("inviter_company_id =", value, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdNotEqualTo(Long value) {
            addCriterion("inviter_company_id <>", value, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdGreaterThan(Long value) {
            addCriterion("inviter_company_id >", value, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inviter_company_id >=", value, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdLessThan(Long value) {
            addCriterion("inviter_company_id <", value, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("inviter_company_id <=", value, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdIn(List<Long> values) {
            addCriterion("inviter_company_id in", values, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdNotIn(List<Long> values) {
            addCriterion("inviter_company_id not in", values, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdBetween(Long value1, Long value2) {
            addCriterion("inviter_company_id between", value1, value2, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andInviterCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("inviter_company_id not between", value1, value2, "inviterCompanyId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andIsForbiddenIsNull() {
            addCriterion("is_forbidden is null");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenIsNotNull() {
            addCriterion("is_forbidden is not null");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenEqualTo(Integer value) {
            addCriterion("is_forbidden =", value, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenNotEqualTo(Integer value) {
            addCriterion("is_forbidden <>", value, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenGreaterThan(Integer value) {
            addCriterion("is_forbidden >", value, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_forbidden >=", value, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenLessThan(Integer value) {
            addCriterion("is_forbidden <", value, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenLessThanOrEqualTo(Integer value) {
            addCriterion("is_forbidden <=", value, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenIn(List<Integer> values) {
            addCriterion("is_forbidden in", values, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenNotIn(List<Integer> values) {
            addCriterion("is_forbidden not in", values, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenBetween(Integer value1, Integer value2) {
            addCriterion("is_forbidden between", value1, value2, "isForbidden");
            return (Criteria) this;
        }

        public Criteria andIsForbiddenNotBetween(Integer value1, Integer value2) {
            addCriterion("is_forbidden not between", value1, value2, "isForbidden");
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
     * 描述:t_expert_basic_info表的实体类
     * @version
     * @author:  01
     * @创建时间: 2018-09-30
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_expert_basic_info 2018-09-30
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