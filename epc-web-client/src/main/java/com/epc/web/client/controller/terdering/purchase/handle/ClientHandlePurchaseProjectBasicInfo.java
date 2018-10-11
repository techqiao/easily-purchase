package com.epc.web.client.controller.terdering.purchase.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    @ApiModelProperty(value = "项目ID")
    @NotEmpty(message = "ClientHandlePurchaseProjectBasicInfo.purchaseProjectId.null")
    private Long projectId;
    @ApiModelProperty(value = "是否国家指定必须招标项目 是否国家指定必须招标:0是，1不是")
    private Integer isStateDesignation;
    @ApiModelProperty(value = "采购项目开始时间")
    private Date purchaseStartTime;
    @ApiModelProperty(value = "采购项目结束时间")
    private Date purchaseEndTime;
    @ApiModelProperty(value = "采购项目预算金额")
    private BigDecimal purchaseProjectBudgetaryAmount;
    @ApiModelProperty(value = "采购方式 招标采购:selective_tendering 询比采购:  竞价采购: 谈判采购: 直接采购: 框架协议采购")
    private String purchaseMode;
    @ApiModelProperty(value = "采购分类 劳务分包labor_subcontract 专业分包professional_subcontracting 设备租赁 货物采购 服务采购 工程采购")
    private String purchaseCategory;
    @ApiModelProperty(value = "采购类型")
    private String purchaseType;
    @ApiModelProperty(value = "可见范围 0:全平台 1:指定")
    private Integer purchaseRange;
    @ApiModelProperty(value = "当为指定时  供应商id集合")
    private List<Long> supplierIds;
    @ApiModelProperty(value = "是否允许调价 0:不允许 1:允许")
    private Integer isAdjust;
    @ApiModelProperty(value = "是否全权委托招标代理机构  0:不全权委托 1:全权委托")
    private Integer isOtherAgency;
    @ApiModelProperty(value = "招标代理机构ID 全权委托招标代理机构情况下 选择招标代理机构")
    private Long purchaserAgencyId;
    @ApiModelProperty(value = "经办人ID")
    private Long agentId;
    @ApiModelProperty(value = "审核人ID")
    private Long auditorId;
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;
}
