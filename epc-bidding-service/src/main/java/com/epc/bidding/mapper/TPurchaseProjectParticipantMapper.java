package com.epc.bidding.mapper;

import com.epc.bidding.domain.TPurchaseProjectParticipant;
import com.epc.bidding.domain.TPurchaseProjectParticipantCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectParticipantMapper {
    int countByExample(TPurchaseProjectParticipantCriteria example);

    int deleteByExample(TPurchaseProjectParticipantCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectParticipant record);

    int insertSelective(TPurchaseProjectParticipant record);

    List<TPurchaseProjectParticipant> selectByExampleWithRowbounds(TPurchaseProjectParticipantCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectParticipant> selectByExample(TPurchaseProjectParticipantCriteria example);

    TPurchaseProjectParticipant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectParticipant record, @Param("example") TPurchaseProjectParticipantCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectParticipant record, @Param("example") TPurchaseProjectParticipantCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectParticipant record);

    int updateByPrimaryKey(TPurchaseProjectParticipant record);

    List<TPurchaseProjectParticipant> getAgencyInfo(Long procurementProjectId);
}