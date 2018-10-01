package com.epc.web.service.mapper.agency;

import com.epc.web.facade.agency.dto.AgencyEmployeeDto;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.agency.TAgencyBasicInfoCriteria;
import java.util.List;

import com.epc.web.service.domain.expert.TExpertBasicInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TAgencyBasicInfoMapper {
    int countByExample(TAgencyBasicInfoCriteria example);

    int deleteByExample(TAgencyBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TAgencyBasicInfo record);

    int insertSelective(TAgencyBasicInfo record);

    List<TAgencyBasicInfo> selectByExampleWithRowbounds(TAgencyBasicInfoCriteria example, RowBounds rowBounds);

    List<TAgencyBasicInfo> selectByExample(TAgencyBasicInfoCriteria example);

    TAgencyBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAgencyBasicInfo record, @Param("example") TAgencyBasicInfoCriteria example);

    int updateByExample(@Param("record") TAgencyBasicInfo record, @Param("example") TAgencyBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TAgencyBasicInfo record);

    int updateByPrimaryKey(TAgencyBasicInfo record);

    LoginUser login(@Param("cellphone") String cellphone, @Param("pwd") String pwd);


    int updateAgencyForbbiden(@Param("id") Long id, @Param("forbidden") Integer forbidden);

    int updateAgencyEmployeeRoleById(@Param("id")Long id, @Param("role")Integer role);

    int deleteAgencyExpertById(@Param("id")Long id, @Param("delete")Integer delete);


    int updateAgencyEmployeeDetail(TAgencyBasicInfo basicInfo);


    List<TAgencyBasicInfo> selectEmployee(AgencyEmployeeDto employee);


    TAgencyBasicInfo selectAgencyBasicByCellphoneAndName(@Param("name") String name, @Param("cellphone") String cellphone);
}