package com.epc.web.facade.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商:附件信息
 */
@Data
public class SupplierAttachmentVO implements Serializable {

    private static final long serialVersionUID = 5238524428339987137L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 运营商法人ID
     */
    private Long supplierId;

    /**
     * 附件类型
     */
    private String certificateType;

    /**
     * 附件url
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

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

}
