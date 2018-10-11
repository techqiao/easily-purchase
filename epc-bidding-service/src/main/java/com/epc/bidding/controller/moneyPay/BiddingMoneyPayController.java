package com.epc.bidding.controller.moneyPay;


import com.epc.bidding.service.moneyPay.MoneyPayService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeMoneyPayService;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.query.moneyPay.ServiceMoneyListForAllDTO;
import com.epc.web.facade.bidding.vo.*;
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
    public Result<List<ServicePayVO>> IsPayForServiceMoney(@RequestBody QueryMoneyPayRecordDTO dto){
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

    @Override
    public Result<List<ServiceBackVO>> getGuarantyBackPayList(@RequestBody QueryMoneyPayRecordDTO dto) {
        return moneyPayService.getGuarantyBackPayList(dto);
    }


    /**
     * 服务费缴费列表（角色缴费记录列表）
     * @param queryMoneyPayRecordDTO
     * @return
     */
    @Override
    public Result<List<PayListForAllVO>> getServiceMoneyListForAll(@RequestBody ServiceMoneyListForAllDTO queryMoneyPayRecordDTO) {
        return moneyPayService.getServiceMoneyListForAll(queryMoneyPayRecordDTO);
    }

    /**
     * 是否支付下载文件金额
     * @param dto
     * @return
     */

    @Override
    public Boolean isPayForProjectFile(@RequestBody QueryProgramPayDTO dto){
        return moneyPayService.IsPayForProjectFile(dto);
    }

}
