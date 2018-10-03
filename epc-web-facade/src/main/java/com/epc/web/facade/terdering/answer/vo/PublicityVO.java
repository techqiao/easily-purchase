package com.epc.web.facade.terdering.answer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-03 16:35
 * <p>@Author : wjq
 */
@ApiModel(value = "公示VO")
@Data
public class PublicityVO {
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "招标方式")
    private String purchaseMode;
    @ApiModelProperty(value = "采购项目编号")
    private String purchaseProjectCode;
    @ApiModelProperty(value = "采购人")
    private Long purchaserId;
    @ApiModelProperty(value = "采购人公司名称")
    private String companyName;
    @ApiModelProperty(value = "问题答案列表")
    private List<PublicitySubVO> answerProblemList;
}
