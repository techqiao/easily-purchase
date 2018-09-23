package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TServiceMoneyPay;
import com.epc.bidding.domain.bidding.TServiceMoneyPayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TServiceMoneyPayMapper {
    int countByExample(TServiceMoneyPayCriteria example);

    int deleteByExample(TServiceMoneyPayCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TServiceMoneyPay record);

    int insertSelective(TServiceMoneyPay record);

    List<TServiceMoneyPay> selectByExampleWithRowbounds(TServiceMoneyPayCriteria example, RowBounds rowBounds);

    List<TServiceMoneyPay> selectByExample(TServiceMoneyPayCriteria example);

    TServiceMoneyPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TServiceMoneyPay record, @Param("example") TServiceMoneyPayCriteria example);

    int updateByExample(@Param("record") TServiceMoneyPay record, @Param("example") TServiceMoneyPayCriteria example);

    int updateByPrimaryKeySelective(TServiceMoneyPay record);

    int updateByPrimaryKey(TServiceMoneyPay record);
}