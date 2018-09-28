package com.epc.web.facade.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.HandleAgencyDto;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.dto.HandleSupplierDto;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.PurchaserAgencyVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface FacadePurchaserService {

    /**
     * 注册 采购人员
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "registerPurchaseBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaseBasicInfo(@RequestBody HandlePurchaser handleOperator);
    /**
     * 采购人员注册供应商
     * @param handleSupplierDetail
     * @return
     */
    @PostMapping(value = "registerSupplierByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDto handleSupplierDetail);

    /**
     * 采购人员注册专家
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "registerExpertByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createExpertByPurchaser(@RequestBody HandleExpert handleOperator);

    /**
     * 采购人员注册代理机构
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "registerAgencyByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createAgencyByPurchaser(@RequestBody HandleAgnecy handleOperator);

    /**
     * 完善采购人信息
     * @param handlePurchaser
     * @return
     */
    @PostMapping(value = "registerPurchaserDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updatePurchaserDetail(@RequestBody HandleRegisterPurchaser handlePurchaser);

    /**
     * 完善代理机构信息
     * @param handleAgnecy
     * @return
     */
    @PostMapping(value = "updateAgencyDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy);
    /**
     * 完善供货商信息detail
     *
     * @param  dto
     * @return
     */
    @PostMapping(value = "updatePurchaserSupplierDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateSupplierDetail(@RequestBody PurchaserHandleSupplierDto dto);

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
     * @author :winlin
     * @Description :采购人注册
     * @param:
     * @return:
     * @date:2018/9/18
     */
    @PostMapping(value = "registerPurchaser", consumes = "application/json; charset=UTF-8")
    Result registerPurchaser(@RequestBody HandleRegisterPurchaser purchaser);

    /**
     * @author :winlin
     * @Description : 查询采购下的所有员工的信息
     * @param: 机构id
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "allEmployee", consumes = "application/json; charset=UTF-8")
    Result allEmployee(@RequestBody HashMap<String,Long> map);

    /**
     * @author :winlin
     * @Description :根据姓名模糊搜索员工
     * @param: fuzzynName 模糊的name
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "findEmployeeByName", consumes = "application/json; charset=UTF-8")
    Result findEmployeeByName(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据手机号,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "updateEmployeeState", consumes = "application/json; charset=UTF-8")
    Result updateEmployeeState(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据id,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "updateEmployeeStateById", consumes = "application/json; charset=UTF-8")
    Result updateEmployeeStateById(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description :根据手机号查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryEmployee", consumes = "application/json; charset=UTF-8")
    Result queryEmployeeByCellphone(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description : 根据id 查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryPurchaserEmployeeById", consumes = "application/json; charset=UTF-8")
    Result queryEmployeeById(@RequestBody HashMap<String,Object> map);
    /**
     *@author :winlin
     *@Description :根据条件查询多有符合条件的员工
     *@param: name cellphone role
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "queryEmplyeeByCriteria", consumes = "application/json; charset=UTF-8")
    Result queryEmplyee(@RequestBody HandleEmployeeDto employeeDto);

    /**
     *@author :winlin
     *@Description : 修改员工权限
     *@param: 员工id,新的权限
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "updateRole", consumes = "application/json; charset=UTF-8")
    Result updateRole(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description :查询采购人下所有的供应商
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryAllSuppliers", consumes = "application/json; charset=UTF-8")
    Result queryAllSuppliers(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description : 模糊查询供应商,根据姓名
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "querySuppliers", consumes = "application/json; charset=UTF-8")
    Result querySuppliersByName(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "querySuppliersById", consumes = "application/json; charset=UTF-8")
    Result querySuppliersById(@RequestBody HashMap<String,Object> map);

    /**
     * @author :winlin
     * @Description :修改供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "updateSuppliers", consumes = "application/json; charset=UTF-8")
    Result updateSuppliers( @RequestBody HandleSupplierDto attachment);

    /**
     * @author :winlin
     * @Description :根据综合条件查询所有专家
     * @param: HandleAgency 综合信息
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryExperts", consumes = "application/json; charset=UTF-8")
    Result queryExperts(@RequestBody HandleExpertDto dto);
    /**
     *@author :winlin
     *@Description :根据id删除专家,修改is_delete状态
     *@param:
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "updateExpertState", consumes = "application/json; charset=UTF-8")
    Result updateExpertState(@RequestBody HashMap<String,Object> map);

    /**
     *@author :winlin
     *@Description :根据条件查询代理机构
     *@param:
     *@return:
     *@date:2018/9/20
     */
    @PostMapping(value = "findAgenciesByCriteria", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(@RequestBody HandleAgencyDto agencyDto);

    /**
     *@author :winlin
     *@Description :
     *@param: 依据条件检索供应商
     *@return:
     *@date:2018/9/20
     */
    @PostMapping(value = "findSupplierByCriterias", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(@RequestBody HandleSupplierDto supplierDto);

    /**
     *@author :winlin
     *@Description :修改采购人代理机构详细信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    @PostMapping(value = "updatePurchaserAgency", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updatePurchaserAgency(@RequestBody HandleAgencyDto agencyDto);
    /**
     *@author :winlin
     *@Description :修改采购人专家的信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    @PostMapping(value = "updatePurchaserExpert", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updatePurchaserExpert(@RequestBody HandleExpertDto expertDto);
    @PostMapping(value = "queryEmployees", consumes = "application/json; charset=UTF-8")
    public Result queryEmployee(@RequestParam(value = "userId") Long userId);
}
