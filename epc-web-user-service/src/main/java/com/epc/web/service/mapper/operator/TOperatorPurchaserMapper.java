package com.epc.web.service.mapper.operator;

import com.epc.web.service.domain.operator.TOperatorPurchaser;
import com.epc.web.service.domain.operator.TOperatorPurchaserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOperatorPurchaserMapper {
    int countByExample(TOperatorPurchaserCriteria example);

    int deleteByExample(TOperatorPurchaserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorPurchaser record);

    int insertSelective(TOperatorPurchaser record);

    List<TOperatorPurchaser> selectByExampleWithRowbounds(TOperatorPurchaserCriteria example, RowBounds rowBounds);

    List<TOperatorPurchaser> selectByExample(TOperatorPurchaserCriteria example);

    TOperatorPurchaser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorPurchaser record, @Param("example") TOperatorPurchaserCriteria example);

    int updateByExample(@Param("record") TOperatorPurchaser record, @Param("example") TOperatorPurchaserCriteria example);

    int updateByPrimaryKeySelective(TOperatorPurchaser record);

    int updateByPrimaryKey(TOperatorPurchaser record);
}