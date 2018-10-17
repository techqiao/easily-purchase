package com.epc.mobile.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientHandleDeleteProjectPurchaser",description = "删除采购项目")
@Data
public class ClientHandleDeleteProjectPurchaser {


    @ApiModelProperty(value = "采购项目id")
    private Long projectPurchaserId;

    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;


}
