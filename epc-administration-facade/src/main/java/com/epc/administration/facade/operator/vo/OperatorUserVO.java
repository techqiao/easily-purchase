package com.epc.administration.facade.operator.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 16:03
 * <p>@Author : luozhixin
 * <p>OperatorUserVO
 */
@Data
public class OperatorUserVO extends OperatorVO implements Serializable {
    private static final long serialVersionUID = 1530035683560531160L;

    @ApiModelProperty("附件集合")
    private List<OperatorAttachmentVO> operatorAttachmentVOList;

}
