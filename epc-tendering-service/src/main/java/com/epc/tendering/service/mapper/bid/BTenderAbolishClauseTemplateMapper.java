package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BTenderAbolishClauseTemplate;
import com.epc.tendering.service.domain.bid.BTenderAbolishClauseTemplateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BTenderAbolishClauseTemplateMapper {
    int countByExample(BTenderAbolishClauseTemplateCriteria example);

    int deleteByExample(BTenderAbolishClauseTemplateCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BTenderAbolishClauseTemplate record);

    int insertSelective(BTenderAbolishClauseTemplate record);

    List<BTenderAbolishClauseTemplate> selectByExampleWithRowbounds(BTenderAbolishClauseTemplateCriteria example, RowBounds rowBounds);

    List<BTenderAbolishClauseTemplate> selectByExample(BTenderAbolishClauseTemplateCriteria example);

    BTenderAbolishClauseTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BTenderAbolishClauseTemplate record, @Param("example") BTenderAbolishClauseTemplateCriteria example);

    int updateByExample(@Param("record") BTenderAbolishClauseTemplate record, @Param("example") BTenderAbolishClauseTemplateCriteria example);

    int updateByPrimaryKeySelective(BTenderAbolishClauseTemplate record);

    int updateByPrimaryKey(BTenderAbolishClauseTemplate record);
}