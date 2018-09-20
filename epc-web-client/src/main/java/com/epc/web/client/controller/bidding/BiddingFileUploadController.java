package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.file.ClientHandleFileUpload;
import com.epc.web.client.remoteApi.bidding.pretrialFile.BiddingClient;
import com.epc.web.facade.bidding.handle.HandleFileUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "投标流程",tags = {"上传预审信息"})
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class BiddingFileUploadController{
    @Autowired
    BiddingClient biddingClient;

    @ApiOperation(value = "提交（预审/投标）文件")
    @PostMapping(value="/fileUpload")
    public Result<Boolean> updatePretrialFile(ClientHandleFileUpload clientHandleFileUpload) {
        HandleFileUpload handleFileUpload=new HandleFileUpload();
        BeanUtils.copyProperties(clientHandleFileUpload,handleFileUpload);
        return biddingClient.updatePretrialFile(handleFileUpload);
    }

}
