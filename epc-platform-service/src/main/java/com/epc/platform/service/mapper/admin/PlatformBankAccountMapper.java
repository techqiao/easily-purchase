package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.PlatformBankAccount;
import com.epc.platform.service.domain.admin.PlatformBankAccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PlatformBankAccountMapper {
    int countByExample(PlatformBankAccountCriteria example);

    int deleteByExample(PlatformBankAccountCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PlatformBankAccount record);

    int insertSelective(PlatformBankAccount record);

    List<PlatformBankAccount> selectByExampleWithRowbounds(PlatformBankAccountCriteria example, RowBounds rowBounds);

    List<PlatformBankAccount> selectByExample(PlatformBankAccountCriteria example);

    PlatformBankAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlatformBankAccount record, @Param("example") PlatformBankAccountCriteria example);

    int updateByExample(@Param("record") PlatformBankAccount record, @Param("example") PlatformBankAccountCriteria example);

    int updateByPrimaryKeySelective(PlatformBankAccount record);

    int updateByPrimaryKey(PlatformBankAccount record);
}