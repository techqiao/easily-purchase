package com.epc.web.client.controller.bidding.handle.evaluation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-26 22:04
 * <p>@Author : luozhixin
 * <p>ClientStandardTypeHandle
 */
@Data
public class ClientStandardTypeHandle {

    /**
     * 方法类型
     */
    @ApiModelProperty(value = "方法类型")
    private String standardType;
    /**
     * '评标方法描述'
     */
    @ApiModelProperty(value = "评标方法描述")
    private String memo;

    /**
     * 评标方法文件url
     */
    @ApiModelProperty(value = "评标方法文件url")
    private String filePath;

    /**
     * 技术评标总分数
     */
    @ApiModelProperty(value = "技术评标总分数")
    private Integer techTypeScore;

}
