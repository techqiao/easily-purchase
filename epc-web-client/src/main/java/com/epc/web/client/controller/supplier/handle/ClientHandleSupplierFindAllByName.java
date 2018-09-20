package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@ApiModel(value = "ClientHandleSupplierFindAllByName",description = "模糊查询")
public class ClientHandleSupplierFindAllByName  {

    @ApiModelProperty(value = "供应商ID")
    @NotEmpty(message = "ClientHandleSupplierFindAllByName.supplierId.null")
    private Long supplierId;

    @ApiModelProperty(value = "模糊名称")
    @NotEmpty(message = "ClientHandleSupplierFindAllByName.where.null")
    private String where;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "ClientHandleSupplierFindAllByName{" +
                "supplierId=" + supplierId +
                ", where='" + where + '\'' +
                '}';
    }
}
