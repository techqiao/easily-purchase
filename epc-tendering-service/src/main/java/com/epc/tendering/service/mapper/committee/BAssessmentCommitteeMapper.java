package com.epc.tendering.service.mapper.committee;

import com.epc.tendering.service.domain.committee.BAssessmentCommittee;
import com.epc.tendering.service.domain.committee.BAssessmentCommitteeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface BAssessmentCommitteeMapper {
    int countByExample(BAssessmentCommitteeCriteria example);

    int deleteByExample(BAssessmentCommitteeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BAssessmentCommittee record);

    int insertSelective(BAssessmentCommittee record);

    List<BAssessmentCommittee> selectByExampleWithRowbounds(BAssessmentCommitteeCriteria example, RowBounds rowBounds);

    List<BAssessmentCommittee> selectByExample(BAssessmentCommitteeCriteria example);

    BAssessmentCommittee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BAssessmentCommittee record, @Param("example") BAssessmentCommitteeCriteria example);

    int updateByExample(@Param("record") BAssessmentCommittee record, @Param("example") BAssessmentCommitteeCriteria example);

    int updateByPrimaryKeySelective(BAssessmentCommittee record);

    int updateByPrimaryKey(BAssessmentCommittee record);

    @Select("Select b.id from b_assessment_committee b where b.procurement_project_id =#{procurementProjectId} and b.process_state='2'")
    Long getId(Long procurementProjectId);
}