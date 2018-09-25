package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 依据用户名，手机号来查询出这个人的详情
 */
@Data
@ApiModel(value = "ClientHandleSupplierNameAndCellphone",description = "依据用户名，手机号来查询出这个人的详情")
public class ClientHandleSupplierNameAndCellphone {


    @ApiModelProperty(value = "运营商的名字")
    @NotEmpty(message = "ClientHandleSupplierNameAndCellphone.name.null")
    private String name;

    @ApiModelProperty(value = "运营商的电话")
    @NotEmpty(message = "ClientHandleSupplierNameAndCellphone.cellphone.null")
    private String cellphone;

}
