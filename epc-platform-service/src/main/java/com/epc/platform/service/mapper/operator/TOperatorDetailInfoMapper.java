package com.epc.platform.service.mapper.operator;

import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.domain.operator.TOperatorDetailInfoCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TOperatorDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int countByExample(TOperatorDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int deleteByExample(TOperatorDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int insert(TOperatorDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int insertSelective(TOperatorDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    List<TOperatorDetailInfo> selectByExampleWithRowbounds(TOperatorDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    List<TOperatorDetailInfo> selectByExample(TOperatorDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    TOperatorDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int updateByExampleSelective(@Param("record") TOperatorDetailInfo record, @Param("example") TOperatorDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int updateByExample(@Param("record") TOperatorDetailInfo record, @Param("example") TOperatorDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int updateByPrimaryKeySelective(TOperatorDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operator_detail_info
     *
     * @mbggenerated Wed Sep 12 11:10:23 CST 2018
     */
    int updateByPrimaryKey(TOperatorDetailInfo record);

    /**
     * 根据名称查询
     * @param companyName
     * @return
     */
    List<TOperatorDetailInfo> selectByName(String companyName);
}