package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.BReleaseAnnouncement;
import com.epc.bidding.domain.bidding.BReleaseAnnouncementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BReleaseAnnouncementMapper {
    int countByExample(BReleaseAnnouncementCriteria example);

    int deleteByExample(BReleaseAnnouncementCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BReleaseAnnouncement record);

    int insertSelective(BReleaseAnnouncement record);

    List<BReleaseAnnouncement> selectByExampleWithBLOBsWithRowbounds(BReleaseAnnouncementCriteria example, RowBounds rowBounds);

    List<BReleaseAnnouncement> selectByExampleWithBLOBs(BReleaseAnnouncementCriteria example);

    List<BReleaseAnnouncement> selectByExampleWithRowbounds(BReleaseAnnouncementCriteria example, RowBounds rowBounds);

    List<BReleaseAnnouncement> selectByExample(BReleaseAnnouncementCriteria example);

    BReleaseAnnouncement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BReleaseAnnouncement record, @Param("example") BReleaseAnnouncementCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BReleaseAnnouncement record, @Param("example") BReleaseAnnouncementCriteria example);

    int updateByExample(@Param("record") BReleaseAnnouncement record, @Param("example") BReleaseAnnouncementCriteria example);

    int updateByPrimaryKeySelective(BReleaseAnnouncement record);

    int updateByPrimaryKeyWithBLOBs(BReleaseAnnouncement record);

    int updateByPrimaryKey(BReleaseAnnouncement record);
}