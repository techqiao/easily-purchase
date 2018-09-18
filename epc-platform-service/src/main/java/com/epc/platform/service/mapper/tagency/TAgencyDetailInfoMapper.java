package com.epc.platform.service.mapper.tagency;

import com.epc.platform.service.domain.tagency.TAgencyDetailInfo;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TAgencyDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int countByExample(TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int deleteByExample(TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int insert(TAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int insertSelective(TAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    List<TAgencyDetailInfo> selectByExampleWithRowbounds(TAgencyDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    List<TAgencyDetailInfo> selectByExample(TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    TAgencyDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByExampleSelective(@Param("record") TAgencyDetailInfo record, @Param("example") TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByExample(@Param("record") TAgencyDetailInfo record, @Param("example") TAgencyDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByPrimaryKeySelective(TAgencyDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_detail_info
     *
     * @mbggenerated Fri Sep 14 15:12:49 CST 2018
     */
    int updateByPrimaryKey(TAgencyDetailInfo record);
}