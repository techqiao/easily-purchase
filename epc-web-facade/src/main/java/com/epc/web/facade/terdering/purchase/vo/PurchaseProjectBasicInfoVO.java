package com.epc.web.facade.terdering.purchase.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 19:29
 * <p>@Author : wjq
 */
@ApiModel(value = "ProjectBasicInfoVO",description = "项目基本属性类")
@Data
public class PurchaseProjectBasicInfoVO {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "项目ID")
    private String projectId;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目开始时间")
    private Date purchaseStartTime;
    @ApiModelProperty(value = "采购项目结束时间")
    private Date purchaseEndTime;
    @ApiModelProperty(value = "采购项目预算金额")
    private BigDecimal purchaseProjectBudgetaryAmount;
    @ApiModelProperty(value = "采购方式")
    private String purchaseMode;
    @ApiModelProperty(value = "采购分类")
    private String purchaseCategory;
    @ApiModelProperty(value = "采购类型")
    private String purchaseType;
    @ApiModelProperty(value = "可见范围 0-全平台 1-供应商私库")
    private Integer purchaseRange;
    @ApiModelProperty(value = "是否允许调价 0-不允许,1-允许")
    private Integer isAdjust;
    @ApiModelProperty(value = "是否全权委托招标代理机构(0-不全权委托,1-全权委托)")
    private Integer isOtherAgency;
    @ApiModelProperty(value = "采购项目状态")
    private String purchaseProjectStatus;


}