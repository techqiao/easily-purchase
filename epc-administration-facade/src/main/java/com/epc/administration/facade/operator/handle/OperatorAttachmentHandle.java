package com.epc.administration.facade.operator.handle;


import lombok.Data;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 14:50
 * <p>@Author : luozhixin
 * <p>OperatorAttachmentHandle
 */
@Data
public class OperatorAttachmentHandle {

    /**
     * 附件url
     */
    private String certificateFilePath;

    /**
     * 附件对应证书名称
     */
    private String certificateName;
}
