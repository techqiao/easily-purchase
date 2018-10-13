package com.epc.web.client.controller.operator.query;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "ClientHandleOperatorFindAllByName",description = "运营商查询列表")
public class ClientHandleOperatorFindAllByName extends QueryRequest {

//    @ApiModelProperty(value = "员工id=运营商的（法人）id")
//    @NotEmpty(message = "ClientHandleOperatorFindAllByName.id.null")
//    private Long id;

    @ApiModelProperty(value = "输入查询的员工名字")
    @NotEmpty(message = "ClientHandleOperatorFindAllByName.name.null")
    private String name;

    @ApiModelProperty(value = "role 角色")
    @NotEmpty(message = "ClientHandleOperatorFindAllByName.role.null")
    private Integer role;

    @ApiModelProperty(value = "是否禁用")
    @NotEmpty(message = "ClientHandleOperatorFindAllByName.isForbidden.null")
    private Integer isForbidden;


}
