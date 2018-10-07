package com.epc.bidding.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class tTWinBid implements Serializable {
    private Long id;

    private Long projectId;

    private Long procurementProjectId;

    private String procurementProjectName;

    private Long bidId;

    private String bidName;

    private Long purchaserId;

    private BigDecimal purchaserMonety;

    private String sort;

    private Long supplierId;

    private String supplierName;

    private Long operateId;

    private Date createAt;

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

    public String getProcurementProjectName() {
        return procurementProjectName;
    }

    public void setProcurementProjectName(String procurementProjectName) {
        this.procurementProjectName = procurementProjectName == null ? null : procurementProjectName.trim();
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public String getBidName() {
        return bidName;
    }

    public void setBidName(String bidName) {
        this.bidName = bidName == null ? null : bidName.trim();
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public BigDecimal getPurchaserMonety() {
        return purchaserMonety;
    }

    public void setPurchaserMonety(BigDecimal purchaserMonety) {
        this.purchaserMonety = purchaserMonety;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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
        sb.append(", procurementProjectName=").append(procurementProjectName);
        sb.append(", bidId=").append(bidId);
        sb.append(", bidName=").append(bidName);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", purchaserMonety=").append(purchaserMonety);
        sb.append(", sort=").append(sort);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}