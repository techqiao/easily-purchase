package com.epc.bidding.service.question.impl;

import com.epc.bidding.domain.BAnswerQuestionCriteria;
import com.epc.bidding.domain.BAnswerQuestionWithBLOBs;
import com.epc.bidding.domain.BExpertScoreReport;
import com.epc.bidding.domain.BExpertScoreReportCriteria;
import com.epc.bidding.mapper.BAnswerQuestionMapper;
import com.epc.bidding.mapper.BExpertScoreReportMapper;
import com.epc.bidding.service.question.QuestionService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.QuestionTypeEnum;
import com.epc.common.util.DateTimeUtil;
import com.epc.web.facade.bidding.handle.HandleQuestion;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQuestionListVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    BAnswerQuestionMapper bAnswerQuestionMapper;
    @Autowired
    BExpertScoreReportMapper bExpertScoreReportMapper;
    /**
     * 查看 答疑列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<QueryAnswerQuestionListVO>> getAnswerQuestionList(QueryAnswerQuestionDTO dto) {
        final BAnswerQuestionCriteria criteria = new BAnswerQuestionCriteria();
        final BAnswerQuestionCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        if(StringUtils.isNotEmpty(dto.getAnswerName())){
            subCriteria.andAnswerNameLike("%"+dto.getAnswerName()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getQuestionType())){
            subCriteria.andQuestionTypeEqualTo(dto.getQuestionType());
        }
        if(dto.getTypeId()!=null && dto.getTypeId()>0){
            subCriteria.andTypeIdEqualTo(dto.getTypeId());
        }
        if(dto.getQuestionerId()!=null && dto.getQuestionerId()>0){
            subCriteria.andQuestionerIdEqualTo(dto.getQuestionerId());
        }
        if(StringUtils.isNotEmpty(dto.getQuestionerName())){
            subCriteria.andQuestionerNameLike("%"+dto.getQuestionerName()+"%");
        }
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        criteria.setOrderByClause("create_at desc");

        List<BAnswerQuestionWithBLOBs> list=bAnswerQuestionMapper.selectByExampleWithBLOBs(criteria);
        List<QueryAnswerQuestionListVO> returnList = new ArrayList<>();
        list.forEach(item -> {
            QueryAnswerQuestionListVO vo = new QueryAnswerQuestionListVO();
            BeanUtils.copyProperties(item, vo);
            vo.setCreateAt(DateTimeUtil.dateToStr(item.getCreateAt()));
            returnList.add(vo);
        });
        return Result.success(returnList);
    }



    /**
     * 新增一条问题 (公告,招标文件，评标)
     * @param handleQuestion
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertBAnswerQuestion(HandleQuestion handleQuestion){
        BAnswerQuestionWithBLOBs entity= new BAnswerQuestionWithBLOBs();
        BeanUtils.copyProperties(handleQuestion,entity);
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setOperateId(handleQuestion.getQuestionerId());
        entity.setStatus(QuestionTypeEnum.WAIT_REPLY.getCode());
        if(handleQuestion.getQuestionType() !=null && QuestionTypeEnum.BID_FILE.equals(handleQuestion.getQuestionType())
                && handleQuestion.getBidsId()!=null){
            //根据标段id 查询到 具体的评审报告
            BExpertScoreReportCriteria criteria=new BExpertScoreReportCriteria();
            BExpertScoreReportCriteria.Criteria cubCriteria=criteria.createCriteria();
            cubCriteria.andBidsIdEqualTo(handleQuestion.getBidsId());
            List<BExpertScoreReport> result= bExpertScoreReportMapper.selectByExample(criteria);
            if(result!=null){
                entity.setTypeId(result.get(0).getBidsId());
            }
        }
        try{
            bAnswerQuestionMapper.insertSelective(entity);
        }catch (Exception e){
            LOGGER.error(entity.toString()+"_"+e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error();
        }
        return  Result.success(true);
    }

}
