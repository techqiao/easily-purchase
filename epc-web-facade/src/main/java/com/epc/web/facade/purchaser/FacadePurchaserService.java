package com.epc.web.facade.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.handle.HandPurchaserAttachment;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.purchaser.handle.HandleRegisterPurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDetail handleSupplierDetail);

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
    Result<Boolean> updatePurchaserDetail(@RequestBody HandlePurchaser handlePurchaser);

    /**
     * 完善代理机构信息
     * @param handleAgnecy
     * @return
     */
    @PostMapping(value = "updateAgencyDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy);

    /**
     * @author :winlin
     * @Description :采购人注册
     * @param:
     * @return:
     * @date:2018/9/18
     */
    @PostMapping(value = "registerPurchaser", consumes = "application/json; charset=UTF-8")
    Result registerPurchaser(HandleRegisterPurchaser purchaser);

    /**
     * @author :winlin
     * @Description : 查询采购下的所有员工的信息
     * @param: 机构id
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "allEmployee", consumes = "application/json; charset=UTF-8")
    Result allEmployee(Long purchaserId);

    /**
     * @author :winlin
     * @Description :根据姓名模糊搜索员工
     * @param: fuzzynName 模糊的name
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "findEmployeeByName", consumes = "application/json; charset=UTF-8")
    Result findEmployeeByName(@RequestParam("fuzzyName")String fuzzyName, @RequestParam("id")Long purchaseId);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据手机号,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "updateEmployeeState", consumes = "application/json; charset=UTF-8")
    Result updateEmployeeState(@RequestParam("cellphone")String cellphone,@RequestParam("state")Integer state);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据id,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "updateEmployeeStateById", consumes = "application/json; charset=UTF-8")
    Result updateEmployeeStateById(@RequestParam("id")Long id,@RequestParam("state")Integer state);

    /**
     * @author :winlin
     * @Description :根据手机号查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryEmployee", consumes = "application/json; charset=UTF-8")
    Result queryEmployee(String cellphone);

    /**
     * @author :winlin
     * @Description : 根据id 查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryEmployeeById", consumes = "application/json; charset=UTF-8")
    Result queryEmployee(Long id);
    /**
     *@author :winlin
     *@Description :根据条件查询多有符合条件的员工
     *@param: name cellphone role
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "queryEmplyeeByCriteria", consumes = "application/json; charset=UTF-8")
    Result queryEmplyee(HandleEmployeeDto employeeDto);

    /**
     *@author :winlin
     *@Description : 修改员工权限
     *@param: 员工id,新的权限
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "updateRole", consumes = "application/json; charset=UTF-8")
    Result updateRole(@RequestParam("id")Long id,@RequestParam("role")Integer role);

    /**
     * @author :winlin
     * @Description :查询采购人下所有的供应商
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryAllSuppliers", consumes = "application/json; charset=UTF-8")
    Result queryAllSuppliers(Long purchaseId);

    /**
     * @author :winlin
     * @Description : 模糊查询供应商,根据姓名
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "querySuppliers", consumes = "application/json; charset=UTF-8")
    Result querySuppliers(@RequestParam("fuzzyName")String fuzzyName,@RequestParam("purchaseId")Long purchaseId);

    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "querySuppliersById", consumes = "application/json; charset=UTF-8")
    Result querySuppliers(Long id);

    /**
     * @author :winlin
     * @Description :修改供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "updateSuppliers", consumes = "application/json; charset=UTF-8")
    Result updateSuppliers(HandPurchaserAttachment attachment);

    /**
     * @author :winlin
     * @Description :根据综合条件查询所有专家
     * @param: HandleAgency 综合信息
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryExperts", consumes = "application/json; charset=UTF-8")
    Result queryExperts(HandleExpertDto dto);
    /**
     *@author :winlin
     *@Description :根据id删除专家,修改is_delete状态
     *@param:
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "updateExpertState", consumes = "application/json; charset=UTF-8")
    Result updateExpertState(@RequestParam("id")Long id ,@RequestParam("state")Integer state);
}
