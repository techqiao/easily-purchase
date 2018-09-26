package com.epc.bidding.controller.bidding;


import com.epc.bidding.service.sign.SignService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeSignService;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.BasePersonInfo;
import com.epc.web.facade.bidding.handle.HandleSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BiddingSignController implements FacadeSignService {

    @Autowired
    SignService signService;

    /**
     * 供应商签到
     * @author linzhixiang
     */
    @Override
    public Result<Boolean> insertSullierSign(@RequestBody  HandleSign handleSign){
       return signService.insertSupplierSign(handleSign);
    }

    /**
     * 获取签到人员信息
     * @param basePersonInfo
     * @return
     */
    @Override
    public Result<SignBaseDTO> getSignBase(@RequestBody BasePersonInfo basePersonInfo) {
        return signService.getSignBase(basePersonInfo.getName(),basePersonInfo.getCellPhone());
    }

}
