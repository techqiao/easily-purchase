package com.epc.platform.service.controller.admin;

import com.epc.administration.facade.admin.PlatformBankAccountService;
import com.epc.administration.facade.admin.dto.QueryBankAccountDTO;
import com.epc.administration.facade.admin.handle.InsertBankAccountHandle;
import com.epc.administration.facade.admin.handle.UpdateBankAccountHandle;
import com.epc.administration.facade.admin.vo.BankAccountVO;
import com.epc.common.Result;
import com.epc.platform.service.domain.admin.PlatformBankAccount;
import com.epc.platform.service.service.admin.BankAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:18
 * <p>@Author : luozhixin
 */
@RestController
public class PlatformBankAccountController extends BaseController implements PlatformBankAccountService {

    @Autowired
    private BankAccountService bankAccountService;

    @Override
    public Result insertBankAccount(@RequestBody InsertBankAccountHandle insertBankAccountHandle) {
        return bankAccountService.insertBankAccount(insertBankAccountHandle);
    }

    @Override
    public Result updateBankAccount(@RequestBody UpdateBankAccountHandle updateBankAccountHandle) {
        return bankAccountService.updateBankAccount(updateBankAccountHandle);
    }

    @Override
    public Result deleteBankAccount(@RequestParam("id") Long id) {
        return bankAccountService.deleteBankAccount(id);
    }

    @Override
    public Result<BankAccountVO> selectBankAccount(@RequestParam("id") Long id) {
        return bankAccountService.selectBankAccount(id);
    }

    @Override
    public Result<Map<String, Object>> selectAllBankAccount(@RequestBody QueryBankAccountDTO queryBankAccountDTO) {
        PageHelper.startPage(queryBankAccountDTO.getPage(),queryBankAccountDTO.getRows());
        Result<List<PlatformBankAccount>> listResult = bankAccountService.selectAllBankAccount(queryBankAccountDTO);
        PageInfo<PlatformBankAccount> pageInfo = new PageInfo<>(listResult.getData());
        return Result.success(getDataTable(pageInfo));
    }
}
