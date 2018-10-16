package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.LetterOfTender;
import com.epc.tendering.service.domain.bid.LetterOfTenderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface LetterOfTenderMapper {
    int countByExample(LetterOfTenderCriteria example);

    int deleteByExample(LetterOfTenderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(LetterOfTender record);

    int insertSelective(LetterOfTender record);

    List<LetterOfTender> selectByExampleWithBLOBsWithRowbounds(LetterOfTenderCriteria example, RowBounds rowBounds);

    List<LetterOfTender> selectByExampleWithBLOBs(LetterOfTenderCriteria example);

    List<LetterOfTender> selectByExampleWithRowbounds(LetterOfTenderCriteria example, RowBounds rowBounds);

    List<LetterOfTender> selectByExample(LetterOfTenderCriteria example);

    LetterOfTender selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LetterOfTender record, @Param("example") LetterOfTenderCriteria example);

    int updateByExampleWithBLOBs(@Param("record") LetterOfTender record, @Param("example") LetterOfTenderCriteria example);

    int updateByExample(@Param("record") LetterOfTender record, @Param("example") LetterOfTenderCriteria example);

    int updateByPrimaryKeySelective(LetterOfTender record);

    int updateByPrimaryKeyWithBLOBs(LetterOfTender record);

    int updateByPrimaryKey(LetterOfTender record);

    /**
     * 唱标 唱标备注为null count=0 false -->唱标已完成
     * @param procurementProjectId
     * @return
     */
    @Select("Select count(b.id) from letter_of_tender b where b.procurement_project_id =#{procurementProjectId} and b.memo IS NOT NULL")
    @ResultType(Boolean.class)
    Boolean getIdMEMO(Long procurementProjectId);

    @Select("Select count(b.id) from letter_of_tender b where b.procurement_project_id =#{procurementProjectId}")
    Integer getId(Long procurementProjectId);
}