package com.epc.web.client.controller.terdering.purchase.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 17:45
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientHandlePurchaseProjectBasicInfo",description = "处理采购项目相关参数")
@Data
public class ClientHandlePurchaseProjectBasicInfo {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目编号")
    private String purchaseProjectCode;
    @ApiModelProperty(value = "采购项目ID")
    @NotEmpty(message = "ClientHandlePurchaseProjectBasicInfo.purchaseProjectId.null")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "是否国家指定必须招标项目")
    private String isStateDesignation;
    @ApiModelProperty(value = "采购项目开始时间")
    private Date purchaseStartTime;
    @ApiModelProperty(value = "采购项目结束时间")
    private Date purchaseEndTime;
    @ApiModelProperty(value = "采购项目预算金额")
    private BigDecimal purchaseProjectBudgetaryAmount;
    @ApiModelProperty(value = "采购方式")
    private Integer purchaseMode;
    @ApiModelProperty(value = "采购分类")
    private Integer purchaseCategory;
    @ApiModelProperty(value = "采购类型")
    private String purchaseType;
    @ApiModelProperty(value = "可见范围")
    private Integer purchaseRange;
    @ApiModelProperty(value = "是否允许调价")
    private Integer isAdjust;
    @ApiModelProperty(value = "是否全权委托招标代理机构")
    private Integer isOtherAgency;
    @ApiModelProperty(value = "招标代理机构ID")
    private Long purchaserAgencyId;
    @ApiModelProperty(value = "经办人ID")
    private Long agentId;
    @ApiModelProperty(value = "审核人ID")
    private Long auditorId;
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;
}
