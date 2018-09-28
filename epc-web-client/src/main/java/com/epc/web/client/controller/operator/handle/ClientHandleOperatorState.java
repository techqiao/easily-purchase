package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleOperatorState",description = "运营商中各个状态state的状态")
@Data
public class ClientHandleOperatorState {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientHandleOperatorState.id.null")
    private Long id;

    @ApiModelProperty(value = "当前状态")
    @NotEmpty(message = "ClientHandleOperatorState.state.null")
    private Integer state;



}