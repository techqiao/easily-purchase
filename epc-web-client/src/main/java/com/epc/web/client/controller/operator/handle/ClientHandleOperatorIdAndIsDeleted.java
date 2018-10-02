package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel
@Data
public class ClientHandleOperatorIdAndIsDeleted {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientHandleOperatorId.id.null")
    private Long id;
}
