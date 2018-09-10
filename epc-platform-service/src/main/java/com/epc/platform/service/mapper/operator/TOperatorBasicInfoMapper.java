package com.epc.platform.service.mapper.operator;

import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.domain.operator.TOperatorBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOperatorBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int countByExample(TOperatorBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int deleteByExample(TOperatorBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int insert(TOperatorBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int insertSelective(TOperatorBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    List<TOperatorBasicInfo> selectByExampleWithRowbounds(TOperatorBasicInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    List<TOperatorBasicInfo> selectByExample(TOperatorBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    TOperatorBasicInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") TOperatorBasicInfo record, @Param("example") TOperatorBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int updateByExample(@Param("record") TOperatorBasicInfo record, @Param("example") TOperatorBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int updateByPrimaryKeySelective(TOperatorBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_basic_info
     *
     * @mbggenerated Mon Sep 10 17:49:45 CST 2018
     */
    int updateByPrimaryKey(TOperatorBasicInfo record);
}