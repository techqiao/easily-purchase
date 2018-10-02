package com.epc.web.client.controller.agency.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientQueryExpertDto",description = "专家查询综合调")
public class ClientExpertDto implements Serializable {
    private static final long serialVersionUID = 4403603529058984547L;
    /**
     * 专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    private String expertName;
    /**
     * 庄家专业
     */
    @ApiModelProperty(value = "专家专业")
    private String profession;
    /**
     * 庄家职称
     */
    @ApiModelProperty(value = "专家职称")
    private String  positional;

    /**
     * 专家水平
     */
    @ApiModelProperty(value = "专家水平")
    private String level;
    /**
     * 工作年限
     */
    @ApiModelProperty(value = "工作年限")
    private Integer workingYears;
}
