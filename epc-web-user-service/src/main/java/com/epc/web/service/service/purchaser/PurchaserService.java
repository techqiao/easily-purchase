package com.epc.web.service.service.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.agency.vo.AgencyExpertDetailVo;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.*;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.*;

import javax.management.Query;
import java.util.List;

/**
 * @author :winlin &linzhixiang
 * @Description :采购商所有的功能接口
 * @date:2018/9/18
 */
public interface PurchaserService {
    /**
     * 新增采购人员工
     */
    Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleEmployee);
    /**
     *@author :winlin
     *@Description :启用或禁用员工
     *@param:
     *@return:
     *@date:2018/9/29
     */
    public Result<Boolean> enableOrDisablePurchaserEmployee(HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :修改员工权限
     *@param:
     *@return:
     *@date:2018/9/30
     */
    public Result<Boolean> updatePurchaserEmployeeRole(HandleTrustList trustList);
/**
 *@author :winlin
 *@Description :修改员工信息
 *@param:
 *@return:
 *@date:2018/9/30
 */
public Result<Boolean> updatePurchaserEmployeeInfo(HandlePurchaserDto handlePurchaser);
    /**
     *@author :winlin
     *@Description :根据条件查询多有符合条件的员工
     *@param: name cellphone role
     *@return:
     *@date:2018/9/19
     */
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(HandleEmployeeDto employeeDto);

    /**
     * 采购人新增专家
     *
     * @param handleExpert
     * @return
     */
    Result<Boolean> createExpertUserInfo(HandleExpert handleExpert);
    /**
     *@author :winlin
     *@Description :完善采购人专家信息
     *@param:
     *@return:
     *@date:2018/9/21
     */
    public Result<Boolean> completePurchaserExpertInfo(HandleExpertDto expertDto);

    /**
     *@author :winlin
     *@Description :删除评标专家 修改delete字段的属性值
     *@param:
     *@return:
     *@date:2018/9/30
     */
    public Result<Boolean> deletePurchaserExpert(HandleTrustList trustList);

    /**
     * @author :winlin
     * @Description :根据综合条件查询所有专家
     * @param: HandlExpertDto综合信息
     * @return:
     * @date:2018/9/19
     */
    public Result<List<PurchaserExpertVo>> queryExperts(QueryExpertDto dto);
    /**
     * 添加代理机构(私库)
     *
     * @param handleAgnecy
     * @return
     */
    Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy);
    /**
     * 完善代理机构detail
     *
     * @param handleAgnecy
     * @return
     */
    Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy);
    /**
     *@author :winlin
     *@Description :添加黑名单-agency
     *@param:
     *@return:
     *@date:2018/9/28
     */
    public Result<Boolean> updateTrustListForAgency(HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :根据条件查询代理机构
     *@param:
     *@return:
     *@date:2018/9/20
     */
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(QueryAgencyDto agencyDto);


    /**
     * 添加供应商(私库)
     *
     * @param handleOperator
     * @return
     */
    Result<Boolean> createSupplierByPurchaser(HandleSupplierDto handleOperator);
    /**
     * 完善供货商信息detail
     *
     * @param  dto
     * @return
     */
    Result<Boolean> updateSupplierDetail(PurchaserHandleSupplierDto dto);
    /**
     *@author :winlin
     *@Description :添加黑名单-supplier
     *@param:
     *@return:
     *@date:2018/9/28
     */
    public Result<Boolean> updateTrustListForSupplier(HandleTrustList trustList);
    /**
     *@author :winlin
     *@Description :
     *@param: 依据条件检索供应商
     *@return:
     *@date:2018/9/20
     */
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(QuerySupplierDto supplierDto);


//    /**
//     * @author :winlin
//     * @Description :采购人注册
//     * @param:
//     * @return:
//     * @date:2018/9/18
//     */
//    public Result<HandleRegisterPurchaser> registerPurchaser(HandleRegisterPurchaser purchaser);
    /**
     * 完善采购人信息detail
     *
     * @param handlePurchaser
     * @return
     */
    Result<Boolean> updatePurchaserDetail(HandleRegisterPurchaser handlePurchaser);



    /**
     * @author :winlin
     * @Description : 查询采购下的所有员工的信息
     * @param: 机构id
     * @return:
     * @date:2018/9/19
     */
    public Result<List<PurchaserEmplyeeVo>> allEmployee(Long purchaserId);

    /**
     * @author :winlin
     * @Description :根据姓名模糊搜索员工
     * @param: fuzzynName 模糊的name
     * @return:
     * @date:2018/9/19
     */
    public Result<List<PurchaserEmplyeeVo>> findEmployeeByName(String fuzzyName,Long purchaseId);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据手机号,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result<Boolean> updateEmployeeState(String cellphone,Integer state);

    /**
     * @author :winlin
     * @Description :修改员工状态,依据id,是否禁用
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result<Boolean> updateEmployeeState(Long id,Integer state);

    /**
     * @author :winlin
     * @Description :根据手机号查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result<PurchaserEmplyeeVo> queryEmployee(String cellphone);

    /**
     * @author :winlin
     * @Description : 根据id 查询员工
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result<PurchaserEmplyeeVo> queryEmployeeDto(QueryDto dto);

    /**
     *@author :winlin
     *@Description : 修改员工权限
     *@param: 员工id,新的权限
     *@return:
     *@date:2018/9/19
     */
    public Result<Boolean> updateRole(Long id,Integer role);

//    /**
//     * @author :winlin
//     * @Description :查询采购人下所有的供应商
//     * @param:
//     * @return:
//     * @date:2018/9/19
//     */
//    public Result<List<PurchaserSupplierVo>> queryAllSuppliers(Long purchaseId);

//    /**
//     * @author :winlin
//     * @Description : 模糊查询供应商,根据姓名
//     * @param:
//     * @return:
//     * @date:2018/9/19
//     */
//    public Result<List<PurchaserSupplierVo>> querySuppliers(String fuzzyName,Long purchaseId);

    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result<SupplierDetailVo> querySuppliersDto(QueryDto dto);
    /**
     *@author :winlin
     *@Description : id查询专家详情
     *@param:
     *@return:
     *@date:2018/10/2
     */
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(QueryDto dto);

    /**
     *@author :winlin
     *@Description :依据id查询代理机构
     *@param:
     *@return:
     *@date:2018/10/2
     */
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(QueryDto dto);

//    /**
//     * @author :winlin
//     * @Description :修改供应商信息
//     * @param:
//     * @return:
//     * @date:2018/9/19
//     */
//    public Result<Boolean> updateSuppliers(HandleSupplierDto attachment);


    /**
     *@author :winlin
     *@Description :根据id删除专家,修改is_delete状态
     *@param:
     *@return:
     *@date:2018/9/19
     */
    public Result<Boolean> updateExpertState(Long id ,Integer state);
//    /**
//     *@author :winlin
//     *@Description :修改采购人代理机构详细信息
//     *@param:
//     *@return:
//     *@date:2018/9/21
//     */
//    public Result<Boolean> updatePurchaserAgency(HandleAgencyDto agencyDto);
//    /**
//     *@author :winlin
//     *@Description :修改采购人专家的信息
//     *@param:
//     *@return:
//     *@date:2018/9/21
//     */
//    public Result<Boolean> updatePurchaserExpert(HandleExpertDto expertDto);








}
