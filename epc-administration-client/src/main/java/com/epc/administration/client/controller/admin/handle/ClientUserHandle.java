package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:28
 * <p>@Author : luozhixin
 */
public class ClientUserHandle extends ClientUserLoginHandle implements Serializable {
    private static final long serialVersionUID = -7478233784938327985L;
    @ApiModelProperty(value = "用户姓名")
    @NotEmpty(message = "ClientUserHandle.name.null")
    private  String name;
    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientUserHandle.id.null")
    private  Long depetid;
    @ApiModelProperty(value = "是否展示")
    @NotEmpty(message = "ClientUserHandle.isDeleted.null")
    private int isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getDepetid() {
        return depetid;
    }

    public void setDepetid(Long depetid) {
        this.depetid = depetid;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ClientUserHandle{" +
                "name='" + name + '\'' +
                ", depetid=" + depetid +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
