package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.GuarantyListVo;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
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
    Result<List<GuarantyListVo>> getMoneyPayList(@RequestBody QueryMoneyPayDTO dto);
    /**
     * 查询是否标段支付服务费
     * @param dto
     * @return
     */
    @PostMapping(value = "IsPayForServiceMoney", consumes = "application/json; charset=UTF-8")
    Result<Boolean> IsPayForServiceMoney(@RequestBody QueryMoneyPayRecordDTO dto);
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

    }
