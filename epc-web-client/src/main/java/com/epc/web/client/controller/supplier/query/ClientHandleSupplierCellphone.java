package com.epc.web.client.controller.supplier.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleSupplierCellphone",description =  "依据电话来查询一条记录")
@Data
public class ClientHandleSupplierCellphone {

    @ApiModelProperty(value = "合法电话")
    @NotEmpty(message = "ClientHandleSupplierCellphone.cellphone.null")
    private String cellphone;

}
