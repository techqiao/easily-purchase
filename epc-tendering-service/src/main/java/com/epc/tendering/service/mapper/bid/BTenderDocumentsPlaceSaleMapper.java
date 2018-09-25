package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BTenderDocumentsPlaceSale;
import com.epc.tendering.service.domain.bid.BTenderDocumentsPlaceSaleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BTenderDocumentsPlaceSaleMapper {
    int countByExample(BTenderDocumentsPlaceSaleCriteria example);

    int deleteByExample(BTenderDocumentsPlaceSaleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BTenderDocumentsPlaceSale record);

    int insertSelective(BTenderDocumentsPlaceSale record);

    List<BTenderDocumentsPlaceSale> selectByExampleWithRowbounds(BTenderDocumentsPlaceSaleCriteria example, RowBounds rowBounds);

    List<BTenderDocumentsPlaceSale> selectByExample(BTenderDocumentsPlaceSaleCriteria example);

    BTenderDocumentsPlaceSale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BTenderDocumentsPlaceSale record, @Param("example") BTenderDocumentsPlaceSaleCriteria example);

    int updateByExample(@Param("record") BTenderDocumentsPlaceSale record, @Param("example") BTenderDocumentsPlaceSaleCriteria example);

    int updateByPrimaryKeySelective(BTenderDocumentsPlaceSale record);

    int updateByPrimaryKey(BTenderDocumentsPlaceSale record);
}