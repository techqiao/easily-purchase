package com.epc.web.client.controller.purchaser;

import com.epc.common.Result;
import com.epc.web.client.controller.purchaser.dto.ClientHandleAgencyDto;
import com.epc.web.client.controller.purchaser.dto.ClientHandleEmployeeDto;
import com.epc.web.client.controller.purchaser.dto.ClientHandleExpertDto;
import com.epc.web.client.controller.purchaser.dto.ClientHandleSupplierDto;
import com.epc.web.client.controller.purchaser.handle.*;
import com.epc.web.client.controller.supplier.handle.ClientHandleSupplierDetail;
import com.epc.web.client.remoteApi.purchaser.PurchaserClient;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.HandleAgencyDto;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.dto.HandleSupplierDto;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.PurchaserAgencyVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

@Api(value = "采购人服务",tags = {"采购人服务"})
@RestController
@RequestMapping(value = "/purchaser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaserController  {
    @Autowired
    PurchaserClient purchaserClient;

    @ApiOperation(value = "注册采购人员",notes = "注册采购人员")
    @PostMapping(value = "/registerPurchaseBasicInfo")
    public Result<Boolean> createPurchaseBasicInfo(@RequestBody ClientHandlePurchaser handlePurchaser) {
        HandlePurchaser purchaser = new HandlePurchaser();
        BeanUtils.copyProperties(handlePurchaser,purchaser);
        return purchaserClient.createPurchaseBasicInfo(purchaser);
    }

    /**
     *@author :winlin
     *@Description :启用或禁用员工
     *@param:
     *@return:
     *@date:2018/9/29
     */
    @ApiModelProperty(value = "采购人启用或禁用员工")
    public Result<Boolean> enableOrDisablePurchaserEmployee(ClientHandleTrustList trustList){
            HandleTrustList handleTrustList = new HandleTrustList();
            BeanUtils.copyProperties(trustList,handleTrustList);
            return purchaserClient.enableOrDisablePurchaserEmployee(handleTrustList);
    };

    @ApiOperation(value = "注册供应商",notes = "注册供应商")
    @PostMapping(value = "/registerSupplierBasicInfo")
    public Result<Boolean> createSupplierByPurchaser(@RequestBody ClientHandleSupplierDto handleSupplierDetail) {
        HandleSupplierDto supplierDetail = new HandleSupplierDto();
        BeanUtils.copyProperties(handleSupplierDetail,supplierDetail);
        return purchaserClient.createSupplierByPurchaser(supplierDetail);
    }

    @ApiOperation(value = "注册专家",notes = "注册专家")
    @PostMapping(value = "/registerExpertBasicInfo")
    public Result<Boolean> createExpertByPurchaser(@RequestBody ClientHandleExpert handleExpert) {
        HandleExpert expert = new HandleExpert();
        BeanUtils.copyProperties(handleExpert,expert);
        return purchaserClient.createExpertByPurchaser(expert);
    }

    @ApiOperation(value = "注册代理机构",notes = "注册代理机构")
    @PostMapping(value = "/registerAgencyBasicInfo")
    public Result<Boolean> createAgencyByPurchaser(@RequestBody ClientHandleAgnecy handleAgnecy) {
        HandleAgnecy agnecy = new HandleAgnecy();
        BeanUtils.copyProperties(handleAgnecy,agnecy);
        return purchaserClient.createAgencyByPurchaser(agnecy);
    }

//    @ApiOperation(value = "完善采购人信息",notes = "完善采购人信息")
//    @PostMapping(value = "/updatePurchaserDetail")
//    public Result<Boolean> updatePurchaserDetail(@RequestBody ClientHandleRegisterPurchaser handlePurchaser) {
//        HandleRegisterPurchaser purchaser = new HandleRegisterPurchaser();
//        BeanUtils.copyProperties(handlePurchaser,purchaser);
//        return purchaserClient.updatePurchaserDetail(purchaser);
//    }

    @ApiOperation(value = "完善代理机构信息",notes = "完善代理机构信息")
    @PostMapping(value = "/updateAgencyDetail")
    public Result<Boolean> updateAgencyDetail(@RequestBody ClientHandleAgnecy handleAgnecy) {
        HandleAgnecy agnecy = new HandleAgnecy();
        BeanUtils.copyProperties(handleAgnecy,agnecy);
        return purchaserClient.updateAgencyDetail(agnecy);
    }

    @ApiOperation(value = "采购商注册",notes = "采购商注册")
    @PostMapping(value = "/registerPurchasers")
    public Result registerPurchaser(@RequestBody ClientHandleRegisterPurchaser purchaser) {
        HandleRegisterPurchaser handleRegisterPurchaser = new HandleRegisterPurchaser();
        BeanUtils.copyProperties(purchaser,handleRegisterPurchaser);
        return purchaserClient.registerPurchaser(handleRegisterPurchaser);
    }

    @ApiOperation(value = "查找采购商所有员工",notes = "查找采购商所有员工,map中key为\"purchaserId\"")
    @PostMapping(value = "/allEmployee")
    public Result allEmployee(@RequestBody @ApiParam(value = "map是的key为purchaserId的json格式")HashMap<String,Long> map) {
        return purchaserClient.allEmployee(map);
    }

    @ApiOperation(value = "根据name查找员工",notes = "根据name查找员工")
    @PostMapping(value = "/findEmployeeByName")
    public Result findEmployeeByName(@RequestBody @ApiParam(value = "map是的key为fuzzyName和purchaseId的json格式")HashMap<String,Object> map) {
        return purchaserClient.findEmployeeByName(map);
    }

    @ApiOperation(value = "根据手机修改员工状态",notes = "根据手机修改员工状态")
    @PostMapping(value = "/updateEmployeeState")
    public Result updateEmployeeState(@RequestBody @ApiParam(value = "map是的key为cellphone和state的json格式")HashMap<String,Object> map) {
        return purchaserClient.updateEmployeeState(map);

    }

    @ApiOperation(value = "根据id修改员工状态",notes = "根据id修改员工状态")
    @PostMapping(value = "/updateEmployeeStateById")
    public Result updateEmployeeStateById(@RequestBody @ApiParam(value = "map是的key为id和state的json格式")HashMap<String,Object> map) {
        return purchaserClient.updateEmployeeStateById(map);
    }

    @ApiOperation(value = "依据手机查员工",notes = "依据手机查员工")
    @PostMapping(value = "/queryEmployeeByCell")
    public Result queryEmployeeByCellphone(@RequestBody @ApiParam(value = "map是的key为cellphone的json格式")HashMap<String,Object> map) {
        return purchaserClient.queryEmployeeByCellphone(map);
    }

    @ApiOperation(value = "依据id查员工",notes = "依据id查员工")
    @PostMapping(value = "/queryEmployeeById")
    public Result queryEmployeeById(@RequestBody @ApiParam(value = "map是的key为idjson格式")HashMap<String,Object> map) {
        return purchaserClient.queryEmployeeById(map);
    }
    @ApiOperation(value = "依据综合条件查员工",notes = "依据综合条件查员工")
    @PostMapping(value = "/queryEmplyees")
    public Result queryEmplyee(@RequestBody ClientHandleEmployeeDto employeeDto) {
        HandleEmployeeDto dto = new HandleEmployeeDto();
        BeanUtils.copyProperties(employeeDto,dto);
        return purchaserClient.queryEmplyee(dto);
    }

    @ApiOperation(value = "依据id改权限",notes = "依据id改权限")
    @PostMapping(value = "/updateRole")
    public Result updateRole(@RequestBody @ApiParam(value = "map是的key为id和role的json格式")HashMap<String,Object> map) {
        return purchaserClient.updateRole(map);
    }

    @ApiOperation(value = "查询机构下所有的供货商",notes = "查询机构下所有的供货商")
    @PostMapping(value = "/queryAllSuppliers")
    public Result queryAllSuppliers(@RequestBody HashMap<String,Object> map) {
        return purchaserClient.queryAllSuppliers(map);
    }

    @ApiOperation(value = "模糊查询机构下的供货商",notes = "查询机构下所有的供货商")
    @PostMapping(value = "/querySuppliersByName")
    public Result querySuppliersByName(@RequestBody @ApiParam(value = "map是的key为fuzzyName和purchaseId的json格式")HashMap<String,Object> map) {
        return purchaserClient.querySuppliersByName(map);
    }

    @ApiOperation(value = "依据id查询供货商",notes = "依据id查询供货商")
    @PostMapping(value = "/querySuppliers")
    public Result querySuppliersById(@RequestBody @ApiParam(value = "map是的key为id的json格式")HashMap<String,Object> map) {
        return purchaserClient.querySuppliersById(map);
    }

    @ApiOperation(value = "修改供货商信息",notes = "修改供货商信息")
    @PostMapping(value = "/updateSuppliers")
    public Result updateSuppliers(@RequestBody ClientHandleSupplierDto attachment) {
        HandleSupplierDto purchaserAttachment = new HandleSupplierDto();
        BeanUtils.copyProperties(attachment,purchaserAttachment);
        return purchaserClient.updateSuppliers(purchaserAttachment);
    }

    @ApiOperation(value = "根据综合条件查询所有专家",notes = "根据综合条件查询所有专家")
    @PostMapping(value = "/queryExperts")
    public Result queryExperts(@RequestBody ClientHandleExpertDto dto) {
        HandleExpertDto expertDto = new HandleExpertDto();
        BeanUtils.copyProperties(dto,expertDto);
        return purchaserClient.queryExperts(expertDto);
    }

    @ApiOperation(value = "根据id修专家状态",notes = "根据id修专家状态")
    @PostMapping(value = "/updateExpertState")
    public Result updateExpertState(@RequestBody @ApiParam(value = "map是的key为id和state的json格式")HashMap<String,Object> map) {
        return purchaserClient.updateExpertState(map);
    }

    /**
     *@author :winlin
     *@Description :根据条件查询代理机构
     *@param:
     *@return:
     *@date:2018/9/20
     */
    @ApiOperation(value = "根据条件查询代理机构",notes = "根据条件查询代理机构")
    @PostMapping(value = "/queryAgenciesByCriteria")
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(@RequestBody ClientHandleAgencyDto agencyDto){
        HandleAgencyDto dto = new HandleAgencyDto();
        BeanUtils.copyProperties(agencyDto,dto);
        return purchaserClient.queryAgenciesByCriteria(dto);
    };

    /**
     *@author :winlin
     *@Description :
     *@param: 依据条件检索供应商
     *@return:
     *@date:2018/9/20
     */
    @ApiOperation(value = "根据条件查询供货商",notes = "根据条件查询供货商")
    @PostMapping(value = "/querySupplierByCriterias")
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(@RequestBody ClientHandleSupplierDto supplierDto){
        HandleSupplierDto dto = new HandleSupplierDto();
        BeanUtils.copyProperties(supplierDto,dto);
        return purchaserClient.querySupplierByCriterias(dto);
    };

    /**
     *@author :winlin
     *@Description :完善采购人专家信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    @ApiOperation(value = "采购人完善专家信息",notes = "采购人完善专家信息")
    @PostMapping(value = "/completePurchaserExpertInfo")
    public Result<Boolean> completePurchaserExpertInfo(@RequestBody ClientHandleExpertDto expertDto){
        HandleExpertDto dto = new HandleExpertDto();
        BeanUtils.copyProperties(expertDto,dto);
        return purchaserClient.completePurchaserExpertInfo(dto);
    };

    /**
     *@author :winlin
     *@Description :修改采购人代理机构详细信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    @ApiOperation(value = "采购人完善代理机构信息",notes = "采购人完善代理机构信息")
    @PostMapping(value = "/updatePurchaserAgency")
    public Result<Boolean> updatePurchaserAgency(@RequestBody ClientHandleAgencyDto agencyDto){
        HandleAgencyDto dto = new HandleAgencyDto();
        BeanUtils.copyProperties(agencyDto,dto);
        return purchaserClient.updatePurchaserAgency(dto);
    };
    /**
     *@author :winlin
     *@Description :修改采购人专家的信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    @ApiOperation(value = "采购人完善专家信息",notes = "采购人完善专家信息")
    @PostMapping(value = "/updatePurchaserExpert")
    public Result<Boolean> updatePurchaserExpert(@RequestBody ClientHandleExpertDto expertDto){
        HandleExpertDto dto = new HandleExpertDto();
        BeanUtils.copyProperties(expertDto,dto);
        return purchaserClient.updatePurchaserExpert(dto);
    };

    public Result queryEmployee(@RequestParam Long userId){
        return purchaserClient.queryEmployee(userId);
    }

}
