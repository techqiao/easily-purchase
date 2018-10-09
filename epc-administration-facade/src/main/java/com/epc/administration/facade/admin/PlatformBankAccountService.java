package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.dto.QueryBankAccountDTO;
import com.epc.administration.facade.admin.handle.InsertBankAccountHandle;
import com.epc.administration.facade.admin.handle.UpdateBankAccountHandle;
import com.epc.administration.facade.admin.vo.BankAccountVO;
import com.epc.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:16
 * <p>@Author : luozhixin
 */
public interface PlatformBankAccountService {

    /**
     * 新增收款账号信息
     * @param insertBankAccountHandle
     * @return
     */
    @ApiOperation(value = "新增收款账号信息")
    @PostMapping(value ="insertBankAccount",consumes = "application/json;charset=UTF-8")
     Result insertBankAccount(@RequestBody InsertBankAccountHandle insertBankAccountHandle);

    /**
     * 修改收款账号信息
     * @param updateBankAccountHandle
     * @return
     */
    @ApiOperation(value = "修改收款账号信息")
    @PostMapping(value ="updateBankAccount",consumes = "application/json;charset=UTF-8")
     Result updateBankAccount(@RequestBody UpdateBankAccountHandle updateBankAccountHandle);

    /**
     * 删除收款账号信息
     * @param id
     * @return
     */
    @ApiOperation(value = "删除收款账号信息")
    @GetMapping(value ="deleteBankAccount")
     Result deleteBankAccount(@RequestParam("id")Long id);

    /**
     * 查询收款账号信息
     * @param id
     * @return
     */
    @ApiOperation(value = "查询收款账号信息")
    @GetMapping(value ="selectBankAccount")
     Result<BankAccountVO> selectBankAccount(@RequestParam("id")Long id);

    /**
     * 查询收款账号信息列表
     * @param queryBankAccountDTO
     * @return
     */
    @ApiOperation(value = "查询收款账号信息列表")
    @PostMapping(value ="selectAllBankAccount",consumes = "application/json;charset=UTF-8")
     Result<Map<String, Object>> selectAllBankAccount(@RequestBody QueryBankAccountDTO queryBankAccountDTO);
}
