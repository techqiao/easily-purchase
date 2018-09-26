package com.epc.web.client.remoteApi.bidding.sign;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeSignService;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.BasePersonInfo;
import com.epc.web.facade.bidding.handle.HandleSign;
import com.epc.web.facade.bidding.query.sign.QuerySignerDTO;
import org.springframework.cloud.netflix.feign.FeignClient;

public class SignHystrix  implements FacadeSignService {

    @Override
    public Result<Boolean> insertSupplierSign(HandleSign handleSign) {
        return Result.hystrixError();
    }

    @Override
    public Result<SignBaseDTO> getSignerInfo(QuerySignerDTO querySignerDTO) {
        return Result.hystrixError();
    }
}
