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
}
