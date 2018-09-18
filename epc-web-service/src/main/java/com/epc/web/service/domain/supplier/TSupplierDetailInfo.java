package com.epc.web.service.domain.supplier;

import java.io.Serializable;
import java.util.Date;

public class TSupplierDetailInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.id
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.supplier_id
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private Long supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.company_name
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private String companyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.uniform_credit_code
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private String uniformCreditCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.public_bank_name
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private String publicBankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.public_ban_account_number
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private String publicBanAccountNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.create_at
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private Date createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.update_at
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private Date updateAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_detail_info.is_deleted
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.id
     *
     * @return the value of t_supplier_detail_info.id
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.id
     *
     * @param id the value for t_supplier_detail_info.id
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.supplier_id
     *
     * @return the value of t_supplier_detail_info.supplier_id
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.supplier_id
     *
     * @param supplierId the value for t_supplier_detail_info.supplier_id
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.company_name
     *
     * @return the value of t_supplier_detail_info.company_name
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.company_name
     *
     * @param companyName the value for t_supplier_detail_info.company_name
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.uniform_credit_code
     *
     * @return the value of t_supplier_detail_info.uniform_credit_code
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public String getUniformCreditCode() {
        return uniformCreditCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.uniform_credit_code
     *
     * @param uniformCreditCode the value for t_supplier_detail_info.uniform_credit_code
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setUniformCreditCode(String uniformCreditCode) {
        this.uniformCreditCode = uniformCreditCode == null ? null : uniformCreditCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.public_bank_name
     *
     * @return the value of t_supplier_detail_info.public_bank_name
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public String getPublicBankName() {
        return publicBankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.public_bank_name
     *
     * @param publicBankName the value for t_supplier_detail_info.public_bank_name
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName == null ? null : publicBankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.public_ban_account_number
     *
     * @return the value of t_supplier_detail_info.public_ban_account_number
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.public_ban_account_number
     *
     * @param publicBanAccountNumber the value for t_supplier_detail_info.public_ban_account_number
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber == null ? null : publicBanAccountNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.create_at
     *
     * @return the value of t_supplier_detail_info.create_at
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.create_at
     *
     * @param createAt the value for t_supplier_detail_info.create_at
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.update_at
     *
     * @return the value of t_supplier_detail_info.update_at
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.update_at
     *
     * @param updateAt the value for t_supplier_detail_info.update_at
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_detail_info.is_deleted
     *
     * @return the value of t_supplier_detail_info.is_deleted
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_detail_info.is_deleted
     *
     * @param isDeleted the value for t_supplier_detail_info.is_deleted
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", companyName=").append(companyName);
        sb.append(", uniformCreditCode=").append(uniformCreditCode);
        sb.append(", publicBankName=").append(publicBankName);
        sb.append(", publicBanAccountNumber=").append(publicBanAccountNumber);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}