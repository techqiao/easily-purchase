package com.epc.web.service.mapper.supplier;

import com.epc.web.facade.supplier.vo.SupplierCategoryVo;
import com.epc.web.service.domain.supplier.SupplierCategory;
import com.epc.web.service.domain.supplier.SupplierCategoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SupplierCategoryMapper {
    int countByExample(SupplierCategoryCriteria example);

    int deleteByExample(SupplierCategoryCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SupplierCategory record);

    int insertSelective(SupplierCategory record);

    List<SupplierCategory> selectByExampleWithRowbounds(SupplierCategoryCriteria example, RowBounds rowBounds);

    List<SupplierCategory> selectByExample(SupplierCategoryCriteria example);

    SupplierCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupplierCategory record, @Param("example") SupplierCategoryCriteria example);

    int updateByExample(@Param("record") SupplierCategory record, @Param("example") SupplierCategoryCriteria example);

    int updateByPrimaryKeySelective(SupplierCategory record);

    int updateByPrimaryKey(SupplierCategory record);

    List<SupplierCategoryVo> selectCategory(@Param("supplierCategory") String supplierCategory);

}