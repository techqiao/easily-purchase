package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BExpertSign;
import com.epc.tendering.service.domain.bid.BExpertSignCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BExpertSignMapper {
    int countByExample(BExpertSignCriteria example);

    int deleteByExample(BExpertSignCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BExpertSign record);

    int insertSelective(BExpertSign record);

    List<BExpertSign> selectByExampleWithRowbounds(BExpertSignCriteria example, RowBounds rowBounds);

    List<BExpertSign> selectByExample(BExpertSignCriteria example);

    BExpertSign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BExpertSign record, @Param("example") BExpertSignCriteria example);

    int updateByExample(@Param("record") BExpertSign record, @Param("example") BExpertSignCriteria example);

    int updateByPrimaryKeySelective(BExpertSign record);

    int updateByPrimaryKey(BExpertSign record);
}