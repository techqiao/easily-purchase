package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleSupplierIdAndIsForbidden",description = "是否禁用")
@Data
public class ClientHandleSupplierIdAndIsForbidden {

    @ApiModelProperty(value = "员工id")
    @NotEmpty(message = "ClientHandleSupplierIdAndIsForbidden.id.null")
    private Long id;


    @ApiModelProperty(value = "是否禁用")
    @NotEmpty(message = "ClientHandleSupplierIdAndIsForbidden.isForbidden.null")
    private Integer isForbidden;

}
