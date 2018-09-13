package com.epc.user.service.domain.supplier;

import java.io.Serializable;
import java.util.Date;

public class TSupplierAttachment implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.id
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.supplier_id
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private Long supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.certificate_type
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private String certificateType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.certificate_file_path
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private String certificateFilePath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.certificate_number
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private String certificateNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.certificate_name
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private String certificateName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.create_at
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private Date createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.update_at
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private Date updateAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_supplier_attachment.is_deleted
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.id
     *
     * @return the value of t_supplier_attachment.id
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.id
     *
     * @param id the value for t_supplier_attachment.id
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.supplier_id
     *
     * @return the value of t_supplier_attachment.supplier_id
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.supplier_id
     *
     * @param supplierId the value for t_supplier_attachment.supplier_id
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.certificate_type
     *
     * @return the value of t_supplier_attachment.certificate_type
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public String getCertificateType() {
        return certificateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.certificate_type
     *
     * @param certificateType the value for t_supplier_attachment.certificate_type
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.certificate_file_path
     *
     * @return the value of t_supplier_attachment.certificate_file_path
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.certificate_file_path
     *
     * @param certificateFilePath the value for t_supplier_attachment.certificate_file_path
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setCertificateFilePath(String certificateFilePath) {
        this.certificateFilePath = certificateFilePath == null ? null : certificateFilePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.certificate_number
     *
     * @return the value of t_supplier_attachment.certificate_number
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.certificate_number
     *
     * @param certificateNumber the value for t_supplier_attachment.certificate_number
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.certificate_name
     *
     * @return the value of t_supplier_attachment.certificate_name
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public String getCertificateName() {
        return certificateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.certificate_name
     *
     * @param certificateName the value for t_supplier_attachment.certificate_name
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName == null ? null : certificateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.create_at
     *
     * @return the value of t_supplier_attachment.create_at
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.create_at
     *
     * @param createAt the value for t_supplier_attachment.create_at
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.update_at
     *
     * @return the value of t_supplier_attachment.update_at
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.update_at
     *
     * @param updateAt the value for t_supplier_attachment.update_at
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_supplier_attachment.is_deleted
     *
     * @return the value of t_supplier_attachment.is_deleted
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_supplier_attachment.is_deleted
     *
     * @param isDeleted the value for t_supplier_attachment.is_deleted
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Wed Sep 12 19:19:24 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", certificateType=").append(certificateType);
        sb.append(", certificateFilePath=").append(certificateFilePath);
        sb.append(", certificateNumber=").append(certificateNumber);
        sb.append(", certificateName=").append(certificateName);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}