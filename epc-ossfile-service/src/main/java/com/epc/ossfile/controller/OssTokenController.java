package com.epc.ossfile.controller;

import com.epc.common.Result;
import com.epc.ossfile.domain.BusinessModelEnum;
import com.epc.ossfile.domain.OssTokenUtil;
import com.epc.web.facade.oss.FacadeOssTokenService;
import com.epc.web.facade.oss.query.ApplyToken;
import com.epc.web.facade.oss.vo.UpTokenResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @author SongXing
 * @Description: 获取上传凭证，相关的接口
 * @date 2018-10-9
 */
@RestController
public class OssTokenController implements FacadeOssTokenService {

    @Override
    public Result<UpTokenResultVO> getUpToken(@RequestBody ApplyToken applyToken){
        // 传入参数
        String regionFileName = applyToken.getRegionFileName();
        String businessModelCode = applyToken.getBusinessModelCode();

        if(StringUtils.isEmpty(regionFileName)){
            return Result.error("文件原名错误");
        }

        String modelValue = BusinessModelEnum.getModelValueByCode(businessModelCode);
        if(StringUtils.isEmpty(modelValue)){
            return Result.error("模块名错误");
        }

        String upToken = OssTokenUtil.getUpToken();
        String fullPath = this.getFullPathByModelValue(modelValue,regionFileName);
        // 输出参数
        UpTokenResultVO upTokenResult = new UpTokenResultVO(upToken,fullPath);
        return Result.success( "获得upToken成功",upTokenResult);
    }

    @Override
    // 文件复写权限
    public Result<String> getReWriteToken(@RequestParam String fileName){
        String reWriteToken ="";

        return Result.success("获得ReWriteToke成功",reWriteToken) ;
    }
    @Override
    // TODO 按照用户权限鉴定
    public Result<String> getPrivatePath(@RequestParam String fileKey){
        String privatePath = OssTokenUtil.getPrivatePath(fileKey);
        return  Result.success("获得私密路径成功",privatePath);
    }

    //  模块-时间戳-原文件名
    private  String getFullPathByModelValue(String modelValue,String regionFileName){
        long time = System.currentTimeMillis();
        String fullFilePath = modelValue+"_"+time+"_"+regionFileName;
        return  fullFilePath;
    }

}
