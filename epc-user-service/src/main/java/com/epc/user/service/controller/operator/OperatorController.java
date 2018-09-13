package com.epc.user.service.controller.operator;


import com.epc.common.Result;
import com.epc.user.service.service.operator.OperatorService;
import com.epc.user.service.service.purchaser.PurchaserService;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OperatorController  implements FacadeOperatorService {

    @Autowired
    OperatorService operatorService;
    @Autowired
    PurchaserService purchaserService;

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
    public Result<Boolean> createOperatorUserInfo(HandleOperator handleOperator) {
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
    public Result<Boolean> createPurchaseByOperator(HandlePurchaser handlePurchaser) {
        return operatorService.createPurchaseByOperator(handlePurchaser);
    }

}
