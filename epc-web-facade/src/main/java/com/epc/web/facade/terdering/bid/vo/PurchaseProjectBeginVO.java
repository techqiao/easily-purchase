package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-30 14:37
 * <p>@Author : wjq
 */
@ApiModel(value = "发布招标详情")
@Data
public class PurchaseProjectBeginVO {
    @ApiModelProperty(value = "发包方式 open公开 invite邀请")
    private String packetMode;
    @ApiModelProperty(value = "是否资格预审 0否 1是")
    private Integer isPrequalification;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目编码")
    private String purchaseProjectCode;
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "采购地点")
    private String purchasePlace;
}
