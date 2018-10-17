package com.epc.mobile.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ClientHandleUpdateProjectAdmin",description = "修改项目")
public class ClientHandleUpdateProjectAdmin{



    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目经理
     */
    @ApiModelProperty(value = "项目经理")
    private String executiveName;

    @ApiModelProperty(value = "项目经理id")
    private Long executiveId;

    @ApiModelProperty(value = "备注")
    private String notes;



}
