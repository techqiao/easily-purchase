package com.epc.tendering.service.mapper.committee;

import com.epc.tendering.service.domain.committee.BAssessmentCommitteeBid;
import com.epc.tendering.service.domain.committee.BAssessmentCommitteeBidCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BAssessmentCommitteeBidMapper {
    int countByExample(BAssessmentCommitteeBidCriteria example);

    int deleteByExample(BAssessmentCommitteeBidCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BAssessmentCommitteeBid record);

    int insertSelective(BAssessmentCommitteeBid record);

    List<BAssessmentCommitteeBid> selectByExampleWithRowbounds(BAssessmentCommitteeBidCriteria example, RowBounds rowBounds);

    List<BAssessmentCommitteeBid> selectByExample(BAssessmentCommitteeBidCriteria example);

    BAssessmentCommitteeBid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BAssessmentCommitteeBid record, @Param("example") BAssessmentCommitteeBidCriteria example);

    int updateByExample(@Param("record") BAssessmentCommitteeBid record, @Param("example") BAssessmentCommitteeBidCriteria example);

    int updateByPrimaryKeySelective(BAssessmentCommitteeBid record);

    int updateByPrimaryKey(BAssessmentCommitteeBid record);
}