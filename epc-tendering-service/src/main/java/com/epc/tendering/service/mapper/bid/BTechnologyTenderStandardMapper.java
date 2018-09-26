package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BTechnologyTenderStandard;
import com.epc.tendering.service.domain.bid.BTechnologyTenderStandardCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BTechnologyTenderStandardMapper {
    int countByExample(BTechnologyTenderStandardCriteria example);

    int deleteByExample(BTechnologyTenderStandardCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BTechnologyTenderStandard record);

    int insertSelective(BTechnologyTenderStandard record);

    List<BTechnologyTenderStandard> selectByExampleWithRowbounds(BTechnologyTenderStandardCriteria example, RowBounds rowBounds);

    List<BTechnologyTenderStandard> selectByExample(BTechnologyTenderStandardCriteria example);

    BTechnologyTenderStandard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BTechnologyTenderStandard record, @Param("example") BTechnologyTenderStandardCriteria example);

    int updateByExample(@Param("record") BTechnologyTenderStandard record, @Param("example") BTechnologyTenderStandardCriteria example);

    int updateByPrimaryKeySelective(BTechnologyTenderStandard record);

    int updateByPrimaryKey(BTechnologyTenderStandard record);
}