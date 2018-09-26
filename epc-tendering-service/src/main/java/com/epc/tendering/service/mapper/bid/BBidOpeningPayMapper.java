package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BBidOpeningPay;
import com.epc.tendering.service.domain.bid.BBidOpeningPayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BBidOpeningPayMapper {
    int countByExample(BBidOpeningPayCriteria example);

    int deleteByExample(BBidOpeningPayCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BBidOpeningPay record);

    int insertSelective(BBidOpeningPay record);

    List<BBidOpeningPay> selectByExampleWithRowbounds(BBidOpeningPayCriteria example, RowBounds rowBounds);

    List<BBidOpeningPay> selectByExample(BBidOpeningPayCriteria example);

    BBidOpeningPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BBidOpeningPay record, @Param("example") BBidOpeningPayCriteria example);

    int updateByExample(@Param("record") BBidOpeningPay record, @Param("example") BBidOpeningPayCriteria example);

    int updateByPrimaryKeySelective(BBidOpeningPay record);

    int updateByPrimaryKey(BBidOpeningPay record);
}