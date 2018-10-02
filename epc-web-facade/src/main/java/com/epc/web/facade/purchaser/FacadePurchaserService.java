package com.epc.web.facade.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.*;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.*;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface FacadePurchaserService {

    /**
     * 新增采购人员工
     */
    @PostMapping(value = "createPurchaserUserInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaserUserInfo(@RequestBody HandlePurchaser handleEmployee);
    /**
     *@author :winlin
     *@Description :启用或禁用员工
     *@param:
     *@return:
     *@date:2018/9/29
     */
    @PostMapping(value = "enableOrDisablePurchaserEmployee", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> enableOrDisablePurchaserEmployee(@RequestBody HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :修改员工权限
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @PostMapping(value = "updatePurchaserEmployeeRole", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updatePurchaserEmployeeRole(@RequestBody HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :修改员工信息
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @PostMapping(value = "updatePurchaserEmployeeInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updatePurchaserEmployeeInfo(@RequestBody HandlePurchaserDto handlePurchaser);
    /**
     *@author :winlin
     *@Description :根据条件查询多有符合条件的员工
     *@param: name cellphone role
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "queryEmplyee", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(@RequestBody HandleEmployeeDto employeeDto);

    /**
     * 采购人新增专家
     *
     * @param handleExpert
     * @return
     */
    @PostMapping(value = "createExpertUserInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createExpertUserInfo(@RequestBody HandleExpert handleExpert);
    /**
     *@author :winlin
     *@Description :完善采购人专家信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    @PostMapping(value = "completePurchaserExpertInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> completePurchaserExpertInfo(@RequestBody HandleExpertDto expertDto);

    /**
     *@author :winlin
     *@Description :删除评标专家 修改delete字段的属性值
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @PostMapping(value = "deletePurchaserExpert", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> deletePurchaserExpert(@RequestBody HandleTrustList trustList);

    /**
     * @author :winlin
     * @Description :根据综合条件查询所有专家
     * @param: HandlExpertDto综合信息
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryExperts", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaserExpertVo>> queryExperts(@RequestBody QueryExpertDto dto);
    /**
     * 添加代理机构
     *
     * @param handleAgnecy
     * @return
     */
    @PostMapping(value = "createAgencyUserInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createAgencyUserInfo(@RequestBody HandleAgnecy handleAgnecy);
    /**
     * 完善代理机构detail
     *
     * @param handleAgnecy
     * @return
     */
    @PostMapping(value = "updateAgencyDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy);
    /**
     *@author :winlin
     *@Description :添加黑名单-agency
     *@param:
     *@return:
     *@date:2018/9/28
     */
    @PostMapping(value = "updateTrustListForAgency", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateTrustListForAgency(@RequestBody HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :根据条件查询代理机构
     *@param:
     *@return:
     *@date:2018/9/20
     */
    @PostMapping(value = "queryAgenciesByCriteria", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(@RequestBody QueryAgencyDto agencyDto);


    /**
     * 添加供应商(私库)
     *
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "createSupplierByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDto handleOperator);
    /**
     * 完善供货商信息detail
     *
     * @param  dto
     * @return
     */
    @PostMapping(value = "updateSupplierDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateSupplierDetail(@RequestBody PurchaserHandleSupplierDto dto);
    /**
     *@author :winlin
     *@Description :添加黑名单-supplier
     *@param:
     *@return:
     *@date:2018/9/28
     */
    @PostMapping(value = "updateTrustListForSupplier", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateTrustListForSupplier(@RequestBody HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :
     *@param: 依据条件检索供应商
     *@return:
     *@date:2018/9/20
     */
    @PostMapping(value = "querySupplierByCriterias", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(@RequestBody QuerySupplierDto supplierDto);


    /**
     * 完善采购人信息detail
     *
     * @param handlePurchaser
     * @return
     */
    @PostMapping(value = "updatePurchaserDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updatePurchaserDetail(@RequestBody HandleRegisterPurchaser handlePurchaser);




    /**
     * @author :winlin
     * @Description : 根据id 查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryEmployeeDto", consumes = "application/json; charset=UTF-8")
    public Result<PurchaserEmplyeeVo> queryEmployeeDto(@RequestBody QueryDto dto);

    /**
     *@author :winlin
     *@Description : 修改员工权限
     *@param: 员工id,新的权限
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "updateRole", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateRole(@RequestParam("id") Long id,@RequestParam("role")Integer role);


    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "querySuppliersDto", consumes = "application/json; charset=UTF-8")
    public Result<SupplierDetailVo> querySuppliersDto(@RequestBody QueryDto dto);
    /**
     *@author :winlin
     *@Description : id查询专家详情
     *@param:
     *@return:
     *@date:2018/10/2
     */
    @PostMapping(value = "queryExpertDetailById", consumes = "application/json; charset=UTF-8")
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(@RequestBody QueryDto dto);

    /**
     *@author :winlin
     *@Description :依据id查询代理机构
     *@param:
     *@return:
     *@date:2018/10/2
     */
    @PostMapping(value = "queryAgencyDetailById", consumes = "application/json; charset=UTF-8")
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(@RequestBody QueryDto dto);



    /**
     *@author :winlin
     *@Description :根据id删除专家,修改is_delete状态
     *@param:
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "updateExpertState", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateExpertState(@RequestParam(value = "id")Long id ,@RequestParam(value = "state")Integer state);

    @PostMapping(value = "queryEmployees", consumes = "application/json; charset=UTF-8")
    public Result queryEmployee(@RequestParam(value = "userId") Long userId);
}
