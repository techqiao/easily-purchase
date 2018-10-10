package com.epc.web.service.mapper.supplier;

import com.epc.web.facade.purchaser.dto.QuerySupplierDto;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierDetailInfoMapper {
    int countByExample(TSupplierDetailInfoCriteria example);

    int deleteByExample(TSupplierDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TSupplierDetailInfo record);

    int insertSelective(TSupplierDetailInfo record);

    List<TSupplierDetailInfo> selectByExampleWithRowbounds(TSupplierDetailInfoCriteria example, RowBounds rowBounds);

    List<TSupplierDetailInfo> selectByExample(TSupplierDetailInfoCriteria example);

    TSupplierDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    int updateByExample(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TSupplierDetailInfo record);

    int updateByPrimaryKey(TSupplierDetailInfo record);


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /*wenlin*/
    TSupplierDetailInfo selectTSupplierDetailInfoBySupplierId(Long supplierId);

    List<PurchaserSupplierVo> selectSupplierByCriteria(QuerySupplierDto dto);


}