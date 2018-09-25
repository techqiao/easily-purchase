package com.epc.web.facade.operator;

import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.purchaser.handle.PurchaserHandleSupplierDto;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description:    运营商服务
 * @Author:         linzhixiang
 * @CreateDate:     2018/9/13 9:50
 * @UpdateUser:     linzhixiang
 * @UpdateDate:     2018/9/13 9:50
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */

public interface FacadeOperatorService {


    /**
     * 注册运营商
     * @author donghuan
     */
    @PostMapping(value = "registerOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> registerOperator(@RequestBody HandleOperator handleOperator);

    /**
     * 忘记密码
     * @author donghuan
     */
    @PostMapping(value = "forgetPasswordOperator", consumes = "application/json; charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword);

    /**
     * 查询用户信息
     * @author donghuan
     */
    @PostMapping(value = "findByNameOperator", consumes = "application/json; charset=UTF-8")
    Result<OperatorBasicInfoVO> findByName(@RequestBody HandleOperator handleOperator);

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    @PostMapping(value = "createOperatorEmployee",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createOperatorEmployee(@RequestBody HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**
     *  根据员工的id来更新该员工的个人信息
     *  @author donghuan
     */
    @PostMapping(value = "updateOperatorEmployeeById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeById(@RequestBody HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    @PostMapping(value = "queryOperatorEmployeeAll",consumes = "application/json; charset=UTF-8")
    Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(@RequestBody HandleOperatorFindAllByName handleOperatorFindAllByName);

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @PostMapping(value = "createSupplierByOperator",consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierByOperator(@RequestBody HandleCreateSupplerByOperator handleCreateSupplerByOperator);



    /**
     * 运营商 注册采购人
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "createPurchaseByOperator", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaseByOperator(@RequestBody HandlePurchaser handleOperator);

    /**
     * 完善信息
     * @param handlePurchaser
     * @return
     */
    @PostMapping(value = "updateSupplierDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateSupplierDetail(@RequestBody PurchaserHandleSupplierDto handlePurchaser) ;

}
