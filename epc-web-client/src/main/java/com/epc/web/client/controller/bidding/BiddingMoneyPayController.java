package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.moneyPay.ClientFilePay;
import com.epc.web.client.controller.bidding.query.moneyPay.ClientMoneyPayDTO;
import com.epc.web.client.controller.bidding.query.moneyPay.ClientMoneyPayForAllDTO;
import com.epc.web.client.controller.bidding.query.moneyPay.ClientMoneyPayRecordDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.moneyPay.MoneyPayClient;
import com.epc.web.client.remoteApi.enrolmentinvitation.EnrolmentInvitationClient;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.query.moneyPay.ServiceMoneyListForAllDTO;
import com.epc.web.facade.bidding.vo.*;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.query.PayForGuarantyDTO;
import com.epc.web.facade.enrolmentinvitation.vo.BSignUpVO;
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
    @Autowired
    EnrolmentInvitationClient enrolmentInvitationClient;

    @ApiOperation(value = "获取保证金支付列表",tags = "获取保证金支付列表")
    @PostMapping(value = "getGuarantyPayList", consumes = "application/json; charset=UTF-8")
    public Result<List<MoneyPayVO>> getGuarantyPayList(@RequestBody ClientMoneyPayDTO dto){
        QueryMoneyPayDTO queryMoneyPayDTO=new QueryMoneyPayDTO();
        BeanUtils.copyProperties(dto,queryMoneyPayDTO);
        queryMoneyPayDTO.setOperateId(getLoginUser().getUserId());
        queryMoneyPayDTO.setCompanyId(getLoginUser().getBossId());
        return moneyPayClient.getMoneyPayList(queryMoneyPayDTO);
    }

    @ApiOperation(value = "获取保证金支付列表(角色缴费记录列表)",tags = "获取保证金支付列表(角色缴费记录列表)")
    @PostMapping(value = "getGuarantyPayListForAll", consumes = "application/json; charset=UTF-8")
    public Result<List<PayListForAllVO>> getGuarantyPayListForAll(@RequestBody ClientMoneyPayForAllDTO dto){
        InvitationForSupplierDTO invitationForSupplierDTO=new InvitationForSupplierDTO();
        invitationForSupplierDTO.setSupplierId(getLoginUser().getBossId());
        invitationForSupplierDTO.setSupplierName(getLoginUser().getBossName());
        Result<List<BSignUpVO>> result=enrolmentInvitationClient.queryInvitationList(invitationForSupplierDTO);
        List<BSignUpVO> list=result.getData();
        PayForGuarantyDTO payForGuarantyDTO=new PayForGuarantyDTO();
        if(list.size()==0){
            return Result.success(null);
        }else{
            payForGuarantyDTO.setList(list);
            if(dto.getPayStatus()!=null){
                payForGuarantyDTO.setPayStatus(dto.getPayStatus());
            }
            if(dto.getProjectName()!=null){
                payForGuarantyDTO.setProjectName(dto.getProjectName());
            }
            if(dto.getProjectStatus()!=null){
                payForGuarantyDTO.setProjectStatus(dto.getProjectStatus());
            }
           return enrolmentInvitationClient.isPayForGuaranty(payForGuarantyDTO);
        }
    }

    @ApiOperation(value = "查询中标服务费支付列表",tags = "查询中标服务费支付列表")
    @PostMapping(value = "getServiceMoneyList", consumes = "application/json; charset=UTF-8")
    public Result<List<ServicePayVO>> getServiceMoneyList(@RequestBody ClientMoneyPayRecordDTO dto){
        QueryMoneyPayRecordDTO queryMoneyPayRecordDTO=new QueryMoneyPayRecordDTO();
        BeanUtils.copyProperties(dto,queryMoneyPayRecordDTO);
        queryMoneyPayRecordDTO.setOperaterId(getLoginUser().getUserId());
        queryMoneyPayRecordDTO.setOperaterName(getLoginUser().getName());
        queryMoneyPayRecordDTO.setCompanyId(getLoginUser().getBossId());
        return moneyPayClient.IsPayForServiceMoney(queryMoneyPayRecordDTO);
    }

    @ApiOperation(value = "获取中标服务费支付列表(角色缴费记录列表)",tags = "获取中标服务费支付列表(角色缴费记录列表)")
    @PostMapping(value = "getServiceMoneyListForAll", consumes = "application/json; charset=UTF-8")
    public Result<List<PayListForAllVO>> getServiceMoneyListForAll(@RequestBody ClientMoneyPayForAllDTO dto){
        ServiceMoneyListForAllDTO serviceMoneyListForAllDto=new ServiceMoneyListForAllDTO();
        BeanUtils.copyProperties(dto,serviceMoneyListForAllDto);
        serviceMoneyListForAllDto.setCompanyId(getLoginUser().getBossId());
        return moneyPayClient.getServiceMoneyListForAll(serviceMoneyListForAllDto);
    }

    @ApiOperation(value = "投标保证金退还列表",tags = "投标保证金退还列表")
    @PostMapping(value = "getGuarantyBackPayList", consumes = "application/json; charset=UTF-8")
    public Result<List<ServiceBackVO>> getGuarantyBackPayList(@RequestBody ClientMoneyPayRecordDTO dto){
        QueryMoneyPayRecordDTO queryMoneyPayRecordDTO=new QueryMoneyPayRecordDTO();
        BeanUtils.copyProperties(dto,queryMoneyPayRecordDTO);
        queryMoneyPayRecordDTO.setOperaterId(getLoginUser().getUserId());
        queryMoneyPayRecordDTO.setOperaterName(getLoginUser().getName());
        queryMoneyPayRecordDTO.setCompanyId(getLoginUser().getBossId());
        return moneyPayClient.getGuarantyBackPayList(queryMoneyPayRecordDTO);

    }


    @ApiOperation(value = "平台插入用户支付记录",tags = "平台插入用户支付记录")
    @PostMapping(value = "insertPurchaseProjectFilePay", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertPurchaseProjectFilePay(@RequestBody ClientFilePay handle){
        HandleFilePay handleFilePay=new HandleFilePay();
        BeanUtils.copyProperties(handle,handleFilePay);
        handleFilePay.setCreator(getLoginUser().getName());
        handleFilePay.setOperateId(getLoginUser().getUserId());
        return moneyPayClient.insertPurchaseProjectFilePay(handleFilePay);
    }

}
