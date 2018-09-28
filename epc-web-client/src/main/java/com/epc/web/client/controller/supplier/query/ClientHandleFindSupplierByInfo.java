package com.epc.web.client.controller.supplier.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@ApiModel(value = "ClientHandleFindSupplierByInfo",description = "依据传回来的值做各种的查询")
@Data
public class ClientHandleFindSupplierByInfo{

    @ApiModelProperty(value = "根据电话来查询一条记录")
    private String cellphone;

    @ApiModelProperty(value = "根据id来查询一条记录")
    @NotEmpty(message = "ClientHandleFindSupplierByInfo.id.null")
    private Long id;

    @ApiModelProperty(value = "根据姓名查询")
    private String name;

    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;

    @ApiModelProperty(value = "依据role来查找")
    private Integer role;

    @ApiModelProperty(value = "是否禁用")
    @NotEmpty(message = "ClientHandleFindSupplierByInfo.isDeleted.null")
    private Integer isDeleted;

}
