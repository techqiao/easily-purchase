package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:    供应商录入员工
 * @Author:          donghuan
 */

@ApiModel(value = "ClientHandlerSupplierAddEmployee", description = "供应商录入员工信息")
@Data
public class ClientHandlerSupplierAddEmployee{



    @ApiModelProperty(value = "员工角色")
    @NotEmpty(message = "ClientHandlerSupplierAddEmployee.role.null")
    private Integer role;

    @ApiModelProperty(value = "员工名字")
    @NotEmpty(message = "ClientHandlerSupplierAddEmployee.name.null")
    private String name;

    @ApiModelProperty(value = "员工电话")
    @NotEmpty(message = "ClientHandlerSupplierAddEmployee.cellphone.null")
    private String cellphone;

}
