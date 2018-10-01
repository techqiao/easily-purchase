package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel
public class ClientHandleOperatorIdAndIsForbidden {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientHandleOperatorIdAndIsForbidden.id.null")
    private Long id;

    @ApiModelProperty(value = "是否禁用")
    @NotEmpty(message = "ClientHandleOperatorIdAndIsForbidden.isForbidden.null")
    private Integer isForbidden;

}
