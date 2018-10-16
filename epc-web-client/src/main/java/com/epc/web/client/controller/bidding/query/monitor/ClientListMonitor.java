package com.epc.web.client.controller.bidding.query.monitor;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 项目监控
 * @Author: linzhixiang
 * @Date: 2018/10/16
 */ 
@Data
@ApiModel("项目监控")
public class ClientListMonitor extends QueryRequest {
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("招标方式")
    private String purchaseMode ;
    @ApiModelProperty("采购状态（-1：全部。0：进行中，1：已结束）")
    private Integer isEnd;
}
