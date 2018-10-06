package com.epc.administration.facade.supplier.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 14:26
 * <p>@Author : luozhixin
 * <p>TWinBidVO
 */
@Data
public class TWinBidVO implements Serializable {
    private static final long serialVersionUID = 7008971987107323979L;

    @ApiModelProperty("中标项目")
    private String procurementProjectName;

    @ApiModelProperty("中标时间")
    private Date createAt;

    @ApiModelProperty("中标供应商名称")
    private  String supplierName;
}
