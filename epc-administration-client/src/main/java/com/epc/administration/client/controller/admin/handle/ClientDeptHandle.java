package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:38
 * <p>@Author : luozhixin
 */
@Data
public class ClientDeptHandle implements Serializable {

    private static final long serialVersionUID = 416827050851258480L;
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "ClientDeptHandle.deptName.null")
    private String deptName;
    @ApiModelProperty(value = "父级ID")
    @NotEmpty(message = "ClientDeptHandle.parentId.null")
    private Long parentId;


}
