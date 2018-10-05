package com.epc.administration.facade.reviewexpert.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 21:55
 * <p>@Author : luozhixin
 * <p>AttachmentHandle
 */
@Data
public class AttachmentHandle implements Serializable {
    private static final long serialVersionUID = 7822140666222225270L;
    /**
     * 附件url
     */
    private String certificateFilePath;

    /**
     * 附件对应证书名称
     */
    private String certificateName;
}
