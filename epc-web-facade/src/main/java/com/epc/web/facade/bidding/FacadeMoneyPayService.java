package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FacadeMoneyPayService {

    @PostMapping(value = "getMoneyPayList", consumes = "application/json; charset=UTF-8")
    Result<List<MoneyPayVO>> getMoneyPayList(@RequestBody QueryMoneyPayDTO dto);

    @PostMapping(value = "IsPayForServiceMoney", consumes = "application/json; charset=UTF-8")
    Result<Boolean> IsPayForServiceMoney(@RequestBody QueryMoneyPayRecordDTO dto);


    }
