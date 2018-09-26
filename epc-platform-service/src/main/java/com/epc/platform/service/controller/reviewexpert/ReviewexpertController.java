package com.epc.platform.service.controller.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewexpertService;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.reviewexpertr.TExpertDetailInfo;
import com.epc.platform.service.service.reviewexpert.ExpertService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * <p>Description : 评审专家控制器
 * <p>Date : 2018-09-14 10:33:12
 * <p>@author : lzx
 */
@Api(value = "评审专家服务", description = "评审专家服务")
@RestController
public class ReviewexpertController  extends BaseController implements ReviewexpertService {

    @Autowired
    private ExpertService expertService;

    /**
     * 评审专家注册
     * @param handleOperator
     * @return
     */
    @Override
    public Result<Boolean> insertReviewExpertBasicInfo(@RequestBody UserBasicInfo handleOperator) {
        return expertService.insertExpertBasicInfo(handleOperator);
    }
    /**
     * 评审专家资料补全
     * @param reviewExpertHandle
     * @return
     */
    @Override
    public Result<Boolean> insertReviewExpertDetailInfo(@RequestBody ReviewExpertHandle reviewExpertHandle) {
        return expertService.insertExpertDetailInfo(reviewExpertHandle);
    }

    /**
     * 评审专家资料删除
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<Boolean> deleteReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return expertService.deleteExpertDetailInfo(queryDetailIfo);
    }

    /**
     * 评审专家资料查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<TExpertDetailInfo> queryReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return expertService.queryExpertDetailInfo(queryDetailIfo);
    }

    /**
     * 评审专家资料模糊查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<List<TExpertDetailInfo>> selectReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return expertService.selectExpertDetailInfo(queryDetailIfo);
    }

    @Override
    public Result selectAllExpertByPage(@RequestBody QueryRequest queryRequest) {
        PageHelper.startPage(queryRequest.getPageNum(),queryRequest.getPageSize());
        List<TExpertDetailInfo> tExpertDetailInfos = expertService.selectAllExpertByPage();
        PageInfo<TExpertDetailInfo> pageInfo = new PageInfo<>(tExpertDetailInfos);
        return Result.success(getDataTable(pageInfo));
    }
}
