package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.domain.admin.SysAdminUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int countByExample(SysAdminUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int deleteByExample(SysAdminUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int insert(SysAdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int insertSelective(SysAdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    List<SysAdminUser> selectByExampleWithRowbounds(SysAdminUserCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    List<SysAdminUser> selectByExample(SysAdminUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    SysAdminUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysAdminUser record, @Param("example") SysAdminUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int updateByExample(@Param("record") SysAdminUser record, @Param("example") SysAdminUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int updateByPrimaryKeySelective(SysAdminUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user
     *
     * @mbggenerated Mon Sep 10 16:51:58 CST 2018
     */
    int updateByPrimaryKey(SysAdminUser record);
}