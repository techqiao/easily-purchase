package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.sign.ClientSignerDTO;
import com.epc.web.client.remoteApi.bidding.sign.SignClient;
import com.epc.web.client.remoteApi.bidding.sign.SupplierBaseClient;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.BasePersonInfo;
import com.epc.web.facade.bidding.handle.HandleSign;
import com.epc.web.facade.bidding.query.sign.QuerySignerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "供应商签到服务",tags = "供应商签到")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingSignController {
    @Autowired
    SignClient signClient;
    @Autowired
    SupplierBaseClient supplierBaseClient;

    @ApiOperation(value = "签到")
    @PostMapping(value="/supplierSign")
    public Result<Boolean> supplierSign(@RequestBody ClientSignerDTO clientSign){
        QuerySignerDTO querySignerDTO=new QuerySignerDTO();
        BeanUtils.copyProperties(clientSign,querySignerDTO);
        SignBaseDTO signBaseDTO=signClient.getSignerInfo(querySignerDTO).getData();

        if(signBaseDTO==null){
            return Result.error("签到人不在邀请范围内");
        }

        HandleSign handleSign=new HandleSign();
        BeanUtils.copyProperties(clientSign,handleSign);
        BeanUtils.copyProperties(signBaseDTO,handleSign);
        return signClient.insertSupplierSign(handleSign);
    }
}
