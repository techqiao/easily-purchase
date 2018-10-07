package com.epc.web.service.mapper.supplier;

import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;

import java.util.Date;
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


    /*wenlin*/

    TSupplierBasicInfo login(@Param("cellphone") String cellphone, @Param("pwd")String pwd);

    TSupplierBasicInfo selectSupplierBasicByNameAndCell(@Param("name") String name, @Param("cellphone") String cellphone);

    List<AgencySupplierVo> selectBasicInfo(@Param("id") Long agencyId, @Param("fuzzyName") String fuzzyName, @Param("supplierId") Long supplierId);

    int registerUser(@Param("cellphone") String cellphone, @Param("pwd") String pwd, @Param("name") String name, @Param("dates")Date date);

    int updateSupplierPassword(ModifyUser modifyUser);

    TSupplierBasicInfo selectSupplierBasicByCell(@Param("cell") String cell);

    TSupplierBasicInfo selectBossBasicInfoByPurchaserIdAndRole(@Param("supplierId") Long suuplierId, @Param("roleCorporation") int roleCorporation);
}