package com.epc.platform.service.controller.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.handle.HandleOperator;
import com.epc.common.Const;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@RestController
public class FacadeOperatorController implements FacadeOperatorService {
    @Autowired
    private OperatorService operatorService;

    @Override
    public Result<Boolean> insertOperator(HandleOperator handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellphone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        return Result.createBySuccess(operatorService.insertOperator(pojo));
    }
}
