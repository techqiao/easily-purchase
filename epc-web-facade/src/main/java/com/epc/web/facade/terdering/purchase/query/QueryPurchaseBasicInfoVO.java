package com.epc.web.facade.terdering.purchase.query;

import com.epc.common.PagerParam;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 19:45
 * <p>@Author : wjq
 */
@Data
public class QueryPurchaseBasicInfoVO extends PagerParam {
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

}
