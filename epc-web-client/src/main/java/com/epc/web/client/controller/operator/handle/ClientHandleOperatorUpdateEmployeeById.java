package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "ClientHandleOperatorUpdateEmployeeById",description = "运营商修改员工信息")
public class ClientHandleOperatorUpdateEmployeeById {

    @ApiModelProperty(value = "要修改员工的id")
    @NotEmpty(message = "ClientHandleOperatorUpdateEmployeeById.id.null")
    private Long id;

    @ApiModelProperty(value = "要修改员工的名字")
    @NotEmpty(message = "ClientHandleOperatorUpdateEmployeeById.name.null")
    private String name;

    @ApiModelProperty(value = "要修改员工的电话")
    @NotEmpty(message = "ClientHandleOperatorUpdateEmployeeById.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "要修改员工的状态")
    @NotEmpty(message = "ClientHandleOperatorUpdateEmployeeById.isDeleted.null")
    private  Integer isDeleted;


}
