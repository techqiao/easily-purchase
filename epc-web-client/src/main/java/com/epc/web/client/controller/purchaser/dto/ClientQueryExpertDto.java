package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientQueryExpertDto",description = "专家查询条件")
public class ClientQueryExpertDto implements Serializable {
    private static final long serialVersionUID = 7333842895118543048L;
    /**
     *专家姓名
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
}
