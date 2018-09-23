package com.epc.bidding.service.moneyPay;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;

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
     * 根据中标服务费表ID查询某标段供应商的服务费是否支付
     * @param dto
     * @return
     */
     Result<Boolean> IsPayForServiceMoney(QueryMoneyPayRecordDTO dto);

    }
