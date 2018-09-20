package com.epc.web.service.service.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.handle.HandPurchaserAttachment;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.purchaser.handle.HandleRegisterPurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import io.swagger.models.auth.In;
import sun.util.resources.ga.LocaleNames_ga;

/**
 * @author :winlin &linzhixiang
 * @Description :采购商所有的功能接口
 * @date:2018/9/18
 */
public interface PurchaserService {
    /**
     * 新增采购人员工
     */
    Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType);

    /**
     * 添加运营商-采购人关系
     *
     * @param handleOperator
     * @return
     */
    Result<Boolean> createOperatePurchaser(HandlePurchaser handleOperator);

    /**
     * 添加运营商(私库)
     *
     * @param handleOperator
     * @return
     */
    Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleOperator);

    /**
     * 添加专家(私库)
     *
     * @param handleExpert
     * @return
     */
    Result<Boolean> createExpertUserInfo(HandleExpert handleExpert);

    /**
     * 添加代理机构(私库)
     *
     * @param handleAgnecy
     * @return
     */
    Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy);


    /**
     * 完善采购人信息detail
     *
     * @param handlePurchaser
     * @return
     */
    Result<Boolean> updatePurchaserDetail(HandlePurchaser handlePurchaser);

    /**
     * 完善供货商信息detail
     *
     * @param HandleSupplierDetail
     * @return
     */
    Result<Boolean> updateSupplierDetail(HandleSupplierDetail HandleSupplierDetail);

    /**
     * 完善代理机构detail
     *
     * @param handleAgnecy
     * @return
     */
    Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy);

    /**
     * @author :winlin
     * @Description :采购人注册
     * @param:
     * @return:
     * @date:2018/9/18
     */
    public Result registerPurchaser(HandleRegisterPurchaser purchaser);

    /**
     * @author :winlin
     * @Description : 查询采购下的所有员工的信息
     * @param: 机构id
     * @return:
     * @date:2018/9/19
     */
    public Result allEmployee(Long purchaserId);

    /**
     * @author :winlin
     * @Description :根据姓名模糊搜索员工
     * @param: fuzzynName 模糊的name
     * @return:
     * @date:2018/9/19
     */
    public Result findEmployeeByName(String fuzzyName,Long purchaseId);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据手机号,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result updateEmployeeState(String cellphone,Integer state);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据id,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result updateEmployeeState(Long id,Integer state);

    /**
     * @author :winlin
     * @Description :根据手机号查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result queryEmployee(String cellphone);

    /**
     * @author :winlin
     * @Description : 根据id 查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result queryEmployee(Long id);
    /**
     *@author :winlin
     *@Description :根据条件查询多有符合条件的员工
     *@param: name cellphone role
     *@return:
     *@date:2018/9/19
     */
    public Result queryEmplyee(HandleEmployeeDto employeeDto);

    /**
     *@author :winlin
     *@Description : 修改员工权限
     *@param: 员工id,新的权限
     *@return:
     *@date:2018/9/19
     */
    public Result updateRole(Long id,Integer role);

    /**
     * @author :winlin
     * @Description :查询采购人下所有的供应商
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result queryAllSuppliers(Long purchaseId);

    /**
     * @author :winlin
     * @Description : 模糊查询供应商,根据姓名
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result querySuppliers(String fuzzyName,Long purchaseId);

    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result querySuppliers(Long id);

    /**
     * @author :winlin
     * @Description :修改供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result updateSuppliers(HandPurchaserAttachment attachment);

    /**
     * @author :winlin
     * @Description :根据综合条件查询所有专家
     * @param: HandleAgency 综合信息
     * @return:
     * @date:2018/9/19
     */
    public Result queryExperts(HandleExpertDto dto);
    /**
     *@author :winlin
     *@Description :根据id删除专家,修改is_delete状态
     *@param:
     *@return:
     *@date:2018/9/19
     */
    public Result updateExpertState(Long id ,Integer state);
}
