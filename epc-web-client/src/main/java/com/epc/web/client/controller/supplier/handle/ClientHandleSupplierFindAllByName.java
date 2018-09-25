package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@ApiModel(value = "ClientHandleSupplierFindAllByName",description = "模糊查询")
@Data
public class ClientHandleSupplierFindAllByName  {

    @ApiModelProperty(value = "供应商ID")
    @NotEmpty(message = "ClientHandleSupplierFindAllByName.supplierId.null")
    private Long supplierId;

    @ApiModelProperty(value = "模糊名称")
    @NotEmpty(message = "ClientHandleSupplierFindAllByName.name.null")
    private String name;


}
