package com.epc.web.service.domain.purchaser;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TWinBidNominate implements Serializable {
    private Long id;

    private Long purchaserId;

    private String purchaserName;

    private String agencyName;

    private String agencyPhone;

    private Integer isPowerAgency;

    private String projectName;

    private String projectCode;

    private Long purchaseProjectId;

    private Long bidId;

    private String bidName;

    private String bidCode;

    private Long firstSupplierid;

    private String firstCompanyname;

    private BigDecimal firstPrice;

    private Long twoSupplierid;

    private BigDecimal twoPrice;

    private String twoCompanyname;

    private Long threeSupplierid;

    private BigDecimal threePrice;

    private String threeCompanyname;

    private Date openStart;

    private Date openEnd;

    private String filePath;

    private String processStatus;

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

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName == null ? null : purchaserName.trim();
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone == null ? null : agencyPhone.trim();
    }

    public Integer getIsPowerAgency() {
        return isPowerAgency;
    }

    public void setIsPowerAgency(Integer isPowerAgency) {
        this.isPowerAgency = isPowerAgency;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public Long getPurchaseProjectId() {
        return purchaseProjectId;
    }

    public void setPurchaseProjectId(Long purchaseProjectId) {
        this.purchaseProjectId = purchaseProjectId;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public String getBidName() {
        return bidName;
    }

    public void setBidName(String bidName) {
        this.bidName = bidName == null ? null : bidName.trim();
    }

    public String getBidCode() {
        return bidCode;
    }

    public void setBidCode(String bidCode) {
        this.bidCode = bidCode == null ? null : bidCode.trim();
    }

    public Long getFirstSupplierid() {
        return firstSupplierid;
    }

    public void setFirstSupplierid(Long firstSupplierid) {
        this.firstSupplierid = firstSupplierid;
    }

    public String getFirstCompanyname() {
        return firstCompanyname;
    }

    public void setFirstCompanyname(String firstCompanyname) {
        this.firstCompanyname = firstCompanyname == null ? null : firstCompanyname.trim();
    }

    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    public Long getTwoSupplierid() {
        return twoSupplierid;
    }

    public void setTwoSupplierid(Long twoSupplierid) {
        this.twoSupplierid = twoSupplierid;
    }

    public BigDecimal getTwoPrice() {
        return twoPrice;
    }

    public void setTwoPrice(BigDecimal twoPrice) {
        this.twoPrice = twoPrice;
    }

    public String getTwoCompanyname() {
        return twoCompanyname;
    }

    public void setTwoCompanyname(String twoCompanyname) {
        this.twoCompanyname = twoCompanyname == null ? null : twoCompanyname.trim();
    }

    public Long getThreeSupplierid() {
        return threeSupplierid;
    }

    public void setThreeSupplierid(Long threeSupplierid) {
        this.threeSupplierid = threeSupplierid;
    }

    public BigDecimal getThreePrice() {
        return threePrice;
    }

    public void setThreePrice(BigDecimal threePrice) {
        this.threePrice = threePrice;
    }

    public String getThreeCompanyname() {
        return threeCompanyname;
    }

    public void setThreeCompanyname(String threeCompanyname) {
        this.threeCompanyname = threeCompanyname == null ? null : threeCompanyname.trim();
    }

    public Date getOpenStart() {
        return openStart;
    }

    public void setOpenStart(Date openStart) {
        this.openStart = openStart;
    }

    public Date getOpenEnd() {
        return openEnd;
    }

    public void setOpenEnd(Date openEnd) {
        this.openEnd = openEnd;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
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
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", purchaserName=").append(purchaserName);
        sb.append(", agencyName=").append(agencyName);
        sb.append(", agencyPhone=").append(agencyPhone);
        sb.append(", isPowerAgency=").append(isPowerAgency);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", purchaseProjectId=").append(purchaseProjectId);
        sb.append(", bidId=").append(bidId);
        sb.append(", bidName=").append(bidName);
        sb.append(", bidCode=").append(bidCode);
        sb.append(", firstSupplierid=").append(firstSupplierid);
        sb.append(", firstCompanyname=").append(firstCompanyname);
        sb.append(", firstPrice=").append(firstPrice);
        sb.append(", twoSupplierid=").append(twoSupplierid);
        sb.append(", twoPrice=").append(twoPrice);
        sb.append(", twoCompanyname=").append(twoCompanyname);
        sb.append(", threeSupplierid=").append(threeSupplierid);
        sb.append(", threePrice=").append(threePrice);
        sb.append(", threeCompanyname=").append(threeCompanyname);
        sb.append(", openStart=").append(openStart);
        sb.append(", openEnd=").append(openEnd);
        sb.append(", filePath=").append(filePath);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}