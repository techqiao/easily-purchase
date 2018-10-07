package com.epc.tendering.service.domain.purchaser;

import java.io.Serializable;
import java.util.Date;

public class TProjectPurchaserEmployeeRelation implements Serializable {
    private Long id;

    private Long projectId;

    private String projectPurchaserName;

    private Long createrId;

    private String createrName;

    private Long purchaserId;

    private Long executiveId;

    private String executiveName;

    private Integer state;

    private Date createAt;

    private Date updateAt;

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

    public String getProjectPurchaserName() {
        return projectPurchaserName;
    }

    public void setProjectPurchaserName(String projectPurchaserName) {
        this.projectPurchaserName = projectPurchaserName == null ? null : projectPurchaserName.trim();
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName == null ? null : createrName.trim();
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectPurchaserName=").append(projectPurchaserName);
        sb.append(", createrId=").append(createrId);
        sb.append(", createrName=").append(createrName);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", executiveId=").append(executiveId);
        sb.append(", executiveName=").append(executiveName);
        sb.append(", state=").append(state);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append("]");
        return sb.toString();
    }
}