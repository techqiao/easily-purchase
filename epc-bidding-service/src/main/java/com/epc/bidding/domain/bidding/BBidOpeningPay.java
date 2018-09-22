package com.epc.bidding.domain.bidding;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BBidOpeningPay implements Serializable {
    private Long id;

    private Long bidsGuaranteeAmountId;

    private Long tendererId;

    private Long tendererCompanyId;

    private String tendererName;

    private Long tendererCompanyName;

    private Date amountMoneyTime;

    private BigDecimal amountMoney;

    private String paymentName;

    private String paymentAccountNumber;

    private Long paymentId;

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

    public Long getBidsGuaranteeAmountId() {
        return bidsGuaranteeAmountId;
    }

    public void setBidsGuaranteeAmountId(Long bidsGuaranteeAmountId) {
        this.bidsGuaranteeAmountId = bidsGuaranteeAmountId;
    }

    public Long getTendererId() {
        return tendererId;
    }

    public void setTendererId(Long tendererId) {
        this.tendererId = tendererId;
    }

    public Long getTendererCompanyId() {
        return tendererCompanyId;
    }

    public void setTendererCompanyId(Long tendererCompanyId) {
        this.tendererCompanyId = tendererCompanyId;
    }

    public String getTendererName() {
        return tendererName;
    }

    public void setTendererName(String tendererName) {
        this.tendererName = tendererName == null ? null : tendererName.trim();
    }

    public Long getTendererCompanyName() {
        return tendererCompanyName;
    }

    public void setTendererCompanyName(Long tendererCompanyName) {
        this.tendererCompanyName = tendererCompanyName;
    }

    public Date getAmountMoneyTime() {
        return amountMoneyTime;
    }

    public void setAmountMoneyTime(Date amountMoneyTime) {
        this.amountMoneyTime = amountMoneyTime;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    public String getPaymentAccountNumber() {
        return paymentAccountNumber;
    }

    public void setPaymentAccountNumber(String paymentAccountNumber) {
        this.paymentAccountNumber = paymentAccountNumber == null ? null : paymentAccountNumber.trim();
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
        sb.append(", bidsGuaranteeAmountId=").append(bidsGuaranteeAmountId);
        sb.append(", tendererId=").append(tendererId);
        sb.append(", tendererCompanyId=").append(tendererCompanyId);
        sb.append(", tendererName=").append(tendererName);
        sb.append(", tendererCompanyName=").append(tendererCompanyName);
        sb.append(", amountMoneyTime=").append(amountMoneyTime);
        sb.append(", amountMoney=").append(amountMoney);
        sb.append(", paymentName=").append(paymentName);
        sb.append(", paymentAccountNumber=").append(paymentAccountNumber);
        sb.append(", paymentId=").append(paymentId);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}