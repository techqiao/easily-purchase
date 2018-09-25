package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.util.Date;

public class TOpeningRecord implements Serializable {
    private Long id;

    private Long purchaseProjectId;

    private Long tenderMessageId;

    private Long bidsId;

    private Long supplierCompanyId;

    private String supplierCompanyName;

    private Integer isPayBond;

    private Integer isSign;

    private Integer isBiddingQualified;

    private Integer isBiddingRefuse;

    private String biddingRefuseReason;

    private Integer status;

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

    public Long getTenderMessageId() {
        return tenderMessageId;
    }

    public void setTenderMessageId(Long tenderMessageId) {
        this.tenderMessageId = tenderMessageId;
    }

    public Long getBidsId() {
        return bidsId;
    }

    public void setBidsId(Long bidsId) {
        this.bidsId = bidsId;
    }

    public Long getSupplierCompanyId() {
        return supplierCompanyId;
    }

    public void setSupplierCompanyId(Long supplierCompanyId) {
        this.supplierCompanyId = supplierCompanyId;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName == null ? null : supplierCompanyName.trim();
    }

    public Integer getIsPayBond() {
        return isPayBond;
    }

    public void setIsPayBond(Integer isPayBond) {
        this.isPayBond = isPayBond;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public Integer getIsBiddingQualified() {
        return isBiddingQualified;
    }

    public void setIsBiddingQualified(Integer isBiddingQualified) {
        this.isBiddingQualified = isBiddingQualified;
    }

    public Integer getIsBiddingRefuse() {
        return isBiddingRefuse;
    }

    public void setIsBiddingRefuse(Integer isBiddingRefuse) {
        this.isBiddingRefuse = isBiddingRefuse;
    }

    public String getBiddingRefuseReason() {
        return biddingRefuseReason;
    }

    public void setBiddingRefuseReason(String biddingRefuseReason) {
        this.biddingRefuseReason = biddingRefuseReason == null ? null : biddingRefuseReason.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", tenderMessageId=").append(tenderMessageId);
        sb.append(", bidsId=").append(bidsId);
        sb.append(", supplierCompanyId=").append(supplierCompanyId);
        sb.append(", supplierCompanyName=").append(supplierCompanyName);
        sb.append(", isPayBond=").append(isPayBond);
        sb.append(", isSign=").append(isSign);
        sb.append(", isBiddingQualified=").append(isBiddingQualified);
        sb.append(", isBiddingRefuse=").append(isBiddingRefuse);
        sb.append(", biddingRefuseReason=").append(biddingRefuseReason);
        sb.append(", status=").append(status);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}