package com.epc.administration.facade.supplier.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 17:01
 * <p>@Author : luozhixin
 * <p>AttachmentHandle
 */
@Data
public class AttachmentHandle implements Serializable {

    private static final long serialVersionUID = -2828926246719513054L;
    /**
     * 附件url
     */
    private String certificateFilePath;


    /**
     * 附件对应证书名称
     */
    private String certificateName;
}
