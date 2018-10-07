package com.epc.bidding.controller.moneyPay;


import com.epc.bidding.service.moneyPay.MoneyPayService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeMoneyPayService;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiddingMoneyPayController implements FacadeMoneyPayService {

    @Autowired
    MoneyPayService moneyPayService;

    /**
     * 获取 缴纳投标保证金列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<MoneyPayVO>> getMoneyPayList(@RequestBody QueryMoneyPayDTO dto){
        return moneyPayService.getMoneyPayList(dto);
    }

    /**
     * 查询是否标段支付服务费
     * @param dto
     * @return
     */
    @Override
    public Result<Boolean> IsPayForServiceMoney(@RequestBody QueryMoneyPayRecordDTO dto){
        return moneyPayService.IsPayForServiceMoney(dto);
    }


    /**
     * 平台插入用户招标文件下载金支付记录
     * @param handle
     * @return
     */
    @Override
    public Result<Boolean> insertPurchaseProjectFilePay(@RequestBody HandleFilePay handle) {
        return moneyPayService.insertPurchaseProjectFilePay(handle);
    }

    /**
     * 平台插入用户标段保证金支付记录
     * @param handle
     * @return
     */
    @Override
    public Result<Boolean> insertGuaranteeAmountPay(@RequestBody HandleGuaranteeAmountPay handle) {
        return moneyPayService.insertGuaranteeAmountPay(handle);
    }

}
