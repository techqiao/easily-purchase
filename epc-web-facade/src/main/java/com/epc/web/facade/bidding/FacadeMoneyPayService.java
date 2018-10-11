package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.query.moneyPay.ServiceMoneyListForAllDTO;
import com.epc.web.facade.bidding.vo.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 支付业务
 * @author linzhixiang
 */
public interface FacadeMoneyPayService {

    /**
     * 获取 缴纳投标保证金列表
     * @param dto
     * @return
     */
    @PostMapping(value = "getMoneyPayList", consumes = "application/json; charset=UTF-8")
    Result<List<MoneyPayVO>> getMoneyPayList(@RequestBody QueryMoneyPayDTO dto);
    /**
     * 查询是否标段支付服务费
     * @param dto
     * @return
     */
    @PostMapping(value = "IsPayForServiceMoney", consumes = "application/json; charset=UTF-8")
    Result<List<ServicePayVO>> IsPayForServiceMoney(@RequestBody QueryMoneyPayRecordDTO dto);
    /**
     * 平台插入用户招标文件下载金支付记录
     * @param handle
     * @return
     */
    @PostMapping(value = "insertPurchaseProjectFilePay", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertPurchaseProjectFilePay(@RequestBody  HandleFilePay handle);
    /**
     * 平台插入用户标段保证金支付记录
     * @param handle
     * @return
     */
    @PostMapping(value = "insertGuaranteeAmountPay", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertGuaranteeAmountPay(@RequestBody HandleGuaranteeAmountPay handle);


    /**
     * 保证金退还列表
     * @param dto
     * @return
     */
    @PostMapping(value = "getGuarantyBackPayList", consumes = "application/json; charset=UTF-8")
    Result<List<ServiceBackVO>> getGuarantyBackPayList(@RequestBody QueryMoneyPayRecordDTO dto);


    /**
     * 服务费缴费列表（角色缴费记录列表）
     * @param queryMoneyPayRecordDTO
     * @return
     */
    @PostMapping(value = "getServiceMoneyListForAll", consumes = "application/json; charset=UTF-8")
    Result<List<PayListForAllVO>> getServiceMoneyListForAll(@RequestBody ServiceMoneyListForAllDTO queryMoneyPayRecordDTO);



    /**
     * 是否支付下载金额
     * @param dto
     * @return
     */
    @PostMapping(value = "isPayForProjectFile", consumes = "application/json; charset=UTF-8")
    Boolean isPayForProjectFile(@RequestBody QueryProgramPayDTO dto);

}
