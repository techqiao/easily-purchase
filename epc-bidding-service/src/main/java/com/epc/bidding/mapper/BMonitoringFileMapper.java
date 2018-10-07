package com.epc.bidding.mapper;

import com.epc.bidding.domain.BMonitoringFile;
import com.epc.bidding.domain.BMonitoringFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BMonitoringFileMapper {
    int countByExample(BMonitoringFileCriteria example);

    int deleteByExample(BMonitoringFileCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BMonitoringFile record);

    int insertSelective(BMonitoringFile record);

    List<BMonitoringFile> selectByExampleWithRowbounds(BMonitoringFileCriteria example, RowBounds rowBounds);

    List<BMonitoringFile> selectByExample(BMonitoringFileCriteria example);

    BMonitoringFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BMonitoringFile record, @Param("example") BMonitoringFileCriteria example);

    int updateByExample(@Param("record") BMonitoringFile record, @Param("example") BMonitoringFileCriteria example);

    int updateByPrimaryKeySelective(BMonitoringFile record);

    int updateByPrimaryKey(BMonitoringFile record);
}