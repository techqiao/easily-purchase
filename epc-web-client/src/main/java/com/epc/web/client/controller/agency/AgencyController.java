package com.epc.web.client.controller.agency;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.agency.AgencyClient;
import com.epc.web.facade.agency.FacadeAgencyService;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
@Api(value = "代理机构",tags = {"代理机构服务"})
@RequestMapping(value = "/agency", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AgencyController  {

    @Autowired
    AgencyClient agencyClient;

    @ApiOperation(value = "代理机构新增员工" , notes = "新增代理机构员工")
    @PostMapping(value = "/insertEmployeee")
    public Result insertEmployee(@RequestBody HandleEmployee employee) {
        return agencyClient.insertEmployee(employee);
    }

    @ApiOperation(value = "代理机构新增专家" , notes = "新增代理机构专家")
    @PostMapping(value = "/insertExpert")
    public Result insertExpert(@RequestBody HandleExpert handleExpert) {
        return agencyClient.insertExpert(handleExpert);
    }

    @ApiOperation(value = "代理机构新增供货商" , notes = "新增代理机构供货商")
    @PostMapping(value = "/insertSupplier")
    public Result insertSupplier(@RequestBody HandleSupplier handleSupplier) {
        return agencyClient.insertSupplier(handleSupplier);
    }
}
