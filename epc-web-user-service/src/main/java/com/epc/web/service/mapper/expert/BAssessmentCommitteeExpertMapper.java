package com.epc.web.service.mapper.expert;

import com.epc.web.service.domain.expert.BAssessmentCommitteeExpert;
import com.epc.web.service.domain.expert.BAssessmentCommitteeExpertCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BAssessmentCommitteeExpertMapper {
    int countByExample(BAssessmentCommitteeExpertCriteria example);

    int deleteByExample(BAssessmentCommitteeExpertCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BAssessmentCommitteeExpert record);

    int insertSelective(BAssessmentCommitteeExpert record);

    List<BAssessmentCommitteeExpert> selectByExampleWithRowbounds(BAssessmentCommitteeExpertCriteria example, RowBounds rowBounds);

    List<BAssessmentCommitteeExpert> selectByExample(BAssessmentCommitteeExpertCriteria example);

    BAssessmentCommitteeExpert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BAssessmentCommitteeExpert record, @Param("example") BAssessmentCommitteeExpertCriteria example);

    int updateByExample(@Param("record") BAssessmentCommitteeExpert record, @Param("example") BAssessmentCommitteeExpertCriteria example);

    int updateByPrimaryKeySelective(BAssessmentCommitteeExpert record);

    int updateByPrimaryKey(BAssessmentCommitteeExpert record);

    List<BAssessmentCommitteeExpert> selectByExpertId(Long expertId);
}