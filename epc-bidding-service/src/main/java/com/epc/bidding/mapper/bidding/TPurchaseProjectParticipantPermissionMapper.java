package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TPurchaseProjectParticipantPermission;
import com.epc.bidding.domain.bidding.TPurchaseProjectParticipantPermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectParticipantPermissionMapper {
    int countByExample(TPurchaseProjectParticipantPermissionCriteria example);

    int deleteByExample(TPurchaseProjectParticipantPermissionCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectParticipantPermission record);

    int insertSelective(TPurchaseProjectParticipantPermission record);

    List<TPurchaseProjectParticipantPermission> selectByExampleWithRowbounds(TPurchaseProjectParticipantPermissionCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectParticipantPermission> selectByExample(TPurchaseProjectParticipantPermissionCriteria example);

    TPurchaseProjectParticipantPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectParticipantPermission record, @Param("example") TPurchaseProjectParticipantPermissionCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectParticipantPermission record, @Param("example") TPurchaseProjectParticipantPermissionCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectParticipantPermission record);

    int updateByPrimaryKey(TPurchaseProjectParticipantPermission record);

    @Select(value = "SELECT * from t_purchase_project_participant_permission where 1=1 and participant_id='' and is_deleted=0")
    List<TPurchaseProjectParticipantPermission> getAgencyInfo(Long id);
}