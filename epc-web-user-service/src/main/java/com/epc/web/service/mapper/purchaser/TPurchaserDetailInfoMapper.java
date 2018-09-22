package com.epc.web.service.mapper.purchaser;

import com.epc.web.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.web.service.domain.purchaser.TPurchaserDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int countByExample(TPurchaserDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int deleteByExample(TPurchaserDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int insert(TPurchaserDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int insertSelective(TPurchaserDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    List<TPurchaserDetailInfo> selectByExampleWithRowbounds(TPurchaserDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    List<TPurchaserDetailInfo> selectByExample(TPurchaserDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    TPurchaserDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") TPurchaserDetailInfo record, @Param("example") TPurchaserDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int updateByExample(@Param("record") TPurchaserDetailInfo record, @Param("example") TPurchaserDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int updateByPrimaryKeySelective(TPurchaserDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_detail_info
     *
     * @mbggenerated Thu Sep 13 16:31:58 CST 2018
     */
    int updateByPrimaryKey(TPurchaserDetailInfo record);
}