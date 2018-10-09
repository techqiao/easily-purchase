package com.epc.web.client.controller.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleOperatorCreateSupplier",description = "运营商增加供应商")
@Data
public class ClientHandleOperatorCreateSupplier {

//    @ApiModelProperty(value = "运营商员工主键id")
//    @NotEmpty(message = "ClientHandleOperatorCreateSupplier.id.null")
//    private Long id;

    @ApiModelProperty(value = "供应商法人姓名")
    @NotEmpty(message = "ClientHandleOperatorCreateSupplier.name.null")
    private String name;

    @ApiModelProperty(value = "手机号(登录账号)")
    @NotEmpty(message = "ClientHandleOperatorCreateSupplier.cellphone.null")
    private String cellphone;

}
