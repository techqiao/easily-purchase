package com.epc.web.service.controller.operator;


import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.service.service.operator.OperatorService;
import com.epc.web.service.service.purchaser.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public class OperatorController implements FacadeOperatorService {

    @Autowired
    private OperatorService operatorService;
    @Autowired
    private PurchaserService purchaserService;


    /**
     * 注册运营商
     * @author donghuan
     */
    @Override
    public Result<Boolean> registerOperator(@RequestBody  HandleOperator handleOperator) {
        return operatorService.registerOperator(handleOperator);
    }

    /**
     * 查询运营商用户信息
     * @author donghuan
     */
    @Override
    public  Result<OperatorBasicInfoVO> findByName(@RequestBody HandleOperator handleOperator) {
        return operatorService.findByName(handleOperator);
    }

    /**
     * 忘记密码
     * @author donghuan
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword) {
        return operatorService.forgetPassword(handleOperatorForgetPassword);
    }

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    @Override
    public Result<Boolean> createOperatorEmployee(@RequestBody HandleOperatorAddEmployee handleOperatorAddEmployee) {
        return operatorService.createOperatorEmployee(handleOperatorAddEmployee);
    }

    /**
     *  根据员工的id来更新该员工的个人信息
     *  @author donghuan
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        return operatorService.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    @Override
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(@RequestBody HandleOperatorFindAllByName handleOperatorFindAllByName) {
        return operatorService.queryOperatorEmployeeAll(handleOperatorFindAllByName);
    }



    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @Override
    public Result<Boolean> createSupplierByOperator(@RequestBody HandleCreateSupplerByOperator handleCreateSupplerByOperator) {
        return operatorService.createSupplierByOperator(handleCreateSupplerByOperator);
    }




    /**
     * @Description:    运营商新增采购人
     */

    @Override
    public Result<Boolean> createPurchaseByOperator(@RequestBody HandlePurchaser handlePurchaser) {
        return operatorService.createPurchaseByOperator(handlePurchaser);
    }


    /**
     * 完善 供应商信息
     * @param handleSupplierDetail
     * @return
     */
    @Override
    public Result<Boolean> updateSupplierDetail(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return purchaserService.updateSupplierDetail(handleSupplierDetail);
    }
}
