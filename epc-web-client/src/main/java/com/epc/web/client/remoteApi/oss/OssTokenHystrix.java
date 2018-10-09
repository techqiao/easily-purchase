package com.epc.web.client.remoteApi.oss;

import com.epc.common.Result;
import com.epc.web.facade.oss.FacadeOssTokenService;
import com.epc.web.facade.oss.query.ApplyToken;
import com.epc.web.facade.oss.vo.UpTokenResultVO;

/**
 * @author SongXing
 * @Description: 对象存储 凭证服务 熔断器
 * @date 2018-10-9 14:22:36
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
