package com.epc.bidding.domain;

import java.io.Serializable;
import java.util.Date;

public class TPurchaseProjectParticipantPermission implements Serializable {
    private Long id;

    private Long participantId;

    private Long userId;

    private Integer participantType;

    private Integer actionState;

    private String stepType;

    private Long purchaseProjectId;

    private String participantPermission;

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

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getParticipantType() {
        return participantType;
    }

    public void setParticipantType(Integer participantType) {
        this.participantType = participantType;
    }

    public Integer getActionState() {
        return actionState;
    }

    public void setActionState(Integer actionState) {
        this.actionState = actionState;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType == null ? null : stepType.trim();
    }

    public Long getPurchaseProjectId() {
        return purchaseProjectId;
    }

    public void setPurchaseProjectId(Long purchaseProjectId) {
        this.purchaseProjectId = purchaseProjectId;
    }

    public String getParticipantPermission() {
        return participantPermission;
    }

    public void setParticipantPermission(String participantPermission) {
        this.participantPermission = participantPermission == null ? null : participantPermission.trim();
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
        sb.append(", participantId=").append(participantId);
        sb.append(", userId=").append(userId);
        sb.append(", participantType=").append(participantType);
        sb.append(", actionState=").append(actionState);
        sb.append(", stepType=").append(stepType);
        sb.append(", purchaseProjectId=").append(purchaseProjectId);
        sb.append(", participantPermission=").append(participantPermission);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}