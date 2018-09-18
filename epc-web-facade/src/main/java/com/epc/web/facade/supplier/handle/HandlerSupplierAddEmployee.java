package com.epc.web.facade.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:    供应商录入员工
 * @Author:          donghuan
 * @CreateDate:     2018/9/13 11:00
 * @UpdateUser:     donghuan
 * @UpdateDate:     2018/9/13 11:00
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
@Data
@ApiModel(value = "HandlerSupplierAddEmployee", description = "供应商录入员工信息")
public class HandlerSupplierAddEmployee implements Serializable{

    @ApiModelProperty(value = "供应商的id")
    @NotEmpty(message = "HandlerSupplierAddEmployee.supplierId.null")
    private Long supplierId;

    @ApiModelProperty(value = "供应商的状态")
    @NotEmpty(message = "HandlerSupplierAddEmployee.state.null")
    private Integer state;

    @ApiModelProperty(value = "角色")
    @NotEmpty(message = "HandlerSupplierAddEmployee.role.null")
    private Integer role;

    @ApiModelProperty(value = "员工名字")
    @NotEmpty(message = "HandlerSupplierAddEmployee.name.null")
    private String name;

    @ApiModelProperty(value = "员工电话")
    @NotEmpty(message = "HandlerSupplierAddEmployee.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "员工密码")
    @NotEmpty(message = "HandlerSupplierAddEmployee.password.null")
    private String password;

    @ApiModelProperty(value = "是否存在")
    @NotEmpty(message = "HandlerSupplierAddEmployee.isDeleted.null")
    private Integer isDeleted;

    private Date createAt;

    private Date updateAt;



}
