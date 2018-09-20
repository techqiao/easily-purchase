package com.epc.bidding.domain.bidding;

import java.io.Serializable;
import java.util.Date;

public class BIssueDocuments implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Long auditorId;

    private Long repliesId;

    private String biddingDocumentsUrl;

    private Date biddingStart;

    private Date biddingEnd;

    private Long agencyId;

    private String agencyName;

    private Integer processState;

    private Date createAt;

    private Date updateAt;

    private Boolean isDeleted;

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

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
    }

    public Integer getProcessState() {
        return processState;
    }

    public void setProcessState(Integer processState) {
        this.processState = processState;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
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
        sb.append(", agencyId=").append(agencyId);
        sb.append(", agencyName=").append(agencyName);
        sb.append(", processState=").append(processState);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", announcementContent=").append(announcementContent);
        sb.append("]");
        return sb.toString();
    }
}