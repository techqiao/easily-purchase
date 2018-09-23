package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TSupplierBasicInfo;
import com.epc.bidding.domain.bidding.TSupplierBasicInfoCriteria;
import java.util.List;

import com.epc.web.facade.bidding.dto.PersonDTO;
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

    List<PersonDTO> selectCompanyPerson(@Param("supplierId") Long supplierId);

}