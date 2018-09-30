package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TPurchaseProjectBegin;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBeginCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectBeginMapper {
    int countByExample(TPurchaseProjectBeginCriteria example);

    int deleteByExample(TPurchaseProjectBeginCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectBegin record);

    int insertSelective(TPurchaseProjectBegin record);

    List<TPurchaseProjectBegin> selectByExampleWithRowbounds(TPurchaseProjectBeginCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectBegin> selectByExample(TPurchaseProjectBeginCriteria example);

    TPurchaseProjectBegin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectBegin record, @Param("example") TPurchaseProjectBeginCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectBegin record, @Param("example") TPurchaseProjectBeginCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectBegin record);

    int updateByPrimaryKey(TPurchaseProjectBegin record);
}