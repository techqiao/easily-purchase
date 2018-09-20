package com.epc.web.facade.operator.vo;

import java.io.Serializable;

public class OperatorAttachmentVO implements Serializable {
    private static final long serialVersionUID = 6416073010409804648L;

    /**
     *  附件类型
     */
    private String certificateType;

    /**
     *  附件url
     */
    private String certificateFilePath;

    /**
     * 附件号码
     */
    private String certificateNumber;

    /**
     * 附件对应证书名称
     */
    private String certificateName;

}
