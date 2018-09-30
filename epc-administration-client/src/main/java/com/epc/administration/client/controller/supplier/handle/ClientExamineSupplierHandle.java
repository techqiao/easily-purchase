package com.epc.administration.client.controller.supplier.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 13:57
 * <p>@Author : luozhixin
 * <p>ClientExamineSupplierHandle
 */
@Data
public class ClientExamineSupplierHandle {

    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientExamineSupplierHandle.supplierId.null")
    private Long supplierId;

    @ApiModelProperty(value = "审核状态:3-审核通过,4-审核失败")
    @NotEmpty(message = "ClientExamineSupplierHandle.state.null")
    private int state;
}
