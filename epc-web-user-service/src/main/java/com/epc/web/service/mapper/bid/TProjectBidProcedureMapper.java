package com.epc.web.service.mapper.bid;

import com.epc.web.service.domain.bid.TProjectBidProcedure;
import com.epc.web.service.domain.bid.TProjectBidProcedureCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TProjectBidProcedureMapper {
    int countByExample(TProjectBidProcedureCriteria example);

    int deleteByExample(TProjectBidProcedureCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TProjectBidProcedure record);

    int insertSelective(TProjectBidProcedure record);

    List<TProjectBidProcedure> selectByExampleWithRowbounds(TProjectBidProcedureCriteria example, RowBounds rowBounds);

    List<TProjectBidProcedure> selectByExample(TProjectBidProcedureCriteria example);

    TProjectBidProcedure selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProjectBidProcedure record, @Param("example") TProjectBidProcedureCriteria example);

    int updateByExample(@Param("record") TProjectBidProcedure record, @Param("example") TProjectBidProcedureCriteria example);

    int updateByPrimaryKeySelective(TProjectBidProcedure record);

    int updateByPrimaryKey(TProjectBidProcedure record);
}