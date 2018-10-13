package com.epc.tendering.service.mapper.announcement;

import com.epc.tendering.service.domain.announcement.BReleaseAnnouncement;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncementCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
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

    int batchUpdateStatus(List<BReleaseAnnouncement> list);

    @Select("select t.process_status from b_release_announcement where id=#{id}")
    @ResultType(String.class)
    String getProcessStatusById(Long id);

    @Select("select procurement_project_id from b_release_announcement where id =#{id}")
    Long getProcurementProjectId(Long id);

    @Select("Select b.id from b_release_announcement b where b.procurement_project_id =#{procurementProjectId} and b.process_status='released'")
    Long getId(Long procurementProjectId);

}