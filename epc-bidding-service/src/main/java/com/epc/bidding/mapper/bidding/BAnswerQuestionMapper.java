package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.BAnswerQuestion;
import com.epc.bidding.domain.bidding.BAnswerQuestionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BAnswerQuestionMapper {
    int countByExample(BAnswerQuestionCriteria example);

    int deleteByExample(BAnswerQuestionCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BAnswerQuestion record);

    int insertSelective(BAnswerQuestion record);

    List<BAnswerQuestion> selectByExampleWithRowbounds(BAnswerQuestionCriteria example, RowBounds rowBounds);

    List<BAnswerQuestion> selectByExample(BAnswerQuestionCriteria example);

    BAnswerQuestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BAnswerQuestion record, @Param("example") BAnswerQuestionCriteria example);

    int updateByExample(@Param("record") BAnswerQuestion record, @Param("example") BAnswerQuestionCriteria example);

    int updateByPrimaryKeySelective(BAnswerQuestion record);

    int updateByPrimaryKey(BAnswerQuestion record);
}