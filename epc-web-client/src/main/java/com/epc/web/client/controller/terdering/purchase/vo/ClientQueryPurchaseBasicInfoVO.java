package com.epc.web.client.controller.terdering.purchase.vo;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 19:45
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientQueryPurchaseBasicInfoVO",description = "查询采购项目动态条件类")
@Data
public class ClientQueryPurchaseBasicInfoVO extends PagerParam {
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目编号")
    private String purchaseProjectCode;
    @ApiModelProperty(value = "开始时间")
    private Date purchaseStartTime;
    @ApiModelProperty(value = "结束时间")
    private Date purchaseEndTime;
    @ApiModelProperty(value = "采购项目状态")
    private String purchaseProjectStatus;
    @ApiModelProperty(value = "采购方式")
    private String purchaseMode;
    @ApiModelProperty(value = "采购分类")
    private String purchaseCategory;
    @ApiModelProperty(value = "采购类型")
    private String purchaseType;

}
