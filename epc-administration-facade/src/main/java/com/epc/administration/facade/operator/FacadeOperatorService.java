package com.epc.administration.facade.operator;

import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
public interface FacadeOperatorService {
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorBasicInfo(@RequestBody HandleOperatorBasicInfo handleOperatorBasicInfo);
}
