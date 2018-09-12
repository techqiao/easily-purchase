package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminUserOperator;
import com.epc.platform.service.domain.admin.SysAdminUserOperatorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminUserOperatorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int countByExample(SysAdminUserOperatorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int deleteByExample(SysAdminUserOperatorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int insert(SysAdminUserOperator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int insertSelective(SysAdminUserOperator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    List<SysAdminUserOperator> selectByExampleWithRowbounds(SysAdminUserOperatorCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    List<SysAdminUserOperator> selectByExample(SysAdminUserOperatorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    SysAdminUserOperator selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysAdminUserOperator record, @Param("example") SysAdminUserOperatorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int updateByExample(@Param("record") SysAdminUserOperator record, @Param("example") SysAdminUserOperatorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int updateByPrimaryKeySelective(SysAdminUserOperator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin_user_operator
     *
     * @mbggenerated Mon Sep 10 16:52:31 CST 2018
     */
    int updateByPrimaryKey(SysAdminUserOperator record);
}