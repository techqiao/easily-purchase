package com.epc.tendering.service.mapper.signup;

import com.epc.tendering.service.domain.signup.BInvitation;
import com.epc.tendering.service.domain.signup.BInvitationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BInvitationMapper {
    int countByExample(BInvitationCriteria example);

    int deleteByExample(BInvitationCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BInvitation record);

    int insertSelective(BInvitation record);

    List<BInvitation> selectByExampleWithRowbounds(BInvitationCriteria example, RowBounds rowBounds);

    List<BInvitation> selectByExample(BInvitationCriteria example);

    BInvitation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BInvitation record, @Param("example") BInvitationCriteria example);

    int updateByExample(@Param("record") BInvitation record, @Param("example") BInvitationCriteria example);

    int updateByPrimaryKeySelective(BInvitation record);

    int updateByPrimaryKey(BInvitation record);
}