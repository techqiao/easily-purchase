package com.epc.tendering.service.controller.question;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.question.BAnswerQuestionService;
import com.epc.web.facade.terdering.answer.FacadeAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.query.QueryPublicityDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import com.epc.web.facade.terdering.answer.vo.MonitorAnswerQuestionVO;
import com.epc.web.facade.terdering.answer.vo.PublicityVO;
import com.epc.web.facade.terdering.answer.vo.WinBidVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:19
 * <p>@Author : wjq
 */
@RestController
public class BAnswerQuestionController extends BaseController implements FacadeAnswerQuestionService {

    @Autowired
    private BAnswerQuestionService bAnswerQuestionService;

    @Override
    public Result<List<FacadeAnswerQuestionVO>> getQuestionList(@RequestBody QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        return bAnswerQuestionService.getQuestionList(queryAnswerQuestionDTO);
    }

    @Override
    public Result<Boolean> replyQuestion(@RequestBody HandleReplyQuestion handleReplyQuestion) {
        return bAnswerQuestionService.replyQuestion(handleReplyQuestion);
    }


    @Override
    public Result<List<PublicityVO>> getPublicityListOfficialNetwork(@RequestBody QueryPublicityDTO QueryPublicityDTO) {
        return bAnswerQuestionService.getPublicityListOfficialNetwork(QueryPublicityDTO);
    }

    /**
     * 官网:中标公示
     * @return
     */
    @Override
    public Result<Map<String, Object>> getBidPublicity(@RequestBody PagerParam pagerParam) {
        PageHelper.startPage(pagerParam.getPage(),pagerParam.getRows());
        Result<List<WinBidVO>> bidPublicity = bAnswerQuestionService.getBidPublicity();
        PageInfo<WinBidVO> pageInfo = new PageInfo<>(bidPublicity.getData());
        return Result.success(getDataTable(pageInfo));
    }

    @Override
    public Result<Map<String, Object>> getProcurementProjectAnswerQuestionList(@RequestBody QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        PageHelper.startPage(queryAnswerQuestionDTO.getPage(),queryAnswerQuestionDTO.getRows());
        Result<List<MonitorAnswerQuestionVO>> procurementProjectAnswerQuestionList = bAnswerQuestionService.getProcurementProjectAnswerQuestionList(queryAnswerQuestionDTO);
        PageInfo<MonitorAnswerQuestionVO> pageInfo = new PageInfo<>(procurementProjectAnswerQuestionList.getData());
        return Result.success(getDataTable(pageInfo));
    }

}
