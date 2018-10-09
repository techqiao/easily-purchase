package com.epc.bidding.mapper;

import com.epc.bidding.domain.TProjectProcedure;
import com.epc.bidding.domain.TProjectProcedureCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TProjectProcedureMapper {
    int countByExample(TProjectProcedureCriteria example);

    int deleteByExample(TProjectProcedureCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TProjectProcedure record);

    int insertSelective(TProjectProcedure record);

    List<TProjectProcedure> selectByExampleWithRowbounds(TProjectProcedureCriteria example, RowBounds rowBounds);

    List<TProjectProcedure> selectByExample(TProjectProcedureCriteria example);

    TProjectProcedure selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProjectProcedure record, @Param("example") TProjectProcedureCriteria example);

    int updateByExample(@Param("record") TProjectProcedure record, @Param("example") TProjectProcedureCriteria example);

    int updateByPrimaryKeySelective(TProjectProcedure record);

    int updateByPrimaryKey(TProjectProcedure record);
}