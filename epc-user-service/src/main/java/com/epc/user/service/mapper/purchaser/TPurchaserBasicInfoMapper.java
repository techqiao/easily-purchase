package com.epc.user.service.mapper.purchaser;

import com.epc.user.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.user.service.domain.purchaser.TPurchaserBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int countByExample(TPurchaserBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int deleteByExample(TPurchaserBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int insert(TPurchaserBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int insertSelective(TPurchaserBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    List<TPurchaserBasicInfo> selectByExampleWithRowbounds(TPurchaserBasicInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    List<TPurchaserBasicInfo> selectByExample(TPurchaserBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    TPurchaserBasicInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int updateByExampleSelective(@Param("record") TPurchaserBasicInfo record, @Param("example") TPurchaserBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int updateByExample(@Param("record") TPurchaserBasicInfo record, @Param("example") TPurchaserBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int updateByPrimaryKeySelective(TPurchaserBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_purchaser_basic_info
     *
     * @mbggenerated Tue Sep 11 16:22:07 CST 2018
     */
    int updateByPrimaryKey(TPurchaserBasicInfo record);
}