package com.epc.web.facade.terdering.answer.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-04 10:13
 * <p>@Author : luozhixin
 * <p>WinBidVO
 */
@Data
public class WinBidVO implements Serializable {

    private static final long serialVersionUID = -5395280650726863595L;
    @ApiModelProperty("标段名称")
    private  String bidName;

    @ApiModelProperty("公示日期")
    private Date createAt;

    @ApiModelProperty("中标单位")
    private String supplierName;
}
