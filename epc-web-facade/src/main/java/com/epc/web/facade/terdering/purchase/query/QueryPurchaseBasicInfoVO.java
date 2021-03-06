package com.epc.web.facade.terdering.purchase.query;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 19:45
 * <p>@Author : wjq
 */
@Data
public class QueryPurchaseBasicInfoVO extends PagerParam implements Serializable {
    private static final long serialVersionUID = -5063764601070440894L;
    /**
     * 采购项目名称
     */
    private String purchaseProjectName;
    /**
     * 采购项目编号
     */
    private String purchaseProjectCode;
    /**
     * 开始时间
     */
    private Date purchaseStartTime;
    /**
     * 结束时间
     */
    private Date purchaseEndTime;
    /**
     * 采购项目状态
     */
    private String purchaseProjectStatus;
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
     * 项目ID
     */
    private Long projectId;
}
