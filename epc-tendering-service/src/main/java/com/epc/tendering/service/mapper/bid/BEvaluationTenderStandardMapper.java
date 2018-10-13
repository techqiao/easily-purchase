package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BEvaluationTenderStandard;
import com.epc.tendering.service.domain.bid.BEvaluationTenderStandardCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface BEvaluationTenderStandardMapper {
    int countByExample(BEvaluationTenderStandardCriteria example);

    int deleteByExample(BEvaluationTenderStandardCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BEvaluationTenderStandard record);

    int insertSelective(BEvaluationTenderStandard record);

    List<BEvaluationTenderStandard> selectByExampleWithBLOBsWithRowbounds(BEvaluationTenderStandardCriteria example, RowBounds rowBounds);

    List<BEvaluationTenderStandard> selectByExampleWithBLOBs(BEvaluationTenderStandardCriteria example);

    List<BEvaluationTenderStandard> selectByExampleWithRowbounds(BEvaluationTenderStandardCriteria example, RowBounds rowBounds);

    List<BEvaluationTenderStandard> selectByExample(BEvaluationTenderStandardCriteria example);

    BEvaluationTenderStandard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BEvaluationTenderStandard record, @Param("example") BEvaluationTenderStandardCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BEvaluationTenderStandard record, @Param("example") BEvaluationTenderStandardCriteria example);

    int updateByExample(@Param("record") BEvaluationTenderStandard record, @Param("example") BEvaluationTenderStandardCriteria example);

    int updateByPrimaryKeySelective(BEvaluationTenderStandard record);

    int updateByPrimaryKeyWithBLOBs(BEvaluationTenderStandard record);

    int updateByPrimaryKey(BEvaluationTenderStandard record);

    @Select("Select b.id from b_evaluation_tender_standard b where b.procurement_project_id =#{procurementProjectId} and b.process_status='released'")
    Long getId(Long procurementProjectId);


}