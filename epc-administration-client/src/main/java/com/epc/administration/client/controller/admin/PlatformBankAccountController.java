package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.dto.ClientQueryBankAccountDTO;
import com.epc.administration.client.controller.admin.handle.ClientInsertBankAccountHandle;
import com.epc.administration.client.controller.admin.handle.ClientUpdateBankAccountHandle;
import com.epc.administration.client.controller.common.BaseController;
import com.epc.administration.client.remoteapi.admin.PlatformBankAccountClient;
import com.epc.administration.facade.admin.dto.QueryBankAccountDTO;
import com.epc.administration.facade.admin.handle.InsertBankAccountHandle;
import com.epc.administration.facade.admin.handle.UpdateBankAccountHandle;
import com.epc.administration.facade.admin.vo.BankAccountVO;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:11
 * <p>@Author : luozhixin
 */
@Api(value = "平台设置收款银行账号信息 @罗志鑫",tags = {"平台收款信息服务"})
@RestController
@RequestMapping(value = "PlatformBankAccountController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlatformBankAccountController extends BaseController {

    @Autowired
    private PlatformBankAccountClient platformBankAccountClient;

    @ApiOperation(value = "新增收款账号信息")
    @PostMapping(value ="insertBankAccount",consumes = "application/json;charset=UTF-8")
    public Result insertBankAccount(@RequestBody ClientInsertBankAccountHandle clientInsertBankAccountHandle){
        InsertBankAccountHandle insertBankAccountHandle = new InsertBankAccountHandle();
        BeanUtils.copyProperties(clientInsertBankAccountHandle,insertBankAccountHandle);
        return platformBankAccountClient.insertBankAccount(insertBankAccountHandle);
    }

    @ApiOperation(value = "修改收款账号信息")
    @PostMapping(value ="updateBankAccount",consumes = "application/json;charset=UTF-8")
    public Result updateBankAccount(@RequestBody ClientUpdateBankAccountHandle clientUpdateBankAccountHandle){
        UpdateBankAccountHandle updateBankAccountHandle = new UpdateBankAccountHandle();
        BeanUtils.copyProperties(clientUpdateBankAccountHandle,updateBankAccountHandle);
        return platformBankAccountClient.updateBankAccount(updateBankAccountHandle);
    }

    @ApiOperation(value = "删除收款账号信息")
    @GetMapping(value ="deleteBankAccount")
    public Result deleteBankAccount(@RequestParam("id")Long id){
        return platformBankAccountClient.deleteBankAccount(id);
    }

    @ApiOperation(value = "查询收款账号信息")
    @GetMapping(value ="selectBankAccount")
    public Result<BankAccountVO> selectBankAccount(@RequestParam("id")Long id){
        return platformBankAccountClient.selectBankAccount(id);
    }

    @ApiOperation(value = "查询收款账号信息列表")
    @PostMapping(value ="selectAllBankAccount",consumes = "application/json;charset=UTF-8")
    public Result<Map<String, Object>> selectAllBankAccount(@RequestBody ClientQueryBankAccountDTO clientQueryBankAccountDTO){
        QueryBankAccountDTO queryBankAccountDTO = new QueryBankAccountDTO();
        BeanUtils.copyProperties(clientQueryBankAccountDTO,queryBankAccountDTO);
        return platformBankAccountClient.selectAllBankAccount(queryBankAccountDTO);
    }
}
