package com.epc.tendering.service.mapper.question;

import com.epc.tendering.service.domain.question.BAnswerQuestion;
import com.epc.tendering.service.domain.question.BAnswerQuestionCriteria;
import com.epc.tendering.service.domain.question.BAnswerQuestionWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

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
}