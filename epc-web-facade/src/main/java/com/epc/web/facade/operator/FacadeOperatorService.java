package com.epc.web.facade.operator;

import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.operator.handle.HandleOperatorDetail;
import com.epc.web.facade.operator.handle.HandleOperatorForgetPassword;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param HandleOperatorDetail
     * @return
     */
    @PostMapping(value = "registerOperator",consumes = "application/json;charset=UTF-8")
    Result<Boolean> registerOperator(@RequestBody HandleOperatorDetail HandleOperatorDetail);


    /**
     * 查询用户信息
     * @author donghuan
     * @param name
     * @param cellphone
     * @return
     */
    @PostMapping(value = "findByName", consumes = "application/json; charset=UTF-8")
    Result<OperatorBasicInfoVO> findByName(@RequestParam String name, String cellphone);

    /**
     * 忘记密码
     * @author donghuan
     * @param handleOperatorForgetPassword
     */
    @PostMapping(value = "forgetPassword", consumes = "application/json; charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword);


    /*       ==============================================             */


    /**
     * 运营商 注册人员
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "createOperatorUserInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createOperatorUserInfo(@RequestBody HandleOperator handleOperator);


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
    Result<Boolean> updateSupplierDetail(@RequestBody HandleSupplierDetail handlePurchaser) ;

}
