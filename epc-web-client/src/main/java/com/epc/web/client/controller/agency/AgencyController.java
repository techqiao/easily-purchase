package com.epc.web.client.controller.agency;

import com.epc.common.Result;
import com.epc.web.client.controller.agency.dto.ClientAgencyExpertDto;
import com.epc.web.client.controller.agency.dto.ClientAgencySubjectDto;
import com.epc.web.client.controller.agency.dto.ClientAgencySupplierDto;
import com.epc.web.client.controller.agency.handle.ClientHandleAgency;
import com.epc.web.client.controller.agency.handle.ClientHandleEmployee;
import com.epc.web.client.controller.agency.handle.ClientHandleExpert;
import com.epc.web.client.controller.agency.handle.ClientHandleSupplier;
import com.epc.web.client.remoteApi.agency.AgencyClient;
import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.AgencySubjectDto;
import com.epc.web.facade.agency.dto.AgencySupplierDto;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
    public Result<Boolean > insertEmployee(@RequestBody ClientHandleEmployee employee) {
        HandleEmployee employee1 = new HandleEmployee();
        BeanUtils.copyProperties(employee,employee1);
        return agencyClient.insertEmployee(employee1);
    }

    @ApiOperation(value = "代理机构新增专家" , notes = "新增代理机构专家")
    @PostMapping(value = "/insertExpert")
    public Result<Boolean> insertExpert(@RequestBody ClientHandleExpert handleExpert) {
       HandleExpert expert = new HandleExpert();
       BeanUtils.copyProperties(handleExpert,expert);
        return agencyClient.insertExpert(expert);
    }

    @ApiOperation(value = "代理机构新增供货商" , notes = "新增代理机构供货商")
    @PostMapping(value = "/insertSupplier")
    public Result<Boolean> insertSupplier(@RequestBody ClientHandleSupplier handleSupplier) {
        HandleSupplier supplier=new HandleSupplier();
        BeanUtils.copyProperties(handleSupplier,supplier);
        return agencyClient.insertSupplier(supplier);
    }
    @ApiOperation(value = "代理机构注册" , notes = "注册")
    @PostMapping(value = "/regesityAgency")
    public Result<Boolean> regesityAgency(@RequestBody ClientHandleAgency agency) {
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
    public Result proxySubjects(ClientAgencySubjectDto clientAgencySubjectDto) {
        AgencySubjectDto subjectDto = new AgencySubjectDto();
        BeanUtils.copyProperties(clientAgencySubjectDto,subjectDto);
        return agencyClient.proxySubjects(subjectDto);
    }

    @ApiOperation(value = "代理机构按条件查询员工" , notes = "代理机构按条件查询员工")
    @PostMapping(value = "/queryEmployee")
    public Result queryEmployee(@RequestBody ClientHandleEmployee employee) {
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
    public Result updateEmployeeBy(@RequestBody ClientHandleEmployee employee) {
        HandleEmployee handleEmployee =new HandleEmployee();
        BeanUtils.copyProperties(employee,handleEmployee);
        return agencyClient.updateEmployeeBy(handleEmployee);
    }

    /**
     * @author :winlin
     * @Description : 封装条件查供应商
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @ApiOperation(value = "代理机构多条件查询供货商" , notes = "代理机多条件查询供货商")
    @PostMapping(value = "/querySuppilerCriteria")
    public Result<List<AgencySupplierVo>> querySupplierCriteria(@RequestBody ClientAgencySupplierDto supplierDto){
        AgencySupplierDto supplierDto1 = new AgencySupplierDto();
        BeanUtils.copyProperties(supplierDto,supplierDto1);
        return agencyClient.querySupplierCriteria(supplierDto1);
    }


    /**
     /**
     * @author :winlin
     * @Description :封装条件查询专家
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @ApiOperation(value = "代理机构多条件查询专家" , notes = "代理机构多条件查询专家")
    @PostMapping(value = "/queryExpertCriteria")
    public Result<List<AgencyExpertVo>> queryExpertCriteria(@RequestBody ClientAgencyExpertDto expertDto){
        AgencyExpertDto dto = new AgencyExpertDto();
        BeanUtils.copyProperties(expertDto,dto);
        return agencyClient.queryExpertCriteria(dto);
    };

    /**
     * @author :winlin
     * @Description :代理机构供应商完善自己的注册信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @ApiOperation(value = "代理机构完善供货商信息" , notes = "代理机构完善供货商信息")
    @PostMapping(value = "/completeAgencySupInfo")
    public Result<Boolean> completeAgencySupInfo(@RequestBody ClientAgencySupplierDto supplierDto){
        AgencySupplierDto dto = new AgencySupplierDto();
        BeanUtils.copyProperties(supplierDto,dto);
        return agencyClient.completeAgencySupInfo(dto);
    };

    /**
     * @author :winlin
     * @Description :代理机构专家完善自己个人信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @ApiOperation(value = "代理机构完善专家信息" , notes = "代理机构完善专家信息")
    @PostMapping(value = "/completeAgencyExpertInfo")
    public Result<Boolean> completeAgencyExpertInfo(@RequestBody ClientAgencyExpertDto expertDto){
        AgencyExpertDto dto = new AgencyExpertDto();
        BeanUtils.copyProperties(expertDto,dto);
        return agencyClient.completeAgencyExpertInfo(dto);
    };

}
