package com.epc.web.client.controller.Operator;

import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.common.Result;
import com.epc.web.client.remoteApi.OperatorClient;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Api(value = "运营商服务")
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class OperatorController {

    @Autowired
    private OperatorClient operatorClient;

    /**
     * @Description:    新增运营商
     * @Author:         linzhixiang
     * @CreateDate:     2018/9/13 10:34
     * @UpdateUser:     linzhixiang
     * @UpdateDate:     2018/9/13 10:34
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */

    @ApiOperation(value = "注册 运营商",notes = "平台添加运营商人员")
    @PostMapping(value = "/createOperatorBasicInfo")
    public Result<Boolean> createOperatorBasicInfo(@RequestBody HandleOperator handleOperator) {
        return operatorClient.createOperatorUserInfo(handleOperator);
    }


    /**
    * @Description:    运营商新增采购人
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 10:34
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 10:34
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    @ApiOperation(value = "运营商添加采购人",notes = "运营商添加采购人")
    @PostMapping(value = "/createPurchaseByOperator")
    public Result<Boolean> createPurchaseByOperator(@RequestBody HandlePurchaser handleOperator) {
        return operatorClient.createPurchaseByOperator(handleOperator);
    }
}
