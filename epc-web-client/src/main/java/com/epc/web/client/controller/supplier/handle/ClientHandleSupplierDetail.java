package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


/**
 * 供应商注册详情
 */

@Data
@ApiModel(value = "ClientHandleSupplierDetail", description = "供应商信息")
public class ClientHandleSupplierDetail {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientHandleSupplierDetail.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "ClientHandleSupplierDetail.password.null")
    private String password;


}
