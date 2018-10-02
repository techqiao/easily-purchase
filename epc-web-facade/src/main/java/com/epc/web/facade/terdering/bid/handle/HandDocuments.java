package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 14:15
 * <p>@Author : wjq
 */
@Data
public class HandDocuments {
    /**
     * 标段保证金集合
     */
    private List<HandleBidsGuaranteeAmount> handleBidsGuaranteeAmount;
    /**
     * 招标文件
     */
    private HandleSaleDocuments handleSaleDocuments;
    /**
     * 线下招标文件
     */
    private HandleUnderLine handleUnderLine;

}
