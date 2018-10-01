package com.epc.web.service.mapper.purchaser;

import com.epc.web.service.domain.purchaser.TPurchaserExpert;
import com.epc.web.service.domain.purchaser.TPurchaserExpertCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface TPurchaserExpertMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int countByExample(TPurchaserExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int deleteByExample(TPurchaserExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int insert(TPurchaserExpert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int insertSelective(TPurchaserExpert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    List<TPurchaserExpert> selectByExampleWithRowbounds(TPurchaserExpertCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    List<TPurchaserExpert> selectByExample(TPurchaserExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    TPurchaserExpert selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int updateByExampleSelective(@Param("record") TPurchaserExpert record, @Param("example") TPurchaserExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int updateByExample(@Param("record") TPurchaserExpert record, @Param("example") TPurchaserExpertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int updateByPrimaryKeySelective(TPurchaserExpert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_expert
     *
     * @mbggenerated Fri Sep 14 17:41:19 CST 2018
     */
    int updateByPrimaryKey(TPurchaserExpert record);


    int deleteExpertById(@Param("id") Long id, @Param("del") Integer delete);
}