package com.epc.tendering.service.domain.purchase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPurchaseProjectFilePay implements Serializable {
    private Long id;

    private Long purchaseProjectFileId;

    private BigDecimal filePaymentReal;

    private Long companyId;

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

    public Long getPurchaseProjectFileId() {
        return purchaseProjectFileId;
    }

    public void setPurchaseProjectFileId(Long purchaseProjectFileId) {
        this.purchaseProjectFileId = purchaseProjectFileId;
    }

    public BigDecimal getFilePaymentReal() {
        return filePaymentReal;
    }

    public void setFilePaymentReal(BigDecimal filePaymentReal) {
        this.filePaymentReal = filePaymentReal;
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
        sb.append(", purchaseProjectFileId=").append(purchaseProjectFileId);
        sb.append(", filePaymentReal=").append(filePaymentReal);
        sb.append(", companyId=").append(companyId);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}