package com.epc.web.service.mapper.operator;

import com.epc.web.service.domain.operator.TOperatorSupplier;
import com.epc.web.service.domain.operator.TOperatorSupplierCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOperatorSupplierMapper {
    int countByExample(TOperatorSupplierCriteria example);

    int deleteByExample(TOperatorSupplierCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorSupplier record);

    int insertSelective(TOperatorSupplier record);

    List<TOperatorSupplier> selectByExampleWithRowbounds(TOperatorSupplierCriteria example, RowBounds rowBounds);

    List<TOperatorSupplier> selectByExample(TOperatorSupplierCriteria example);

    TOperatorSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorSupplier record, @Param("example") TOperatorSupplierCriteria example);

    int updateByExample(@Param("record") TOperatorSupplier record, @Param("example") TOperatorSupplierCriteria example);

    int updateByPrimaryKeySelective(TOperatorSupplier record);

    int updateByPrimaryKey(TOperatorSupplier record);
}