package com.epc.bidding.domain.bidding;

import java.io.Serializable;
import java.util.Date;

public class TTenderMessage implements Serializable {
    private Long id;

    private Long purchaseProjectId;

    private Long releaseAnnouncementId;

    private Long bidsId;

    private Long companyId;

    private String companyName;

    private String delegator;

    private String identitCard;

    private String bailmentPath;

    private String bidAppendix;

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

    public Long getBidsId() {
        return bidsId;
    }

    public void setBidsId(Long bidsId) {
        this.bidsId = bidsId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
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
        sb.append(", purchaseProjectId=").append(purchaseProjectId);
        sb.append(", releaseAnnouncementId=").append(releaseAnnouncementId);
        sb.append(", bidsId=").append(bidsId);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", delegator=").append(delegator);
        sb.append(", identitCard=").append(identitCard);
        sb.append(", bailmentPath=").append(bailmentPath);
        sb.append(", bidAppendix=").append(bidAppendix);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}