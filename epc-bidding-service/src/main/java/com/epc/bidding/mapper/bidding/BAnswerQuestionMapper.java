package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.BAnswerQuestion;
import com.epc.bidding.domain.bidding.BAnswerQuestionCriteria;
import com.epc.bidding.domain.bidding.BAnswerQuestionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
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
}