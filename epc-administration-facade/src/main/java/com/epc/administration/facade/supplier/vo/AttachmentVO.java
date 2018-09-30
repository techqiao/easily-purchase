package com.epc.administration.facade.supplier.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 14:49
 * <p>@Author : luozhixin
 * <p>AttachmentVO
 */
@Data
public class AttachmentVO implements Serializable {
    private static final long serialVersionUID = 7572788719865223489L;


    /**
     * 附件url
     */
    private String certificateFilePath;


    /**
     * 附件对应证书名称
     */
    private String certificateName;

    /**
     * 附件类型
     */
    private  String certificateType;
}
