package com.epc.web.client.controller.supplier.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "ClientHandleSupplierId",description = "供应商员工id")
public class ClientHandleSupplierId {

    @ApiModelProperty(value = "员工id")
    @NotEmpty(message = "ClientHandleSupplierId.id.null")
    private Long id;
}
