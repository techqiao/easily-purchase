package com.epc.administration.facade.biddingagency.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 09:30
 * <p>@Author : luozhixin
 * <p>AgencyAttachmentVO
 */
@Data
public class AgencyAttachmentVO implements Serializable {

    private static final long serialVersionUID = 3403863468089031916L;
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
