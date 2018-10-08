package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: 下载文件支付查询
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */
@Data
@ApiModel(value = "ClientFilePay",description = "下载文件支付查询")
public class ClientFilePay {

    @ApiModelProperty(value = "采购项目Id")
    private Long procurementProjectId;
    @ApiModelProperty(value = "采购人id")
    private Long purchaserId;
    @ApiModelProperty(value = "下载机构ID")
    private Long companyId;
}
