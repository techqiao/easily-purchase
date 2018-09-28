package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleOperatorId",description = "依据用户id来查询用户基本信息")
@Data
public class ClientHandleOperatorId {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientHandleOperatorId.id.null")
    private Long id;

    @ApiModelProperty(value = "是否删除")
    @NotEmpty(message = "ClientHandleOperatorId.isDeleted.null")
    private Integer isDeleted;
}
