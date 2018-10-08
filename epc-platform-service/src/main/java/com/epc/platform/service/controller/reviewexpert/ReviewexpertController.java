package com.epc.platform.service.controller.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewExpertService;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.ExpertForbiddenHandle;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.vo.ExpertDetailVO;
import com.epc.administration.facade.reviewexpert.vo.ReviewExpertVO;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.service.reviewexpert.ExpertService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : 评审专家控制器
 * <p>Date : 2018-09-14 10:33:12
 * <p>@author : lzx
 */
@Api(value = "评审专家服务", description = "评审专家服务")
@RestController
public class ReviewexpertController  extends BaseController implements ReviewExpertService {

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

    @Override
    public Result<Boolean> updateReviewExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        return expertService.updateReviewExpertDetailInfo(reviewExpertHandle);
    }

    /**
     * 评审专家资料删除
     * @param whereId
     * @return
     */
    @Override
    public Result<Boolean> deleteReviewExpertDetailInfo(@RequestParam("whereId") Long whereId) {
        return expertService.deleteExpertDetailInfo(whereId);
    }

    /**
     * 评审专家资料查询
     * @param whereId
     * @return
     */
    @Override
    public Result<ExpertDetailVO> queryReviewExpertDetailInfo(@RequestParam("whereId") Long whereId) {
        return expertService.queryExpertDetailInfo(whereId);
    }


    /**
     * 查询所有评审专家 分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<Map<String, Object>> selectAllExpertByPage(@RequestBody QueryDetailIfo queryDetailIfo) {
        PageHelper.startPage(queryDetailIfo.getPageNum(),queryDetailIfo.getPageSize());
        Result<List<ReviewExpertVO>> listResult = expertService.selectAllExpertByPage(queryDetailIfo);
        PageInfo<ReviewExpertVO> pageInfo = new PageInfo<>(listResult.getData());
        return Result.success(getDataTable(pageInfo));
    }

    /**
     * 审核评审专家
     * @param examineExpertHandle
     * @return
     */
    @Override
    public Result<Boolean> examineExpert(@RequestBody ExamineExpertHandle examineExpertHandle) {
        return expertService.examineExpert(examineExpertHandle);
    }

    /**
     * 启用 锁定评审专家
     * @param expertForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenExpertUser(@RequestBody ExpertForbiddenHandle expertForbiddenHandle) {
        return expertService.forbiddenExpertUser(expertForbiddenHandle);
    }
}
