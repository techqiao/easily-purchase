package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.file.ClientFileUpload;
import com.epc.web.client.controller.bidding.handle.file.ClientHandleFileUpload;
import com.epc.web.client.controller.bidding.handle.file.ClientNoticeFileLoad;
import com.epc.web.client.controller.bidding.handle.file.ClientNoticeLoad;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.pretrialFile.BiddingClient;
import com.epc.web.facade.bidding.handle.HandleNotice;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @Description:  提交 文件
* @Author: linzhixiang
* @Date: 2018/9/20
*/
@Api(value = "预审/投标 信息修改",tags = "预审文件/投标文件")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingFileUploadController extends BaseController {
    @Autowired
    BiddingClient biddingClient;

    @ApiOperation(value = "新增/更新/删除  预审信息")
    @PostMapping(value="/updatePretrialFile")
    public Result<Boolean> updatePretrialFile(@RequestBody ClientFileUpload clientFileUpload) {
        List<ClientHandleFileUpload> list=clientFileUpload.getFileList();
        if(list.size()>0){
            for(ClientHandleFileUpload clientHandleFileUpload:list){
                HandlePretriaFile handlePretriaFile=new HandlePretriaFile();
                BeanUtils.copyProperties(clientHandleFileUpload,handlePretriaFile);
                handlePretriaFile.setOperateId(getLoginUser().getUserId());
                handlePretriaFile.setOperateName(getLoginUser().getName());
                handlePretriaFile.setCompanyId(getLoginUser().getBossId());
                handlePretriaFile.setCompanyName(getLoginUser().getBossName());
                biddingClient.updatePretrialFile(handlePretriaFile);
            }
        }
        return Result.success(true);
    }

    @ApiOperation(value = "新增/更新/删除 投标文件")
    @PostMapping(value="/updateNotice")
    Result<Boolean> updateNotice(@RequestBody ClientNoticeLoad clientNoticeLoad, HttpServletRequest request){
        List<ClientNoticeFileLoad> list=clientNoticeLoad.getClientNoticeFileLoad();
        if(!CollectionUtils.isEmpty(list)){
            for(ClientNoticeFileLoad dto:list){
                HandleNotice handleNotice=new HandleNotice();
                BeanUtils.copyProperties(dto,handleNotice);
                handleNotice.setOperateId(getLoginUser().getUserId());
                handleNotice.setOperateName(getLoginUser().getName());
                handleNotice.setCompanyId(getLoginUser().getBossId());
                handleNotice.setCompanyName(getLoginUser().getBossName());
                handleNotice.setIp(request.getRemoteHost());
                biddingClient.updateNotice(handleNotice);
            }
        }
        return Result.success(true);
    }
}
