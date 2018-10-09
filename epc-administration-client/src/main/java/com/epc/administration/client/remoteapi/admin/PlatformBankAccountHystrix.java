package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.PlatformBankAccountService;
import com.epc.administration.facade.admin.dto.QueryBankAccountDTO;
import com.epc.administration.facade.admin.handle.InsertBankAccountHandle;
import com.epc.administration.facade.admin.handle.UpdateBankAccountHandle;
import com.epc.common.Result;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:16
 * <p>@Author : luozhixin
 */
public class PlatformBankAccountHystrix implements PlatformBankAccountService {

    @Override
    public Result insertBankAccount(InsertBankAccountHandle clientInsertBankAccountHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result updateBankAccount(UpdateBankAccountHandle clientUpdateBankAccountHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result deleteBankAccount(Long id) {
        return Result.hystrixError();
    }

    @Override
    public Result selectBankAccount(Long id) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAllBankAccount(QueryBankAccountDTO clientQueryBankAccountDTO) {
        return Result.hystrixError();
    }
}
