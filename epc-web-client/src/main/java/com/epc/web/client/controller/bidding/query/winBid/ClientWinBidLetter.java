package com.epc.web.client.controller.bidding.query.winBid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
* @Description:  获取中标通知书
* @Author: linzhixiang
* @Date: 2018/9/22
*/
@ApiModel(value = "获取中标通知书",description = "获取中标通知书")
@Data
public class ClientWinBidLetter {

    @ApiModelProperty(value = "采购项目Id")
    private Long procurementProjectId;

}
