package com.epc.web.facade.bidding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("线下详情")
public class OfflineDetailDTO implements Serializable {

    private static final long serialVersionUID = -4660476813322703350L;
    @ApiModelProperty("发售开始时间")
    private Date saleTimeStart;
    @ApiModelProperty("发售结束时间")
    private Date saleTimeEnd;
    @ApiModelProperty("发售地点")
    private String place;
    @ApiModelProperty("金额")
    private BigDecimal price;
    @ApiModelProperty("联系人")
    private String contactsName;
    @ApiModelProperty("联系电话")
    private String contactNumber;
}
