package com.epc.web.service.controller.agency;

import com.epc.common.Result;
import com.epc.web.service.service.agency.AgencyService;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.beans.factory.annotation.Autowired;
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
}
