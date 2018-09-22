package com.epc.web.client.controller.bidding.query.tender;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author linzhixiang
 */
@ApiModel(value = "标段列表查询",description = "标段列表查询")
@Data
public class ClientTenderList {
@ApiModelProperty(value = "采购项目Id")
    private Long purchasProgramId;

}
