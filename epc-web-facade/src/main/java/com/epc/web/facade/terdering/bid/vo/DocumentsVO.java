package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 14:15
 * <p>@Author : wjq
 */
@ApiModel(value = "招标文件详情")
@Data
public class DocumentsVO implements Serializable {
    private static final long serialVersionUID = -4330973702789468823L;
    @ApiModelProperty(value = "标段保证金集合")
    private List<BidsGuaranteeAmountVO> bidsGuaranteeAmountVOList;
    @ApiModelProperty(value = "招标文件")
    private SaleDocumentsVO saleDocumentsVO;
    @ApiModelProperty(value = "线下招标文件")
    private UnderLineVO underLineVO;

}
