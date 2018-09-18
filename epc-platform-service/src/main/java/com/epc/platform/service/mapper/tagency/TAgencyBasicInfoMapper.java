package com.epc.platform.service.mapper.tagency;

import com.epc.platform.service.domain.tagency.TAgencyBasicInfo;
import com.epc.platform.service.domain.tagency.TAgencyBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TAgencyBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int countByExample(TAgencyBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int deleteByExample(TAgencyBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int insert(TAgencyBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int insertSelective(TAgencyBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    List<TAgencyBasicInfo> selectByExampleWithRowbounds(TAgencyBasicInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    List<TAgencyBasicInfo> selectByExample(TAgencyBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    TAgencyBasicInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByExampleSelective(@Param("record") TAgencyBasicInfo record, @Param("example") TAgencyBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByExample(@Param("record") TAgencyBasicInfo record, @Param("example") TAgencyBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByPrimaryKeySelective(TAgencyBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_basic_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByPrimaryKey(TAgencyBasicInfo record);
}