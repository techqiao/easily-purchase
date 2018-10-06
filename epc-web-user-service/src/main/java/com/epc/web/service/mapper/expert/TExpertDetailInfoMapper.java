package com.epc.web.service.mapper.expert;

import com.epc.web.service.domain.expert.TExpertDetailInfo;
import com.epc.web.service.domain.expert.TExpertDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TExpertDetailInfoMapper {
    int countByExample(TExpertDetailInfoCriteria example);

    int deleteByExample(TExpertDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TExpertDetailInfo record);

    int insertSelective(TExpertDetailInfo record);

    List<TExpertDetailInfo> selectByExampleWithRowbounds(TExpertDetailInfoCriteria example, RowBounds rowBounds);

    List<TExpertDetailInfo> selectByExample(TExpertDetailInfoCriteria example);

    TExpertDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TExpertDetailInfo record, @Param("example") TExpertDetailInfoCriteria example);

    int updateByExample(@Param("record") TExpertDetailInfo record, @Param("example") TExpertDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TExpertDetailInfo record);

    int updateByPrimaryKey(TExpertDetailInfo record);
}