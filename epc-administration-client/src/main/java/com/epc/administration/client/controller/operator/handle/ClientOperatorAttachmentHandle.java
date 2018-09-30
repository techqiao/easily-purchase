package com.epc.administration.client.controller.operator.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 14:46
 * <p>@Author : luozhixin
 * <p>ClientOperatorAttachmentHandle
 */
@Data
public class ClientOperatorAttachmentHandle implements Serializable {
    private static final long serialVersionUID = -8661463274385325605L;
    /**
     * 附件url
     */
    @ApiModelProperty(value = "附件url")
    @NotEmpty(message = "ClientOperatorAttachmentHandle.certificateFilePath.null")
    private String certificateFilePath;

    /**
     * 附件对应证书名称
     */
    @ApiModelProperty(value = "附件对应证书名称")
    @NotEmpty(message = "ClientOperatorAttachmentHandle.certificateName.null")
    private String certificateName;
}
