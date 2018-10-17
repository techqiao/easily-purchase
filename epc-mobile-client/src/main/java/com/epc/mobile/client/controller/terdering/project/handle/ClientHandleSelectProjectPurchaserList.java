package com.epc.mobile.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientHandleSelectProjectPurchaserList",description = "获取 自己创建的采购项目 列表")
@Data
public class ClientHandleSelectProjectPurchaserList{



    //项目名字
//    private String projectName;
    //项目id;
    @ApiModelProperty(value = "项目id")
    private Long projectId;




}
