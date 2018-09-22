package com.epc.web.service.mapper.agency;

import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.AgencySubjectDto;
import com.epc.web.facade.agency.dto.AgencySupplierDto;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySubjectsVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.agency.TAgencyBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    AgencyEmployeeVo queryEmployeeByCellphone(String cellphone);

    AgencyEmployeeVo queryEmployeeById(Long id);

    List<AgencyEmployeeVo> queryAllAgencyEmployees(Long agencyId);

    List<HandleAgency> queryAgencyByCrtiteria(HandleAgency agency);

    List<AgencySubjectsVo> proxySubjects(AgencySubjectDto subjectDto);

    List<AgencyEmployeeVo> queryAllAgencyEmployeesByCriteria(HandleEmployee employee);

    int updateEmployeeByCriteria(HandleEmployee employee);

    List<AgencySupplierVo> queryquerySupplierCriteria(AgencySupplierDto supplierDto);

    List<AgencyExpertVo> queryExpertByCriteria(AgencyExpertDto expertDto);

    int completeAgencySupInfo(AgencySupplierDto supplierDto);

    int completeAgencyExpertInfo(AgencyExpertDto expertDto);

    AgencySupplierVo querySupplierByName(AgencySupplierDto supplierDto);
}