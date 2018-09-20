package com.epc.web.client.controller.operator;

import com.epc.web.client.controller.operator.handle.ClientHandleOperator;
import com.epc.web.client.controller.supplier.handle.ClientHandleSupplierDetail;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.common.Result;
import com.epc.web.client.remoteApi.operator.OperatorClient;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(value = "运营商服务",tags = {"运营商服务"})
@RestController
@RequestMapping(value = "/operator", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @PostMapping(value = "/registerOperator")
    public Result<Boolean> createOperatorBasicInfo(@RequestBody ClientHandleOperator clientHandleOperator) {
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
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
    @PostMapping(value = "/registerPurchaser")
    public Result<Boolean> createPurchaseByOperator(@RequestBody HandlePurchaser handleOperator) {

//        HandleOperator handleOperator1=new HandleOperator();
//        BeanUtils.copyProperties(clientHandleOperator,handleOperator1);
        return operatorClient.createPurchaseByOperator(handleOperator);
    }


    /**
    * @Description:    完善供应商信息
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/14 19:21
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/14 19:21
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "完善供应商信息",notes = "完善供应商信息")
    @PostMapping(value = "/updateSupplierDetail")
    public Result<Boolean> updateSupplierDetail(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail) {
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return operatorClient.updateSupplierDetail(handleSupplierDetail);
    }
}
