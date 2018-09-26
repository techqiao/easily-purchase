package com.epc.web.client.controller.bidding.handle.evaluation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 评审因素
 * <p>Description : easilys
 * <p>Date : 2018-09-25 14:49
 * <p>@Author : luozhixin
 * <p>ClientTechnologyHandle
 */
@Data
public class ClientTechnologyHandle {

    /**
     * 评审因素
     */
    @ApiModelProperty(value = "评审因素 办法名对应因素集合")
    @NotEmpty(message = "ClientTechnologyHandle.evaluationFactors.null")
    private String evaluationFactors;

    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    @NotEmpty(message = "ClientTechnologyHandle.explain.null")
    private String explain;

    /**
     * 分值开始范围
     */
    @ApiModelProperty(value = "分值开始范围")
    @NotEmpty(message = "ClientTechnologyHandle.dividingRangeStart.null")
    private String dividingRangeStart;

    /**
     * 分值结束范围
     */
    @ApiModelProperty(value = "分值结束范围")
    @NotEmpty(message = "ClientTechnologyHandle.dividingRangeEnd.null")
    private String dividingRangeEnd;
}
