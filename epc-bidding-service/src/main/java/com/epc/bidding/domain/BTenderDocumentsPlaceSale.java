package com.epc.bidding.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BTenderDocumentsPlaceSale implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private Long bIssueDocumentsId;

    private Date saleTimeStart;

    private Date saleTimeEnd;

    private String place;

    private BigDecimal price;

    private String contactsName;

    private String contactNumber;

    private String remarks;

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

    public Date getSaleTimeStart() {
        return saleTimeStart;
    }

    public void setSaleTimeStart(Date saleTimeStart) {
        this.saleTimeStart = saleTimeStart;
    }

    public Date getSaleTimeEnd() {
        return saleTimeEnd;
    }

    public void setSaleTimeEnd(Date saleTimeEnd) {
        this.saleTimeEnd = saleTimeEnd;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
        sb.append(", saleTimeStart=").append(saleTimeStart);
        sb.append(", saleTimeEnd=").append(saleTimeEnd);
        sb.append(", place=").append(place);
        sb.append(", price=").append(price);
        sb.append(", contactsName=").append(contactsName);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", remarks=").append(remarks);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}