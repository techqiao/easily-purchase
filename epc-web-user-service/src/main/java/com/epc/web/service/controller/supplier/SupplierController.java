package com.epc.web.service.controller.supplier;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.query.QuerywithPageHandle;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierCategoryVo;
import com.epc.web.facade.supplier.vo.TenderMessageVO;
import com.epc.web.service.controller.BaseController;
import com.epc.web.service.service.supplier.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 供应商服务
 * @author donghuan
 */
@RestController
public class SupplierController extends BaseController implements FacadeTSupplierBasicInfoService {

    @Autowired
    private SupplierService supplierService;

    /**0
     * 注册供应商
     *  {业务：    还需要要判断电话在数据库中有没有，（有无人拉。如无，就是自己注册；如有，就是添加密码登陆完善个人信息）
     *         1. 第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *              所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *         2.  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  }
     *  自己找到平台网站注册供应商
     */
    @Override
    public Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail){
        return supplierService.registerSupplier(handleSupplierDetail);
    }



    /**2
     *  完善供应商信息
     */
    @Override
    public Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo){
        return supplierService.insertCompleteSupplierInfo(roleDetailInfo);
    }

    //--------------------------平台审核通过之后----------------------------------

    /**3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @Override
    public Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee){
        return supplierService.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**4
     * 根据员工的id来查询基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody HandleFindSupplierBasicById handleFindSupplierBasicById){
        return supplierService.findSupplierBasicById(handleFindSupplierBasicById);
    }

    /**5
     *  供应商通过id修改员工
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById){
        return supplierService.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @Override
    public Result<RoleDetailInfo> findSupplierDetailByEmployee(@RequestBody HandleFindSupplierBasicById handleFindSupplierBasicById) {
        return supplierService.findSupplierDetailByEmployee(handleFindSupplierBasicById);
    }
    /**6.5  查看公司详情
     * 管理员或者员工 通过登陆信息里面的 bossId 来查看  公司详情（包括附件）
     */
    @Override
    public Result<RoleDetailInfo> findSupplierByBossId(@RequestBody HandleFindSupplierBasicById handleFindSupplierBasicById){
        return supplierService.findSupplierByBossId(handleFindSupplierBasicById);
    }

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    public Result<Boolean> findSupplierRecordByCellphone(@RequestBody HandleSupplierCellphone handleSupplierCellphone){
        return supplierService.findSupplierRecordByCellphone(handleSupplierCellphone);
    }

    /**8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleSupplierCellphone handleSupplierCellphone){
        return supplierService.findSupplierByCellphone(handleSupplierCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden){
        return supplierService.updateSupplierEmployeeByisDeleted(handleSupplierIdAndIsForbidden);
    }

    /**10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @Override
    public Result<Boolean> deleteSupplierEmployeeById(@RequestBody HandleSupplieIsDeleted handleSupplieIsDeleted){
        return supplierService.deleteSupplierEmployeeById(handleSupplieIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole){
        return supplierService.updateSupplierEmployeeRoleById(handleOperatorRole);
    }

    /**12
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState){
        return supplierService.updateSupplierEmployeeStateById(handleOperatorState);
    }

    /**13
     *  忘记密码
     */
    @Override
    public Result<Boolean> forgetPasswordSupplier(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return supplierService.forgetPasswordSupplier(handleSupplierForgetPassword);
    }


    /**14
     * 根据员工的名字,角色，是否禁用
     * 来匹配出符合条件的员工返回一个list：
     */
    @Override
    public Result<Map<String,Object>> querySupplierEmployeeAll(@RequestBody HandleSupplierIdAndName handleSupplierIdAndName){
        PageHelper.startPage(handleSupplierIdAndName.getPageNum(),handleSupplierIdAndName.getPageSize());
        Result<List<SupplierBasicInfoVO>> listVOS=supplierService.querySupplierEmployeeAll(handleSupplierIdAndName);
        List<SupplierBasicInfoVO> data = listVOS.getData();
        PageInfo<SupplierBasicInfoVO> pageInfo=new PageInfo<>(data);
        Map<String,Object> dataTable=getDataTable(pageInfo);
        return Result.success(dataTable);
    }




    /**
     * 投标项目列表展示
     * @param querywithPageHandle
     * @return
     */
    @Override
    public Result<Map<String, Object>> querySupplierProject(@RequestBody QuerywithPageHandle querywithPageHandle) {
        PageHelper.startPage(querywithPageHandle.getPageNum(),querywithPageHandle.getPageSize());
        Result<List<TenderMessageVO>> listResult= supplierService.querySupplierProject(querywithPageHandle);
        PageInfo<TenderMessageVO> pageInfo = new PageInfo<>(listResult.getData());
        return Result.success(getDataTable(pageInfo));
    }

    @Override
    public Result<List<SupplierCategoryVo>> querySupplierCategory() {
        return supplierService.querySupplierCategory();
    }
}
