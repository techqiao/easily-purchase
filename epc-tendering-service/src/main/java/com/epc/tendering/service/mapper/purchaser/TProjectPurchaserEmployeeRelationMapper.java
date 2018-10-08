package com.epc.tendering.service.mapper.purchaser;

import com.epc.tendering.service.domain.purchaser.TProjectPurchaserEmployeeRelation;
import com.epc.tendering.service.domain.purchaser.TProjectPurchaserEmployeeRelationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TProjectPurchaserEmployeeRelationMapper {
    int countByExample(TProjectPurchaserEmployeeRelationCriteria example);

    int deleteByExample(TProjectPurchaserEmployeeRelationCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TProjectPurchaserEmployeeRelation record);

    int insertSelective(TProjectPurchaserEmployeeRelation record);

    List<TProjectPurchaserEmployeeRelation> selectByExampleWithRowbounds(TProjectPurchaserEmployeeRelationCriteria example, RowBounds rowBounds);

    List<TProjectPurchaserEmployeeRelation> selectByExample(TProjectPurchaserEmployeeRelationCriteria example);

    TProjectPurchaserEmployeeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProjectPurchaserEmployeeRelation record, @Param("example") TProjectPurchaserEmployeeRelationCriteria example);

    int updateByExample(@Param("record") TProjectPurchaserEmployeeRelation record, @Param("example") TProjectPurchaserEmployeeRelationCriteria example);

    int updateByPrimaryKeySelective(TProjectPurchaserEmployeeRelation record);

    int updateByPrimaryKey(TProjectPurchaserEmployeeRelation record);
}