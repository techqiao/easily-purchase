package com.epc.bidding.mapper;

import com.epc.bidding.domain.BExpertScoreReport;
import com.epc.bidding.domain.BExpertScoreReportCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
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
}