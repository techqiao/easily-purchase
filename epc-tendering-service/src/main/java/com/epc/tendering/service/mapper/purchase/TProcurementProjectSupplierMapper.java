package com.epc.tendering.service.mapper.purchase;

import com.epc.tendering.service.domain.purchase.TProcurementProjectSupplier;
import com.epc.tendering.service.domain.purchase.TProcurementProjectSupplierCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TProcurementProjectSupplierMapper {
    int countByExample(TProcurementProjectSupplierCriteria example);

    int deleteByExample(TProcurementProjectSupplierCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TProcurementProjectSupplier record);

    int insertSelective(TProcurementProjectSupplier record);

    List<TProcurementProjectSupplier> selectByExampleWithRowbounds(TProcurementProjectSupplierCriteria example, RowBounds rowBounds);

    List<TProcurementProjectSupplier> selectByExample(TProcurementProjectSupplierCriteria example);

    TProcurementProjectSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProcurementProjectSupplier record, @Param("example") TProcurementProjectSupplierCriteria example);

    int updateByExample(@Param("record") TProcurementProjectSupplier record, @Param("example") TProcurementProjectSupplierCriteria example);

    int updateByPrimaryKeySelective(TProcurementProjectSupplier record);

    int updateByPrimaryKey(TProcurementProjectSupplier record);
}