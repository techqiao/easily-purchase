package com.epc.web.facade.operator;

import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import org.springframework.web.bind.annotation.PostMapping;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestBody;

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

}
