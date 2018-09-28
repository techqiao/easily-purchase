package com.epc.web.facade.terdering.preview;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.facade.terdering.preview.dto.QueryPreviewDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:17
 * <p>@Author : luozhixin
 * <p>PreviewService
 */
public interface PreviewService {

    /**
     * 发布预告
     * @param previewHandle
     * @return
     */
    @PostMapping("insertPreview")
    Result<Boolean> insertPreview(@RequestBody PreviewHandle previewHandle);

    /**
     * 查询预告列表
     * @param pagerParam
     * @return
     */
    @PostMapping("selectPreview")
    Result selectPreview(@RequestBody PagerParam pagerParam);

    /**
     * 详情
     * @param queryWhere
     * @return
     */
    @PostMapping("queryPreview")
    Result queryPreview(@RequestBody QueryWhere queryWhere);

    /**
     * 根据时间段查询
     * @param pagerParam
     * @param startDate
     * @param endDate
     * @return
     */
    @PostMapping("queryByDate")
    Result queryByDate(@RequestBody PagerParam pagerParam,
                       @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate);



}
