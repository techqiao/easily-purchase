package com.epc.user.service.controller.agency;

import com.epc.common.Result;
import com.epc.user.service.service.agency.AgencyService;
import com.epc.user.service.service.impl.agency.AgencyServiceImpl;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgencyController implements FacadeAgencyService {

    @Autowired
    AgencyService agencyService;
   /* @Autowired
    AgencyServiceImpl agencyService;*/


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
