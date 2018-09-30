package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminUserRole;
import com.epc.platform.service.domain.admin.SysAdminUserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminUserRoleMapper {
    int countByExample(SysAdminUserRoleCriteria example);

    int deleteByExample(SysAdminUserRoleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminUserRole record);

    int insertSelective(SysAdminUserRole record);

    List<SysAdminUserRole> selectByExampleWithRowbounds(SysAdminUserRoleCriteria example, RowBounds rowBounds);

    List<SysAdminUserRole> selectByExample(SysAdminUserRoleCriteria example);

    SysAdminUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminUserRole record, @Param("example") SysAdminUserRoleCriteria example);

    int updateByExample(@Param("record") SysAdminUserRole record, @Param("example") SysAdminUserRoleCriteria example);

    int updateByPrimaryKeySelective(SysAdminUserRole record);

    int updateByPrimaryKey(SysAdminUserRole record);
}