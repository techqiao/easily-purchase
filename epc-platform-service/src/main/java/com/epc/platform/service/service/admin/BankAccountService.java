package com.epc.platform.service.service.admin;

import com.epc.administration.facade.admin.dto.QueryBankAccountDTO;
import com.epc.administration.facade.admin.handle.InsertBankAccountHandle;
import com.epc.administration.facade.admin.handle.UpdateBankAccountHandle;
import com.epc.administration.facade.admin.vo.BankAccountVO;
import com.epc.common.Result;
import com.epc.platform.service.domain.admin.PlatformBankAccount;

import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 14:04
 * <p>@Author : luozhixin
 */
public interface BankAccountService {

    /**
     * 新增收款账号信息
     * @param insertBankAccountHandle
     * @return
     */
    Result insertBankAccount( InsertBankAccountHandle insertBankAccountHandle);

    /**
     * 修改收款账号信息
     * @param updateBankAccountHandle
     * @return
     */
    Result updateBankAccount( UpdateBankAccountHandle updateBankAccountHandle);

    /**
     * 删除收款账号信息
     * @param id
     * @return
     */
    Result deleteBankAccount(Long id);

    /**
     * 查询收款账号信息
     * @param id
     * @return
     */
    Result<BankAccountVO> selectBankAccount(Long id);

    /**
     * 查询收款账号信息列表
     * @param queryBankAccountDTO
     * @return
     */
    Result<List<PlatformBankAccount>> selectAllBankAccount(QueryBankAccountDTO queryBankAccountDTO);
}
