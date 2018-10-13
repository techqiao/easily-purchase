package com.epc.web.client.controller.expert.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientProjectDto",description = "查询专家评审项目信息")
public class ClientProjectDto implements Serializable {
    private static final long serialVersionUID = 8418306294025266413L;
    @ApiModelProperty(value = "专家id")
    @NotEmpty(message = "ClientProjectDto.expertId.null")
    private  Long expertId;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "采购人名称")
    private  String purchaserName;
    /**
     * 0 进行中,1 已结束 -1 未开始
     */
    @ApiModelProperty(value = "进行状态 -1：未开始，0：进行中，1：已结束")
    private Integer isEnd;

}
