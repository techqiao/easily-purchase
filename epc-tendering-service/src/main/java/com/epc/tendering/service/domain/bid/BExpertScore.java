package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.util.Date;

public class BExpertScore implements Serializable {
    private Long id;

    private Long bidsId;

    private Long bidsCode;

    private Long procurementProjectId;

    private Long supplierId;

    private String supplierCompanyName;

    private String status;

    private String standardType;

    private Integer techTypeScore;

    private Integer commerceTypeScore;

    private Integer finalScore;

    private Long expertId;

    private String expertName;

    private Long operateId;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBidsId() {
        return bidsId;
    }

    public void setBidsId(Long bidsId) {
        this.bidsId = bidsId;
    }

    public Long getBidsCode() {
        return bidsCode;
    }

    public void setBidsCode(Long bidsCode) {
        this.bidsCode = bidsCode;
    }

    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName == null ? null : supplierCompanyName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType == null ? null : standardType.trim();
    }

    public Integer getTechTypeScore() {
        return techTypeScore;
    }

    public void setTechTypeScore(Integer techTypeScore) {
        this.techTypeScore = techTypeScore;
    }

    public Integer getCommerceTypeScore() {
        return commerceTypeScore;
    }

    public void setCommerceTypeScore(Integer commerceTypeScore) {
        this.commerceTypeScore = commerceTypeScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName == null ? null : expertName.trim();
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bidsId=").append(bidsId);
        sb.append(", bidsCode=").append(bidsCode);
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierCompanyName=").append(supplierCompanyName);
        sb.append(", status=").append(status);
        sb.append(", standardType=").append(standardType);
        sb.append(", techTypeScore=").append(techTypeScore);
        sb.append(", commerceTypeScore=").append(commerceTypeScore);
        sb.append(", finalScore=").append(finalScore);
        sb.append(", expertId=").append(expertId);
        sb.append(", expertName=").append(expertName);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}