package com.epc.web.service.controller.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.dto.*;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertDetailVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.purchaser.dto.QueryDto;
import com.epc.web.facade.purchaser.handle.HandleTrustList;
import com.epc.web.service.service.agency.AgencyService;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;

/**
 * @author winlin
 */
@RestController
public class AgencyController implements FacadeAgencyService {

    @Autowired
    AgencyService agencyService;

    @Override
    public Result<Boolean> insertEmployee(@RequestBody HandleEmployee employee) {
        return agencyService.insertEmployee(employee);
    }

    @Override
    public Result<Boolean> enableOrDisableAgencyEmployee(HandleTrustList trustList) {
        return null;
    }

    @Override
    public Result<Boolean> insertExpert(@RequestBody HandleExpert handleExpert) {
        return agencyService.insertExpert(handleExpert);
    }

    @Override
    public Result insertSupplier(@RequestBody HandleSupplier handleSupplier) {
        return agencyService.insertSupplier(handleSupplier);
    }


    @Override
    public Result completeInfo(@RequestBody HandleAgency agency) {

        return agencyService.completeInfo(agency);
    }

    @Override
    public Result<AgencyEmployeeVo> queryEmployeeById(@RequestBody QueryDto dto) {
        return null;
    }

    @Override

    public Result queryEmployee(@RequestBody AgencyEmployeeDto employee) {

        return agencyService.queryEmployee(employee);
    }

    @Override

    public Result updateEmployeeBy(@RequestBody HandleEmployee employee) {

        return agencyService.updateEmployeeBy(employee);
    }
    @Override
    public Result<Boolean> updateAgencyEmployeeRoleById(@RequestBody HandleTrustList trustList) {
        return agencyService.updateAgencyEmployeeRoleById(trustList);
    }

    @Override
    public Result<List<AgencySupplierVo>> querySupplierCriteria(@RequestBody SupplierDto supplierDto) {
        return agencyService.querySupplierCriteria(supplierDto);
    }
    @Override
    public Result<AgencySupplierVo> queryAgencySupplierDetail(@RequestBody QueryDto dto) {
        return agencyService.queryAgencySupplierDetail(dto);
    }
    @Override
    public Result<List<AgencyExpertVo>> queryExpertCriteria(@RequestBody ExpertDto expertDto) {
        return agencyService.queryExpertCriteria(expertDto);
    }

    @Override
    public Result<AgencyExpertDetailVo> queryExpertDetailById(@RequestBody QueryDto dto) {
        return agencyService.queryExpertDetailById(dto);
    }

    @Override
    public Result<Boolean> completeAgencySupInfo(@RequestBody AgencySupplierDto supplierDto) {
        return agencyService.completeAgencySupInfo(supplierDto);
    }

    @Override
    public Result<Boolean> completeAgencyExpertInfo(@RequestBody AgencyExpertDto expertDto) {
        return agencyService.completeAgencyExpertInfo(expertDto);
    }

    @Override
    public Result<Boolean> deleteAgencyExpertById(@RequestBody HandleTrustList trustList) {
        return agencyService.deleteAgencyExpertById(trustList);
    }
}
