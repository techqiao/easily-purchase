package com.epc.web.client.remoteApi.terdering.preview;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.facade.terdering.preview.PreviewService;
import com.epc.web.facade.terdering.preview.dto.QueryPageDTO;
import com.epc.web.facade.terdering.preview.dto.QueryPreviewDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:27
 * <p>@Author : luozhixin
 * <p>previewHystrix
 */
public class previewHystrix  implements PreviewService {

    @Override
    public Result<Boolean> insertPreview(PreviewHandle previewHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result selectPreview(QueryPageDTO queryPageDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result queryPreview(QueryWhere queryWhere) {
        return Result.hystrixError();
    }

    @Override
    public Result queryByDate(PagerParam pagerParam, String startDate, String endDate) {
        return Result.hystrixError();
    }
}
