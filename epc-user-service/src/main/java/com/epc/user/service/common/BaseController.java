/**
 * }
 * Copyright 2016
 * Copyright 2016 linglingqi Group Holding Ltd. All Rights Reserved
 */
package com.epc.user.service.common;

import org.apache.commons.lang.StringUtils;

import java.util.List;

public abstract class BaseController {

    /**
     * 获取csrf_token,设置是否登录的标记
     *
     * @param baseResult
     *
     * @return
     */
    protected BaseResult returnResult(BaseResult baseResult) {


        if (baseResult.getData() != null && (baseResult.getData().getClass().isArray()
                                             || baseResult.getData() instanceof List)) {
            // 统一Object封装
            baseResult.setData(new Items(baseResult.getData()));
        }

        return baseResult;
    }

    /**
     * 添加异常到结果
     * @param baseResult
     * @param ex
     */
    protected void setRuntimeException(BaseResult baseResult, BizRuntimeException ex){
        baseResult.setCode(ex.getErrorCode().getCode());
        baseResult.setMsg(ex.getErrorCode().getDesc());
        if(StringUtils.isNotEmpty(ex.getMessage())){
            baseResult.setMsg(ex.getMessage());
        }
    }

}
