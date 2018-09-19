package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:12
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientHandleBidsBasicInfo",description = "处理采购项目标段相关参数")
@Data
public class ClientHandleBidsBasicInfo {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "采购方式")
    private String purchaseMode;
    @ApiModelProperty(value = "标段编号")
    private String bidCode;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
    @ApiModelProperty(value = "预算金额")
    private BigDecimal bidBudgetaryAmount;
    @ApiModelProperty(value = "保证金金额")
    private BigDecimal guaranteePayment;
    @ApiModelProperty(value = "标段文件路径")
    private String bidFilePath;
    @ApiModelProperty(value = "标段说明")
    private String bidMemo;
}
