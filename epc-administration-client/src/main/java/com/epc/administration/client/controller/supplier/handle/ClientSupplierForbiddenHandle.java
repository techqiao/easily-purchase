package com.epc.administration.client.controller.supplier.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 14:22
 * <p>@Author : luozhixin
 * <p>ClientSupplierForbiddenHandle
 */
@Data
public class ClientSupplierForbiddenHandle  implements Serializable {
    private static final long serialVersionUID = 3542988314699396329L;

    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("是否锁定 0 启用 1 锁定")
    private Integer isForbidden;
}
