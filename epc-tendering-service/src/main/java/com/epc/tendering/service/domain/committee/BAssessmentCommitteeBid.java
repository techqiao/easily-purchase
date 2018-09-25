package com.epc.tendering.service.domain.committee;

import java.io.Serializable;
import java.util.Date;

public class BAssessmentCommitteeBid implements Serializable {
    private Long id;

    private Long committeeId;

    private Long bidsId;

    private String bidsName;

    private Integer professionalNumber;

    private String professionalName;

    private String professionalLevel;

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

    public Long getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Long committeeId) {
        this.committeeId = committeeId;
    }

    public Long getBidsId() {
        return bidsId;
    }

    public void setBidsId(Long bidsId) {
        this.bidsId = bidsId;
    }

    public String getBidsName() {
        return bidsName;
    }

    public void setBidsName(String bidsName) {
        this.bidsName = bidsName == null ? null : bidsName.trim();
    }

    public Integer getProfessionalNumber() {
        return professionalNumber;
    }

    public void setProfessionalNumber(Integer professionalNumber) {
        this.professionalNumber = professionalNumber;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName == null ? null : professionalName.trim();
    }

    public String getProfessionalLevel() {
        return professionalLevel;
    }

    public void setProfessionalLevel(String professionalLevel) {
        this.professionalLevel = professionalLevel == null ? null : professionalLevel.trim();
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
        sb.append(", committeeId=").append(committeeId);
        sb.append(", bidsId=").append(bidsId);
        sb.append(", bidsName=").append(bidsName);
        sb.append(", professionalNumber=").append(professionalNumber);
        sb.append(", professionalName=").append(professionalName);
        sb.append(", professionalLevel=").append(professionalLevel);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}