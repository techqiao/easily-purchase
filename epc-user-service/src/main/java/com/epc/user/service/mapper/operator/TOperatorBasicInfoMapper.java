package com.epc.user.service.mapper.operator;

import com.epc.user.service.domain.operator.TOperatorBasicInfo;
import com.epc.user.service.domain.operator.TOperatorBasicInfoCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface TOperatorBasicInfoMapper {

    int countByExample(TOperatorBasicInfoCriteria example);


    int deleteByExample(TOperatorBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorBasicInfo record);

    int insertSelective(TOperatorBasicInfo record);

    List<TOperatorBasicInfo> selectByExampleWithRowbounds(TOperatorBasicInfoCriteria example, RowBounds rowBounds);

    List<TOperatorBasicInfo> selectByExample(TOperatorBasicInfoCriteria example);

    TOperatorBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorBasicInfo record, @Param("example") TOperatorBasicInfoCriteria example);

    int updateByExample(@Param("record") TOperatorBasicInfo record, @Param("example") TOperatorBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TOperatorBasicInfo record);

    int updateByPrimaryKey(TOperatorBasicInfo record);
}