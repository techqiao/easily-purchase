package com.epc.administration.client.controller.reviewexpert.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 21:52
 * <p>@Author : luozhixin
 * <p>ClientAttachmentHandle
 */
@Data
public class ClientAttachmentHandle implements Serializable {
    private static final long serialVersionUID = -2114301155655302964L;
    /**
     * 附件url
     */
    @ApiModelProperty(value = "附件url")
    @NotEmpty(message = "ClientAttachmentHandle.certificateFilePath.null")
    private String certificateFilePath;

    /**
     * 附件对应证书名称
     */
    @ApiModelProperty(value = "附件对应证书名称")
    @NotEmpty(message = "ClientAttachmentHandle.certificateName.null")
    private String certificateName;

}
