package com.epc.platform.service.domain.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:platform_bank_account表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-10-09
 */
public class PlatformBankAccount implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 收款单位
     */
    private String proceedsUnit;

    /**
     * 开户银行
     */
    private String bankOfDeposit;

    /**
     * 收款账号
     */
    private String shroffAccountNumber;

    /**
     * 大额行号
     */
    private String wholesaleLineNumber;

    /**
     * 同城行号
     */
    private String locationLineNumber;

    /**
     * 收款类型 
     */
    private Integer paymentType;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

    /**
     * platform_bank_account
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 收款单位
     * @return proceeds_ unit 收款单位
     */
    public String getProceedsUnit() {
        return proceedsUnit;
    }

    /**
     * 收款单位
     * @param proceedsUnit 收款单位
     */
    public void setProceedsUnit(String proceedsUnit) {
        this.proceedsUnit = proceedsUnit == null ? null : proceedsUnit.trim();
    }

    /**
     * 开户银行
     * @return bank_of_deposit 开户银行
     */
    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    /**
     * 开户银行
     * @param bankOfDeposit 开户银行
     */
    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    /**
     * 收款账号
     * @return shroff_account_number 收款账号
     */
    public String getShroffAccountNumber() {
        return shroffAccountNumber;
    }

    /**
     * 收款账号
     * @param shroffAccountNumber 收款账号
     */
    public void setShroffAccountNumber(String shroffAccountNumber) {
        this.shroffAccountNumber = shroffAccountNumber == null ? null : shroffAccountNumber.trim();
    }

    /**
     * 大额行号
     * @return wholesale_line_number 大额行号
     */
    public String getWholesaleLineNumber() {
        return wholesaleLineNumber;
    }

    /**
     * 大额行号
     * @param wholesaleLineNumber 大额行号
     */
    public void setWholesaleLineNumber(String wholesaleLineNumber) {
        this.wholesaleLineNumber = wholesaleLineNumber == null ? null : wholesaleLineNumber.trim();
    }

    /**
     * 同城行号
     * @return location_line_number 同城行号
     */
    public String getLocationLineNumber() {
        return locationLineNumber;
    }

    /**
     * 同城行号
     * @param locationLineNumber 同城行号
     */
    public void setLocationLineNumber(String locationLineNumber) {
        this.locationLineNumber = locationLineNumber == null ? null : locationLineNumber.trim();
    }

    /**
     * 收款类型 
     * @return Payment type 收款类型 
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 收款类型 
     * @param paymentType 收款类型 
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 创建时间
     * @return create_at 创建时间
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * 创建时间
     * @param createAt 创建时间
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 最后修改时间
     * @return update_at 最后修改时间
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * 最后修改时间
     * @param updateAt 最后修改时间
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 是否删除: 0-存在,1-删除
     * @return is_deleted 是否删除: 0-存在,1-删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除: 0-存在,1-删除
     * @param isDeleted 是否删除: 0-存在,1-删除
     */
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