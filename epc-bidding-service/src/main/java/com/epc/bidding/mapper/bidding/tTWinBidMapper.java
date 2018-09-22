package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.tTWinBid;
import com.epc.bidding.domain.bidding.tTWinBidCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface tTWinBidMapper {
    int countByExample(tTWinBidCriteria example);

    int deleteByExample(tTWinBidCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(tTWinBid record);

    int insertSelective(tTWinBid record);

    List<tTWinBid> selectByExampleWithRowbounds(tTWinBidCriteria example, RowBounds rowBounds);

    List<tTWinBid> selectByExample(tTWinBidCriteria example);

    tTWinBid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") tTWinBid record, @Param("example") tTWinBidCriteria example);

    int updateByExample(@Param("record") tTWinBid record, @Param("example") tTWinBidCriteria example);

    int updateByPrimaryKeySelective(tTWinBid record);

    int updateByPrimaryKey(tTWinBid record);
}