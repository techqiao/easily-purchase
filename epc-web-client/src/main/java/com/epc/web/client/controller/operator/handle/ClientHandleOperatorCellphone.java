package com.epc.web.client.controller.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleOperatorCellphone",description = "运营商的电话")
@Data
public class ClientHandleOperatorCellphone {

    @ApiModelProperty(value = "运营商员工电话")
    @NotEmpty(message = "ClientHandleOperatorCellphone.cellphone.null")
    private String cellphone;

}


