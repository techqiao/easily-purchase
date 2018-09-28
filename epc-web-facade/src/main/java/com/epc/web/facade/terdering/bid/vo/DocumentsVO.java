package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 14:15
 * <p>@Author : wjq
 */
@Data
public class DocumentsVO implements Serializable {
    private static final long serialVersionUID = -4330973702789468823L;
    /**
     * 标段保证金集合
     */
    private List<BidsGuaranteeAmountVO> bidsGuaranteeAmountVOList;
    /**
     * 招标文件
     */
    private SaleDocumentsVO saleDocumentsVO;
    /**
     * 线下招标文件
     */
    private UnderLineVO underLineVO;

}
