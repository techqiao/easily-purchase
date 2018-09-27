package com.epc.web.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleExpertScore;
import com.epc.web.client.remoteApi.terdering.bid.ExpertScoreClient;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 11:27
 * <p>@Author : wjq
 */
@Api(value = "开标记录服务",tags="开标记录服务")
@RestController
@RequestMapping(value = "/expert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ExpertScoreController extends BaseController {
    @Autowired
    private ExpertScoreClient expertScoreClient;

    @ApiOperation(value = "获取投标人列表")
    @GetMapping(value = "getBidderList", consumes = "application/json; charset=UTF-8")
    public Result<List<BidderListVO>> getBidderList(Long procurementProjectId){
        return expertScoreClient.getBidderList(procurementProjectId);
    }

    @ApiOperation(value = "专家评分")
    @PostMapping(value = "handleExpertScore", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> handleExpertScore(@RequestBody ClientHandleExpertScore clientHandleExpertScore){
        HandleExpertScore handleExpertScore = new HandleExpertScore();
        BeanUtils.copyProperties(clientHandleExpertScore, handleExpertScore);
        handleExpertScore.setOperateId(getLoginUser().getUserId());
        handleExpertScore.setExpertId(getLoginUser().getUserId());
        handleExpertScore.setExpertName(getLoginUser().getName());
        return expertScoreClient.handleExpertScore(handleExpertScore);
    }

}
