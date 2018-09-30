package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.RoleWithSource;
import com.epc.platform.service.domain.admin.SysAdminRole;
import com.epc.platform.service.domain.admin.SysAdminRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminRoleMapper {
    int countByExample(SysAdminRoleCriteria example);

    int deleteByExample(SysAdminRoleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminRole record);

    int insertSelective(SysAdminRole record);

    List<SysAdminRole> selectByExampleWithRowbounds(SysAdminRoleCriteria example, RowBounds rowBounds);

    List<SysAdminRole> selectByExample(SysAdminRoleCriteria example);

    SysAdminRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminRole record, @Param("example") SysAdminRoleCriteria example);

    int updateByExample(@Param("record") SysAdminRole record, @Param("example") SysAdminRoleCriteria example);

    int updateByPrimaryKeySelective(SysAdminRole record);

    int updateByPrimaryKey(SysAdminRole record);


    List<RoleWithSource> findById(Long roleId);

    List<SysAdminRole> findUserRole(String userName);

    List<SysAdminRole> selectLikeName(String name);


}