package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.BasePersonInfo;
import com.epc.web.facade.bidding.handle.HandleSign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FacadeSignService {

    /**
     * 供应商签到
     * @param handleSign
     * @return
     */
    @PostMapping(value = "insertSullierSign", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertSullierSign(@RequestBody HandleSign handleSign);


    /**
     * 获取签到人员基本信息
     * @param basePersonInfo
     * @return
     */
    @PostMapping(value = "getSignBase", consumes = "application/json; charset=UTF-8")
    Result<SignBaseDTO> getSignBase(@RequestBody BasePersonInfo basePersonInfo) ;

}
