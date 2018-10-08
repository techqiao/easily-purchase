package com.epc.web.service.mapper.operator;

import com.epc.web.service.domain.operator.TOperatorDetailInfo;
import com.epc.web.service.domain.operator.TOperatorDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOperatorDetailInfoMapper {
    int countByExample(TOperatorDetailInfoCriteria example);

    int deleteByExample(TOperatorDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorDetailInfo record);

    int insertSelective(TOperatorDetailInfo record);

    List<TOperatorDetailInfo> selectByExampleWithRowbounds(TOperatorDetailInfoCriteria example, RowBounds rowBounds);

    List<TOperatorDetailInfo> selectByExample(TOperatorDetailInfoCriteria example);

    TOperatorDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorDetailInfo record, @Param("example") TOperatorDetailInfoCriteria example);

    int updateByExample(@Param("record") TOperatorDetailInfo record, @Param("example") TOperatorDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TOperatorDetailInfo record);

    int updateByPrimaryKey(TOperatorDetailInfo record);




    /*wenlin*/
    TOperatorDetailInfo selectOperatorDetailByOperatorId(Long operatorId);
}