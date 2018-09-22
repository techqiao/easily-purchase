package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description : 处理采购项目标段相关参数
 * <p>Date : 2018-09-19 11:12
 * <p>@Author : wjq
 */
@Data
public class HandleBidsBasicInfo implements Serializable {
    private static final long serialVersionUID = -1638765685536416837L;
    /**
     * 主键ID 修改时传
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 采购项目名称
     */
    private String purchaseProjectName;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 采购方式
     */
    private String purchaseMode;
    /**
     * 标段编号
     */
    private String bidCode;
    /**
     * 标段名称
     */
    private String bidName;
    /**
     * 预算金额
     */
    private BigDecimal bidBudgetaryAmount;
    /**
     * 保证金金额
     */
    private BigDecimal guaranteePayment;
    /**
     * 标段文件路径
     */
    private String bidFilePath;
    /**
     * 标段说明
     */
    private String bidMemo;
    /**
     * 操作人ID
     */
    private Long operateId;
    /**
     * 创建者姓名
     */
    private String creator;

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
        this.purchaseProjectName = purchaseProjectName;
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
        this.projectName = projectName;
    }

    public String getPurchaseMode() {
        return purchaseMode;
    }

    public void setPurchaseMode(String purchaseMode) {
        this.purchaseMode = purchaseMode;
    }

    public String getBidCode() {
        return bidCode;
    }

    public void setBidCode(String bidCode) {
        this.bidCode = bidCode;
    }

    public String getBidName() {
        return bidName;
    }

    public void setBidName(String bidName) {
        this.bidName = bidName;
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
        this.bidFilePath = bidFilePath;
    }

    public String getBidMemo() {
        return bidMemo;
    }

    public void setBidMemo(String bidMemo) {
        this.bidMemo = bidMemo;
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
        this.creator = creator;
    }
}
