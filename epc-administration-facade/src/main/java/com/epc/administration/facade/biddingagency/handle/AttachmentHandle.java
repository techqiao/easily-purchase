package com.epc.administration.facade.biddingagency.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 16:58
 * <p>@Author : luozhixin
 * <p>AttachmentHandle
 */
@Data
public class AttachmentHandle implements Serializable {

    private static final long serialVersionUID = -7901278499861901154L;
    /**
     * 附件url
     */
    private String certificateFilePath;


    /**
     * 附件对应证书名称
     */
    private String certificateName;
}
