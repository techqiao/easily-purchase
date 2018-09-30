package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminRoleResource;
import com.epc.platform.service.domain.admin.SysAdminRoleResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminRoleResourceMapper {
    int countByExample(SysAdminRoleResourceCriteria example);

    int deleteByExample(SysAdminRoleResourceCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminRoleResource record);

    int insertSelective(SysAdminRoleResource record);

    List<SysAdminRoleResource> selectByExampleWithRowbounds(SysAdminRoleResourceCriteria example, RowBounds rowBounds);

    List<SysAdminRoleResource> selectByExample(SysAdminRoleResourceCriteria example);

    SysAdminRoleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminRoleResource record, @Param("example") SysAdminRoleResourceCriteria example);

    int updateByExample(@Param("record") SysAdminRoleResource record, @Param("example") SysAdminRoleResourceCriteria example);

    int updateByPrimaryKeySelective(SysAdminRoleResource record);

    int updateByPrimaryKey(SysAdminRoleResource record);

    /**
     * 传入用户的角色id返回对应资源id
     * @param roleId
     * @return
     */
    Long[] selectResourceByUserRole(Long roleId);
}