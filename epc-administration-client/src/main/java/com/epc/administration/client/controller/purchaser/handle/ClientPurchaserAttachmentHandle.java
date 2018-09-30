package com.epc.administration.client.controller.purchaser.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 13:53
 * <p>@Author : luozhixin
 * <p>ClientPurchaserAttachmentHandle
 */
@Data
public class ClientPurchaserAttachmentHandle implements Serializable {

    private static final long serialVersionUID = 8465372554066015500L;
    /**
     * 附件url
     */
    @ApiModelProperty(value = "附件url")
    @NotEmpty(message = "ClientPurchaserAttachmentHandle.certificateFilePath.null")
    private String certificateFilePath;

    /**
     * 附件对应证书名称
     */
    @ApiModelProperty(value = "附件对应证书名称")
    @NotEmpty(message = "ClientPurchaserAttachmentHandle.certificateName.null")
    private String certificateName;
}
