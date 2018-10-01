package com.epc.administration.facade.supplier.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 14:48
 * <p>@Author : luozhixin
 * <p>SupplierAttachmentVO
 */
@Data
public class SupplierAttachmentVO extends SupplierUserVO implements Serializable {
    private static final long serialVersionUID = 6160536347821498240L;

    @ApiModelProperty("附件集合")
    private List<AttachmentVO> attachmentVOList;
}
