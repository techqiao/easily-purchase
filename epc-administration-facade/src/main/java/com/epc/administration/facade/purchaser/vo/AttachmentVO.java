package com.epc.administration.facade.purchaser.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-03 21:46
 * <p>@Author : luozhixin
 * <p>AttachmentVO
 */
@Data
public class AttachmentVO implements Serializable {

    private static final long serialVersionUID = -617369923243230756L;
    @ApiModelProperty("附件url")
    private String certificateFilePath;
    @ApiModelProperty("附件对应证书名称")
    private String certificateName;
}
