package com.epc.administration.client.remoteapi.oss;

import com.epc.common.Result;
import com.epc.web.facade.oss.FacadeOssTokenService;
import com.epc.web.facade.oss.query.ApplyToken;
import com.epc.web.facade.oss.vo.UpTokenResultVO;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 19:52
 * <p>@Author : luozhixin
 */
public class OssTokenHystrix implements FacadeOssTokenService {
    @Override
    public Result<UpTokenResultVO> getUpToken(ApplyToken applyToken) {
        return Result.hystrixError();
    }

    @Override
    public Result<String> getReWriteToken(String fileName) {
        return Result.hystrixError();
    }

    @Override
    public Result<String> getPrivatePath(String fileKey) {
        return Result.hystrixError();
    }
}
