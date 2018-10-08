package com.epc.web.facade.terdering.project.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 15:24
 * <p>@Author : wjq
 */
@ApiModel(value = "ProjectDetailInfoVO",description = "项目详情类")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDetailInfoVO extends ProjectBasicInfoVO implements Serializable {
    private static final long serialVersionUID = -8761487064785499329L;
    @ApiModelProperty(value = "项目描述")
    private String projectDescription;
    @ApiModelProperty(value = "是否国家指定必须招标项目")
    private String isStateDesignation;
    @ApiModelProperty(value = "项目总投资")
    private String totalProjectInvestment;
    @ApiModelProperty(value = "投资来源")
    private String sourceOfInvestment;
    @ApiModelProperty(value = "项目地址")
    private String projectAddress;
    @ApiModelProperty(value = "项目备注")
    private String projectMemo;
}
