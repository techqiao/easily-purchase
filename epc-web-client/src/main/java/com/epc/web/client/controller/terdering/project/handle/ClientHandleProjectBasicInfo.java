package com.epc.web.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 13:53
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientHandleProjectBasicInfo",description = "处理项目相关参数")
@Data
public class ClientHandleProjectBasicInfo {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "项目描述")
    private String projectDescription;
    @ApiModelProperty(value = "项目总投资")
    private String totalProjectInvestment;
    @ApiModelProperty(value = "投资来源 0：国有投资 1：私有投资 2：国有占主体投资")
    private Integer sourceOfInvestment;
    @ApiModelProperty(value = "项目地址")
    private String projectAddress;
    @ApiModelProperty(value = "项目备注")
    private String projectMemo;
}
