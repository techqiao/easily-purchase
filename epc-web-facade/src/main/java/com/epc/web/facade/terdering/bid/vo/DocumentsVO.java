package com.epc.web.facade.terdering.bid.vo;

import com.epc.web.facade.terdering.bid.handle.HandleSaleDocuments;
import com.epc.web.facade.terdering.bid.handle.HandleUnderLine;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 14:15
 * <p>@Author : wjq
 */
@Data
public class DocumentsVO {
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
