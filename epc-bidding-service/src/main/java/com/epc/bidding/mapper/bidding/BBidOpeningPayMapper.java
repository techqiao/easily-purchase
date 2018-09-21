package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.BBidOpeningPay;
import com.epc.bidding.domain.bidding.BBidOpeningPayCriteria;
import java.util.List;

import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
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

    List<QueryTenderMoneyRecordVO> selectBidPayRecord(Long id);
}