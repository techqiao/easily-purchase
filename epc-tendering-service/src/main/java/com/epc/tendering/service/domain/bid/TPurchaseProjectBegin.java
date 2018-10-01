package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.util.Date;

public class TPurchaseProjectBegin implements Serializable {
    private Long id;

    private String packetMode;

    private Integer isPrequalification;

    private Long purchaseProjectId;

    private String purchaseProjectName;

    private String purchaseProjectCode;

    private Long projectId;

    private String projectName;

    private String projectCode;

    private String purchasePlace;

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

    public String getPacketMode() {
        return packetMode;
    }

    public void setPacketMode(String packetMode) {
        this.packetMode = packetMode == null ? null : packetMode.trim();
    }

    public Integer getIsPrequalification() {
        return isPrequalification;
    }

    public void setIsPrequalification(Integer isPrequalification) {
        this.isPrequalification = isPrequalification;
    }

    public Long getPurchaseProjectId() {
        return purchaseProjectId;
    }

    public void setPurchaseProjectId(Long purchaseProjectId) {
        this.purchaseProjectId = purchaseProjectId;
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

    public String getPurchasePlace() {
        return purchasePlace;
    }

    public void setPurchasePlace(String purchasePlace) {
        this.purchasePlace = purchasePlace == null ? null : purchasePlace.trim();
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
        sb.append(", packetMode=").append(packetMode);
        sb.append(", isPrequalification=").append(isPrequalification);
        sb.append(", purchaseProjectId=").append(purchaseProjectId);
        sb.append(", purchaseProjectName=").append(purchaseProjectName);
        sb.append(", purchaseProjectCode=").append(purchaseProjectCode);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", purchasePlace=").append(purchasePlace);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}