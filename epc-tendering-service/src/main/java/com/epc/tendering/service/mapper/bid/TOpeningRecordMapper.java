package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TOpeningRecord;
import com.epc.tendering.service.domain.bid.TOpeningRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TOpeningRecordMapper {
    int countByExample(TOpeningRecordCriteria example);

    int deleteByExample(TOpeningRecordCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOpeningRecord record);

    int insertSelective(TOpeningRecord record);

    List<TOpeningRecord> selectByExampleWithRowbounds(TOpeningRecordCriteria example, RowBounds rowBounds);

    List<TOpeningRecord> selectByExample(TOpeningRecordCriteria example);

    TOpeningRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOpeningRecord record, @Param("example") TOpeningRecordCriteria example);

    int updateByExample(@Param("record") TOpeningRecord record, @Param("example") TOpeningRecordCriteria example);

    int updateByPrimaryKeySelective(TOpeningRecord record);

    int updateByPrimaryKey(TOpeningRecord record);

    /**
     * 状态为1 正常 true 已完成
     * @param procurementProjectId
     * @return
     */
    @Select("Select count(b.id) from t_opening_record b where b.purchase_project_id =#{procurementProjectId} and b.status='1'")
    @ResultType(Boolean.class)
    Boolean getId(Long procurementProjectId);
}