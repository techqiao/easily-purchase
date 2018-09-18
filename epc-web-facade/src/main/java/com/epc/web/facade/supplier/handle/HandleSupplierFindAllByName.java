package com.epc.web.facade.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@ApiModel(value = "HandleSupplierFindAllByName",description = "模糊查询")
public class HandleSupplierFindAllByName implements Serializable {

    @ApiModelProperty(value = "供应商ID")
    @NotEmpty(message = "HandleSupplierFindAllByName.supplierId.null")
    private Long supplierId;

    @ApiModelProperty(value = "模糊名称")
    @NotEmpty(message = "HandleSupplierFindAllByName.where.null")
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
        return "HandleSupplierFindAllByName{" +
                "supplierId=" + supplierId +
                ", where='" + where + '\'' +
                '}';
    }
}
