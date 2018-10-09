package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:31
 * <p>@Author : luozhixin
 */
@Data
public class ClientUpdateBankAccountHandle extends ClientInsertBankAccountHandle implements Serializable {
    private static final long serialVersionUID = -3019565139741775161L;

    @ApiModelProperty(value = "主键id")
    @NotEmpty(message = "ClientInsertBankAccountHandle.id.null")
    private String id;

}
