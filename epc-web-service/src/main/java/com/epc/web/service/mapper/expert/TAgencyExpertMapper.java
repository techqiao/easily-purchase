package com.epc.web.service.mapper.expert;

import com.epc.web.service.domain.expert.TAgencyExpert;
import com.epc.web.service.domain.expert.TAgencyExpertCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TAgencyExpertMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int countByExample(TAgencyExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int deleteByExample(TAgencyExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int insert(TAgencyExpert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int insertSelective(TAgencyExpert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    List<TAgencyExpert> selectByExampleWithRowbounds(TAgencyExpertCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    List<TAgencyExpert> selectByExample(TAgencyExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    TAgencyExpert selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") TAgencyExpert record, @Param("example") TAgencyExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int updateByExample(@Param("record") TAgencyExpert record, @Param("example") TAgencyExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int updateByPrimaryKeySelective(TAgencyExpert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_agency_expert
     *
     * @mbggenerated Fri Sep 14 11:19:33 CST 2018
     */
    int updateByPrimaryKey(TAgencyExpert record);
}