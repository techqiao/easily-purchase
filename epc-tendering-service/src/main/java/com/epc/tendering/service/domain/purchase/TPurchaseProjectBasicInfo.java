package com.epc.tendering.service.domain.purchase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPurchaseProjectBasicInfo implements Serializable {
    private Long id;

    private String projectId;

    private String projectName;

    private String purchaseProjectName;

    private String purchaseProjectCode;

    private Date purchaseStartTime;

    private Date purchaseEndTime;

    private Integer isStateDesignation;

    private BigDecimal purchaseProjectBudgetaryAmount;

    private String purchaseMode;

    private String purchaseCategory;

    private String purchaseType;

    private Integer purchaseRange;

    private String purchaseProjectStatus;

    private Integer isAdjust;

    private Integer isOtherAgency;

    private Long operateId;

    private String creator;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getPurchaseProjectName() {
        return purchaseProjectName;
    }

    public void setPurchaseProjectName(String purchaseProjectName) {
        this.purchaseProjectName = purchaseProjectName == null ? null : purchaseProjectName.trim();
    }

    public String getPurchaseProjectCode() {
        return purchaseProjectCode;
    }

    public void setPurchaseProjectCode(String purchaseProjectCode) {
        this.purchaseProjectCode = purchaseProjectCode == null ? null : purchaseProjectCode.trim();
    }

    public Date getPurchaseStartTime() {
        return purchaseStartTime;
    }

    public void setPurchaseStartTime(Date purchaseStartTime) {
        this.purchaseStartTime = purchaseStartTime;
    }

    public Date getPurchaseEndTime() {
        return purchaseEndTime;
    }

    public void setPurchaseEndTime(Date purchaseEndTime) {
        this.purchaseEndTime = purchaseEndTime;
    }

    public Integer getIsStateDesignation() {
        return isStateDesignation;
    }

    public void setIsStateDesignation(Integer isStateDesignation) {
        this.isStateDesignation = isStateDesignation;
    }

    public BigDecimal getPurchaseProjectBudgetaryAmount() {
        return purchaseProjectBudgetaryAmount;
    }

    public void setPurchaseProjectBudgetaryAmount(BigDecimal purchaseProjectBudgetaryAmount) {
        this.purchaseProjectBudgetaryAmount = purchaseProjectBudgetaryAmount;
    }

    public String getPurchaseMode() {
        return purchaseMode;
    }

    public void setPurchaseMode(String purchaseMode) {
        this.purchaseMode = purchaseMode == null ? null : purchaseMode.trim();
    }

    public String getPurchaseCategory() {
        return purchaseCategory;
    }

    public void setPurchaseCategory(String purchaseCategory) {
        this.purchaseCategory = purchaseCategory == null ? null : purchaseCategory.trim();
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType == null ? null : purchaseType.trim();
    }

    public Integer getPurchaseRange() {
        return purchaseRange;
    }

    public void setPurchaseRange(Integer purchaseRange) {
        this.purchaseRange = purchaseRange;
    }

    public String getPurchaseProjectStatus() {
        return purchaseProjectStatus;
    }

    public void setPurchaseProjectStatus(String purchaseProjectStatus) {
        this.purchaseProjectStatus = purchaseProjectStatus == null ? null : purchaseProjectStatus.trim();
    }

    public Integer getIsAdjust() {
        return isAdjust;
    }

    public void setIsAdjust(Integer isAdjust) {
        this.isAdjust = isAdjust;
    }

    public Integer getIsOtherAgency() {
        return isOtherAgency;
    }

    public void setIsOtherAgency(Integer isOtherAgency) {
        this.isOtherAgency = isOtherAgency;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        sb.append(", projectName=").append(projectName);
        sb.append(", purchaseProjectName=").append(purchaseProjectName);
        sb.append(", purchaseProjectCode=").append(purchaseProjectCode);
        sb.append(", purchaseStartTime=").append(purchaseStartTime);
        sb.append(", purchaseEndTime=").append(purchaseEndTime);
        sb.append(", isStateDesignation=").append(isStateDesignation);
        sb.append(", purchaseProjectBudgetaryAmount=").append(purchaseProjectBudgetaryAmount);
        sb.append(", purchaseMode=").append(purchaseMode);
        sb.append(", purchaseCategory=").append(purchaseCategory);
        sb.append(", purchaseType=").append(purchaseType);
        sb.append(", purchaseRange=").append(purchaseRange);
        sb.append(", purchaseProjectStatus=").append(purchaseProjectStatus);
        sb.append(", isAdjust=").append(isAdjust);
        sb.append(", isOtherAgency=").append(isOtherAgency);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}