package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.util.Date;

public class TTenderMessage implements Serializable {
    private Long id;

    private Long purchaseProjectId;

    private Long releaseAnnouncementId;

    private Long bidId;

    private Long companyId;

    private Long operateId;

    private String operateName;

    private String delegator;

    private String identitCard;

    private String bailmentPath;

    private String bidAppendix;

    private String status;

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

    public Long getPurchaseProjectId() {
        return purchaseProjectId;
    }

    public void setPurchaseProjectId(Long purchaseProjectId) {
        this.purchaseProjectId = purchaseProjectId;
    }

    public Long getReleaseAnnouncementId() {
        return releaseAnnouncementId;
    }

    public void setReleaseAnnouncementId(Long releaseAnnouncementId) {
        this.releaseAnnouncementId = releaseAnnouncementId;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName == null ? null : operateName.trim();
    }

    public String getDelegator() {
        return delegator;
    }

    public void setDelegator(String delegator) {
        this.delegator = delegator == null ? null : delegator.trim();
    }

    public String getIdentitCard() {
        return identitCard;
    }

    public void setIdentitCard(String identitCard) {
        this.identitCard = identitCard == null ? null : identitCard.trim();
    }

    public String getBailmentPath() {
        return bailmentPath;
    }

    public void setBailmentPath(String bailmentPath) {
        this.bailmentPath = bailmentPath == null ? null : bailmentPath.trim();
    }

    public String getBidAppendix() {
        return bidAppendix;
    }

    public void setBidAppendix(String bidAppendix) {
        this.bidAppendix = bidAppendix == null ? null : bidAppendix.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", purchaseProjectId=").append(purchaseProjectId);
        sb.append(", releaseAnnouncementId=").append(releaseAnnouncementId);
        sb.append(", bidId=").append(bidId);
        sb.append(", companyId=").append(companyId);
        sb.append(", operateId=").append(operateId);
        sb.append(", operateName=").append(operateName);
        sb.append(", delegator=").append(delegator);
        sb.append(", identitCard=").append(identitCard);
        sb.append(", bailmentPath=").append(bailmentPath);
        sb.append(", bidAppendix=").append(bidAppendix);
        sb.append(", status=").append(status);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}