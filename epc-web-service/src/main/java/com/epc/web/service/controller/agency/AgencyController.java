package com.epc.web.service.controller.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.service.service.agency.AgencyService;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "regesityAgency", consumes = "application/json; charset=UTF-8")
    @Override
    public Result regesityAgency(HandleAgency agency) {
        return agencyService.regesityAgency(agency);
    }

    @Override
    public Result queryAgencies(HandleAgency agency) {
        return agencyService.queryAgencies(agency);
    }

    @Override
    public Result modifypassword(HandleAgency agency) {
        return agencyService.modifypassword(agency);
    }

    @Override
    public Result completeInfo(HandleAgency agency) {
        return agencyService.completeInfo(agency);
    }

    @Override
    public Result proxySubjects() {
        return agencyService.proxySubjects();
    }

    @Override
    public Result queryEmployee(HandleEmployee employee) {
        return agencyService.queryEmployee(employee);
    }

    @Override
    public Result queryEmployeeByCellphone(String cellphone) {
        return agencyService.queryEmployeeByCellphone(cellphone);
    }

    @Override
    public Result queryEmployeeById(Long id) {
        return agencyService.queryEmployeeById(id);
    }

    @Override
    public Result updateEmployeeBy(HandleEmployee employee) {
        return agencyService.updateEmployeeBy(employee);
    }
}
