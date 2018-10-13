package com.epc.bidding.domain;

import java.io.Serializable;
import java.util.Date;

public class BSaleDocumentsFile implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Long saleDocumentsId;

    private String announcementUrl;

    private String noticeBidderUrl;

    private String technicalRequirementUrl;

    private String termsContractUrl;

    private String evaluationUrl;

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

    public Long getSaleDocumentsId() {
        return saleDocumentsId;
    }

    public void setSaleDocumentsId(Long saleDocumentsId) {
        this.saleDocumentsId = saleDocumentsId;
    }

    public String getAnnouncementUrl() {
        return announcementUrl;
    }

    public void setAnnouncementUrl(String announcementUrl) {
        this.announcementUrl = announcementUrl == null ? null : announcementUrl.trim();
    }

    public String getNoticeBidderUrl() {
        return noticeBidderUrl;
    }

    public void setNoticeBidderUrl(String noticeBidderUrl) {
        this.noticeBidderUrl = noticeBidderUrl == null ? null : noticeBidderUrl.trim();
    }

    public String getTechnicalRequirementUrl() {
        return technicalRequirementUrl;
    }

    public void setTechnicalRequirementUrl(String technicalRequirementUrl) {
        this.technicalRequirementUrl = technicalRequirementUrl == null ? null : technicalRequirementUrl.trim();
    }

    public String getTermsContractUrl() {
        return termsContractUrl;
    }

    public void setTermsContractUrl(String termsContractUrl) {
        this.termsContractUrl = termsContractUrl == null ? null : termsContractUrl.trim();
    }

    public String getEvaluationUrl() {
        return evaluationUrl;
    }

    public void setEvaluationUrl(String evaluationUrl) {
        this.evaluationUrl = evaluationUrl == null ? null : evaluationUrl.trim();
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
        sb.append(", saleDocumentsId=").append(saleDocumentsId);
        sb.append(", announcementUrl=").append(announcementUrl);
        sb.append(", noticeBidderUrl=").append(noticeBidderUrl);
        sb.append(", technicalRequirementUrl=").append(technicalRequirementUrl);
        sb.append(", termsContractUrl=").append(termsContractUrl);
        sb.append(", evaluationUrl=").append(evaluationUrl);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}