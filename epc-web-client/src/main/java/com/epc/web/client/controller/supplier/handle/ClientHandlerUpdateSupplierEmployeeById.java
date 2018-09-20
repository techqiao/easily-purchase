package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;


/**
 * 修改员工的一条信息
 * @author donghuan
 */

@ApiModel(value="ClientHandlerUpdateSupplierEmployeeById",description = "供应商修改员工信息")
@Data
public class ClientHandlerUpdateSupplierEmployeeById {


    @ApiModelProperty(value = "员工id")
    @NotEmpty(message = "ClientHandlerUpdateSupplierEmployeeById.id.null")
    private Long id;

    @ApiModelProperty(value = "员工名字")
    @NotEmpty(message = "ClientHandlerUpdateSupplierEmployeeById.id.null")
    private String name;

    @ApiModelProperty(value = "员工电话")
    @NotEmpty(message = "ClientHandlerUpdateSupplierEmployeeById.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "员工状态是否启用与禁用")
    @NotEmpty(message = "ClientHandlerUpdateSupplierEmployeeById.cellphone.null")
    private Integer isDeleted;

    //
    @ApiModelProperty(value = "最后更新的时间")
    private Date updateAt;


}
