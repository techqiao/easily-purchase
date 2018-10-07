package com.epc.bidding.mapper;

import com.epc.bidding.domain.TWinBid;
import com.epc.bidding.domain.TWinBidCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TWinBidMapper {
    int countByExample(TWinBidCriteria example);

    int deleteByExample(TWinBidCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TWinBid record);

    int insertSelective(TWinBid record);

    List<TWinBid> selectByExampleWithRowbounds(TWinBidCriteria example, RowBounds rowBounds);

    List<TWinBid> selectByExample(TWinBidCriteria example);

    TWinBid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TWinBid record, @Param("example") TWinBidCriteria example);

    int updateByExample(@Param("record") TWinBid record, @Param("example") TWinBidCriteria example);

    int updateByPrimaryKeySelective(TWinBid record);

    int updateByPrimaryKey(TWinBid record);
}