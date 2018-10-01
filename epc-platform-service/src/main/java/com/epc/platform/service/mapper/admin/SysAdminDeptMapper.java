package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminDept;
import com.epc.platform.service.domain.admin.SysAdminDeptCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminDeptMapper {
    int countByExample(SysAdminDeptCriteria example);

    int deleteByExample(SysAdminDeptCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminDept record);

    int insertSelective(SysAdminDept record);

    List<SysAdminDept> selectByExampleWithRowbounds(SysAdminDeptCriteria example, RowBounds rowBounds);

    List<SysAdminDept> selectByExample(SysAdminDeptCriteria example);

    SysAdminDept selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminDept record, @Param("example") SysAdminDeptCriteria example);

    int updateByExample(@Param("record") SysAdminDept record, @Param("example") SysAdminDeptCriteria example);

    int updateByPrimaryKeySelective(SysAdminDept record);

    int updateByPrimaryKey(SysAdminDept record);


    /** 删除父节点，子节点变成顶级节点（根据实际业务调整）
     * @param deptIds
     */
    void changeToTop(List<String> deptIds);
}