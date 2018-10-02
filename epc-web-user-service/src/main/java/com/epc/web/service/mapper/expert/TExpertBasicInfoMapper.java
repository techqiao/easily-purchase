package com.epc.web.service.mapper.expert;

import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.ExpertDto;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.purchaser.dto.QueryExpertDto;
import com.epc.web.facade.purchaser.vo.PurchaserExpertVo;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfoCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TExpertBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int countByExample(TExpertBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int deleteByExample(TExpertBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int insert(TExpertBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int insertSelective(TExpertBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    List<TExpertBasicInfo> selectByExampleWithRowbounds(TExpertBasicInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    List<TExpertBasicInfo> selectByExample(TExpertBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    TExpertBasicInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int updateByExampleSelective(@Param("record") TExpertBasicInfo record, @Param("example") TExpertBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int updateByExample(@Param("record") TExpertBasicInfo record, @Param("example") TExpertBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int updateByPrimaryKeySelective(TExpertBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_expert_basic_info
     *
     * @mbggenerated Fri Sep 14 11:18:37 CST 2018
     */
    int updateByPrimaryKey(TExpertBasicInfo record);


    TExpertBasicInfo selectExpertByNameAndCellPhone(@Param("expertName") String expertName, @Param("cellPhone") String cellPhone);


    List<AgencyExpertVo> selectExpertByCriteria(ExpertDto expertDto);

    LoginUser login(@Param("cellphone") String cellphone, @Param("pwd") String pwd);

    int registerUser(@Param("cellphone") String cellphone, @Param("pwd") String pwd, @Param("name") String name);

    List<PurchaserExpertVo> selectExpertByQueryCriteria(QueryExpertDto dto);

}