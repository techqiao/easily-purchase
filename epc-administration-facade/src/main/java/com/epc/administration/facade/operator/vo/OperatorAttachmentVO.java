package com.epc.administration.facade.operator.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 16:03
 * <p>@Author : luozhixin
 * <p>OperatorAttachmentVO
 */
@Data
public class OperatorAttachmentVO implements Serializable {

    private static final long serialVersionUID = -4223250831521125195L;
    /**
     * 附件url
     */
    @ApiModelProperty("附件url")
    private String certificateFilePath;


    /**
     * 附件对应证书名称
     */
    @ApiModelProperty("附件对应证书名称")
    private String certificateName;

    /**
     * 附件类型
     */
    @ApiModelProperty("附件类型")
    private  String certificateType;
}
