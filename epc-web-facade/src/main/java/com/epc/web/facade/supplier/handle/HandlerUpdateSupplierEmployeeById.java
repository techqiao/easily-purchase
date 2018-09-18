package com.epc.web.facade.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value="HandlerUpdateSupplierEmployeeById",description = "供应商修改员工信息")
public class HandlerUpdateSupplierEmployeeById implements Serializable {
    /**
     * 修改员工的一条信息
     */

    @ApiModelProperty(value = "员工id")
    @NotEmpty(message = "HandlerUpdateSupplierEmployeeById.id.null")
    private Long id;

    @ApiModelProperty(value = "员工名字")
    @NotEmpty(message = "HandlerUpdateSupplierEmployeeById.id.null")
    private String name;

    @ApiModelProperty(value = "员工电话")
    @NotEmpty(message = "HandlerUpdateSupplierEmployeeById.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "员工状态是否启用与禁用")
    @NotEmpty(message = "HandlerUpdateSupplierEmployeeById.cellphone.null")
    private Integer isDeleted;

    // 最后更新的时间
    private Date updateAt;


}
