package com.epc.web.client.controller.agency;

import com.epc.common.Result;
import com.epc.web.client.controller.agency.handle.ClientHandleAgency;
import com.epc.web.client.controller.agency.handle.ClientHandleEmployee;
import com.epc.web.client.controller.agency.handle.ClientHandleExpert;
import com.epc.web.client.controller.agency.handle.ClientHandleSupplier;
import com.epc.web.client.remoteApi.agency.AgencyClient;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
@Api(value = "代理机构",tags = {"代理机构服务"})
@RequestMapping(value = "/agency", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AgencyController {

    @Autowired
    AgencyClient agencyClient;

    @ApiOperation(value = "代理机构新增员工" , notes = "新增代理机构员工")
    @PostMapping(value = "/insertEmployeee")
    public Result insertEmployee(@RequestBody ClientHandleEmployee employee) {
        HandleEmployee employee1 = new HandleEmployee();
        BeanUtils.copyProperties(employee,employee1);
        return agencyClient.insertEmployee(employee1);
    }

    @ApiOperation(value = "代理机构新增专家" , notes = "新增代理机构专家")
    @PostMapping(value = "/insertExpert")
    public Result insertExpert(@RequestBody ClientHandleExpert handleExpert) {
       HandleExpert expert = new HandleExpert();
       BeanUtils.copyProperties(handleExpert,expert);
        return agencyClient.insertExpert(expert);
    }

    @ApiOperation(value = "代理机构新增供货商" , notes = "新增代理机构供货商")
    @PostMapping(value = "/insertSupplier")
    public Result insertSupplier(@RequestBody ClientHandleSupplier handleSupplier) {
        HandleSupplier supplier=new HandleSupplier();
        BeanUtils.copyProperties(handleSupplier,supplier);
        return agencyClient.insertSupplier(supplier);
    }
    @ApiOperation(value = "代理机构注册" , notes = "注册")
    @PostMapping(value = "/regesityAgency")
    public Result regesityAgency(@RequestBody ClientHandleAgency agency) {
        HandleAgency handleAgency=new HandleAgency();
        BeanUtils.copyProperties(agency,handleAgency);
        return agencyClient.regesityAgency(handleAgency);
    }
    @ApiOperation(value = "按条件查询代理机构" , notes = "按条件查询代理机构")
    @PostMapping(value = "/queryAgencies")
    public Result queryAgencies(@RequestBody ClientHandleAgency agency) {
        HandleAgency handleAgency=new HandleAgency();
        BeanUtils.copyProperties(agency,handleAgency);
        return agencyClient.queryAgencies(handleAgency);
    }

    @ApiOperation(value = "代理机构修改密码" , notes = "代理机构修改密码")
    @PostMapping(value = "/modifypassword")
    public Result modifypassword(@RequestBody ClientHandleAgency agency) {
        HandleAgency handleAgency=new HandleAgency();
        BeanUtils.copyProperties(agency,handleAgency);
        return agencyClient.modifypassword(handleAgency);
    }

    @ApiOperation(value = "代理机构注册完善信息" , notes = "代理机构注册完善信息")
    @PostMapping(value = "/completeInfo")
    public Result completeInfo(@RequestBody ClientHandleAgency agency) {
        HandleAgency handleAgency=new HandleAgency();
        BeanUtils.copyProperties(agency,handleAgency);
        return agencyClient.completeInfo(handleAgency);
    }

    @ApiOperation(value = "代理机构注册代理的所有项目" , notes = "代理机构注册代理的所有项目")
    @PostMapping(value = "/proxySubjects")
    public Result proxySubjects() {
        return agencyClient.proxySubjects();
    }

    @ApiOperation(value = "代理机构按条件查询员工" , notes = "代理机构按条件查询员工")
    @PostMapping(value = "/queryEmployee")
    public Result queryEmployee(@RequestBody  ClientHandleEmployee employee) {
        HandleEmployee handleEmployee =new HandleEmployee();
        BeanUtils.copyProperties(employee,handleEmployee);
        return agencyClient.queryEmployee(handleEmployee);
    }

    @ApiOperation(value = "代理机构按手机查询员工" , notes = "代理机构按手机查询员工")
    @PostMapping(value = "/queryEmployeeByCellphone")
    public Result queryEmployeeByCellphone(@RequestBody HashMap<String,String> map) {
        return agencyClient.queryEmployeeByCellphone(map);
    }
    @ApiOperation(value = "代理机构按id查询员工" , notes = "代理机id查询员工")
    @PostMapping(value = "/queryEmployeeById")
    public Result queryEmployeeById(@RequestBody HashMap<String,Long> map) {
        return agencyClient.queryEmployeeById(map);
    }

    @ApiOperation(value = "代理机构修改员工信息" , notes = "代理机构修改员工信息")
    @PostMapping(value = "/updateEmployeeBy")
    public Result updateEmployeeBy(@RequestBody  ClientHandleEmployee employee) {
        HandleEmployee handleEmployee =new HandleEmployee();
        BeanUtils.copyProperties(employee,handleEmployee);
        return agencyClient.updateEmployeeBy(handleEmployee);
    }
}
