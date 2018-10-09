package com.epc.bidding.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BBidsGuaranteeAmount implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Long bIssueDocumentsId;

    private BigDecimal tenderGuaranteeAmount;

    private String bidsName;

    private Long bidsId;

    private String bidsCode;

    private String receivables;

    private String bankAccount;

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

    public Long getbIssueDocumentsId() {
        return bIssueDocumentsId;
    }

    public void setbIssueDocumentsId(Long bIssueDocumentsId) {
        this.bIssueDocumentsId = bIssueDocumentsId;
    }

    public BigDecimal getTenderGuaranteeAmount() {
        return tenderGuaranteeAmount;
    }

    public void setTenderGuaranteeAmount(BigDecimal tenderGuaranteeAmount) {
        this.tenderGuaranteeAmount = tenderGuaranteeAmount;
    }

    public String getBidsName() {
        return bidsName;
    }

    public void setBidsName(String bidsName) {
        this.bidsName = bidsName == null ? null : bidsName.trim();
    }

    public Long getBidsId() {
        return bidsId;
    }

    public void setBidsId(Long bidsId) {
        this.bidsId = bidsId;
    }

    public String getBidsCode() {
        return bidsCode;
    }

    public void setBidsCode(String bidsCode) {
        this.bidsCode = bidsCode == null ? null : bidsCode.trim();
    }

    public String getReceivables() {
        return receivables;
    }

    public void setReceivables(String receivables) {
        this.receivables = receivables == null ? null : receivables.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
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
        sb.append(", bIssueDocumentsId=").append(bIssueDocumentsId);
        sb.append(", tenderGuaranteeAmount=").append(tenderGuaranteeAmount);
        sb.append(", bidsName=").append(bidsName);
        sb.append(", bidsId=").append(bidsId);
        sb.append(", bidsCode=").append(bidsCode);
        sb.append(", receivables=").append(receivables);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}