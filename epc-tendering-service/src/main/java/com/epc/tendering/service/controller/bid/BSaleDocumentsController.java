package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.SaleDocumentsService;
import com.epc.web.facade.terdering.bid.FacadeSaleDocumentsService;
import com.epc.web.facade.terdering.bid.handle.HandleDocuments;
import com.epc.web.facade.terdering.bid.vo.DocumentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : 发售招标文件
 * <p>Date : 2018-09-25 13:15
 * <p>@Author : wjq
 */
@RestController
public class BSaleDocumentsController implements FacadeSaleDocumentsService {

    @Autowired
    private SaleDocumentsService saleDocumentsService;

    @Override
    public Result<Boolean> handleSaleDocuments(@RequestBody HandleDocuments handleDocuments) {
        return saleDocumentsService.handleSaleDocuments(handleDocuments);
    }

    @Override
    public Result<DocumentsVO> getSaleDocuments(@RequestParam(value = "id") Long id) {
        return saleDocumentsService.getSaleDocuments(id);
    }
}
