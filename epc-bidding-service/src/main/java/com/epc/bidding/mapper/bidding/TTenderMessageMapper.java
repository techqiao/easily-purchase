package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TTenderMessage;
import com.epc.bidding.domain.bidding.TTenderMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TTenderMessageMapper {
    int countByExample(TTenderMessageCriteria example);

    int deleteByExample(TTenderMessageCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TTenderMessage record);

    int insertSelective(TTenderMessage record);

    List<TTenderMessage> selectByExampleWithRowbounds(TTenderMessageCriteria example, RowBounds rowBounds);

    List<TTenderMessage> selectByExample(TTenderMessageCriteria example);

    TTenderMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TTenderMessage record, @Param("example") TTenderMessageCriteria example);

    int updateByExample(@Param("record") TTenderMessage record, @Param("example") TTenderMessageCriteria example);

    int updateByPrimaryKeySelective(TTenderMessage record);

    int updateByPrimaryKey(TTenderMessage record);
}