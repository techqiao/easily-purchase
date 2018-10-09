package com.epc.web.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientHandleDeleteProjectAdmin",description = "删除一个项目")
public class ClientHandleDeleteProjectAdmin{



    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;

}
