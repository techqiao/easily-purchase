package com.epc.tendering.service.mapper.purchaser;

import com.epc.tendering.service.domain.purchaser.TProjectEmployeeRelation;
import com.epc.tendering.service.domain.purchaser.TProjectEmployeeRelationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TProjectEmployeeRelationMapper {
    int countByExample(TProjectEmployeeRelationCriteria example);

    int deleteByExample(TProjectEmployeeRelationCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TProjectEmployeeRelation record);

    int insertSelective(TProjectEmployeeRelation record);

    List<TProjectEmployeeRelation> selectByExampleWithRowbounds(TProjectEmployeeRelationCriteria example, RowBounds rowBounds);

    List<TProjectEmployeeRelation> selectByExample(TProjectEmployeeRelationCriteria example);

    TProjectEmployeeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProjectEmployeeRelation record, @Param("example") TProjectEmployeeRelationCriteria example);

    int updateByExample(@Param("record") TProjectEmployeeRelation record, @Param("example") TProjectEmployeeRelationCriteria example);

    int updateByPrimaryKeySelective(TProjectEmployeeRelation record);

    int updateByPrimaryKey(TProjectEmployeeRelation record);
}