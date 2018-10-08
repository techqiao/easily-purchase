package com.epc.bidding.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TProjectBasicInfo implements Serializable {
    private Long id;

    private String projectCode;

    private String projectName;

    private String projectDescription;

    private BigDecimal totalProjectInvestment;

    private Integer sourceOfInvestment;

    private String projectAddress;

    private Long purchaserId;

    private Long operateId;

    private String creator;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String projectMemo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public BigDecimal getTotalProjectInvestment() {
        return totalProjectInvestment;
    }

    public void setTotalProjectInvestment(BigDecimal totalProjectInvestment) {
        this.totalProjectInvestment = totalProjectInvestment;
    }

    public Integer getSourceOfInvestment() {
        return sourceOfInvestment;
    }

    public void setSourceOfInvestment(Integer sourceOfInvestment) {
        this.sourceOfInvestment = sourceOfInvestment;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
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

    public String getProjectMemo() {
        return projectMemo;
    }

    public void setProjectMemo(String projectMemo) {
        this.projectMemo = projectMemo == null ? null : projectMemo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectDescription=").append(projectDescription);
        sb.append(", totalProjectInvestment=").append(totalProjectInvestment);
        sb.append(", sourceOfInvestment=").append(sourceOfInvestment);
        sb.append(", projectAddress=").append(projectAddress);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", projectMemo=").append(projectMemo);
        sb.append("]");
        return sb.toString();
    }
}