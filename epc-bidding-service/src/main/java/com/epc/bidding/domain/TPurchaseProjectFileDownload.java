package com.epc.bidding.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPurchaseProjectFileDownload implements Serializable {
    private Long id;

    private Long purchasProjectId;

    private Long purchaserId;

    private String purchaseFileName;

    private BigDecimal filePayment;

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

    public Long getPurchasProjectId() {
        return purchasProjectId;
    }

    public void setPurchasProjectId(Long purchasProjectId) {
        this.purchasProjectId = purchasProjectId;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getPurchaseFileName() {
        return purchaseFileName;
    }

    public void setPurchaseFileName(String purchaseFileName) {
        this.purchaseFileName = purchaseFileName == null ? null : purchaseFileName.trim();
    }

    public BigDecimal getFilePayment() {
        return filePayment;
    }

    public void setFilePayment(BigDecimal filePayment) {
        this.filePayment = filePayment;
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
        sb.append(", purchasProjectId=").append(purchasProjectId);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", purchaseFileName=").append(purchaseFileName);
        sb.append(", filePayment=").append(filePayment);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}