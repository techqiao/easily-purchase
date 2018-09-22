package com.epc.web.client.controller.terdering.preview;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.preview.handle.ClientPreviewHandle;
import com.epc.web.client.controller.terdering.preview.query.ClientQueryPreviewDTO;
import com.epc.web.client.controller.terdering.preview.query.ClientQueryPreviewOneDTO;
import com.epc.web.client.remoteApi.terdering.preview.PreviewClient;
import com.epc.web.facade.terdering.preview.dto.QueryPreviewDTO;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 15:56
 * <p>@Author : luozhixin
 * <p>PreviewController
 */
@Api(value = "发布预告",tags ={"发布预告"} )
@RestController
@RequestMapping(value = "/preview", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PreviewController extends BaseController {

    @Autowired
    private PreviewClient previewClient;

    @PostMapping(value = "insertPreview" ,consumes = "application/json;charset=UTF-8")
    public Result insertPreview(@RequestBody ClientPreviewHandle clientPreviewHandle ){
        PreviewHandle previewHande = new PreviewHandle();
        BeanUtils.copyProperties(clientPreviewHandle,previewHande);
        previewHande.setCreator(getLoginUser().getName());
        previewHande.setSetOperateId(getLoginUser().getUserId());
        return previewClient.insertPreview(previewHande );
    }
    /**
     * 查询预告列表
     * @param clientQueryPreviewDTO
     * @return
     */
    @PostMapping(value = "selectPreview",consumes = "application/json;charset=UTF-8")
    public Result selectPreview(@RequestBody ClientQueryPreviewDTO clientQueryPreviewDTO){
        QueryPreviewDTO queryPreviewDTO = new QueryPreviewDTO();
        BeanUtils.copyProperties(clientQueryPreviewDTO,queryPreviewDTO);
        return previewClient.selectPreview(queryPreviewDTO);
    }
    /**
     * 详情
     * @param clientQueryPreviewOneDTOc
     * @return
     */
    @PostMapping(value = "queryPreview",consumes = "application/json;charset=UTF-8")
    public Result queryPreview(@RequestBody ClientQueryPreviewOneDTO clientQueryPreviewOneDTOc){
        QueryPreviewDTO queryPreviewDTO = new QueryPreviewDTO();
        BeanUtils.copyProperties(clientQueryPreviewOneDTOc,queryPreviewDTO);
        return previewClient.selectPreview(queryPreviewDTO);
    }
    /**
     * 根据时间段查询
     * @param startDate
     * @param endDate
     * @return
     */
    @PostMapping(value = "queryByDate",consumes = "application/json;charset=UTF-8")
    public Result queryByDate(@RequestBody ClientQueryPreviewDTO clientQueryPreviewDTO,
                              @RequestParam("startDate")Date startDate , @RequestParam("endDate") Date endDate){
        QueryPreviewDTO queryPreviewDTO = new QueryPreviewDTO();
        BeanUtils.copyProperties(clientQueryPreviewDTO,queryPreviewDTO);
        return  previewClient.queryByDate(queryPreviewDTO,startDate,endDate);
    }

}
