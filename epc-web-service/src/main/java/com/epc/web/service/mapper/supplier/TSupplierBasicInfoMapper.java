package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierBasicInfoMapper {
    int countByExample(TSupplierBasicInfoCriteria example);

    int deleteByExample(TSupplierBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TSupplierBasicInfo record);

    int insertSelective(TSupplierBasicInfo record);

    List<TSupplierBasicInfo> selectByExampleWithRowbounds(TSupplierBasicInfoCriteria example, RowBounds rowBounds);

    List<TSupplierBasicInfo> selectByExample(TSupplierBasicInfoCriteria example);

    TSupplierBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSupplierBasicInfo record, @Param("example") TSupplierBasicInfoCriteria example);

    int updateByExample(@Param("record") TSupplierBasicInfo record, @Param("example") TSupplierBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TSupplierBasicInfo record);

    int updateByPrimaryKey(TSupplierBasicInfo record);
}