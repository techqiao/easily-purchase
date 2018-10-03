package com.epc.platform.service.mapper.operator;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.vo.OperatorVO;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.domain.operator.TOperatorDetailInfoCriteria;
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

    /**
     * 根据名称查询
     * @param companyName
     * @return
     */
    List<TOperatorDetailInfo> selectByName(String companyName);

    /**
     * 可以传入状态值 和公司名
     * 分页查询
     * @return
     */
    List<OperatorVO> selectByPage(QueryDetailIfo queryDetailIfo);
}