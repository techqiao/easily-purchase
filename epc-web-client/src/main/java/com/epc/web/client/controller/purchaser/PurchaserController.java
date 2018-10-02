package com.epc.web.client.controller.purchaser;

import com.epc.common.Result;
import com.epc.web.client.controller.purchaser.dto.*;
import com.epc.web.client.controller.purchaser.handle.*;
import com.epc.web.client.controller.supplier.handle.ClientHandleSupplierDetail;
import com.epc.web.client.remoteApi.purchaser.PurchaserClient;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.*;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.*;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.sun.deploy.util.SessionState;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

@Api(value = "采购人服务")
@RestController
@RequestMapping(value = "/purchaser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaserController {
    @Autowired
    PurchaserClient purchaserClient;

    /**
     * 新增采购人员工
     */
    @ApiOperation(value = "新增采购人机构员工")
    @PostMapping(value = "/clientcreatePurchaserUserInfo")
    Result<Boolean> createPurchaserUserInfo(@RequestBody ClientHandlePurchaser handleEmployee) {
        HandlePurchaser purchaser = new HandlePurchaser();
        BeanUtils.copyProperties(handleEmployee, purchaser);
        return purchaserClient.createPurchaserUserInfo(purchaser);
    }

    ;

    /**
     * @author :winlin
     * @Description :启用或禁用员工
     * @param:
     * @return:
     * @date:2018/9/29
     */
    @ApiOperation(value = "启用或禁用员工")
    @PostMapping(value = "/clientenableOrDisablePurchaserEmployee")
    public Result<Boolean> enableOrDisablePurchaserEmployee(@RequestBody ClientHandleTrustList trustList) {
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList, handleTrustList);
        return purchaserClient.enableOrDisablePurchaserEmployee(handleTrustList);
    }

    ;

    /**
     * @author :winlin
     * @Description :修改员工权限
     * @param:
     * @return:
     * @date:2018/9/30
     */
    @ApiOperation(value = "修改员工权限")
    @PostMapping(value = "/clienteupdatePurchaserEmployeeRole")
    public Result<Boolean> updatePurchaserEmployeeRole(@RequestBody ClientHandleTrustList trustList) {
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList, handleTrustList);
        return purchaserClient.updatePurchaserEmployeeRole(handleTrustList);
    }

    ;

    /**
     * @author :winlin
     * @Description :修改员工信息
     * @param:
     * @return:
     * @date:2018/9/30
     */
    @ApiOperation(value = "修改员工信息")
    @PostMapping(value = "/clientupdatePurchaserEmployeeInfo")
    public Result<Boolean> updatePurchaserEmployeeInfo(@RequestBody ClientHandlePurchaserDto handlePurchaser) {
        HandlePurchaserDto handlePurchaserDto = new HandlePurchaserDto();
        BeanUtils.copyProperties(handlePurchaser, handlePurchaserDto);
        return purchaserClient.updatePurchaserEmployeeInfo(handlePurchaserDto);

    }

    ;

    /**
     * @author :winlin
     * @Description :根据条件查询多有符合条件的员工
     * @param: name cellphone role
     * @return:
     * @date:2018/9/19
     */
    @ApiOperation(value = "根据条件查询多有符合条件的员工")
    @PostMapping(value = "/clientqueryEmplyee")
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(@RequestBody ClientEmployeeDto employeeDto) {
        HandleEmployeeDto dto = new HandleEmployeeDto();
        BeanUtils.copyProperties(employeeDto, dto);
        return purchaserClient.queryEmplyee(dto);
    }

    ;

    /**
     * 采购人新增专家
     *
     * @param handleExpert
     * @return
     */
    @ApiOperation(value = "采购人新增专家")
    @PostMapping(value = "/clientcreateExpertUserInfo")
    Result<Boolean> createExpertUserInfo(@RequestBody ClientHandleExpert handleExpert) {
        HandleExpert handleExpert1 = new HandleExpert();
        BeanUtils.copyProperties(handleExpert, handleExpert1);
        return purchaserClient.createExpertUserInfo(handleExpert1);
    }

    ;

    /**
     * @author :winlin
     * @Description :完善采购人专家信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @ApiOperation(value = "完善采购人专家信息")
    @PostMapping(value = "/clientcompletePurchaserExpertInfo")
    public Result<Boolean> completePurchaserExpertInfo(@RequestBody ClientHandleExpertDto expertDto) {
        HandleExpertDto handleExpertDto = new HandleExpertDto();
        BeanUtils.copyProperties(expertDto, handleExpertDto);
        return purchaserClient.completePurchaserExpertInfo(handleExpertDto);
    }

    ;

    /**
     * @author :winlin
     * @Description :删除评标专家 修改delete字段的属性值
     * @param:
     * @return:
     * @date:2018/9/30
     */
    @ApiOperation(value = "删除评标专家")
    @PostMapping(value = "/clientdeletePurchaserExpert")
    public Result<Boolean> deletePurchaserExpert(@RequestBody ClientHandleTrustList trustList) {
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList, handleTrustList);
        return purchaserClient.deletePurchaserExpert(handleTrustList);
    }

    ;

    /**
     * @author :winlin
     * @Description :根据综合条件查询所有专家
     * @param: HandlExpertDto综合信息
     * @return:
     * @date:2018/9/19
     */
    @ApiOperation(value = "启用或禁用员工")
    @PostMapping(value = "/clientqueryExperts")
    public Result<List<PurchaserExpertVo>> queryExperts(@RequestBody ClientQueryExpertDto dto) {
        QueryExpertDto queryExpertDto = new QueryExpertDto();
        BeanUtils.copyProperties(dto, queryExpertDto);
        return purchaserClient.queryExperts(queryExpertDto);
    }

    ;

    /**
     * 添加代理机构
     *
     * @param handleAgnecy
     * @return
     */
    @ApiOperation(value = "添加代理机构")
    @PostMapping(value = "/clientcreateAgencyUserInfo")
    Result<Boolean> createAgencyUserInfo(@RequestBody  ClientHandleAgnecy handleAgnecy){
        HandleAgnecy agnecy = new HandleAgnecy();
        BeanUtils.copyProperties(handleAgnecy,agnecy);
        return purchaserClient.createAgencyUserInfo(agnecy);
    };

    /**
     * 完善代理机构detail
     *
     * @param handleAgnecy
     * @return
     */
    @ApiOperation(value = "完善代理机构detail")
    @PostMapping(value = "/clientupdateAgencyDetail")
    Result<Boolean> updateAgencyDetail(@RequestBody  ClientHandleAgnecy handleAgnecy){
        HandleAgnecy agnecy = new HandleAgnecy();
        BeanUtils.copyProperties(handleAgnecy,agnecy);
        return purchaserClient.updateAgencyDetail(agnecy);
    };

    /**
     * @author :winlin
     * @Description :添加黑名单-agency
     * @param:
     * @return:
     * @date:2018/9/28
     */
    @ApiOperation(value = "添加黑名单-agency")
    @PostMapping(value = "/clientupdateTrustListForAgency")
    public Result<Boolean> updateTrustListForAgency(@RequestBody ClientHandleTrustList trustList){
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList,handleTrustList);
        return purchaserClient.updateTrustListForAgency(handleTrustList);
    };

    /**
     * @author :winlin
     * @Description :根据条件查询代理机构
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @ApiOperation(value = "根据条件查询代理机构")
    @PostMapping(value = "/clientqueryAgenciesByCriteria")
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(@RequestBody ClientQueryAgencyDto agencyDto){
        QueryAgencyDto queryAgencyDto = new QueryAgencyDto();
        BeanUtils.copyProperties(agencyDto,queryAgencyDto);
        return purchaserClient.queryAgenciesByCriteria(queryAgencyDto);
    };


    /**
     * 添加供应商(私库)
     *
     * @param handleOperator
     * @return
     */
    @ApiOperation(value = " 添加供应商")
    @PostMapping(value = "/clientcreateSupplierByPurchaser")
    Result<Boolean> createSupplierByPurchaser(@RequestBody ClientHandleSupplierDto handleOperator){
        HandleSupplierDto handleSupplierDto = new HandleSupplierDto();
        BeanUtils.copyProperties(handleOperator,handleSupplierDto);
        return purchaserClient.createSupplierByPurchaser(handleSupplierDto);
    };

    /**
     * 完善供货商信息detail
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "完善供货商信息detail")
    @PostMapping(value = "/clientupdateSupplierDetail")
    Result<Boolean> updateSupplierDetail(@RequestBody  ClientPurchaserHandleSupplierDto dto){
        PurchaserHandleSupplierDto purchaserHandleSupplierDto = new PurchaserHandleSupplierDto();
        BeanUtils.copyProperties(dto,purchaserHandleSupplierDto);
        return purchaserClient.updateSupplierDetail(purchaserHandleSupplierDto);
    };

    /**
     * @author :winlin
     * @Description :添加黑名单-supplier
     * @param:
     * @return:
     * @date:2018/9/28
     */
    @ApiOperation(value = "添加黑名单-supplier")
    @PostMapping(value = "/clientupdateTrustListForSupplier")
    public Result<Boolean> updateTrustListForSupplier(@RequestBody ClientHandleTrustList trustList){
        HandleTrustList handleTrustList = new HandleTrustList();
        BeanUtils.copyProperties(trustList,handleTrustList);
        return purchaserClient.updateTrustListForSupplier(handleTrustList);
    };

    /**
     * @author :winlin
     * @Description :
     * @param: 依据条件检索供应商
     * @return:
     * @date:2018/9/20
     */
    @ApiOperation(value = "依据条件检索供应商")
    @PostMapping(value = "/clientquerySupplierByCriterias")
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(@RequestBody ClientQuerySupplierDto supplierDto){
            QuerySupplierDto querySupplierDto = new QuerySupplierDto();
            BeanUtils.copyProperties(supplierDto,querySupplierDto);
            return purchaserClient.querySupplierByCriterias(querySupplierDto);
    };


    /**
     * 完善采购人信息detail
     *
     * @param handlePurchaser
     * @return
     */
    @ApiOperation(value = "完善采购人信息detail")
    @PostMapping(value = "/clientupdatePurchaserDetail")
    Result<Boolean> updatePurchaserDetail(@RequestBody  ClientHandleRegisterPurchaser handlePurchaser){
        HandleRegisterPurchaser handleRegisterPurchaser = new HandleRegisterPurchaser();
        BeanUtils.copyProperties(handlePurchaser,handleRegisterPurchaser);
        return purchaserClient.updatePurchaserDetail(handleRegisterPurchaser);
    };


    /**
     * @author :winlin
     * @Description : 根据id 查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @ApiOperation(value = "根据id 查询员工")
    @PostMapping(value = "/clientqueryEmployeeDto")
    public Result<PurchaserEmplyeeVo> queryEmployeeDto(@RequestBody ClientQueryDto dto){
        QueryDto queryDto = new QueryDto();
        BeanUtils.copyProperties(dto,queryDto);
        return purchaserClient.queryEmployeeDto(queryDto);
    };


    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @ApiOperation(value = "根据id查询供应商信息")
    @PostMapping(value = "/clientquerySuppliersDto")
    public Result<SupplierDetailVo> querySuppliersDto(@RequestBody ClientQueryDto dto){
        QueryDto queryDto = new QueryDto();
        BeanUtils.copyProperties(dto,queryDto);
        return purchaserClient.querySuppliersDto(queryDto);
    };

    /**
     * @author :winlin
     * @Description : id查询专家详情
     * @param:
     * @return:
     * @date:2018/10/2
     */
    @ApiOperation(value = "id查询专家详情")
    @PostMapping(value = "/clientqueryExpertDetailById")
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(@RequestBody ClientQueryDto dto) {
        QueryDto queryDto = new QueryDto();
        BeanUtils.copyProperties(dto,queryDto);
        return purchaserClient.queryExpertDetailById(queryDto);
    }

    ;


    /**
     * @author :winlin
     * @Description :依据id查询代理机构
     * @param:
     * @return:
     * @date:2018/10/2
     */
    @ApiOperation(value = "依据id查询代理机构")
    @PostMapping(value = "/clientqueryAgencyDetailById")
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(@RequestBody ClientQueryDto dto) {
        QueryDto queryDto = new QueryDto();
        BeanUtils.copyProperties(dto, queryDto);
        return purchaserClient.queryAgencyDetailById(queryDto);
    }

    ;


    public Result queryEmployee(@RequestParam Long userId) {
        return purchaserClient.queryEmployee(userId);
    }

}
