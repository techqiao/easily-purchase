package com.epc.platform.service.controller.operator;

import com.epc.api.expert.ExpertService;
import com.epc.platform.service.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-11 19:34
 * <p>@Author : wjq
 * <P>Email : wujiangqiao@difengshanguo.com
 */
@RestController
public class ExpertServerController implements ExpertService {

    @Autowired
    private OperatorService operatorService;

    @Override
    public Boolean insert() {
        return null;
    }
}
