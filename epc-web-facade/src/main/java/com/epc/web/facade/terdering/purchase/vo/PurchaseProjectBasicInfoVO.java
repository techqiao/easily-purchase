package com.epc.web.facade.terdering.purchase.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : 项目基本属性类
 * <p>Date : 2018-09-18 19:29
 * <p>@Author : wjq
 */
@Data
public class PurchaseProjectBasicInfoVO implements Serializable {
    private static final long serialVersionUID = -5494140873900417955L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 项目ID
     */
    private String projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 采购项目名称
     */
    private String purchaseProjectName;
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
    private String purchaseMode;
    /**
     * 采购分类
     */
    private String purchaseCategory;
    /**
     * 采购类型
     */
    private String purchaseType;
    /**
     * 可见范围 0-全平台 1-供应商私库
     */
    private Integer purchaseRange;
    /**
     * 是否允许调价 0-不允许,1-允许
     */
    private Integer isAdjust;
    /**
     * 是否全权委托招标代理机构(0-不全权委托,1-全权委托)
     */
    private Integer isOtherAgency;
    /**
     * 采购项目状态
     */
    private String purchaseProjectStatus;


}
