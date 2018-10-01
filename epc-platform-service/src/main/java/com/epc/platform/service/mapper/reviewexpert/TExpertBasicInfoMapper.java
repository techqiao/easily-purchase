package com.epc.platform.service.mapper.reviewexpert;

import com.epc.platform.service.domain.expert.TExpertBasicInfo;
import com.epc.platform.service.domain.expert.TExpertBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TExpertBasicInfoMapper {
    int countByExample(TExpertBasicInfoCriteria example);

    int deleteByExample(TExpertBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TExpertBasicInfo record);

    int insertSelective(TExpertBasicInfo record);

    List<TExpertBasicInfo> selectByExampleWithRowbounds(TExpertBasicInfoCriteria example, RowBounds rowBounds);

    List<TExpertBasicInfo> selectByExample(TExpertBasicInfoCriteria example);

    TExpertBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TExpertBasicInfo record, @Param("example") TExpertBasicInfoCriteria example);

    int updateByExample(@Param("record") TExpertBasicInfo record, @Param("example") TExpertBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TExpertBasicInfo record);

    int updateByPrimaryKey(TExpertBasicInfo record);
}