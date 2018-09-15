package com.epc.web.client.controller.agency;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.agency.AgencyClient;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
@Api(value = "代理机构")
@RequestMapping(value = "/agency", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AgencyController  {

    @Autowired
    AgencyClient agencyClient;

    @ApiOperation(value = "代理机构新增员工" , tags = "新增代理机构员工")
    @PostMapping(value = "/insertEmployeee")
    public Result insertEmployee(HandleEmployee employee) {
        return agencyClient.insertEmployee(employee);
    }

    @ApiOperation(value = "代理机构新增专家" , tags = "新增代理机构专家")
    @PostMapping(value = "/insertExpert")
    public Result insertExpert(HandleExpert handleExpert) {
        return agencyClient.insertExpert(handleExpert);
    }

    @ApiOperation(value = "代理机构新增供货商" , tags = "新增代理机构供货商")
    @PostMapping(value = "/insertSupplier")
    public Result insertSupplier(HandleSupplier handleSupplier) {
        return agencyClient.insertSupplier(handleSupplier);
    }
}
