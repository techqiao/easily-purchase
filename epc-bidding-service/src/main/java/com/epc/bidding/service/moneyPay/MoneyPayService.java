package com.epc.bidding.service.moneyPay;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.query.moneyPay.ServiceMoneyListForAllDTO;
import com.epc.web.facade.bidding.vo.*;

import java.util.List;

/**
 * @author linzhixiang
 */
public interface MoneyPayService {
    /**
     * 获取 缴纳投标保证金列表
     * @param dto
     * @return
     */
     Result<List<MoneyPayVO>> getMoneyPayList(QueryMoneyPayDTO dto);


    /**
     * 平台插入下载金额支付记录
     * @param handle
     * @return
     */
     Result<Boolean> insertPurchaseProjectFilePay(HandleFilePay handle);

    /**
     * 平台插入保证金支付记录
     * @param handle
     * @return
     */
     Result<Boolean> insertGuaranteeAmountPay(HandleGuaranteeAmountPay handle);

    /**
     * 保证金退还列表
     * @param dto
     * @return
     */
    Result<List<ServiceBackVO>> getGuarantyBackPayList(QueryMoneyPayRecordDTO dto);

    /**
     * 缴纳中标 服务费列表
     * @param dto
     * @return
     */
    Result<List<ServicePayVO>> IsPayForServiceMoney(QueryMoneyPayRecordDTO dto);

    /**
     * 角色服务费缴费列表
     * @param queryMoneyPayRecordDTO
     * @return
     */
    Result<List<PayListForAllVO>> getServiceMoneyListForAll(ServiceMoneyListForAllDTO queryMoneyPayRecordDTO);

    /**
     * 查询供应商是否支付下载招标文件金额
     * @return
     */
    Boolean IsPayForProjectFile(QueryProgramPayDTO dto);

}
