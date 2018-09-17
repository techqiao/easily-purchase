package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.supplier.handle.HandlerSupplierUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/supplier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController {

    @Autowired
    private SupplierClient supplierClient;

    /**
    * @Description:    供应商添加员工
    * @Author:         donghuan
    * @param
    * @CreateDate:     16:35 2018/9/13
    * @UpdateUser:
    * @UpdateDate:     16:35 2018/9/13
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "供应商添加员工",notes = "供应商添加员工")
    @PostMapping(value="/createSupplierUser")
    public Result<Boolean> createSupplierUser(@RequestBody HandlerSupplierUser handlerSupplierUser){
        return supplierClient.createSupplierUser(handlerSupplierUser);
    }

}
