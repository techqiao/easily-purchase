package com.epc.platform.service.controller.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.common.Result;
import com.epc.platform.service.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@RestController
public class OperatorServerController implements FacadeOperatorService {
    @Autowired
    private OperatorService operatorService;

    @Override
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody UserBasicInfo handleOperator) {
        return operatorService.insertOperatorBasicInfo(handleOperator);
    }

    @Override
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailIfo roleDetailIfo) {
        return operatorService.insertOperatorDetailInfo(roleDetailIfo);
    }



}
