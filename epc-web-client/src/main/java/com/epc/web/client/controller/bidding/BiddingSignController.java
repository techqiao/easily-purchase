package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.sign.ClientPersonInfo;
import com.epc.web.client.controller.bidding.handle.sign.ClientSign;
import com.epc.web.client.remoteApi.bidding.sign.SignClient;
import com.epc.web.client.remoteApi.bidding.sign.SupplierBaseClient;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.BasePersonInfo;
import com.epc.web.facade.bidding.handle.HandleSign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "供应商签到服务",description = "供应商签到")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingSignController {
    @Autowired
    SignClient signClient;
    @Autowired
    SupplierBaseClient supplierBaseClient;

    @ApiOperation(value = "签到")
    @PostMapping(value="/supplierSign")
    public Result<Boolean> supplierSign(@RequestBody ClientSign clientSign){
        BasePersonInfo basePersonInfo =new BasePersonInfo();
        BeanUtils.copyProperties(clientSign,basePersonInfo);
        SignBaseDTO signBaseDTO=signClient.getSignBase(basePersonInfo).getData();

        if(signBaseDTO==null){
            return Result.error("数据库查询不到该用户的信息");
        }

        HandleSign handleSign=new HandleSign();
        BeanUtils.copyProperties(clientSign,handleSign);
        BeanUtils.copyProperties(signBaseDTO,handleSign);
        return signClient.insertSullierSign(handleSign);
    }

}
