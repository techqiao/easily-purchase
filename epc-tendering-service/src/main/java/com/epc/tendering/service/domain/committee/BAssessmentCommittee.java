package com.epc.tendering.service.domain.committee;

import java.io.Serializable;
import java.util.Date;

public class BAssessmentCommittee implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Integer totalNumber;

    private Integer platformExpertsNumber;

    private Integer ownerSpecialistsNumber;

    private Long auditorId;

    private Long repliesId;

    private String processStatus;

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

    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getPlatformExpertsNumber() {
        return platformExpertsNumber;
    }

    public void setPlatformExpertsNumber(Integer platformExpertsNumber) {
        this.platformExpertsNumber = platformExpertsNumber;
    }

    public Integer getOwnerSpecialistsNumber() {
        return ownerSpecialistsNumber;
    }

    public void setOwnerSpecialistsNumber(Integer ownerSpecialistsNumber) {
        this.ownerSpecialistsNumber = ownerSpecialistsNumber;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Long getRepliesId() {
        return repliesId;
    }

    public void setRepliesId(Long repliesId) {
        this.repliesId = repliesId;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
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
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", totalNumber=").append(totalNumber);
        sb.append(", platformExpertsNumber=").append(platformExpertsNumber);
        sb.append(", ownerSpecialistsNumber=").append(ownerSpecialistsNumber);
        sb.append(", auditorId=").append(auditorId);
        sb.append(", repliesId=").append(repliesId);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}