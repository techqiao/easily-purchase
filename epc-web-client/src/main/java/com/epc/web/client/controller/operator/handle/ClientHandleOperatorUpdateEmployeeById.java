package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
@ApiModel(value = "ClientHandleOperatorUpdateEmployeeById",description = "依据员工id来修改员工信息")
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

    @ApiModelProperty(value = "修改自己的密码")
    private String password;

    @ApiModelProperty(value = "更新修改的时间")
    @NotEmpty(message = "ClientHandleOperatorUpdateEmployeeById.updateAt.null")
    private Date updateAt;


}
