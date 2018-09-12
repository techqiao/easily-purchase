package com.epc.user.service.mapper.operator;

import com.epc.user.service.domain.operator.TOperatorUser;
import com.epc.user.service.domain.operator.TOperatorUserCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface TOperatorUserMapper {

    int countByExample(TOperatorUserCriteria example);

    int deleteByExample(TOperatorUserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorUser record);

    int insertSelective(TOperatorUser record);

    List<TOperatorUser> selectByExampleWithRowbounds(TOperatorUserCriteria example, RowBounds rowBounds);

    List<TOperatorUser> selectByExample(TOperatorUserCriteria example);

    TOperatorUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorUser record, @Param("example") TOperatorUserCriteria example);

    int updateByExample(@Param("record") TOperatorUser record, @Param("example") TOperatorUserCriteria example);

    int updateByPrimaryKeySelective(TOperatorUser record);

    int updateByPrimaryKey(TOperatorUser record);
}