package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.BBidsGuaranteeAmount;
import com.epc.bidding.domain.bidding.BBidsGuaranteeAmountCriteria;
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