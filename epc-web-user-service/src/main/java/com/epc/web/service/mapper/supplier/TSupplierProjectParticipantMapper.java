package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.TSupplierProjectParticipant;
import com.epc.web.service.domain.supplier.TSupplierProjectParticipantCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierProjectParticipantMapper {
    int countByExample(TSupplierProjectParticipantCriteria example);

    int deleteByExample(TSupplierProjectParticipantCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TSupplierProjectParticipant record);

    int insertSelective(TSupplierProjectParticipant record);

    List<TSupplierProjectParticipant> selectByExampleWithRowbounds(TSupplierProjectParticipantCriteria example, RowBounds rowBounds);

    List<TSupplierProjectParticipant> selectByExample(TSupplierProjectParticipantCriteria example);

    TSupplierProjectParticipant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSupplierProjectParticipant record, @Param("example") TSupplierProjectParticipantCriteria example);

    int updateByExample(@Param("record") TSupplierProjectParticipant record, @Param("example") TSupplierProjectParticipantCriteria example);

    int updateByPrimaryKeySelective(TSupplierProjectParticipant record);

    int updateByPrimaryKey(TSupplierProjectParticipant record);


}