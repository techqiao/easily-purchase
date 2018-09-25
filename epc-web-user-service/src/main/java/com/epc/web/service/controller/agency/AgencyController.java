package com.epc.web.service.controller.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.AgencySubjectDto;
import com.epc.web.facade.agency.dto.AgencySupplierDto;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.service.service.agency.AgencyService;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Result insertEmployee(@RequestBody HandleEmployee employee) {
        return agencyService.insertEmployee(employee);
    }

    @Override
    public Result insertExpert(@RequestBody HandleExpert handleExpert) {
        return agencyService.insertExpert(handleExpert);
    }

    @Override
    public Result insertSupplier( @RequestBody HandleSupplier handleSupplier) {
        return agencyService.insertSupplier(handleSupplier);
    }


    @Override
    public Result regesityAgency(@RequestBody HandleAgency agency) {
        return agencyService.regesityAgency(agency);
    }

    @Override

    public Result<List<HandleAgency>>  queryAgencies(@RequestBody HandleAgency agency) {

        return agencyService.queryAgencies(agency);
    }

    @Override

    public Result modifypassword( @RequestBody HandleAgency agency) {

        return agencyService.modifypassword(agency);
    }

    @Override

    public Result completeInfo( @RequestBody HandleAgency agency) {

        return agencyService.completeInfo(agency);
    }

    @Override
    public Result proxySubjects(AgencySubjectDto subjectDto) {
        return agencyService.proxySubjects( subjectDto);
    }

    @Override

    public Result queryEmployee( @RequestBody HandleEmployee employee) {

        return agencyService.queryEmployee(employee);
    }

    @Override
    public Result queryEmployeeByCellphone(@RequestBody HashMap<String,String> map) {
        String cellphone = map.get("cellphone");
        return agencyService.queryEmployeeByCellphone(cellphone);
    }

    @Override

    public Result queryEmployeeById(@RequestBody HashMap<String,Long> map) {
        Long id = map.get("id");

        return agencyService.queryEmployeeById(id);
    }

    @Override

    public Result updateEmployeeBy( @RequestBody HandleEmployee employee) {

        return agencyService.updateEmployeeBy(employee);
    }

    @Override
    public Result<List<AgencyEmployeeVo>> queryAllEmployee(@RequestBody HashMap<String, Long> map) {
        Long agencyId = map.get("agencyId");
        return agencyService.queryAllEmployee(agencyId);
    }

    @Override
    public Result<List<AgencySupplierVo>> querySupplierCriteria(@RequestBody AgencySupplierDto supplierDto) {
        return agencyService.querySupplierCriteria(supplierDto);
    }

    @Override
    public Result<List<AgencyExpertVo>> queryExpertCriteria(@RequestBody AgencyExpertDto expertDto) {
        return agencyService.queryExpertCriteria(expertDto);
    }

    @Override
    public Result<Boolean> completeAgencySupInfo(@RequestBody AgencySupplierDto supplierDto) {
        return agencyService.completeAgencySupInfo(supplierDto);
    }

    @Override
    public Result<Boolean> completeAgencyExpertInfo(@RequestBody AgencyExpertDto expertDto) {
        return agencyService.completeAgencyExpertInfo(expertDto);
    }
}
