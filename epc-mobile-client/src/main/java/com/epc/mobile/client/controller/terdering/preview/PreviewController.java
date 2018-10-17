package com.epc.mobile.client.controller.terdering.preview;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.mobile.client.controller.common.BaseController;
import com.epc.mobile.client.controller.terdering.preview.handle.ClientPreviewHandle;
import com.epc.mobile.client.controller.terdering.preview.query.ClientQueryPageDTO;
import com.epc.mobile.client.controller.terdering.preview.query.ClientQueryPreviewOneDTO;
import com.epc.mobile.client.remoteApi.terdering.preview.PreviewClient;
import com.epc.web.facade.terdering.preview.dto.QueryPageDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 15:56
 * <p>@Author : luozhixin
 * <p>PreviewController
 */
@Api(value = "发布预告", tags = {"发布预告"})
@RestController
@RequestMapping(value = "/preview", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PreviewController extends BaseController {

    @Autowired
    private PreviewClient previewClient;

    /**
     * 发布预告
     *
     * @param clientPreviewHandle
     * @return
     */
    @ApiOperation("发布预告")
    @PostMapping(value = "insertPreview", consumes = "application/json;charset=UTF-8")
    public Result insertPreview(@RequestBody ClientPreviewHandle clientPreviewHandle) {
        PreviewHandle previewHandle = new PreviewHandle();
        BeanUtils.copyProperties(clientPreviewHandle, previewHandle);
        previewHandle.setCreator(getLoginUser().getName());
        previewHandle.setSetOperateId(getLoginUser().getUserId());
        previewHandle.setPurchaserId(getLoginUser().getUserId());
        return previewClient.insertPreview(previewHandle);
    }

    /**
     * 查询预告列表
     *
     * @param clientQueryPageDTO
     * @return
     */
    @ApiOperation("查询预告列表")
    @PostMapping(value = "selectPreview", consumes = "application/json;charset=UTF-8")
    public Result selectPreview(@RequestBody ClientQueryPageDTO clientQueryPageDTO) {
        QueryPageDTO QueryPageDTO = new QueryPageDTO();
        BeanUtils.copyProperties(clientQueryPageDTO, QueryPageDTO);
        return previewClient.selectPreview(QueryPageDTO);
    }

    /**
     * 详情
     *
     * @param clientQueryPreviewOneDTO
     * @return
     */
    @ApiOperation("详情")
    @PostMapping(value = "queryPreview", consumes = "application/json;charset=UTF-8")
    public Result queryPreview(@RequestBody ClientQueryPreviewOneDTO clientQueryPreviewOneDTO) {
        QueryWhere queryWhere = new QueryWhere();
        BeanUtils.copyProperties(clientQueryPreviewOneDTO, queryWhere);
        return previewClient.queryPreview(queryWhere);
    }

    /**
     * 根据时间段查询
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @ApiOperation("根据时间段查询")
    @PostMapping(value = "queryByDate", consumes = "application/json;charset=UTF-8")
    public Result queryByDate(@RequestBody ClientQueryPageDTO clientQueryPageDTO,
                              String startDate, String endDate) {
        PagerParam pagerParam = new PagerParam();
        BeanUtils.copyProperties(clientQueryPageDTO, pagerParam);
        return previewClient.queryByDate(pagerParam, startDate, endDate);
    }

}
