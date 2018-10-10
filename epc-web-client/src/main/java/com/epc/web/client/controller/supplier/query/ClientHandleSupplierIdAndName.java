package com.epc.web.client.controller.supplier.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "ClientHandleSupplierIdAndName",description = "依据条件查询")
public class ClientHandleSupplierIdAndName {

//    @ApiModelProperty(value = "操作者的id")
//    @NotEmpty(message = "ClientHandleSupplierIdAndName.id.null")
//    private Long id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "角色")
    private Integer role;

    @ApiModelProperty(value = "是否禁用")
    private Integer isForbidden;

}
