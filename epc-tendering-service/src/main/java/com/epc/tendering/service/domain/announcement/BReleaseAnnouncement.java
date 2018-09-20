package com.epc.tendering.service.domain.announcement;

import java.io.Serializable;
import java.util.Date;

public class BReleaseAnnouncement implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Long auditorId;

    private Long repliesId;

    private String biddingDocumentsUrl;

    private Date biddingStart;

    private Date biddingEnd;

    private String processStatus;

    private Long operateId;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String announcementContent;

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

    public String getBiddingDocumentsUrl() {
        return biddingDocumentsUrl;
    }

    public void setBiddingDocumentsUrl(String biddingDocumentsUrl) {
        this.biddingDocumentsUrl = biddingDocumentsUrl == null ? null : biddingDocumentsUrl.trim();
    }

    public Date getBiddingStart() {
        return biddingStart;
    }

    public void setBiddingStart(Date biddingStart) {
        this.biddingStart = biddingStart;
    }

    public Date getBiddingEnd() {
        return biddingEnd;
    }

    public void setBiddingEnd(Date biddingEnd) {
        this.biddingEnd = biddingEnd;
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

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent == null ? null : announcementContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", auditorId=").append(auditorId);
        sb.append(", repliesId=").append(repliesId);
        sb.append(", biddingDocumentsUrl=").append(biddingDocumentsUrl);
        sb.append(", biddingStart=").append(biddingStart);
        sb.append(", biddingEnd=").append(biddingEnd);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", announcementContent=").append(announcementContent);
        sb.append("]");
        return sb.toString();
    }
}