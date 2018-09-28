package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleSupplierRecordByCellphone",description =  "依据电话来查询一条记录")
@Data
public class ClientHandleSupplierRecordByCellphone {

    @ApiModelProperty(value = "合法电话")
    @NotEmpty(message = "ClientHandleSupplierRecordByCellphone.cellphone.null")
    private String cellphone;

}
