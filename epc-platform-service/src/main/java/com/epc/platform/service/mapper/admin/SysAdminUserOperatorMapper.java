package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminUserOperator;
import com.epc.platform.service.domain.admin.SysAdminUserOperatorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminUserOperatorMapper {
    int countByExample(SysAdminUserOperatorCriteria example);

    int deleteByExample(SysAdminUserOperatorCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminUserOperator record);

    int insertSelective(SysAdminUserOperator record);

    List<SysAdminUserOperator> selectByExampleWithRowbounds(SysAdminUserOperatorCriteria example, RowBounds rowBounds);

    List<SysAdminUserOperator> selectByExample(SysAdminUserOperatorCriteria example);

    SysAdminUserOperator selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminUserOperator record, @Param("example") SysAdminUserOperatorCriteria example);

    int updateByExample(@Param("record") SysAdminUserOperator record, @Param("example") SysAdminUserOperatorCriteria example);

    int updateByPrimaryKeySelective(SysAdminUserOperator record);

    int updateByPrimaryKey(SysAdminUserOperator record);
}