package com.epc.mobile.client.controller.terdering.bid.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientBidAnnouncement",description = "查询标段")
public class ClientBidAnnouncement implements Serializable {

    private static final long serialVersionUID = 4738209030466537879L;
    @ApiModelProperty(value = "标段Id")
    private Long bidId;
}
