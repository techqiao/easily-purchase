package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleSupplieIsDeleted",description = "供应商服务")
@Data
public class ClientHandleSupplieIsDeleted {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientHandleSupplieIsDeleted.id.null")
    private Long id;

    @ApiModelProperty(value = "是否删除")
    @NotEmpty(message = "ClientHandleSupplieIsDeleted.isDeleted.null")
    private Integer isDeleted;

}
