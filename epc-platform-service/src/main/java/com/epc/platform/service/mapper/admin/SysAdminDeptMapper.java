package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminDept;
import com.epc.platform.service.domain.admin.SysAdminDeptCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SysAdminDeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int countByExample(SysAdminDeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int deleteByExample(SysAdminDeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int insert(SysAdminDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int insertSelective(SysAdminDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    List<SysAdminDept> selectByExampleWithRowbounds(SysAdminDeptCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    List<SysAdminDept> selectByExample(SysAdminDeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    SysAdminDept selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysAdminDept record, @Param("example") SysAdminDeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int updateByExample(@Param("record") SysAdminDept record, @Param("example") SysAdminDeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int updateByPrimaryKeySelective(SysAdminDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_dept
     *
     * @mbggenerated Thu Sep 13 17:41:18 CST 2018
     */
    int updateByPrimaryKey(SysAdminDept record);

    // 删除父节点，子节点变成顶级节点（根据实际业务调整）
    void changeToTop(List<String> deptIds);
}