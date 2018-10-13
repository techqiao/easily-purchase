package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TBidAnnouncement;
import com.epc.tendering.service.domain.bid.TBidAnnouncementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TBidAnnouncementMapper {
    int countByExample(TBidAnnouncementCriteria example);

    int deleteByExample(TBidAnnouncementCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TBidAnnouncement record);

    int insertSelective(TBidAnnouncement record);

    List<TBidAnnouncement> selectByExampleWithRowbounds(TBidAnnouncementCriteria example, RowBounds rowBounds);

    List<TBidAnnouncement> selectByExample(TBidAnnouncementCriteria example);

    TBidAnnouncement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TBidAnnouncement record, @Param("example") TBidAnnouncementCriteria example);

    int updateByExample(@Param("record") TBidAnnouncement record, @Param("example") TBidAnnouncementCriteria example);

    int updateByPrimaryKeySelective(TBidAnnouncement record);

    int updateByPrimaryKey(TBidAnnouncement record);

    @Select("Select COUNT(b.id) from t_bid_announcement b where b.purchase_project_id =#{procurementProjectId}")
    Integer getId(Long procurementProjectId);
}