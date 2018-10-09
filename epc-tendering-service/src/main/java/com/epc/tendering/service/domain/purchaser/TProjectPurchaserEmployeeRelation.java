package com.epc.tendering.service.domain.purchaser;

import java.io.Serializable;
import java.util.Date;

public class TProjectPurchaserEmployeeRelation implements Serializable {
    private Long id;

    private Long projectId;

    private Long purchaserId;

    private String projectPurchaserName;

    private Long executiveId;

    private String executiveName;

    private Long approvalId;

    private String approvalName;

    private Long checkId;

    private String checkName;

    private Integer state;

    private Integer isDeleted;

    private Date createAt;

    private Date updateAt;

    private String notes;

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

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getProjectPurchaserName() {
        return projectPurchaserName;
    }

    public void setProjectPurchaserName(String projectPurchaserName) {
        this.projectPurchaserName = projectPurchaserName == null ? null : projectPurchaserName.trim();
    }

    public Long getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(Long executiveId) {
        this.executiveId = executiveId;
    }

    public String getExecutiveName() {
        return executiveName;
    }

    public void setExecutiveName(String executiveName) {
        this.executiveName = executiveName == null ? null : executiveName.trim();
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName == null ? null : approvalName.trim();
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", projectPurchaserName=").append(projectPurchaserName);
        sb.append(", executiveId=").append(executiveId);
        sb.append(", executiveName=").append(executiveName);
        sb.append(", approvalId=").append(approvalId);
        sb.append(", approvalName=").append(approvalName);
        sb.append(", checkId=").append(checkId);
        sb.append(", checkName=").append(checkName);
        sb.append(", state=").append(state);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", notes=").append(notes);
        sb.append("]");
        return sb.toString();
    }
}