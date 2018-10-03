package com.epc.administration.facade.reviewexpert.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 16:31
 * <p>@Author : luozhixin
 * <p>AttachmentVO
 */
@Data
public class AttachmentVO implements Serializable {
    private static final long serialVersionUID = 7636759622965525925L;
    @ApiModelProperty("附件url")
    private String certificateFilePath;
    @ApiModelProperty("附件对应证书名称")
    private String certificateName;

}
