package com.epc.bidding.mapper;

import com.epc.bidding.domain.TPurchaseProjectFilePay;
import com.epc.bidding.domain.TPurchaseProjectFilePayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectFilePayMapper {
    int countByExample(TPurchaseProjectFilePayCriteria example);

    int deleteByExample(TPurchaseProjectFilePayCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectFilePay record);

    int insertSelective(TPurchaseProjectFilePay record);

    List<TPurchaseProjectFilePay> selectByExampleWithRowbounds(TPurchaseProjectFilePayCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectFilePay> selectByExample(TPurchaseProjectFilePayCriteria example);

    TPurchaseProjectFilePay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectFilePay record, @Param("example") TPurchaseProjectFilePayCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectFilePay record, @Param("example") TPurchaseProjectFilePayCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectFilePay record);

    int updateByPrimaryKey(TPurchaseProjectFilePay record);
}