package com.epc.bidding.service.sign;

import com.epc.common.Result;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.HandleSign;


public interface SignService {


    /**
     * 供应商签到
     * @author linzhixiang
     */

    Result<Boolean> insertSupplierSign(HandleSign handleSign);

    Result<SignBaseDTO> getSignBase(String name, String cellPhone) ;

}
