package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminResource;
import com.epc.platform.service.domain.admin.SysAdminResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int countByExample(SysAdminResourceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int deleteByExample(SysAdminResourceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int insert(SysAdminResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int insertSelective(SysAdminResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    List<SysAdminResource> selectByExampleWithRowbounds(SysAdminResourceCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    List<SysAdminResource> selectByExample(SysAdminResourceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    SysAdminResource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysAdminResource record, @Param("example") SysAdminResourceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int updateByExample(@Param("record") SysAdminResource record, @Param("example") SysAdminResourceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int updateByPrimaryKeySelective(SysAdminResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_resource
     *
     * @mbggenerated Mon Sep 10 16:49:57 CST 2018
     */
    int updateByPrimaryKey(SysAdminResource record);
}