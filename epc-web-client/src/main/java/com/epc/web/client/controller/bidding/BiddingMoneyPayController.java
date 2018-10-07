package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.moneyPay.ClientFilePay;
import com.epc.web.client.controller.bidding.query.moneyPay.ClientMoneyPayDTO;
import com.epc.web.client.controller.bidding.query.moneyPay.ClientMoneyPayRecordDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.moneyPay.MoneyPayClient;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.GuarantyListVo;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @Description: 支付业务
 * @Author: linzhixiang
 * @Date: 2018/9/28
 */ 
@Api(value = "支付业务",tags = "支付业务")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class BiddingMoneyPayController extends BaseController {

    @Autowired
    MoneyPayClient moneyPayClient;

    @ApiOperation(value = "获取保证金支付列表",tags = "获取保证金支付列表")
    @PostMapping(value = "getMoneyPayList", consumes = "application/json; charset=UTF-8")
    public Result<List<MoneyPayVO>> getMoneyPayList(@RequestBody ClientMoneyPayDTO dto){
        QueryMoneyPayDTO queryMoneyPayDTO=new QueryMoneyPayDTO();
        BeanUtils.copyProperties(dto,queryMoneyPayDTO);
        queryMoneyPayDTO.setOperateId(getLoginUser().getUserId());
        queryMoneyPayDTO.setOperateId(1L);
        return moneyPayClient.getMoneyPayList(queryMoneyPayDTO);
    }


    @ApiOperation(value = "查询标段服务费是否支付",tags = "查询标段服务费是否支付")
    @PostMapping(value = "IsPayForServiceMoney", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> IsPayForServiceMoney(@RequestBody ClientMoneyPayRecordDTO dto){
        QueryMoneyPayRecordDTO queryMoneyPayRecordDTO=new QueryMoneyPayRecordDTO();
        BeanUtils.copyProperties(dto,queryMoneyPayRecordDTO);
        return moneyPayClient.IsPayForServiceMoney(queryMoneyPayRecordDTO);
    }


    @ApiOperation(value = "平台插入用户支付记录",tags = "平台插入用户支付记录")
    @PostMapping(value = "insertPurchaseProjectFilePay", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertPurchaseProjectFilePay(@RequestBody ClientFilePay handle){
        HandleFilePay handleFilePay=new HandleFilePay();
        BeanUtils.copyProperties(handle,handleFilePay);
        handleFilePay.setCreator(getLoginUser().getName());
        handle.setOperateId(getLoginUser().getUserId());
        handle.setOperateId(1L);
        return moneyPayClient.insertPurchaseProjectFilePay(handleFilePay);
    }

}
