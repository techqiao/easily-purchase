package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TSupplierSign;
import com.epc.tendering.service.domain.bid.TSupplierSignCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierSignMapper {
    int countByExample(TSupplierSignCriteria example);

    int deleteByExample(TSupplierSignCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TSupplierSign record);

    int insertSelective(TSupplierSign record);

    List<TSupplierSign> selectByExampleWithRowbounds(TSupplierSignCriteria example, RowBounds rowBounds);

    List<TSupplierSign> selectByExample(TSupplierSignCriteria example);

    TSupplierSign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSupplierSign record, @Param("example") TSupplierSignCriteria example);

    int updateByExample(@Param("record") TSupplierSign record, @Param("example") TSupplierSignCriteria example);

    int updateByPrimaryKeySelective(TSupplierSign record);

    int updateByPrimaryKey(TSupplierSign record);
}