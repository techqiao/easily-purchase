package com.epc.web.service.controller.operator;


import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorDetail;
import com.epc.web.facade.operator.handle.HandleOperatorForgetPassword;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.service.operator.OperatorService;
import com.epc.web.service.service.operator.OperatorUserService;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public class OperatorController implements FacadeOperatorService {

    @Autowired
    OperatorService operatorService;
    @Autowired
    PurchaserService purchaserService;

    @Autowired
    OperatorUserService operatorUserService;

    /**
     * 注册运营商
     * @author donghuan
     * @param HandleOperatorDetail
     * @return
     */
    @Override
    public Result<Boolean> registerOperator(@RequestBody  HandleOperatorDetail HandleOperatorDetail) {
        return operatorUserService.registerOperator(HandleOperatorDetail);
    }

    /**
     * 通过名字或者电话号码得到这个人的信息
     * @author donghuan
     * @param name
     * @param cellphone
     * @return
     */
    @Override
    public  Result<OperatorBasicInfoVO> findByName(@RequestBody String name, String cellphone) {
        return operatorUserService.findByName(name,cellphone);
    }

    /**
     * 忘记密码
     * @author donghuan
     * @param handleOperatorForgetPassword
     * @return
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword) {
        return operatorUserService.forgetPassword(handleOperatorForgetPassword);
    }


    /*===============================================================*/


    /**
    * @Description:    新增运营商人员
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 9:49
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 9:49
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @Override
    public Result<Boolean> createOperatorUserInfo(@RequestBody HandleOperator handleOperator) {
        return operatorService.createOperatorBasicInfo(handleOperator);
    }

    /**
     * @Description:    运营商新增采购人
     * @Author:         linzhixiang
     * @CreateDate:     2018/9/13 9:49
     * @UpdateUser:     linzhixiang
     * @UpdateDate:     2018/9/13 9:49
     * @UpdateRemark:   修改内容
     * @Version:        1.0
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
