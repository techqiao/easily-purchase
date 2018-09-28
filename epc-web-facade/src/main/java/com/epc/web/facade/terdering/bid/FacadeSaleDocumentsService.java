package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleDocuments;
import com.epc.web.facade.terdering.bid.vo.DocumentsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>Description : 招标文件相关接口
 * <p>Date : 2018-09-25 13:18
 * <p>@Author : wjq
 */
public interface FacadeSaleDocumentsService {

    /**
     * 发布|审核|批复|修改|删除 招标文件
     * @param handleDocuments
     * @return
     */
    @PostMapping(value = "handleSaleDocuments", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleSaleDocuments(@RequestBody HandleDocuments handleDocuments);

    /**
     * 查询招标文件详情
     * @param id
     * @return
     */
    @GetMapping(value = "getSaleDocuments", consumes = "application/json; charset=UTF-8")
    Result<DocumentsVO> getSaleDocuments(@RequestParam(value = "id") Long id);
}
