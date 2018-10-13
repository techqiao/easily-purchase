package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BExpertScore;
import com.epc.tendering.service.domain.bid.BExpertScoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BExpertScoreMapper {
    int countByExample(BExpertScoreCriteria example);

    int deleteByExample(BExpertScoreCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BExpertScore record);

    int insertSelective(BExpertScore record);

    List<BExpertScore> selectByExampleWithRowbounds(BExpertScoreCriteria example, RowBounds rowBounds);

    List<BExpertScore> selectByExample(BExpertScoreCriteria example);

    BExpertScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BExpertScore record, @Param("example") BExpertScoreCriteria example);

    int updateByExample(@Param("record") BExpertScore record, @Param("example") BExpertScoreCriteria example);

    int updateByPrimaryKeySelective(BExpertScore record);

    int updateByPrimaryKey(BExpertScore record);
}