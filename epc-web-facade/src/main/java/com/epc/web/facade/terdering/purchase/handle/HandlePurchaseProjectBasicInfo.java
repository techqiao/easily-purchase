package com.epc.web.facade.terdering.purchase.handle;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 17:45
 * <p>@Author : wjq
 */
@Data
public class HandlePurchaseProjectBasicInfo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 采购项目名称
     */
    private String purchaseProjectName;
    /**
     * 采购项目编号
     */
    private String purchaseProjectCode;
    /**
     * 采购项目开始时间
     */
    private Date purchaseStartTime;
    /**
     * 采购项目结束时间
     */
    private Date purchaseEndTime;

    /**
     * 采购项目预算金额
     */
    private BigDecimal purchaseProjectBudgetaryAmount;

    /**
     * 采购方式
     */
    private Integer purchaseMode;

    /**
     * 采购分类
     */
    private Integer purchaseCategory;

    /**
     * 采购类型
     */
    private String purchaseType;

    /**
     * 可见范围
     */
    private Integer purchaseRange;

    /**
     * 是否允许调价
     */
    private Integer isAdjust;

    /**
     * 是否全权委托招标代理机构
     */
    private Integer isOtherAgency;

}
