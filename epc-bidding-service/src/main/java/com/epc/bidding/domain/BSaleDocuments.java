package com.epc.bidding.domain;

import java.io.Serializable;
import java.util.Date;

public class BSaleDocuments implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Long auditorId;

    private Long repliesId;

    private String biddingDocumentsUpUrl;

    private String biddingDocumentsDownloadUrl;

    private Integer isUnderLine;

    private Date biddingEndTime;

    private Date biddingBondEndTime;

    private Date bidOpeningTime;

    private String bidOpeningPlace;

    private Date clarificationProblemEndTime;

    private Integer decryptionMethod;

    private Integer processStatus;

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

    public String getBiddingDocumentsUpUrl() {
        return biddingDocumentsUpUrl;
    }

    public void setBiddingDocumentsUpUrl(String biddingDocumentsUpUrl) {
        this.biddingDocumentsUpUrl = biddingDocumentsUpUrl == null ? null : biddingDocumentsUpUrl.trim();
    }

    public String getBiddingDocumentsDownloadUrl() {
        return biddingDocumentsDownloadUrl;
    }

    public void setBiddingDocumentsDownloadUrl(String biddingDocumentsDownloadUrl) {
        this.biddingDocumentsDownloadUrl = biddingDocumentsDownloadUrl == null ? null : biddingDocumentsDownloadUrl.trim();
    }

    public Integer getIsUnderLine() {
        return isUnderLine;
    }

    public void setIsUnderLine(Integer isUnderLine) {
        this.isUnderLine = isUnderLine;
    }

    public Date getBiddingEndTime() {
        return biddingEndTime;
    }

    public void setBiddingEndTime(Date biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    public Date getBiddingBondEndTime() {
        return biddingBondEndTime;
    }

    public void setBiddingBondEndTime(Date biddingBondEndTime) {
        this.biddingBondEndTime = biddingBondEndTime;
    }

    public Date getBidOpeningTime() {
        return bidOpeningTime;
    }

    public void setBidOpeningTime(Date bidOpeningTime) {
        this.bidOpeningTime = bidOpeningTime;
    }

    public String getBidOpeningPlace() {
        return bidOpeningPlace;
    }

    public void setBidOpeningPlace(String bidOpeningPlace) {
        this.bidOpeningPlace = bidOpeningPlace == null ? null : bidOpeningPlace.trim();
    }

    public Date getClarificationProblemEndTime() {
        return clarificationProblemEndTime;
    }

    public void setClarificationProblemEndTime(Date clarificationProblemEndTime) {
        this.clarificationProblemEndTime = clarificationProblemEndTime;
    }

    public Integer getDecryptionMethod() {
        return decryptionMethod;
    }

    public void setDecryptionMethod(Integer decryptionMethod) {
        this.decryptionMethod = decryptionMethod;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
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
        sb.append(", auditorId=").append(auditorId);
        sb.append(", repliesId=").append(repliesId);
        sb.append(", biddingDocumentsUpUrl=").append(biddingDocumentsUpUrl);
        sb.append(", biddingDocumentsDownloadUrl=").append(biddingDocumentsDownloadUrl);
        sb.append(", isUnderLine=").append(isUnderLine);
        sb.append(", biddingEndTime=").append(biddingEndTime);
        sb.append(", biddingBondEndTime=").append(biddingBondEndTime);
        sb.append(", bidOpeningTime=").append(bidOpeningTime);
        sb.append(", bidOpeningPlace=").append(bidOpeningPlace);
        sb.append(", clarificationProblemEndTime=").append(clarificationProblemEndTime);
        sb.append(", decryptionMethod=").append(decryptionMethod);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}