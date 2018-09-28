package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BTenderAbolishClause;
import com.epc.tendering.service.domain.bid.BTenderAbolishClauseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BTenderAbolishClauseMapper {
    int countByExample(BTenderAbolishClauseCriteria example);

    int deleteByExample(BTenderAbolishClauseCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BTenderAbolishClause record);

    int insertSelective(BTenderAbolishClause record);

    List<BTenderAbolishClause> selectByExampleWithRowbounds(BTenderAbolishClauseCriteria example, RowBounds rowBounds);

    List<BTenderAbolishClause> selectByExample(BTenderAbolishClauseCriteria example);

    BTenderAbolishClause selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BTenderAbolishClause record, @Param("example") BTenderAbolishClauseCriteria example);

    int updateByExample(@Param("record") BTenderAbolishClause record, @Param("example") BTenderAbolishClauseCriteria example);

    int updateByPrimaryKeySelective(BTenderAbolishClause record);

    int updateByPrimaryKey(BTenderAbolishClause record);
}