package com.epc.administration.facade.operator;

import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.administration.facade.operator.handle.HandleOperatorDetailIfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description : 运营商接口
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
public interface FacadeOperatorService {
    /**
     * 运营商注册
     * @param handleOperatorBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "insertOperatorBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorBasicInfo(@RequestBody HandleOperatorBasicInfo handleOperatorBasicInfo);

    /**
     * 运营商完善资料
     * @param handleOperatorDetailIfo 附件信息
     * @return
     */
    @PostMapping(value = "insertOperatorDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorDetailInfo(@RequestBody HandleOperatorDetailIfo handleOperatorDetailIfo);
}
