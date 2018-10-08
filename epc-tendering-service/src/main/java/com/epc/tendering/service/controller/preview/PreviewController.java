package com.epc.tendering.service.controller.preview;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.preview.BiddingPreviewService;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.terdering.preview.PreviewService;
import com.epc.web.facade.terdering.preview.dto.QueryPageDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:40
 * <p>@Author : luozhixin
 * <p>PreviewController
 */
@RestController
public class PreviewController extends BaseController implements PreviewService {

    @Autowired
    private BiddingPreviewService biddingPreviewService;

    @Override
    public Result<Boolean> insertPreview(@RequestBody PreviewHandle previewHandle) {
        return biddingPreviewService.insertPreview(previewHandle);
    }

    @Override
    public Result selectPreview(@RequestBody QueryPageDTO queryPageDTO) {
        PageHelper.startPage(queryPageDTO.getPage(),queryPageDTO.getRows());
        Result<List<ProjectBasicInfoVO>> projectList = biddingPreviewService.selectPreview(queryPageDTO);
        PageInfo<ProjectBasicInfoVO> pageInfo = new PageInfo<>(projectList.getData());
        return Result.success(getDataTable(pageInfo));
    }

    @Override
    public Result queryPreview(@RequestBody QueryWhere queryWhere) {
        return biddingPreviewService.queryPreview(queryWhere);
    }

    @Override
    public Result queryByDate(@RequestBody  PagerParam pagerParam,
                              @RequestParam("startDate") String startDate,
                              @RequestParam("endDate") String endDate) {
        return biddingPreviewService.queryByDate(pagerParam, startDate, endDate);

    }


}
