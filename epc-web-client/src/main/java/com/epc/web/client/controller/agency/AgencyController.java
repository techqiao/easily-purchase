package com.epc.web.client.controller.agency;

import com.epc.common.Result;
import com.epc.web.client.controller.agency.dto.*;
import com.epc.web.client.controller.agency.handle.ClientHandleAgency;
import com.epc.web.client.controller.agency.handle.ClientHandleEmployee;
import com.epc.web.client.controller.agency.handle.ClientHandleExpert;
import com.epc.web.client.controller.agency.handle.ClientHandleSupplier;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.loginuser.handle.ClientLoginUser;
import com.epc.web.client.controller.purchaser.dto.ClientQueryDto;
import com.epc.web.client.controller.purchaser.handle.ClientHandleTrustList;
import com.epc.web.client.remoteApi.agency.AgencyClient;
import com.epc.web.facade.agency.dto.*;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.purchaser.dto.QueryDto;
import com.epc.web.facade.purchaser.handle.HandleTrustList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
@Api(value = "代理机构")
@RequestMapping(value = "/agency", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AgencyController extends BaseController {

    @Autowired
    AgencyClient agencyClient;

    @ApiOperation(value = "代理机构新增员工" )
    @PostMapping(value = "/insertAgencyEmployeee")
    public Result<Boolean > insertEmployee(@RequestBody ClientHandleEmployee employee) {
        HandleEmployee employee1 = new HandleEmployee();
        ClientLoginUser clientLoginUser = super.getLoginUser();
        if(null !=clientLoginUser) {
            if (StringUtils.isEmpty(clientLoginUser.getBossId())) {
                return Result.error("请先完善个人信息!");
            }
            employee1.setAgencyId(clientLoginUser.getBossId());
            BeanUtils.copyProperties(employee, employee1);
            return agencyClient.insertEmployee(employee1);
        }
        return Result.success("请先登录,谢谢!",true);
    }

    @ApiOperation(value = "代理机构新增专家" )
    @PostMapping(value = "/insertAgencyExpert")
    public Result<Boolean> insertExpert(@RequestBody ClientHandleExpert handleExpert) {
       HandleExpert expert = new HandleExpert();
        ClientLoginUser clientLoginUser = super.getLoginUser();
        if(null !=clientLoginUser) {
            if (StringUtils.isEmpty(clientLoginUser.getBossId())) {
                return Result.error("请先完善个人信息!");
            }
            expert.setInvterCompanyId(clientLoginUser.getBossId() + "");
            expert.setInviterid(clientLoginUser.getUserId());
            BeanUtils.copyProperties(handleExpert, expert);
            return agencyClient.insertExpert(expert);
        }
        return Result.success("请先登录,谢谢!",true);
    }

    @ApiOperation(value = "代理机构新增供货商")
    @PostMapping(value = "/insertAgencySupplier")
    public Result<Boolean> insertSupplier(@RequestBody ClientHandleSupplier handleSupplier) {
        HandleSupplier supplier=new HandleSupplier();
        ClientLoginUser clientLoginUser = super.getLoginUser();
        if(null !=clientLoginUser) {
            if (StringUtils.isEmpty(clientLoginUser.getBossId())) {
                return Result.error("请先完善个人信息!");
            }
            supplier.setInviterCompanyId(clientLoginUser.getBossId().intValue());
            supplier.setInviterId(clientLoginUser.getUserId());
            BeanUtils.copyProperties(handleSupplier, supplier);
            return agencyClient.insertSupplier(supplier);
        }
        return Result.success("请先登录,谢谢!",true);
    }


    @ApiOperation(value = "代理机构完善信息" )
    @PostMapping(value = "/completeInfo")
    public Result completeInfo(@RequestBody ClientHandleAgency agency) {
        HandleAgency handleAgency=new HandleAgency();
//        ClientLoginUser clientLoginUser = super.getLoginUser();
//        if(null !=clientLoginUser) {
            BeanUtils.copyProperties(agency, handleAgency);
            return agencyClient.completeInfo(handleAgency);
//        }
//        return Result.success("请先登录,谢谢!",true);
    }


    @ApiOperation(value = "代理机构按条件查询员工" )
    @PostMapping(value = "/queryEmployee")
    public Result queryEmployee(@RequestBody ClientAgencyEmployeeDto employee) {
        AgencyEmployeeDto handleEmployee =new AgencyEmployeeDto();
        ClientLoginUser clientLoginUser = super.getLoginUser();
        if(null !=clientLoginUser) {
            if (StringUtils.isEmpty(clientLoginUser.getBossId())) {
                return Result.error("请先完善个人信息!");
            }
            handleEmployee.setAgencyId(clientLoginUser.getBossId());
            BeanUtils.copyProperties(employee, handleEmployee);
            return agencyClient.queryEmployee(handleEmployee);
        }
        return Result.success("请先登录,谢谢!",true);
    }


    @ApiOperation(value = "代理机构修改员工信息" )
    @PostMapping(value = "/updateEmployeeBy")
    public Result updateEmployeeBy(@RequestBody ClientHandleEmployee employee) {
        HandleEmployee handleEmployee =new HandleEmployee();
        ClientLoginUser clientLoginUser = super.getLoginUser();
        if(null!=clientLoginUser) {
            BeanUtils.copyProperties(employee, handleEmployee);
            return agencyClient.updateEmployeeBy(handleEmployee);
        }
        return Result.success("请先登录,谢谢!",true);
    }

    /**
     * @author :winlin
     * @Description : 封装条件查供应商
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @ApiOperation(value = "代理机构多条件查询供货商" )
    @PostMapping(value = "/querySuppilerCriteria")
    public Result<List<AgencySupplierVo>> querySupplierCriteria(@RequestBody ClientSupplierDto supplierDto){
        SupplierDto supplierDto1 = new SupplierDto();
        ClientLoginUser clientLoginUser = super.getLoginUser();
        if(null!=clientLoginUser) {
            if (StringUtils.isEmpty(clientLoginUser.getBossId())) {
                return Result.error("请先完善个人信息!");
            }
            supplierDto1.setAgencyId(clientLoginUser.getBossId());
            BeanUtils.copyProperties(supplierDto, supplierDto1);
            return agencyClient.querySupplierCriteria(supplierDto1);
        }
        return null;
    }


    /**
     /**
     * @author :winlin
     * @Description :封装条件查询专家
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @ApiOperation(value = "代理机构多条件查询专家" )
    @PostMapping(value = "/queryExpertCriteria")
    public Result<List<AgencyExpertVo>> queryExpertCriteria(@RequestBody ClientExpertDto expertDto){
        ExpertDto dto = new ExpertDto();
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
    @ApiOperation(value = "代理机构完善供货商信息" )
    @PostMapping(value = "/completeAgencySupInfo")
    public Result<Boolean> completeAgencySupInfo(@RequestBody ClientAgencySupplierDto supplierDto){
        AgencySupplierDto dto = new AgencySupplierDto();
        ClientLoginUser loginUser = super.getLoginUser();
        if (null!=loginUser) {
            BeanUtils.copyProperties(supplierDto, dto);
            dto.setOperatorId(loginUser.getUserId());
            dto.setAgencyId(loginUser.getBossId());
            return agencyClient.completeAgencySupInfo(dto);
        }
        return Result.success("请先登录,谢谢!",true);
    };

    /**
     * @author :winlin
     * @Description :代理机构专家完善自己个人信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @ApiOperation(value = "代理机构完善专家信息+专家登录完善信息")
    @PostMapping(value = "/completeAgencyExpertInfo")
    public Result<Boolean> completeAgencyExpertInfo(@RequestBody ClientAgencyExpertDto expertDto){
        AgencyExpertDto dto = new AgencyExpertDto();
        ClientLoginUser loginUser = super.getLoginUser();
        if (null!=loginUser){
            dto.setInviterId(loginUser.getUserId());
            dto.setInviterCompanyId(loginUser.getBossId());
            dto.setAgencyId(loginUser.getCompanyId());
            BeanUtils.copyProperties(expertDto, dto);
            return agencyClient.completeAgencyExpertInfo(dto);
        }
        return Result.success("请先登录,谢谢!",true);
    };
    /**
     * @author :winlin
     * @Description :根据id查询员工信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @ApiOperation(value = "根据id查询员工信息")
    @PostMapping(value = "/clientqueryEmployeeById")
    public Result<AgencyEmployeeVo> queryEmployeeById(@RequestBody ClientQueryDto dto){
        QueryDto queryDto = new QueryDto();
        BeanUtils.copyProperties(dto,queryDto);
        return agencyClient.queryEmployeeById(queryDto);
    };

    /**
     *@author :winlin
     *@Description :依据id查询供货商详情
     *@param:
     *@return:
     *@date:2018/10/1
     */
    @ApiOperation(value = "依据id查询供货商详情")
    @PostMapping(value = "/clientqueryAgencySupplierDetail")
    public Result<AgencySupplierVo> queryAgencySupplierDetail(@RequestBody ClientQueryDto dto){
            QueryDto queryDto = new QueryDto();
            BeanUtils.copyProperties(dto,queryDto);
            return agencyClient.queryAgencySupplierDetail(queryDto);
    };
    /**
     *@author :winlin
     *@Description :依据id修改员工权限
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @ApiOperation(value = "依据id修改员工权限")
    @PostMapping(value = "/clientupdateAgencyEmployeeRoleById")
    public Result<Boolean> updateAgencyEmployeeRoleById(@RequestBody ClientHandleTrustList trustList){
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList,handleTrustList);
        return agencyClient.updateAgencyEmployeeRoleById(handleTrustList);
    };
    /**
     *@author :winlin
     *@Description :删除专家 修改is_delete的字段属性
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @ApiOperation(value = "删除专家")
    @PostMapping(value = "/clientdeleteAgencyExpertById")
    public Result<Boolean> deleteAgencyExpertById(@RequestBody ClientHandleTrustList trustList){
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList,handleTrustList);
        return agencyClient.deleteAgencyExpertById(handleTrustList);
    };

}
