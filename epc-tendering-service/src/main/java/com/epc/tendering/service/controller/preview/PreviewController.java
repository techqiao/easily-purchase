package com.epc.tendering.service.controller.preview;

import com.epc.common.Result;
import com.epc.tendering.service.service.preview.BiddingPreviewService;
import com.epc.web.facade.terdering.preview.PreviewService;
import com.epc.web.facade.terdering.preview.dto.QueryPreviewDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:40
 * <p>@Author : luozhixin
 * <p>PreviewController
 */
public class PreviewController  implements PreviewService {

    @Autowired
    private BiddingPreviewService biddingPreviewService;

    @Override
    public Result<Boolean> insertPreview(@RequestBody PreviewHandle previewHandle) {
        return biddingPreviewService.insertPreview(previewHandle);
    }

    @Override
    public Result selectPreview(@RequestBody QueryPreviewDTO queryPreviewDTO) {
        return biddingPreviewService.selectPreview(queryPreviewDTO);
    }

    @Override
    public Result queryPreview(@RequestBody QueryWhere queryWhere) {
        return biddingPreviewService.queryPreview(queryWhere);
    }

    @Override
    public Result queryByDate(@RequestBody QueryPreviewDTO queryPreviewDTO,
                              @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        return biddingPreviewService.queryByDate(queryPreviewDTO, startDate, endDate);

    }
}
