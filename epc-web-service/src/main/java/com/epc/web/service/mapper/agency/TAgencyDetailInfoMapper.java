package com.epc.web.service.mapper.agency;


import com.epc.web.service.domain.agency.TAgencyDetailInfo;
import com.epc.web.service.domain.agency.TAgencyDetailInfoCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
public interface TAgencyDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int countByExample(TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int deleteByExample(TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int insert(TAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int insertSelective(TAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    List<TAgencyDetailInfo> selectByExampleWithRowbounds(TAgencyDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    List<TAgencyDetailInfo> selectByExample(TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    TAgencyDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int updateByExampleSelective(@Param("record") TAgencyDetailInfo record, @Param("example") TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int updateByExample(@Param("record") TAgencyDetailInfo record, @Param("example") TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int updateByPrimaryKeySelective(TAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 16:20:46 CST 2018
     */
    int updateByPrimaryKey(TAgencyDetailInfo record);
}