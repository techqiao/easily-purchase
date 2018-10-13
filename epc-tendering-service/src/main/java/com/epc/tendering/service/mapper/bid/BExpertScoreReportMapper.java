package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BExpertScoreReport;
import com.epc.tendering.service.domain.bid.BExpertScoreReportCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface BExpertScoreReportMapper {
    int countByExample(BExpertScoreReportCriteria example);

    int deleteByExample(BExpertScoreReportCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BExpertScoreReport record);

    int insertSelective(BExpertScoreReport record);

    List<BExpertScoreReport> selectByExampleWithBLOBsWithRowbounds(BExpertScoreReportCriteria example, RowBounds rowBounds);

    List<BExpertScoreReport> selectByExampleWithBLOBs(BExpertScoreReportCriteria example);

    List<BExpertScoreReport> selectByExampleWithRowbounds(BExpertScoreReportCriteria example, RowBounds rowBounds);

    List<BExpertScoreReport> selectByExample(BExpertScoreReportCriteria example);

    BExpertScoreReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BExpertScoreReport record, @Param("example") BExpertScoreReportCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BExpertScoreReport record, @Param("example") BExpertScoreReportCriteria example);

    int updateByExample(@Param("record") BExpertScoreReport record, @Param("example") BExpertScoreReportCriteria example);

    int updateByPrimaryKeySelective(BExpertScoreReport record);

    int updateByPrimaryKeyWithBLOBs(BExpertScoreReport record);

    int updateByPrimaryKey(BExpertScoreReport record);


    @Select("Select count(b.id) from b_expert_score_report b where b.procurement_project_id =#{procurementProjectId}")
    Integer getId(Long procurementProjectId);
}