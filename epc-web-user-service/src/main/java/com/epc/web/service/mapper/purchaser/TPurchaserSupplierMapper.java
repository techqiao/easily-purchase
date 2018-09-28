package com.epc.web.service.mapper.purchaser;

import com.epc.web.facade.purchaser.handle.HandleTrustList;
import com.epc.web.service.domain.purchaser.TPurchaserSupplier;
import com.epc.web.service.domain.purchaser.TPurchaserSupplierCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserSupplierMapper {
    int countByExample(TPurchaserSupplierCriteria example);

    int deleteByExample(TPurchaserSupplierCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserSupplier record);

    int insertSelective(TPurchaserSupplier record);

    List<TPurchaserSupplier> selectByExampleWithRowbounds(TPurchaserSupplierCriteria example, RowBounds rowBounds);

    List<TPurchaserSupplier> selectByExample(TPurchaserSupplierCriteria example);

    TPurchaserSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserSupplier record, @Param("example") TPurchaserSupplierCriteria example);

    int updateByExample(@Param("record") TPurchaserSupplier record, @Param("example") TPurchaserSupplierCriteria example);

    int updateByPrimaryKeySelective(TPurchaserSupplier record);

    int updateByPrimaryKey(TPurchaserSupplier record);

    int updateTrustList(HandleTrustList trustList);
}