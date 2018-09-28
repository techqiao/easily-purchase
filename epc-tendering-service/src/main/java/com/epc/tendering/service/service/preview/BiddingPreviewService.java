package com.epc.tendering.service.service.preview;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.facade.terdering.preview.dto.QueryPreviewDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:44
 * <p>@Author : luozhixin
 * <p>BiddingPreviewService
 */
public interface BiddingPreviewService {

    /**
     * 发布预告
     * @param previewHandle
     * @return
     */
    Result<Boolean> insertPreview(PreviewHandle previewHandle);

    /**
     * 查询所有分页展示
     * @param pagerParam
     * @return
     */
    Result selectPreview(PagerParam pagerParam);

    /**
     * 详情
     * @param queryWhere
     * @return
     */
    Result queryPreview(QueryWhere queryWhere);


    /**
     * 根据时间段查询
     * @param startDate
     * @param endDate
     * @return
     */
    Result queryByDate(PagerParam pagerParam, String startDate, String endDate);
}
