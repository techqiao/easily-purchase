package com.epc.mobile.client.controller.terdering.preview.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-23 10:21
 * <p>@Author : luozhixin
 * <p>ClientQueryPageDTO
 */
@Data
@ApiModel(value = "ClientQueryPageDTO",description = "查询预告列表")
public class ClientQueryPageDTO implements Serializable {

    @ApiModelProperty(value = "当前页")
    private Integer page;
    @ApiModelProperty(value = "限制返回记录数")
    private Integer rows;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
}
