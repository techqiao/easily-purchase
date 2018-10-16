package com.epc.tendering.service.mapper.question;

import com.epc.tendering.service.domain.question.BAnswerQuestion;
import com.epc.tendering.service.domain.question.BAnswerQuestionCriteria;
import com.epc.tendering.service.domain.question.BAnswerQuestionWithBLOBs;
import java.util.List;

import com.epc.web.facade.terdering.answer.vo.PublicitySubVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface BAnswerQuestionMapper {
    int countByExample(BAnswerQuestionCriteria example);

    int deleteByExample(BAnswerQuestionCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BAnswerQuestionWithBLOBs record);

    int insertSelective(BAnswerQuestionWithBLOBs record);

    List<BAnswerQuestionWithBLOBs> selectByExampleWithBLOBsWithRowbounds(BAnswerQuestionCriteria example, RowBounds rowBounds);

    List<BAnswerQuestionWithBLOBs> selectByExampleWithBLOBs(BAnswerQuestionCriteria example);

    List<BAnswerQuestion> selectByExampleWithRowbounds(BAnswerQuestionCriteria example, RowBounds rowBounds);

    List<BAnswerQuestion> selectByExample(BAnswerQuestionCriteria example);

    BAnswerQuestionWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BAnswerQuestionWithBLOBs record, @Param("example") BAnswerQuestionCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BAnswerQuestionWithBLOBs record, @Param("example") BAnswerQuestionCriteria example);

    int updateByExample(@Param("record") BAnswerQuestion record, @Param("example") BAnswerQuestionCriteria example);

    int updateByPrimaryKeySelective(BAnswerQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BAnswerQuestionWithBLOBs record);

    int updateByPrimaryKey(BAnswerQuestion record);

    /**
     * 通过采购项目ID分组查询相关参数
     * @param procurementProjectId 采购项目ID
     * @return
     */
    @Select("select b.problem,b.answer,b.create_at as startTime from b_answer_question b where b.procurement_project_id ={procurementProjectId} group by b.procurement_project_id")
    List<PublicitySubVO> getListGroupByProcurementProjectId(Long procurementProjectId);


    /**
     * 状态为wait_reply 待回复 0 false ->已完成
     * @param procurementProjectId
     * @return
     */
    @Select("Select count(b.id) from b_answer_question b where b.procurement_project_id =#{procurementProjectId} and b.question_type='bidFile' and b.status='wait_reply'")
    @ResultType(Boolean.class)
    Boolean getId(Long procurementProjectId);

}