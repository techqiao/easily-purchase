package com.epc.web.service.domain.agency;

import java.io.Serializable;
import java.util.Date;

public class TAgencyBasicInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.id
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.name
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.agency_id
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Long agencyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.cellphone
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private String cellphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.password
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.state
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.role
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Integer role;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.create_at
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Date createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.update_at
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Date updateAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_agency_basic_info.is_deleted
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.id
     *
     * @return the value of t_agency_basic_info.id
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.id
     *
     * @param id the value for t_agency_basic_info.id
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.name
     *
     * @return the value of t_agency_basic_info.name
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.name
     *
     * @param name the value for t_agency_basic_info.name
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.agency_id
     *
     * @return the value of t_agency_basic_info.agency_id
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Long getAgencyId() {
        return agencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.agency_id
     *
     * @param agencyId the value for t_agency_basic_info.agency_id
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.cellphone
     *
     * @return the value of t_agency_basic_info.cellphone
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.cellphone
     *
     * @param cellphone the value for t_agency_basic_info.cellphone
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.password
     *
     * @return the value of t_agency_basic_info.password
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.password
     *
     * @param password the value for t_agency_basic_info.password
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.state
     *
     * @return the value of t_agency_basic_info.state
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.state
     *
     * @param state the value for t_agency_basic_info.state
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.role
     *
     * @return the value of t_agency_basic_info.role
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.role
     *
     * @param role the value for t_agency_basic_info.role
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.create_at
     *
     * @return the value of t_agency_basic_info.create_at
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.create_at
     *
     * @param createAt the value for t_agency_basic_info.create_at
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.update_at
     *
     * @return the value of t_agency_basic_info.update_at
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.update_at
     *
     * @param updateAt the value for t_agency_basic_info.update_at
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_agency_basic_info.is_deleted
     *
     * @return the value of t_agency_basic_info.is_deleted
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_agency_basic_info.is_deleted
     *
     * @param isDeleted the value for t_agency_basic_info.is_deleted
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Thu Sep 13 16:23:51 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", cellphone=").append(cellphone);
        sb.append(", password=").append(password);
        sb.append(", state=").append(state);
        sb.append(", role=").append(role);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}