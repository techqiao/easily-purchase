package com.epc.web.facade.terdering.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 15:46
 * <p>@Author : wjq
 */
@ApiModel(value = "ProjectBasicInfoVO",description = "项目基本属性类")
@Data
public class ProjectBasicInfoVO {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "采购人ID")
    private Long purchaserId;
    @ApiModelProperty(value = "采购人公司名称")
    private String companyName;
    @ApiModelProperty(value = "采购人姓名")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private Date createAt;
}
