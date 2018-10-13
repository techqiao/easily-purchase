package com.epc.web.client.controller.supplier.query;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("参与项目列表")
public class ClientSupplierProject extends QueryRequest{
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("投标状态")
    private String status;

}
