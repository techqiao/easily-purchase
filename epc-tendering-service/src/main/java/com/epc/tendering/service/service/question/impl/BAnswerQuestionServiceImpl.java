package com.epc.tendering.service.service.question.impl;

import com.epc.common.Result;
import com.epc.tendering.service.domain.question.BAnswerQuestion;
import com.epc.tendering.service.domain.question.BAnswerQuestionCriteria;
import com.epc.tendering.service.domain.question.BAnswerQuestionWithBLOBs;
import com.epc.tendering.service.mapper.question.BAnswerQuestionMapper;
import com.epc.tendering.service.service.question.BAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:50
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BAnswerQuestionServiceImpl implements BAnswerQuestionService {
    @Autowired
    private BAnswerQuestionMapper bAnswerQuestionMapper;

    @Override
    public Result<List<FacadeAnswerQuestionVO>> getQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        List<FacadeAnswerQuestionVO> returnList = new ArrayList<>();
        final BAnswerQuestionCriteria criteria = new BAnswerQuestionCriteria();
        final BAnswerQuestionCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andProcurementProjectIdEqualTo(queryAnswerQuestionDTO.getProcurementProjectId());
        if(StringUtils.isNotBlank(queryAnswerQuestionDTO.getQuestionerName())) {
            subCriteria.andQuestionerNameEqualTo(queryAnswerQuestionDTO.getQuestionerName());
        }
        if(StringUtils.isNotBlank(queryAnswerQuestionDTO.getStatus())) {
            subCriteria.andStatusEqualTo(queryAnswerQuestionDTO.getStatus());
        }
        criteria.setOrderByClause("id desc");
        List<BAnswerQuestionWithBLOBs> withBLOBsList = bAnswerQuestionMapper.selectByExampleWithBLOBsWithRowbounds(criteria, queryAnswerQuestionDTO.getRowBounds());
        for (BAnswerQuestionWithBLOBs item : withBLOBsList) {
            FacadeAnswerQuestionVO pojo = new FacadeAnswerQuestionVO();
            BeanUtils.copyProperties(item,pojo);
            returnList.add(pojo);
        }
        return Result.success(returnList);
    }

    @Override
    public Result<Boolean> replyQuestion(HandleReplyQuestion handleReplyQuestion) {
        BAnswerQuestionWithBLOBs questionWithBLOBs = bAnswerQuestionMapper.selectByPrimaryKey(handleReplyQuestion.getId());
        questionWithBLOBs.setAnswerId(handleReplyQuestion.getOperateId());
        questionWithBLOBs.setAnswerName(handleReplyQuestion.getOperateName());
        questionWithBLOBs.setUpdateAt(new Date());
        questionWithBLOBs.setStatus("replied");
        questionWithBLOBs.setAnswer(handleReplyQuestion.getAnswer());
        return Result.success(bAnswerQuestionMapper.updateByPrimaryKeyWithBLOBs(questionWithBLOBs) > 0);
    }
}
