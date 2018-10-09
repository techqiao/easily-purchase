package com.epc.platform.service.service.admin.impl;
import java.util.Date;

import com.epc.administration.facade.admin.dto.QueryBankAccountDTO;
import com.epc.administration.facade.admin.handle.InsertBankAccountHandle;
import com.epc.administration.facade.admin.handle.UpdateBankAccountHandle;
import com.epc.administration.facade.admin.vo.BankAccountVO;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.platform.service.domain.admin.PlatformBankAccount;
import com.epc.platform.service.domain.admin.PlatformBankAccountCriteria;
import com.epc.platform.service.mapper.admin.PlatformBankAccountMapper;
import com.epc.platform.service.service.admin.BankAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 14:06
 * <p>@Author : luozhixin
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private PlatformBankAccountMapper platformBankAccountMapper;

    @Override
    public Result insertBankAccount(InsertBankAccountHandle insertBankAccountHandle){
        Date date = new Date();
        PlatformBankAccount platformBankAccount = new PlatformBankAccount();
        BeanUtils.copyProperties(insertBankAccountHandle,platformBankAccount);
        platformBankAccount.setCreateAt(date);
        platformBankAccount.setUpdateAt(date);
        platformBankAccount.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        return Result.success(platformBankAccountMapper.insertSelective(platformBankAccount)>0);
    }

    @Override
    public Result updateBankAccount(UpdateBankAccountHandle updateBankAccountHandle){
        Date date = new Date();
        PlatformBankAccount platformBankAccount = new PlatformBankAccount();
        BeanUtils.copyProperties(updateBankAccountHandle,platformBankAccount);
        platformBankAccount.setUpdateAt(date);
        platformBankAccount.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        return Result.success(platformBankAccountMapper.updateByPrimaryKeySelective(platformBankAccount)>0);
    }

    @Override
    public Result deleteBankAccount(Long id){
        PlatformBankAccount platformBankAccount = new PlatformBankAccount();
        platformBankAccount.setId(id);
        platformBankAccount.setUpdateAt(new Date());
        platformBankAccount.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        return Result.success(platformBankAccountMapper.updateByPrimaryKeySelective(platformBankAccount)>0);
    }

    @Override
    public Result<BankAccountVO> selectBankAccount(Long id) {
        PlatformBankAccount platformBankAccount = platformBankAccountMapper.selectByPrimaryKey(id);
        BankAccountVO bankAccountVO =new BankAccountVO();
        bankAccountVO.setId(platformBankAccount.getId());
        bankAccountVO.setProceedsUnit(platformBankAccount.getProceedsUnit());
        bankAccountVO.setBankOfDeposit(platformBankAccount.getBankOfDeposit());
        bankAccountVO.setShroffAccountNumber(platformBankAccount.getShroffAccountNumber());
        bankAccountVO.setWholesaleLineNumber(platformBankAccount.getWholesaleLineNumber());
        bankAccountVO.setPaymentType(platformBankAccount.getPaymentType());
        return Result.success(bankAccountVO);
    }

    @Override
    public Result<List<PlatformBankAccount>> selectAllBankAccount(QueryBankAccountDTO queryBankAccountDTO){
        PlatformBankAccountCriteria platformBankAccountCriteria = new PlatformBankAccountCriteria();
        platformBankAccountCriteria.setOrderByClause("id desc");
        PlatformBankAccountCriteria.Criteria subCriteria = platformBankAccountCriteria.createCriteria();
        if(StringUtils.isNotBlank(queryBankAccountDTO.getType().toString())){
            subCriteria.andPaymentTypeEqualTo(queryBankAccountDTO.getType());
        }
        if(StringUtils.isNotBlank(queryBankAccountDTO.getBankOfDeposit())){
            subCriteria.andBankOfDepositEqualTo(queryBankAccountDTO.getBankOfDeposit());
        }
        List<PlatformBankAccount> platformBankAccounts = platformBankAccountMapper.selectByExample(platformBankAccountCriteria);
        return Result.success(platformBankAccounts);
    }




}
