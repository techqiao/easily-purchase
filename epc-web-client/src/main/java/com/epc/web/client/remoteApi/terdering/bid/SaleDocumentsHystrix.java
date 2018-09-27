package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeSaleDocumentsService;
import com.epc.web.facade.terdering.bid.handle.HandleDocuments;
import com.epc.web.facade.terdering.bid.vo.DocumentsVO;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 15:04
 * <p>@Author : wjq
 */
public class SaleDocumentsHystrix implements FacadeSaleDocumentsService {
    @Override
    public Result<Boolean> handleSaleDocuments(HandleDocuments handleDocuments) {
        return Result.hystrixError();
    }

    @Override
    public Result<DocumentsVO> getSaleDocuments(Long id) {
        return Result.hystrixError();
    }
}
