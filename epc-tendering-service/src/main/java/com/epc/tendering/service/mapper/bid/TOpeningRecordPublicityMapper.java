package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TOpeningRecordPublicity;
import com.epc.tendering.service.domain.bid.TOpeningRecordPublicityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TOpeningRecordPublicityMapper {
    int countByExample(TOpeningRecordPublicityCriteria example);

    int deleteByExample(TOpeningRecordPublicityCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOpeningRecordPublicity record);

    int insertSelective(TOpeningRecordPublicity record);

    List<TOpeningRecordPublicity> selectByExampleWithRowbounds(TOpeningRecordPublicityCriteria example, RowBounds rowBounds);

    List<TOpeningRecordPublicity> selectByExample(TOpeningRecordPublicityCriteria example);

    TOpeningRecordPublicity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOpeningRecordPublicity record, @Param("example") TOpeningRecordPublicityCriteria example);

    int updateByExample(@Param("record") TOpeningRecordPublicity record, @Param("example") TOpeningRecordPublicityCriteria example);

    int updateByPrimaryKeySelective(TOpeningRecordPublicity record);

    int updateByPrimaryKey(TOpeningRecordPublicity record);


    @Select("SELECT t.process_status FROM t_opening_record_publicity t WHERE t.id = #{id}")
    String getProcessStatus(Long id);

    @Select("Select b.id from t_opening_record_publicity b left join t_opening_record t on t.id = b.bid_announcement_id where t.purchase_project_id =#{procurementProjectId} and b.process_status='released'")
    Long getId(Long procurementProjectId);
}