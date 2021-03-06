package com.epc.tendering.service.domain.signup;

import java.io.Serializable;
import java.util.Date;

public class BSignUp implements Serializable {
    private Long id;

    private Long projectId;

    private Long procurementProjectId;

    private String bidsId;

    private String bidsName;

    private String bidsCode;

    private Long supplierId;

    private String supplierName;

    private Long userId;

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    public String getBidsId() {
        return bidsId;
    }

    public void setBidsId(String bidsId) {
        this.bidsId = bidsId == null ? null : bidsId.trim();
    }

    public String getBidsName() {
        return bidsName;
    }

    public void setBidsName(String bidsName) {
        this.bidsName = bidsName == null ? null : bidsName.trim();
    }

    public String getBidsCode() {
        return bidsCode;
    }

    public void setBidsCode(String bidsCode) {
        this.bidsCode = bidsCode == null ? null : bidsCode.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        sb.append(", projectId=").append(projectId);
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", bidsId=").append(bidsId);
        sb.append(", bidsName=").append(bidsName);
        sb.append(", bidsCode=").append(bidsCode);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", userId=").append(userId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}