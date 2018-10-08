package com.epc.bidding.service.moneyPay;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import com.epc.web.facade.bidding.vo.ServiceBackVO;
import com.epc.web.facade.bidding.vo.ServicePayVO;

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
     * 缴纳中标 服务费列表
     * @param dto
     * @return
     */
    Result<List<ServicePayVO>> IsPayForServiceMoney(QueryMoneyPayRecordDTO dto);

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
}
