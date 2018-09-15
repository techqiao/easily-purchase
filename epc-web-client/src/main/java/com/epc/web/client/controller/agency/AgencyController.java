package com.epc.web.client.controller.agency;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.agency.AgencyClient;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
@RequestMapping(value = "/agency", method = RequestMethod.POST)
@RestController
public class AgencyController implements FacadeAgencyService {

    @Autowired
    AgencyClient agencyClient;

    @PostMapping(value = "/insertEmployeee", consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    @Override
    public Result insertEmployee(HandleEmployee employee) {
        return agencyClient.insertEmployee(employee);
    }

    @PostMapping(value = "/insertExpert", consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    @Override
    public Result insertExpert(HandleExpert handleExpert) {
        return agencyClient.insertExpert(handleExpert);
    }

    @PostMapping(value = "/insertSupplier", consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    @Override
    public Result insertSupplier(HandleSupplier handleSupplier) {
        return agencyClient.insertSupplier(handleSupplier);
    }
}
