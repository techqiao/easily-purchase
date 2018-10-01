package com.epc.web.service.controller.purchaser;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.purchaser.dto.HandleAgencyDto;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.dto.HandleSupplierDto;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.PurchaserAgencyVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public  class PurchaserController implements FacadePurchaserService {

    @Autowired
    PurchaserService purchaserService;

    /**
     * 新增采购人员
     */
    @Override
    public Result<Boolean> createPurchaseBasicInfo(@RequestBody HandlePurchaser handleOperator) {
        return purchaserService.createPurchaserUserInfo(handleOperator,Const.Role.ROLE_CUSTOMER);
    }
    @Override
    public Result<Boolean> enableOrDisablePurchaserEmployee(@RequestBody HandleTrustList trustList){
        return purchaserService.enableOrDisablePurchaserEmployee(trustList);
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeRole(@RequestBody HandleTrustList trustList) {
        return purchaserService.updatePurchaserEmployeeRole(trustList);
    }

    /**
     * 采购人 添加 供应商
     */
    @Override
    public Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDto handleSupplierDetail) {
        return purchaserService.createSupplierByPurchaser(handleSupplierDetail);
    }


    /**
     * 采购人 添加 专家
     */
    @Override
    public Result<Boolean> createExpertByPurchaser(@RequestBody HandleExpert handleExpert) {
        return purchaserService.createExpertUserInfo(handleExpert);
    }

    /**
     * 采购人 添加 代理机构
     */
    @Override
    public Result<Boolean> createAgencyByPurchaser(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserService.createAgencyUserInfo(handleAgnecy);
    }

    /**
     * 完善 采购人信息
     * @param handlePurchaser
     * @return
     */
    @Override
    public Result<Boolean> updatePurchaserDetail(@RequestBody HandleRegisterPurchaser handlePurchaser) {
        return purchaserService.updatePurchaserDetail(handlePurchaser);
    }

    /**
     * 完善 代理机构信息
     * @param handleAgnecy
     * @return
     */
    @Override
    public Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserService.updateAgencyDetail(handleAgnecy);
    }
    /**
     *@author :winlin
     *@Description :完善采购人供货商信息
     *@param:
     *@return:
     *@date:2018/9/25
     */
    @Override
    public Result<Boolean> updateSupplierDetail(@RequestBody PurchaserHandleSupplierDto dto) {
        return purchaserService.updateSupplierDetail(dto);
    }
    /**
     *@author :winlin
     *@Description :完善采购人专家的信息
     *@param:
     *@return:
     *@date:2018/9/25
     */
    @Override
    public Result<Boolean> completePurchaserExpertInfo(@RequestBody HandleExpertDto expertDto) {
        return purchaserService.completePurchaserExpertInfo(expertDto);
    }
/**
 *@author :winlin
 *@Description :采购人注册
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result registerPurchaser(@RequestBody HandleRegisterPurchaser purchaser) {
        return purchaserService.registerPurchaser(purchaser);
    }
/**
 *@author :winlin
 *@Description :查找采购人下的所有员工
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result allEmployee(@RequestBody HashMap<String,Long> map) {
        Long purchaserId=map.get("purchaserId");
        return purchaserService.allEmployee(purchaserId);
    }
/**
 *@author :winlin
 *@Description :通过姓名模糊查找员工
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result findEmployeeByName(@RequestBody HashMap<String,Object> map) {
            String fuzzyName = (String) map.get("fuzzyName");
        String pur=(String) map.get("purchaseId");
        Long purchaseId = Long.parseLong(pur);
        return purchaserService.findEmployeeByName(fuzzyName,purchaseId);
    }
/**
 *@author :winlin
 *@Description :通过电话查找员工状态并更新
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result updateEmployeeState(@RequestBody HashMap<String,Object> map) {
        String cellphone =(String)map.get("cellphone");
        String states = (String)map.get("state");
        Integer state =Integer.parseInt(states);
        return purchaserService.updateEmployeeState(cellphone,state);
    }
/**
 *@author :winlin
 *@Description :通过id更新员工状态
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result updateEmployeeStateById(@RequestBody HashMap<String,Object> map) {
        String ids = (String) map.get("id");
        String states =(String)map.get("state");
        Long id = Long .parseLong(ids);
        Integer state = Integer.parseInt(states);
        return purchaserService.updateEmployeeState(id,state);
    }




    /**
 *@author :winlin
 *@Description :通过电话查找员工
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result queryEmployeeByCellphone(@RequestBody HashMap<String,Object> map) {
        String cellphone =(String)map.get("cellphone");
        return purchaserService.queryEmployee(cellphone);
    }
/**
 *@author :winlin
 *@Description :通过id查找员工
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result  queryEmployeeById(@RequestBody HashMap<String,Object> map) {
            String ids = (String) map.get("id");
            Long id =Long.parseLong(ids);
        return purchaserService.queryEmployee(id);
    }

/**
 *@author :winlin
 *@Description :通过综合条件查找员工
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result queryEmplyee(@RequestBody HandleEmployeeDto employeeDto) {
        return purchaserService.queryEmplyee(employeeDto);
    }

/**
 *@author :winlin
 *@Description :通过id修改员工权限
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result updateRole(@RequestBody HashMap<String,Object> map) {
        String ids = (String)map.get("id");
        String roles = (String) map.get("role");
        Long id= Long.parseLong(ids);
        Integer role =Integer.parseInt(roles);
        return purchaserService.updateRole(id,role);
    }

    /**
 *@author :winlin
 *@Description :查询采购人下所有的供货商信息
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result queryAllSuppliers(@RequestBody HashMap<String,Object> map) {
       String pur =(String)map.get("purchaseId");
        Long purchaseId =Long.parseLong(pur);
        return purchaserService.queryAllSuppliers(purchaseId);
    }
    /**
     *@author :winlin
     *@Description : 通过供货商名字模糊查找供货商
     *@param:
     *@return:
     *@date:2018/9/25
     */
    @Override
    public Result querySuppliersByName(@RequestBody HashMap<String,Object> map) {
        String fuzzyName = (String)map.get("fuzzyName");
        String pur =(String)map.get("purchaseId");
        Long purchaseId =Long.parseLong(pur);
        return purchaserService.querySuppliers(fuzzyName,purchaseId);
    }

/**
 *@author :winlin
 *@Description :通过id查找供货商
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result querySuppliersById(@RequestBody HashMap<String,Object> map) {
        String pur =(String)map.get("id");
        Long id =Long.parseLong(pur);
        return purchaserService.querySuppliers(id);
    }
/**
 *@author :winlin
 *@Description : 修改供货商的信息
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result updateSuppliers(@RequestBody HandleSupplierDto attachment) {
        return purchaserService.updateSuppliers(attachment);
    }
/**
 *@author :winlin
 *@Description :依据综合条件查询专家
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result queryExperts(@RequestBody HandleExpertDto dto) {
        return purchaserService.queryExperts(dto);
    }


    /**
 *@author :winlin
 *@Description :依据id修改状态
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result updateExpertState(@RequestBody HashMap<String, Object> map) {
        String states = (String)map.get("state");
        String pur =(String)map.get("id");
        Long id =Long.parseLong(pur);
        Integer state =Integer.parseInt(states);
        return purchaserService.updateExpertState(id,state);
    }
/**
 *@author :winlin
 *@Description :综合条件查询所有的代理机构
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(@RequestBody HandleAgencyDto agencyDto) {
        return purchaserService.queryAgenciesByCriteria(agencyDto);
    }
/**
 *@author :winlin
 *@Description :综合条件查询供货商
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(@RequestBody HandleSupplierDto supplierDto) {
        return purchaserService.querySupplierByCriterias(supplierDto);
    }
/**
 *@author :winlin
 *@Description :更新代理机构信息
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result<Boolean> updatePurchaserAgency(@RequestBody HandleAgencyDto agencyDto) {
        return purchaserService.updatePurchaserAgency(agencyDto);
    }
/**
 *@author :winlin
 *@Description :更新专家信息
 *@param:
 *@return:
 *@date:2018/9/25
 */
    @Override
    public Result<Boolean> updatePurchaserExpert(@RequestBody HandleExpertDto expertDto) {
        return purchaserService.updatePurchaserExpert(expertDto);
    }

    @Override
    public Result queryEmployee(Long userId) {
        return purchaserService.queryEmployee(userId);
    }

}
