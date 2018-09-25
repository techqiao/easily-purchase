package com.epc.bidding.domain.bidding;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TWinBid implements Serializable {
    private Long id;

    private Long projectId;

    private String projectName;

    private String projectCode;

    private Long procurementProjectId;

    private String procurementProjectName;

    private Long bidId;

    private String bidName;

    private String bidCode;

    private Long purchaserId;

    private BigDecimal purchaserMonety;

    private String filePath;

    private Long supplierId;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
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

    public String getBidCode() {
        return bidCode;
    }

    public void setBidCode(String bidCode) {
        this.bidCode = bidCode == null ? null : bidCode.trim();
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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
        sb.append(", projectName=").append(projectName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", procurementProjectName=").append(procurementProjectName);
        sb.append(", bidId=").append(bidId);
        sb.append(", bidName=").append(bidName);
        sb.append(", bidCode=").append(bidCode);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", purchaserMonety=").append(purchaserMonety);
        sb.append(", filePath=").append(filePath);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}