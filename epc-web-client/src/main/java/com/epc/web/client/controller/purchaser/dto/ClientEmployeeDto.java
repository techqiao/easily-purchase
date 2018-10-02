package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientEmployeeDto",description = "条件查询员工")
public class ClientEmployeeDto implements Serializable {
    private static final long serialVersionUID = -976558214613518834L;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "采购人机构id")
    @NotEmpty(message = "ClientEmployeeDto.purchaseId.null")
    private Long purchaseId;
    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    private String name;
}
