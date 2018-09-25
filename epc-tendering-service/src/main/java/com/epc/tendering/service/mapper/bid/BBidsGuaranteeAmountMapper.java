package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BBidsGuaranteeAmount;
import com.epc.tendering.service.domain.bid.BBidsGuaranteeAmountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BBidsGuaranteeAmountMapper {
    int countByExample(BBidsGuaranteeAmountCriteria example);

    int deleteByExample(BBidsGuaranteeAmountCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BBidsGuaranteeAmount record);

    int insertSelective(BBidsGuaranteeAmount record);

    List<BBidsGuaranteeAmount> selectByExampleWithRowbounds(BBidsGuaranteeAmountCriteria example, RowBounds rowBounds);

    List<BBidsGuaranteeAmount> selectByExample(BBidsGuaranteeAmountCriteria example);

    BBidsGuaranteeAmount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BBidsGuaranteeAmount record, @Param("example") BBidsGuaranteeAmountCriteria example);

    int updateByExample(@Param("record") BBidsGuaranteeAmount record, @Param("example") BBidsGuaranteeAmountCriteria example);

    int updateByPrimaryKeySelective(BBidsGuaranteeAmount record);

    int updateByPrimaryKey(BBidsGuaranteeAmount record);
}