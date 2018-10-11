package com.epc.web.client.remoteApi.bidding.moneyPay;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeMoneyPayService;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.query.moneyPay.ServiceMoneyListForAllDTO;
import com.epc.web.facade.bidding.vo.*;

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

    @Override
    public Result<List<ServiceBackVO>> getGuarantyBackPayList(QueryMoneyPayRecordDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PayListForAllVO>> getServiceMoneyListForAll(ServiceMoneyListForAllDTO queryMoneyPayRecordDTO) {
        return Result.hystrixError();
    }

    @Override
    public Boolean isPayForProjectFile(QueryProgramPayDTO dto) {
        return null;
    }

    @Override
    public BankAccountVO getBankAccount(int documents) {
        return null;
    }

}
