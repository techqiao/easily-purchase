package com.epc.web.service.mapper.bid;

import com.epc.web.service.domain.bid.TPurchaseProjectBids;
import com.epc.web.service.domain.bid.TPurchaseProjectBidsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectBidsMapper {
    int countByExample(TPurchaseProjectBidsCriteria example);

    int deleteByExample(TPurchaseProjectBidsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectBids record);

    int insertSelective(TPurchaseProjectBids record);

    List<TPurchaseProjectBids> selectByExampleWithBLOBsWithRowbounds(TPurchaseProjectBidsCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectBids> selectByExampleWithBLOBs(TPurchaseProjectBidsCriteria example);

    List<TPurchaseProjectBids> selectByExampleWithRowbounds(TPurchaseProjectBidsCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectBids> selectByExample(TPurchaseProjectBidsCriteria example);

    TPurchaseProjectBids selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectBids record, @Param("example") TPurchaseProjectBidsCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TPurchaseProjectBids record, @Param("example") TPurchaseProjectBidsCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectBids record, @Param("example") TPurchaseProjectBidsCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectBids record);

    int updateByPrimaryKeyWithBLOBs(TPurchaseProjectBids record);

    int updateByPrimaryKey(TPurchaseProjectBids record);
}