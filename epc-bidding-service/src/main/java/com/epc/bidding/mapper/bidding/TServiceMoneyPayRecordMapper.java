package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TServiceMoneyPayRecord;
import com.epc.bidding.domain.bidding.TServiceMoneyPayRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TServiceMoneyPayRecordMapper {
    int countByExample(TServiceMoneyPayRecordCriteria example);

    int deleteByExample(TServiceMoneyPayRecordCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TServiceMoneyPayRecord record);

    int insertSelective(TServiceMoneyPayRecord record);

    List<TServiceMoneyPayRecord> selectByExampleWithRowbounds(TServiceMoneyPayRecordCriteria example, RowBounds rowBounds);

    List<TServiceMoneyPayRecord> selectByExample(TServiceMoneyPayRecordCriteria example);

    TServiceMoneyPayRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TServiceMoneyPayRecord record, @Param("example") TServiceMoneyPayRecordCriteria example);

    int updateByExample(@Param("record") TServiceMoneyPayRecord record, @Param("example") TServiceMoneyPayRecordCriteria example);

    int updateByPrimaryKeySelective(TServiceMoneyPayRecord record);

    int updateByPrimaryKey(TServiceMoneyPayRecord record);
}