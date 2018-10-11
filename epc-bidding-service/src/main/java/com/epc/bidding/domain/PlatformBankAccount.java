package com.epc.bidding.domain;

import java.io.Serializable;
import java.util.Date;

public class PlatformBankAccount implements Serializable {
    private Long id;

    private String proceedsUnit;

    private String bankOfDeposit;

    private String shroffAccountNumber;

    private String wholesaleLineNumber;

    private String locationLineNumber;

    private Integer paymentType;

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

    public String getProceedsUnit() {
        return proceedsUnit;
    }

    public void setProceedsUnit(String proceedsUnit) {
        this.proceedsUnit = proceedsUnit == null ? null : proceedsUnit.trim();
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    public String getShroffAccountNumber() {
        return shroffAccountNumber;
    }

    public void setShroffAccountNumber(String shroffAccountNumber) {
        this.shroffAccountNumber = shroffAccountNumber == null ? null : shroffAccountNumber.trim();
    }

    public String getWholesaleLineNumber() {
        return wholesaleLineNumber;
    }

    public void setWholesaleLineNumber(String wholesaleLineNumber) {
        this.wholesaleLineNumber = wholesaleLineNumber == null ? null : wholesaleLineNumber.trim();
    }

    public String getLocationLineNumber() {
        return locationLineNumber;
    }

    public void setLocationLineNumber(String locationLineNumber) {
        this.locationLineNumber = locationLineNumber == null ? null : locationLineNumber.trim();
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
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
        sb.append(", proceedsUnit=").append(proceedsUnit);
        sb.append(", bankOfDeposit=").append(bankOfDeposit);
        sb.append(", shroffAccountNumber=").append(shroffAccountNumber);
        sb.append(", wholesaleLineNumber=").append(wholesaleLineNumber);
        sb.append(", locationLineNumber=").append(locationLineNumber);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}