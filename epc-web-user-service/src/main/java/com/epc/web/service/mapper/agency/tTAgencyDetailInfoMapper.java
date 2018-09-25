package com.epc.web.service.mapper.agency;

import com.epc.web.service.domain.agency.tTAgencyDetailInfo;
import com.epc.web.service.domain.agency.tTAgencyDetailInfoCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface tTAgencyDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int countByExample(tTAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int deleteByExample(tTAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int insert(tTAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int insertSelective(tTAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    List<tTAgencyDetailInfo> selectByExampleWithRowbounds(tTAgencyDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    List<tTAgencyDetailInfo> selectByExample(tTAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    tTAgencyDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int updateByExampleSelective(@Param("record") tTAgencyDetailInfo record, @Param("example") tTAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int updateByExample(@Param("record") tTAgencyDetailInfo record, @Param("example") tTAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int updateByPrimaryKeySelective(tTAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Thu Sep 13 21:04:40 CST 2018
     */
    int updateByPrimaryKey(tTAgencyDetailInfo record);
}