package com.epc.mobile.client.controller.terdering.project.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientHandleProjectPurchaserByProjectId",description = "")
@Data
public class ClientHandleProjectPurchaserByProjectId {

    @ApiModelProperty(value = "当前登陆人的id")
    private Long id;

    @ApiModelProperty(value = "项目的id")
    private Long projectId;

}
