package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : 查询文件列表返回
 * <p>Date : 2018-09-25 16:31
 * <p>@Author : luozhixin
 * <p>TPretrialFileVO
 */
@Data
public class TPretrialFileVO implements Serializable {


    private static final long serialVersionUID = 8708410627548431059L;
    /**
     * 标段id
     */
    @ApiModelProperty("标段id")
    private Long bidId;

    /**
     * 标段名称
     */
    @ApiModelProperty("标段名称")
    private String bidName;

    /**
     * 公司id
     */
    @ApiModelProperty("公司id")
    private Long companyId;
    /**
     * 供应商名称
     */
    @ApiModelProperty("供应商名称")
    private String companyName;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String filePath;

    /**
     * 文件名
     */
    @ApiModelProperty("文件名")
    private String fileName;

}
