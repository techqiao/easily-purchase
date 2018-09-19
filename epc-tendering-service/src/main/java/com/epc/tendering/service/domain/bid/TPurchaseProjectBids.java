package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPurchaseProjectBids implements Serializable {
    private Long id;

    private Long purchaseProjectId;

    private String purchaseProjectName;

    private Long projectId;

    private String projectName;

    private String bidCode;

    private String bidName;

    private BigDecimal bidBudgetaryAmount;

    private BigDecimal guaranteePayment;

    private String bidFilePath;

    private Long operateId;

    private String creator;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String bidMemo;

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

    public String getPurchaseProjectName() {
        return purchaseProjectName;
    }

    public void setPurchaseProjectName(String purchaseProjectName) {
        this.purchaseProjectName = purchaseProjectName == null ? null : purchaseProjectName.trim();
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getBidCode() {
        return bidCode;
    }

    public void setBidCode(String bidCode) {
        this.bidCode = bidCode == null ? null : bidCode.trim();
    }

    public String getBidName() {
        return bidName;
    }

    public void setBidName(String bidName) {
        this.bidName = bidName == null ? null : bidName.trim();
    }

    public BigDecimal getBidBudgetaryAmount() {
        return bidBudgetaryAmount;
    }

    public void setBidBudgetaryAmount(BigDecimal bidBudgetaryAmount) {
        this.bidBudgetaryAmount = bidBudgetaryAmount;
    }

    public BigDecimal getGuaranteePayment() {
        return guaranteePayment;
    }

    public void setGuaranteePayment(BigDecimal guaranteePayment) {
        this.guaranteePayment = guaranteePayment;
    }

    public String getBidFilePath() {
        return bidFilePath;
    }

    public void setBidFilePath(String bidFilePath) {
        this.bidFilePath = bidFilePath == null ? null : bidFilePath.trim();
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

    public String getBidMemo() {
        return bidMemo;
    }

    public void setBidMemo(String bidMemo) {
        this.bidMemo = bidMemo == null ? null : bidMemo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", purchaseProjectId=").append(purchaseProjectId);
        sb.append(", purchaseProjectName=").append(purchaseProjectName);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", bidCode=").append(bidCode);
        sb.append(", bidName=").append(bidName);
        sb.append(", bidBudgetaryAmount=").append(bidBudgetaryAmount);
        sb.append(", guaranteePayment=").append(guaranteePayment);
        sb.append(", bidFilePath=").append(bidFilePath);
        sb.append(", operateId=").append(operateId);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", bidMemo=").append(bidMemo);
        sb.append("]");
        return sb.toString();
    }
}