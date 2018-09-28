package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "ClientHandleOperatorFindAllByName",description = "")
public class ClientHandleOperatorFindAllByName {

    @ApiModelProperty(value = "员工id=运营商的（法人）id")
    @NotEmpty(message = "ClientHandleOperatorFindAllByName.id.null")
    private Long id;

    @ApiModelProperty(value = "输入查询的员工名字")
    private String name;


}
