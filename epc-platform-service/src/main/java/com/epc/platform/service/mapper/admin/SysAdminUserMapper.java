package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.domain.admin.SysAdminUserCriteria;
import java.util.List;

import com.epc.platform.service.domain.admin.UserWithRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminUserMapper {
    int countByExample(SysAdminUserCriteria example);

    int deleteByExample(SysAdminUserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminUser record);

    int insertSelective(SysAdminUser record);

    List<SysAdminUser> selectByExampleWithRowbounds(SysAdminUserCriteria example, RowBounds rowBounds);

    List<SysAdminUser> selectByExample(SysAdminUserCriteria example);

    SysAdminUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminUser record, @Param("example") SysAdminUserCriteria example);

    int updateByExample(@Param("record") SysAdminUser record, @Param("example") SysAdminUserCriteria example);

    int updateByPrimaryKeySelective(SysAdminUser record);

    int updateByPrimaryKey(SysAdminUser record);

    UserWithRole findUserWithRole(Long userId);

    List<SysAdminUser> findUserWithDept(SysAdminUser user);
}