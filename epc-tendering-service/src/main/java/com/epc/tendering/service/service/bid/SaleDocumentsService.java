package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleDocuments;
import com.epc.web.facade.terdering.bid.vo.DocumentsVO;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 13:16
 * <p>@Author : wjq
 */
public interface SaleDocumentsService {

    /**
     * 处理招标文件
     * @param handleDocuments
     * @return
     */
    Result<Boolean> handleSaleDocuments(HandleDocuments handleDocuments);

    /**
     * 查询招标文件详情
     *
     * @param id
     * @return
     */
    Result<DocumentsVO> getSaleDocuments(Long id);
}
