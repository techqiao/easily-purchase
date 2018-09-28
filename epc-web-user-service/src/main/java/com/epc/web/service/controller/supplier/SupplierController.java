package com.epc.web.service.controller.supplier;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorCellphone;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 供应商
 * @author donghuan
 */
@RestController
public class SupplierController implements FacadeTSupplierBasicInfoService {

    @Autowired
    private SupplierService supplierService;

    /**
     * 供应商注册
     */
    @Override
    public Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return supplierService.registerSupplier(handleSupplierDetail);
    }

    @Override
    public Result<Boolean> addPasswordSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return supplierService.addPasswordSupplier(handleSupplierDetail);
    }

    /**
     *  根据员工id来删除一个员工
     */
    @Override
    public Result<Boolean> deleteSupplierEmployeeById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return supplierService.deleteSupplierEmployeeById(handleFindSupplierByInfo);
    }

//    @Override
//    public Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone) {
//        return supplierService.deleteOperatorEmployeeByCellphone();
//    }

    /**
     * 根据员工的id来查询基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo){
        return supplierService.findSupplierBasicById(handleFindSupplierByInfo);
    }

    /**
     * 通过员工id 只 修改员工的状态
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody HandleSupplierEmployeeByisDeleted handleSupplierEmployeeByisDeleted) {
        return supplierService.updateSupplierEmployeeByisDeleted(handleSupplierEmployeeByisDeleted);
    }

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState){
        return  supplierService.updateSupplierEmployeeStateById(handleOperatorState);
    }


    /**
     * 员工来查询 公司详情
     */
    @Override
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return supplierService.findSupplierDetailByEmployee(handleFindSupplierByInfo);
    }

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole){
        return supplierService.updateSupplierEmployeeRoleById(handleOperatorRole);
    }

    /**
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    public Result<Boolean> findSupplierRecordByCellphone(@RequestBody HandleSupplierRecordByCellphone handleSupplierByCellphone){
        return supplierService.findSupplierRecordByCellphone(handleSupplierByCellphone);
    }

    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return supplierService.findSupplierByCellphone(handleFindSupplierByInfo);
    }


    /**
     *  忘记密码
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return supplierService.forgetPassword(handleSupplierForgetPassword);
    }

    /**
     * 供应商添加员工
     */
    @Override
    public Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return supplierService.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**
     * 通过供应商员工id更新一条信息
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return supplierService.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

    /**
     * 根据员工的姓名来模糊查询出一个符合要求的列表
     */
    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return supplierService.querySupplierEmployeeAll(handleFindSupplierByInfo);
    }

    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return supplierService.querySupplierEmployeeByisDeleted(handleFindSupplierByInfo);
    }

    /**
     * 完善供应商信息
     */
    @Override
    public Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo) {
        return supplierService.insertCompleteSupplierInfo(roleDetailInfo);
    }


}
