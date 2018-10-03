package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientHandleEmployeeDto",description = "员工查询综合条件")
public class ClientHandleEmployeeDto implements Serializable{
    private static final long serialVersionUID = -2820637505337309345L;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "采购人id")
    private Long purchaseId;
    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    private String name;
    /**
     * 员工手机
     */
    @ApiModelProperty(value = "员工手机")
    private String cellphone;
    /**
     * 员工状态
     */
    @ApiModelProperty(value = "员工状态")
    private Integer state;
    /**
     * 员工权限
     */
    @ApiModelProperty(value = "员工权限")
    private Integer role;
    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id")
    private Long employeeId;
}
