package com.epc.web.facade.oss;

import com.epc.common.Result;
import com.epc.web.facade.oss.query.ApplyToken;
import com.epc.web.facade.oss.vo.UpTokenResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:    对象存储凭证服务
 * @Author:         SongXing
 * @CreateDate:     2018/9/13 9:50
 * @Version:        1.0
 */
public interface FacadeOssTokenService {

    @PostMapping(value = "OssTokenController/getUpToken",consumes = "application/json; charset=UTF-8")
    Result<UpTokenResultVO> getUpToken(@RequestBody ApplyToken applyToken);

    @GetMapping(value = "/getReWriteToken")
    Result<String> getReWriteToken(@RequestParam("fileName") String fileName);

    @GetMapping(value = "/getPrivatePath")
    Result<String> getPrivatePath(@RequestParam("fileKey") String fileKey);

}
