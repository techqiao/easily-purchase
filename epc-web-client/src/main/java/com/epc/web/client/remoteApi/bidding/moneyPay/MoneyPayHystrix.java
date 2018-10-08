package com.epc.web.client.remoteApi.bidding.moneyPay;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeMoneyPayService;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import com.epc.web.facade.bidding.vo.ServicePayVO;

import java.util.List;

public class MoneyPayHystrix implements FacadeMoneyPayService {


    @Override
    public Result<List<MoneyPayVO>> getMoneyPayList(QueryMoneyPayDTO dto) {
        return Result.hystrixError();    }

    @Override
    public Result<List<ServicePayVO>> IsPayForServiceMoney(QueryMoneyPayRecordDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertPurchaseProjectFilePay(HandleFilePay handle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertGuaranteeAmountPay(HandleGuaranteeAmountPay handle) {
        return Result.hystrixError();
    }
}
