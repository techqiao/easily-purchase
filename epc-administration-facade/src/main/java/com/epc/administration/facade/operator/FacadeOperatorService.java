package com.epc.administration.facade.operator;

import com.epc.administration.facade.operator.handle.HandleOperator;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
public interface FacadeOperatorService {
    @PostMapping("/insert")
    Boolean insert(HandleOperator handleOperator);
}
