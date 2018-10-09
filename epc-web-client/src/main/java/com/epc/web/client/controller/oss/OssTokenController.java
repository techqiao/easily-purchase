package com.epc.web.client.controller.oss;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.oss.OssTokenClient;
import com.epc.web.facade.oss.query.ApplyToken;
import com.epc.web.facade.oss.vo.UpTokenResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author SongXing
 * @Description: 对象存储凭证服务
 * @date 2018-10-9 14:26:07
 */
@Api(value = "OssTokenController",tags = "凭证服务")
@RestController
@RequestMapping(value = "OssTokenController")
public class OssTokenController {
    @Autowired
    OssTokenClient ossTokenClient;

    @ApiOperation(value = "申请上传凭证", notes = "申请上传凭证,参数：模块+文件原名，返回：凭证+文件存储key")
    @PostMapping(value = "getUpToken", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<UpTokenResultVO> getUpToken(@RequestBody ApplyToken applyToken) {
        return ossTokenClient.getUpToken(applyToken);
    }
    @ApiOperation(value = "申请上传覆盖写凭证", notes = "申请上传复写凭证，覆盖旧的文件")
    @GetMapping(value = "getReWriteToken", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> getReWriteToken(@RequestParam("fileName") String fileName) {
        return ossTokenClient.getReWriteToken(fileName);
    }
    @ApiOperation(value = "申请", notes = "申请下载凭证，参数+文件key，返回：文件私有路径")
    @GetMapping(value = "getPrivatePath", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> getPrivatePath(@RequestParam("fileKey") String fileKey) {
        return ossTokenClient.getPrivatePath(fileKey);
    }
}
