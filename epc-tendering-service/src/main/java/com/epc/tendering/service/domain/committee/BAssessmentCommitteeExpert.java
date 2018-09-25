package com.epc.tendering.service.domain.committee;

import java.io.Serializable;
import java.util.Date;

public class BAssessmentCommitteeExpert implements Serializable {
    private Long id;

    private Long committeeBidId;

    private Date noticeTime;

    private String noticeMode;

    private String expertArea;

    private Long expertId;

    private String expertName;

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

    public Long getCommitteeBidId() {
        return committeeBidId;
    }

    public void setCommitteeBidId(Long committeeBidId) {
        this.committeeBidId = committeeBidId;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeMode() {
        return noticeMode;
    }

    public void setNoticeMode(String noticeMode) {
        this.noticeMode = noticeMode == null ? null : noticeMode.trim();
    }

    public String getExpertArea() {
        return expertArea;
    }

    public void setExpertArea(String expertArea) {
        this.expertArea = expertArea == null ? null : expertArea.trim();
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName == null ? null : expertName.trim();
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
        sb.append(", committeeBidId=").append(committeeBidId);
        sb.append(", noticeTime=").append(noticeTime);
        sb.append(", noticeMode=").append(noticeMode);
        sb.append(", expertArea=").append(expertArea);
        sb.append(", expertId=").append(expertId);
        sb.append(", expertName=").append(expertName);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}